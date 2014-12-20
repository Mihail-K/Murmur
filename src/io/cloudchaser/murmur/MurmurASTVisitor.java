/*
 *	The MIT License (MIT)
 *
 *	Copyright (c) 2014 Mihail K
 *
 *	Permission is hereby granted, free of charge, to any person obtaining a copy
 *	of this software and associated documentation files (the "Software"), to deal
 *	in the Software without restriction, including without limitation the rights
 *	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *	copies of the Software, and to permit persons to whom the Software is
 *	furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all
 *	copies or substantial portions of the Software.
 *
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *	SOFTWARE.
 */

package io.cloudchaser.murmur;

import io.cloudchaser.murmur.parser.MurmurParser;
import io.cloudchaser.murmur.parser.MurmurParserBaseVisitor;
import io.cloudchaser.murmur.types.MurmurVariable;
import io.cloudchaser.murmur.types.SymbolContext;
import io.cloudchaser.murmur.types.InvocationDelegate;
import io.cloudchaser.murmur.types.InvokableType;
import io.cloudchaser.murmur.types.java.JavaClass;
import io.cloudchaser.murmur.types.java.JavaInvokableType;
import io.cloudchaser.murmur.types.MurmurArray;
import io.cloudchaser.murmur.types.MurmurBoolean;
import io.cloudchaser.murmur.types.MurmurCharacter;
import io.cloudchaser.murmur.types.MurmurComponent;
import io.cloudchaser.murmur.types.MurmurDecimal;
import io.cloudchaser.murmur.types.MurmurField;
import io.cloudchaser.murmur.types.MurmurInstance;
import io.cloudchaser.murmur.types.MurmurInteger;
import io.cloudchaser.murmur.types.MurmurLambda;
import io.cloudchaser.murmur.types.MurmurMember;
import io.cloudchaser.murmur.types.MurmurMethod;
import io.cloudchaser.murmur.types.MurmurNull;
import io.cloudchaser.murmur.types.MurmurObject;
import io.cloudchaser.murmur.types.MurmurReturn;
import io.cloudchaser.murmur.types.MurmurString;
import io.cloudchaser.murmur.types.MurmurSymbol;
import io.cloudchaser.murmur.types.MurmurVoid;
import io.cloudchaser.murmur.types.ReferenceType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurASTVisitor
		extends MurmurParserBaseVisitor {
	
	/**
	 * The context stack.
	 */
	private final Deque<SymbolContext> context =
			new LinkedList<>();
	
	/**
	 * The call stack (for error output).
	 */
	private final Deque<InvokableType> callStack =
			new LinkedList<>();
	
	/**
	 * The interpreter invocation delegate.
	 */
	private final InvocationDelegate delegate =
	(local, lambda) -> {
		try {
			// Step into the local context.
			context.push(local);
			callStack.push(lambda);
			
			// Execute the function.
			MurmurObject result = visitBlock(lambda.getBody());

			// Step out of the context.
			callStack.pop();
			context.pop();
			return result;
		} catch(MurmurError err) {
			// Attach call stack to error.
			err.setCallStack(callStack);
			throw err;
		}
	};
	
	/**
	 * Removes symbol binding from a murmur value, if present.
	 * 
	 * @param object The object to de-symbolize.
	 * @return A murmur object.
	 */
	private static MurmurObject desymbolize(MurmurObject object) {
		return object instanceof MurmurSymbol ? ((MurmurSymbol)object).getValue() : object;
	}
	
	/**
	 * Tries to get a more 'visible' view of the given parser rule.
	 * 
	 * @param rule The parser rule being viewed.
	 * @return A visible view of the rule.
	 */
	public static ParserRuleContext getVisibleView(ParserRuleContext rule) {
		if(rule instanceof MurmurParser.IdentifierListContext ||
				rule instanceof MurmurParser.InitializerListContext ||
				rule instanceof MurmurParser.ExpressionListContext) {
			return (ParserRuleContext)rule.parent;
		}
		
		// This one will do file.
		return rule;
	}
	
	/**
	 * Fetches a string with the original formatting of a context.
	 * 
	 * @param rule The rule to fetch the String for.
	 * @return A String of a rule, as it appears in the source.
	 */
	private static String getOriginalText(ParserRuleContext rule) {
		int start = rule.start.getStartIndex();
		int stop = rule.stop.getStopIndex();
		Interval interval = new Interval(start, stop);
		return rule.start.getInputStream().getText(interval);
	}

	@Override
	public MurmurObject visitCompilationUnit(MurmurParser.CompilationUnitContext ctx) {
		// Push initial context.
		context.push(new MurmurBaseContext());
		
		// Visit children.
		ctx.statement().stream().forEach(this::visitStatement);
		
		// Pop initial context.
		context.pop();
		return null;
	}

	@Override
	public MurmurObject visitStatement(MurmurParser.StatementContext ctx) {
		if(ctx.keywordStatement() != null) {
			return visitKeywordStatement(ctx.keywordStatement());
		} else if(ctx.typeStatement() != null) {
			return visitTypeStatement(ctx.typeStatement());
		} else {
			return visitExpression(ctx.expression());
		}
	}
	
	/* - Statements  - */
	/* - - - - - - - - */
	
	public MurmurObject visitLeftArrowStatement(MurmurParser.KeywordStatementContext ctx) {
		// Get the current instance context.
		MurmurSymbol symbol = context.peek().getSymbol("this");
		MurmurInstance instance = (MurmurInstance)symbol.getValue();
		
		ctx.identifierList().Identifier()
				.stream().forEach((identifier) -> {
			String name = identifier.getText();
			MurmurObject target = instance.getMember(name);
			MurmurSymbol source = context.peek().getLocal(name);
			
			// Check that the symbol exists.
			if(source == null || target == null ||
					!(target instanceof MurmurSymbol)) {
				throw MurmurError.create(ctx.start.getLine(),
						getOriginalText(ctx) + "\t(Not found: " + name + ")",
						MurmurError.SYMBOL_NOT_FOUND);
			}
			
			// Bind the symbol, by name.
			((MurmurSymbol)target).setValue(source.getValue());
		});
		
		// Return void value.
		return MurmurVoid.VOID;
	}
	
	public MurmurObject visitRightArrowStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitBreakStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitContinueStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitLetInitializerList(MurmurParser.InitializerListContext ctx) {
		ctx.initializerElement().stream().forEach((element) -> {
			String name = element.Identifier().getText();
			MurmurObject value = desymbolize(visitExpression(element.expression()));
			
			// Check that the value exists.
			if(value == null) {
				value = MurmurVoid.VOID;
			}
			
			// Create a symbol entry.
			context.peek().addSymbol(new MurmurVariable(name, value));
		});
		
		// Return void value.
		return MurmurVoid.VOID;
	}
	
	public MurmurObject visitLetStatement(MurmurParser.KeywordStatementContext ctx) {
		// Let with an initializer list.
		if(ctx.initializerList() != null) {
			return visitLetInitializerList(ctx.initializerList());
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject visitReturnStatement(MurmurParser.KeywordStatementContext ctx) {
		// Wrap return value.
		MurmurObject value = visitExpression(ctx.expression());
		return new MurmurReturn(desymbolize(value));
	}
	
	public MurmurObject visitThrowStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	@Override
	public MurmurObject visitKeywordStatement(MurmurParser.KeywordStatementContext ctx) {
		if(ctx.operator != null) {
			// Keyword/operator.
			switch(ctx.operator.getText()) {
				case "<-":
					return visitLeftArrowStatement(ctx);
				case "->":
					return visitRightArrowStatement(ctx);
				case "break":
					return visitBreakStatement(ctx);
				case "continue":
					return visitContinueStatement(ctx);
				case "let":
					return visitLetStatement(ctx);
				case "return":
					return visitReturnStatement(ctx);
				case "throw":
					return visitThrowStatement(ctx);
				default:
					// Unknown operation.
					throw new UnsupportedOperationException();
			}
		}
		
		// Something went wrong.
		throw MurmurError.create(ctx.start.getLine(),
				ctx.getText(), MurmurError.INTERNAL_ERROR);
	}
	
	/* - Interfaces  - */
	/* - - - - - - - - */
	
	public MurmurObject visitITypeFunction(MurmurParser.ITypeElementContext ctx) {
		// TODO
		return null;
	}

	@Override
	public MurmurObject visitITypeElement(MurmurParser.ITypeElementContext ctx) {
		// TODO
		return null;
	}
	
	/* - Component Types - */
	/* - - - - - - - - - - */
	
	@Override
	public MurmurMember visitTypeElement(MurmurParser.TypeElementContext ctx) {
		String name = ctx.name.getText();
		MurmurObject value = visitExpression(ctx.expression());
		
		// Determine the element type.
		if(ctx.expression() == null) {
			// Validate field name.
			if(name.equals("this")) {
				throw MurmurError.create(ctx.start.getLine(),
						ctx.getText(), MurmurError.NOT_A_FUNCTION);
			}

			// Create the field.
			return new MurmurField(name);
		} else {
			// Adjust names.
			if(name.equals("this")) {
				name = "~ctor";
			}

			// Check that this is a function.
			if(!(value instanceof MurmurLambda)) {
				throw MurmurError.create(ctx.start.getLine(),
						ctx.getText(), MurmurError.NOT_A_FUNCTION);
			}

			// Create the function.
			MurmurLambda function = (MurmurLambda)value;
			return new MurmurMethod(name, function);
		}
	}

	@Override
	public MurmurObject visitTypeDeclaration(MurmurParser.TypeDeclarationContext ctx) {
		// Create a local component type.
		MurmurComponent component = new MurmurComponent(
				 "<local>", ctx.start.getLine(), context.peek());
		
		// Build component members list.
		if(ctx.typeElement() != null) {
			ctx.typeElement().stream().forEach((element) -> {
				MurmurMember member = visitTypeElement(element);
				component.addMember(member);
			});
		}
		
		// Return the component.
		return component;
	}
	
	public List<MurmurComponent> visitTypeParents(MurmurParser.TypeStatementContext ctx) {
		if(ctx.parents == null) return new ArrayList<>();
		
		List<MurmurComponent> types = new ArrayList<>();
		ctx.parents.stream().forEach((identifier) -> {
			// Resolve component type name.
			MurmurSymbol symbol = context.peek().getSymbol(identifier.getText());
			
			// Check that the type exists.
			if(symbol == null) {
				throw MurmurError.create(ctx.start.getLine(),
						identifier.getText(), MurmurError.SYMBOL_NOT_FOUND);
			}
			
			// Check that this is a component type.
			MurmurObject object = symbol.getValue();
			if(object instanceof MurmurComponent) {
				throw new UnsupportedOperationException();
			}
			
			// Add it to the list.
			types.add((MurmurComponent)object);
		});
		
		return types;
	}
	
	@Override
	public MurmurObject visitTypeStatement(MurmurParser.TypeStatementContext ctx) {
		String name = ctx.name.getText();
		
		// Visit parent and local types.
		List<MurmurComponent> types = visitTypeParents(ctx);
		types.add((MurmurComponent)visitTypeDeclaration(ctx.typeDeclaration()));
		
		// Build the finished Murmur component object.
		MurmurObject component = new MurmurComponent(
				name, ctx.start.getLine(), context.peek(), types);
		context.peek().addSymbol(new MurmurVariable(name, component));
		
		// Return void value.
		return MurmurVoid.VOID;
	}
	
	/* - Expressions - */
	/* - - - - - - - - */
	
	public MurmurObject visitPositiveExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject right = visitExpression(ctx.right);
		return right.opPositive();
	}
	
	public MurmurObject visitPreIncrementExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject right = visitExpression(ctx.right);
		
		// Must be a symbol to increment.
		if(!(right instanceof MurmurSymbol)) {
			throw new UnsupportedOperationException();
		}
		
		// Increment and return value.
		MurmurSymbol symbol = (MurmurSymbol)right;
		symbol.setValue(right.opIncrement());
		return symbol.getValue();
	}
	
	public MurmurObject visitPostIncrementExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		
		// Must be a symbol to increment.
		if(!(left instanceof MurmurSymbol)) {
			throw new UnsupportedOperationException();
		}
		
		// Increment and return old value.
		MurmurSymbol symbol = (MurmurSymbol)left;
		MurmurObject old = symbol.getValue();
		symbol.setValue(left.opIncrement());
		return old;
	}
	
	public MurmurObject visitAdditionExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opPlus(desymbolize(right));
	}
	
	public MurmurObject visitNegativeExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject right = visitExpression(ctx.right);
		return right.opNegative();
	}
	
	public MurmurObject visitPreDecrementExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject right = visitExpression(ctx.right);
		
		// Must be a symbol to decrement.
		if(!(right instanceof MurmurSymbol)) {
			throw new UnsupportedOperationException();
		}
		
		// Decrement and return value.
		MurmurSymbol symbol = (MurmurSymbol)right;
		symbol.setValue(right.opDecrement());
		return symbol.getValue();
	}
	
	public MurmurObject visitPostDecrementExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		
		// Must be a symbol to decrement.
		if(!(left instanceof MurmurSymbol)) {
			throw new UnsupportedOperationException();
		}
		
		// Decrement and return old value.
		MurmurSymbol symbol = (MurmurSymbol)left;
		MurmurObject old = symbol.getValue();
		symbol.setValue(left.opDecrement());
		return old;
	}
	
	public MurmurObject visitSubtractionExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opMinus(desymbolize(right));
	}
	
	public MurmurObject visitMultiplicationExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opMultiply(desymbolize(right));
	}
	
	public MurmurObject visitDivisionExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opDivide(desymbolize(right));
	}
	
	public MurmurObject visitModuloExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opModulo(desymbolize(right));
	}
	
	public MurmurObject visitEqualExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opEquals(desymbolize(right));
	}
	
	public MurmurObject visitNotEqualExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opNotEquals(desymbolize(right));
	}
	
	public MurmurObject visitLogicalNotExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject right = visitExpression(ctx.right);
		return right.opLogicalNot();
	}
	
	public MurmurObject visitLogicalAndExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opLogicalAnd(desymbolize(right));
	}
	
	public MurmurObject visitLogicalOrExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opLogicalOr(desymbolize(right));
	}
	
	public MurmurObject visitBinaryNotExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject right = visitExpression(ctx.right);
		return right.opBitNot();
	}
	
	public MurmurObject visitBinaryAndExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opBitAnd(desymbolize(right));
	}
	
	public MurmurObject visitBinaryXorExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opBitXor(desymbolize(right));
	}
	
	public MurmurObject visitBinaryOrExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opBitOr(desymbolize(right));
	}
	
	public MurmurObject visitLessThanExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opLessThan(desymbolize(right));
	}
	
	public MurmurObject visitGreaterThanExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opGreaterThan(desymbolize(right));
	}
	
	public MurmurObject visitLessOrEqualExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opLessOrEqual(desymbolize(right));
	}
	
	public MurmurObject visitGreaterOrEqualExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opGreaterOrEqual(desymbolize(right));
	}
	
	public MurmurObject visitShiftLeftExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opShiftLeft(desymbolize(right));
	}
	
	public MurmurObject visitShiftRightExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opShiftRight(desymbolize(right));
	}
	
	public MurmurObject visitTernaryExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject clause = desymbolize(visitExpression(ctx.clause));
		
		// Check that the clause is boolean.
		if(!(clause instanceof MurmurBoolean)) {
			throw MurmurError.create(ctx.start.getLine(),
					getOriginalText(ctx), MurmurError.NOT_A_BOOLEAN);
		}
		
		// Check the clause.
		if(((MurmurBoolean)clause).getValue()) {
			// True; evaluate left.
			if(ctx.left != null) {
				return visitExpression(ctx.left);
			} else {
				return visitStatement(ctx.statement(0));
			}
		} else {
			// False; evaluate right.
			if(ctx.right != null) {
				return visitExpression(ctx.right);
			} else if(ctx.statement().size() == 2) {
				return visitStatement(ctx.statement(1));
			} else {
				return MurmurVoid.VOID;
			}
		}
	}
	
	public MurmurObject visitIterativeExpression(MurmurParser.ExpressionContext ctx) {
		// Track iterations.
		int iterations = 0;
		
		while(true) {
			MurmurObject before = desymbolize(visitExpression(ctx.clause));

			// Check that the clause is boolean.
			if(!(before instanceof MurmurBoolean)) {
				throw MurmurError.create(ctx.start.getLine(),
						getOriginalText(ctx), MurmurError.NOT_A_BOOLEAN);
			}
		
			// Check the loop condition.
			if(!((MurmurBoolean)before).getValue()) {
				// TODO
				return MurmurVoid.VOID;
			}
			
			// Visit loop body.
			MurmurObject during = desymbolize(visitStatement(ctx.statement(0)));
			
			// Check for lambda.
			if(during instanceof InvokableType) {
				// Pass along the iterations count.
				InvokableType invoke = (InvokableType)during;
				invoke.opInvoke(Collections.singletonList(
						MurmurInteger.create(iterations)));
			}
			
			// Check if an after clause exists.
			if(ctx.statement().size() == 2) {
				MurmurObject after = visitStatement(ctx.statement(1));
				
				// Check for lambda.
				if(after instanceof InvokableType) {
					// Pass along the iterations count.
					InvokableType invoke = (InvokableType)after;
					invoke.opInvoke(Collections.singletonList(
							MurmurInteger.create(iterations)));
				}
			}
			
			// Increment counter.
			iterations++;
		}
	}
	
	public MurmurObject visitConcatExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Dereference symbols.
		return left.opConcat(desymbolize(right));
	}
	
	public MurmurObject visitArrayIndexExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject index = visitExpression(ctx.index);
		
		// Dereference symbols.
		return left.opIndex(desymbolize(index));
	}
	
	public List<MurmurObject> visitArrayInitializerList(MurmurParser.ExpressionListContext ctx) {
		if(ctx == null) return new ArrayList<>();
		List<MurmurObject> elements = new ArrayList<>();
		ctx.expression().stream().forEach((expression) ->
				elements.add(desymbolize(visitExpression(expression))));
		return elements;
	}
	
	public MurmurObject visitArrayValueExpression(MurmurParser.ExpressionContext ctx) {
		List<MurmurObject> elements = visitArrayInitializerList(ctx.expressionList());
		return new MurmurArray(elements);
	}
	
	public List<MurmurObject> visitFunctionArguments(MurmurParser.ExpressionListContext ctx) {
		if(ctx == null) return Collections.emptyList();
		List<MurmurObject> args = new ArrayList<>();
		ctx.expression().stream().forEach((argument) ->
				args.add(desymbolize(visitExpression(argument))));
		return args;
	}
	
	@Override
	public MurmurObject visitBlock(MurmurParser.BlockContext ctx) {
		// Execute statements in sequence.
		for(MurmurParser.StatementContext statement : ctx.statement()) {
			MurmurObject result = visitStatement(statement);
			
			// Check for a return value.
			if(result instanceof MurmurReturn) {
				return ((MurmurReturn)result).getValue();
			}
		}
		
		// Return void value.
		return MurmurVoid.VOID;
	}
	
	public MurmurObject visitFunctionCallExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = desymbolize(visitExpression(ctx.left));
		List<MurmurObject> args = visitFunctionArguments(ctx.expressionList());
		
		// Check that this is an invokable type.
		if(left instanceof JavaInvokableType) {
			JavaInvokableType invoke = (JavaInvokableType)left;
			return invoke.opInvoke(args);
		} else if(left instanceof InvokableType) {
			// Invoke and return the result.
			InvokableType invoke = (InvokableType)left;
			return invoke.opInvoke(args);
		} else {
			throw new UnsupportedOperationException();
		}
	}
	
	public MurmurObject visitAssignmentExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Check that this is an lvalue.
		if(!(left instanceof MurmurVariable)) {
			throw new UnsupportedOperationException();
		}
		
		// Assign the value to the symbol.
		MurmurObject value = desymbolize(right);
		((MurmurVariable)left).setValue(value);
		return value;
	}
	
	public MurmurObject visitCompoundAssignmentExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = desymbolize(visitExpression(ctx.right));
		
		// Check that this is a reference type.
		if(!(left instanceof ReferenceType)) {
			throw new UnsupportedOperationException();
		}
		
		// Invoke the relevant operator.
		ReferenceType ref = (ReferenceType)left;
		switch(ctx.operator.getText()) {
			case "+=":
				return ref.opPlusAssign(right);
			case "-=":
				return ref.opMinusAssign(right);
			case "*=":
				return ref.opMultiplyAssign(right);
			case "/=":
				return ref.opDivideAssign(right);
			case "%=":
				return ref.opModuloAssign(right);
			case "&=":
				return ref.opBitAndAssign(right);
			case "^=":
				return ref.opBitXorAssign(right);
			case "|=":
				return ref.opBitOrAssign(right);
			case "<<=":
				return ref.opShiftLeftAssign(right);
			case ">>=":
				return ref.opShiftRightAssign(right);
			case "~=":
				return ref.opConcatAssign(right);
			default:
				// Unsupported assignment type.
				throw new UnsupportedOperationException();
		}
	}
	
	public MurmurObject visitMemberExpression(MurmurParser.ExpressionContext ctx) {
		String name = ctx.Identifier().getText();
		MurmurObject left = visitExpression(ctx.left);
		
		// Find and return the member.
		return left.getMember(name);
	}
	
	public MurmurObject visitSetNotationExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitIdentifierExpression(MurmurParser.ExpressionContext ctx) {
		MurmurSymbol symbol = context.peek().getSymbol(ctx.Identifier().getText());
		
		// Check that the symbol exists.
		if(symbol == null) {
			return MurmurVoid.VOID;
		}
		
		// Return the symbol.
		return (MurmurObject)symbol;
	}
	
	public List<String> visitLambdaParameterList(MurmurParser.IdentifierListContext ctx) {
		if(ctx == null) return Collections.emptyList();
		List<String> parameters = new ArrayList<>();
		ctx.Identifier().stream().forEach((parameter) ->
				parameters.add(parameter.getText()));
		return parameters;
	}

	@Override
	public MurmurObject visitLambda(MurmurParser.LambdaContext ctx) {
		// Create a lambda and a parameter list.
		List<String> parameters = visitLambdaParameterList(ctx.identifierList());
		return new MurmurLambda(ctx.start.getLine(), ctx.block(),
				parameters, context.peek(), delegate);
	}
	
	public MurmurObject visitLambdaInvokeExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = desymbolize(visitExpression(ctx.left));
		MurmurLambda lambda = (MurmurLambda)visitLambda(ctx.lambda());
		
		// Check that this is an invokable type.
		if(left instanceof InvokableType) {
			// Invoke and return the result.
			InvokableType invoke = (InvokableType)left;
			return invoke.opInvoke(Collections.singletonList(lambda));
		} else {
			throw new UnsupportedOperationException();
		}
	}
	
	public MurmurObject visitInstantiationExpression(MurmurParser.ExpressionContext ctx) {
		MurmurSymbol symbol = context.peek().getSymbol(ctx.Identifier().getText());
		
		// Check that the symbol exists.
		if(symbol == null) {
			throw MurmurError.create(ctx.start.getLine(),
					getOriginalText(getVisibleView((ParserRuleContext)ctx.parent)) +
							"\t(Not found: " + ctx.Identifier().getText() + ")",
					MurmurError.SYMBOL_NOT_FOUND);
		}
		
		// Check that this is a type.
		MurmurObject object = symbol.getValue();
		if(!(object instanceof MurmurComponent ||
				object instanceof JavaClass)) {
			throw new UnsupportedOperationException();
		}
		
		// Return the type.
		return object;
	}
	
	public MurmurObject visitRequireExpression(MurmurParser.ExpressionContext ctx) {
		try {
			// Lookup the Java class.
			String text = ctx.StringLiteral().getText();
			MurmurString string = MurmurString.create(text.substring(1, text.length() - 1));
			Class<?> javaClass = Class.forName(string.getValue());
			
			// Wrap the Java class.
			return new JavaClass(javaClass);
		} catch (ClassNotFoundException ex) {
			throw MurmurError.create(ctx.start.getLine(), getOriginalText(ctx),
					MurmurError.JAVA_CLASS_NOT_FOUND, ex);
		}
	}

	@Override
	public MurmurObject visitExpression(MurmurParser.ExpressionContext ctx) {
		// Skip null elements.
		if(ctx == null) return null;
		
		// Literals.
		if(ctx.literal() != null) {
			// Expression: a
			return visitLiteral(ctx.literal());
		}
		
		if(ctx.operator != null) {
			// Operator types.
			switch(ctx.operator.getText()) {
				case ".":
					// Expression: a.b
					return visitMemberExpression(ctx);
				case "..":
					// Expression: [a .. b]
					return visitSetNotationExpression(ctx);
				case "+":
					if(ctx.left != null)
						// Expression: a + b
						return visitAdditionExpression(ctx);
					// Expression: +a
					return visitPositiveExpression(ctx);
				case "-":
					if(ctx.left != null)
						// Expression: a - b
						return visitSubtractionExpression(ctx);
					// Expression: -a
					return visitNegativeExpression(ctx);
				case "*":
					// Expression: a * b
					return visitMultiplicationExpression(ctx);
				case "/":
					// Expression: a / b
					return visitDivisionExpression(ctx);
				case "%":
					// Expression: a % b
					return visitModuloExpression(ctx);
				case "!":
					// Expression: !a
					return visitLogicalNotExpression(ctx);
				case "~":
					if(ctx.left != null)
						// Expression: a ~ b
						return visitConcatExpression(ctx);
					// Expression: ~a
					return visitBinaryNotExpression(ctx);
				case "&":
					// Expression: a & b
					return visitBinaryAndExpression(ctx);
				case "^":
					// Expression: a ^ b
					return visitBinaryXorExpression(ctx);
				case "|":
					// Expression: a | b
					return visitBinaryOrExpression(ctx);
				case "<":
					// Expression: a < b
					return visitLessThanExpression(ctx);
				case ">":
					// Expression: a > b
					return visitGreaterThanExpression(ctx);
				case "=":
					// Expression: a = b
					return visitAssignmentExpression(ctx);
				case "?":
					// Expression: a ? b : c
					return visitTernaryExpression(ctx);
				case "@":
					// Expression: a @ b : c
					return visitIterativeExpression(ctx);
				case "(":
					// Expression: a(b, c, ...)
					return visitFunctionCallExpression(ctx);
				case "[":
					if(ctx.left != null)
						// Expression: a[b]
						return visitArrayIndexExpression(ctx);
					// Expression: [a, b, c, ...]
					return visitArrayValueExpression(ctx);
				case "++":
					if(ctx.left != null)
						// Expression: a++
						return visitPostIncrementExpression(ctx);
					// Expression: ++a
					return visitPreIncrementExpression(ctx);
				case "--":
					if(ctx.left != null)
						// Expression: a--
						return visitPostDecrementExpression(ctx);
					// Expression: --a
					return visitPreDecrementExpression(ctx);
				case "&&":
					// Expression: a && b
					return visitLogicalAndExpression(ctx);
				case "||":
					// Expression: a || b
					return visitLogicalOrExpression(ctx);
				case "==":
					// Expression: a == b
					return visitEqualExpression(ctx);
				case "!=":
					// Expression: a != b
					return visitNotEqualExpression(ctx);
				case "<=":
					// Expression: a <= b
					return visitLessOrEqualExpression(ctx);
				case ">=":
					// Expression: a >= b
					return visitGreaterOrEqualExpression(ctx);
				case "<<":
					// Expression: a << b
					return visitShiftLeftExpression(ctx);
				case ">>":
					// Expression: a >> b
					return visitShiftRightExpression(ctx);
				case "new":
					// Expression: new a
					return visitInstantiationExpression(ctx);
				case "require":
					// Expression: require "a"
					return visitRequireExpression(ctx);
				default:
					// Expression: a compound b
					return visitCompoundAssignmentExpression(ctx);
			}
		}
		
		// Identifier.
		if(ctx.Identifier() != null) {
			// Expression: a
			return visitIdentifierExpression(ctx);
		}
		
		// Lambda.
		if(ctx.lambda() != null) {
			if(ctx.left != null)
				// Expression: a { b }
				return visitLambdaInvokeExpression(ctx);
			// Expression: { a }
			return visitLambda(ctx.lambda());
		}
		
		// Parenthesized.
		if(ctx.inner != null) {
			// Expression: ( a )
			return visitExpression(ctx.inner);
		}
		
		// Internal error.
		throw MurmurError.create(ctx.start.getLine(),
				ctx.getText(), MurmurError.INTERNAL_ERROR);
	}
	
	/* - Literal Types - */
	/* - - - - - - - - - */
	
	public MurmurInteger visitIntegerLiteral(MurmurParser.LiteralContext ctx) {
		long value;
		String text = ctx.getText().toLowerCase();
		
		// Check for base.
		if(text.startsWith("0x")) {
			// Hexadecimal
			text = text.replaceAll("(0x|_|l)", "");
			value = Long.parseLong(text, 16);
		} else if(text.startsWith("0b")) {
			// Binary
			text = text.replaceAll("(0b|_|l)", "");
			value = Long.parseLong(text, 2);
		} else if(text.startsWith("0")) {
			// Octal
			value = Long.parseLong(text, 8);
		} else {
			// Decimal
			text = text.replaceAll("(_|l)", "");
			value = Long.parseLong(text);
		}
		
		return MurmurInteger.create(value);
	}
	
	public MurmurObject visitDecimalLiteral(MurmurParser.LiteralContext ctx) {
		String text = ctx.getText().toLowerCase();
		double value = Double.parseDouble(text);
		return MurmurDecimal.create(value);
	}
	
	public MurmurObject visitBooleanLiteral(MurmurParser.LiteralContext ctx) {
		return MurmurBoolean.create(Boolean.parseBoolean(ctx.getText()));
	}
	
	public MurmurObject visitCharacterLiteral(MurmurParser.LiteralContext ctx) {
		Pattern pattern = Pattern.compile("\\'(?:([^\\\\])|(\\\\[bfnrt0\\\\'\"])|(?:\\\\([0-3]?[0-7]?[0-7])))\\'",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(ctx.getText());
		
		// Sanity check.
		if(!matcher.find()) {
			throw new RuntimeException();
		}
		
		String group;
		if((group = matcher.group(1)) != null) {
			// Simple character literal.
			return new MurmurCharacter(group.charAt(0));
		} else if((group = matcher.group(2)) != null) {
			// Simple escape sequence.
			switch(group.charAt(1)) {
				case 'b':  return new MurmurCharacter('\b');
				case 'f':  return new MurmurCharacter('\f');
				case 'n':  return new MurmurCharacter('\n');
				case 'r':  return new MurmurCharacter('\r');
				case 't':  return new MurmurCharacter('\t');
				case '0':  return new MurmurCharacter('\0');
				case '\\': return new MurmurCharacter('\\');
				case '\'': return new MurmurCharacter('\'');
				case '"':  return new MurmurCharacter('"');
					
				// Invalid character escape sequence.
				default: return new MurmurCharacter(group.charAt(1));
			}
		} else if((group = matcher.group(3)) != null) {
			// Octal escape sequence.
			int value = Integer.parseInt(group, 8);
			return new MurmurCharacter(value);
		} else {
			// Something went wrong.
			throw new RuntimeException();
		}
	}
	
	public MurmurObject visitStringLiteral(MurmurParser.LiteralContext ctx) {
		// Create a string and trim outer quotes.
		String value = ctx.getText();
		return MurmurString.create(value.substring(1, value.length() - 1));
	}
	
	public MurmurObject visitNullLiteral(MurmurParser.LiteralContext ctx) {
		// Return the null literal.
		return MurmurNull.NULL;
	}

	@Override
	public MurmurObject visitLiteral(MurmurParser.LiteralContext ctx) {
		// Integer literals.
		if(ctx.IntegerLiteral() != null) {
			return visitIntegerLiteral(ctx);
		}
		// Decimal literals.
		if(ctx.DecimalLiteral() != null) {
			return visitDecimalLiteral(ctx);
		}
		// Boolean literals.
		if(ctx.BooleanLiteral() != null) {
			return visitBooleanLiteral(ctx);
		}
		// Character literals.
		if(ctx.CharacterLiteral() != null) {
			return visitCharacterLiteral(ctx);
		}
		// String literals.
		if(ctx.StringLiteral() != null) {
			return visitStringLiteral(ctx);
		}
		// Null literals.
		if(ctx.NullLiteral() != null) {
			return visitNullLiteral(ctx);
		}
		// 'this' literal.
		if(ctx.getText().equals("this")) {
			MurmurSymbol symbol = context.peek().getSymbol("this");
			
			// Check that there is a 'this' defined.
			if(symbol == null) {
				throw new UnsupportedOperationException();
			}
			
			// Return the symbol.
			return (MurmurObject)symbol;
		}
		
		// Unknown literal type.
		throw MurmurError.create(ctx.start.getLine(),
				ctx.getText(), MurmurError.INTERNAL_ERROR);
	}

}

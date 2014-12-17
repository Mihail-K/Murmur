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
import io.cloudchaser.murmur.symbol.LetSymbol;
import io.cloudchaser.murmur.symbol.Symbol;
import io.cloudchaser.murmur.symbol.SymbolContext;
import io.cloudchaser.murmur.types.MurmurArray;
import io.cloudchaser.murmur.types.MurmurBoolean;
import io.cloudchaser.murmur.types.MurmurComponent;
import io.cloudchaser.murmur.types.MurmurComponent.ComponentField;
import io.cloudchaser.murmur.types.MurmurComponent.ComponentFunction;
import io.cloudchaser.murmur.types.MurmurFunction;
import io.cloudchaser.murmur.types.MurmurInstance;
import io.cloudchaser.murmur.types.MurmurInteger;
import io.cloudchaser.murmur.types.MurmurNull;
import io.cloudchaser.murmur.types.MurmurObject;
import io.cloudchaser.murmur.types.MurmurReturn;
import io.cloudchaser.murmur.types.MurmurString;
import static io.cloudchaser.murmur.types.MurmurType.TYPE;
import io.cloudchaser.murmur.types.ReferenceType;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurASTVisitor
		extends MurmurParserBaseVisitor {
	
	private static class MurmurBaseContext
			implements SymbolContext {
		
		private final Map<String, Symbol> symbols;

		public MurmurBaseContext() {
			symbols = new HashMap<>();
		}

		@Override
		public SymbolContext getParent() {
			return null;
		}

		@Override
		public void addSymbol(Symbol symbol) {
			symbols.put(symbol.getName(), symbol);
		}

		@Override
		public Symbol getSymbol(String name) {
			return symbols.get(name);
		}

		@Override
		public Symbol getLocal(String name) {
			return symbols.get(name);
		}
		
	}
	
	private final Deque<SymbolContext> context;
	
	public MurmurASTVisitor() {
		context = new LinkedList<>();
	}
	
	/**
	 * Removes symbol binding from a murmur value, if present.
	 * 
	 * @param object The object to de-symbolize.
	 * @return A murmur object.
	 */
	private static MurmurObject desymbolize(MurmurObject object) {
		return object instanceof Symbol ? ((Symbol)object).getValue() : object;
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
			// Print results for debug.
			System.out.println(visitExpression(ctx.expression()));
		}
		
		return null;
	}
	
	/* - Statements  - */
	/* - - - - - - - - */
	
	public MurmurObject visitLeftArrowStatement(MurmurParser.KeywordStatementContext ctx) {
		// Get the current instance context.
		Symbol symbol = context.peek().getSymbol("this");
		MurmurInstance instance = (MurmurInstance)symbol.getValue();
		
		ctx.identifierList().Identifier()
				.stream().forEach((identifier) -> {
			String name = identifier.getText();
			Symbol source = context.peek().getLocal(name);
			Symbol target = instance.getContext().getLocal(name);
			
			// Check that the symbol exists.
			if(source == null || target == null) {
				throw new NullPointerException();
			}
			
			// Bind the symbol, by name.
			target.setValue(source.getValue());
		});
		
		return null;
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
			MurmurObject value = visitExpression(element.expression());
			
			// Create a symbol entry.
			context.peek().addSymbol(new LetSymbol(name, value));
		});
		
		return null;
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
					throw new RuntimeException();
			}
		}
		
		// Something went wrong.
		throw new RuntimeException();
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
	
	public MurmurComponent.ComponentField visitTypeField(MurmurParser.TypeElementContext ctx) {
		String name = ctx.name.getText();
		
		// Validate field name.
		if(name.equals("this")) {
			throw new UnsupportedOperationException();
		}
		
		// Create the field.
		return new ComponentField(name);
	}
	
	public MurmurComponent.ComponentFunction visitTypeFunction(MurmurParser.TypeElementContext ctx) {
		String name = ctx.name.getText();
		MurmurObject value = visitExpression(ctx.expression());
		
		// Adjust names.
		if(name.equals("this")) {
			name = "~ctor";
		}
		
		// Check that this is a function.
		if(!(value instanceof MurmurFunction)) {
			throw new UnsupportedOperationException();
		}
		
		// Create the function.
		MurmurFunction function = (MurmurFunction)value;
		return new ComponentFunction(name, function);
	}

	@Override
	public MurmurComponent.ComponentField visitTypeElement(MurmurParser.TypeElementContext ctx) {
		// Determine the element type.
		if(ctx.expression() != null) {
			return visitTypeFunction(ctx);
		} else {
			return visitTypeField(ctx);
		}
	}

	@Override
	public MurmurObject visitTypeDeclaration(MurmurParser.TypeDeclarationContext ctx) {
		MurmurComponent component = new MurmurComponent("<local>", context.peek());
		
		// Build component members list.
		if(ctx.typeElement() != null) {
			ctx.typeElement().stream().forEach((element) -> {
				MurmurComponent.ComponentField symbol = visitTypeElement(element);
				component.getMembers().put(symbol.getName(), symbol);
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
			Symbol symbol = context.peek().getSymbol(identifier.getText());
			
			// Check that the type exists.
			if(symbol == null) {
				throw new NullPointerException();
			}
			
			// Check that this is a component type.
			MurmurObject object = symbol.getValue();
			if(object.getType() != TYPE) {
				throw new UnsupportedOperationException();
			}
			
			// Add it to the list.
			types.add((MurmurComponent)object);
		});
		
		return types;
	}
	
	@Override
	public MurmurObject visitTypeStatement(MurmurParser.TypeStatementContext ctx) {
		Symbol symbol;
		String name = ctx.name.getText();
		
		// Visit parent and local types.
		List<MurmurComponent> types = visitTypeParents(ctx);
		types.add((MurmurComponent)visitTypeDeclaration(ctx.typeDeclaration()));
		
		// Build the finished Murmur component object.
		MurmurObject component = new MurmurComponent(name, context.peek(), types);
		context.peek().addSymbol(symbol = new LetSymbol(name, component));
		return symbol.getValue();
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
		if(!(right instanceof Symbol)) {
			throw new UnsupportedOperationException();
		}
		
		// Increment and return value.
		Symbol symbol = (Symbol)right;
		symbol.setValue(right.opIncrement());
		return symbol.getValue();
	}
	
	public MurmurObject visitPostIncrementExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		
		// Must be a symbol to increment.
		if(!(left instanceof Symbol)) {
			throw new UnsupportedOperationException();
		}
		
		// Increment and return old value.
		Symbol symbol = (Symbol)left;
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
		if(!(right instanceof Symbol)) {
			throw new UnsupportedOperationException();
		}
		
		// Decrement and return value.
		Symbol symbol = (Symbol)right;
		symbol.setValue(right.opDecrement());
		return symbol.getValue();
	}
	
	public MurmurObject visitPostDecrementExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		
		// Must be a symbol to decrement.
		if(!(left instanceof Symbol)) {
			throw new UnsupportedOperationException();
		}
		
		// Decrement and return old value.
		Symbol symbol = (Symbol)left;
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
		MurmurObject clause = visitExpression(ctx.clause);
		clause = clause instanceof Symbol ? ((Symbol)clause).getValue() : clause;
		
		// Check that the clause is boolean.
		if(!(clause instanceof MurmurBoolean)) {
			throw new UnsupportedOperationException();
		}
		
		// Check the clause.
		MurmurBoolean bool = (MurmurBoolean)clause;
		if(bool.getValue()) {
			// True; evaluate left.
			return visitExpression(ctx.expression(1));
		} else {
			// False; evaluate right.
			return visitExpression(ctx.expression(2));
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
		if(ctx == null) return null;
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
		
		// TODO
		return null;
	}
	
	public MurmurObject visitFunctionCallExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		left = left instanceof Symbol ? ((Symbol)left).getValue() : left;
		List<MurmurObject> args = visitFunctionArguments(ctx.expressionList());
		
		// Check that this is a function.
		if(left instanceof MurmurFunction) {
			// Step into a new context.
			MurmurFunction function = (MurmurFunction)left;
			context.push(function.createLocal(args));

			// Execute function body.
			MurmurObject result = visitBlock(function.getBody());

			// Leave the function context.
			context.pop();
			return result;
		} else if(left instanceof MurmurComponent) {
			// Create a new instance of the component.
			MurmurComponent component = (MurmurComponent)left;
			MurmurInstance instance = new MurmurInstance(component);
			
			// Lookup and call the construtor.
			Symbol symbol = instance.getContext().getLocal("~ctor");
			MurmurFunction ctor = (MurmurFunction)symbol.getValue();
			context.push(ctor.createLocal(args));
			
			// Execute constructor body.
			visitBlock(ctor.getBody());
			
			// Leave the constructor.
			context.pop();
			return instance;
		} else {
			// TODO : Objects can define an invoke operator.
			throw new UnsupportedOperationException();
		}
	}
	
	public MurmurObject visitAssignmentExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		
		// Check that this is an lvalue.
		if(!(left instanceof Symbol)) {
			throw new UnsupportedOperationException();
		}
		
		// Assign the value to the symbol.
		MurmurObject value = desymbolize(right);
		((Symbol)left).setValue(value);
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
		MurmurObject left = desymbolize(visitExpression(ctx.left));
		
		// TODO : Other types will have members too.
		if(!(left instanceof MurmurInstance)) {
			throw new UnsupportedOperationException();
		}
		
		// Get the symbol from the object.
		MurmurInstance instance = (MurmurInstance)left;
		return instance.getContext().getLocal(name);
	}
	
	public MurmurObject visitSetNotationExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitIdentifierExpression(MurmurParser.ExpressionContext ctx) {
		Symbol symbol = context.peek().getSymbol(ctx.getText());
		
		// Check that the symbol exists.
		if(symbol == null) {
			// TODO
			throw new NullPointerException();
		}
		
		// Return the symbol.
		return symbol;
	}
	
	public List<String> visitLambdaParameterList(MurmurParser.IdentifierListContext ctx) {
		if(ctx == null) return null;
		List<String> parameters = new ArrayList<>();
		ctx.Identifier().stream().forEach((parameter) ->
				parameters.add(parameter.getText()));
		return parameters;
	}

	@Override
	public MurmurObject visitLambda(MurmurParser.LambdaContext ctx) {
		List<String> parameters = visitLambdaParameterList(ctx.identifierList());
		return new MurmurFunction(context.peek(), parameters, ctx.block());
	}
	
	public MurmurObject visitInstantiationExpression(MurmurParser.ExpressionContext ctx) {
		Symbol symbol = context.peek().getSymbol(ctx.Identifier().getText());
		
		// Check that the symbol exists.
		if(symbol == null) {
			// TODO
			throw new NullPointerException();
		}
		
		// Check that this is a type.
		MurmurObject object = symbol.getValue();
		if(!(object instanceof MurmurComponent)) {
			throw new UnsupportedOperationException();
		}
		
		// Return the type.
		return object;
	}

	@Override
	public MurmurObject visitExpression(MurmurParser.ExpressionContext ctx) {
		// Skip null elements.
		if(ctx == null) return null;
		
		// Literals.
		if(ctx.literal() != null) {
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
				default:
					// Expression: a compound b
					return visitCompoundAssignmentExpression(ctx);
			}
		}
		
		// Identifier.
		if(ctx.Identifier() != null) {
			return visitIdentifierExpression(ctx);
		}
		
		// Lambda.
		if(ctx.lambda() != null) {
			return visitLambda(ctx.lambda());
		}
		
		// Parenthesized.
		if(ctx.inner != null) {
			return visitExpression(ctx.inner);
		}
		
		throw new RuntimeException();
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
		// TODO
		return null;
	}
	
	public MurmurObject visitBooleanLiteral(MurmurParser.LiteralContext ctx) {
		return MurmurBoolean.create(Boolean.parseBoolean(ctx.getText()));
	}
	
	public MurmurObject visitCharacterLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitStringLiteral(MurmurParser.LiteralContext ctx) {
		// Create a string and trim outer quotes.
		String value = ctx.getText();
		return new MurmurString(value.substring(1, value.length() - 1));
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
			Symbol symbol = context.peek().getSymbol("this");
			
			// Check that there is a 'this' defined.
			if(symbol == null) {
				throw new UnsupportedOperationException();
			}
			
			// Return the symbol.
			return symbol;
		}
		
		// Unknown literal type.
		throw new RuntimeException();
	}

}

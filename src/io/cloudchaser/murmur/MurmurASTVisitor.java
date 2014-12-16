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
import io.cloudchaser.murmur.types.MurmurInteger;
import io.cloudchaser.murmur.types.MurmurObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurASTVisitor
		extends MurmurParserBaseVisitor<MurmurObject> {
	
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
		
	}
	
	private final SymbolContext context;
	
	public MurmurASTVisitor() {
		context = new MurmurBaseContext();
	}

	@Override
	public MurmurObject visitCompilationUnit(MurmurParser.CompilationUnitContext ctx) {
		// Visit children.
		ctx.statement().stream().forEach(this::visitStatement);
		
		return null;
	}

	@Override
	public MurmurObject visitStatement(MurmurParser.StatementContext ctx) {
		if(ctx.keywordStatement() != null) {
			visitKeywordStatement(ctx.keywordStatement());
		} else {
			// Print results for debug.
			System.out.println(visitExpression(ctx.expression()));
		}
		
		return null;
	}
	
	/* - Statements  - */
	/* - - - - - - - - */
	
	public MurmurObject visitLeftArrowStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
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
			System.out.println(name + " : " + value);
			
			// Create a symbol entry.
			context.addSymbol(new LetSymbol(name, value));
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
		// TODO
		return null;
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
	
	/* - Classes - */
	/* - - - - - - */
	
	public MurmurObject visitTypeField(MurmurParser.TypeElementContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitTypeFunction(MurmurParser.TypeElementContext ctx) {
		// TODO
		return null;
	}

	@Override
	public MurmurObject visitTypeElement(MurmurParser.TypeElementContext ctx) {
		// TODO
		return null;
	}
	
	/* - Expressions - */
	/* - - - - - - - - */
	
	public MurmurObject visitPositiveExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitPreIncrementExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitPostIncrementExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitAdditionExpression(MurmurParser.ExpressionContext ctx) {
		MurmurObject left = visitExpression(ctx.left);
		MurmurObject right = visitExpression(ctx.right);
		return left.opPlus(right instanceof Symbol ?
				((Symbol)right).getValue() : right);
	}
	
	public MurmurObject visitNegativeExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitPreDecrementExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitPostDecrementExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitSubtractionExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitMultiplicationExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitDivisionExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitModuloExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitEqualExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitNotEqualExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitLogicalNotExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitLogicalAndExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitLogicalOrExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitBinaryNotExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitBinaryAndExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitBinaryXorExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitBinaryOrExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitLessThanExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitGreaterThanExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitLessOrEqualExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitGreaterOrEqualExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitShiftLeftExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitShiftRightExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitTernaryExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitArrayIndexExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitFunctionArguments(MurmurParser.ExpressionListContext ctx) {
		// Visit the argument list.
		ctx.expression().stream().forEach(this::visitExpression);
		
		// TODO
		return null;
	}
	
	public MurmurObject visitFunctionCallExpression(MurmurParser.ExpressionContext ctx) {
		if(ctx.expressionList() != null) {
			visitFunctionArguments(ctx.expressionList());
		}
		
		// TODO
		return null;
	}
	
	public MurmurObject visitAssignmentExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitMemberExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitSetNotationExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitIdentifierExpression(MurmurParser.ExpressionContext ctx) {
		return context.getSymbol(ctx.getText());
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
				case ",":
					// Expression: [a, b]
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
					// Expression: a[b]
					return visitArrayIndexExpression(ctx);
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
				default:
					// Unknown operator.
					throw new RuntimeException();
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
		long value = Long.parseLong(ctx.getText());
		if(value == 0) return MurmurInteger.ZERO;
		return new MurmurInteger(value);
	}
	
	public MurmurObject visitDecimalLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitBooleanLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitCharacterLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitStringLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public MurmurObject visitNullLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
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
			return visitDecimalLiteral(ctx);
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
		
		// Unknown literal type.
		throw new RuntimeException();
	}

}

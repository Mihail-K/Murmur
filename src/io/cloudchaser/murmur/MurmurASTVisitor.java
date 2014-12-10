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
import io.cloudchaser.murmur.symbols.Symbol;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurASTVisitor
		extends MurmurParserBaseVisitor {

	public MurmurASTVisitor() {
	}
	
	/* - Statements  - */
	/* - - - - - - - - */
	
	public Object visitLeftArrowStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitRightArrowStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitBreakStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitContinueStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitLetStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitReturnStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitThrowStatement(MurmurParser.KeywordStatementContext ctx) {
		// TODO
		return null;
	}
	
	@Override
	public Object visitKeywordStatement(MurmurParser.KeywordStatementContext ctx) {
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
	
	public Object visitITypeFunction(MurmurParser.ITypeElementContext ctx) {
		// TODO
		return null;
	}

	@Override
	public Object visitITypeElement(MurmurParser.ITypeElementContext ctx) {
		// Get symbol information.
		Symbol symbol = (Symbol)ctx.getExtra();
		
		switch(symbol.getType()) {
			case FUNCTION:
				// Interface function.
				return visitITypeFunction(ctx);
			default:
				// Unsupported type.
				// TODO : Inner types.
				throw new RuntimeException();
		}
	}
	
	/* - Classes - */
	/* - - - - - - */
	
	public Object visitTypeField(MurmurParser.TypeElementContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitTypeFunction(MurmurParser.TypeElementContext ctx) {
		// TODO
		return null;
	}

	@Override
	public Object visitTypeElement(MurmurParser.TypeElementContext ctx) {
		// Get symbol information.
		Symbol symbol = (Symbol)ctx.getExtra();
		
		switch(symbol.getType()) {
			case VARIABLE:
				// Class field.
				return visitTypeField(ctx);
			case FUNCTION:
				// Class function.
				return visitTypeFunction(ctx);
			default:
				// Unsupported type.
				// TODO : Inner types.
				throw new RuntimeException();
		}
	}
	
	/* - Expressions - */
	/* - - - - - - - - */
	
	public Object visitPositiveExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitPreIncrementExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitPostIncrementExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitAdditionExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitNegativeExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitPreDecrementExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitPostDecrementExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitSubtractionExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitMultiplicationExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitDivisionExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitModuloExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitEqualExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitNotEqualExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitLogicalNotExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitLogicalAndExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitLogicalOrExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitBinaryNotExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitBinaryAndExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitBinaryXorExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitBinaryOrExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitLessThanExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitGreaterThanExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitLessOrEqualExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitGreaterOrEqualExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitShiftLeftExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitShiftRightExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitTernaryExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitArrayIndexExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitFunctionCallExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitAssignmentExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitMemberExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitSetNotationExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitIdentifierExpression(MurmurParser.ExpressionContext ctx) {
		// TODO
		return null;
	}

	@Override
	public Object visitExpression(MurmurParser.ExpressionContext ctx) {
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
		
		return null;
	}
	
	/* - Literal Types - */
	/* - - - - - - - - - */
	
	public Object visitIntegerLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitDecimalLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitBooleanLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitCharacterLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitStringLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}
	
	public Object visitNullLiteral(MurmurParser.LiteralContext ctx) {
		// TODO
		return null;
	}

	@Override
	public Object visitLiteral(MurmurParser.LiteralContext ctx) {
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

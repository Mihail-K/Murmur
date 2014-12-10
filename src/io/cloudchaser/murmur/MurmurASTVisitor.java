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


/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurASTVisitor
		extends MurmurParserBaseVisitor {

	public MurmurASTVisitor() {
	}
	
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

	@Override
	public Object visitExpression(MurmurParser.ExpressionContext ctx) {
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
		
		// Parenthesized.
		if(ctx.inner != null) {
			return visitExpression(ctx.inner);
		}
		
		return null;
	}
	
}

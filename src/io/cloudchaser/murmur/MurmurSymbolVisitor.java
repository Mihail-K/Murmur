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
import io.cloudchaser.murmur.symbols.SymbolContext;
import io.cloudchaser.murmur.symbols.SymbolType;

import static io.cloudchaser.murmur.symbols.SymbolType.CLASS;
import static io.cloudchaser.murmur.symbols.SymbolType.FUNCTION;
import static io.cloudchaser.murmur.symbols.SymbolType.INTERFACE;
import static io.cloudchaser.murmur.symbols.SymbolType.VARIABLE;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurSymbolVisitor
		extends MurmurParserBaseVisitor {
	
	private final SymbolContext head;
	private SymbolContext tail;

	public MurmurSymbolVisitor() {
		head = tail = new SymbolContext(null, null);
	}
	
	/**
	 * Returns a complete symbol table.
	 * 
	 * @return The completed symbol table.
	 */
	public SymbolContext getSymbolTable() {
		return head;
	}

	@Override
	public Object visitITypeStatement(MurmurParser.ITypeStatementContext ctx) {
		// Push a new symbol context.
		SymbolContext symbol = new SymbolContext(ctx.name.getText(), INTERFACE);
		tail.addSymbol(symbol);
		ctx.setExtra(symbol);
		tail = symbol;
		
		// Visit children.
		super.visitITypeStatement(ctx);
		
		// Pop the context off the stack.
		tail = tail.getParent();
		
		return null;
	}

	@Override
	public Object visitITypeElement(MurmurParser.ITypeElementContext ctx) {
		Symbol symbol = new Symbol(ctx.name.getText(), FUNCTION);
		tail.addSymbol(symbol);
		ctx.setExtra(symbol);
		return null;
	}

	@Override
	public Object visitTypeStatement(MurmurParser.TypeStatementContext ctx) {
		// Push a new symbol context.
		SymbolContext symbol = new SymbolContext(ctx.name.getText(), CLASS);
		tail.addSymbol(symbol);
		ctx.setExtra(symbol);
		tail = symbol;
		
		// Visit children.
		super.visitTypeStatement(ctx);
		
		// Pop the context off the stack.
		tail = tail.getParent();
		
		return null;
	}

	@Override
	public Object visitTypeElement(MurmurParser.TypeElementContext ctx) {
		SymbolType type = VARIABLE;
		if(ctx.expression() != null) {
			// Find the precise field type.
			type = (SymbolType)visitExpression(ctx.expression());
		}
		
		Symbol symbol = new Symbol(ctx.name.getText(), type);
		tail.addSymbol(symbol);
		ctx.setExtra(symbol);
		return null;
	}

	@Override
	public Object visitExpression(MurmurParser.ExpressionContext ctx) {
		// Check if this is a function.
		if(ctx.operator == null && ctx.lambda() != null) {
			return FUNCTION;
		}
		
		// Parenthesized type.
		if(ctx.inner != null) {
			return visitExpression(ctx.inner);
		}
		
		// Must be a variable.
		return VARIABLE;
	}

}

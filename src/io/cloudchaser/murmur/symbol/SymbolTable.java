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

package io.cloudchaser.murmur.symbol;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class SymbolTable {
	
	private final Deque<SymbolContext> contexts;

	public SymbolTable() {
		// Create an initial context.
		contexts = new LinkedList<>();
	}
	
	public void addSymbol(Symbol symbol) {
		contexts.peek().addSymbol(symbol);
	}
	
	public Symbol getSymbol(String name) {
		return contexts.peek().getSymbol(name, false);
	}
	
	public void enterContext(SymbolContext context) {
		contexts.push(context);
	}
	
	public SymbolContext context() {
		return contexts.peek();
	}
	
	public SymbolContext leaveContext() {
		return contexts.pop();
	}
	
}

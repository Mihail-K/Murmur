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

package io.cloudchaser.murmur.types;

import io.cloudchaser.murmur.symbol.Symbol;
import io.cloudchaser.murmur.symbol.SymbolContext;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class LambdaContext
		implements SymbolContext {
	
	/**
	 * The parent symbol context.
	 **/
	private final SymbolContext context;
	
	/**
	 * The context symbol table.
	 **/
	private final Map<String, Symbol> symbols;

	public LambdaContext() {
		this(null);
	}

	public LambdaContext(SymbolContext context) {
		symbols = new HashMap<>();
		this.context = context;
	}

	@Override
	public SymbolContext getParent() {
		return context;
	}

	@Override
	public void addSymbol(Symbol symbol) {
		symbols.put(symbol.getName(), symbol);
	}

	@Override
	public Symbol getSymbol(String name) {
		Symbol symbol = symbols.get(name);
		if(symbol == null && context != null)
			return context.getSymbol(name);
		return symbol;
	}

	@Override
	public Symbol getLocal(String name) {
		return symbols.get(name);
	}
	
}

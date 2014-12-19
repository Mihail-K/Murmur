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

import io.cloudchaser.murmur.types.MurmurSymbol;
import io.cloudchaser.murmur.types.SymbolContext;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mihail
 */
class MurmurBaseContext implements SymbolContext {
	
	/**
	 * The base context symbol table.
	 */
	private final Map<String, MurmurSymbol> symbols;

	public MurmurBaseContext() {
		symbols = new HashMap<>();
	}

	@Override
	public SymbolContext getParent() {
		return null;
	}

	@Override
	public void addSymbol(MurmurSymbol symbol) {
		symbols.put(symbol.getName(), symbol);
	}

	@Override
	public MurmurSymbol getSymbol(String name) {
		return symbols.get(name);
	}

	@Override
	public MurmurSymbol getLocal(String name) {
		return symbols.get(name);
	}
	
}

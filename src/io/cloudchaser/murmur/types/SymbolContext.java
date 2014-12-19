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

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public interface SymbolContext {
	
	/**
	 * Returns this context's parent context.
	 * 
	 * @return The parent context.
	 */
	SymbolContext getParent();
	
	/**
	 * Defines a symbol in this context.
	 * If a definition already exists, its value is replaced.
	 * 
	 * @param symbol The new symbol.
	 */
	void addSymbol(MurmurSymbol symbol);
	
	/**
	 * Search for a symbol by name.
	 * If the symbol isn't found in this context, the parent is searched.
	 * 
	 * @param name The name of the symbol to look for.
	 * @return The symbol, if found. Otherwise, <code>null</code>.
	 */
	MurmurSymbol getSymbol(String name);
	
	/**
	 * Search for a symbol by name, in the local context.
	 * 
	 * @param name The name of the symbol to look for.
	 * @return The symbol, if found. Otherwise, <code>null</code>.
	 */
	MurmurSymbol getLocal(String name);
	
}

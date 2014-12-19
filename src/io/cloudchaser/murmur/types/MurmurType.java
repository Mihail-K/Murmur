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
 **/
public enum MurmurType {
	
	NULL("null", false),
	INTEGER("integer", true),
	DECIMAL("decimal", true),
	BOOLEAN("boolean", false),
	CHARACTER("character", true),
	STRING("string", false),
	ARRAY("array", false),
	
	FUNCTION("function", false),
	OBJECT("object", false),
	TYPE("type", false),
	VOID("void", false);
	
	/**
	 * The internal name of the type.
	 **/
	public final String name;
	/**
	 * Numeric type flag.
	 **/
	public final boolean numeric;
	
	MurmurType(String name, boolean numeric) {
		this.name = name;
		this.numeric = numeric;
	}
	
}

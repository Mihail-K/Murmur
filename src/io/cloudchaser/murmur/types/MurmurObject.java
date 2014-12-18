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
public abstract class MurmurObject {
	
	private final MurmurType type;

	public MurmurObject(MurmurType type) {
		this.type = type;
	}

	public MurmurType getType() {
		return type;
	}
	
	/**
	 * Converts this Murmur object into a Java object.
	 * 
	 * @return A Java object.
	 */
	public Object toJavaObject() {
		return null;
	}
	
	public MurmurObject getMember(String name) {
		// Default implementation.
		return MurmurVoid.VOID;
	}
	
	/**
	 * Converts this Object to an integer, if possible.
	 * 
	 * @return This Object as an integer.
	 **/
	public abstract MurmurInteger asInteger();
	
	/**
	 * Converts this Object to a decimal, if possible.
	 * 
	 * @return This Object as a decimal.
	 **/
	public abstract MurmurDecimal asDecimal();
	
	/**
	 * Converts this Object to a string, if possible.
	 * 
	 * @return This Object as a string.
	 **/
	public abstract MurmurString asString();
	
	public abstract MurmurObject opPositive();
	
	public abstract MurmurObject opNegative();
	
	public abstract MurmurObject opIncrement();
	
	public abstract MurmurObject opDecrement();
	
	public abstract MurmurObject opPlus(MurmurObject other);
	
	public abstract MurmurObject opMinus(MurmurObject other);
	
	public abstract MurmurObject opMultiply(MurmurObject other);
	
	public abstract MurmurObject opDivide(MurmurObject other);
	
	public abstract MurmurObject opModulo(MurmurObject other);
	
	public abstract MurmurObject opShiftLeft(MurmurObject other);
	
	public abstract MurmurObject opShiftRight(MurmurObject other);
	
	public abstract MurmurObject opLessThan(MurmurObject other);
	
	public abstract MurmurObject opGreaterThan(MurmurObject other);
	
	public abstract MurmurObject opLessOrEqual(MurmurObject other);
	
	public abstract MurmurObject opGreaterOrEqual(MurmurObject other);
	
	public abstract MurmurObject opEquals(MurmurObject other);
	
	public abstract MurmurObject opNotEquals(MurmurObject other);
	
	public abstract MurmurObject opBitNot();
	
	public abstract MurmurObject opBitAnd(MurmurObject other);
	
	public abstract MurmurObject opBitXor(MurmurObject other);
	
	public abstract MurmurObject opBitOr(MurmurObject other);
	
	public abstract MurmurObject opLogicalNot();
	
	public abstract MurmurObject opLogicalAnd(MurmurObject other);
	
	public abstract MurmurObject opLogicalOr(MurmurObject other);
	
	public abstract MurmurObject opIndex(MurmurObject other);
	
	public abstract MurmurObject opConcat(MurmurObject other);
	
}

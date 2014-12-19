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
public class MurmurObject {
	
	private final MurmurType type;

	public MurmurObject(MurmurType type) {
		this.type = type;
	}

	public MurmurType getType() {
		return type;
	}
	
	public MurmurObject getMember(String name) {
		// All objects have a type.
		if(name.equals("typeof")) {
			// Return a string of the object type.
			return MurmurString.create(getType().name);
		}
		
		// Default implementation.
		return MurmurVoid.VOID;
	}
	
	/**
	 * Checks if this Murmur object can convert to a Java type.
	 * 
	 * @param type The Java type being converted to.
	 * @return <code>true</code> is this object converts to the given type.
	 */
	public boolean isCompatible(Class<?> type) {
		// By default, no conversion is available.
		return type.isAssignableFrom(getClass());
	}
	
	/**
	 * Converts this Murmur object into a Java type.
	 * 
	 * @param type The Java type being converted to.
	 * @return The converted Java object.
	 */
	public Object getAsJavaType(Class<?> type) {
		// Check that this type is compatible.
		if(type.isAssignableFrom(getClass())) {
			return this;
		}
		
		// Unsupported conversion.
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Converts this Object to an integer, if possible.
	 * 
	 * @return This Object as an integer.
	 **/
	public MurmurInteger asInteger() {
		return MurmurInteger.ZERO;
	}
	
	/**
	 * Converts this Object to a decimal, if possible.
	 * 
	 * @return This Object as a decimal.
	 **/
	public MurmurDecimal asDecimal() {
		return MurmurDecimal.ZERO;
	}
	
	/**
	 * Converts this Object to a string, if possible.
	 * 
	 * @return This Object as a string.
	 **/
	public MurmurString asString() {
		return MurmurString.EMPTY;
	}
	
	public MurmurObject opPositive() {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opNegative() {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opIncrement() {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opDecrement() {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opPlus(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opMinus(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opMultiply(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opDivide(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opModulo(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opShiftLeft(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opShiftRight(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opLessThan(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opGreaterThan(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opLessOrEqual(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opEquals(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opNotEquals(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opBitNot() {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opBitAnd(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opBitXor(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opBitOr(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opLogicalNot() {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opLogicalAnd(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opLogicalOr(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opIndex(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
	public MurmurObject opConcat(MurmurObject other) {
		// Default has no implementation.
		throw new UnsupportedOperationException();
	}
	
}

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

import static io.cloudchaser.murmur.types.MurmurType.STRING;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurString extends MurmurObject {
	
	/**
	 * Singleton empty Murmur string.
	 */
	public static final MurmurString EMPTY = MurmurString.create("");
	
	private final String value;

	private MurmurString(String value) {
		super(STRING);
		this.value = value;
	}

	public static MurmurString create(String value) {
		if(value.isEmpty()) return EMPTY;
		return new MurmurString(value);
	}
	
	@Override
	public Object toJavaObject() {
		return value;
	}
	
	@Override
	public boolean isCompatible(Class<?> type) {
		return type.isAssignableFrom(String.class) ||
				type.isAssignableFrom(CharSequence.class);
	}
	
	@Override
	public Object getAsJavaType(Class<?> type) {
		// Java string type.
		if(type.isAssignableFrom(String.class) ||
				type.isAssignableFrom(CharSequence.class)) {
			return value;
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurInteger asInteger() {
		return MurmurInteger.ZERO;
	}

	@Override
	public MurmurDecimal asDecimal() {
		return MurmurDecimal.ZERO;
	}

	@Override
	public MurmurString asString() {
		return this;
	}

	@Override
	public MurmurObject opPositive() {
		// Strings don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opNegative() {
		// Strings don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIncrement() {
		// Strings don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDecrement() {
		// Strings don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		// Strings don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		// Strings don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		// Strings don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		// Strings don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		// Strings don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		// Strings don't support bitshift.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		// Strings don't support bitshift.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		// Strings don't support inequality.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		// Strings don't support inequality.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		// Strings don't support inequality.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		// Strings don't support inequality.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == STRING) {
			return MurmurBoolean.create(
					value.equals(((MurmurString)other).value));
		}
		
		// Not equal.
		return MurmurBoolean.FALSE;
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == STRING) {
			return MurmurBoolean.create(!
					value.equals(((MurmurString)other).value));
		}
		
		// Not equal.
		return MurmurBoolean.TRUE;
	}

	@Override
	public MurmurObject opBitNot() {
		// Strings don't support bit arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		// Strings don't support bit arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		// Strings don't support bit arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		// Strings don't support bit arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalNot() {
		// Strings don't support boolean arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalAnd(MurmurObject other) {
		// Strings don't support boolean arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalOr(MurmurObject other) {
		// Strings don't support boolean arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIndex(MurmurObject other) {
		// Strings don't support array indexing.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opConcat(MurmurObject other) {
		// Convert to string and do concat.
		MurmurString string = other.asString();
		return MurmurString.create(value + string.value);
	}

	@Override
	public String toString() {
		return "MurmurString{value=" + value + '}';
	}
	
}

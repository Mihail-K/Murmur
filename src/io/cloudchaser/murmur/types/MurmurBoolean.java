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

import static io.cloudchaser.murmur.types.MurmurType.BOOLEAN;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurBoolean extends MurmurObject {
	
	public static final MurmurBoolean TRUE = new MurmurBoolean(true);
	public static final MurmurBoolean FALSE = new MurmurBoolean(false);
	
	private final boolean value;

	private MurmurBoolean(boolean value) {
		super(BOOLEAN);
		this.value = value;
	}
	
	/**
	 * Converts a Java boolean into a Murmur boolean.
	 * 
	 * @param value The Java boolean value.
	 * @return The murmur boolean value.
	 */
	public static MurmurBoolean create(boolean value) {
		return value ? TRUE : FALSE;
	}
	
	public boolean getValue() {
		return value;
	}

	@Override
	public MurmurInteger asInteger() {
		return MurmurInteger.create(value ? 1 : 0);
	}
	
	@Override
	public MurmurString asString() {
		return new MurmurString(Boolean.toString(value));
	}

	@Override
	public MurmurObject opPositive() {
		// Booleans don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opNegative() {
		// Booleans don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIncrement() {
		// Booleans don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDecrement() {
		// Booleans don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		// Booleans don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		// Booleans don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		// Booleans don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		// Booleans don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		// Booleans don't support integer arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		// Booleans don't support bitshift.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		// Booleans don't support bitshift.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		// Booleans don't support inequality.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		// Booleans don't support inequality.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		// Booleans don't support inequality.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		// Booleans don't support inequality.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == BOOLEAN) {
			return create(value == ((MurmurBoolean)other).value);
		}
		
		// Not equal.
		return FALSE;
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == BOOLEAN) {
			return create(value != ((MurmurBoolean)other).value);
		}
		
		// Not equal.
		return TRUE;
	}

	@Override
	public MurmurObject opBitNot() {
		return create(!value);
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == BOOLEAN) {
			return create(value & ((MurmurBoolean)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == BOOLEAN) {
			return create(value ^ ((MurmurBoolean)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == BOOLEAN) {
			return create(value | ((MurmurBoolean)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalNot() {
		return create(!value);
	}

	@Override
	public MurmurObject opLogicalAnd(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == BOOLEAN) {
			return create(value && ((MurmurBoolean)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalOr(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == BOOLEAN) {
			return create(value || ((MurmurBoolean)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIndex(MurmurObject other) {
		// Booleans don't support array indexing.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opPlusAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinusAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiplyAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivideAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModuloAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitAndAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitXorAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitOrAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftLeftAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftRightAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opConcatAssign(MurmurObject other) {
		// Unused. Boolean values are immutable.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opConcat(MurmurObject other) {
		// Unsupported.
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int hashCode() {
		return Boolean.hashCode(value);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof MurmurBoolean)) return false;
		return ((MurmurBoolean)o).value == value;
	}

	@Override
	public String toString() {
		return "MurmurBoolean{" + "value=" + value + '}';
	}
	
}

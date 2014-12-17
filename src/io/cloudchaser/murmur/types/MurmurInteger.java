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

import static io.cloudchaser.murmur.types.MurmurType.INTEGER;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurInteger extends MurmurObject {
	
	/**
	 * Singleton constant for integer zero.
	 */
	public static final MurmurInteger ZERO = new MurmurInteger(0);
	
	private final long value;

	private MurmurInteger(long value) {
		super(INTEGER);
		this.value = value;
	}
	
	/**
	 * Creates an integer from a Java long value.
	 * If the value is 0, the singleton ZERO is returned instead.
	 * 
	 * @param value The value for the integer.
	 * @return The murmur integer value.
	 */
	public static MurmurInteger create(long value) {
		if(value == 0) return ZERO;
		return new MurmurInteger(value);
	}

	public long getValue() {
		return value;
	}

	@Override
	public MurmurInteger asInteger() {
		return this;
	}

	@Override
	public MurmurString asString() {
		return new MurmurString(Long.toString(value));
	}

	@Override
	public MurmurObject opPositive() {
		return create(+value);
	}

	@Override
	public MurmurObject opNegative() {
		return create(-value);
	}

	@Override
	public MurmurObject opIncrement() {
		return create(value + 1);
	}

	@Override
	public MurmurObject opDecrement() {
		return create(value - 1);
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value + ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value - ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value * ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value / ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value % ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value << ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value >> ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			boolean result = value < ((MurmurInteger)other).value;
			return result ? MurmurBoolean.TRUE : MurmurBoolean.FALSE;
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			boolean result = value > ((MurmurInteger)other).value;
			return result ? MurmurBoolean.TRUE : MurmurBoolean.FALSE;
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			boolean result = value <= ((MurmurInteger)other).value;
			return result ? MurmurBoolean.TRUE : MurmurBoolean.FALSE;
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			boolean result = value >= ((MurmurInteger)other).value;
			return result ? MurmurBoolean.TRUE : MurmurBoolean.FALSE;
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			boolean result = value == ((MurmurInteger)other).value;
			return result ? MurmurBoolean.TRUE : MurmurBoolean.FALSE;
		}
		
		// Not equal.
		return MurmurBoolean.FALSE;
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			boolean result = value != ((MurmurInteger)other).value;
			return result ? MurmurBoolean.TRUE : MurmurBoolean.FALSE;
		}
		
		// Not equal.
		return MurmurBoolean.TRUE;
	}

	@Override
	public MurmurObject opBitNot() {
		return create(~value);
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value & ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value ^ ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			return create(value | ((MurmurInteger)other).value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalNot() {
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalAnd(MurmurObject other) {
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalOr(MurmurObject other) {
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIndex(MurmurObject other) {
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opConcat(MurmurObject other) {
		// Unsupported.
		throw new UnsupportedOperationException();
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(value);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof MurmurInteger)) return false;
		return ((MurmurInteger)o).value == value;
	}

	@Override
	public String toString() {
		return "MurmurInteger{" + "value=" + value + '}';
	}
	
}

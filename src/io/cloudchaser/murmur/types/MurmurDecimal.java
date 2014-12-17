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

import static io.cloudchaser.murmur.types.MurmurType.DECIMAL;
import static io.cloudchaser.murmur.types.MurmurType.INTEGER;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class MurmurDecimal extends MurmurObject {
	
	/**
	 * Singleton constant for decimal zero.
	 */
	public static final MurmurDecimal ZERO = new MurmurDecimal(0);
	
	private final double value;

	private MurmurDecimal(double value) {
		super(DECIMAL);
		this.value = value;
	}
	
	/**
	 * Creates an decimal from a Java double value.
	 * If the value is 0, the singleton ZERO is returned instead.
	 * 
	 * @param value The value for the decimal.
	 * @return The murmur decimal value.
	 */
	public static MurmurDecimal create(double value) {
		if(value == 0) return ZERO;
		return new MurmurDecimal(value);
	}

	public double getValue() {
		return value;
	}

	@Override
	public MurmurInteger asInteger() {
		return MurmurInteger.create((long)value);
	}

	@Override
	public MurmurDecimal asDecimal() {
		return this;
	}

	@Override
	public MurmurString asString() {
		return new MurmurString(Double.toString(value));
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
		if(other.getType() == DECIMAL) {
			return create(value + ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return create(value + other.asDecimal().value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return create(value - ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return create(value - other.asDecimal().value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return create(value * ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return create(value * other.asDecimal().value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return create(value / ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return create(value / other.asDecimal().value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return create(value % ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return create(value % other.asDecimal().value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		// Decimal don't support bitshift.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		// Decimal don't support bitshift.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return MurmurBoolean.create(value < ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return MurmurBoolean.create(value < other.asDecimal().value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return MurmurBoolean.create(value > ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return MurmurBoolean.create(value > other.asDecimal().value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return MurmurBoolean.create(value <= ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return MurmurBoolean.create(value <= other.asDecimal().value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return MurmurBoolean.create(value >= ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return MurmurBoolean.create(value >= other.asDecimal().value);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return MurmurBoolean.create(value == ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return MurmurBoolean.create(value == other.asDecimal().value);
		}
		
		// Not equal.
		return MurmurBoolean.FALSE;
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == DECIMAL) {
			return MurmurBoolean.create(value != ((MurmurDecimal)other).value);
		} else if(other.getType() == INTEGER) {
			return MurmurBoolean.create(value != other.asDecimal().value);
		}
		
		// Not equal.
		return MurmurBoolean.TRUE;
	}

	@Override
	public MurmurObject opBitNot() {
		// Decimal don't support bit arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		// Decimal don't support bit arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		// Decimal don't support bit arithmetic.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		// Decimal don't support bit arithmetic.
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
		return Double.hashCode(value);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof MurmurDecimal)) return false;
		return ((MurmurDecimal)o).value == value;
	}

	@Override
	public String toString() {
		return "MurmurDecimal{value=" + value + '}';
	}
	
}

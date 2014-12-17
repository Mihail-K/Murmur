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

import static io.cloudchaser.murmur.types.MurmurType.CHARACTER;
import static io.cloudchaser.murmur.types.MurmurType.DECIMAL;
import static io.cloudchaser.murmur.types.MurmurType.INTEGER;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class MurmurCharacter extends MurmurObject {
	
	private final char value;

	public MurmurCharacter(int value) {
		super(CHARACTER);
		this.value = (char)value;
	}

	public long getValue() {
		return value;
	}

	@Override
	public MurmurInteger asInteger() {
		return MurmurInteger.create(value);
	}

	@Override
	public MurmurDecimal asDecimal() {
		return MurmurDecimal.create(value);
	}

	@Override
	public MurmurString asString() {
		return new MurmurString(Character.toString(value));
	}

	@Override
	public MurmurObject opPositive() {
		return new MurmurCharacter(+value);
	}

	@Override
	public MurmurObject opNegative() {
		return new MurmurCharacter(-value);
	}

	@Override
	public MurmurObject opIncrement() {
		return new MurmurCharacter(value + 1);
	}

	@Override
	public MurmurObject opDecrement() {
		return new MurmurCharacter(value - 1);
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value + ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opPlus(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opPlus(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value - ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opMinus(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opMinus(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value * ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opMultiply(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opMultiply(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value / ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opDivide(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opDivide(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value % ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opModulo(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opModulo(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value << ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opShiftLeft(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value >> ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opShiftRight(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return MurmurBoolean.create(
					value < ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opLessThan(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opLessThan(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return MurmurBoolean.create(
					value > ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opGreaterThan(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opGreaterThan(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return MurmurBoolean.create(
					value <= ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opLessOrEqual(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opLessOrEqual(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return MurmurBoolean.create(
					value >= ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opGreaterOrEqual(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opGreaterOrEqual(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return MurmurBoolean.create(
					value == ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opEquals(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opEquals(other);
		}
		
		// Not equal.
		return MurmurBoolean.FALSE;
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return MurmurBoolean.create(
					value != ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opNotEquals(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opNotEquals(other);
		}
		
		// Not equal.
		return MurmurBoolean.TRUE;
	}

	@Override
	public MurmurObject opBitNot() {
		return new MurmurCharacter(~value);
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value & ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opBitAnd(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opBitAnd(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value ^ ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opBitXor(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opBitXor(other);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == CHARACTER) {
			return new MurmurCharacter(
					value | ((MurmurCharacter)other).value);
		} else if(other.getType() == INTEGER) {
			return asInteger().opBitOr(other);
		} else if(other.getType() == DECIMAL) {
			return asDecimal().opBitOr(other);
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
		if(!(o instanceof MurmurCharacter)) return false;
		return ((MurmurCharacter)o).value == value;
	}

	@Override
	public String toString() {
		return "MurmurChararcter{value=" + value + '}';
	}
	
}

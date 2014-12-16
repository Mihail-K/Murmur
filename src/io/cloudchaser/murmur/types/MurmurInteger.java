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

	public MurmurInteger(long value) {
		super(INTEGER);
		this.value = value;
	}

	public long getValue() {
		return value;
	}

	@Override
	public MurmurInteger asInteger() {
		return this;
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			long result = value + ((MurmurInteger)other).value;
			if(result == 0) return ZERO;
			return new MurmurInteger(result);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			long result = value - ((MurmurInteger)other).value;
			if(result == 0) return ZERO;
			return new MurmurInteger(result);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			long result = value * ((MurmurInteger)other).value;
			if(result == 0) return ZERO;
			return new MurmurInteger(result);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			long result = value / ((MurmurInteger)other).value;
			if(result == 0) return ZERO;
			return new MurmurInteger(result);
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		// Check for supported operation.
		if(other.getType() == INTEGER) {
			long result = value % ((MurmurInteger)other).value;
			if(result == 0) return ZERO;
			return new MurmurInteger(result);
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
	public String toString() {
		return "MurmurInteger{" + "value=" + value + '}';
	}
	
}

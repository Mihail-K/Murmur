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
public final class MurmurNull extends MurmurObject {
	
	/**
	 * Singleton murmur NULL value.
	 */
	public static final MurmurNull NULL = new MurmurNull();

	private MurmurNull() {
		super(MurmurType.NULL);
	}
	
	@Override
	public boolean isCompatible(Class<?> type) {
		return !type.isPrimitive();
	}
	
	@Override
	public Object getAsJavaType(Class<?> type) {
		if(!type.isPrimitive()) {
			return null;
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
		return MurmurString.create("null");
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		return MurmurBoolean.create(other.getType() == MurmurType.NULL);
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		return MurmurBoolean.create(other.getType() != MurmurType.NULL);
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof MurmurNull;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		return "MurmurNull{ }";
	}
	
}

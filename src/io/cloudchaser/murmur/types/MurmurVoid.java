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
public class MurmurVoid extends MurmurObject {
	
	/**
	 * Singleton murmur void value.
	 */
	public static final MurmurVoid VOID = new MurmurVoid();

	private MurmurVoid() {
		super(MurmurType.VOID);
	}

	@Override
	public MurmurInteger asInteger() {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurDecimal asDecimal() {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}
	
	@Override
	public MurmurString asString() {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opPositive() {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opNegative() {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIncrement() {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDecrement() {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitNot() {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalNot() {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalAnd(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalOr(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIndex(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opConcat(MurmurObject other) {
		// Cannot operate on void.
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof MurmurVoid;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		return "MurmurVoid{ }";
	}
	
}

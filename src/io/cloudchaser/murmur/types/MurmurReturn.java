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
 */
public class MurmurReturn extends MurmurObject {
	
	/**
	 * Wrapped return value.
	 */
	private final MurmurObject value;

	public MurmurReturn(MurmurObject value) {
		super(null);
		this.value = value;
	}

	public MurmurObject getValue() {
		return value;
	}

	@Override
	public MurmurType getType() {
		return value.getType();
	}

	@Override
	public MurmurInteger asInteger() {
		return value.asInteger();
	}

	@Override
	public MurmurDecimal asDecimal() {
		return value.asDecimal();
	}

	@Override
	public MurmurString asString() {
		return value.asString();
	}

	@Override
	public MurmurObject opPositive() {
		return value.opPositive();
	}

	@Override
	public MurmurObject opNegative() {
		return value.opNegative();
	}

	@Override
	public MurmurObject opIncrement() {
		return value.opIncrement();
	}

	@Override
	public MurmurObject opDecrement() {
		return value.opDecrement();
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		return value.opPlus(other);
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		return value.opMinus(other);
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		return value.opMultiply(other);
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		return value.opDivide(other);
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		return value.opModulo(other);
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		return value.opShiftLeft(other);
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		return value.opShiftRight(other);
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		return value.opLessThan(other);
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		return value.opGreaterThan(other);
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		return value.opLessOrEqual(other);
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		return value.opGreaterOrEqual(other);
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		return value.opEquals(other);
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		return value.opNotEquals(other);
	}

	@Override
	public MurmurObject opBitNot() {
		return value.opBitNot();
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		return value.opBitAnd(other);
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		return value.opBitXor(other);
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		return value.opBitOr(other);
	}

	@Override
	public MurmurObject opLogicalNot() {
		return value.opLogicalNot();
	}

	@Override
	public MurmurObject opLogicalAnd(MurmurObject other) {
		return value.opLogicalAnd(other);
	}

	@Override
	public MurmurObject opLogicalOr(MurmurObject other) {
		return value.opLogicalOr(other);
	}

	@Override
	public MurmurObject opIndex(MurmurObject other) {
		return value.opIndex(other);
	}

	@Override
	public MurmurObject opConcat(MurmurObject other) {
		return value.opConcat(other);
	}

	@Override
	public String toString() {
		return "MurmurReturn{" + "value=" + value + '}';
	}
	
}

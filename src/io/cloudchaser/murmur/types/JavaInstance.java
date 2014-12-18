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

import static io.cloudchaser.murmur.types.MurmurType.OBJECT;
import java.lang.reflect.Field;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class JavaInstance extends JavaObject {
	
	/**
	 * Stores the Java object instance.
	 */
	private final Object instance;
	
	/**
	 * The Java class object corresponding to this instance.
	 */
	private final Class<?> type;

	public JavaInstance(Object instance, Class<?> type) {
		super(OBJECT);
		this.type = type;
		this.instance = instance;
	}

	public Object getInstance() {
		return instance;
	}

	public Class<?> getInstanceType() {
		return type;
	}
	
	@Override
	public JavaMember getMember(String name) {
		try {
			// Check if this is a static field.
			Field field = type.getField(name);
			return new JavaMember(name, field.getType(), field.get(instance));
		} catch (NoSuchFieldException | SecurityException |
				IllegalArgumentException | IllegalAccessException ex) {
			// Assume this is a static method.
			return new JavaMember(name, type, instance);
		}
	}
	
	@Override
	public Object toJavaObject() {
		return instance;
	}

	@Override
	public boolean isCompatible(Class<?> type) {
		return type.isAssignableFrom(this.type) ||
				type.isAssignableFrom(
						JavaTypeUtils.getPrimitive(type));
	}

	@Override
	public Object getAsJavaType(Class<?> type) {
		// Java object type.
		if(type.isAssignableFrom(type)) {
			return instance;
		}
		
		// Java primitive type.
		if(type.isAssignableFrom(
				JavaTypeUtils.getPrimitive(type))) {
			return instance;
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurInteger asInteger() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurDecimal asDecimal() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurString asString() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opPositive() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opNegative() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opIncrement() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opDecrement() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opBitNot() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opLogicalNot() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opLogicalAnd(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opLogicalOr(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opIndex(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opConcat(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}

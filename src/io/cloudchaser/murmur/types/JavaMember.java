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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class JavaMember extends JavaObject
		implements JavaInvokableType {

	private final String name;
	private final Class<?> type;
	private final Object instance;
	
	public JavaMember(String name, Class<?> type) {
		this(name, type, null);
	}

	public JavaMember(String name, Class<?> type, Object instance) {
		super(OBJECT);
		this.name = name;
		this.type = type;
		this.instance = instance;
	}

	@Override
	public MurmurObject getMember(String name) {
		try {
			// Check if this is a field.
			Field field = type.getField(name);
			return new JavaMember(name, field.getType(), field.get(instance));
		} catch (NoSuchFieldException | SecurityException |
				IllegalArgumentException | IllegalAccessException ex) {
			// Assume this is a method.
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
		return MurmurInteger.ZERO;
	}

	@Override
	public MurmurDecimal asDecimal() {
		return MurmurDecimal.ZERO;
	}

	@Override
	public MurmurString asString() {
		return new MurmurString(name);
	}

	@Override
	public MurmurObject opPositive() {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opNegative() {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIncrement() {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDecrement() {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		return MurmurBoolean.create(this == other);
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		return MurmurBoolean.create(this != other);
	}

	@Override
	public MurmurObject opBitNot() {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalNot() {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalAnd(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalOr(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIndex(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opConcat(MurmurObject other) {
		// Cannot operate on Java functions.
		throw new UnsupportedOperationException();
	}
	
	@Override
	public MurmurObject opInvoke(MurmurObject argument) {
		try {
			// TODO
			if(argument == null) {
				// No arguments.
				Method method = type.getMethod(name);
				method.invoke(instance);
				return MurmurNull.NULL;
			} else {
				// Void and Object type not allowed.
				if(argument instanceof MurmurVoid ||
						argument instanceof MurmurFunction ||
						argument instanceof MurmurInstance ||
						argument instanceof MurmurComponent) {
					throw new UnsupportedOperationException();
				}
				
				// Search for a compatible method.
				for(Method method : type.getMethods()) {
					// Filter compatible method signature.
					if(!method.getName().equals(name)) continue;
					if(method.getParameterCount() != 1) continue;
					
					// Fetch the parameter type.
					Class<?> param = method.getParameterTypes()[0];
					if(argument.isCompatible(param)) {
						// Convert parameter and invoke function.
						method.invoke(instance, argument.getAsJavaType(param));
						return MurmurNull.NULL;
					}
				}
				
				// TODO
				throw new UnsupportedOperationException();
			}
		} catch(IllegalAccessException | IllegalArgumentException |
				InvocationTargetException | NoSuchMethodException |
				SecurityException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public String toString() {
		return "JavaMember{name=" + name + ", type=" + type +
				", instance=" + instance + '}';
	}
	
}

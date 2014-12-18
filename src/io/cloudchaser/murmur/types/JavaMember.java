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
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class JavaMember extends MurmurObject
		implements JavaInvokableType {

	private final String name;
	private final Class<?> type;
	private final Object instance;

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
	
	private Class<?> getPrimitive(Class<?> wrapper) {
		if(wrapper == Long.class)		return long.class;
		if(wrapper == Integer.class)	return int.class;
		if(wrapper == Short.class)		return short.class;
		if(wrapper == Byte.class)		return byte.class;
		if(wrapper == Character.class)	return char.class;
		if(wrapper == Double.class)		return double.class;
		if(wrapper == Float.class)		return float.class;
		if(wrapper == Boolean.class)	return boolean.class;
		return wrapper;
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
						argument instanceof MurmurInstance ||
						argument instanceof MurmurComponent) {
					throw new UnsupportedOperationException();
				}
				
				Object object = argument.toJavaObject();
				for(Method method : type.getMethods()) {
					// Filter compatible method signature.
					if(!method.getName().equals(name)) continue;
					if(method.getParameterCount() != 1) continue;
					
					// Check if this is a Java argument.
					if(argument instanceof JavaInstance ||
							argument instanceof JavaMember ||
							argument instanceof JavaClass) {
						// Invoke a compatible method.
						if(method.getParameterTypes()[0].isAssignableFrom(object.getClass()) ||
								method.getParameterTypes()[0].isAssignableFrom(
										getPrimitive(object.getClass()))) {
							method.invoke(instance, object);
							return MurmurNull.NULL;
						}
					} else {
						// Murmur argument types.
						if(argument instanceof MurmurNull) {
							if(!method.getParameterTypes()[0].isPrimitive())
								method.invoke(instance, (Object)null);
							return MurmurNull.NULL;
						} 
						
						// Murmur String argument.
						if(argument instanceof MurmurString) {
							if(method.getParameterTypes()[0].isAssignableFrom(String.class))
								method.invoke(instance, object);
							else continue;
							return MurmurNull.NULL;
						}
						
						// Murmur boolean argument.
						if(argument instanceof MurmurBoolean) {
							if(method.getParameterTypes()[0].isAssignableFrom(boolean.class) ||
									method.getParameterTypes()[0].isAssignableFrom(Boolean.class))
								method.invoke(instance, object);
							else continue;
							return MurmurNull.NULL;
						}
						
						// Murmur integer argument.
						if(argument instanceof MurmurInteger) {
							if(method.getParameterTypes()[0].isAssignableFrom(long.class) ||
									method.getParameterTypes()[0].isAssignableFrom(Long.class))
								method.invoke(instance, object);
							else if(method.getParameterTypes()[0].isAssignableFrom(int.class) ||
									method.getParameterTypes()[0].isAssignableFrom(Integer.class))
								method.invoke(instance, (int)object);
							else if(method.getParameterTypes()[0].isAssignableFrom(short.class) ||
									method.getParameterTypes()[0].isAssignableFrom(Short.class))
								method.invoke(instance, (short)object);
							else if(method.getParameterTypes()[0].isAssignableFrom(byte.class) ||
									method.getParameterTypes()[0].isAssignableFrom(Byte.class))
								method.invoke(instance, (byte)object);
							else continue;
							return MurmurNull.NULL;
						}
						
						// Murmur decimal argument.
						if(argument instanceof MurmurDecimal) {
							if(method.getParameterTypes()[0].isAssignableFrom(double.class) ||
									method.getParameterTypes()[0].isAssignableFrom(Double.class))
								method.invoke(instance, object);
							else if(method.getParameterTypes()[0].isAssignableFrom(float.class) ||
									method.getParameterTypes()[0].isAssignableFrom(Float.class))
								method.invoke(instance, (float)object);
							else continue;
							return MurmurNull.NULL;
						}
						
						// Murmur character argument.
						if(argument instanceof MurmurCharacter) {
							if(method.getParameterTypes()[0].isAssignableFrom(char.class) ||
									method.getParameterTypes()[0].isAssignableFrom(Character.class))
								method.invoke(instance, object);
							else continue;
							return MurmurNull.NULL;
						}
						
						// Murmur array argument.
						if(argument instanceof MurmurArray) {
							if(method.getParameterTypes()[0].isAssignableFrom(List.class))
								method.invoke(instance, object);
							if(method.getParameterTypes()[0].isAssignableFrom(Object[].class))
								method.invoke(instance, Arrays.asList((Object[])object));
							else continue;
							return MurmurNull.NULL;
						}
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

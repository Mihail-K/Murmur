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

import static io.cloudchaser.murmur.types.JavaTypeUtils.invokeFunction;
import static io.cloudchaser.murmur.types.MurmurType.OBJECT;
import java.lang.reflect.Field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

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
	public MurmurString asString() {
		return MurmurString.create(name);
	}
	
	@Override
	public MurmurObject opInvoke(List<MurmurObject> arguments) {
		try {
			// Build a parameter list and invoke the function.
			return invokeFunction(name, type, instance, arguments);
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

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

import static io.cloudchaser.murmur.types.JavaTypeUtils.invokeConstructor;
import static io.cloudchaser.murmur.types.MurmurType.TYPE;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class JavaClass extends JavaObject
		implements JavaInvokableType {
	
	private final Class<?> javaClass;

	public JavaClass(Class<?> javaClass) {
		super(TYPE);
		this.javaClass = javaClass;
	}
	
	public Class<?> getJavaClass() {
		return javaClass;
	}

	@Override
	public MurmurObject getMember(String name) {
		try {
			// Check if this is a static field.
			Field field = javaClass.getField(name);
			return new JavaMember(name, field.getType(), field.get(null));
		} catch (NoSuchFieldException | SecurityException |
				IllegalArgumentException | IllegalAccessException ex) {
			// Assume this is a static method.
			return new JavaMember(name, javaClass);
		}
	}

	@Override
	public boolean isCompatible(Class<?> type) {
		return type.isAssignableFrom(Class.class);
	}

	@Override
	public Object getAsJavaType(Class<?> type) {
		// Java meta class object.
		if(type.isAssignableFrom(Class.class)) {
			return javaClass;
		}
		
		// Unsupported.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurString asString() {
		return MurmurString.create("type");
	}
	
	@Override
	public MurmurObject opInvoke(List<MurmurObject> arguments) {
		try {
			return invokeConstructor(javaClass, arguments);
		} catch(IllegalAccessException | IllegalArgumentException |
				InvocationTargetException| InstantiationException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public String toString() {
		return "JavaClass{javaClass=" + javaClass + '}';
	}
	
}

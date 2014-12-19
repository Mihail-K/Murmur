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

package io.cloudchaser.murmur.types.java;

import io.cloudchaser.murmur.types.MurmurBoolean;
import io.cloudchaser.murmur.types.MurmurCharacter;
import io.cloudchaser.murmur.types.MurmurDecimal;
import io.cloudchaser.murmur.types.MurmurInteger;
import io.cloudchaser.murmur.types.MurmurNull;
import io.cloudchaser.murmur.types.MurmurObject;
import io.cloudchaser.murmur.types.MurmurString;
import io.cloudchaser.murmur.types.MurmurVoid;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public final class JavaTypeUtils {
	
	private static class VarArgsBuilder {
		
		private int varIndex = 0;
		private final Object varArgs;

		public VarArgsBuilder(Class<?> type, int count) {
			varArgs = Array.newInstance(type, count);
		}
		
		public Object getVarArgs() {
			return varArgs;
		}
		
		public void addVarArg(Object value) {
			Array.set(varArgs, varIndex++, value);
		}
		
	}
	
	/**
	 * Maps Java primitive wrapper types to their primitive class.
	 * 
	 * @param wrapper The wrapper class to map.
	 * @return The corresponding primitive class.
	 **/
	public static Class<?> getPrimitive(Class<?> wrapper) {
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
	
	public static MurmurObject getAsMurmurObject(Object object) {
		// Check for null.
		if(object == null) {
			return MurmurNull.NULL;
		}
		
		// Check for Murmur Object.
		if(object instanceof MurmurObject) {
			return (MurmurObject)object;
		}
		
		// Check for String.
		if(object instanceof String) {
			return MurmurString.create(object.toString());
		}
		
		// Check for boolean.
		if(MurmurBoolean.TRUE.isCompatible(object.getClass())) {
			return MurmurBoolean.create((boolean)object);
		}
		
		// Check for integer.
		if(MurmurInteger.ZERO.isCompatible(object.getClass())) {
			return MurmurInteger.create((long)object);
		}
		
		// Check for decimal.
		if(MurmurDecimal.ZERO.isCompatible(object.getClass())) {
			return MurmurDecimal.create((long)object);
		}
		
		// Check for character.
		if(object.getClass().isAssignableFrom(char.class) ||
				object.getClass().isAssignableFrom(Character.class)) {
			return new MurmurCharacter((char)object);
		}
		
		// Check for array.
		if(object.getClass().isArray() || object instanceof List) {
			// TODO
			throw new UnsupportedOperationException();
		}
		
		// Wrap the Java object.
		return new JavaInstance(object, object.getClass());
	}
	
	/**
	 * Invokes a Java language function with Murmur arguments.
	 * 
	 * @param name
	 * @param type
	 * @param instance
	 * @param args
	 * @return 
	 * @throws java.lang.IllegalAccessException 
	 * @throws java.lang.reflect.InvocationTargetException 
	 * @throws java.lang.NoSuchMethodException 
	 */
	public static MurmurObject invokeFunction(
			String name, Class<?> type,
			Object instance, List<MurmurObject> args) throws
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException {
		// No-argument case.
		if(args == null || args.isEmpty()) {
			Method method = type.getMethod(name);
			Object object = method.invoke(instance);
			
			// Check if the method has no return value.
			if(method.getReturnType().equals(void.class) ||
					method.getReturnType().equals(Void.class)) {
				return MurmurVoid.VOID;
			}
			
			// Convert and return the value.
			return getAsMurmurObject(object);
		}
		
		// Allocate an argument list.
		VarArgsBuilder vaBuilder = null;
		List<Object> params = new ArrayList<>();
		
		// Search for a matching method.
ML:		for(Method method : type.getMethods()) {
			// Filter a matching method signature.
			if(!method.getName().equals(name)) continue;
			if(method.getParameterCount() != args.size() &&
					!method.isVarArgs()) continue;
			
			for(int idx = 0; idx < args.size(); idx++) {
				// Fetch the parameter type.
				Parameter param = method.getParameters()[idx];
				
				// Var Args.
				if(param.isVarArgs()) {
					// Check against the array subtype.
					if(!args.get(idx).isCompatible(
							param.getType().getComponentType())) {
						// Incompatible argument type.
						continue ML;
					}
				
					// Create a varargs list.
					if(vaBuilder == null) {
						vaBuilder = new VarArgsBuilder(
								param.getType().getComponentType(),
								args.size() - idx);
					}
					
					// Perform conversion and add the vararg.
					Object object = args.get(idx).getAsJavaType(
							param.getType().getComponentType());
					vaBuilder.addVarArg(object);
				} else {
					if(!args.get(idx).isCompatible(param.getType())) {
						// Incompatible argument type.
						continue ML;
					}
				
					// Perform the conversion.
					params.add(args.get(idx).getAsJavaType(
							param.getType()));
				}
			}
			
			// Check for varargs.
			if(vaBuilder != null) {
				// Append the var args list.
				params.add(vaBuilder.getVarArgs());
			}
			
			// Invoke the function.
			Object object = method.invoke(instance, params.toArray());
			
			// Check if the method has no return value.
			if(method.getReturnType().equals(void.class) ||
					method.getReturnType().equals(Void.class)) {
				return MurmurVoid.VOID;
			}
			
			// Convert and return the value.
			return getAsMurmurObject(object);
		}

		// Method not found.
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Invokes a Java language constructor with Murmur arguments.
	 * 
	 * @param type
	 * @param args
	 * @return 
	 * @throws java.lang.IllegalAccessException 
	 * @throws java.lang.reflect.InvocationTargetException 
	 * @throws java.lang.InstantiationException 
	 */
	public static MurmurObject invokeConstructor(
			Class<?> type, List<MurmurObject> args) throws
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException {
		// No-arguments case.
		if(args == null || args.isEmpty()) {
			return new JavaInstance(type.newInstance(), type);
		}
		
		// Allocate an argument list.
		VarArgsBuilder vaBuilder = null;
		List<Object> params = new ArrayList<>();
		
		// Search for a matching method.
ML:		for(Constructor constructor : type.getConstructors()) {
			// Filter a matching method signature.
			if(constructor.getParameterCount() != args.size() &&
					!constructor.isVarArgs()) continue;
			
			for(int idx = 0; idx < args.size(); idx++) {
				// Fetch the parameter type.
				Parameter param = constructor.getParameters()[idx];
				
				// Var Args.
				if(param.isVarArgs()) {
					// Check against the array subtype.
					if(!args.get(idx).isCompatible(
							param.getType().getComponentType())) {
						// Incompatible argument type.
						continue ML;
					}
				
					// Create a varargs list.
					if(vaBuilder == null) {
						vaBuilder = new VarArgsBuilder(
								param.getType().getComponentType(),
								args.size() - idx);
					}
					
					// Perform conversion and add the vararg.
					Object object = args.get(idx).getAsJavaType(
							param.getType().getComponentType());
					vaBuilder.addVarArg(object);
				} else {
					if(!args.get(idx).isCompatible(param.getType())) {
						// Incompatible argument type.
						continue ML;
					}
				
					// Perform the conversion.
					params.add(args.get(idx).getAsJavaType(
							param.getType()));
				}
			}
			
			// Check for varargs.
			if(vaBuilder != null) {
				// Append the var args list.
				params.add(vaBuilder.getVarArgs());
			}
			
			// Invoke the constructor and return the result.
			Object object = constructor.newInstance(params.toArray());
			return new JavaInstance(object, type);
		}

		// Method not found.
		throw new UnsupportedOperationException();
	}
	
}

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

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public final class JavaTypeUtils {
	
	/**
	 * Maps Java primitive wrapper type to their primitive class.
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
	
}

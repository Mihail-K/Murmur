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

import static io.cloudchaser.murmur.types.MurmurType.FUNCTION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class JavaFunction extends MurmurObject
		implements JavaInvokableType {
	
	private final Method method;
	private final Object instance;

	public JavaFunction(Method method, Object instance) {
		super(FUNCTION);
		this.method = method;
		this.instance = instance;
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
		return new MurmurString("function");
	}

	@Override
	public MurmurObject opPositive() {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opNegative() {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIncrement() {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDecrement() {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMinus(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opMultiply(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opDivide(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opModulo(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftLeft(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opShiftRight(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessThan(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterThan(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLessOrEqual(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opGreaterOrEqual(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
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
	public MurmurObject opBitNot() {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitAnd(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitXor(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opBitOr(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalNot() {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalAnd(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opLogicalOr(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opIndex(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurObject opConcat(MurmurObject other) {
		// Cannot operate on null.
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Build a Java language compatible argument list.
	 * 
	 * @param args The murmur argument list.
	 * @return A java argument list.
	 **/
	private Object[] buildArgumentList(List<MurmurObject> args) {
		// Validate parameter count.
		if(method.getParameterCount() != args.size() &&
				!method.isVarArgs()) {
			throw new RuntimeException();
		}
		
		// Handle no-args case.
		if(args.isEmpty()) {
			return null;
		}
		
		// Perform parameter mapping.
		Parameter[] params = method.getParameters();
		Object[] javaArgs = new Object[args.size()];
		for(int idx = 0; idx < javaArgs.length; idx++) {
			// Check if the parameter expects a murmur type.
			if(params[idx].getType().isAssignableFrom(MurmurObject.class)) {
				// Convert the element to a Java object.
				javaArgs[idx] = args.get(idx).toJavaObject();
			} else {
				// Assign the argument, as-is.
				javaArgs[idx] = args.get(idx);
			}
		}
		
		// Return the converted arguments.
		return javaArgs;
	}

	@Override
	public MurmurObject opInvoke(List<MurmurObject> args) {
		try {
			// TODO
			method.invoke(instance, buildArgumentList(args));
			return null;
		} catch(IllegalAccessException | IllegalArgumentException |
				InvocationTargetException ex) {
			Logger.getLogger(JavaFunction.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}
	
}

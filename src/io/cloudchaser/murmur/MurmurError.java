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

package io.cloudchaser.murmur;

import io.cloudchaser.murmur.types.InvokableType;
import java.util.Deque;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurError extends Error {
	
	public static final String INTERNAL_ERROR =
			"Murmur was expecting input here, but didn't find what it was looking for. (Internal error)";
	public static final String NOT_A_VALUE =
			"The right side of this expression does not produce a value.";
	public static final String NOT_A_BOOLEAN =
			"Murmur expected a boolean value here, but got something else.";
	public static final String NOT_A_FUNCTION =
			"Murmur expected a function or lambda here, but got something else.";
	public static final String SYMBOL_NOT_FOUND =
			"Murmur couldn't find the referenced symbol in this context.";
	
	public static final String JAVA_CLASS_NOT_FOUND =
			"Murmur couldn't find the referenced Java class or type.";
	
	/**
	 * The file the error originated in.
	 */
	private String file;
	
	/**
	 * The line number of the error.
	 */
	private int lineNumber;
	
	/**
	 * The text on the line of the error.
	 */
	private String lineText;
	
	/**
	 * The call stack at the time of the error.
	 */
	private Deque<InvokableType> callStack;

	public MurmurError() {
	}

	public MurmurError(String string) {
		super(string);
	}

	public MurmurError(String string, Throwable thrwbl) {
		super(string, thrwbl);
	}

	public MurmurError(Throwable thrwbl) {
		super(thrwbl);
	}
	
	/**
	 * Creates a Murmur Error with line information and a message.
	 * 
	 * @param lineNumber The line number the error occurred on.
	 * @param lineText A text snippet related to the error.
	 * @param message A message with details on the error.
	 * @return The Murmur error object.
	 */
	public static MurmurError create(
			int lineNumber, String lineText, String message) {
		MurmurError error = new MurmurError(message);
		error.setLineNumber(lineNumber);
		error.setLineText(lineText);
		return error;
	}
	
	/**
	 * Wraps a Throwable, including line information and a message.
	 * 
	 * @param lineNumber The line number the error occurred on.
	 * @param lineText A text snippet related to the error.
	 * @param message A message with details on the error.
	 * @param cause The wrapped cause of this error.
	 * @return The Murmur error object.
	 */
	public static MurmurError create(
			int lineNumber, String lineText, String message, Throwable cause) {
		MurmurError error = new MurmurError(message, cause);
		error.setLineNumber(lineNumber);
		error.setLineText(lineText);
		return error;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getLineText() {
		return lineText;
	}

	public void setLineText(String lineText) {
		this.lineText = lineText;
	}

	public Deque<InvokableType> getCallStack() {
		return callStack;
	}

	public void setCallStack(Deque<InvokableType> callStack) {
		this.callStack = callStack;
	}
	
}

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

import io.cloudchaser.murmur.parser.MurmurParser;
import java.util.List;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class MurmurMethod extends MurmurLambda
		implements MurmurMember {
	
	/**
	 * This method's name.
	 **/
	private final String name;
	
	/**
	 * This method's declaring component.
	 **/
	private MurmurComponent component;

	/**
	 * Creates a component-bound method with no parent context.
	 * 
	 * @param name The name of the method.
	 * @param component The component to bind to.
	 * @param lineNumber The line number the method was declared on.
	 * @param body The parser context of the body of the method.
	 * @param parameters The parameter list of the method.
	 **/
	public MurmurMethod(String name, MurmurComponent component, 
			int lineNumber, MurmurParser.BlockContext body,
			List<String> parameters) {
		super(lineNumber, body, parameters);
		this.component = component;
		this.name = name;
	}

	/**
	 * Creates a component-bound method with a parent context.
	 * 
	 * @param name The name of the method.
	 * @param component The component to bind to.
	 * @param lineNumber The line number the method was declared on.
	 * @param body The parser context of the body of the method.
	 * @param parameters The parameter list of the method.
	 * @param parent The parent context to this method.
	 **/
	public MurmurMethod(String name, MurmurComponent component,
			int lineNumber, MurmurParser.BlockContext body,
			List<String> parameters, SymbolContext parent) {
		super(lineNumber, body, parameters, parent);
		this.component = component;
		this.name = name;
	}

	/**
	 * Creates a method by naming a lambda function.
	 * 
	 * @param name The name of the method.
	 * @param lambda The lambda function.
	 **/
	public MurmurMethod(String name, MurmurLambda lambda) {
		super(lambda);
		this.name = name;
	}
	
	/**
	 * Clones a Murmur Method into a different context.
	 * 
	 * @param method The method to clone.
	 * @param context The new context for the method.
	 **/
	public MurmurMethod(MurmurMethod method, SymbolContext context) {
		super(method);
		this.name = method.name;
		this.setParent(context);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public MurmurComponent getComponent() {
		return component;
	}

	@Override
	public void bindComponent(MurmurComponent component) {
		if(this.component != null) return;
		this.component = component;
	}
	
}

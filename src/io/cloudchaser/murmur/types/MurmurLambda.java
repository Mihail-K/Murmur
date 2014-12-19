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

import io.cloudchaser.murmur.parser.MurmurParser.BlockContext;
import io.cloudchaser.murmur.symbol.LetSymbol;
import io.cloudchaser.murmur.symbol.SymbolContext;
import static io.cloudchaser.murmur.types.MurmurType.FUNCTION;
import java.util.List;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class MurmurLambda extends MurmurObject
		implements InvokableType {
	
	/**
	 * The line number this lambda was declared on.
	 **/
	private final int lineNumber;
	
	/**
	 * This lambda function's body.
	 **/
	private final BlockContext body;
	
	/**
	 * This lambda function's parameter list.
	 **/
	private final List<String> parameters;
	
	/**
	 * The symbol context this lambda exists in.
	 **/
	private SymbolContext parent;

	public MurmurLambda(int lineNumber, BlockContext body,
			List<String> parameters) {
		super(FUNCTION);
		this.lineNumber = lineNumber;
		this.parameters = parameters;
		this.body = body;
	}

	public MurmurLambda(int lineNumber, BlockContext body,
			List<String> parameters, SymbolContext parent) {
		super(FUNCTION);
		this.lineNumber = lineNumber;
		this.parameters = parameters;
		this.parent = parent;
		this.body = body;
	}
	
	protected SymbolContext createLocalContext(List<MurmurObject> arguments) {
		// Validate parameters match.
		if((parameters.isEmpty() && arguments.isEmpty()) ||
				(parameters.size() == arguments.size())) {
			// Create a local context.
			SymbolContext local = new LambdaContext();
			
			// Bind parameters.
			for(int idx = 0; idx < arguments.size(); idx++) {
				local.addSymbol(new LetSymbol(
						parameters.get(idx), arguments.get(idx)));
			}
			
			return local;
		}
		
		// Mismatch.
		throw new UnsupportedOperationException();
	}

	public int getLineNumber() {
		return lineNumber;
	}

	@Override
	public BlockContext getBody() {
		return body;
	}

	public SymbolContext getParent() {
		return parent;
	}

	public void setParent(SymbolContext parent) {
		this.parent = parent;
	}

	@Override
	public int getDeclaringLine() {
		return lineNumber;
	}

	@Override
	public String getMethodSignature() {
		return "<lambda>";
	}

	@Override
	public MurmurObject opInvoke(InvocationDelegate delegate, List<MurmurObject> args) {
		return delegate.invokeFunction(createLocalContext(args), this);
	}
	
}

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
import io.cloudchaser.murmur.symbol.Symbol;
import io.cloudchaser.murmur.symbol.SymbolContext;
import static io.cloudchaser.murmur.types.MurmurType.FUNCTION;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class MurmurFunction extends MurmurObject
		implements InvokableType {
	
	private class FunctionLocalContext
			implements SymbolContext {
		
		private final Map<String, Symbol> symbols;

		public FunctionLocalContext() {
			this.symbols = new HashMap<>();
		}

		@Override
		public SymbolContext getParent() {
			return context;
		}

		@Override
		public void addSymbol(Symbol symbol) {
			symbols.put(symbol.getName(), symbol);
		}

		@Override
		public Symbol getSymbol(String name) {
			Symbol symbol = symbols.get(name);
			if(symbol == null && context != null)
				return context.getSymbol(name);
			return symbol;
		}

		@Override
		public Symbol getLocal(String name) {
			return symbols.get(name);
		}
		
	}
	
	/**
	 * The line number this function was declared on.
	 **/
	private final int lineNumber;
	
	/**
	 * Function declaration context.
	 **/
	private SymbolContext context;
	
	/**
	 * Function parameter list.
	 **/
	private final List<String> parameters;
	
	/**
	 * The function body parser context.
	 **/
	private final BlockContext body;

	public MurmurFunction(int lineNumber, SymbolContext context,
			List<String> parameters, BlockContext body) {
		super(FUNCTION);
		this.lineNumber = lineNumber;
		this.context = context;
		this.parameters = parameters;
		this.body = body;
	}
	
	public SymbolContext getContext() {
		return context;
	}
	
	public void setContext(SymbolContext context) {
		this.context = context;
	}
	
	public int getParameterCount() {
		return parameters.size();
	}
	
	public List<String> getParameters() {
		return Collections.unmodifiableList(parameters);
	}
	
	public BlockContext getBody() {
		return body;
	}
	
	public SymbolContext createLocal(List<MurmurObject> arguments) {
		// Validate parameters match.
		if((parameters == null && arguments == null) ||
				(parameters.size() == arguments.size())) {
			// Create a local context.
			SymbolContext local = new FunctionLocalContext();
			
			// Bind parameters.
			if(arguments != null) {
				for(int idx = 0; idx < arguments.size(); idx++)
					local.addSymbol(new LetSymbol(
							parameters.get(idx), arguments.get(idx)));
			}
			
			return local;
		}
		
		// Mismatch.
		throw new UnsupportedOperationException();
	}

	@Override
	public MurmurString asString() {
		return MurmurString.create("function");
	}
	
	@Override
	public MurmurObject opEquals(MurmurObject other) {
		if(other.getType() == FUNCTION) {
			// Check if this is the exact same function.
			return MurmurBoolean.create(equals(other));
		}
		
		// Not equal.
		return MurmurBoolean.FALSE;
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		if(other.getType() == FUNCTION) {
			// Check if this is the exact same function.
			return MurmurBoolean.create(!equals(other));
		}
		
		// Not equal.
		return MurmurBoolean.TRUE;
	}
	
	@Override
	public int getDeclaringLine() {
		return lineNumber;
	}
	
	@Override
	public String getMethodSignature() {
		// Return the constructor's method signature.
		StringBuilder builder = new StringBuilder("<lambda>");
		builder.append("(");
		
		// Build the argument list.
		if(parameters != null) {
			parameters.stream().forEach(builder::append);
		}
		
		builder.append(")");
		return builder.toString();
	}
	
	@Override
	public MurmurObject opInvoke(InvocationDelegate delegate,
			List<MurmurObject> args) {
		// Create a context and invoke.
		SymbolContext local = createLocal(args);
		return delegate.invokeFunction(local, this);
	}

	@Override
	public String toString() {
		return "MurmurFunction{context=" + context +
				", parameters=" + parameters +
				", body=" + body + '}';
	}
	
}

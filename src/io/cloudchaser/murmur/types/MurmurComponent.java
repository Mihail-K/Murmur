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

import io.cloudchaser.murmur.symbol.Symbol;
import io.cloudchaser.murmur.symbol.SymbolContext;
import static io.cloudchaser.murmur.types.MurmurType.TYPE;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class MurmurComponent extends MurmurObject
		implements InvokableType {
	
	public static class ComponentField<Type> {
		
		private final String name;
		private final Type value;

		public ComponentField(String name) {
			this.name = name;
			this.value = null;
		}

		public ComponentField(String name, Type value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public Type getValue() {
			return value;
		}
		
	}
	
	public static class ComponentFunction
			extends ComponentField<MurmurFunction> {

		public ComponentFunction(String name, MurmurFunction function) {
			super(name, function);
		}
		
	}
	
	/**
	 * The declared name of this component.
	 */
	private final String name;
	
	/**
	 * The declaring line number of this component.
	 */
	private final int lineNumber;
	
	/**
	 * This component's parent context.
	 */
	private final SymbolContext context;
	
	/**
	 * The table of members defined in this component.
	 */
	private final Map<String, ComponentField> members;
	
	/**
	 * The list of components that make up this one, if any.
	 */
	private final List<MurmurComponent> components;

	public MurmurComponent(String name, int lineNumber, SymbolContext context) {
		this(name, lineNumber, context, Collections.emptyList());
	}
	
	public MurmurComponent(String name, int lineNumber,
			SymbolContext context, List<MurmurComponent> components) {
		super(TYPE);
		this.name = name;
		this.lineNumber = lineNumber;
		this.context = context;
		this.components = components;
		
		// Build memberlist.
		members = new HashMap<>();
		components.stream().forEach((component) -> {
			members.putAll(component.getMembers());
		});
	}
	
	public String getName() {
		return name;
	}
	
	public SymbolContext getContext() {
		return context;
	}
	
	public Map<String, ComponentField> getMembers() {
		return members;
	}
	
	public List<MurmurComponent> getComponents() {
		return Collections.unmodifiableList(components);
	}

	@Override
	public MurmurString asString() {
		return MurmurString.create(name);
	}

	@Override
	public MurmurObject opEquals(MurmurObject other) {
		// Check for component type.
		if(other.getType() == TYPE) {
			// Check that this is exactly the same component.
			return MurmurBoolean.create(equals(other));
		}
		
		// Not equal.
		return MurmurBoolean.FALSE;
	}

	@Override
	public MurmurObject opNotEquals(MurmurObject other) {
		// Check for component type.
		if(other.getType() == TYPE) {
			// Check that this isn't exactly the same component.
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
		// Get the constructor field.
		ComponentField local = members.get("~ctor");
		if(!(local instanceof ComponentFunction)) {
			// This should never happen.
			return name + "(...)";
		}
		
		// Return the constructor's method signature.
		ComponentFunction ctor = (ComponentFunction)local;
		StringBuilder builder = new StringBuilder(name);
		builder.append("(");
		
		// Build the argument list.
		if(!ctor.getValue().getParameters().isEmpty()) {
			ctor.getValue().getParameters().stream()
					.forEach(builder::append);
		}
		
		builder.append(")");
		return builder.toString();
	}

	@Override
	public MurmurObject opInvoke(InvocationDelegate delegate, List<MurmurObject> args) {
		// Create a new Murmur instance from this context.
		MurmurInstance instance = new MurmurInstance(this);

		// Lookup and call the construtor.
		Symbol local = instance.getContext().getLocal("~ctor");
		MurmurFunction ctor = (MurmurFunction)local.getValue();
		
		// Invoke the constructor.
		delegate.invokeFunction(ctor.createLocal(args), ctor);
		
		// Return the created instance.
		return instance;
	}

	@Override
	public String toString() {
		return "MurmurComponent{name=" + name + ", context=" + context +
				", members=" + members + ", components=" + components + '}';
	}
	
}

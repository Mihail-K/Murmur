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
	private final Map<String, MurmurMember> members;
	
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
	
	public void addMember(MurmurMember member) {
		members.put(member.getName(), member);
		member.bindComponent(this);
	}
	
	public Map<String, MurmurMember> getMembers() {
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
		return "~ctor";
	}

	@Override
	public MurmurObject opInvoke(List<MurmurObject> args) {
		// Create a new Murmur instance from this context.
		MurmurInstance instance = new MurmurInstance(this);

		// Lookup and call the construtor.
		MurmurSymbol local = instance.getContext().getLocal("~ctor");
		MurmurLambda ctor = (MurmurLambda)local.getValue();
		
		// Invoke the constructor.
		ctor.opInvoke(args);
		
		// Return the created instance.
		return instance;
	}

	@Override
	public String toString() {
		return "MurmurComponent{name=" + name + ", context=" + context +
				", members=" + members + ", components=" + components + '}';
	}
	
}

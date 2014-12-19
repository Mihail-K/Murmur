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

import static io.cloudchaser.murmur.types.MurmurType.OBJECT;
import java.util.Collections;


/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class MurmurInstance extends MurmurObject
		implements ReferenceType {
	
	/**
	 * The symbol context local to this object.
	 **/
	private final SymbolContext context;
	
	/**
	 * This object's component type.
	 **/
	private final MurmurComponent component;

	/**
	 * Creates a Murmur object instance from a component type.
	 * 
	 * @param component The component type to instantiate.
	 **/
	public MurmurInstance(MurmurComponent component) {
		super(OBJECT);
		this.component = component;
		
		// Build the local context.
		context = new MurmurInstanceContext(component);
		((MurmurInstanceContext)context).build();
		
		// Bind 'this' constant.
		context.addSymbol(new MurmurVariable("this", this));
	}
	
	public SymbolContext getContext() {
		return context;
	}
	
	public MurmurComponent getComponentType() {
		return component;
	}
	
	@Override
	public MurmurObject getMember(String name) {
		MurmurSymbol symbol = context.getLocal(name);
		return (MurmurObject)symbol;
	}

	@Override
	public MurmurObject opPlus(MurmurObject other) {
		MurmurSymbol symbol = context.getLocal("opPlus");
		
		// Check that the operator is defined.
		if(symbol == null) {
			throw new UnsupportedOperationException();
		}
		
		// Invoke the operator function.
		MurmurMethod method = (MurmurMethod)symbol.getValue();
		return method.opInvoke(Collections.singletonList(other));
	}

	@Override
	public MurmurObject opPlusAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opMinusAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opMultiplyAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opDivideAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opModuloAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opBitAndAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opBitXorAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opBitOrAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opShiftLeftAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opShiftRightAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public MurmurObject opConcatAssign(MurmurObject other) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}

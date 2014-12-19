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

import io.cloudchaser.murmur.symbol.LetSymbol;
import io.cloudchaser.murmur.symbol.Symbol;
import io.cloudchaser.murmur.symbol.SymbolContext;
import static io.cloudchaser.murmur.types.MurmurType.OBJECT;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mihail K
 * @since 0.1
 */
public class MurmurInstance extends MurmurObject
		implements ReferenceType {
	
	private class InstanceLocalContext
			implements SymbolContext {
		
		private final Map<String, Symbol> symbols;

		public InstanceLocalContext() {
			symbols = new HashMap<>();
		}
		
		protected void build() {
			component.getMembers().values()
					.stream().forEach((member) -> {
				// Check if this is a function.
				if(member instanceof MurmurLambda) {
					// Bind the function to the local context.
					MurmurLambda function = (MurmurLambda)member;
					function.setParent(context);
					
					// Create a function symbol.
					addSymbol(new LetSymbol(member.getName(), function));
				} else {
					// Create a field symbol.
					addSymbol(new LetSymbol(member.getName(), (MurmurField)member));
				}
			});
		}

		@Override
		public SymbolContext getParent() {
			return component.getContext();
		}

		@Override
		public void addSymbol(Symbol symbol) {
			symbols.put(symbol.getName(), symbol);
		}

		@Override
		public Symbol getSymbol(String name) {
			Symbol symbol = symbols.get(name);
			if(symbol == null && getParent() != null)
				return getParent().getSymbol(name);
			return symbol;
		}

		@Override
		public Symbol getLocal(String name) {
			return symbols.get(name);
		}
		
	}
	
	/**
	 * The symbol context local to this object.
	 */
	private final SymbolContext context;
	
	/**
	 * This object's component type.
	 */
	private final MurmurComponent component;

	public MurmurInstance(MurmurComponent component) {
		super(OBJECT);
		this.component = component;
		
		// Build the local context.
		context = new InstanceLocalContext();
		((InstanceLocalContext)context).build();
		context.addSymbol(new LetSymbol("this", this));
		System.out.println(((InstanceLocalContext)context).symbols);
	}
	
	public SymbolContext getContext() {
		return context;
	}
	
	public MurmurComponent getComponentType() {
		return component;
	}
	
	@Override
	public MurmurObject getMember(String name) {
		Symbol symbol = context.getLocal(name);
		return symbol == null ? MurmurVoid.VOID : symbol;
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

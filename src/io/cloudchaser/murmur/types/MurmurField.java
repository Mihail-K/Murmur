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

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class MurmurField extends MurmurVariable
		implements MurmurMember {
	
	/**
	 * The component to which this field is bound.
	 **/
	private MurmurComponent component;

	public MurmurField(String name) {
		this(name, null, MurmurNull.NULL);
	}

	public MurmurField(String name, MurmurObject value) {
		this(name, null, value);
	}

	public MurmurField(String name, MurmurComponent component, MurmurObject value) {
		super(name, value);
		this.component = component;
	}
	
	public MurmurField(MurmurField field) {
		super(field.getName(), field.getValue());
		this.component = field.component;
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

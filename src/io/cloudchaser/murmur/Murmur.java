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

import io.cloudchaser.murmur.parser.MurmurLexer;
import io.cloudchaser.murmur.parser.MurmurParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 *
 * @author Mihail K
 * @since 0.1
 **/
public class Murmur {
	
	/**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
		try {
			Reader reader = new BufferedReader(new FileReader(args[0]));
			ANTLRInputStream input = new ANTLRInputStream(reader);
			MurmurLexer lexer = new MurmurLexer(input);
			TokenStream tokens = new CommonTokenStream(lexer);
			MurmurParser parser = new MurmurParser(tokens);
			
			// Build a symbol table for the file.
			ParseTreeVisitor visitor = new MurmurASTVisitor();
			visitor.visit(parser.compilationUnit());
		} catch(IOException ex) {
			Logger.getLogger(Murmur.class.getName())
					.log(Level.SEVERE, null, ex);
		} catch(MurmurError err) {
			// Output an error message.
			System.err.printf("Murmur Error: %1$s%n", err.getMessage());
			System.err.printf("(%1$s @Line %2$d)%n", args[0], err.getLineNumber());
			System.err.printf(">\t%1$s%n%n", err.getLineText());
			
			// Display the call stack.
			if(err.getCallStack() != null) {
				err.getCallStack().stream().forEach((object) -> {
					System.err.printf("@ Line %1$d:\t%2$s%n", object.getDeclaringLine(),
							object.getMethodSignature());
				});
				System.err.println();
			}
			
			// Exit with error code.
			System.exit(1);
		}
    }
	
}

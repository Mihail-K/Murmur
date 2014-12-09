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

parser grammar MurmurParser;

options {
	// Import lexer.
	tokenVocab = MurmurLexer;
}

compilationUnit
	:	statement*
	;

/* - Statements  - */
/* - - - - - - - - */

statement
	//	Declarations.
	:	typeStatement ';'?
	|	iTypeStatement ';'?
		
	//	Language elements.
	|	keywordStatement ';'?
	|	expression ';'?
	;

keywordStatement
	//	Flow control.
	:	('break' | 'continue')
	|	'return' expression?
	|	'throw' expression

	//	Let statement.
	|	'let' initializerList
	|	'let' identifierList '->' expression

	//	Self-assignment.
	|	'<-' identifierList
	|	'->' identifierList
	;

/* - Blocks  - */
/* - - - - - - */

block
	//	{ ... }
	:	'{' statement* '}'
	;

/* - Types - */
/* - - - - - */

typeStatement
	//	name = type { ... }
	:	Identifier '='
		(Identifier '+')*
		typeDeclaration
	;

typeDeclaration
	//	type { ... }
	:	'type' '{'
		(typeElement ';'?)*
		'}'
	;

typeElement
	//	Fields and functions.
	:	(Identifier | 'this') ('=' expression)?
	;

/* - Interface Types - */
/* - - - - - - - - - - */

iTypeStatement
	//	name = itype { ... }
	:	Identifier '='
		(Identifier '+')*
		iTypeDeclaration
	;

iTypeDeclaration
	//	itype { ... }
	:	'itype' '{'	
		(iTypeElement ';'?)*
		'}'
	;

iTypeElement
	//	name = ( ... )
	:	Identifier '=' '('
		identifierList?
		')'
	;

/* - Expressions - */
/* - - - - - - - - */

identifierList
	:	Identifier
		(',' Identifier)*
	;

initializerList
	:	Identifier ('=' expression)?
		(',' Identifier ('=' expression)?)*
	;

expressionList
	:	expression
		(',' expression)*
	;

expression
	//	Literals.
	:	literal
		
	//	Identifiers.
	|	Identifier
		
	//	Lambdas.
	|	lambda
		
	//	Postfixed.
	|	expression ('++' | '--')
	|	expression '.' Identifier
	|	expression '[' expression ']'
		
	|	expression lambda
	|	expression '(' expressionList? ')'

	//	Prefixed.
	|	('+' | '-') expression
	|	('++' | '--') expression
	|	('!' | '~') expression

	//	Multiplicative.
	|	expression
		('*' | '/' | '%')
		expression
		
	//	Additive.
	|	expression
		('+' | '-' | '~')
		expression

	//	Bit Shift.
	|	expression
		('<<' | '>>')
		expression

	//	Comparison.
	|	expression
		('<' | '>' | '<=' | '>=')
		expression

	//	Equality
	|	expression
		('==' | '!=')
		expression

	//	Bitwise.
	|	expression
		'&'
		expression
	|	expression
		'^'
		expression
	|	expression
		'|'
		
	//	Logical.
	|	expression
		'&&'
		expression
	|	expression
		'||'
		expression

	//	Ternary.
	|	expression
		'?'
		expression
		':'
		expression
	|	expression
		'?'
		statement
		(':'
		 statement)?

	//	Assignment.
	|	<assoc = right>
		expression
		(	'='
		|	'+='
		|	'-='
		|	'*='
		|	'/='
		|	'%='
		|	'&='
		|	'^='
		|	'|='
		|	'>>='
		|	'<<='
		)
		expression

	//	Set notation.
	|	'[' expression? ','
		expression? ']'

	//	Parenthesized.
	|	'(' expression ')'
	;

lambda
	:	('(' identifierList? ')')?
		block
	;

literal
	//	Literals.
	:	IntegerLiteral
	|	DecimalLiteral
	|	BooleanLiteral
	|	CharacterLiteral
	|	StringLiteral
	|	NullLiteral

	//	Keywords.
	|	'this'
	|	'super'
	;

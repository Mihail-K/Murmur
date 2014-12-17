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
	:	operator = ('break' | 'continue')
	|	operator = 'return' expression?
	|	operator = 'throw' expression

	//	Let statement.
	|	operator = 'let' initializerList
	|	operator = 'let' identifierList '->' expression

	//	Self-assignment.
	|	operator = '<-' identifierList
	|	operator = '->' identifierList
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
	:	name = Identifier '='
		(parents += Identifier '+')*
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
	:	name = (Identifier | 'this')
		('=' expression)?
	;

/* - Interface Types - */
/* - - - - - - - - - - */

iTypeStatement
	//	name = itype { ... }
	:	name = Identifier '='
		(parents += Identifier '+')*
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
	:	name = Identifier '='
		'(' identifierList?	')'
	;

/* - Expressions - */
/* - - - - - - - - */

identifierList
	:	Identifier
		(',' Identifier)*
	;

initializerElement
	:	Identifier ('=' expression)?
	;

initializerList
	:	initializerElement
		(',' initializerElement)*
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
		
	//	Instantiation.
	|	operator = 'new'
		name = Identifier
		
	//	Postfixed.
	|	left = expression
		operator = ('++' | '--')
	|	left = expression
		operator = '.'
		name = Identifier
	|	left = expression
		operator = '['
		index = expression ']'
		
	|	left = expression lambda
	|	left = expression
		operator = '('
		expressionList? ')'

	//	Prefixed.
	|	operator = ('+' | '-')
		right = expression
	|	operator = ('++' | '--')
		right = expression
	|	operator = ('!' | '~')
		right = expression

	//	Multiplicative.
	|	left = expression
		operator = ('*' | '/' | '%')
		right = expression
		
	//	Additive.
	|	left = expression
		operator = ('+' | '-')
		right = expression

	//	Bit Shift.
	|	left = expression
		operator = ('<<' | '>>')
		right = expression

	//	Comparison.
	|	left = expression
		operator = ('<' | '>' | '<=' | '>=')
		right = expression

	//	Equality
	|	left = expression
		operator = ('==' | '!=')
		right = expression

	//	Bitwise.
	|	left = expression
		operator = '&'
		right = expression
	|	left = expression
		operator = '^'
		right = expression
	|	left = expression
		operator = '|'
		right = expression
		
	//	Logical.
	|	left = expression
		operator = '&&'
		right = expression
	|	left = expression
		operator = '||'
		right = expression

	//	Ternary.
	|	clause = expression
		operator = '?'
		expression
		':'
		expression
	|	clause = expression
		operator = '?'
		statement
		(':'
		 statement)?
		
	//	Concatenation.
	|	left = expression
		operator = '~'
		right = expression

	//	Assignment.
	|	<assoc = right>
		left = expression
		operator = (
			'='
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
		|	'~='
		)
		right = expression

	//	Set notation.
	|	'[' left = expression?
		operator = '..'
		right = expression? ']'
		
	//	Array notation.
	|	operator = '['
		expressionList? ']'

	//	Parenthesized.
	|	'(' inner = expression ')'
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

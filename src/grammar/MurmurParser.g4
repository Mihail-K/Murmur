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
	|	keywordStatement ';'
	|	expression ';'
	;

keywordStatement
	//	Flow control.
	:	'break' expression?
	|	'continue' expression?
	|	'return' expression?
	|	'throw' expression

	//	Self-assignment.
	|	'<-' Identifier
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
	:	Identifier ('=' expression)?
	;

/* - Interface Types - */
/* - - - - - - - - - - */

iTypeStatement
	//	name = itype { ... }
	:	Identifier '='
		iTypeDeclaration
	;

iTypeDeclaration
	//	itype { ... }
	:	'itype' '{'
		(iTypeElement ';'?)*
		'}'
	;

iTypeElement
	//	name ( ... )
	:	Identifier '('
		identifierList?
		')'
	;

/* - Expressions - */
/* - - - - - - - - */

identifierList
	:	Identifier
		(',' Identifier)*
	;

expressionList
	:	expression
		(',' expression)*
	;

expression
	//	Literals.
	:	literal
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

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

lexer grammar MurmurLexer;

/* - Literal Types - */
/* - - - - - - - - - */

IntegerLiteral
	:	Base10IntegerLiteral
	|	Base16IntegerLiteral
	|	Base8IntegerLiteral
	|	Base2IntegerLiteral
	;

DecimalLiteral
	:	Base10DecimalLiteral
	|	Base16DecimalLiteral
	;

/* - Base 10 Integer - */
/* - - - - - - - - - - */

fragment
Base10IntegerLiteral
	:	Base10Integer IntegerSuffix?
	;

fragment
Base10Integer
	:	/* No Prefix */ [0]
	|	/* No Prefix */ Base10Digits
	;

fragment
Base10Digits
	:	Base10NonZero
		(	Base10Elements?
			Base10Digit
		)?
	;

fragment
Base10Elements
	:	(	Base10Digit
		|	[_]
		)+
	;

fragment
Base10Digit
	:	[0]
	|	Base10NonZero
	;

fragment
Base10NonZero
	:	[1-9]
	;

/* - Base 16 Integer - */
/* - - - - - - - - - - */

fragment
Base16IntegerLiteral
	:	Base16Integer IntegerSuffix?
	;

fragment
Base16Integer
	:	[0] [xX] Base16Digits
	;

fragment
Base16Digits
	:	Base16Digit
		(	Base16Elements?
			Base16Digit
		)?
	;

fragment
Base16Elements
	:	(	Base16Digit
		|	[_]
		)+
	;

fragment
Base16Digit
	:	[0-9a-fA-F]
	;

/* - Base 8 Integer  - */
/* - - - - - - - - - - */

fragment
Base8IntegerLiteral
	:	Base8Integer IntegerSuffix?
	;

fragment
Base8Integer
	:	[0] [_]*? Base8Digits
	;

fragment
Base8Digits
	:	Base8Digit
		(	Base8Elements?
			Base8Digit
		)?
	;

fragment
Base8Elements
	:	(	Base8Digit
		|	[_]
		)+
	;

fragment
Base8Digit
	:	[0-7]
	;

/* - Base 2 Integer  - */
/* - - - - - - - - - - */

fragment
Base2IntegerLiteral
	:	Base2Integer IntegerSuffix?
	;

fragment
Base2Integer
	:	[0] [bB] Base2Digits
	;

fragment
Base2Digits
	:	Base2Digit
		(	Base2Elements?
			Base2Digit
		)?
	;

fragment
Base2Elements
	:	(	Base2Digit
		|	[_]
		)+
	;

fragment
Base2Digit
	:	[01]
	;

fragment
IntegerSuffix
	:	[lL]
	;

/* - Base 10 Decimal - */
/* - - - - - - - - - - */

fragment
Base10DecimalLiteral
	:	([0] | Base10Digits) '.' Base10Value?  Base10Exponent? DecimalSuffix?
	|	'.' Base10Value Base10Exponent? DecimalSuffix?
	|	Base10Digits Base10Exponent DecimalSuffix?
	|	Base10Digits DecimalSuffix
	;

fragment
Base10Value
	:	Base10Digit
		(	Base10Elements?
			Base10Digit
		)?
	;

fragment
Base10Exponent
	:	[eE] [+-]? Base10Integer
	;

/* - Base 16 Decimal - */
/* - - - - - - - - - - */

fragment
Base16DecimalLiteral
	:	Base16Integer '.'? Base16Exponent DecimalSuffix?
	|	[0] [xX] Base16Digits? '.' Base16Digits Base16Exponent DecimalSuffix?
	;

fragment
Base16Exponent
	:	[pP] [+-]? Base10Digits
	;

fragment
DecimalSuffix
	:	[fFdD]
	;

/* - Boolean Literal - */
/* - - - - - - - - - - */

BooleanLiteral
	:	'true'
	|	'false'
	;

/* - Character Literal - */
/* - - - - - - - - - - - */

CharacterLiteral
	:	['] (~[\\'] | EscapedCharacter) [']
	;

fragment
EscapedCharacter
	:	[\\]
		(	[bfnrt0\\'"]
		|	[0-3]?[0-7]?[0-7]
		)
	;

/* - String Literal  - */
/* - - - - - - - - - - */

StringLiteral
	:	["] (~[\\"] | EscapedCharacter)*? ["]
	;

/* - Null Literal  - */
/* - - - - - - - - - */

NullLiteral
	:	'null'
	;

/* - Operators - */
/* - - - - - - - */

AddOperator
	:	'+'
	;

AssignOperator
	:	'='
	;

BinaryAndOperator
	:	'&'
	;

BinaryNotOperator
	:	'~'
	;

BinaryOrOperator
	:	'|'
	;

BinaryXorOperator
	:	'^'
	;

CommaOperator
	:	','
	;

CompoundAddOperator
	:	'+='
	;

CompoundBinaryAndOperator
	:	'&='
	;

CompoundBinaryOrOperator
	:	'|='
	;

CompoundBinaryXorOperator
	:	'^='
	;

CompoundDivideOperator
	:	'/='
	;

CompoundLeftShiftOperator
	:	'<<='
	;

CompoundModuloOperator
	:	'%='
	;

CompoundMultiplyOperator
	:	'*='
	;

CompoundRightShiftOperator
	:	'>>='
	;

CompoundSubtractOperator
	:	'-='
	;

DecrementOperator
	:	'--'
	;

DivideOperator
	:	'/'
	;

DotOperator
	:	'.'
	;

EqualsOperator
	:	'=='
	;

GreaterOrEqualOperator
	:	'>='
	;

GreaterThanOperator
	:	'>'
	;

IncrementOperator
	:	'++'
	;

LeftShiftOperator
	:	'<<'
	;

LessOrEqualOperator
	:	'<='
	;

LessThanOperator
	:	'<'
	;

LogicalAndOperator
	:	'&&'
	;

LogicalNotOperator
	:	'!'
	;

LogicalOrOperator
	:	'||'
	;

ModuloOperator
	:	'%'
	;

MultiplyOperator
	:	'*'
	;

NotEqualsOperator
	:	'!='
	;

RangeOperator
	:	'..'
	;

RightShiftOperator
	:	'>>'
	;

SubtractOperator
	:	'-'
	;

TernaryConditionOperator
	:	'?'
	;

TernaryIterativeOperator
	:	'@'
	;

/* - Syntax Elements - */
/* - - - - - - - - - - */

ColonElement
	:	':'
	;

SemicolonElement
	:	';'
	;

LeftArrowElement
	:	'<-'
	;

RightArrowElement
	:	'->'
	;

LeftBraceElement
	:	'{'
	;

RightBraceElement
	:	'}'
	;

LeftBracketElement
	:	'['
	;

RightBracketElement
	:	']'
	;

LeftParenElement
	:	'('
	;

RightParenElement
	:	')'
	;

/* - Keyword Table - */
/* - - - - - - - - - */

AssertKeyword
	:	'assert'
	;

BreakKeyword
	:	'break'
	;

ContinueKeyword
	:	'continue'
	;

ImportKeyword
	:	'import'
	;

ITypeKeyword
	:	'itype'
	;

LetKeyword
	:	'let'
	;

ModuleKeyword
	:	'module'
	;

NewKeyword
	:	'new'
	;

ReturnKeyword
	:	'return'
	;

SuperKeyword
	:	'super'
	;

ThisKeyword
	:	'this'
	;

ThrowKeyword
	:	'throw'
	;

TypeKeyword
	:	'type'
	;

/* - Access Modifier - */
/* - - - - - - - - - - */

PrivateKeyword
	:	'private'
	;

ProtectedKeyword
	:	'protected'
	;

PublicKeyword
	:	'public'
	;

/* - Identifiers - */
/* - - - - - - - - */

Identifier
	:	IdentifierFirst IdentifierLast*
	;

fragment
IdentifierFirst
	:	[a-zA-Z_$]
	;

fragment
IdentifierLast
	:	[a-zA-Z0-9_$]
	;

/* - Ignored Symbols - */
/* - - - - - - - - - - */

Whitespace
	:	[ \t\r\n]+ -> skip
	;

LineComment
	:	'//' (~'\n')* -> skip
	;

BlockComment
	:	'/*' .*? '*/' -> skip
	;

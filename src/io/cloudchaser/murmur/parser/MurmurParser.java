// Generated from C:\Users\Mihail\Documents\NetBeansProjects\Murmur\src\grammar\MurmurParser.g4 by ANTLR 4.4
package io.cloudchaser.murmur.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MurmurParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LeftParenElement=52, ModuleKeyword=60, TernaryConditionOperator=42, LineComment=72, 
		ThisKeyword=64, BinaryXorOperator=12, CommaOperator=13, EqualsOperator=27, 
		ColonElement=44, LogicalAndOperator=34, Identifier=70, RightParenElement=53, 
		CompoundRightShiftOperator=22, ITypeKeyword=58, TypeKeyword=66, BinaryAndOperator=9, 
		IntegerLiteral=1, CompoundSubtractOperator=23, BlockComment=73, ContinueKeyword=56, 
		CompoundAddOperator=14, ThrowKeyword=65, CompoundBinaryOrOperator=16, 
		StringLiteral=5, LessOrEqualOperator=32, NotEqualsOperator=39, GreaterOrEqualOperator=28, 
		RightBraceElement=49, NullLiteral=6, SuperKeyword=63, ProtectedKeyword=68, 
		CompoundBinaryAndOperator=15, CompoundModuloOperator=20, SemicolonElement=45, 
		AddOperator=7, BooleanLiteral=3, ModuloOperator=37, LeftBracketElement=50, 
		LeftArrowElement=46, Whitespace=71, BinaryOrOperator=11, PrivateKeyword=67, 
		ReturnKeyword=62, MultiplyOperator=38, AssertKeyword=54, DivideOperator=25, 
		RightArrowElement=47, DecimalLiteral=2, TernaryIterativeOperator=43, DecrementOperator=24, 
		RightShiftOperator=40, RightBracketElement=51, BreakKeyword=55, PublicKeyword=69, 
		LogicalNotOperator=35, CompoundLeftShiftOperator=19, GreaterThanOperator=29, 
		CompoundMultiplyOperator=21, AssignOperator=8, LeftBraceElement=48, LetKeyword=59, 
		NewKeyword=61, LessThanOperator=33, SubtractOperator=41, ImportKeyword=57, 
		CompoundBinaryXorOperator=17, DotOperator=26, IncrementOperator=30, BinaryNotOperator=10, 
		LogicalOrOperator=36, LeftShiftOperator=31, CompoundDivideOperator=18, 
		CharacterLiteral=4;
	public static final String[] tokenNames = {
		"<INVALID>", "IntegerLiteral", "DecimalLiteral", "BooleanLiteral", "CharacterLiteral", 
		"StringLiteral", "'null'", "'+'", "'='", "'&'", "'~'", "'|'", "'^'", "','", 
		"'+='", "'&='", "'|='", "'^='", "'/='", "'<<='", "'%='", "'*='", "'>>='", 
		"'-='", "'--'", "'/'", "'.'", "'=='", "'>='", "'>'", "'++'", "'<<'", "'<='", 
		"'<'", "'&&'", "'!'", "'||'", "'%'", "'*'", "'!='", "'>>'", "'-'", "'?'", 
		"'@'", "':'", "';'", "'<-'", "'->'", "'{'", "'}'", "'['", "']'", "'('", 
		"')'", "'assert'", "'break'", "'continue'", "'import'", "'itype'", "'let'", 
		"'module'", "'new'", "'return'", "'super'", "'this'", "'throw'", "'type'", 
		"'private'", "'protected'", "'public'", "Identifier", "Whitespace", "LineComment", 
		"BlockComment"
	};
	public static final int
		RULE_compilationUnit = 0, RULE_statement = 1, RULE_keywordStatement = 2, 
		RULE_block = 3, RULE_typeStatement = 4, RULE_typeDeclaration = 5, RULE_typeElement = 6, 
		RULE_iTypeStatement = 7, RULE_iTypeDeclaration = 8, RULE_iTypeElement = 9, 
		RULE_identifierList = 10, RULE_initializerElement = 11, RULE_initializerList = 12, 
		RULE_expressionList = 13, RULE_expression = 14, RULE_lambda = 15, RULE_literal = 16;
	public static final String[] ruleNames = {
		"compilationUnit", "statement", "keywordStatement", "block", "typeStatement", 
		"typeDeclaration", "typeElement", "iTypeStatement", "iTypeDeclaration", 
		"iTypeElement", "identifierList", "initializerElement", "initializerList", 
		"expressionList", "expression", "lambda", "literal"
	};

	@Override
	public String getGrammarFileName() { return "MurmurParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MurmurParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftArrowElement) | (1L << RightArrowElement) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << BreakKeyword) | (1L << ContinueKeyword) | (1L << LetKeyword) | (1L << ReturnKeyword) | (1L << SuperKeyword))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ThisKeyword - 64)) | (1L << (ThrowKeyword - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(34); statement();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TypeStatementContext typeStatement() {
			return getRuleContext(TypeStatementContext.class,0);
		}
		public ITypeStatementContext iTypeStatement() {
			return getRuleContext(ITypeStatementContext.class,0);
		}
		public KeywordStatementContext keywordStatement() {
			return getRuleContext(KeywordStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40); typeStatement();
				setState(42);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(41); match(SemicolonElement);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44); iTypeStatement();
				setState(46);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(45); match(SemicolonElement);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48); keywordStatement();
				setState(50);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(49); match(SemicolonElement);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(52); expression(0);
				setState(54);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(53); match(SemicolonElement);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordStatementContext extends ParserRuleContext {
		public Token operator;
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public KeywordStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitKeywordStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordStatementContext keywordStatement() throws RecognitionException {
		KeywordStatementContext _localctx = new KeywordStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_keywordStatement);
		int _la;
		try {
			setState(76);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				((KeywordStatementContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==BreakKeyword || _la==ContinueKeyword) ) {
					((KeywordStatementContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); ((KeywordStatementContext)_localctx).operator = match(ReturnKeyword);
				setState(61);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(60); expression(0);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(63); ((KeywordStatementContext)_localctx).operator = match(ThrowKeyword);
				setState(64); expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(65); ((KeywordStatementContext)_localctx).operator = match(LetKeyword);
				setState(66); initializerList();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(67); ((KeywordStatementContext)_localctx).operator = match(LetKeyword);
				setState(68); identifierList();
				setState(69); match(RightArrowElement);
				setState(70); expression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(72); ((KeywordStatementContext)_localctx).operator = match(LeftArrowElement);
				setState(73); identifierList();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(74); ((KeywordStatementContext)_localctx).operator = match(RightArrowElement);
				setState(75); identifierList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); match(LeftBraceElement);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftArrowElement) | (1L << RightArrowElement) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << BreakKeyword) | (1L << ContinueKeyword) | (1L << LetKeyword) | (1L << ReturnKeyword) | (1L << SuperKeyword))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ThisKeyword - 64)) | (1L << (ThrowKeyword - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(79); statement();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85); match(RightBraceElement);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeStatementContext extends ParserRuleContext {
		public Token name;
		public Token Identifier;
		public List<Token> parents = new ArrayList<Token>();
		public List<TerminalNode> Identifier() { return getTokens(MurmurParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MurmurParser.Identifier, i);
		}
		public TypeDeclarationContext typeDeclaration() {
			return getRuleContext(TypeDeclarationContext.class,0);
		}
		public TypeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitTypeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeStatementContext typeStatement() throws RecognitionException {
		TypeStatementContext _localctx = new TypeStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); ((TypeStatementContext)_localctx).name = match(Identifier);
			setState(88); match(AssignOperator);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(89); ((TypeStatementContext)_localctx).Identifier = match(Identifier);
				((TypeStatementContext)_localctx).parents.add(((TypeStatementContext)_localctx).Identifier);
				setState(90); match(AddOperator);
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96); typeDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclarationContext extends ParserRuleContext {
		public List<TypeElementContext> typeElement() {
			return getRuleContexts(TypeElementContext.class);
		}
		public TypeElementContext typeElement(int i) {
			return getRuleContext(TypeElementContext.class,i);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(TypeKeyword);
			setState(99); match(LeftBraceElement);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ThisKeyword || _la==Identifier) {
				{
				{
				setState(100); typeElement();
				setState(102);
				_la = _input.LA(1);
				if (_la==SemicolonElement) {
					{
					setState(101); match(SemicolonElement);
					}
				}

				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109); match(RightBraceElement);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeElementContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Identifier() { return getToken(MurmurParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitTypeElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeElementContext typeElement() throws RecognitionException {
		TypeElementContext _localctx = new TypeElementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typeElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			((TypeElementContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==ThisKeyword || _la==Identifier) ) {
				((TypeElementContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(114);
			_la = _input.LA(1);
			if (_la==AssignOperator) {
				{
				setState(112); match(AssignOperator);
				setState(113); expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ITypeStatementContext extends ParserRuleContext {
		public Token name;
		public Token Identifier;
		public List<Token> parents = new ArrayList<Token>();
		public List<TerminalNode> Identifier() { return getTokens(MurmurParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MurmurParser.Identifier, i);
		}
		public ITypeDeclarationContext iTypeDeclaration() {
			return getRuleContext(ITypeDeclarationContext.class,0);
		}
		public ITypeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iTypeStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitITypeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ITypeStatementContext iTypeStatement() throws RecognitionException {
		ITypeStatementContext _localctx = new ITypeStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_iTypeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); ((ITypeStatementContext)_localctx).name = match(Identifier);
			setState(117); match(AssignOperator);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(118); ((ITypeStatementContext)_localctx).Identifier = match(Identifier);
				((ITypeStatementContext)_localctx).parents.add(((ITypeStatementContext)_localctx).Identifier);
				setState(119); match(AddOperator);
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125); iTypeDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ITypeDeclarationContext extends ParserRuleContext {
		public ITypeElementContext iTypeElement(int i) {
			return getRuleContext(ITypeElementContext.class,i);
		}
		public List<ITypeElementContext> iTypeElement() {
			return getRuleContexts(ITypeElementContext.class);
		}
		public ITypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iTypeDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitITypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ITypeDeclarationContext iTypeDeclaration() throws RecognitionException {
		ITypeDeclarationContext _localctx = new ITypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_iTypeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(ITypeKeyword);
			setState(128); match(LeftBraceElement);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(129); iTypeElement();
				setState(131);
				_la = _input.LA(1);
				if (_la==SemicolonElement) {
					{
					setState(130); match(SemicolonElement);
					}
				}

				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138); match(RightBraceElement);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ITypeElementContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Identifier() { return getToken(MurmurParser.Identifier, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public ITypeElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iTypeElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitITypeElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ITypeElementContext iTypeElement() throws RecognitionException {
		ITypeElementContext _localctx = new ITypeElementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_iTypeElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140); ((ITypeElementContext)_localctx).name = match(Identifier);
			setState(141); match(AssignOperator);
			setState(142); match(LeftParenElement);
			setState(144);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(143); identifierList();
				}
			}

			setState(146); match(RightParenElement);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MurmurParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MurmurParser.Identifier, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_identifierList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(148); match(Identifier);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(149); match(CommaOperator);
					setState(150); match(Identifier);
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerElementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MurmurParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitializerElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitInitializerElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerElementContext initializerElement() throws RecognitionException {
		InitializerElementContext _localctx = new InitializerElementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_initializerElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(Identifier);
			setState(159);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(157); match(AssignOperator);
				setState(158); expression(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerListContext extends ParserRuleContext {
		public List<InitializerElementContext> initializerElement() {
			return getRuleContexts(InitializerElementContext.class);
		}
		public InitializerElementContext initializerElement(int i) {
			return getRuleContext(InitializerElementContext.class,i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_initializerList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161); initializerElement();
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(162); match(CommaOperator);
					setState(163); initializerElement();
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); expression(0);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CommaOperator) {
				{
				{
				setState(170); match(CommaOperator);
				setState(171); expression(0);
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public ExpressionContext clause;
		public Token operator;
		public ExpressionContext right;
		public ExpressionContext inner;
		public Token name;
		public ExpressionContext index;
		public TerminalNode Identifier() { return getToken(MurmurParser.Identifier, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(178);
				((ExpressionContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==AddOperator || _la==SubtractOperator) ) {
					((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(179); ((ExpressionContext)_localctx).right = expression(20);
				}
				break;
			case 2:
				{
				setState(180);
				((ExpressionContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==DecrementOperator || _la==IncrementOperator) ) {
					((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(181); ((ExpressionContext)_localctx).right = expression(19);
				}
				break;
			case 3:
				{
				setState(182);
				((ExpressionContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==BinaryNotOperator || _la==LogicalNotOperator) ) {
					((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(183); ((ExpressionContext)_localctx).right = expression(18);
				}
				break;
			case 4:
				{
				setState(184); literal();
				}
				break;
			case 5:
				{
				setState(185); match(Identifier);
				}
				break;
			case 6:
				{
				setState(186); lambda();
				}
				break;
			case 7:
				{
				setState(187); match(LeftBracketElement);
				setState(189);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << SuperKeyword))) != 0) || _la==ThisKeyword || _la==Identifier) {
					{
					setState(188); ((ExpressionContext)_localctx).left = expression(0);
					}
				}

				setState(191); ((ExpressionContext)_localctx).operator = match(CommaOperator);
				setState(193);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << SuperKeyword))) != 0) || _la==ThisKeyword || _la==Identifier) {
					{
					setState(192); ((ExpressionContext)_localctx).right = expression(0);
					}
				}

				setState(195); match(RightBracketElement);
				}
				break;
			case 8:
				{
				setState(196); ((ExpressionContext)_localctx).operator = match(LeftBracketElement);
				setState(198);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << SuperKeyword))) != 0) || _la==ThisKeyword || _la==Identifier) {
					{
					setState(197); expressionList();
					}
				}

				setState(200); match(RightBracketElement);
				}
				break;
			case 9:
				{
				setState(201); match(LeftParenElement);
				setState(202); ((ExpressionContext)_localctx).inner = expression(0);
				setState(203); match(RightParenElement);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(208);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DivideOperator) | (1L << ModuloOperator) | (1L << MultiplyOperator))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(209); ((ExpressionContext)_localctx).right = expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(211);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AddOperator || _la==SubtractOperator) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(212); ((ExpressionContext)_localctx).right = expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(214);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShiftOperator || _la==RightShiftOperator) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(215); ((ExpressionContext)_localctx).right = expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(217);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GreaterOrEqualOperator) | (1L << GreaterThanOperator) | (1L << LessOrEqualOperator) | (1L << LessThanOperator))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(218); ((ExpressionContext)_localctx).right = expression(15);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(220);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EqualsOperator || _la==NotEqualsOperator) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(221); ((ExpressionContext)_localctx).right = expression(14);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(223); ((ExpressionContext)_localctx).operator = match(BinaryAndOperator);
						setState(224); ((ExpressionContext)_localctx).right = expression(13);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(226); ((ExpressionContext)_localctx).operator = match(BinaryXorOperator);
						setState(227); ((ExpressionContext)_localctx).right = expression(12);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(229); ((ExpressionContext)_localctx).operator = match(BinaryOrOperator);
						setState(230); ((ExpressionContext)_localctx).right = expression(11);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(232); ((ExpressionContext)_localctx).operator = match(LogicalAndOperator);
						setState(233); ((ExpressionContext)_localctx).right = expression(10);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(235); ((ExpressionContext)_localctx).operator = match(LogicalOrOperator);
						setState(236); ((ExpressionContext)_localctx).right = expression(9);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.clause = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(237);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(238); ((ExpressionContext)_localctx).operator = match(TernaryConditionOperator);
						setState(239); expression(0);
						setState(240); match(ColonElement);
						setState(241); expression(8);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(244);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AssignOperator) | (1L << CompoundAddOperator) | (1L << CompoundBinaryAndOperator) | (1L << CompoundBinaryOrOperator) | (1L << CompoundBinaryXorOperator) | (1L << CompoundDivideOperator) | (1L << CompoundLeftShiftOperator) | (1L << CompoundModuloOperator) | (1L << CompoundMultiplyOperator) | (1L << CompoundRightShiftOperator) | (1L << CompoundSubtractOperator))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(245); ((ExpressionContext)_localctx).right = expression(5);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(246);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(247); ((ExpressionContext)_localctx).operator = match(BinaryNotOperator);
						setState(248); ((ExpressionContext)_localctx).right = expression(5);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(249);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(250);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DecrementOperator || _la==IncrementOperator) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(251);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(252); ((ExpressionContext)_localctx).operator = match(DotOperator);
						setState(253); ((ExpressionContext)_localctx).name = match(Identifier);
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(254);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(255); ((ExpressionContext)_localctx).operator = match(LeftBracketElement);
						setState(256); ((ExpressionContext)_localctx).index = expression(0);
						setState(257); match(RightBracketElement);
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(259);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(260); lambda();
						}
						break;
					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(261);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(262); ((ExpressionContext)_localctx).operator = match(LeftParenElement);
						setState(264);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << SuperKeyword))) != 0) || _la==ThisKeyword || _la==Identifier) {
							{
							setState(263); expressionList();
							}
						}

						setState(266); match(RightParenElement);
						}
						break;
					case 19:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.clause = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(268); ((ExpressionContext)_localctx).operator = match(TernaryConditionOperator);
						setState(269); statement();
						setState(272);
						switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
						case 1:
							{
							setState(270); match(ColonElement);
							setState(271); statement();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if (_la==LeftParenElement) {
				{
				setState(279); match(LeftParenElement);
				setState(281);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(280); identifierList();
					}
				}

				setState(283); match(RightParenElement);
				}
			}

			setState(286); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode DecimalLiteral() { return getToken(MurmurParser.DecimalLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(MurmurParser.StringLiteral, 0); }
		public TerminalNode NullLiteral() { return getToken(MurmurParser.NullLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(MurmurParser.IntegerLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(MurmurParser.BooleanLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(MurmurParser.CharacterLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MurmurParserVisitor ) return ((MurmurParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_la = _input.LA(1);
			if ( !(((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (IntegerLiteral - 1)) | (1L << (DecimalLiteral - 1)) | (1L << (BooleanLiteral - 1)) | (1L << (CharacterLiteral - 1)) | (1L << (StringLiteral - 1)) | (1L << (NullLiteral - 1)) | (1L << (SuperKeyword - 1)) | (1L << (ThisKeyword - 1)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 17);
		case 1: return precpred(_ctx, 16);
		case 2: return precpred(_ctx, 15);
		case 3: return precpred(_ctx, 14);
		case 4: return precpred(_ctx, 13);
		case 5: return precpred(_ctx, 12);
		case 6: return precpred(_ctx, 11);
		case 7: return precpred(_ctx, 10);
		case 8: return precpred(_ctx, 9);
		case 9: return precpred(_ctx, 8);
		case 10: return precpred(_ctx, 7);
		case 11: return precpred(_ctx, 5);
		case 12: return precpred(_ctx, 4);
		case 13: return precpred(_ctx, 25);
		case 14: return precpred(_ctx, 24);
		case 15: return precpred(_ctx, 23);
		case 16: return precpred(_ctx, 22);
		case 17: return precpred(_ctx, 21);
		case 18: return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3K\u0125\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\5\3-\n\3\3\3\3\3\5\3\61\n\3\3\3\3"+
		"\3\5\3\65\n\3\3\3\3\3\5\39\n\3\5\3;\n\3\3\4\3\4\3\4\5\4@\n\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\5\3\5\7\5S\n\5\f"+
		"\5\16\5V\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\5\7i\n\7\7\7k\n\7\f\7\16\7n\13\7\3\7\3\7\3\b\3\b\3\b"+
		"\5\bu\n\b\3\t\3\t\3\t\3\t\7\t{\n\t\f\t\16\t~\13\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\5\n\u0086\n\n\7\n\u0088\n\n\f\n\16\n\u008b\13\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\5\13\u0093\n\13\3\13\3\13\3\f\3\f\3\f\7\f\u009a\n\f\f\f\16"+
		"\f\u009d\13\f\3\r\3\r\3\r\5\r\u00a2\n\r\3\16\3\16\3\16\7\16\u00a7\n\16"+
		"\f\16\16\16\u00aa\13\16\3\17\3\17\3\17\7\17\u00af\n\17\f\17\16\17\u00b2"+
		"\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00c0\n\20\3\20\3\20\5\20\u00c4\n\20\3\20\3\20\3\20\5\20\u00c9\n\20\3"+
		"\20\3\20\3\20\3\20\3\20\5\20\u00d0\n\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u010b\n\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u0113\n\20\7\20\u0115\n\20\f\20\16\20\u0118"+
		"\13\20\3\21\3\21\5\21\u011c\n\21\3\21\5\21\u011f\n\21\3\21\3\21\3\22\3"+
		"\22\3\22\2\3\36\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\r\3\29"+
		":\4\2BBHH\4\2\t\t++\4\2\32\32  \4\2\f\f%%\4\2\33\33\'(\4\2!!**\4\2\36"+
		"\37\"#\4\2\35\35))\4\2\n\n\20\31\4\2\3\bAB\u0151\2\'\3\2\2\2\4:\3\2\2"+
		"\2\6N\3\2\2\2\bP\3\2\2\2\nY\3\2\2\2\fd\3\2\2\2\16q\3\2\2\2\20v\3\2\2\2"+
		"\22\u0081\3\2\2\2\24\u008e\3\2\2\2\26\u0096\3\2\2\2\30\u009e\3\2\2\2\32"+
		"\u00a3\3\2\2\2\34\u00ab\3\2\2\2\36\u00cf\3\2\2\2 \u011e\3\2\2\2\"\u0122"+
		"\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2"+
		"\2)\'\3\2\2\2*,\5\n\6\2+-\7/\2\2,+\3\2\2\2,-\3\2\2\2-;\3\2\2\2.\60\5\20"+
		"\t\2/\61\7/\2\2\60/\3\2\2\2\60\61\3\2\2\2\61;\3\2\2\2\62\64\5\6\4\2\63"+
		"\65\7/\2\2\64\63\3\2\2\2\64\65\3\2\2\2\65;\3\2\2\2\668\5\36\20\2\679\7"+
		"/\2\28\67\3\2\2\289\3\2\2\29;\3\2\2\2:*\3\2\2\2:.\3\2\2\2:\62\3\2\2\2"+
		":\66\3\2\2\2;\5\3\2\2\2<O\t\2\2\2=?\7@\2\2>@\5\36\20\2?>\3\2\2\2?@\3\2"+
		"\2\2@O\3\2\2\2AB\7C\2\2BO\5\36\20\2CD\7=\2\2DO\5\32\16\2EF\7=\2\2FG\5"+
		"\26\f\2GH\7\61\2\2HI\5\36\20\2IO\3\2\2\2JK\7\60\2\2KO\5\26\f\2LM\7\61"+
		"\2\2MO\5\26\f\2N<\3\2\2\2N=\3\2\2\2NA\3\2\2\2NC\3\2\2\2NE\3\2\2\2NJ\3"+
		"\2\2\2NL\3\2\2\2O\7\3\2\2\2PT\7\62\2\2QS\5\4\3\2RQ\3\2\2\2SV\3\2\2\2T"+
		"R\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\63\2\2X\t\3\2\2\2YZ\7H\2\2"+
		"Z_\7\n\2\2[\\\7H\2\2\\^\7\t\2\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2"+
		"\2`b\3\2\2\2a_\3\2\2\2bc\5\f\7\2c\13\3\2\2\2de\7D\2\2el\7\62\2\2fh\5\16"+
		"\b\2gi\7/\2\2hg\3\2\2\2hi\3\2\2\2ik\3\2\2\2jf\3\2\2\2kn\3\2\2\2lj\3\2"+
		"\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7\63\2\2p\r\3\2\2\2qt\t\3\2\2rs\7"+
		"\n\2\2su\5\36\20\2tr\3\2\2\2tu\3\2\2\2u\17\3\2\2\2vw\7H\2\2w|\7\n\2\2"+
		"xy\7H\2\2y{\7\t\2\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2"+
		"\2~|\3\2\2\2\177\u0080\5\22\n\2\u0080\21\3\2\2\2\u0081\u0082\7<\2\2\u0082"+
		"\u0089\7\62\2\2\u0083\u0085\5\24\13\2\u0084\u0086\7/\2\2\u0085\u0084\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0083\3\2\2\2\u0088"+
		"\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2"+
		"\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7\63\2\2\u008d\23\3\2\2\2\u008e\u008f"+
		"\7H\2\2\u008f\u0090\7\n\2\2\u0090\u0092\7\66\2\2\u0091\u0093\5\26\f\2"+
		"\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095"+
		"\7\67\2\2\u0095\25\3\2\2\2\u0096\u009b\7H\2\2\u0097\u0098\7\17\2\2\u0098"+
		"\u009a\7H\2\2\u0099\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\27\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a1"+
		"\7H\2\2\u009f\u00a0\7\n\2\2\u00a0\u00a2\5\36\20\2\u00a1\u009f\3\2\2\2"+
		"\u00a1\u00a2\3\2\2\2\u00a2\31\3\2\2\2\u00a3\u00a8\5\30\r\2\u00a4\u00a5"+
		"\7\17\2\2\u00a5\u00a7\5\30\r\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2"+
		"\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\33\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00b0\5\36\20\2\u00ac\u00ad\7\17\2\2\u00ad\u00af\5\36\20"+
		"\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\35\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\b\20\1\2\u00b4"+
		"\u00b5\t\4\2\2\u00b5\u00d0\5\36\20\26\u00b6\u00b7\t\5\2\2\u00b7\u00d0"+
		"\5\36\20\25\u00b8\u00b9\t\6\2\2\u00b9\u00d0\5\36\20\24\u00ba\u00d0\5\""+
		"\22\2\u00bb\u00d0\7H\2\2\u00bc\u00d0\5 \21\2\u00bd\u00bf\7\64\2\2\u00be"+
		"\u00c0\5\36\20\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3"+
		"\2\2\2\u00c1\u00c3\7\17\2\2\u00c2\u00c4\5\36\20\2\u00c3\u00c2\3\2\2\2"+
		"\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00d0\7\65\2\2\u00c6\u00c8"+
		"\7\64\2\2\u00c7\u00c9\5\34\17\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2"+
		"\2\u00c9\u00ca\3\2\2\2\u00ca\u00d0\7\65\2\2\u00cb\u00cc\7\66\2\2\u00cc"+
		"\u00cd\5\36\20\2\u00cd\u00ce\7\67\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00b3"+
		"\3\2\2\2\u00cf\u00b6\3\2\2\2\u00cf\u00b8\3\2\2\2\u00cf\u00ba\3\2\2\2\u00cf"+
		"\u00bb\3\2\2\2\u00cf\u00bc\3\2\2\2\u00cf\u00bd\3\2\2\2\u00cf\u00c6\3\2"+
		"\2\2\u00cf\u00cb\3\2\2\2\u00d0\u0116\3\2\2\2\u00d1\u00d2\f\23\2\2\u00d2"+
		"\u00d3\t\7\2\2\u00d3\u0115\5\36\20\24\u00d4\u00d5\f\22\2\2\u00d5\u00d6"+
		"\t\4\2\2\u00d6\u0115\5\36\20\23\u00d7\u00d8\f\21\2\2\u00d8\u00d9\t\b\2"+
		"\2\u00d9\u0115\5\36\20\22\u00da\u00db\f\20\2\2\u00db\u00dc\t\t\2\2\u00dc"+
		"\u0115\5\36\20\21\u00dd\u00de\f\17\2\2\u00de\u00df\t\n\2\2\u00df\u0115"+
		"\5\36\20\20\u00e0\u00e1\f\16\2\2\u00e1\u00e2\7\13\2\2\u00e2\u0115\5\36"+
		"\20\17\u00e3\u00e4\f\r\2\2\u00e4\u00e5\7\16\2\2\u00e5\u0115\5\36\20\16"+
		"\u00e6\u00e7\f\f\2\2\u00e7\u00e8\7\r\2\2\u00e8\u0115\5\36\20\r\u00e9\u00ea"+
		"\f\13\2\2\u00ea\u00eb\7$\2\2\u00eb\u0115\5\36\20\f\u00ec\u00ed\f\n\2\2"+
		"\u00ed\u00ee\7&\2\2\u00ee\u0115\5\36\20\13\u00ef\u00f0\f\t\2\2\u00f0\u00f1"+
		"\7,\2\2\u00f1\u00f2\5\36\20\2\u00f2\u00f3\7.\2\2\u00f3\u00f4\5\36\20\n"+
		"\u00f4\u0115\3\2\2\2\u00f5\u00f6\f\7\2\2\u00f6\u00f7\t\13\2\2\u00f7\u0115"+
		"\5\36\20\7\u00f8\u00f9\f\6\2\2\u00f9\u00fa\7\f\2\2\u00fa\u0115\5\36\20"+
		"\7\u00fb\u00fc\f\33\2\2\u00fc\u0115\t\5\2\2\u00fd\u00fe\f\32\2\2\u00fe"+
		"\u00ff\7\34\2\2\u00ff\u0115\7H\2\2\u0100\u0101\f\31\2\2\u0101\u0102\7"+
		"\64\2\2\u0102\u0103\5\36\20\2\u0103\u0104\7\65\2\2\u0104\u0115\3\2\2\2"+
		"\u0105\u0106\f\30\2\2\u0106\u0115\5 \21\2\u0107\u0108\f\27\2\2\u0108\u010a"+
		"\7\66\2\2\u0109\u010b\5\34\17\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2"+
		"\2\u010b\u010c\3\2\2\2\u010c\u0115\7\67\2\2\u010d\u010e\f\b\2\2\u010e"+
		"\u010f\7,\2\2\u010f\u0112\5\4\3\2\u0110\u0111\7.\2\2\u0111\u0113\5\4\3"+
		"\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u00d1"+
		"\3\2\2\2\u0114\u00d4\3\2\2\2\u0114\u00d7\3\2\2\2\u0114\u00da\3\2\2\2\u0114"+
		"\u00dd\3\2\2\2\u0114\u00e0\3\2\2\2\u0114\u00e3\3\2\2\2\u0114\u00e6\3\2"+
		"\2\2\u0114\u00e9\3\2\2\2\u0114\u00ec\3\2\2\2\u0114\u00ef\3\2\2\2\u0114"+
		"\u00f5\3\2\2\2\u0114\u00f8\3\2\2\2\u0114\u00fb\3\2\2\2\u0114\u00fd\3\2"+
		"\2\2\u0114\u0100\3\2\2\2\u0114\u0105\3\2\2\2\u0114\u0107\3\2\2\2\u0114"+
		"\u010d\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\37\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\7\66\2\2\u011a\u011c"+
		"\5\26\f\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2"+
		"\u011d\u011f\7\67\2\2\u011e\u0119\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u0121\5\b\5\2\u0121!\3\2\2\2\u0122\u0123\t\f\2\2\u0123"+
		"#\3\2\2\2!\',\60\648:?NT_hlt|\u0085\u0089\u0092\u009b\u00a1\u00a8\u00b0"+
		"\u00bf\u00c3\u00c8\u00cf\u010a\u0112\u0114\u0116\u011b\u011e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
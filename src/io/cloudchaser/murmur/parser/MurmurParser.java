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
		RULE_identifierList = 10, RULE_initializerList = 11, RULE_expressionList = 12, 
		RULE_expression = 13, RULE_lambda = 14, RULE_literal = 15;
	public static final String[] ruleNames = {
		"compilationUnit", "statement", "keywordStatement", "block", "typeStatement", 
		"typeDeclaration", "typeElement", "iTypeStatement", "iTypeDeclaration", 
		"iTypeElement", "identifierList", "initializerList", "expressionList", 
		"expression", "lambda", "literal"
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
	public static class CompilationUnitContext extends MurmurRuleContext {
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
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftArrowElement) | (1L << RightArrowElement) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << BreakKeyword) | (1L << ContinueKeyword) | (1L << LetKeyword) | (1L << ReturnKeyword) | (1L << SuperKeyword))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ThisKeyword - 64)) | (1L << (ThrowKeyword - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(32); statement();
				}
				}
				setState(37);
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

	public static class StatementContext extends MurmurRuleContext {
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
			setState(54);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38); typeStatement();
				setState(40);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(39); match(SemicolonElement);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42); iTypeStatement();
				setState(44);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(43); match(SemicolonElement);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46); keywordStatement();
				setState(48);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(47); match(SemicolonElement);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(50); expression(0);
				setState(52);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(51); match(SemicolonElement);
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

	public static class KeywordStatementContext extends MurmurRuleContext {
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
			setState(74);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
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
				setState(57); ((KeywordStatementContext)_localctx).operator = match(ReturnKeyword);
				setState(59);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(58); expression(0);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61); ((KeywordStatementContext)_localctx).operator = match(ThrowKeyword);
				setState(62); expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(63); ((KeywordStatementContext)_localctx).operator = match(LetKeyword);
				setState(64); initializerList();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(65); ((KeywordStatementContext)_localctx).operator = match(LetKeyword);
				setState(66); identifierList();
				setState(67); match(RightArrowElement);
				setState(68); expression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(70); ((KeywordStatementContext)_localctx).operator = match(LeftArrowElement);
				setState(71); identifierList();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(72); ((KeywordStatementContext)_localctx).operator = match(RightArrowElement);
				setState(73); identifierList();
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

	public static class BlockContext extends MurmurRuleContext {
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
			setState(76); match(LeftBraceElement);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftArrowElement) | (1L << RightArrowElement) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << BreakKeyword) | (1L << ContinueKeyword) | (1L << LetKeyword) | (1L << ReturnKeyword) | (1L << SuperKeyword))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ThisKeyword - 64)) | (1L << (ThrowKeyword - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(77); statement();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83); match(RightBraceElement);
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

	public static class TypeStatementContext extends MurmurRuleContext {
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
			setState(85); ((TypeStatementContext)_localctx).name = match(Identifier);
			setState(86); match(AssignOperator);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(87); ((TypeStatementContext)_localctx).Identifier = match(Identifier);
				((TypeStatementContext)_localctx).parents.add(((TypeStatementContext)_localctx).Identifier);
				setState(88); match(AddOperator);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94); typeDeclaration();
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

	public static class TypeDeclarationContext extends MurmurRuleContext {
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
			setState(96); match(TypeKeyword);
			setState(97); match(LeftBraceElement);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ThisKeyword || _la==Identifier) {
				{
				{
				setState(98); typeElement();
				setState(100);
				_la = _input.LA(1);
				if (_la==SemicolonElement) {
					{
					setState(99); match(SemicolonElement);
					}
				}

				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107); match(RightBraceElement);
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

	public static class TypeElementContext extends MurmurRuleContext {
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
			setState(109);
			((TypeElementContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==ThisKeyword || _la==Identifier) ) {
				((TypeElementContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(112);
			_la = _input.LA(1);
			if (_la==AssignOperator) {
				{
				setState(110); match(AssignOperator);
				setState(111); expression(0);
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

	public static class ITypeStatementContext extends MurmurRuleContext {
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
			setState(114); ((ITypeStatementContext)_localctx).name = match(Identifier);
			setState(115); match(AssignOperator);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(116); ((ITypeStatementContext)_localctx).Identifier = match(Identifier);
				((ITypeStatementContext)_localctx).parents.add(((ITypeStatementContext)_localctx).Identifier);
				setState(117); match(AddOperator);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123); iTypeDeclaration();
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

	public static class ITypeDeclarationContext extends MurmurRuleContext {
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
			setState(125); match(ITypeKeyword);
			setState(126); match(LeftBraceElement);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(127); iTypeElement();
				setState(129);
				_la = _input.LA(1);
				if (_la==SemicolonElement) {
					{
					setState(128); match(SemicolonElement);
					}
				}

				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136); match(RightBraceElement);
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

	public static class ITypeElementContext extends MurmurRuleContext {
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
			setState(138); ((ITypeElementContext)_localctx).name = match(Identifier);
			setState(139); match(AssignOperator);
			setState(140); match(LeftParenElement);
			setState(142);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(141); identifierList();
				}
			}

			setState(144); match(RightParenElement);
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

	public static class IdentifierListContext extends MurmurRuleContext {
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
			setState(146); match(Identifier);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(147); match(CommaOperator);
					setState(148); match(Identifier);
					}
					} 
				}
				setState(153);
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

	public static class InitializerListContext extends MurmurRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MurmurParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MurmurParser.Identifier, i);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		enterRule(_localctx, 22, RULE_initializerList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154); match(Identifier);
			setState(157);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(155); match(AssignOperator);
				setState(156); expression(0);
				}
				break;
			}
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(159); match(CommaOperator);
					setState(160); match(Identifier);
					setState(163);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(161); match(AssignOperator);
						setState(162); expression(0);
						}
						break;
					}
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class ExpressionListContext extends MurmurRuleContext {
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
		enterRule(_localctx, 24, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); expression(0);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CommaOperator) {
				{
				{
				setState(171); match(CommaOperator);
				setState(172); expression(0);
				}
				}
				setState(177);
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

	public static class ExpressionContext extends MurmurRuleContext {
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(179);
				((ExpressionContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==AddOperator || _la==SubtractOperator) ) {
					((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(180); ((ExpressionContext)_localctx).right = expression(18);
				}
				break;
			case 2:
				{
				setState(181);
				((ExpressionContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==DecrementOperator || _la==IncrementOperator) ) {
					((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(182); ((ExpressionContext)_localctx).right = expression(17);
				}
				break;
			case 3:
				{
				setState(183);
				((ExpressionContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==BinaryNotOperator || _la==LogicalNotOperator) ) {
					((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(184); ((ExpressionContext)_localctx).right = expression(16);
				}
				break;
			case 4:
				{
				setState(185); literal();
				}
				break;
			case 5:
				{
				setState(186); match(Identifier);
				}
				break;
			case 6:
				{
				setState(187); lambda();
				}
				break;
			case 7:
				{
				setState(188); match(LeftBracketElement);
				setState(190);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << SuperKeyword))) != 0) || _la==ThisKeyword || _la==Identifier) {
					{
					setState(189); ((ExpressionContext)_localctx).left = expression(0);
					}
				}

				setState(192); ((ExpressionContext)_localctx).operator = match(CommaOperator);
				setState(194);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << SuperKeyword))) != 0) || _la==ThisKeyword || _la==Identifier) {
					{
					setState(193); ((ExpressionContext)_localctx).right = expression(0);
					}
				}

				setState(196); match(RightBracketElement);
				}
				break;
			case 8:
				{
				setState(197); match(LeftParenElement);
				setState(198); ((ExpressionContext)_localctx).inner = expression(0);
				setState(199); match(RightParenElement);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(267);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(203);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(204);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DivideOperator) | (1L << ModuloOperator) | (1L << MultiplyOperator))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(205); ((ExpressionContext)_localctx).right = expression(16);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(206);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(207);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOperator) | (1L << BinaryNotOperator) | (1L << SubtractOperator))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(208); ((ExpressionContext)_localctx).right = expression(15);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(210);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShiftOperator || _la==RightShiftOperator) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(211); ((ExpressionContext)_localctx).right = expression(14);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(212);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(213);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GreaterOrEqualOperator) | (1L << GreaterThanOperator) | (1L << LessOrEqualOperator) | (1L << LessThanOperator))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(214); ((ExpressionContext)_localctx).right = expression(13);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(215);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(216);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EqualsOperator || _la==NotEqualsOperator) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(217); ((ExpressionContext)_localctx).right = expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(218);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(219); ((ExpressionContext)_localctx).operator = match(BinaryAndOperator);
						setState(220); ((ExpressionContext)_localctx).right = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(221);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(222); ((ExpressionContext)_localctx).operator = match(BinaryXorOperator);
						setState(223); ((ExpressionContext)_localctx).right = expression(10);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(224);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(225); ((ExpressionContext)_localctx).operator = match(BinaryOrOperator);
						setState(226); ((ExpressionContext)_localctx).right = expression(9);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(227);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(228); ((ExpressionContext)_localctx).operator = match(LogicalAndOperator);
						setState(229); ((ExpressionContext)_localctx).right = expression(8);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(230);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(231); ((ExpressionContext)_localctx).operator = match(LogicalOrOperator);
						setState(232); ((ExpressionContext)_localctx).right = expression(7);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.clause = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(233);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(234); ((ExpressionContext)_localctx).operator = match(TernaryConditionOperator);
						setState(235); expression(0);
						setState(236); match(ColonElement);
						setState(237); expression(6);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(239);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(240);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AssignOperator) | (1L << CompoundAddOperator) | (1L << CompoundBinaryAndOperator) | (1L << CompoundBinaryOrOperator) | (1L << CompoundBinaryXorOperator) | (1L << CompoundDivideOperator) | (1L << CompoundLeftShiftOperator) | (1L << CompoundModuloOperator) | (1L << CompoundMultiplyOperator) | (1L << CompoundRightShiftOperator) | (1L << CompoundSubtractOperator))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(241); ((ExpressionContext)_localctx).right = expression(3);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(243);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DecrementOperator || _la==IncrementOperator) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(245); ((ExpressionContext)_localctx).operator = match(DotOperator);
						setState(246); ((ExpressionContext)_localctx).name = match(Identifier);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(248); ((ExpressionContext)_localctx).operator = match(LeftBracketElement);
						setState(249); ((ExpressionContext)_localctx).index = expression(0);
						setState(250); match(RightBracketElement);
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(253); lambda();
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(254);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(255); ((ExpressionContext)_localctx).operator = match(LeftParenElement);
						setState(257);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << BooleanLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << AddOperator) | (1L << BinaryNotOperator) | (1L << DecrementOperator) | (1L << IncrementOperator) | (1L << LogicalNotOperator) | (1L << SubtractOperator) | (1L << LeftBraceElement) | (1L << LeftBracketElement) | (1L << LeftParenElement) | (1L << SuperKeyword))) != 0) || _la==ThisKeyword || _la==Identifier) {
							{
							setState(256); expressionList();
							}
						}

						setState(259); match(RightParenElement);
						}
						break;
					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.clause = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(260);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(261); ((ExpressionContext)_localctx).operator = match(TernaryConditionOperator);
						setState(262); statement();
						setState(265);
						switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
						case 1:
							{
							setState(263); match(ColonElement);
							setState(264); statement();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(271);
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

	public static class LambdaContext extends MurmurRuleContext {
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
		enterRule(_localctx, 28, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if (_la==LeftParenElement) {
				{
				setState(272); match(LeftParenElement);
				setState(274);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(273); identifierList();
					}
				}

				setState(276); match(RightParenElement);
				}
			}

			setState(279); block();
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

	public static class LiteralContext extends MurmurRuleContext {
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
		enterRule(_localctx, 30, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
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
		case 13: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 15);
		case 1: return precpred(_ctx, 14);
		case 2: return precpred(_ctx, 13);
		case 3: return precpred(_ctx, 12);
		case 4: return precpred(_ctx, 11);
		case 5: return precpred(_ctx, 10);
		case 6: return precpred(_ctx, 9);
		case 7: return precpred(_ctx, 8);
		case 8: return precpred(_ctx, 7);
		case 9: return precpred(_ctx, 6);
		case 10: return precpred(_ctx, 5);
		case 11: return precpred(_ctx, 3);
		case 12: return precpred(_ctx, 23);
		case 13: return precpred(_ctx, 22);
		case 14: return precpred(_ctx, 21);
		case 15: return precpred(_ctx, 20);
		case 16: return precpred(_ctx, 19);
		case 17: return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3K\u011e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\3\3\3\5\3+\n\3\3\3\3\3\5\3/\n\3\3\3\3\3\5\3\63\n"+
		"\3\3\3\3\3\5\3\67\n\3\5\39\n\3\3\4\3\4\3\4\5\4>\n\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4M\n\4\3\5\3\5\7\5Q\n\5\f\5\16\5"+
		"T\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\5\7g\n\7\7\7i\n\7\f\7\16\7l\13\7\3\7\3\7\3\b\3\b\3\b\5\bs\n"+
		"\b\3\t\3\t\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n"+
		"\u0084\n\n\7\n\u0086\n\n\f\n\16\n\u0089\13\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\5\13\u0091\n\13\3\13\3\13\3\f\3\f\3\f\7\f\u0098\n\f\f\f\16\f\u009b"+
		"\13\f\3\r\3\r\3\r\5\r\u00a0\n\r\3\r\3\r\3\r\3\r\5\r\u00a6\n\r\7\r\u00a8"+
		"\n\r\f\r\16\r\u00ab\13\r\3\16\3\16\3\16\7\16\u00b0\n\16\f\16\16\16\u00b3"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00c1\n\17\3\17\3\17\5\17\u00c5\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00cc"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u0104\n\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u010c\n\17\7\17\u010e\n"+
		"\17\f\17\16\17\u0111\13\17\3\20\3\20\5\20\u0115\n\20\3\20\5\20\u0118\n"+
		"\20\3\20\3\20\3\21\3\21\3\21\2\3\34\22\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \2\16\3\29:\4\2BBHH\4\2\t\t++\4\2\32\32  \4\2\f\f%%\4\2\33\33\'"+
		"(\5\2\t\t\f\f++\4\2!!**\4\2\36\37\"#\4\2\35\35))\4\2\n\n\20\31\4\2\3\b"+
		"AB\u0149\2%\3\2\2\2\48\3\2\2\2\6L\3\2\2\2\bN\3\2\2\2\nW\3\2\2\2\fb\3\2"+
		"\2\2\16o\3\2\2\2\20t\3\2\2\2\22\177\3\2\2\2\24\u008c\3\2\2\2\26\u0094"+
		"\3\2\2\2\30\u009c\3\2\2\2\32\u00ac\3\2\2\2\34\u00cb\3\2\2\2\36\u0117\3"+
		"\2\2\2 \u011b\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2"+
		"\2\2&\3\3\2\2\2\'%\3\2\2\2(*\5\n\6\2)+\7/\2\2*)\3\2\2\2*+\3\2\2\2+9\3"+
		"\2\2\2,.\5\20\t\2-/\7/\2\2.-\3\2\2\2./\3\2\2\2/9\3\2\2\2\60\62\5\6\4\2"+
		"\61\63\7/\2\2\62\61\3\2\2\2\62\63\3\2\2\2\639\3\2\2\2\64\66\5\34\17\2"+
		"\65\67\7/\2\2\66\65\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28(\3\2\2\28,\3\2"+
		"\2\28\60\3\2\2\28\64\3\2\2\29\5\3\2\2\2:M\t\2\2\2;=\7@\2\2<>\5\34\17\2"+
		"=<\3\2\2\2=>\3\2\2\2>M\3\2\2\2?@\7C\2\2@M\5\34\17\2AB\7=\2\2BM\5\30\r"+
		"\2CD\7=\2\2DE\5\26\f\2EF\7\61\2\2FG\5\34\17\2GM\3\2\2\2HI\7\60\2\2IM\5"+
		"\26\f\2JK\7\61\2\2KM\5\26\f\2L:\3\2\2\2L;\3\2\2\2L?\3\2\2\2LA\3\2\2\2"+
		"LC\3\2\2\2LH\3\2\2\2LJ\3\2\2\2M\7\3\2\2\2NR\7\62\2\2OQ\5\4\3\2PO\3\2\2"+
		"\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7\63\2\2V\t\3\2"+
		"\2\2WX\7H\2\2X]\7\n\2\2YZ\7H\2\2Z\\\7\t\2\2[Y\3\2\2\2\\_\3\2\2\2][\3\2"+
		"\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\5\f\7\2a\13\3\2\2\2bc\7D\2\2cj\7"+
		"\62\2\2df\5\16\b\2eg\7/\2\2fe\3\2\2\2fg\3\2\2\2gi\3\2\2\2hd\3\2\2\2il"+
		"\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\63\2\2n\r\3\2\2\2"+
		"or\t\3\2\2pq\7\n\2\2qs\5\34\17\2rp\3\2\2\2rs\3\2\2\2s\17\3\2\2\2tu\7H"+
		"\2\2uz\7\n\2\2vw\7H\2\2wy\7\t\2\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2"+
		"\2\2{}\3\2\2\2|z\3\2\2\2}~\5\22\n\2~\21\3\2\2\2\177\u0080\7<\2\2\u0080"+
		"\u0087\7\62\2\2\u0081\u0083\5\24\13\2\u0082\u0084\7/\2\2\u0083\u0082\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0081\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\63\2\2\u008b\23\3\2\2\2\u008c\u008d"+
		"\7H\2\2\u008d\u008e\7\n\2\2\u008e\u0090\7\66\2\2\u008f\u0091\5\26\f\2"+
		"\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\7\67\2\2\u0093\25\3\2\2\2\u0094\u0099\7H\2\2\u0095\u0096\7\17\2\2\u0096"+
		"\u0098\7H\2\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\27\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009f"+
		"\7H\2\2\u009d\u009e\7\n\2\2\u009e\u00a0\5\34\17\2\u009f\u009d\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u00a9\3\2\2\2\u00a1\u00a2\7\17\2\2\u00a2\u00a5"+
		"\7H\2\2\u00a3\u00a4\7\n\2\2\u00a4\u00a6\5\34\17\2\u00a5\u00a3\3\2\2\2"+
		"\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a8\u00ab"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\31\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\u00b1\5\34\17\2\u00ad\u00ae\7\17\2\2\u00ae\u00b0"+
		"\5\34\17\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2"+
		"\u00b1\u00b2\3\2\2\2\u00b2\33\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5"+
		"\b\17\1\2\u00b5\u00b6\t\4\2\2\u00b6\u00cc\5\34\17\24\u00b7\u00b8\t\5\2"+
		"\2\u00b8\u00cc\5\34\17\23\u00b9\u00ba\t\6\2\2\u00ba\u00cc\5\34\17\22\u00bb"+
		"\u00cc\5 \21\2\u00bc\u00cc\7H\2\2\u00bd\u00cc\5\36\20\2\u00be\u00c0\7"+
		"\64\2\2\u00bf\u00c1\5\34\17\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2"+
		"\u00c1\u00c2\3\2\2\2\u00c2\u00c4\7\17\2\2\u00c3\u00c5\5\34\17\2\u00c4"+
		"\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00cc\7\65"+
		"\2\2\u00c7\u00c8\7\66\2\2\u00c8\u00c9\5\34\17\2\u00c9\u00ca\7\67\2\2\u00ca"+
		"\u00cc\3\2\2\2\u00cb\u00b4\3\2\2\2\u00cb\u00b7\3\2\2\2\u00cb\u00b9\3\2"+
		"\2\2\u00cb\u00bb\3\2\2\2\u00cb\u00bc\3\2\2\2\u00cb\u00bd\3\2\2\2\u00cb"+
		"\u00be\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cc\u010f\3\2\2\2\u00cd\u00ce\f\21"+
		"\2\2\u00ce\u00cf\t\7\2\2\u00cf\u010e\5\34\17\22\u00d0\u00d1\f\20\2\2\u00d1"+
		"\u00d2\t\b\2\2\u00d2\u010e\5\34\17\21\u00d3\u00d4\f\17\2\2\u00d4\u00d5"+
		"\t\t\2\2\u00d5\u010e\5\34\17\20\u00d6\u00d7\f\16\2\2\u00d7\u00d8\t\n\2"+
		"\2\u00d8\u010e\5\34\17\17\u00d9\u00da\f\r\2\2\u00da\u00db\t\13\2\2\u00db"+
		"\u010e\5\34\17\16\u00dc\u00dd\f\f\2\2\u00dd\u00de\7\13\2\2\u00de\u010e"+
		"\5\34\17\r\u00df\u00e0\f\13\2\2\u00e0\u00e1\7\16\2\2\u00e1\u010e\5\34"+
		"\17\f\u00e2\u00e3\f\n\2\2\u00e3\u00e4\7\r\2\2\u00e4\u010e\5\34\17\13\u00e5"+
		"\u00e6\f\t\2\2\u00e6\u00e7\7$\2\2\u00e7\u010e\5\34\17\n\u00e8\u00e9\f"+
		"\b\2\2\u00e9\u00ea\7&\2\2\u00ea\u010e\5\34\17\t\u00eb\u00ec\f\7\2\2\u00ec"+
		"\u00ed\7,\2\2\u00ed\u00ee\5\34\17\2\u00ee\u00ef\7.\2\2\u00ef\u00f0\5\34"+
		"\17\b\u00f0\u010e\3\2\2\2\u00f1\u00f2\f\5\2\2\u00f2\u00f3\t\f\2\2\u00f3"+
		"\u010e\5\34\17\5\u00f4\u00f5\f\31\2\2\u00f5\u010e\t\5\2\2\u00f6\u00f7"+
		"\f\30\2\2\u00f7\u00f8\7\34\2\2\u00f8\u010e\7H\2\2\u00f9\u00fa\f\27\2\2"+
		"\u00fa\u00fb\7\64\2\2\u00fb\u00fc\5\34\17\2\u00fc\u00fd\7\65\2\2\u00fd"+
		"\u010e\3\2\2\2\u00fe\u00ff\f\26\2\2\u00ff\u010e\5\36\20\2\u0100\u0101"+
		"\f\25\2\2\u0101\u0103\7\66\2\2\u0102\u0104\5\32\16\2\u0103\u0102\3\2\2"+
		"\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u010e\7\67\2\2\u0106"+
		"\u0107\f\6\2\2\u0107\u0108\7,\2\2\u0108\u010b\5\4\3\2\u0109\u010a\7.\2"+
		"\2\u010a\u010c\5\4\3\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e"+
		"\3\2\2\2\u010d\u00cd\3\2\2\2\u010d\u00d0\3\2\2\2\u010d\u00d3\3\2\2\2\u010d"+
		"\u00d6\3\2\2\2\u010d\u00d9\3\2\2\2\u010d\u00dc\3\2\2\2\u010d\u00df\3\2"+
		"\2\2\u010d\u00e2\3\2\2\2\u010d\u00e5\3\2\2\2\u010d\u00e8\3\2\2\2\u010d"+
		"\u00eb\3\2\2\2\u010d\u00f1\3\2\2\2\u010d\u00f4\3\2\2\2\u010d\u00f6\3\2"+
		"\2\2\u010d\u00f9\3\2\2\2\u010d\u00fe\3\2\2\2\u010d\u0100\3\2\2\2\u010d"+
		"\u0106\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\35\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0114\7\66\2\2\u0113\u0115"+
		"\5\26\f\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2"+
		"\u0116\u0118\7\67\2\2\u0117\u0112\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119"+
		"\3\2\2\2\u0119\u011a\5\b\5\2\u011a\37\3\2\2\2\u011b\u011c\t\r\2\2\u011c"+
		"!\3\2\2\2!%*.\62\668=LR]fjrz\u0083\u0087\u0090\u0099\u009f\u00a5\u00a9"+
		"\u00b1\u00c0\u00c4\u00cb\u0103\u010b\u010d\u010f\u0114\u0117";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
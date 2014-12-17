// Generated from C:\Users\Mihail\Documents\NetBeansProjects\Murmur\src\grammar\MurmurLexer.g4 by ANTLR 4.4
package io.cloudchaser.murmur.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MurmurLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IntegerLiteral=1, DecimalLiteral=2, BooleanLiteral=3, CharacterLiteral=4, 
		StringLiteral=5, NullLiteral=6, AddOperator=7, AssignOperator=8, BinaryAndOperator=9, 
		BinaryNotOperator=10, BinaryOrOperator=11, BinaryXorOperator=12, CommaOperator=13, 
		CompoundAddOperator=14, CompoundBinaryAndOperator=15, CompoundBinaryOrOperator=16, 
		CompoundBinaryXorOperator=17, CompoundDivideOperator=18, CompoundLeftShiftOperator=19, 
		CompoundModuloOperator=20, CompoundMultiplyOperator=21, CompoundRightShiftOperator=22, 
		CompoundSubtractOperator=23, DecrementOperator=24, DivideOperator=25, 
		DotOperator=26, EqualsOperator=27, GreaterOrEqualOperator=28, GreaterThanOperator=29, 
		IncrementOperator=30, LeftShiftOperator=31, LessOrEqualOperator=32, LessThanOperator=33, 
		LogicalAndOperator=34, LogicalNotOperator=35, LogicalOrOperator=36, ModuloOperator=37, 
		MultiplyOperator=38, NotEqualsOperator=39, RangeOperator=40, RightShiftOperator=41, 
		SubtractOperator=42, TernaryConditionOperator=43, TernaryIterativeOperator=44, 
		ColonElement=45, SemicolonElement=46, LeftArrowElement=47, RightArrowElement=48, 
		LeftBraceElement=49, RightBraceElement=50, LeftBracketElement=51, RightBracketElement=52, 
		LeftParenElement=53, RightParenElement=54, AssertKeyword=55, BreakKeyword=56, 
		ContinueKeyword=57, ImportKeyword=58, ITypeKeyword=59, LetKeyword=60, 
		ModuleKeyword=61, NewKeyword=62, ReturnKeyword=63, SuperKeyword=64, ThisKeyword=65, 
		ThrowKeyword=66, TypeKeyword=67, PrivateKeyword=68, ProtectedKeyword=69, 
		PublicKeyword=70, Identifier=71, Whitespace=72, LineComment=73, BlockComment=74;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='", "'>'", "'?'", "'@'", "'A'", "'B'", "'C'", "'D'", "'E'", 
		"'F'", "'G'", "'H'", "'I'", "'J'"
	};
	public static final String[] ruleNames = {
		"IntegerLiteral", "DecimalLiteral", "Base10IntegerLiteral", "Base10Integer", 
		"Base10Digits", "Base10Elements", "Base10Digit", "Base10NonZero", "Base16IntegerLiteral", 
		"Base16Integer", "Base16Digits", "Base16Elements", "Base16Digit", "Base8IntegerLiteral", 
		"Base8Integer", "Base8Digits", "Base8Elements", "Base8Digit", "Base2IntegerLiteral", 
		"Base2Integer", "Base2Digits", "Base2Elements", "Base2Digit", "IntegerSuffix", 
		"Base10DecimalLiteral", "Base10Value", "Base10Exponent", "Base16DecimalLiteral", 
		"Base16Exponent", "DecimalSuffix", "BooleanLiteral", "CharacterLiteral", 
		"EscapedCharacter", "StringLiteral", "NullLiteral", "AddOperator", "AssignOperator", 
		"BinaryAndOperator", "BinaryNotOperator", "BinaryOrOperator", "BinaryXorOperator", 
		"CommaOperator", "CompoundAddOperator", "CompoundBinaryAndOperator", "CompoundBinaryOrOperator", 
		"CompoundBinaryXorOperator", "CompoundDivideOperator", "CompoundLeftShiftOperator", 
		"CompoundModuloOperator", "CompoundMultiplyOperator", "CompoundRightShiftOperator", 
		"CompoundSubtractOperator", "DecrementOperator", "DivideOperator", "DotOperator", 
		"EqualsOperator", "GreaterOrEqualOperator", "GreaterThanOperator", "IncrementOperator", 
		"LeftShiftOperator", "LessOrEqualOperator", "LessThanOperator", "LogicalAndOperator", 
		"LogicalNotOperator", "LogicalOrOperator", "ModuloOperator", "MultiplyOperator", 
		"NotEqualsOperator", "RangeOperator", "RightShiftOperator", "SubtractOperator", 
		"TernaryConditionOperator", "TernaryIterativeOperator", "ColonElement", 
		"SemicolonElement", "LeftArrowElement", "RightArrowElement", "LeftBraceElement", 
		"RightBraceElement", "LeftBracketElement", "RightBracketElement", "LeftParenElement", 
		"RightParenElement", "AssertKeyword", "BreakKeyword", "ContinueKeyword", 
		"ImportKeyword", "ITypeKeyword", "LetKeyword", "ModuleKeyword", "NewKeyword", 
		"ReturnKeyword", "SuperKeyword", "ThisKeyword", "ThrowKeyword", "TypeKeyword", 
		"PrivateKeyword", "ProtectedKeyword", "PublicKeyword", "Identifier", "IdentifierFirst", 
		"IdentifierLast", "Whitespace", "LineComment", "BlockComment"
	};


	public MurmurLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MurmurLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2L\u02c8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\3\2\3"+
		"\2\3\2\3\2\5\2\u00da\n\2\3\3\3\3\5\3\u00de\n\3\3\4\3\4\5\4\u00e2\n\4\3"+
		"\5\3\5\5\5\u00e6\n\5\3\6\3\6\5\6\u00ea\n\6\3\6\5\6\u00ed\n\6\3\7\3\7\6"+
		"\7\u00f1\n\7\r\7\16\7\u00f2\3\b\3\b\5\b\u00f7\n\b\3\t\3\t\3\n\3\n\5\n"+
		"\u00fd\n\n\3\13\3\13\3\13\3\13\3\f\3\f\5\f\u0105\n\f\3\f\5\f\u0108\n\f"+
		"\3\r\3\r\6\r\u010c\n\r\r\r\16\r\u010d\3\16\3\16\3\17\3\17\5\17\u0114\n"+
		"\17\3\20\3\20\7\20\u0118\n\20\f\20\16\20\u011b\13\20\3\20\3\20\3\21\3"+
		"\21\5\21\u0121\n\21\3\21\5\21\u0124\n\21\3\22\3\22\6\22\u0128\n\22\r\22"+
		"\16\22\u0129\3\23\3\23\3\24\3\24\5\24\u0130\n\24\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\5\26\u0138\n\26\3\26\5\26\u013b\n\26\3\27\3\27\6\27\u013f\n\27"+
		"\r\27\16\27\u0140\3\30\3\30\3\31\3\31\3\32\3\32\5\32\u0149\n\32\3\32\3"+
		"\32\5\32\u014d\n\32\3\32\5\32\u0150\n\32\3\32\5\32\u0153\n\32\3\32\3\32"+
		"\3\32\5\32\u0158\n\32\3\32\5\32\u015b\n\32\3\32\3\32\3\32\5\32\u0160\n"+
		"\32\3\32\3\32\3\32\5\32\u0165\n\32\3\33\3\33\5\33\u0169\n\33\3\33\5\33"+
		"\u016c\n\33\3\34\3\34\5\34\u0170\n\34\3\34\3\34\3\35\3\35\5\35\u0176\n"+
		"\35\3\35\3\35\5\35\u017a\n\35\3\35\3\35\3\35\5\35\u017f\n\35\3\35\3\35"+
		"\3\35\3\35\5\35\u0185\n\35\5\35\u0187\n\35\3\36\3\36\5\36\u018b\n\36\3"+
		"\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u019a\n \3!\3!\3!\5!"+
		"\u019f\n!\3!\3!\3\"\3\"\3\"\5\"\u01a6\n\"\3\"\5\"\u01a9\n\"\3\"\5\"\u01ac"+
		"\n\"\3#\3#\3#\7#\u01b1\n#\f#\16#\u01b4\13#\3#\3#\3$\3$\3$\3$\3$\3%\3%"+
		"\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3"+
		"/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\38\38\39"+
		"\39\39\3:\3:\3:\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3@\3@\3@\3A\3A"+
		"\3B\3B\3B\3C\3C\3D\3D\3E\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3I\3I\3J\3J\3K"+
		"\3K\3L\3L\3M\3M\3M\3N\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U"+
		"\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3V\3W\3W\3W\3W\3W\3W\3W\3W\3W\3X\3X\3X"+
		"\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3[\3[\3[\3\\\3"+
		"\\\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3^\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3`\3"+
		"`\3`\3`\3`\3`\3a\3a\3a\3a\3a\3b\3b\3b\3b\3b\3b\3b\3b\3c\3c\3c\3c\3c\3"+
		"c\3c\3c\3c\3c\3d\3d\3d\3d\3d\3d\3d\3e\3e\7e\u02a0\ne\fe\16e\u02a3\13e"+
		"\3f\3f\3g\3g\3h\6h\u02aa\nh\rh\16h\u02ab\3h\3h\3i\3i\3i\3i\7i\u02b4\n"+
		"i\fi\16i\u02b7\13i\3i\3i\3j\3j\3j\3j\7j\u02bf\nj\fj\16j\u02c2\13j\3j\3"+
		"j\3j\3j\3j\5\u0119\u01b2\u02c0\2k\3\3\5\4\7\2\t\2\13\2\r\2\17\2\21\2\23"+
		"\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65"+
		"\2\67\29\2;\2=\2?\5A\6C\2E\7G\bI\tK\nM\13O\fQ\rS\16U\17W\20Y\21[\22]\23"+
		"_\24a\25c\26e\27g\30i\31k\32m\33o\34q\35s\36u\37w y!{\"}#\177$\u0081%"+
		"\u0083&\u0085\'\u0087(\u0089)\u008b*\u008d+\u008f,\u0091-\u0093.\u0095"+
		"/\u0097\60\u0099\61\u009b\62\u009d\63\u009f\64\u00a1\65\u00a3\66\u00a5"+
		"\67\u00a78\u00a99\u00ab:\u00ad;\u00af<\u00b1=\u00b3>\u00b5?\u00b7@\u00b9"+
		"A\u00bbB\u00bdC\u00bfD\u00c1E\u00c3F\u00c5G\u00c7H\u00c9I\u00cb\2\u00cd"+
		"\2\u00cfJ\u00d1K\u00d3L\3\2\32\3\2\62\62\3\2aa\3\2\63;\4\2ZZzz\5\2\62"+
		";CHch\3\2\629\4\2DDdd\3\2\62\63\4\2NNnn\4\2GGgg\4\2--//\4\2RRrr\6\2FF"+
		"HHffhh\3\2))\4\2))^^\3\2^^\13\2$$))\62\62^^ddhhppttvv\3\2\62\65\3\2$$"+
		"\4\2$$^^\6\2&&C\\aac|\7\2&&\62;C\\aac|\5\2\13\f\17\17\"\"\3\2\f\f\u02e1"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3"+
		"\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2"+
		"\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb"+
		"\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2"+
		"\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1"+
		"\3\2\2\2\2\u00d3\3\2\2\2\3\u00d9\3\2\2\2\5\u00dd\3\2\2\2\7\u00df\3\2\2"+
		"\2\t\u00e5\3\2\2\2\13\u00e7\3\2\2\2\r\u00f0\3\2\2\2\17\u00f6\3\2\2\2\21"+
		"\u00f8\3\2\2\2\23\u00fa\3\2\2\2\25\u00fe\3\2\2\2\27\u0102\3\2\2\2\31\u010b"+
		"\3\2\2\2\33\u010f\3\2\2\2\35\u0111\3\2\2\2\37\u0115\3\2\2\2!\u011e\3\2"+
		"\2\2#\u0127\3\2\2\2%\u012b\3\2\2\2\'\u012d\3\2\2\2)\u0131\3\2\2\2+\u0135"+
		"\3\2\2\2-\u013e\3\2\2\2/\u0142\3\2\2\2\61\u0144\3\2\2\2\63\u0164\3\2\2"+
		"\2\65\u0166\3\2\2\2\67\u016d\3\2\2\29\u0186\3\2\2\2;\u0188\3\2\2\2=\u018e"+
		"\3\2\2\2?\u0199\3\2\2\2A\u019b\3\2\2\2C\u01a2\3\2\2\2E\u01ad\3\2\2\2G"+
		"\u01b7\3\2\2\2I\u01bc\3\2\2\2K\u01be\3\2\2\2M\u01c0\3\2\2\2O\u01c2\3\2"+
		"\2\2Q\u01c4\3\2\2\2S\u01c6\3\2\2\2U\u01c8\3\2\2\2W\u01ca\3\2\2\2Y\u01cd"+
		"\3\2\2\2[\u01d0\3\2\2\2]\u01d3\3\2\2\2_\u01d6\3\2\2\2a\u01d9\3\2\2\2c"+
		"\u01dd\3\2\2\2e\u01e0\3\2\2\2g\u01e3\3\2\2\2i\u01e7\3\2\2\2k\u01ea\3\2"+
		"\2\2m\u01ed\3\2\2\2o\u01ef\3\2\2\2q\u01f1\3\2\2\2s\u01f4\3\2\2\2u\u01f7"+
		"\3\2\2\2w\u01f9\3\2\2\2y\u01fc\3\2\2\2{\u01ff\3\2\2\2}\u0202\3\2\2\2\177"+
		"\u0204\3\2\2\2\u0081\u0207\3\2\2\2\u0083\u0209\3\2\2\2\u0085\u020c\3\2"+
		"\2\2\u0087\u020e\3\2\2\2\u0089\u0210\3\2\2\2\u008b\u0213\3\2\2\2\u008d"+
		"\u0216\3\2\2\2\u008f\u0219\3\2\2\2\u0091\u021b\3\2\2\2\u0093\u021d\3\2"+
		"\2\2\u0095\u021f\3\2\2\2\u0097\u0221\3\2\2\2\u0099\u0223\3\2\2\2\u009b"+
		"\u0226\3\2\2\2\u009d\u0229\3\2\2\2\u009f\u022b\3\2\2\2\u00a1\u022d\3\2"+
		"\2\2\u00a3\u022f\3\2\2\2\u00a5\u0231\3\2\2\2\u00a7\u0233\3\2\2\2\u00a9"+
		"\u0235\3\2\2\2\u00ab\u023c\3\2\2\2\u00ad\u0242\3\2\2\2\u00af\u024b\3\2"+
		"\2\2\u00b1\u0252\3\2\2\2\u00b3\u0258\3\2\2\2\u00b5\u025c\3\2\2\2\u00b7"+
		"\u0263\3\2\2\2\u00b9\u0267\3\2\2\2\u00bb\u026e\3\2\2\2\u00bd\u0274\3\2"+
		"\2\2\u00bf\u0279\3\2\2\2\u00c1\u027f\3\2\2\2\u00c3\u0284\3\2\2\2\u00c5"+
		"\u028c\3\2\2\2\u00c7\u0296\3\2\2\2\u00c9\u029d\3\2\2\2\u00cb\u02a4\3\2"+
		"\2\2\u00cd\u02a6\3\2\2\2\u00cf\u02a9\3\2\2\2\u00d1\u02af\3\2\2\2\u00d3"+
		"\u02ba\3\2\2\2\u00d5\u00da\5\7\4\2\u00d6\u00da\5\23\n\2\u00d7\u00da\5"+
		"\35\17\2\u00d8\u00da\5\'\24\2\u00d9\u00d5\3\2\2\2\u00d9\u00d6\3\2\2\2"+
		"\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\4\3\2\2\2\u00db\u00de\5"+
		"\63\32\2\u00dc\u00de\59\35\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de"+
		"\6\3\2\2\2\u00df\u00e1\5\t\5\2\u00e0\u00e2\5\61\31\2\u00e1\u00e0\3\2\2"+
		"\2\u00e1\u00e2\3\2\2\2\u00e2\b\3\2\2\2\u00e3\u00e6\t\2\2\2\u00e4\u00e6"+
		"\5\13\6\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\n\3\2\2\2\u00e7"+
		"\u00ec\5\21\t\2\u00e8\u00ea\5\r\7\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3"+
		"\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\5\17\b\2\u00ec\u00e9\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\f\3\2\2\2\u00ee\u00f1\5\17\b\2\u00ef\u00f1\t\3\2"+
		"\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\16\3\2\2\2\u00f4\u00f7\t\2\2\2\u00f5"+
		"\u00f7\5\21\t\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\20\3\2\2"+
		"\2\u00f8\u00f9\t\4\2\2\u00f9\22\3\2\2\2\u00fa\u00fc\5\25\13\2\u00fb\u00fd"+
		"\5\61\31\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\24\3\2\2\2\u00fe"+
		"\u00ff\t\2\2\2\u00ff\u0100\t\5\2\2\u0100\u0101\5\27\f\2\u0101\26\3\2\2"+
		"\2\u0102\u0107\5\33\16\2\u0103\u0105\5\31\r\2\u0104\u0103\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\5\33\16\2\u0107\u0104\3"+
		"\2\2\2\u0107\u0108\3\2\2\2\u0108\30\3\2\2\2\u0109\u010c\5\33\16\2\u010a"+
		"\u010c\t\3\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\32\3\2\2\2\u010f\u0110"+
		"\t\6\2\2\u0110\34\3\2\2\2\u0111\u0113\5\37\20\2\u0112\u0114\5\61\31\2"+
		"\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\36\3\2\2\2\u0115\u0119"+
		"\t\2\2\2\u0116\u0118\t\3\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011c\u011d\5!\21\2\u011d \3\2\2\2\u011e\u0123\5%\23\2\u011f\u0121"+
		"\5#\22\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0124\5%\23\2\u0123\u0120\3\2\2\2\u0123\u0124\3\2\2\2\u0124\"\3\2\2\2"+
		"\u0125\u0128\5%\23\2\u0126\u0128\t\3\2\2\u0127\u0125\3\2\2\2\u0127\u0126"+
		"\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"$\3\2\2\2\u012b\u012c\t\7\2\2\u012c&\3\2\2\2\u012d\u012f\5)\25\2\u012e"+
		"\u0130\5\61\31\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130(\3\2\2"+
		"\2\u0131\u0132\t\2\2\2\u0132\u0133\t\b\2\2\u0133\u0134\5+\26\2\u0134*"+
		"\3\2\2\2\u0135\u013a\5/\30\2\u0136\u0138\5-\27\2\u0137\u0136\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\5/\30\2\u013a\u0137\3\2"+
		"\2\2\u013a\u013b\3\2\2\2\u013b,\3\2\2\2\u013c\u013f\5/\30\2\u013d\u013f"+
		"\t\3\2\2\u013e\u013c\3\2\2\2\u013e\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141.\3\2\2\2\u0142\u0143\t\t\2\2"+
		"\u0143\60\3\2\2\2\u0144\u0145\t\n\2\2\u0145\62\3\2\2\2\u0146\u0149\t\2"+
		"\2\2\u0147\u0149\5\13\6\2\u0148\u0146\3\2\2\2\u0148\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u014c\7\60\2\2\u014b\u014d\5\65\33\2\u014c\u014b"+
		"\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u0150\5\67\34\2"+
		"\u014f\u014e\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u0153"+
		"\5=\37\2\u0152\u0151\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0165\3\2\2\2\u0154"+
		"\u0155\7\60\2\2\u0155\u0157\5\65\33\2\u0156\u0158\5\67\34\2\u0157\u0156"+
		"\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159\u015b\5=\37\2\u015a"+
		"\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u0165\3\2\2\2\u015c\u015d\5\13"+
		"\6\2\u015d\u015f\5\67\34\2\u015e\u0160\5=\37\2\u015f\u015e\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u0165\3\2\2\2\u0161\u0162\5\13\6\2\u0162\u0163\5"+
		"=\37\2\u0163\u0165\3\2\2\2\u0164\u0148\3\2\2\2\u0164\u0154\3\2\2\2\u0164"+
		"\u015c\3\2\2\2\u0164\u0161\3\2\2\2\u0165\64\3\2\2\2\u0166\u016b\5\17\b"+
		"\2\u0167\u0169\5\r\7\2\u0168\u0167\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a"+
		"\3\2\2\2\u016a\u016c\5\17\b\2\u016b\u0168\3\2\2\2\u016b\u016c\3\2\2\2"+
		"\u016c\66\3\2\2\2\u016d\u016f\t\13\2\2\u016e\u0170\t\f\2\2\u016f\u016e"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\5\t\5\2\u0172"+
		"8\3\2\2\2\u0173\u0175\5\25\13\2\u0174\u0176\7\60\2\2\u0175\u0174\3\2\2"+
		"\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\5;\36\2\u0178\u017a"+
		"\5=\37\2\u0179\u0178\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u0187\3\2\2\2\u017b"+
		"\u017c\t\2\2\2\u017c\u017e\t\5\2\2\u017d\u017f\5\27\f\2\u017e\u017d\3"+
		"\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\7\60\2\2\u0181"+
		"\u0182\5\27\f\2\u0182\u0184\5;\36\2\u0183\u0185\5=\37\2\u0184\u0183\3"+
		"\2\2\2\u0184\u0185\3\2\2\2\u0185\u0187\3\2\2\2\u0186\u0173\3\2\2\2\u0186"+
		"\u017b\3\2\2\2\u0187:\3\2\2\2\u0188\u018a\t\r\2\2\u0189\u018b\t\f\2\2"+
		"\u018a\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d"+
		"\5\13\6\2\u018d<\3\2\2\2\u018e\u018f\t\16\2\2\u018f>\3\2\2\2\u0190\u0191"+
		"\7v\2\2\u0191\u0192\7t\2\2\u0192\u0193\7w\2\2\u0193\u019a\7g\2\2\u0194"+
		"\u0195\7h\2\2\u0195\u0196\7c\2\2\u0196\u0197\7n\2\2\u0197\u0198\7u\2\2"+
		"\u0198\u019a\7g\2\2\u0199\u0190\3\2\2\2\u0199\u0194\3\2\2\2\u019a@\3\2"+
		"\2\2\u019b\u019e\t\17\2\2\u019c\u019f\n\20\2\2\u019d\u019f\5C\"\2\u019e"+
		"\u019c\3\2\2\2\u019e\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\t\17"+
		"\2\2\u01a1B\3\2\2\2\u01a2\u01ab\t\21\2\2\u01a3\u01ac\t\22\2\2\u01a4\u01a6"+
		"\t\23\2\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2\2\2"+
		"\u01a7\u01a9\t\7\2\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa"+
		"\3\2\2\2\u01aa\u01ac\t\7\2\2\u01ab\u01a3\3\2\2\2\u01ab\u01a5\3\2\2\2\u01ac"+
		"D\3\2\2\2\u01ad\u01b2\t\24\2\2\u01ae\u01b1\n\25\2\2\u01af\u01b1\5C\"\2"+
		"\u01b0\u01ae\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b3"+
		"\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5"+
		"\u01b6\t\24\2\2\u01b6F\3\2\2\2\u01b7\u01b8\7p\2\2\u01b8\u01b9\7w\2\2\u01b9"+
		"\u01ba\7n\2\2\u01ba\u01bb\7n\2\2\u01bbH\3\2\2\2\u01bc\u01bd\7-\2\2\u01bd"+
		"J\3\2\2\2\u01be\u01bf\7?\2\2\u01bfL\3\2\2\2\u01c0\u01c1\7(\2\2\u01c1N"+
		"\3\2\2\2\u01c2\u01c3\7\u0080\2\2\u01c3P\3\2\2\2\u01c4\u01c5\7~\2\2\u01c5"+
		"R\3\2\2\2\u01c6\u01c7\7`\2\2\u01c7T\3\2\2\2\u01c8\u01c9\7.\2\2\u01c9V"+
		"\3\2\2\2\u01ca\u01cb\7-\2\2\u01cb\u01cc\7?\2\2\u01ccX\3\2\2\2\u01cd\u01ce"+
		"\7(\2\2\u01ce\u01cf\7?\2\2\u01cfZ\3\2\2\2\u01d0\u01d1\7~\2\2\u01d1\u01d2"+
		"\7?\2\2\u01d2\\\3\2\2\2\u01d3\u01d4\7`\2\2\u01d4\u01d5\7?\2\2\u01d5^\3"+
		"\2\2\2\u01d6\u01d7\7\61\2\2\u01d7\u01d8\7?\2\2\u01d8`\3\2\2\2\u01d9\u01da"+
		"\7>\2\2\u01da\u01db\7>\2\2\u01db\u01dc\7?\2\2\u01dcb\3\2\2\2\u01dd\u01de"+
		"\7\'\2\2\u01de\u01df\7?\2\2\u01dfd\3\2\2\2\u01e0\u01e1\7,\2\2\u01e1\u01e2"+
		"\7?\2\2\u01e2f\3\2\2\2\u01e3\u01e4\7@\2\2\u01e4\u01e5\7@\2\2\u01e5\u01e6"+
		"\7?\2\2\u01e6h\3\2\2\2\u01e7\u01e8\7/\2\2\u01e8\u01e9\7?\2\2\u01e9j\3"+
		"\2\2\2\u01ea\u01eb\7/\2\2\u01eb\u01ec\7/\2\2\u01ecl\3\2\2\2\u01ed\u01ee"+
		"\7\61\2\2\u01een\3\2\2\2\u01ef\u01f0\7\60\2\2\u01f0p\3\2\2\2\u01f1\u01f2"+
		"\7?\2\2\u01f2\u01f3\7?\2\2\u01f3r\3\2\2\2\u01f4\u01f5\7@\2\2\u01f5\u01f6"+
		"\7?\2\2\u01f6t\3\2\2\2\u01f7\u01f8\7@\2\2\u01f8v\3\2\2\2\u01f9\u01fa\7"+
		"-\2\2\u01fa\u01fb\7-\2\2\u01fbx\3\2\2\2\u01fc\u01fd\7>\2\2\u01fd\u01fe"+
		"\7>\2\2\u01fez\3\2\2\2\u01ff\u0200\7>\2\2\u0200\u0201\7?\2\2\u0201|\3"+
		"\2\2\2\u0202\u0203\7>\2\2\u0203~\3\2\2\2\u0204\u0205\7(\2\2\u0205\u0206"+
		"\7(\2\2\u0206\u0080\3\2\2\2\u0207\u0208\7#\2\2\u0208\u0082\3\2\2\2\u0209"+
		"\u020a\7~\2\2\u020a\u020b\7~\2\2\u020b\u0084\3\2\2\2\u020c\u020d\7\'\2"+
		"\2\u020d\u0086\3\2\2\2\u020e\u020f\7,\2\2\u020f\u0088\3\2\2\2\u0210\u0211"+
		"\7#\2\2\u0211\u0212\7?\2\2\u0212\u008a\3\2\2\2\u0213\u0214\7\60\2\2\u0214"+
		"\u0215\7\60\2\2\u0215\u008c\3\2\2\2\u0216\u0217\7@\2\2\u0217\u0218\7@"+
		"\2\2\u0218\u008e\3\2\2\2\u0219\u021a\7/\2\2\u021a\u0090\3\2\2\2\u021b"+
		"\u021c\7A\2\2\u021c\u0092\3\2\2\2\u021d\u021e\7B\2\2\u021e\u0094\3\2\2"+
		"\2\u021f\u0220\7<\2\2\u0220\u0096\3\2\2\2\u0221\u0222\7=\2\2\u0222\u0098"+
		"\3\2\2\2\u0223\u0224\7>\2\2\u0224\u0225\7/\2\2\u0225\u009a\3\2\2\2\u0226"+
		"\u0227\7/\2\2\u0227\u0228\7@\2\2\u0228\u009c\3\2\2\2\u0229\u022a\7}\2"+
		"\2\u022a\u009e\3\2\2\2\u022b\u022c\7\177\2\2\u022c\u00a0\3\2\2\2\u022d"+
		"\u022e\7]\2\2\u022e\u00a2\3\2\2\2\u022f\u0230\7_\2\2\u0230\u00a4\3\2\2"+
		"\2\u0231\u0232\7*\2\2\u0232\u00a6\3\2\2\2\u0233\u0234\7+\2\2\u0234\u00a8"+
		"\3\2\2\2\u0235\u0236\7c\2\2\u0236\u0237\7u\2\2\u0237\u0238\7u\2\2\u0238"+
		"\u0239\7g\2\2\u0239\u023a\7t\2\2\u023a\u023b\7v\2\2\u023b\u00aa\3\2\2"+
		"\2\u023c\u023d\7d\2\2\u023d\u023e\7t\2\2\u023e\u023f\7g\2\2\u023f\u0240"+
		"\7c\2\2\u0240\u0241\7m\2\2\u0241\u00ac\3\2\2\2\u0242\u0243\7e\2\2\u0243"+
		"\u0244\7q\2\2\u0244\u0245\7p\2\2\u0245\u0246\7v\2\2\u0246\u0247\7k\2\2"+
		"\u0247\u0248\7p\2\2\u0248\u0249\7w\2\2\u0249\u024a\7g\2\2\u024a\u00ae"+
		"\3\2\2\2\u024b\u024c\7k\2\2\u024c\u024d\7o\2\2\u024d\u024e\7r\2\2\u024e"+
		"\u024f\7q\2\2\u024f\u0250\7t\2\2\u0250\u0251\7v\2\2\u0251\u00b0\3\2\2"+
		"\2\u0252\u0253\7k\2\2\u0253\u0254\7v\2\2\u0254\u0255\7{\2\2\u0255\u0256"+
		"\7r\2\2\u0256\u0257\7g\2\2\u0257\u00b2\3\2\2\2\u0258\u0259\7n\2\2\u0259"+
		"\u025a\7g\2\2\u025a\u025b\7v\2\2\u025b\u00b4\3\2\2\2\u025c\u025d\7o\2"+
		"\2\u025d\u025e\7q\2\2\u025e\u025f\7f\2\2\u025f\u0260\7w\2\2\u0260\u0261"+
		"\7n\2\2\u0261\u0262\7g\2\2\u0262\u00b6\3\2\2\2\u0263\u0264\7p\2\2\u0264"+
		"\u0265\7g\2\2\u0265\u0266\7y\2\2\u0266\u00b8\3\2\2\2\u0267\u0268\7t\2"+
		"\2\u0268\u0269\7g\2\2\u0269\u026a\7v\2\2\u026a\u026b\7w\2\2\u026b\u026c"+
		"\7t\2\2\u026c\u026d\7p\2\2\u026d\u00ba\3\2\2\2\u026e\u026f\7u\2\2\u026f"+
		"\u0270\7w\2\2\u0270\u0271\7r\2\2\u0271\u0272\7g\2\2\u0272\u0273\7t\2\2"+
		"\u0273\u00bc\3\2\2\2\u0274\u0275\7v\2\2\u0275\u0276\7j\2\2\u0276\u0277"+
		"\7k\2\2\u0277\u0278\7u\2\2\u0278\u00be\3\2\2\2\u0279\u027a\7v\2\2\u027a"+
		"\u027b\7j\2\2\u027b\u027c\7t\2\2\u027c\u027d\7q\2\2\u027d\u027e\7y\2\2"+
		"\u027e\u00c0\3\2\2\2\u027f\u0280\7v\2\2\u0280\u0281\7{\2\2\u0281\u0282"+
		"\7r\2\2\u0282\u0283\7g\2\2\u0283\u00c2\3\2\2\2\u0284\u0285\7r\2\2\u0285"+
		"\u0286\7t\2\2\u0286\u0287\7k\2\2\u0287\u0288\7x\2\2\u0288\u0289\7c\2\2"+
		"\u0289\u028a\7v\2\2\u028a\u028b\7g\2\2\u028b\u00c4\3\2\2\2\u028c\u028d"+
		"\7r\2\2\u028d\u028e\7t\2\2\u028e\u028f\7q\2\2\u028f\u0290\7v\2\2\u0290"+
		"\u0291\7g\2\2\u0291\u0292\7e\2\2\u0292\u0293\7v\2\2\u0293\u0294\7g\2\2"+
		"\u0294\u0295\7f\2\2\u0295\u00c6\3\2\2\2\u0296\u0297\7r\2\2\u0297\u0298"+
		"\7w\2\2\u0298\u0299\7d\2\2\u0299\u029a\7n\2\2\u029a\u029b\7k\2\2\u029b"+
		"\u029c\7e\2\2\u029c\u00c8\3\2\2\2\u029d\u02a1\5\u00cbf\2\u029e\u02a0\5"+
		"\u00cdg\2\u029f\u029e\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f\3\2\2\2"+
		"\u02a1\u02a2\3\2\2\2\u02a2\u00ca\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02a5"+
		"\t\26\2\2\u02a5\u00cc\3\2\2\2\u02a6\u02a7\t\27\2\2\u02a7\u00ce\3\2\2\2"+
		"\u02a8\u02aa\t\30\2\2\u02a9\u02a8\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02a9"+
		"\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\bh\2\2\u02ae"+
		"\u00d0\3\2\2\2\u02af\u02b0\7\61\2\2\u02b0\u02b1\7\61\2\2\u02b1\u02b5\3"+
		"\2\2\2\u02b2\u02b4\n\31\2\2\u02b3\u02b2\3\2\2\2\u02b4\u02b7\3\2\2\2\u02b5"+
		"\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b8\3\2\2\2\u02b7\u02b5\3\2"+
		"\2\2\u02b8\u02b9\bi\2\2\u02b9\u00d2\3\2\2\2\u02ba\u02bb\7\61\2\2\u02bb"+
		"\u02bc\7,\2\2\u02bc\u02c0\3\2\2\2\u02bd\u02bf\13\2\2\2\u02be\u02bd\3\2"+
		"\2\2\u02bf\u02c2\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c0\u02be\3\2\2\2\u02c1"+
		"\u02c3\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02c4\7,\2\2\u02c4\u02c5\7\61"+
		"\2\2\u02c5\u02c6\3\2\2\2\u02c6\u02c7\bj\2\2\u02c7\u00d4\3\2\2\28\2\u00d9"+
		"\u00dd\u00e1\u00e5\u00e9\u00ec\u00f0\u00f2\u00f6\u00fc\u0104\u0107\u010b"+
		"\u010d\u0113\u0119\u0120\u0123\u0127\u0129\u012f\u0137\u013a\u013e\u0140"+
		"\u0148\u014c\u014f\u0152\u0157\u015a\u015f\u0164\u0168\u016b\u016f\u0175"+
		"\u0179\u017e\u0184\u0186\u018a\u0199\u019e\u01a5\u01a8\u01ab\u01b0\u01b2"+
		"\u02a1\u02ab\u02b5\u02c0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
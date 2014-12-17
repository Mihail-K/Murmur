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
		CompoundBinaryXorOperator=17, CompoundConcatOperator=18, CompoundDivideOperator=19, 
		CompoundLeftShiftOperator=20, CompoundModuloOperator=21, CompoundMultiplyOperator=22, 
		CompoundRightShiftOperator=23, CompoundSubtractOperator=24, DecrementOperator=25, 
		DivideOperator=26, DotOperator=27, EqualsOperator=28, GreaterOrEqualOperator=29, 
		GreaterThanOperator=30, IncrementOperator=31, LeftShiftOperator=32, LessOrEqualOperator=33, 
		LessThanOperator=34, LogicalAndOperator=35, LogicalNotOperator=36, LogicalOrOperator=37, 
		ModuloOperator=38, MultiplyOperator=39, NotEqualsOperator=40, RangeOperator=41, 
		RightShiftOperator=42, SubtractOperator=43, TernaryConditionOperator=44, 
		TernaryIterativeOperator=45, ColonElement=46, SemicolonElement=47, LeftArrowElement=48, 
		RightArrowElement=49, LeftBraceElement=50, RightBraceElement=51, LeftBracketElement=52, 
		RightBracketElement=53, LeftParenElement=54, RightParenElement=55, AssertKeyword=56, 
		BreakKeyword=57, ContinueKeyword=58, ImportKeyword=59, ITypeKeyword=60, 
		LetKeyword=61, ModuleKeyword=62, NewKeyword=63, ReturnKeyword=64, SuperKeyword=65, 
		ThisKeyword=66, ThrowKeyword=67, TypeKeyword=68, PrivateKeyword=69, ProtectedKeyword=70, 
		PublicKeyword=71, Identifier=72, Whitespace=73, LineComment=74, BlockComment=75;
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
		"'F'", "'G'", "'H'", "'I'", "'J'", "'K'"
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
		"CompoundBinaryXorOperator", "CompoundConcatOperator", "CompoundDivideOperator", 
		"CompoundLeftShiftOperator", "CompoundModuloOperator", "CompoundMultiplyOperator", 
		"CompoundRightShiftOperator", "CompoundSubtractOperator", "DecrementOperator", 
		"DivideOperator", "DotOperator", "EqualsOperator", "GreaterOrEqualOperator", 
		"GreaterThanOperator", "IncrementOperator", "LeftShiftOperator", "LessOrEqualOperator", 
		"LessThanOperator", "LogicalAndOperator", "LogicalNotOperator", "LogicalOrOperator", 
		"ModuloOperator", "MultiplyOperator", "NotEqualsOperator", "RangeOperator", 
		"RightShiftOperator", "SubtractOperator", "TernaryConditionOperator", 
		"TernaryIterativeOperator", "ColonElement", "SemicolonElement", "LeftArrowElement", 
		"RightArrowElement", "LeftBraceElement", "RightBraceElement", "LeftBracketElement", 
		"RightBracketElement", "LeftParenElement", "RightParenElement", "AssertKeyword", 
		"BreakKeyword", "ContinueKeyword", "ImportKeyword", "ITypeKeyword", "LetKeyword", 
		"ModuleKeyword", "NewKeyword", "ReturnKeyword", "SuperKeyword", "ThisKeyword", 
		"ThrowKeyword", "TypeKeyword", "PrivateKeyword", "ProtectedKeyword", "PublicKeyword", 
		"Identifier", "IdentifierFirst", "IdentifierLast", "Whitespace", "LineComment", 
		"BlockComment"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2M\u02cd\b\1\4\2\t"+
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
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\3\2\3\2\3\2\3\2\5\2\u00dc\n\2\3\3\3\3\5\3\u00e0\n\3\3\4\3\4\5\4\u00e4"+
		"\n\4\3\5\3\5\5\5\u00e8\n\5\3\6\3\6\5\6\u00ec\n\6\3\6\5\6\u00ef\n\6\3\7"+
		"\3\7\6\7\u00f3\n\7\r\7\16\7\u00f4\3\b\3\b\5\b\u00f9\n\b\3\t\3\t\3\n\3"+
		"\n\5\n\u00ff\n\n\3\13\3\13\3\13\3\13\3\f\3\f\5\f\u0107\n\f\3\f\5\f\u010a"+
		"\n\f\3\r\3\r\6\r\u010e\n\r\r\r\16\r\u010f\3\16\3\16\3\17\3\17\5\17\u0116"+
		"\n\17\3\20\3\20\7\20\u011a\n\20\f\20\16\20\u011d\13\20\3\20\3\20\3\21"+
		"\3\21\5\21\u0123\n\21\3\21\5\21\u0126\n\21\3\22\3\22\6\22\u012a\n\22\r"+
		"\22\16\22\u012b\3\23\3\23\3\24\3\24\5\24\u0132\n\24\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\5\26\u013a\n\26\3\26\5\26\u013d\n\26\3\27\3\27\6\27\u0141\n"+
		"\27\r\27\16\27\u0142\3\30\3\30\3\31\3\31\3\32\3\32\5\32\u014b\n\32\3\32"+
		"\3\32\5\32\u014f\n\32\3\32\5\32\u0152\n\32\3\32\5\32\u0155\n\32\3\32\3"+
		"\32\3\32\5\32\u015a\n\32\3\32\5\32\u015d\n\32\3\32\3\32\3\32\5\32\u0162"+
		"\n\32\3\32\3\32\3\32\5\32\u0167\n\32\3\33\3\33\5\33\u016b\n\33\3\33\5"+
		"\33\u016e\n\33\3\34\3\34\5\34\u0172\n\34\3\34\3\34\3\35\3\35\5\35\u0178"+
		"\n\35\3\35\3\35\5\35\u017c\n\35\3\35\3\35\3\35\5\35\u0181\n\35\3\35\3"+
		"\35\3\35\3\35\5\35\u0187\n\35\5\35\u0189\n\35\3\36\3\36\5\36\u018d\n\36"+
		"\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u019c\n \3!\3!\3!\5"+
		"!\u01a1\n!\3!\3!\3\"\3\"\3\"\5\"\u01a8\n\"\3\"\5\"\u01ab\n\"\3\"\5\"\u01ae"+
		"\n\"\3#\3#\3#\7#\u01b3\n#\f#\16#\u01b6\13#\3#\3#\3$\3$\3$\3$\3$\3%\3%"+
		"\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3"+
		"/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\3"+
		"8\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3@\3@\3A\3"+
		"A\3A\3B\3B\3C\3C\3C\3D\3D\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3H\3I\3I\3J\3"+
		"J\3K\3K\3L\3L\3M\3M\3N\3N\3N\3O\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3"+
		"U\3U\3V\3V\3V\3V\3V\3V\3V\3W\3W\3W\3W\3W\3W\3X\3X\3X\3X\3X\3X\3X\3X\3"+
		"X\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3"+
		"\\\3\\\3\\\3]\3]\3]\3]\3^\3^\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3_\3`\3`\3"+
		"`\3`\3`\3a\3a\3a\3a\3a\3a\3b\3b\3b\3b\3b\3c\3c\3c\3c\3c\3c\3c\3c\3d\3"+
		"d\3d\3d\3d\3d\3d\3d\3d\3d\3e\3e\3e\3e\3e\3e\3e\3f\3f\7f\u02a5\nf\ff\16"+
		"f\u02a8\13f\3g\3g\3h\3h\3i\6i\u02af\ni\ri\16i\u02b0\3i\3i\3j\3j\3j\3j"+
		"\7j\u02b9\nj\fj\16j\u02bc\13j\3j\3j\3k\3k\3k\3k\7k\u02c4\nk\fk\16k\u02c7"+
		"\13k\3k\3k\3k\3k\3k\5\u011b\u01b4\u02c5\2l\3\3\5\4\7\2\t\2\13\2\r\2\17"+
		"\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61"+
		"\2\63\2\65\2\67\29\2;\2=\2?\5A\6C\2E\7G\bI\tK\nM\13O\fQ\rS\16U\17W\20"+
		"Y\21[\22]\23_\24a\25c\26e\27g\30i\31k\32m\33o\34q\35s\36u\37w y!{\"}#"+
		"\177$\u0081%\u0083&\u0085\'\u0087(\u0089)\u008b*\u008d+\u008f,\u0091-"+
		"\u0093.\u0095/\u0097\60\u0099\61\u009b\62\u009d\63\u009f\64\u00a1\65\u00a3"+
		"\66\u00a5\67\u00a78\u00a99\u00ab:\u00ad;\u00af<\u00b1=\u00b3>\u00b5?\u00b7"+
		"@\u00b9A\u00bbB\u00bdC\u00bfD\u00c1E\u00c3F\u00c5G\u00c7H\u00c9I\u00cb"+
		"J\u00cd\2\u00cf\2\u00d1K\u00d3L\u00d5M\3\2\32\3\2\62\62\3\2aa\3\2\63;"+
		"\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62\63\4\2NNnn\4\2GGgg\4\2--/"+
		"/\4\2RRrr\6\2FFHHffhh\3\2))\4\2))^^\3\2^^\13\2$$))\62\62^^ddhhppttvv\3"+
		"\2\62\65\3\2$$\4\2$$^^\6\2&&C\\aac|\7\2&&\62;C\\aac|\5\2\13\f\17\17\""+
		"\"\3\2\f\f\u02e6\2\3\3\2\2\2\2\5\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2E\3\2"+
		"\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2"+
		"\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_"+
		"\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2"+
		"\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2"+
		"\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2"+
		"\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095"+
		"\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2"+
		"\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7"+
		"\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2"+
		"\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9"+
		"\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2"+
		"\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb"+
		"\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\3\u00db\3\2\2"+
		"\2\5\u00df\3\2\2\2\7\u00e1\3\2\2\2\t\u00e7\3\2\2\2\13\u00e9\3\2\2\2\r"+
		"\u00f2\3\2\2\2\17\u00f8\3\2\2\2\21\u00fa\3\2\2\2\23\u00fc\3\2\2\2\25\u0100"+
		"\3\2\2\2\27\u0104\3\2\2\2\31\u010d\3\2\2\2\33\u0111\3\2\2\2\35\u0113\3"+
		"\2\2\2\37\u0117\3\2\2\2!\u0120\3\2\2\2#\u0129\3\2\2\2%\u012d\3\2\2\2\'"+
		"\u012f\3\2\2\2)\u0133\3\2\2\2+\u0137\3\2\2\2-\u0140\3\2\2\2/\u0144\3\2"+
		"\2\2\61\u0146\3\2\2\2\63\u0166\3\2\2\2\65\u0168\3\2\2\2\67\u016f\3\2\2"+
		"\29\u0188\3\2\2\2;\u018a\3\2\2\2=\u0190\3\2\2\2?\u019b\3\2\2\2A\u019d"+
		"\3\2\2\2C\u01a4\3\2\2\2E\u01af\3\2\2\2G\u01b9\3\2\2\2I\u01be\3\2\2\2K"+
		"\u01c0\3\2\2\2M\u01c2\3\2\2\2O\u01c4\3\2\2\2Q\u01c6\3\2\2\2S\u01c8\3\2"+
		"\2\2U\u01ca\3\2\2\2W\u01cc\3\2\2\2Y\u01cf\3\2\2\2[\u01d2\3\2\2\2]\u01d5"+
		"\3\2\2\2_\u01d8\3\2\2\2a\u01db\3\2\2\2c\u01de\3\2\2\2e\u01e2\3\2\2\2g"+
		"\u01e5\3\2\2\2i\u01e8\3\2\2\2k\u01ec\3\2\2\2m\u01ef\3\2\2\2o\u01f2\3\2"+
		"\2\2q\u01f4\3\2\2\2s\u01f6\3\2\2\2u\u01f9\3\2\2\2w\u01fc\3\2\2\2y\u01fe"+
		"\3\2\2\2{\u0201\3\2\2\2}\u0204\3\2\2\2\177\u0207\3\2\2\2\u0081\u0209\3"+
		"\2\2\2\u0083\u020c\3\2\2\2\u0085\u020e\3\2\2\2\u0087\u0211\3\2\2\2\u0089"+
		"\u0213\3\2\2\2\u008b\u0215\3\2\2\2\u008d\u0218\3\2\2\2\u008f\u021b\3\2"+
		"\2\2\u0091\u021e\3\2\2\2\u0093\u0220\3\2\2\2\u0095\u0222\3\2\2\2\u0097"+
		"\u0224\3\2\2\2\u0099\u0226\3\2\2\2\u009b\u0228\3\2\2\2\u009d\u022b\3\2"+
		"\2\2\u009f\u022e\3\2\2\2\u00a1\u0230\3\2\2\2\u00a3\u0232\3\2\2\2\u00a5"+
		"\u0234\3\2\2\2\u00a7\u0236\3\2\2\2\u00a9\u0238\3\2\2\2\u00ab\u023a\3\2"+
		"\2\2\u00ad\u0241\3\2\2\2\u00af\u0247\3\2\2\2\u00b1\u0250\3\2\2\2\u00b3"+
		"\u0257\3\2\2\2\u00b5\u025d\3\2\2\2\u00b7\u0261\3\2\2\2\u00b9\u0268\3\2"+
		"\2\2\u00bb\u026c\3\2\2\2\u00bd\u0273\3\2\2\2\u00bf\u0279\3\2\2\2\u00c1"+
		"\u027e\3\2\2\2\u00c3\u0284\3\2\2\2\u00c5\u0289\3\2\2\2\u00c7\u0291\3\2"+
		"\2\2\u00c9\u029b\3\2\2\2\u00cb\u02a2\3\2\2\2\u00cd\u02a9\3\2\2\2\u00cf"+
		"\u02ab\3\2\2\2\u00d1\u02ae\3\2\2\2\u00d3\u02b4\3\2\2\2\u00d5\u02bf\3\2"+
		"\2\2\u00d7\u00dc\5\7\4\2\u00d8\u00dc\5\23\n\2\u00d9\u00dc\5\35\17\2\u00da"+
		"\u00dc\5\'\24\2\u00db\u00d7\3\2\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3"+
		"\2\2\2\u00db\u00da\3\2\2\2\u00dc\4\3\2\2\2\u00dd\u00e0\5\63\32\2\u00de"+
		"\u00e0\59\35\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\6\3\2\2\2"+
		"\u00e1\u00e3\5\t\5\2\u00e2\u00e4\5\61\31\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4"+
		"\3\2\2\2\u00e4\b\3\2\2\2\u00e5\u00e8\t\2\2\2\u00e6\u00e8\5\13\6\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8\n\3\2\2\2\u00e9\u00ee\5\21\t"+
		"\2\u00ea\u00ec\5\r\7\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00ef\5\17\b\2\u00ee\u00eb\3\2\2\2\u00ee\u00ef\3\2\2\2"+
		"\u00ef\f\3\2\2\2\u00f0\u00f3\5\17\b\2\u00f1\u00f3\t\3\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\16\3\2\2\2\u00f6\u00f9\t\2\2\2\u00f7\u00f9\5\21\t"+
		"\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\20\3\2\2\2\u00fa\u00fb"+
		"\t\4\2\2\u00fb\22\3\2\2\2\u00fc\u00fe\5\25\13\2\u00fd\u00ff\5\61\31\2"+
		"\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\24\3\2\2\2\u0100\u0101"+
		"\t\2\2\2\u0101\u0102\t\5\2\2\u0102\u0103\5\27\f\2\u0103\26\3\2\2\2\u0104"+
		"\u0109\5\33\16\2\u0105\u0107\5\31\r\2\u0106\u0105\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010a\5\33\16\2\u0109\u0106\3\2\2\2"+
		"\u0109\u010a\3\2\2\2\u010a\30\3\2\2\2\u010b\u010e\5\33\16\2\u010c\u010e"+
		"\t\3\2\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\32\3\2\2\2\u0111\u0112\t\6\2"+
		"\2\u0112\34\3\2\2\2\u0113\u0115\5\37\20\2\u0114\u0116\5\61\31\2\u0115"+
		"\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\36\3\2\2\2\u0117\u011b\t\2\2"+
		"\2\u0118\u011a\t\3\2\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u011c"+
		"\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e"+
		"\u011f\5!\21\2\u011f \3\2\2\2\u0120\u0125\5%\23\2\u0121\u0123\5#\22\2"+
		"\u0122\u0121\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126"+
		"\5%\23\2\u0125\u0122\3\2\2\2\u0125\u0126\3\2\2\2\u0126\"\3\2\2\2\u0127"+
		"\u012a\5%\23\2\u0128\u012a\t\3\2\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2"+
		"\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"$\3\2\2\2\u012d\u012e\t\7\2\2\u012e&\3\2\2\2\u012f\u0131\5)\25\2\u0130"+
		"\u0132\5\61\31\2\u0131\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132(\3\2\2"+
		"\2\u0133\u0134\t\2\2\2\u0134\u0135\t\b\2\2\u0135\u0136\5+\26\2\u0136*"+
		"\3\2\2\2\u0137\u013c\5/\30\2\u0138\u013a\5-\27\2\u0139\u0138\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\5/\30\2\u013c\u0139\3\2"+
		"\2\2\u013c\u013d\3\2\2\2\u013d,\3\2\2\2\u013e\u0141\5/\30\2\u013f\u0141"+
		"\t\3\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143.\3\2\2\2\u0144\u0145\t\t\2\2"+
		"\u0145\60\3\2\2\2\u0146\u0147\t\n\2\2\u0147\62\3\2\2\2\u0148\u014b\t\2"+
		"\2\2\u0149\u014b\5\13\6\2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014e\7\60\2\2\u014d\u014f\5\65\33\2\u014e\u014d"+
		"\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u0152\5\67\34\2"+
		"\u0151\u0150\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0155"+
		"\5=\37\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0167\3\2\2\2\u0156"+
		"\u0157\7\60\2\2\u0157\u0159\5\65\33\2\u0158\u015a\5\67\34\2\u0159\u0158"+
		"\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u015d\5=\37\2\u015c"+
		"\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0167\3\2\2\2\u015e\u015f\5\13"+
		"\6\2\u015f\u0161\5\67\34\2\u0160\u0162\5=\37\2\u0161\u0160\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162\u0167\3\2\2\2\u0163\u0164\5\13\6\2\u0164\u0165\5"+
		"=\37\2\u0165\u0167\3\2\2\2\u0166\u014a\3\2\2\2\u0166\u0156\3\2\2\2\u0166"+
		"\u015e\3\2\2\2\u0166\u0163\3\2\2\2\u0167\64\3\2\2\2\u0168\u016d\5\17\b"+
		"\2\u0169\u016b\5\r\7\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c"+
		"\3\2\2\2\u016c\u016e\5\17\b\2\u016d\u016a\3\2\2\2\u016d\u016e\3\2\2\2"+
		"\u016e\66\3\2\2\2\u016f\u0171\t\13\2\2\u0170\u0172\t\f\2\2\u0171\u0170"+
		"\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\5\t\5\2\u0174"+
		"8\3\2\2\2\u0175\u0177\5\25\13\2\u0176\u0178\7\60\2\2\u0177\u0176\3\2\2"+
		"\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b\5;\36\2\u017a\u017c"+
		"\5=\37\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u0189\3\2\2\2\u017d"+
		"\u017e\t\2\2\2\u017e\u0180\t\5\2\2\u017f\u0181\5\27\f\2\u0180\u017f\3"+
		"\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\7\60\2\2\u0183"+
		"\u0184\5\27\f\2\u0184\u0186\5;\36\2\u0185\u0187\5=\37\2\u0186\u0185\3"+
		"\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u0175\3\2\2\2\u0188"+
		"\u017d\3\2\2\2\u0189:\3\2\2\2\u018a\u018c\t\r\2\2\u018b\u018d\t\f\2\2"+
		"\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f"+
		"\5\13\6\2\u018f<\3\2\2\2\u0190\u0191\t\16\2\2\u0191>\3\2\2\2\u0192\u0193"+
		"\7v\2\2\u0193\u0194\7t\2\2\u0194\u0195\7w\2\2\u0195\u019c\7g\2\2\u0196"+
		"\u0197\7h\2\2\u0197\u0198\7c\2\2\u0198\u0199\7n\2\2\u0199\u019a\7u\2\2"+
		"\u019a\u019c\7g\2\2\u019b\u0192\3\2\2\2\u019b\u0196\3\2\2\2\u019c@\3\2"+
		"\2\2\u019d\u01a0\t\17\2\2\u019e\u01a1\n\20\2\2\u019f\u01a1\5C\"\2\u01a0"+
		"\u019e\3\2\2\2\u01a0\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\t\17"+
		"\2\2\u01a3B\3\2\2\2\u01a4\u01ad\t\21\2\2\u01a5\u01ae\t\22\2\2\u01a6\u01a8"+
		"\t\23\2\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2\2\2"+
		"\u01a9\u01ab\t\7\2\2\u01aa\u01a9\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac"+
		"\3\2\2\2\u01ac\u01ae\t\7\2\2\u01ad\u01a5\3\2\2\2\u01ad\u01a7\3\2\2\2\u01ae"+
		"D\3\2\2\2\u01af\u01b4\t\24\2\2\u01b0\u01b3\n\25\2\2\u01b1\u01b3\5C\"\2"+
		"\u01b2\u01b0\3\2\2\2\u01b2\u01b1\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b5"+
		"\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7"+
		"\u01b8\t\24\2\2\u01b8F\3\2\2\2\u01b9\u01ba\7p\2\2\u01ba\u01bb\7w\2\2\u01bb"+
		"\u01bc\7n\2\2\u01bc\u01bd\7n\2\2\u01bdH\3\2\2\2\u01be\u01bf\7-\2\2\u01bf"+
		"J\3\2\2\2\u01c0\u01c1\7?\2\2\u01c1L\3\2\2\2\u01c2\u01c3\7(\2\2\u01c3N"+
		"\3\2\2\2\u01c4\u01c5\7\u0080\2\2\u01c5P\3\2\2\2\u01c6\u01c7\7~\2\2\u01c7"+
		"R\3\2\2\2\u01c8\u01c9\7`\2\2\u01c9T\3\2\2\2\u01ca\u01cb\7.\2\2\u01cbV"+
		"\3\2\2\2\u01cc\u01cd\7-\2\2\u01cd\u01ce\7?\2\2\u01ceX\3\2\2\2\u01cf\u01d0"+
		"\7(\2\2\u01d0\u01d1\7?\2\2\u01d1Z\3\2\2\2\u01d2\u01d3\7~\2\2\u01d3\u01d4"+
		"\7?\2\2\u01d4\\\3\2\2\2\u01d5\u01d6\7`\2\2\u01d6\u01d7\7?\2\2\u01d7^\3"+
		"\2\2\2\u01d8\u01d9\7\u0080\2\2\u01d9\u01da\7?\2\2\u01da`\3\2\2\2\u01db"+
		"\u01dc\7\61\2\2\u01dc\u01dd\7?\2\2\u01ddb\3\2\2\2\u01de\u01df\7>\2\2\u01df"+
		"\u01e0\7>\2\2\u01e0\u01e1\7?\2\2\u01e1d\3\2\2\2\u01e2\u01e3\7\'\2\2\u01e3"+
		"\u01e4\7?\2\2\u01e4f\3\2\2\2\u01e5\u01e6\7,\2\2\u01e6\u01e7\7?\2\2\u01e7"+
		"h\3\2\2\2\u01e8\u01e9\7@\2\2\u01e9\u01ea\7@\2\2\u01ea\u01eb\7?\2\2\u01eb"+
		"j\3\2\2\2\u01ec\u01ed\7/\2\2\u01ed\u01ee\7?\2\2\u01eel\3\2\2\2\u01ef\u01f0"+
		"\7/\2\2\u01f0\u01f1\7/\2\2\u01f1n\3\2\2\2\u01f2\u01f3\7\61\2\2\u01f3p"+
		"\3\2\2\2\u01f4\u01f5\7\60\2\2\u01f5r\3\2\2\2\u01f6\u01f7\7?\2\2\u01f7"+
		"\u01f8\7?\2\2\u01f8t\3\2\2\2\u01f9\u01fa\7@\2\2\u01fa\u01fb\7?\2\2\u01fb"+
		"v\3\2\2\2\u01fc\u01fd\7@\2\2\u01fdx\3\2\2\2\u01fe\u01ff\7-\2\2\u01ff\u0200"+
		"\7-\2\2\u0200z\3\2\2\2\u0201\u0202\7>\2\2\u0202\u0203\7>\2\2\u0203|\3"+
		"\2\2\2\u0204\u0205\7>\2\2\u0205\u0206\7?\2\2\u0206~\3\2\2\2\u0207\u0208"+
		"\7>\2\2\u0208\u0080\3\2\2\2\u0209\u020a\7(\2\2\u020a\u020b\7(\2\2\u020b"+
		"\u0082\3\2\2\2\u020c\u020d\7#\2\2\u020d\u0084\3\2\2\2\u020e\u020f\7~\2"+
		"\2\u020f\u0210\7~\2\2\u0210\u0086\3\2\2\2\u0211\u0212\7\'\2\2\u0212\u0088"+
		"\3\2\2\2\u0213\u0214\7,\2\2\u0214\u008a\3\2\2\2\u0215\u0216\7#\2\2\u0216"+
		"\u0217\7?\2\2\u0217\u008c\3\2\2\2\u0218\u0219\7\60\2\2\u0219\u021a\7\60"+
		"\2\2\u021a\u008e\3\2\2\2\u021b\u021c\7@\2\2\u021c\u021d\7@\2\2\u021d\u0090"+
		"\3\2\2\2\u021e\u021f\7/\2\2\u021f\u0092\3\2\2\2\u0220\u0221\7A\2\2\u0221"+
		"\u0094\3\2\2\2\u0222\u0223\7B\2\2\u0223\u0096\3\2\2\2\u0224\u0225\7<\2"+
		"\2\u0225\u0098\3\2\2\2\u0226\u0227\7=\2\2\u0227\u009a\3\2\2\2\u0228\u0229"+
		"\7>\2\2\u0229\u022a\7/\2\2\u022a\u009c\3\2\2\2\u022b\u022c\7/\2\2\u022c"+
		"\u022d\7@\2\2\u022d\u009e\3\2\2\2\u022e\u022f\7}\2\2\u022f\u00a0\3\2\2"+
		"\2\u0230\u0231\7\177\2\2\u0231\u00a2\3\2\2\2\u0232\u0233\7]\2\2\u0233"+
		"\u00a4\3\2\2\2\u0234\u0235\7_\2\2\u0235\u00a6\3\2\2\2\u0236\u0237\7*\2"+
		"\2\u0237\u00a8\3\2\2\2\u0238\u0239\7+\2\2\u0239\u00aa\3\2\2\2\u023a\u023b"+
		"\7c\2\2\u023b\u023c\7u\2\2\u023c\u023d\7u\2\2\u023d\u023e\7g\2\2\u023e"+
		"\u023f\7t\2\2\u023f\u0240\7v\2\2\u0240\u00ac\3\2\2\2\u0241\u0242\7d\2"+
		"\2\u0242\u0243\7t\2\2\u0243\u0244\7g\2\2\u0244\u0245\7c\2\2\u0245\u0246"+
		"\7m\2\2\u0246\u00ae\3\2\2\2\u0247\u0248\7e\2\2\u0248\u0249\7q\2\2\u0249"+
		"\u024a\7p\2\2\u024a\u024b\7v\2\2\u024b\u024c\7k\2\2\u024c\u024d\7p\2\2"+
		"\u024d\u024e\7w\2\2\u024e\u024f\7g\2\2\u024f\u00b0\3\2\2\2\u0250\u0251"+
		"\7k\2\2\u0251\u0252\7o\2\2\u0252\u0253\7r\2\2\u0253\u0254\7q\2\2\u0254"+
		"\u0255\7t\2\2\u0255\u0256\7v\2\2\u0256\u00b2\3\2\2\2\u0257\u0258\7k\2"+
		"\2\u0258\u0259\7v\2\2\u0259\u025a\7{\2\2\u025a\u025b\7r\2\2\u025b\u025c"+
		"\7g\2\2\u025c\u00b4\3\2\2\2\u025d\u025e\7n\2\2\u025e\u025f\7g\2\2\u025f"+
		"\u0260\7v\2\2\u0260\u00b6\3\2\2\2\u0261\u0262\7o\2\2\u0262\u0263\7q\2"+
		"\2\u0263\u0264\7f\2\2\u0264\u0265\7w\2\2\u0265\u0266\7n\2\2\u0266\u0267"+
		"\7g\2\2\u0267\u00b8\3\2\2\2\u0268\u0269\7p\2\2\u0269\u026a\7g\2\2\u026a"+
		"\u026b\7y\2\2\u026b\u00ba\3\2\2\2\u026c\u026d\7t\2\2\u026d\u026e\7g\2"+
		"\2\u026e\u026f\7v\2\2\u026f\u0270\7w\2\2\u0270\u0271\7t\2\2\u0271\u0272"+
		"\7p\2\2\u0272\u00bc\3\2\2\2\u0273\u0274\7u\2\2\u0274\u0275\7w\2\2\u0275"+
		"\u0276\7r\2\2\u0276\u0277\7g\2\2\u0277\u0278\7t\2\2\u0278\u00be\3\2\2"+
		"\2\u0279\u027a\7v\2\2\u027a\u027b\7j\2\2\u027b\u027c\7k\2\2\u027c\u027d"+
		"\7u\2\2\u027d\u00c0\3\2\2\2\u027e\u027f\7v\2\2\u027f\u0280\7j\2\2\u0280"+
		"\u0281\7t\2\2\u0281\u0282\7q\2\2\u0282\u0283\7y\2\2\u0283\u00c2\3\2\2"+
		"\2\u0284\u0285\7v\2\2\u0285\u0286\7{\2\2\u0286\u0287\7r\2\2\u0287\u0288"+
		"\7g\2\2\u0288\u00c4\3\2\2\2\u0289\u028a\7r\2\2\u028a\u028b\7t\2\2\u028b"+
		"\u028c\7k\2\2\u028c\u028d\7x\2\2\u028d\u028e\7c\2\2\u028e\u028f\7v\2\2"+
		"\u028f\u0290\7g\2\2\u0290\u00c6\3\2\2\2\u0291\u0292\7r\2\2\u0292\u0293"+
		"\7t\2\2\u0293\u0294\7q\2\2\u0294\u0295\7v\2\2\u0295\u0296\7g\2\2\u0296"+
		"\u0297\7e\2\2\u0297\u0298\7v\2\2\u0298\u0299\7g\2\2\u0299\u029a\7f\2\2"+
		"\u029a\u00c8\3\2\2\2\u029b\u029c\7r\2\2\u029c\u029d\7w\2\2\u029d\u029e"+
		"\7d\2\2\u029e\u029f\7n\2\2\u029f\u02a0\7k\2\2\u02a0\u02a1\7e\2\2\u02a1"+
		"\u00ca\3\2\2\2\u02a2\u02a6\5\u00cdg\2\u02a3\u02a5\5\u00cfh\2\u02a4\u02a3"+
		"\3\2\2\2\u02a5\u02a8\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7"+
		"\u00cc\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a9\u02aa\t\26\2\2\u02aa\u00ce\3"+
		"\2\2\2\u02ab\u02ac\t\27\2\2\u02ac\u00d0\3\2\2\2\u02ad\u02af\t\30\2\2\u02ae"+
		"\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2"+
		"\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b3\bi\2\2\u02b3\u00d2\3\2\2\2\u02b4"+
		"\u02b5\7\61\2\2\u02b5\u02b6\7\61\2\2\u02b6\u02ba\3\2\2\2\u02b7\u02b9\n"+
		"\31\2\2\u02b8\u02b7\3\2\2\2\u02b9\u02bc\3\2\2\2\u02ba\u02b8\3\2\2\2\u02ba"+
		"\u02bb\3\2\2\2\u02bb\u02bd\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bd\u02be\bj"+
		"\2\2\u02be\u00d4\3\2\2\2\u02bf\u02c0\7\61\2\2\u02c0\u02c1\7,\2\2\u02c1"+
		"\u02c5\3\2\2\2\u02c2\u02c4\13\2\2\2\u02c3\u02c2\3\2\2\2\u02c4\u02c7\3"+
		"\2\2\2\u02c5\u02c6\3\2\2\2\u02c5\u02c3\3\2\2\2\u02c6\u02c8\3\2\2\2\u02c7"+
		"\u02c5\3\2\2\2\u02c8\u02c9\7,\2\2\u02c9\u02ca\7\61\2\2\u02ca\u02cb\3\2"+
		"\2\2\u02cb\u02cc\bk\2\2\u02cc\u00d6\3\2\2\28\2\u00db\u00df\u00e3\u00e7"+
		"\u00eb\u00ee\u00f2\u00f4\u00f8\u00fe\u0106\u0109\u010d\u010f\u0115\u011b"+
		"\u0122\u0125\u0129\u012b\u0131\u0139\u013c\u0140\u0142\u014a\u014e\u0151"+
		"\u0154\u0159\u015c\u0161\u0166\u016a\u016d\u0171\u0177\u017b\u0180\u0186"+
		"\u0188\u018c\u019b\u01a0\u01a7\u01aa\u01ad\u01b2\u01b4\u02a6\u02b0\u02ba"+
		"\u02c5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
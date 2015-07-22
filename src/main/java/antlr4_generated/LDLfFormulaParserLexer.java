// Generated from LDLfFormulaParser.g4 by ANTLR 4.3

	package antlr4_generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LDLfFormulaParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LAST=1, EPSILON=2, TT=3, FF=4, END=5, BOXLSEPARATOR=6, BOXRSEPARATOR=7, 
		DIAMONDLSEPARATOR=8, DIAMONDRSEPARATOR=9, STAR=10, TEST=11, ALTERNATION=12, 
		CONCATENATION=13, ID=14, TRUE=15, FALSE=16, DOUBLEIMPLY=17, IMPLY=18, 
		OR=19, AND=20, NOT=21, LSEPARATOR=22, RSEPARATOR=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'"
	};
	public static final String[] ruleNames = {
		"LAST", "EPSILON", "TT", "FF", "END", "BOXLSEPARATOR", "BOXRSEPARATOR", 
		"DIAMONDLSEPARATOR", "DIAMONDRSEPARATOR", "STAR", "TEST", "ALTERNATION", 
		"CONCATENATION", "ID", "TRUE", "FALSE", "DOUBLEIMPLY", "IMPLY", "OR", 
		"AND", "NOT", "LSEPARATOR", "RSEPARATOR", "WS"
	};


	public LDLfFormulaParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LDLfFormulaParser.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2@\n\2\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6U\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20u\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u0086\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\5\24\u0092\n\24\3\25\3\25\3\25\5\25\u0097\n\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\6\31\u00a0\n\31\r\31\16\31\u00a1\3\31\3\31"+
		"\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\3\5\2\13\f\17"+
		"\17\"\"\u00af\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\3?\3\2\2\2\5A\3\2\2\2\7E\3\2\2\2\tH\3\2\2\2"+
		"\13T\3\2\2\2\rV\3\2\2\2\17X\3\2\2\2\21Z\3\2\2\2\23\\\3\2\2\2\25^\3\2\2"+
		"\2\27`\3\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37t\3\2\2\2!\u0085"+
		"\3\2\2\2#\u0087\3\2\2\2%\u008b\3\2\2\2\'\u0091\3\2\2\2)\u0096\3\2\2\2"+
		"+\u0098\3\2\2\2-\u009a\3\2\2\2/\u009c\3\2\2\2\61\u009f\3\2\2\2\63\64\7"+
		"N\2\2\64\65\7c\2\2\65\66\7u\2\2\66@\7v\2\2\678\7N\2\289\7C\2\29:\7U\2"+
		"\2:@\7V\2\2;<\7n\2\2<=\7c\2\2=>\7u\2\2>@\7v\2\2?\63\3\2\2\2?\67\3\2\2"+
		"\2?;\3\2\2\2@\4\3\2\2\2AB\7g\2\2BC\7r\2\2CD\7u\2\2D\6\3\2\2\2EF\7v\2\2"+
		"FG\7v\2\2G\b\3\2\2\2HI\7h\2\2IJ\7h\2\2J\n\3\2\2\2KL\7g\2\2LM\7p\2\2MU"+
		"\7f\2\2NO\7G\2\2OP\7P\2\2PU\7F\2\2QR\7G\2\2RS\7p\2\2SU\7f\2\2TK\3\2\2"+
		"\2TN\3\2\2\2TQ\3\2\2\2U\f\3\2\2\2VW\7]\2\2W\16\3\2\2\2XY\7_\2\2Y\20\3"+
		"\2\2\2Z[\7>\2\2[\22\3\2\2\2\\]\7@\2\2]\24\3\2\2\2^_\7,\2\2_\26\3\2\2\2"+
		"`a\7A\2\2a\30\3\2\2\2bc\7-\2\2c\32\3\2\2\2de\7=\2\2e\34\3\2\2\2fg\4c|"+
		"\2g\36\3\2\2\2hi\7V\2\2ij\7t\2\2jk\7w\2\2ku\7g\2\2lm\7V\2\2mn\7T\2\2n"+
		"o\7W\2\2ou\7G\2\2pq\7v\2\2qr\7t\2\2rs\7w\2\2su\7g\2\2th\3\2\2\2tl\3\2"+
		"\2\2tp\3\2\2\2u \3\2\2\2vw\7H\2\2wx\7c\2\2xy\7n\2\2yz\7u\2\2z\u0086\7"+
		"g\2\2{|\7H\2\2|}\7C\2\2}~\7N\2\2~\177\7U\2\2\177\u0086\7G\2\2\u0080\u0081"+
		"\7h\2\2\u0081\u0082\7c\2\2\u0082\u0083\7n\2\2\u0083\u0084\7u\2\2\u0084"+
		"\u0086\7g\2\2\u0085v\3\2\2\2\u0085{\3\2\2\2\u0085\u0080\3\2\2\2\u0086"+
		"\"\3\2\2\2\u0087\u0088\7>\2\2\u0088\u0089\7/\2\2\u0089\u008a\7@\2\2\u008a"+
		"$\3\2\2\2\u008b\u008c\7/\2\2\u008c\u008d\7@\2\2\u008d&\3\2\2\2\u008e\u008f"+
		"\7~\2\2\u008f\u0092\7~\2\2\u0090\u0092\7~\2\2\u0091\u008e\3\2\2\2\u0091"+
		"\u0090\3\2\2\2\u0092(\3\2\2\2\u0093\u0094\7(\2\2\u0094\u0097\7(\2\2\u0095"+
		"\u0097\7(\2\2\u0096\u0093\3\2\2\2\u0096\u0095\3\2\2\2\u0097*\3\2\2\2\u0098"+
		"\u0099\7#\2\2\u0099,\3\2\2\2\u009a\u009b\7*\2\2\u009b.\3\2\2\2\u009c\u009d"+
		"\7+\2\2\u009d\60\3\2\2\2\u009e\u00a0\t\2\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a4\b\31\2\2\u00a4\62\3\2\2\2\n\2?Tt\u0085\u0091\u0096\u00a1"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
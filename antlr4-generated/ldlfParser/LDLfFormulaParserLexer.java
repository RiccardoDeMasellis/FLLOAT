// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/LDLfFormulaParser.g4 by ANTLR 4.5

	package ldlfParser;

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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, TRUE=2, FALSE=3, LAST=4, EPSILON=5, TT=6, FF=7, END=8, DOUBLEIMPLY=9, 
		IMPLY=10, OR=11, AND=12, NOT=13, LSEPARATOR=14, RSEPARATOR=15, BOXLSEPARATOR=16, 
		BOXRSEPARATOR=17, DIAMONDLSEPARATOR=18, DIAMONDRSEPARATOR=19, STAR=20, 
		TEST=21, REGEXPOR=22, CONCATENATION=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ID", "TRUE", "FALSE", "LAST", "EPSILON", "TT", "FF", "END", "DOUBLEIMPLY", 
		"IMPLY", "OR", "AND", "NOT", "LSEPARATOR", "RSEPARATOR", "BOXLSEPARATOR", 
		"BOXRSEPARATOR", "DIAMONDLSEPARATOR", "DIAMONDRSEPARATOR", "STAR", "TEST", 
		"REGEXPOR", "CONCATENATION", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ID", "TRUE", "FALSE", "LAST", "EPSILON", "TT", "FF", "END", "DOUBLEIMPLY", 
		"IMPLY", "OR", "AND", "NOT", "LSEPARATOR", "RSEPARATOR", "BOXLSEPARATOR", 
		"BOXRSEPARATOR", "DIAMONDLSEPARATOR", "DIAMONDRSEPARATOR", "STAR", "TEST", 
		"REGEXPOR", "CONCATENATION", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LDLfFormulaParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LDLfFormulaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00a6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"C\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"T\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5b\n\5\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\tw\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u0083\n\f\3\r\3"+
		"\r\3\r\5\r\u0088\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\6\31"+
		"\u00a1\n\31\r\31\16\31\u00a2\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\3\2\3\5\2\13\f\17\17\"\"\u00b1\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3"+
		"\2\2\2\5B\3\2\2\2\7S\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2\rg\3\2\2\2\17j\3\2"+
		"\2\2\21v\3\2\2\2\23x\3\2\2\2\25|\3\2\2\2\27\u0082\3\2\2\2\31\u0087\3\2"+
		"\2\2\33\u0089\3\2\2\2\35\u008b\3\2\2\2\37\u008d\3\2\2\2!\u008f\3\2\2\2"+
		"#\u0091\3\2\2\2%\u0093\3\2\2\2\'\u0095\3\2\2\2)\u0097\3\2\2\2+\u0099\3"+
		"\2\2\2-\u009b\3\2\2\2/\u009d\3\2\2\2\61\u00a0\3\2\2\2\63\64\4c|\2\64\4"+
		"\3\2\2\2\65\66\7V\2\2\66\67\7t\2\2\678\7w\2\28C\7g\2\29:\7V\2\2:;\7T\2"+
		"\2;<\7W\2\2<C\7G\2\2=>\7v\2\2>?\7t\2\2?@\7w\2\2@C\7g\2\2AC\7V\2\2B\65"+
		"\3\2\2\2B9\3\2\2\2B=\3\2\2\2BA\3\2\2\2C\6\3\2\2\2DE\7H\2\2EF\7c\2\2FG"+
		"\7n\2\2GH\7u\2\2HT\7g\2\2IJ\7H\2\2JK\7C\2\2KL\7N\2\2LM\7U\2\2MT\7G\2\2"+
		"NO\7h\2\2OP\7c\2\2PQ\7n\2\2QR\7u\2\2RT\7g\2\2SD\3\2\2\2SI\3\2\2\2SN\3"+
		"\2\2\2T\b\3\2\2\2UV\7N\2\2VW\7c\2\2WX\7u\2\2Xb\7v\2\2YZ\7N\2\2Z[\7C\2"+
		"\2[\\\7U\2\2\\b\7V\2\2]^\7n\2\2^_\7c\2\2_`\7u\2\2`b\7v\2\2aU\3\2\2\2a"+
		"Y\3\2\2\2a]\3\2\2\2b\n\3\2\2\2cd\7g\2\2de\7r\2\2ef\7u\2\2f\f\3\2\2\2g"+
		"h\7v\2\2hi\7v\2\2i\16\3\2\2\2jk\7h\2\2kl\7h\2\2l\20\3\2\2\2mn\7g\2\2n"+
		"o\7p\2\2ow\7f\2\2pq\7G\2\2qr\7P\2\2rw\7F\2\2st\7G\2\2tu\7p\2\2uw\7f\2"+
		"\2vm\3\2\2\2vp\3\2\2\2vs\3\2\2\2w\22\3\2\2\2xy\7>\2\2yz\7/\2\2z{\7@\2"+
		"\2{\24\3\2\2\2|}\7/\2\2}~\7@\2\2~\26\3\2\2\2\177\u0080\7~\2\2\u0080\u0083"+
		"\7~\2\2\u0081\u0083\7~\2\2\u0082\177\3\2\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\30\3\2\2\2\u0084\u0085\7(\2\2\u0085\u0088\7(\2\2\u0086\u0088\7(\2\2\u0087"+
		"\u0084\3\2\2\2\u0087\u0086\3\2\2\2\u0088\32\3\2\2\2\u0089\u008a\7#\2\2"+
		"\u008a\34\3\2\2\2\u008b\u008c\7*\2\2\u008c\36\3\2\2\2\u008d\u008e\7+\2"+
		"\2\u008e \3\2\2\2\u008f\u0090\7]\2\2\u0090\"\3\2\2\2\u0091\u0092\7_\2"+
		"\2\u0092$\3\2\2\2\u0093\u0094\7>\2\2\u0094&\3\2\2\2\u0095\u0096\7@\2\2"+
		"\u0096(\3\2\2\2\u0097\u0098\7,\2\2\u0098*\3\2\2\2\u0099\u009a\7A\2\2\u009a"+
		",\3\2\2\2\u009b\u009c\7-\2\2\u009c.\3\2\2\2\u009d\u009e\7=\2\2\u009e\60"+
		"\3\2\2\2\u009f\u00a1\t\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\31"+
		"\2\2\u00a5\62\3\2\2\2\n\2BSav\u0082\u0087\u00a2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
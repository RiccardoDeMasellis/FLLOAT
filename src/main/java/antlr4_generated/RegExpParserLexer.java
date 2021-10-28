// Generated from RegExpParser.g4 by ANTLR 4.5

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
public class RegExpParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STAR=1, TEST=2, ALTERNATION=3, CONCATENATION=4, ID=5, TRUE=6, FALSE=7, 
		DOUBLEIMPLY=8, IMPLY=9, OR=10, AND=11, NOT=12, LSEPARATOR=13, RSEPARATOR=14, 
		WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"STAR", "TEST", "ALTERNATION", "CONCATENATION", "ID", "TRUE", "FALSE", 
		"DOUBLEIMPLY", "IMPLY", "OR", "AND", "NOT", "LSEPARATOR", "RSEPARATOR", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STAR", "TEST", "ALTERNATION", "CONCATENATION", "ID", "TRUE", "FALSE", 
		"DOUBLEIMPLY", "IMPLY", "OR", "AND", "NOT", "LSEPARATOR", "RSEPARATOR", 
		"WS"
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

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public RegExpParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RegExpParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21i\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\5\6+\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\79\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bJ\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\5\13V\n\13\3"+
		"\f\3\f\3\f\5\f[\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\6\20d\n\20\r\20\16"+
		"\20e\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21\3\2\4\7\2\62;AAC\\aac|\5\2\13\f\17\17\"\"o"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2"+
		"\2\2\7%\3\2\2\2\t\'\3\2\2\2\13*\3\2\2\2\r8\3\2\2\2\17I\3\2\2\2\21K\3\2"+
		"\2\2\23O\3\2\2\2\25U\3\2\2\2\27Z\3\2\2\2\31\\\3\2\2\2\33^\3\2\2\2\35`"+
		"\3\2\2\2\37c\3\2\2\2!\"\7,\2\2\"\4\3\2\2\2#$\7A\2\2$\6\3\2\2\2%&\7-\2"+
		"\2&\b\3\2\2\2\'(\7=\2\2(\n\3\2\2\2)+\t\2\2\2*)\3\2\2\2+\f\3\2\2\2,-\7"+
		"V\2\2-.\7t\2\2./\7w\2\2/9\7g\2\2\60\61\7V\2\2\61\62\7T\2\2\62\63\7W\2"+
		"\2\639\7G\2\2\64\65\7v\2\2\65\66\7t\2\2\66\67\7w\2\2\679\7g\2\28,\3\2"+
		"\2\28\60\3\2\2\28\64\3\2\2\29\16\3\2\2\2:;\7H\2\2;<\7c\2\2<=\7n\2\2=>"+
		"\7u\2\2>J\7g\2\2?@\7H\2\2@A\7C\2\2AB\7N\2\2BC\7U\2\2CJ\7G\2\2DE\7h\2\2"+
		"EF\7c\2\2FG\7n\2\2GH\7u\2\2HJ\7g\2\2I:\3\2\2\2I?\3\2\2\2ID\3\2\2\2J\20"+
		"\3\2\2\2KL\7>\2\2LM\7/\2\2MN\7@\2\2N\22\3\2\2\2OP\7/\2\2PQ\7@\2\2Q\24"+
		"\3\2\2\2RS\7~\2\2SV\7~\2\2TV\7~\2\2UR\3\2\2\2UT\3\2\2\2V\26\3\2\2\2WX"+
		"\7(\2\2X[\7(\2\2Y[\7(\2\2ZW\3\2\2\2ZY\3\2\2\2[\30\3\2\2\2\\]\7#\2\2]\32"+
		"\3\2\2\2^_\7*\2\2_\34\3\2\2\2`a\7+\2\2a\36\3\2\2\2bd\t\3\2\2cb\3\2\2\2"+
		"de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\b\20\2\2h \3\2\2\2\t\2*8IU"+
		"Ze\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/LTLfFormulaParser.g4 by ANTLR 4.5

	package ltlfParser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LTLfFormulaParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, TRUE=2, FALSE=3, LAST=4, DOUBLEIMPLY=5, IMPLY=6, OR=7, AND=8, WEAKUNTIL=9, 
		UNTIL=10, RELEASE=11, GLOBALLY=12, EVENTUALLY=13, WEAKNEXT=14, NEXT=15, 
		NOT=16, LSEPARATOR=17, RSEPARATOR=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ID", "TRUE", "FALSE", "LAST", "DOUBLEIMPLY", "IMPLY", "OR", "AND", "WEAKUNTIL", 
		"UNTIL", "RELEASE", "GLOBALLY", "EVENTUALLY", "WEAKNEXT", "NEXT", "NOT", 
		"LSEPARATOR", "RSEPARATOR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ID", "TRUE", "FALSE", "LAST", "DOUBLEIMPLY", "IMPLY", "OR", "AND", 
		"WEAKUNTIL", "UNTIL", "RELEASE", "GLOBALLY", "EVENTUALLY", "WEAKNEXT", 
		"NEXT", "NOT", "LSEPARATOR", "RSEPARATOR", "WS"
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


	public LTLfFormulaParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LTLfFormulaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u008e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\38\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5W\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\5\bc\n\b\3\t\3\t\3\t"+
		"\5\th\n\t\3\n\3\n\3\n\5\nm\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\5\rv\n\r"+
		"\3\16\3\16\3\16\5\16{\n\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\6\24\u0089\n\24\r\24\16\24\u008a\3\24\3\24\2\2\25\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25\3\2\3\5\2\13\f\17\17\"\"\u0099\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\3)\3\2\2\2\5\67\3\2\2\2\7H\3\2\2\2\tV\3\2\2\2\13X\3\2\2\2\r\\\3"+
		"\2\2\2\17b\3\2\2\2\21g\3\2\2\2\23l\3\2\2\2\25n\3\2\2\2\27p\3\2\2\2\31"+
		"u\3\2\2\2\33z\3\2\2\2\35|\3\2\2\2\37\177\3\2\2\2!\u0081\3\2\2\2#\u0083"+
		"\3\2\2\2%\u0085\3\2\2\2\'\u0088\3\2\2\2)*\4c|\2*\4\3\2\2\2+,\7V\2\2,-"+
		"\7t\2\2-.\7w\2\2.8\7g\2\2/\60\7V\2\2\60\61\7T\2\2\61\62\7W\2\2\628\7G"+
		"\2\2\63\64\7v\2\2\64\65\7t\2\2\65\66\7w\2\2\668\7g\2\2\67+\3\2\2\2\67"+
		"/\3\2\2\2\67\63\3\2\2\28\6\3\2\2\29:\7H\2\2:;\7c\2\2;<\7n\2\2<=\7u\2\2"+
		"=I\7g\2\2>?\7H\2\2?@\7C\2\2@A\7N\2\2AB\7U\2\2BI\7G\2\2CD\7h\2\2DE\7c\2"+
		"\2EF\7n\2\2FG\7u\2\2GI\7g\2\2H9\3\2\2\2H>\3\2\2\2HC\3\2\2\2I\b\3\2\2\2"+
		"JK\7N\2\2KL\7c\2\2LM\7u\2\2MW\7v\2\2NO\7N\2\2OP\7C\2\2PQ\7U\2\2QW\7V\2"+
		"\2RS\7n\2\2ST\7c\2\2TU\7u\2\2UW\7v\2\2VJ\3\2\2\2VN\3\2\2\2VR\3\2\2\2W"+
		"\n\3\2\2\2XY\7>\2\2YZ\7/\2\2Z[\7@\2\2[\f\3\2\2\2\\]\7/\2\2]^\7@\2\2^\16"+
		"\3\2\2\2_`\7~\2\2`c\7~\2\2ac\7~\2\2b_\3\2\2\2ba\3\2\2\2c\20\3\2\2\2de"+
		"\7(\2\2eh\7(\2\2fh\7(\2\2gd\3\2\2\2gf\3\2\2\2h\22\3\2\2\2ij\7Y\2\2jm\7"+
		"W\2\2km\7Y\2\2li\3\2\2\2lk\3\2\2\2m\24\3\2\2\2no\7W\2\2o\26\3\2\2\2pq"+
		"\7T\2\2q\30\3\2\2\2rs\7]\2\2sv\7_\2\2tv\7I\2\2ur\3\2\2\2ut\3\2\2\2v\32"+
		"\3\2\2\2wx\7>\2\2x{\7@\2\2y{\7H\2\2zw\3\2\2\2zy\3\2\2\2{\34\3\2\2\2|}"+
		"\7Y\2\2}~\7Z\2\2~\36\3\2\2\2\177\u0080\7Z\2\2\u0080 \3\2\2\2\u0081\u0082"+
		"\7#\2\2\u0082\"\3\2\2\2\u0083\u0084\7*\2\2\u0084$\3\2\2\2\u0085\u0086"+
		"\7+\2\2\u0086&\3\2\2\2\u0087\u0089\t\2\2\2\u0088\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\b\24\2\2\u008d(\3\2\2\2\f\2\67HVbgluz\u008a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
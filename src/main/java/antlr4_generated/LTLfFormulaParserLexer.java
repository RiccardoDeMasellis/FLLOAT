// Generated from LTLfFormulaParser.g4 by ANTLR 4.5

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
public class LTLfFormulaParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LAST=1, WEAKUNTIL=2, UNTIL=3, RELEASE=4, GLOBALLY=5, EVENTUALLY=6, WEAKNEXT=7, 
		NEXT=8, ID=9, TRUE=10, FALSE=11, DOUBLEIMPLY=12, IMPLY=13, OR=14, AND=15, 
		NOT=16, LSEPARATOR=17, RSEPARATOR=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LAST", "WEAKUNTIL", "UNTIL", "RELEASE", "GLOBALLY", "EVENTUALLY", "WEAKNEXT", 
		"NEXT", "ID", "TRUE", "FALSE", "DOUBLEIMPLY", "IMPLY", "OR", "AND", "NOT", 
		"LSEPARATOR", "RSEPARATOR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LAST", "WEAKUNTIL", "UNTIL", "RELEASE", "GLOBALLY", "EVENTUALLY", 
		"WEAKNEXT", "NEXT", "ID", "TRUE", "FALSE", "DOUBLEIMPLY", "IMPLY", "OR", 
		"AND", "NOT", "LSEPARATOR", "RSEPARATOR", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u008f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\66\n\2\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\5\6D"+
		"\n\6\3\7\3\7\3\7\5\7I\n\7\3\b\3\b\3\b\3\t\3\t\3\n\5\nQ\n\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13_\n\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fp\n\f\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\5\17|\n\17\3\20\3\20\3\20\5\20\u0081"+
		"\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\6\24\u008a\n\24\r\24\16\24\u008b"+
		"\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\4\7\2\62;AAC\\aac|\5\2\13\f"+
		"\17\17\"\"\u009a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3\65\3\2\2\2\5:\3\2\2\2\7"+
		"<\3\2\2\2\t>\3\2\2\2\13C\3\2\2\2\rH\3\2\2\2\17J\3\2\2\2\21M\3\2\2\2\23"+
		"P\3\2\2\2\25^\3\2\2\2\27o\3\2\2\2\31q\3\2\2\2\33u\3\2\2\2\35{\3\2\2\2"+
		"\37\u0080\3\2\2\2!\u0082\3\2\2\2#\u0084\3\2\2\2%\u0086\3\2\2\2\'\u0089"+
		"\3\2\2\2)*\7N\2\2*+\7c\2\2+,\7u\2\2,\66\7v\2\2-.\7N\2\2./\7C\2\2/\60\7"+
		"U\2\2\60\66\7V\2\2\61\62\7n\2\2\62\63\7c\2\2\63\64\7u\2\2\64\66\7v\2\2"+
		"\65)\3\2\2\2\65-\3\2\2\2\65\61\3\2\2\2\66\4\3\2\2\2\678\7Y\2\28;\7W\2"+
		"\29;\7Y\2\2:\67\3\2\2\2:9\3\2\2\2;\6\3\2\2\2<=\7W\2\2=\b\3\2\2\2>?\7T"+
		"\2\2?\n\3\2\2\2@A\7]\2\2AD\7_\2\2BD\7I\2\2C@\3\2\2\2CB\3\2\2\2D\f\3\2"+
		"\2\2EF\7>\2\2FI\7@\2\2GI\7H\2\2HE\3\2\2\2HG\3\2\2\2I\16\3\2\2\2JK\7Y\2"+
		"\2KL\7Z\2\2L\20\3\2\2\2MN\7Z\2\2N\22\3\2\2\2OQ\t\2\2\2PO\3\2\2\2Q\24\3"+
		"\2\2\2RS\7V\2\2ST\7t\2\2TU\7w\2\2U_\7g\2\2VW\7V\2\2WX\7T\2\2XY\7W\2\2"+
		"Y_\7G\2\2Z[\7v\2\2[\\\7t\2\2\\]\7w\2\2]_\7g\2\2^R\3\2\2\2^V\3\2\2\2^Z"+
		"\3\2\2\2_\26\3\2\2\2`a\7H\2\2ab\7c\2\2bc\7n\2\2cd\7u\2\2dp\7g\2\2ef\7"+
		"H\2\2fg\7C\2\2gh\7N\2\2hi\7U\2\2ip\7G\2\2jk\7h\2\2kl\7c\2\2lm\7n\2\2m"+
		"n\7u\2\2np\7g\2\2o`\3\2\2\2oe\3\2\2\2oj\3\2\2\2p\30\3\2\2\2qr\7>\2\2r"+
		"s\7/\2\2st\7@\2\2t\32\3\2\2\2uv\7/\2\2vw\7@\2\2w\34\3\2\2\2xy\7~\2\2y"+
		"|\7~\2\2z|\7~\2\2{x\3\2\2\2{z\3\2\2\2|\36\3\2\2\2}~\7(\2\2~\u0081\7(\2"+
		"\2\177\u0081\7(\2\2\u0080}\3\2\2\2\u0080\177\3\2\2\2\u0081 \3\2\2\2\u0082"+
		"\u0083\7#\2\2\u0083\"\3\2\2\2\u0084\u0085\7*\2\2\u0085$\3\2\2\2\u0086"+
		"\u0087\7+\2\2\u0087&\3\2\2\2\u0088\u008a\t\3\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\b\24\2\2\u008e(\3\2\2\2\r\2\65:CHP^o{\u0080\u008b\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
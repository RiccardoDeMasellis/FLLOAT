// Generated from LTLfFormulaParser.g4 by ANTLR 4.3

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
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

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

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'"
	};
	public static final String[] ruleNames = {
		"LAST", "WEAKUNTIL", "UNTIL", "RELEASE", "GLOBALLY", "EVENTUALLY", "WEAKNEXT", 
		"NEXT", "ID", "TRUE", "FALSE", "DOUBLEIMPLY", "IMPLY", "OR", "AND", "NOT", 
		"LSEPARATOR", "RSEPARATOR", "WS"
	};


	public LTLfFormulaParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LTLfFormulaParser.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u008e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\66\n\2\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\5\6D"+
		"\n\6\3\7\3\7\3\7\5\7I\n\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13^\n\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fo\n\f\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\5\17{\n\17\3\20\3\20\3\20\5\20\u0080\n"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\6\24\u0089\n\24\r\24\16\24\u008a"+
		"\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\3\5\2\13\f\17\17\"\"\u0099"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\3\65\3\2\2\2\5:\3\2\2\2\7<\3\2\2\2\t>\3\2"+
		"\2\2\13C\3\2\2\2\rH\3\2\2\2\17J\3\2\2\2\21M\3\2\2\2\23O\3\2\2\2\25]\3"+
		"\2\2\2\27n\3\2\2\2\31p\3\2\2\2\33t\3\2\2\2\35z\3\2\2\2\37\177\3\2\2\2"+
		"!\u0081\3\2\2\2#\u0083\3\2\2\2%\u0085\3\2\2\2\'\u0088\3\2\2\2)*\7N\2\2"+
		"*+\7c\2\2+,\7u\2\2,\66\7v\2\2-.\7N\2\2./\7C\2\2/\60\7U\2\2\60\66\7V\2"+
		"\2\61\62\7n\2\2\62\63\7c\2\2\63\64\7u\2\2\64\66\7v\2\2\65)\3\2\2\2\65"+
		"-\3\2\2\2\65\61\3\2\2\2\66\4\3\2\2\2\678\7Y\2\28;\7W\2\29;\7Y\2\2:\67"+
		"\3\2\2\2:9\3\2\2\2;\6\3\2\2\2<=\7W\2\2=\b\3\2\2\2>?\7T\2\2?\n\3\2\2\2"+
		"@A\7]\2\2AD\7_\2\2BD\7I\2\2C@\3\2\2\2CB\3\2\2\2D\f\3\2\2\2EF\7>\2\2FI"+
		"\7@\2\2GI\7H\2\2HE\3\2\2\2HG\3\2\2\2I\16\3\2\2\2JK\7Y\2\2KL\7Z\2\2L\20"+
		"\3\2\2\2MN\7Z\2\2N\22\3\2\2\2OP\4c|\2P\24\3\2\2\2QR\7V\2\2RS\7t\2\2ST"+
		"\7w\2\2T^\7g\2\2UV\7V\2\2VW\7T\2\2WX\7W\2\2X^\7G\2\2YZ\7v\2\2Z[\7t\2\2"+
		"[\\\7w\2\2\\^\7g\2\2]Q\3\2\2\2]U\3\2\2\2]Y\3\2\2\2^\26\3\2\2\2_`\7H\2"+
		"\2`a\7c\2\2ab\7n\2\2bc\7u\2\2co\7g\2\2de\7H\2\2ef\7C\2\2fg\7N\2\2gh\7"+
		"U\2\2ho\7G\2\2ij\7h\2\2jk\7c\2\2kl\7n\2\2lm\7u\2\2mo\7g\2\2n_\3\2\2\2"+
		"nd\3\2\2\2ni\3\2\2\2o\30\3\2\2\2pq\7>\2\2qr\7/\2\2rs\7@\2\2s\32\3\2\2"+
		"\2tu\7/\2\2uv\7@\2\2v\34\3\2\2\2wx\7~\2\2x{\7~\2\2y{\7~\2\2zw\3\2\2\2"+
		"zy\3\2\2\2{\36\3\2\2\2|}\7(\2\2}\u0080\7(\2\2~\u0080\7(\2\2\177|\3\2\2"+
		"\2\177~\3\2\2\2\u0080 \3\2\2\2\u0081\u0082\7#\2\2\u0082\"\3\2\2\2\u0083"+
		"\u0084\7*\2\2\u0084$\3\2\2\2\u0085\u0086\7+\2\2\u0086&\3\2\2\2\u0087\u0089"+
		"\t\2\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\b\24\2\2\u008d(\3\2\2\2"+
		"\f\2\65:CH]nz\177\u008a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
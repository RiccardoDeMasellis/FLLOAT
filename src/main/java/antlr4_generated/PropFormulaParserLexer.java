// Generated from PropFormulaParser.g4 by ANTLR 4.3

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
public class PropFormulaParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, TRUE=2, FALSE=3, DOUBLEIMPLY=4, IMPLY=5, OR=6, AND=7, NOT=8, LSEPARATOR=9, 
		RSEPARATOR=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'"
	};
	public static final String[] ruleNames = {
		"ID", "TRUE", "FALSE", "DOUBLEIMPLY", "IMPLY", "OR", "AND", "NOT", "LSEPARATOR", 
		"RSEPARATOR", "WS"
	};


	public PropFormulaParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PropFormulaParser.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rX\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3(\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\49\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\5\7E\n\7\3\b\3\b\3\b\5"+
		"\bJ\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\6\fS\n\f\r\f\16\fT\3\f\3\f\2\2\r"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\3\5\2\13\f\17"+
		"\17\"\"^\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\3\31\3\2\2\2\5\'\3\2\2\2\78\3\2\2\2\t:\3\2\2\2\13>\3\2\2\2\r"+
		"D\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27R\3\2\2\2"+
		"\31\32\4c|\2\32\4\3\2\2\2\33\34\7V\2\2\34\35\7t\2\2\35\36\7w\2\2\36(\7"+
		"g\2\2\37 \7V\2\2 !\7T\2\2!\"\7W\2\2\"(\7G\2\2#$\7v\2\2$%\7t\2\2%&\7w\2"+
		"\2&(\7g\2\2\'\33\3\2\2\2\'\37\3\2\2\2\'#\3\2\2\2(\6\3\2\2\2)*\7H\2\2*"+
		"+\7c\2\2+,\7n\2\2,-\7u\2\2-9\7g\2\2./\7H\2\2/\60\7C\2\2\60\61\7N\2\2\61"+
		"\62\7U\2\2\629\7G\2\2\63\64\7h\2\2\64\65\7c\2\2\65\66\7n\2\2\66\67\7u"+
		"\2\2\679\7g\2\28)\3\2\2\28.\3\2\2\28\63\3\2\2\29\b\3\2\2\2:;\7>\2\2;<"+
		"\7/\2\2<=\7@\2\2=\n\3\2\2\2>?\7/\2\2?@\7@\2\2@\f\3\2\2\2AB\7~\2\2BE\7"+
		"~\2\2CE\7~\2\2DA\3\2\2\2DC\3\2\2\2E\16\3\2\2\2FG\7(\2\2GJ\7(\2\2HJ\7("+
		"\2\2IF\3\2\2\2IH\3\2\2\2J\20\3\2\2\2KL\7#\2\2L\22\3\2\2\2MN\7*\2\2N\24"+
		"\3\2\2\2OP\7+\2\2P\26\3\2\2\2QS\t\2\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2"+
		"TU\3\2\2\2UV\3\2\2\2VW\b\f\2\2W\30\3\2\2\2\b\2\'8DIT\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
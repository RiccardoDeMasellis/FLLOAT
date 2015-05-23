// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/fromStringToCharParser.g4 by ANTLR 4.5

package fromStringToCharParser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fromStringToCharParserParser extends Parser {
    public static final int
            EVERYTHING = 1, LSEPARATOR = 2, RSEPARATOR = 3, WS = 4;
    public static final int
            RULE_start = 0, RULE_expression = 1, RULE_string = 2;
    public static final String[] ruleNames = {
            "start", "expression", "string"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\6\34\4\2\t\2\4\3" +
                    "\t\3\4\4\t\4\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\22\n\3\f\3\16\3\25" +
                    "\13\3\3\3\5\3\30\n\3\3\4\3\4\3\4\2\2\5\2\4\6\2\2\32\2\b\3\2\2\2\4\27\3" +
                    "\2\2\2\6\31\3\2\2\2\b\t\5\4\3\2\t\n\7\2\2\3\n\3\3\2\2\2\13\23\5\6\4\2" +
                    "\f\r\7\4\2\2\r\16\5\6\4\2\16\17\7\5\2\2\17\20\5\6\4\2\20\22\3\2\2\2\21" +
                    "\f\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\30\3\2\2\2\25" +
                    "\23\3\2\2\2\26\30\5\6\4\2\27\13\3\2\2\2\27\26\3\2\2\2\30\5\3\2\2\2\31" +
                    "\32\7\3\2\2\32\7\3\2\2\2\4\23\27";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "EVERYTHING", "LSEPARATOR", "RSEPARATOR", "WS"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public fromStringToCharParserParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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

    @Override
    public String getGrammarFileName() {
        return "fromStringToCharParser.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final StartContext start() throws RecognitionException {
        StartContext _localctx = new StartContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_start);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(6);
                expression();
                setState(7);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_expression);
        int _la;
        try {
            setState(21);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(9);
                    string();
                    setState(17);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == LSEPARATOR) {
                        {
                            {
                                setState(10);
                                match(LSEPARATOR);
                                setState(11);
                                string();
                                setState(12);
                                match(RSEPARATOR);
                                setState(13);
                                string();
                            }
                        }
                        setState(19);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(20);
                    string();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StringContext string() throws RecognitionException {
        StringContext _localctx = new StringContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_string);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(23);
                match(EVERYTHING);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StartContext extends ParserRuleContext {
        public StartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(fromStringToCharParserParser.EOF, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_start;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof fromStringToCharParserVisitor)
                return ((fromStringToCharParserVisitor<? extends T>) visitor).visitStart(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<StringContext> string() {
            return getRuleContexts(StringContext.class);
        }

        public StringContext string(int i) {
            return getRuleContext(StringContext.class, i);
        }

        public List<TerminalNode> LSEPARATOR() {
            return getTokens(fromStringToCharParserParser.LSEPARATOR);
        }

        public TerminalNode LSEPARATOR(int i) {
            return getToken(fromStringToCharParserParser.LSEPARATOR, i);
        }

        public List<TerminalNode> RSEPARATOR() {
            return getTokens(fromStringToCharParserParser.RSEPARATOR);
        }

        public TerminalNode RSEPARATOR(int i) {
            return getToken(fromStringToCharParserParser.RSEPARATOR, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof fromStringToCharParserVisitor)
                return ((fromStringToCharParserVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StringContext extends ParserRuleContext {
        public StringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode EVERYTHING() {
            return getToken(fromStringToCharParserParser.EVERYTHING, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof fromStringToCharParserVisitor)
                return ((fromStringToCharParserVisitor<? extends T>) visitor).visitString(this);
            else return visitor.visitChildren(this);
        }
    }
}
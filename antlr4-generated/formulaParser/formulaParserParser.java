// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/formulaParser.g4 by ANTLR 4.5

package formulaParser;

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
public class formulaParserParser extends Parser {
    public static final int
            FORMULA = 1, SEPARATOR = 2, FORMULATYPE = 3, WS = 4;
    public static final int
            RULE_start = 0, RULE_expression = 1, RULE_formula = 2;
    public static final String[] ruleNames = {
            "start", "expression", "formula"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\6\30\4\2\t\2\4\3" +
                    "\t\3\4\4\t\4\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\21\n\3\f\3\16\3\24\13" +
                    "\3\3\4\3\4\3\4\2\2\5\2\4\6\2\2\25\2\b\3\2\2\2\4\13\3\2\2\2\6\25\3\2\2" +
                    "\2\b\t\5\4\3\2\t\n\7\2\2\3\n\3\3\2\2\2\13\f\7\3\2\2\f\r\7\4\2\2\r\22\5" +
                    "\6\4\2\16\17\7\4\2\2\17\21\5\6\4\2\20\16\3\2\2\2\21\24\3\2\2\2\22\20\3" +
                    "\2\2\2\22\23\3\2\2\2\23\5\3\2\2\2\24\22\3\2\2\2\25\26\7\3\2\2\26\7\3\2" +
                    "\2\2\3\22";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "FORMULA", "SEPARATOR", "FORMULATYPE", "WS"
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

    public formulaParserParser(TokenStream input) {
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
        return "formulaParser.g4";
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
            enterOuterAlt(_localctx, 1);
            {
                setState(9);
                match(FORMULA);
                setState(10);
                match(SEPARATOR);
                setState(11);
                formula();
                setState(16);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == SEPARATOR) {
                    {
                        {
                            setState(12);
                            match(SEPARATOR);
                            setState(13);
                            formula();
                        }
                    }
                    setState(18);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
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

    public final FormulaContext formula() throws RecognitionException {
        FormulaContext _localctx = new FormulaContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_formula);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(19);
                match(FORMULA);
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
            return getToken(formulaParserParser.EOF, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_start;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof formulaParserVisitor)
                return ((formulaParserVisitor<? extends T>) visitor).visitStart(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FORMULA() {
            return getToken(formulaParserParser.FORMULA, 0);
        }

        public List<TerminalNode> SEPARATOR() {
            return getTokens(formulaParserParser.SEPARATOR);
        }

        public TerminalNode SEPARATOR(int i) {
            return getToken(formulaParserParser.SEPARATOR, i);
        }

        public List<FormulaContext> formula() {
            return getRuleContexts(FormulaContext.class);
        }

        public FormulaContext formula(int i) {
            return getRuleContext(FormulaContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof formulaParserVisitor)
                return ((formulaParserVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FormulaContext extends ParserRuleContext {
        public FormulaContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FORMULA() {
            return getToken(formulaParserParser.FORMULA, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_formula;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof formulaParserVisitor)
                return ((formulaParserVisitor<? extends T>) visitor).visitFormula(this);
            else return visitor.visitChildren(this);
        }
    }
}
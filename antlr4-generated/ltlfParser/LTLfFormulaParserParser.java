// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/LTLfFormulaParser.g4 by ANTLR 4.5

	package ltlfParser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LTLfFormulaParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, TRUE=2, FALSE=3, LAST=4, DOUBLEIMPLY=5, IMPLY=6, OR=7, AND=8, WEAKUNTIL=9, 
		UNTIL=10, RELEASE=11, GLOBALLY=12, EVENTUALLY=13, WEAKNEXT=14, NEXT=15, 
		NOT=16, LSEPARATOR=17, RSEPARATOR=18, WS=19;
	public static final int
		RULE_start = 0, RULE_expression = 1, RULE_checkdoubleImplication = 2, 
		RULE_checkImplication = 3, RULE_checkOr = 4, RULE_checkAnd = 5, RULE_checkWeakUntil = 6, 
		RULE_checkRelease = 7, RULE_checkUntil = 8, RULE_checkGlobally = 9, RULE_checkEventually = 10, 
		RULE_checkWeakNext = 11, RULE_checkNext = 12, RULE_checkNot = 13, RULE_atom = 14;
	public static final String[] ruleNames = {
		"start", "expression", "checkdoubleImplication", "checkImplication", "checkOr", 
		"checkAnd", "checkWeakUntil", "checkRelease", "checkUntil", "checkGlobally", 
		"checkEventually", "checkWeakNext", "checkNext", "checkNot", "atom"
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

	@Override
	public String getGrammarFileName() { return "LTLfFormulaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LTLfFormulaParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LTLfFormulaParserParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); 
			expression();
			setState(31); 
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public CheckdoubleImplicationContext checkdoubleImplication() {
			return getRuleContext(CheckdoubleImplicationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			checkdoubleImplication();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckdoubleImplicationContext extends ParserRuleContext {
		public List<CheckImplicationContext> checkImplication() {
			return getRuleContexts(CheckImplicationContext.class);
		}
		public CheckImplicationContext checkImplication(int i) {
			return getRuleContext(CheckImplicationContext.class,i);
		}
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(LTLfFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(LTLfFormulaParserParser.DOUBLEIMPLY, i);
		}
		public CheckdoubleImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkdoubleImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckdoubleImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckdoubleImplicationContext checkdoubleImplication() throws RecognitionException {
		CheckdoubleImplicationContext _localctx = new CheckdoubleImplicationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_checkdoubleImplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			checkImplication();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLEIMPLY) {
				{
				{
				setState(36); 
				match(DOUBLEIMPLY);
				setState(37); 
				checkImplication();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckImplicationContext extends ParserRuleContext {
		public List<CheckOrContext> checkOr() {
			return getRuleContexts(CheckOrContext.class);
		}
		public CheckOrContext checkOr(int i) {
			return getRuleContext(CheckOrContext.class,i);
		}
		public List<TerminalNode> IMPLY() { return getTokens(LTLfFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(LTLfFormulaParserParser.IMPLY, i);
		}
		public CheckImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckImplicationContext checkImplication() throws RecognitionException {
		CheckImplicationContext _localctx = new CheckImplicationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_checkImplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			checkOr();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPLY) {
				{
				{
				setState(44); 
				match(IMPLY);
				setState(45); 
				checkOr();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckOrContext extends ParserRuleContext {
		public List<CheckAndContext> checkAnd() {
			return getRuleContexts(CheckAndContext.class);
		}
		public CheckAndContext checkAnd(int i) {
			return getRuleContext(CheckAndContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LTLfFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LTLfFormulaParserParser.OR, i);
		}
		public CheckOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkOr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckOrContext checkOr() throws RecognitionException {
		CheckOrContext _localctx = new CheckOrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_checkOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			checkAnd();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(52); 
				match(OR);
				setState(53); 
				checkAnd();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckAndContext extends ParserRuleContext {
		public List<CheckWeakUntilContext> checkWeakUntil() {
			return getRuleContexts(CheckWeakUntilContext.class);
		}
		public CheckWeakUntilContext checkWeakUntil(int i) {
			return getRuleContext(CheckWeakUntilContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LTLfFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LTLfFormulaParserParser.AND, i);
		}
		public CheckAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkAnd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckAndContext checkAnd() throws RecognitionException {
		CheckAndContext _localctx = new CheckAndContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_checkAnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			checkWeakUntil();
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(60); 
				match(AND);
				setState(61); 
				checkWeakUntil();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckWeakUntilContext extends ParserRuleContext {
		public List<CheckReleaseContext> checkRelease() {
			return getRuleContexts(CheckReleaseContext.class);
		}
		public CheckReleaseContext checkRelease(int i) {
			return getRuleContext(CheckReleaseContext.class,i);
		}
		public List<TerminalNode> WEAKUNTIL() { return getTokens(LTLfFormulaParserParser.WEAKUNTIL); }
		public TerminalNode WEAKUNTIL(int i) {
			return getToken(LTLfFormulaParserParser.WEAKUNTIL, i);
		}
		public CheckWeakUntilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkWeakUntil; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckWeakUntil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckWeakUntilContext checkWeakUntil() throws RecognitionException {
		CheckWeakUntilContext _localctx = new CheckWeakUntilContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_checkWeakUntil);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			checkRelease();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WEAKUNTIL) {
				{
				{
				setState(68); 
				match(WEAKUNTIL);
				setState(69); 
				checkRelease();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckReleaseContext extends ParserRuleContext {
		public List<CheckUntilContext> checkUntil() {
			return getRuleContexts(CheckUntilContext.class);
		}
		public CheckUntilContext checkUntil(int i) {
			return getRuleContext(CheckUntilContext.class,i);
		}
		public List<TerminalNode> RELEASE() { return getTokens(LTLfFormulaParserParser.RELEASE); }
		public TerminalNode RELEASE(int i) {
			return getToken(LTLfFormulaParserParser.RELEASE, i);
		}
		public CheckReleaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkRelease; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckRelease(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckReleaseContext checkRelease() throws RecognitionException {
		CheckReleaseContext _localctx = new CheckReleaseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_checkRelease);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); 
			checkUntil();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RELEASE) {
				{
				{
				setState(76); 
				match(RELEASE);
				setState(77); 
				checkUntil();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckUntilContext extends ParserRuleContext {
		public List<CheckGloballyContext> checkGlobally() {
			return getRuleContexts(CheckGloballyContext.class);
		}
		public CheckGloballyContext checkGlobally(int i) {
			return getRuleContext(CheckGloballyContext.class,i);
		}
		public List<TerminalNode> UNTIL() { return getTokens(LTLfFormulaParserParser.UNTIL); }
		public TerminalNode UNTIL(int i) {
			return getToken(LTLfFormulaParserParser.UNTIL, i);
		}
		public CheckUntilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkUntil; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckUntil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckUntilContext checkUntil() throws RecognitionException {
		CheckUntilContext _localctx = new CheckUntilContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_checkUntil);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); 
			checkGlobally();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNTIL) {
				{
				{
				setState(84); 
				match(UNTIL);
				setState(85); 
				checkGlobally();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckGloballyContext extends ParserRuleContext {
		public CheckEventuallyContext checkEventually() {
			return getRuleContext(CheckEventuallyContext.class,0);
		}
		public TerminalNode GLOBALLY() { return getToken(LTLfFormulaParserParser.GLOBALLY, 0); }
		public CheckGloballyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkGlobally; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckGlobally(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckGloballyContext checkGlobally() throws RecognitionException {
		CheckGloballyContext _localctx = new CheckGloballyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_checkGlobally);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if (_la==GLOBALLY) {
				{
				setState(91); 
				match(GLOBALLY);
				}
			}

			setState(94); 
			checkEventually();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckEventuallyContext extends ParserRuleContext {
		public CheckWeakNextContext checkWeakNext() {
			return getRuleContext(CheckWeakNextContext.class,0);
		}
		public TerminalNode EVENTUALLY() { return getToken(LTLfFormulaParserParser.EVENTUALLY, 0); }
		public CheckEventuallyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkEventually; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckEventually(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckEventuallyContext checkEventually() throws RecognitionException {
		CheckEventuallyContext _localctx = new CheckEventuallyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_checkEventually);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if (_la==EVENTUALLY) {
				{
				setState(96); 
				match(EVENTUALLY);
				}
			}

			setState(99); 
			checkWeakNext();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckWeakNextContext extends ParserRuleContext {
		public CheckNextContext checkNext() {
			return getRuleContext(CheckNextContext.class,0);
		}
		public TerminalNode WEAKNEXT() { return getToken(LTLfFormulaParserParser.WEAKNEXT, 0); }
		public CheckWeakNextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkWeakNext; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckWeakNext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckWeakNextContext checkWeakNext() throws RecognitionException {
		CheckWeakNextContext _localctx = new CheckWeakNextContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_checkWeakNext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if (_la==WEAKNEXT) {
				{
				setState(101); 
				match(WEAKNEXT);
				}
			}

			setState(104); 
			checkNext();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckNextContext extends ParserRuleContext {
		public CheckNotContext checkNot() {
			return getRuleContext(CheckNotContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(LTLfFormulaParserParser.NEXT, 0); }
		public CheckNextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkNext; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckNext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckNextContext checkNext() throws RecognitionException {
		CheckNextContext _localctx = new CheckNextContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_checkNext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if (_la==NEXT) {
				{
				setState(106); 
				match(NEXT);
				}
			}

			setState(109); 
			checkNot();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CheckNotContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode NOT() { return getToken(LTLfFormulaParserParser.NOT, 0); }
		public TerminalNode LSEPARATOR() { return getToken(LTLfFormulaParserParser.LSEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LTLfFormulaParserParser.RSEPARATOR, 0); }
		public CheckNotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkNot; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitCheckNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckNotContext checkNot() throws RecognitionException {
		CheckNotContext _localctx = new CheckNotContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_checkNot);
		int _la;
		try {
			setState(122);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(111); 
					match(NOT);
					}
				}

				setState(114); 
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(115); 
					match(NOT);
					}
				}

				setState(118); 
				match(LSEPARATOR);
				setState(119); 
				expression();
				setState(120); 
				match(RSEPARATOR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LTLfFormulaParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LTLfFormulaParserParser.ID, i);
		}
		public TerminalNode TRUE() { return getToken(LTLfFormulaParserParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LTLfFormulaParserParser.FALSE, 0); }
		public TerminalNode LAST() { return getToken(LTLfFormulaParserParser.LAST, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atom);
		int _la;
		try {
			setState(133);
			switch (_input.LA(1)) {
			case EOF:
			case ID:
			case DOUBLEIMPLY:
			case IMPLY:
			case OR:
			case AND:
			case WEAKUNTIL:
			case UNTIL:
			case RELEASE:
			case RSEPARATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(124); 
					match(ID);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(130); 
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(131); 
				match(FALSE);
				}
				break;
			case LAST:
				enterOuterAlt(_localctx, 4);
				{
				setState(132); 
				match(LAST);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25\u008a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\7\4)\n\4\f\4\16\4,\13\4\3\5\3\5\3\5\7\5\61\n\5\f\5\16\5"+
		"\64\13\5\3\6\3\6\3\6\7\69\n\6\f\6\16\6<\13\6\3\7\3\7\3\7\7\7A\n\7\f\7"+
		"\16\7D\13\7\3\b\3\b\3\b\7\bI\n\b\f\b\16\bL\13\b\3\t\3\t\3\t\7\tQ\n\t\f"+
		"\t\16\tT\13\t\3\n\3\n\3\n\7\nY\n\n\f\n\16\n\\\13\n\3\13\5\13_\n\13\3\13"+
		"\3\13\3\f\5\fd\n\f\3\f\3\f\3\r\5\ri\n\r\3\r\3\r\3\16\5\16n\n\16\3\16\3"+
		"\16\3\17\5\17s\n\17\3\17\3\17\5\17w\n\17\3\17\3\17\3\17\3\17\5\17}\n\17"+
		"\3\20\7\20\u0080\n\20\f\20\16\20\u0083\13\20\3\20\3\20\3\20\5\20\u0088"+
		"\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\u008c\2 "+
		"\3\2\2\2\4#\3\2\2\2\6%\3\2\2\2\b-\3\2\2\2\n\65\3\2\2\2\f=\3\2\2\2\16E"+
		"\3\2\2\2\20M\3\2\2\2\22U\3\2\2\2\24^\3\2\2\2\26c\3\2\2\2\30h\3\2\2\2\32"+
		"m\3\2\2\2\34|\3\2\2\2\36\u0087\3\2\2\2 !\5\4\3\2!\"\7\2\2\3\"\3\3\2\2"+
		"\2#$\5\6\4\2$\5\3\2\2\2%*\5\b\5\2&\'\7\7\2\2\')\5\b\5\2(&\3\2\2\2),\3"+
		"\2\2\2*(\3\2\2\2*+\3\2\2\2+\7\3\2\2\2,*\3\2\2\2-\62\5\n\6\2./\7\b\2\2"+
		"/\61\5\n\6\2\60.\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\t\3\2\2\2\64\62\3\2\2\2\65:\5\f\7\2\66\67\7\t\2\2\679\5\f\7\28\66\3\2"+
		"\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\13\3\2\2\2<:\3\2\2\2=B\5\16\b\2>?"+
		"\7\n\2\2?A\5\16\b\2@>\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\r\3\2\2\2"+
		"DB\3\2\2\2EJ\5\20\t\2FG\7\13\2\2GI\5\20\t\2HF\3\2\2\2IL\3\2\2\2JH\3\2"+
		"\2\2JK\3\2\2\2K\17\3\2\2\2LJ\3\2\2\2MR\5\22\n\2NO\7\r\2\2OQ\5\22\n\2P"+
		"N\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\21\3\2\2\2TR\3\2\2\2UZ\5\24\13"+
		"\2VW\7\f\2\2WY\5\24\13\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\23"+
		"\3\2\2\2\\Z\3\2\2\2]_\7\16\2\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\5\26\f"+
		"\2a\25\3\2\2\2bd\7\17\2\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\5\30\r\2f\27"+
		"\3\2\2\2gi\7\20\2\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\5\32\16\2k\31\3\2"+
		"\2\2ln\7\21\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\5\34\17\2p\33\3\2\2\2"+
		"qs\7\22\2\2rq\3\2\2\2rs\3\2\2\2st\3\2\2\2t}\5\36\20\2uw\7\22\2\2vu\3\2"+
		"\2\2vw\3\2\2\2wx\3\2\2\2xy\7\23\2\2yz\5\4\3\2z{\7\24\2\2{}\3\2\2\2|r\3"+
		"\2\2\2|v\3\2\2\2}\35\3\2\2\2~\u0080\7\3\2\2\177~\3\2\2\2\u0080\u0083\3"+
		"\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0088\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0088\7\4\2\2\u0085\u0088\7\5\2\2\u0086\u0088\7\6"+
		"\2\2\u0087\u0081\3\2\2\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\37\3\2\2\2\22*\62:BJRZ^chmrv|\u0081\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
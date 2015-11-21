// Generated from LTLfFormulaParser.g4 by ANTLR 4.5

	package antlr4_generated;

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
		LAST=1, WEAKUNTIL=2, UNTIL=3, RELEASE=4, GLOBALLY=5, EVENTUALLY=6, WEAKNEXT=7, 
		NEXT=8, ID=9, TRUE=10, FALSE=11, DOUBLEIMPLY=12, IMPLY=13, OR=14, AND=15, 
		NOT=16, LSEPARATOR=17, RSEPARATOR=18, WS=19;
	public static final int
		RULE_start = 0, RULE_expression = 1, RULE_doubleImplicationTemp = 2, RULE_implicationTemp = 3, 
		RULE_orTemp = 4, RULE_andTemp = 5, RULE_weakUntil = 6, RULE_release = 7, 
		RULE_until = 8, RULE_globally = 9, RULE_eventually = 10, RULE_weakNext = 11, 
		RULE_next = 12, RULE_notTemp = 13, RULE_ltlfAtom = 14, RULE_propositionalFormula = 15, 
		RULE_doubleImplicationProp = 16, RULE_implicationProp = 17, RULE_orProp = 18, 
		RULE_andProp = 19, RULE_notProp = 20, RULE_atom = 21;
	public static final String[] ruleNames = {
		"start", "expression", "doubleImplicationTemp", "implicationTemp", "orTemp", 
		"andTemp", "weakUntil", "release", "until", "globally", "eventually", 
		"weakNext", "next", "notTemp", "ltlfAtom", "propositionalFormula", "doubleImplicationProp", 
		"implicationProp", "orProp", "andProp", "notProp", "atom"
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
			setState(44);
			expression();
			setState(45);
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
		public DoubleImplicationTempContext doubleImplicationTemp() {
			return getRuleContext(DoubleImplicationTempContext.class,0);
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
			setState(47);
			doubleImplicationTemp();
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

	public static class DoubleImplicationTempContext extends ParserRuleContext {
		public List<ImplicationTempContext> implicationTemp() {
			return getRuleContexts(ImplicationTempContext.class);
		}
		public ImplicationTempContext implicationTemp(int i) {
			return getRuleContext(ImplicationTempContext.class,i);
		}
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(LTLfFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(LTLfFormulaParserParser.DOUBLEIMPLY, i);
		}
		public DoubleImplicationTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleImplicationTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitDoubleImplicationTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleImplicationTempContext doubleImplicationTemp() throws RecognitionException {
		DoubleImplicationTempContext _localctx = new DoubleImplicationTempContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_doubleImplicationTemp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			implicationTemp();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLEIMPLY) {
				{
				{
				setState(50);
				match(DOUBLEIMPLY);
				setState(51);
				implicationTemp();
				}
				}
				setState(56);
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

	public static class ImplicationTempContext extends ParserRuleContext {
		public List<OrTempContext> orTemp() {
			return getRuleContexts(OrTempContext.class);
		}
		public OrTempContext orTemp(int i) {
			return getRuleContext(OrTempContext.class,i);
		}
		public List<TerminalNode> IMPLY() { return getTokens(LTLfFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(LTLfFormulaParserParser.IMPLY, i);
		}
		public ImplicationTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implicationTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitImplicationTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplicationTempContext implicationTemp() throws RecognitionException {
		ImplicationTempContext _localctx = new ImplicationTempContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_implicationTemp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			orTemp();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPLY) {
				{
				{
				setState(58);
				match(IMPLY);
				setState(59);
				orTemp();
				}
				}
				setState(64);
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

	public static class OrTempContext extends ParserRuleContext {
		public List<AndTempContext> andTemp() {
			return getRuleContexts(AndTempContext.class);
		}
		public AndTempContext andTemp(int i) {
			return getRuleContext(AndTempContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LTLfFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LTLfFormulaParserParser.OR, i);
		}
		public OrTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitOrTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrTempContext orTemp() throws RecognitionException {
		OrTempContext _localctx = new OrTempContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_orTemp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			andTemp();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(66);
				match(OR);
				setState(67);
				andTemp();
				}
				}
				setState(72);
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

	public static class AndTempContext extends ParserRuleContext {
		public List<WeakUntilContext> weakUntil() {
			return getRuleContexts(WeakUntilContext.class);
		}
		public WeakUntilContext weakUntil(int i) {
			return getRuleContext(WeakUntilContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LTLfFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LTLfFormulaParserParser.AND, i);
		}
		public AndTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitAndTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndTempContext andTemp() throws RecognitionException {
		AndTempContext _localctx = new AndTempContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_andTemp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			weakUntil();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(74);
				match(AND);
				setState(75);
				weakUntil();
				}
				}
				setState(80);
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

	public static class WeakUntilContext extends ParserRuleContext {
		public List<ReleaseContext> release() {
			return getRuleContexts(ReleaseContext.class);
		}
		public ReleaseContext release(int i) {
			return getRuleContext(ReleaseContext.class,i);
		}
		public List<TerminalNode> WEAKUNTIL() { return getTokens(LTLfFormulaParserParser.WEAKUNTIL); }
		public TerminalNode WEAKUNTIL(int i) {
			return getToken(LTLfFormulaParserParser.WEAKUNTIL, i);
		}
		public WeakUntilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weakUntil; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitWeakUntil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeakUntilContext weakUntil() throws RecognitionException {
		WeakUntilContext _localctx = new WeakUntilContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_weakUntil);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			release();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WEAKUNTIL) {
				{
				{
				setState(82);
				match(WEAKUNTIL);
				setState(83);
				release();
				}
				}
				setState(88);
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

	public static class ReleaseContext extends ParserRuleContext {
		public List<UntilContext> until() {
			return getRuleContexts(UntilContext.class);
		}
		public UntilContext until(int i) {
			return getRuleContext(UntilContext.class,i);
		}
		public List<TerminalNode> RELEASE() { return getTokens(LTLfFormulaParserParser.RELEASE); }
		public TerminalNode RELEASE(int i) {
			return getToken(LTLfFormulaParserParser.RELEASE, i);
		}
		public ReleaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_release; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitRelease(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReleaseContext release() throws RecognitionException {
		ReleaseContext _localctx = new ReleaseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_release);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			until();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RELEASE) {
				{
				{
				setState(90);
				match(RELEASE);
				setState(91);
				until();
				}
				}
				setState(96);
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

	public static class UntilContext extends ParserRuleContext {
		public List<GloballyContext> globally() {
			return getRuleContexts(GloballyContext.class);
		}
		public GloballyContext globally(int i) {
			return getRuleContext(GloballyContext.class,i);
		}
		public List<TerminalNode> UNTIL() { return getTokens(LTLfFormulaParserParser.UNTIL); }
		public TerminalNode UNTIL(int i) {
			return getToken(LTLfFormulaParserParser.UNTIL, i);
		}
		public UntilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_until; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitUntil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UntilContext until() throws RecognitionException {
		UntilContext _localctx = new UntilContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_until);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			globally();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNTIL) {
				{
				{
				setState(98);
				match(UNTIL);
				setState(99);
				globally();
				}
				}
				setState(104);
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

	public static class GloballyContext extends ParserRuleContext {
		public EventuallyContext eventually() {
			return getRuleContext(EventuallyContext.class,0);
		}
		public TerminalNode GLOBALLY() { return getToken(LTLfFormulaParserParser.GLOBALLY, 0); }
		public GloballyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globally; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitGlobally(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GloballyContext globally() throws RecognitionException {
		GloballyContext _localctx = new GloballyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_globally);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if (_la==GLOBALLY) {
				{
				setState(105);
				match(GLOBALLY);
				}
			}

			setState(108);
			eventually();
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

	public static class EventuallyContext extends ParserRuleContext {
		public WeakNextContext weakNext() {
			return getRuleContext(WeakNextContext.class,0);
		}
		public TerminalNode EVENTUALLY() { return getToken(LTLfFormulaParserParser.EVENTUALLY, 0); }
		public EventuallyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventually; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitEventually(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventuallyContext eventually() throws RecognitionException {
		EventuallyContext _localctx = new EventuallyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_eventually);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_la = _input.LA(1);
			if (_la==EVENTUALLY) {
				{
				setState(110);
				match(EVENTUALLY);
				}
			}

			setState(113);
			weakNext();
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

	public static class WeakNextContext extends ParserRuleContext {
		public NextContext next() {
			return getRuleContext(NextContext.class,0);
		}
		public TerminalNode WEAKNEXT() { return getToken(LTLfFormulaParserParser.WEAKNEXT, 0); }
		public WeakNextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weakNext; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitWeakNext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeakNextContext weakNext() throws RecognitionException {
		WeakNextContext _localctx = new WeakNextContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_weakNext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if (_la==WEAKNEXT) {
				{
				setState(115);
				match(WEAKNEXT);
				}
			}

			setState(118);
			next();
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

	public static class NextContext extends ParserRuleContext {
		public NotTempContext notTemp() {
			return getRuleContext(NotTempContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(LTLfFormulaParserParser.NEXT, 0); }
		public NextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_next; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitNext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextContext next() throws RecognitionException {
		NextContext _localctx = new NextContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_next);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if (_la==NEXT) {
				{
				setState(120);
				match(NEXT);
				}
			}

			setState(123);
			notTemp();
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

	public static class NotTempContext extends ParserRuleContext {
		public LtlfAtomContext ltlfAtom() {
			return getRuleContext(LtlfAtomContext.class,0);
		}
		public TerminalNode LSEPARATOR() { return getToken(LTLfFormulaParserParser.LSEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LTLfFormulaParserParser.RSEPARATOR, 0); }
		public TerminalNode NOT() { return getToken(LTLfFormulaParserParser.NOT, 0); }
		public NotTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitNotTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotTempContext notTemp() throws RecognitionException {
		NotTempContext _localctx = new NotTempContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_notTemp);
		int _la;
		try {
			setState(133);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				ltlfAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(126);
					match(NOT);
					}
				}

				setState(129);
				match(LSEPARATOR);
				setState(130);
				expression();
				setState(131);
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

	public static class LtlfAtomContext extends ParserRuleContext {
		public TerminalNode LAST() { return getToken(LTLfFormulaParserParser.LAST, 0); }
		public PropositionalFormulaContext propositionalFormula() {
			return getRuleContext(PropositionalFormulaContext.class,0);
		}
		public LtlfAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ltlfAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitLtlfAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LtlfAtomContext ltlfAtom() throws RecognitionException {
		LtlfAtomContext _localctx = new LtlfAtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ltlfAtom);
		try {
			setState(137);
			switch (_input.LA(1)) {
			case LAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(LAST);
				}
				break;
			case EOF:
			case WEAKUNTIL:
			case UNTIL:
			case RELEASE:
			case ID:
			case TRUE:
			case FALSE:
			case DOUBLEIMPLY:
			case IMPLY:
			case OR:
			case AND:
			case NOT:
			case LSEPARATOR:
			case RSEPARATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				propositionalFormula();
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

	public static class PropositionalFormulaContext extends ParserRuleContext {
		public DoubleImplicationPropContext doubleImplicationProp() {
			return getRuleContext(DoubleImplicationPropContext.class,0);
		}
		public PropositionalFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propositionalFormula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitPropositionalFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropositionalFormulaContext propositionalFormula() throws RecognitionException {
		PropositionalFormulaContext _localctx = new PropositionalFormulaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propositionalFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			doubleImplicationProp();
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

	public static class DoubleImplicationPropContext extends ParserRuleContext {
		public List<ImplicationPropContext> implicationProp() {
			return getRuleContexts(ImplicationPropContext.class);
		}
		public ImplicationPropContext implicationProp(int i) {
			return getRuleContext(ImplicationPropContext.class,i);
		}
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(LTLfFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(LTLfFormulaParserParser.DOUBLEIMPLY, i);
		}
		public DoubleImplicationPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleImplicationProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitDoubleImplicationProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleImplicationPropContext doubleImplicationProp() throws RecognitionException {
		DoubleImplicationPropContext _localctx = new DoubleImplicationPropContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_doubleImplicationProp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			implicationProp();
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(142);
					match(DOUBLEIMPLY);
					setState(143);
					implicationProp();
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class ImplicationPropContext extends ParserRuleContext {
		public List<OrPropContext> orProp() {
			return getRuleContexts(OrPropContext.class);
		}
		public OrPropContext orProp(int i) {
			return getRuleContext(OrPropContext.class,i);
		}
		public List<TerminalNode> IMPLY() { return getTokens(LTLfFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(LTLfFormulaParserParser.IMPLY, i);
		}
		public ImplicationPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implicationProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitImplicationProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplicationPropContext implicationProp() throws RecognitionException {
		ImplicationPropContext _localctx = new ImplicationPropContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_implicationProp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			orProp();
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(150);
					match(IMPLY);
					setState(151);
					orProp();
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class OrPropContext extends ParserRuleContext {
		public List<AndPropContext> andProp() {
			return getRuleContexts(AndPropContext.class);
		}
		public AndPropContext andProp(int i) {
			return getRuleContext(AndPropContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LTLfFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LTLfFormulaParserParser.OR, i);
		}
		public OrPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitOrProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrPropContext orProp() throws RecognitionException {
		OrPropContext _localctx = new OrPropContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_orProp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			andProp();
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(158);
					match(OR);
					setState(159);
					andProp();
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class AndPropContext extends ParserRuleContext {
		public List<NotPropContext> notProp() {
			return getRuleContexts(NotPropContext.class);
		}
		public NotPropContext notProp(int i) {
			return getRuleContext(NotPropContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LTLfFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LTLfFormulaParserParser.AND, i);
		}
		public AndPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitAndProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndPropContext andProp() throws RecognitionException {
		AndPropContext _localctx = new AndPropContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_andProp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			notProp();
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(166);
					match(AND);
					setState(167);
					notProp();
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class NotPropContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode NOT() { return getToken(LTLfFormulaParserParser.NOT, 0); }
		public TerminalNode LSEPARATOR() { return getToken(LTLfFormulaParserParser.LSEPARATOR, 0); }
		public PropositionalFormulaContext propositionalFormula() {
			return getRuleContext(PropositionalFormulaContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LTLfFormulaParserParser.RSEPARATOR, 0); }
		public NotPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLfFormulaParserVisitor ) return ((LTLfFormulaParserVisitor<? extends T>)visitor).visitNotProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotPropContext notProp() throws RecognitionException {
		NotPropContext _localctx = new NotPropContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_notProp);
		int _la;
		try {
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(173);
					match(NOT);
					}
				}

				setState(176);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(177);
					match(NOT);
					}
				}

				setState(180);
				match(LSEPARATOR);
				setState(181);
				propositionalFormula();
				setState(182);
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
		enterRule(_localctx, 42, RULE_atom);
		int _la;
		try {
			setState(194);
			switch (_input.LA(1)) {
			case EOF:
			case WEAKUNTIL:
			case UNTIL:
			case RELEASE:
			case ID:
			case DOUBLEIMPLY:
			case IMPLY:
			case OR:
			case AND:
			case RSEPARATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(186);
					match(ID);
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				match(FALSE);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25\u00c7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B"+
		"\13\5\3\6\3\6\3\6\7\6G\n\6\f\6\16\6J\13\6\3\7\3\7\3\7\7\7O\n\7\f\7\16"+
		"\7R\13\7\3\b\3\b\3\b\7\bW\n\b\f\b\16\bZ\13\b\3\t\3\t\3\t\7\t_\n\t\f\t"+
		"\16\tb\13\t\3\n\3\n\3\n\7\ng\n\n\f\n\16\nj\13\n\3\13\5\13m\n\13\3\13\3"+
		"\13\3\f\5\fr\n\f\3\f\3\f\3\r\5\rw\n\r\3\r\3\r\3\16\5\16|\n\16\3\16\3\16"+
		"\3\17\3\17\5\17\u0082\n\17\3\17\3\17\3\17\3\17\5\17\u0088\n\17\3\20\3"+
		"\20\5\20\u008c\n\20\3\21\3\21\3\22\3\22\3\22\7\22\u0093\n\22\f\22\16\22"+
		"\u0096\13\22\3\23\3\23\3\23\7\23\u009b\n\23\f\23\16\23\u009e\13\23\3\24"+
		"\3\24\3\24\7\24\u00a3\n\24\f\24\16\24\u00a6\13\24\3\25\3\25\3\25\7\25"+
		"\u00ab\n\25\f\25\16\25\u00ae\13\25\3\26\5\26\u00b1\n\26\3\26\3\26\5\26"+
		"\u00b5\n\26\3\26\3\26\3\26\3\26\5\26\u00bb\n\26\3\27\7\27\u00be\n\27\f"+
		"\27\16\27\u00c1\13\27\3\27\3\27\5\27\u00c5\n\27\3\27\2\2\30\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\2\u00c8\2.\3\2\2\2\4\61\3\2\2"+
		"\2\6\63\3\2\2\2\b;\3\2\2\2\nC\3\2\2\2\fK\3\2\2\2\16S\3\2\2\2\20[\3\2\2"+
		"\2\22c\3\2\2\2\24l\3\2\2\2\26q\3\2\2\2\30v\3\2\2\2\32{\3\2\2\2\34\u0087"+
		"\3\2\2\2\36\u008b\3\2\2\2 \u008d\3\2\2\2\"\u008f\3\2\2\2$\u0097\3\2\2"+
		"\2&\u009f\3\2\2\2(\u00a7\3\2\2\2*\u00ba\3\2\2\2,\u00c4\3\2\2\2./\5\4\3"+
		"\2/\60\7\2\2\3\60\3\3\2\2\2\61\62\5\6\4\2\62\5\3\2\2\2\638\5\b\5\2\64"+
		"\65\7\16\2\2\65\67\5\b\5\2\66\64\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2"+
		"\2\29\7\3\2\2\2:8\3\2\2\2;@\5\n\6\2<=\7\17\2\2=?\5\n\6\2><\3\2\2\2?B\3"+
		"\2\2\2@>\3\2\2\2@A\3\2\2\2A\t\3\2\2\2B@\3\2\2\2CH\5\f\7\2DE\7\20\2\2E"+
		"G\5\f\7\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\13\3\2\2\2JH\3\2\2"+
		"\2KP\5\16\b\2LM\7\21\2\2MO\5\16\b\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3"+
		"\2\2\2Q\r\3\2\2\2RP\3\2\2\2SX\5\20\t\2TU\7\4\2\2UW\5\20\t\2VT\3\2\2\2"+
		"WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\17\3\2\2\2ZX\3\2\2\2[`\5\22\n\2\\]\7\6"+
		"\2\2]_\5\22\n\2^\\\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\21\3\2\2\2b"+
		"`\3\2\2\2ch\5\24\13\2de\7\5\2\2eg\5\24\13\2fd\3\2\2\2gj\3\2\2\2hf\3\2"+
		"\2\2hi\3\2\2\2i\23\3\2\2\2jh\3\2\2\2km\7\7\2\2lk\3\2\2\2lm\3\2\2\2mn\3"+
		"\2\2\2no\5\26\f\2o\25\3\2\2\2pr\7\b\2\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2"+
		"st\5\30\r\2t\27\3\2\2\2uw\7\t\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\5\32"+
		"\16\2y\31\3\2\2\2z|\7\n\2\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\5\34\17\2"+
		"~\33\3\2\2\2\177\u0088\5\36\20\2\u0080\u0082\7\22\2\2\u0081\u0080\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\23\2\2\u0084"+
		"\u0085\5\4\3\2\u0085\u0086\7\24\2\2\u0086\u0088\3\2\2\2\u0087\177\3\2"+
		"\2\2\u0087\u0081\3\2\2\2\u0088\35\3\2\2\2\u0089\u008c\7\3\2\2\u008a\u008c"+
		"\5 \21\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\37\3\2\2\2\u008d"+
		"\u008e\5\"\22\2\u008e!\3\2\2\2\u008f\u0094\5$\23\2\u0090\u0091\7\16\2"+
		"\2\u0091\u0093\5$\23\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095#\3\2\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u009c\5&\24\2\u0098\u0099\7\17\2\2\u0099\u009b\5&\24\2\u009a\u0098\3"+
		"\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"%\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a4\5(\25\2\u00a0\u00a1\7\20\2\2"+
		"\u00a1\u00a3\5(\25\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\'\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00ac\5*\26\2\u00a8\u00a9\7\21\2\2\u00a9\u00ab\5*\26\2\u00aa\u00a8\3"+
		"\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		")\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\7\22\2\2\u00b0\u00af\3\2\2\2"+
		"\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00bb\5,\27\2\u00b3\u00b5"+
		"\7\22\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2"+
		"\u00b6\u00b7\7\23\2\2\u00b7\u00b8\5 \21\2\u00b8\u00b9\7\24\2\2\u00b9\u00bb"+
		"\3\2\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00b4\3\2\2\2\u00bb+\3\2\2\2\u00bc"+
		"\u00be\7\13\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3"+
		"\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c5\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2"+
		"\u00c5\7\f\2\2\u00c3\u00c5\7\r\2\2\u00c4\u00bf\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c4\u00c3\3\2\2\2\u00c5-\3\2\2\2\318@HPX`hlqv{\u0081\u0087\u008b"+
		"\u0094\u009c\u00a4\u00ac\u00b0\u00b4\u00ba\u00bf\u00c4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
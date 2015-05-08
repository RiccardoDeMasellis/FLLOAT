// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/LDLfFormulaParser.g4 by ANTLR 4.5

	package ldlfParser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LDLfFormulaParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, TRUE=2, FALSE=3, LAST=4, EPSILON=5, TT=6, FF=7, END=8, DOUBLEIMPLY=9, 
		IMPLY=10, OR=11, AND=12, NOT=13, LSEPARATOR=14, RSEPARATOR=15, BOXLSEPARATOR=16, 
		BOXRSEPARATOR=17, DIAMONDLSEPARATOR=18, DIAMONDRSEPARATOR=19, STAR=20, 
		TEST=21, REGEXPOR=22, CONCATENATION=23, WS=24;
	public static final int
		RULE_start = 0, RULE_expression = 1, RULE_checkdoubleImplication = 2, 
		RULE_checkImplication = 3, RULE_checkOr = 4, RULE_checkAnd = 5, RULE_checkBox = 6, 
		RULE_checkDiamond = 7, RULE_checkNot = 8, RULE_ldlfAtom = 9, RULE_regularExpression = 10, 
		RULE_checkOrRegExp = 11, RULE_checkConcatenationRegExp = 12, RULE_checkStar = 13, 
		RULE_checkTest = 14, RULE_propositionalFormula = 15, RULE_checkdoubleImplicationProp = 16, 
		RULE_checkImplicationProp = 17, RULE_checkOrProp = 18, RULE_checkAndProp = 19, 
		RULE_checkNotProp = 20, RULE_atom = 21;
	public static final String[] ruleNames = {
		"start", "expression", "checkdoubleImplication", "checkImplication", "checkOr", 
		"checkAnd", "checkBox", "checkDiamond", "checkNot", "ldlfAtom", "regularExpression", 
		"checkOrRegExp", "checkConcatenationRegExp", "checkStar", "checkTest", 
		"propositionalFormula", "checkdoubleImplicationProp", "checkImplicationProp", 
		"checkOrProp", "checkAndProp", "checkNotProp", "atom"
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

	@Override
	public String getGrammarFileName() { return "LDLfFormulaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		

	public LDLfFormulaParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LDLfFormulaParserParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitStart(this);
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
		public CheckdoubleImplicationContext checkdoubleImplication() {
			return getRuleContext(CheckdoubleImplicationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitExpression(this);
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
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(LDLfFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(LDLfFormulaParserParser.DOUBLEIMPLY, i);
		}
		public CheckdoubleImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkdoubleImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckdoubleImplication(this);
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
			setState(49); 
			checkImplication();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLEIMPLY) {
				{
				{
				setState(50); 
				match(DOUBLEIMPLY);
				setState(51); 
				checkImplication();
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

	public static class CheckImplicationContext extends ParserRuleContext {
		public List<CheckOrContext> checkOr() {
			return getRuleContexts(CheckOrContext.class);
		}
		public CheckOrContext checkOr(int i) {
			return getRuleContext(CheckOrContext.class,i);
		}
		public List<TerminalNode> IMPLY() { return getTokens(LDLfFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(LDLfFormulaParserParser.IMPLY, i);
		}
		public CheckImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckImplication(this);
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
			setState(57); 
			checkOr();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPLY) {
				{
				{
				setState(58); 
				match(IMPLY);
				setState(59); 
				checkOr();
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

	public static class CheckOrContext extends ParserRuleContext {
		public List<CheckAndContext> checkAnd() {
			return getRuleContexts(CheckAndContext.class);
		}
		public CheckAndContext checkAnd(int i) {
			return getRuleContext(CheckAndContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LDLfFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LDLfFormulaParserParser.OR, i);
		}
		public CheckOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkOr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckOr(this);
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
			setState(65); 
			checkAnd();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(66); 
				match(OR);
				setState(67); 
				checkAnd();
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

	public static class CheckAndContext extends ParserRuleContext {
		public List<CheckBoxContext> checkBox() {
			return getRuleContexts(CheckBoxContext.class);
		}
		public CheckBoxContext checkBox(int i) {
			return getRuleContext(CheckBoxContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LDLfFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LDLfFormulaParserParser.AND, i);
		}
		public CheckAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkAnd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckAnd(this);
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
			setState(73); 
			checkBox();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(74); 
				match(AND);
				setState(75); 
				checkBox();
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

	public static class CheckBoxContext extends ParserRuleContext {
		public CheckDiamondContext checkDiamond() {
			return getRuleContext(CheckDiamondContext.class,0);
		}
		public TerminalNode BOXLSEPARATOR() { return getToken(LDLfFormulaParserParser.BOXLSEPARATOR, 0); }
		public RegularExpressionContext regularExpression() {
			return getRuleContext(RegularExpressionContext.class,0);
		}
		public TerminalNode BOXRSEPARATOR() { return getToken(LDLfFormulaParserParser.BOXRSEPARATOR, 0); }
		public CheckBoxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkBox; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckBox(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckBoxContext checkBox() throws RecognitionException {
		CheckBoxContext _localctx = new CheckBoxContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_checkBox);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if (_la==BOXLSEPARATOR) {
				{
				setState(81); 
				match(BOXLSEPARATOR);
				setState(82); 
				regularExpression();
				setState(83); 
				match(BOXRSEPARATOR);
				}
			}

			setState(87); 
			checkDiamond();
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

	public static class CheckDiamondContext extends ParserRuleContext {
		public CheckNotContext checkNot() {
			return getRuleContext(CheckNotContext.class,0);
		}
		public TerminalNode DIAMONDLSEPARATOR() { return getToken(LDLfFormulaParserParser.DIAMONDLSEPARATOR, 0); }
		public RegularExpressionContext regularExpression() {
			return getRuleContext(RegularExpressionContext.class,0);
		}
		public TerminalNode DIAMONDRSEPARATOR() { return getToken(LDLfFormulaParserParser.DIAMONDRSEPARATOR, 0); }
		public CheckDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkDiamond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckDiamond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckDiamondContext checkDiamond() throws RecognitionException {
		CheckDiamondContext _localctx = new CheckDiamondContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_checkDiamond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_la = _input.LA(1);
			if (_la==DIAMONDLSEPARATOR) {
				{
				setState(89); 
				match(DIAMONDLSEPARATOR);
				setState(90); 
				regularExpression();
				setState(91); 
				match(DIAMONDRSEPARATOR);
				}
			}

			setState(95); 
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
		public LdlfAtomContext ldlfAtom() {
			return getRuleContext(LdlfAtomContext.class,0);
		}
		public TerminalNode NOT() { return getToken(LDLfFormulaParserParser.NOT, 0); }
		public TerminalNode LSEPARATOR() { return getToken(LDLfFormulaParserParser.LSEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LDLfFormulaParserParser.RSEPARATOR, 0); }
		public CheckNotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkNot; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckNotContext checkNot() throws RecognitionException {
		CheckNotContext _localctx = new CheckNotContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_checkNot);
		int _la;
		try {
			setState(108);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(97); 
					match(NOT);
					}
					break;
				}
				setState(100); 
				ldlfAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(101); 
					match(NOT);
					}
				}

				setState(104); 
				match(LSEPARATOR);
				setState(105); 
				expression();
				setState(106); 
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

	public static class LdlfAtomContext extends ParserRuleContext {
		public TerminalNode TT() { return getToken(LDLfFormulaParserParser.TT, 0); }
		public TerminalNode FF() { return getToken(LDLfFormulaParserParser.FF, 0); }
		public TerminalNode LAST() { return getToken(LDLfFormulaParserParser.LAST, 0); }
		public TerminalNode END() { return getToken(LDLfFormulaParserParser.END, 0); }
		public PropositionalFormulaContext propositionalFormula() {
			return getRuleContext(PropositionalFormulaContext.class,0);
		}
		public LdlfAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ldlfAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitLdlfAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LdlfAtomContext ldlfAtom() throws RecognitionException {
		LdlfAtomContext _localctx = new LdlfAtomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ldlfAtom);
		try {
			setState(115);
			switch (_input.LA(1)) {
			case TT:
				enterOuterAlt(_localctx, 1);
				{
				setState(110); 
				match(TT);
				}
				break;
			case FF:
				enterOuterAlt(_localctx, 2);
				{
				setState(111); 
				match(FF);
				}
				break;
			case LAST:
				enterOuterAlt(_localctx, 3);
				{
				setState(112); 
				match(LAST);
				}
				break;
			case END:
				enterOuterAlt(_localctx, 4);
				{
				setState(113); 
				match(END);
				}
				break;
			case EOF:
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
			case TEST:
				enterOuterAlt(_localctx, 5);
				{
				setState(114); 
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

	public static class RegularExpressionContext extends ParserRuleContext {
		public CheckOrRegExpContext checkOrRegExp() {
			return getRuleContext(CheckOrRegExpContext.class,0);
		}
		public RegularExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitRegularExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegularExpressionContext regularExpression() throws RecognitionException {
		RegularExpressionContext _localctx = new RegularExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_regularExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); 
			checkOrRegExp();
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

	public static class CheckOrRegExpContext extends ParserRuleContext {
		public List<CheckConcatenationRegExpContext> checkConcatenationRegExp() {
			return getRuleContexts(CheckConcatenationRegExpContext.class);
		}
		public CheckConcatenationRegExpContext checkConcatenationRegExp(int i) {
			return getRuleContext(CheckConcatenationRegExpContext.class,i);
		}
		public List<TerminalNode> REGEXPOR() { return getTokens(LDLfFormulaParserParser.REGEXPOR); }
		public TerminalNode REGEXPOR(int i) {
			return getToken(LDLfFormulaParserParser.REGEXPOR, i);
		}
		public CheckOrRegExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkOrRegExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckOrRegExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckOrRegExpContext checkOrRegExp() throws RecognitionException {
		CheckOrRegExpContext _localctx = new CheckOrRegExpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_checkOrRegExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); 
			checkConcatenationRegExp();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==REGEXPOR) {
				{
				{
				setState(120); 
				match(REGEXPOR);
				setState(121); 
				checkConcatenationRegExp();
				}
				}
				setState(126);
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

	public static class CheckConcatenationRegExpContext extends ParserRuleContext {
		public List<CheckStarContext> checkStar() {
			return getRuleContexts(CheckStarContext.class);
		}
		public CheckStarContext checkStar(int i) {
			return getRuleContext(CheckStarContext.class,i);
		}
		public List<TerminalNode> CONCATENATION() { return getTokens(LDLfFormulaParserParser.CONCATENATION); }
		public TerminalNode CONCATENATION(int i) {
			return getToken(LDLfFormulaParserParser.CONCATENATION, i);
		}
		public CheckConcatenationRegExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkConcatenationRegExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckConcatenationRegExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckConcatenationRegExpContext checkConcatenationRegExp() throws RecognitionException {
		CheckConcatenationRegExpContext _localctx = new CheckConcatenationRegExpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_checkConcatenationRegExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); 
			checkStar();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION) {
				{
				{
				setState(128); 
				match(CONCATENATION);
				setState(129); 
				checkStar();
				}
				}
				setState(134);
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

	public static class CheckStarContext extends ParserRuleContext {
		public CheckTestContext checkTest() {
			return getRuleContext(CheckTestContext.class,0);
		}
		public TerminalNode STAR() { return getToken(LDLfFormulaParserParser.STAR, 0); }
		public TerminalNode LSEPARATOR() { return getToken(LDLfFormulaParserParser.LSEPARATOR, 0); }
		public RegularExpressionContext regularExpression() {
			return getRuleContext(RegularExpressionContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LDLfFormulaParserParser.RSEPARATOR, 0); }
		public CheckStarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkStar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckStar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckStarContext checkStar() throws RecognitionException {
		CheckStarContext _localctx = new CheckStarContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_checkStar);
		int _la;
		try {
			setState(145);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135); 
				checkTest();
				setState(137);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(136); 
					match(STAR);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139); 
				match(LSEPARATOR);
				setState(140); 
				regularExpression();
				setState(141); 
				match(RSEPARATOR);
				setState(143);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(142); 
					match(STAR);
					}
				}

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

	public static class CheckTestContext extends ParserRuleContext {
		public TerminalNode LSEPARATOR() { return getToken(LDLfFormulaParserParser.LSEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LDLfFormulaParserParser.RSEPARATOR, 0); }
		public TerminalNode TEST() { return getToken(LDLfFormulaParserParser.TEST, 0); }
		public LdlfAtomContext ldlfAtom() {
			return getRuleContext(LdlfAtomContext.class,0);
		}
		public PropositionalFormulaContext propositionalFormula() {
			return getRuleContext(PropositionalFormulaContext.class,0);
		}
		public TerminalNode EPSILON() { return getToken(LDLfFormulaParserParser.EPSILON, 0); }
		public CheckTestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkTest; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckTestContext checkTest() throws RecognitionException {
		CheckTestContext _localctx = new CheckTestContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_checkTest);
		try {
			setState(157);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147); 
				match(LSEPARATOR);
				setState(148); 
				expression();
				setState(149); 
				match(RSEPARATOR);
				setState(150); 
				match(TEST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152); 
				ldlfAtom();
				setState(153); 
				match(TEST);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(155); 
				propositionalFormula();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(156); 
				match(EPSILON);
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

	public static class PropositionalFormulaContext extends ParserRuleContext {
		public CheckdoubleImplicationPropContext checkdoubleImplicationProp() {
			return getRuleContext(CheckdoubleImplicationPropContext.class,0);
		}
		public PropositionalFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propositionalFormula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitPropositionalFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropositionalFormulaContext propositionalFormula() throws RecognitionException {
		PropositionalFormulaContext _localctx = new PropositionalFormulaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propositionalFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); 
			checkdoubleImplicationProp();
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

	public static class CheckdoubleImplicationPropContext extends ParserRuleContext {
		public List<CheckImplicationPropContext> checkImplicationProp() {
			return getRuleContexts(CheckImplicationPropContext.class);
		}
		public CheckImplicationPropContext checkImplicationProp(int i) {
			return getRuleContext(CheckImplicationPropContext.class,i);
		}
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(LDLfFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(LDLfFormulaParserParser.DOUBLEIMPLY, i);
		}
		public CheckdoubleImplicationPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkdoubleImplicationProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckdoubleImplicationProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckdoubleImplicationPropContext checkdoubleImplicationProp() throws RecognitionException {
		CheckdoubleImplicationPropContext _localctx = new CheckdoubleImplicationPropContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_checkdoubleImplicationProp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161); 
			checkImplicationProp();
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(162); 
					match(DOUBLEIMPLY);
					setState(163); 
					checkImplicationProp();
					}
					} 
				}
				setState(168);
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

	public static class CheckImplicationPropContext extends ParserRuleContext {
		public List<CheckOrPropContext> checkOrProp() {
			return getRuleContexts(CheckOrPropContext.class);
		}
		public CheckOrPropContext checkOrProp(int i) {
			return getRuleContext(CheckOrPropContext.class,i);
		}
		public List<TerminalNode> IMPLY() { return getTokens(LDLfFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(LDLfFormulaParserParser.IMPLY, i);
		}
		public CheckImplicationPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkImplicationProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckImplicationProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckImplicationPropContext checkImplicationProp() throws RecognitionException {
		CheckImplicationPropContext _localctx = new CheckImplicationPropContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_checkImplicationProp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(169); 
			checkOrProp();
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(170); 
					match(IMPLY);
					setState(171); 
					checkOrProp();
					}
					} 
				}
				setState(176);
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

	public static class CheckOrPropContext extends ParserRuleContext {
		public List<CheckAndPropContext> checkAndProp() {
			return getRuleContexts(CheckAndPropContext.class);
		}
		public CheckAndPropContext checkAndProp(int i) {
			return getRuleContext(CheckAndPropContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LDLfFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LDLfFormulaParserParser.OR, i);
		}
		public CheckOrPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkOrProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckOrProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckOrPropContext checkOrProp() throws RecognitionException {
		CheckOrPropContext _localctx = new CheckOrPropContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_checkOrProp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177); 
			checkAndProp();
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(178); 
					match(OR);
					setState(179); 
					checkAndProp();
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class CheckAndPropContext extends ParserRuleContext {
		public List<CheckNotPropContext> checkNotProp() {
			return getRuleContexts(CheckNotPropContext.class);
		}
		public CheckNotPropContext checkNotProp(int i) {
			return getRuleContext(CheckNotPropContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LDLfFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LDLfFormulaParserParser.AND, i);
		}
		public CheckAndPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkAndProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckAndProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckAndPropContext checkAndProp() throws RecognitionException {
		CheckAndPropContext _localctx = new CheckAndPropContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_checkAndProp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185); 
			checkNotProp();
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(186); 
					match(AND);
					setState(187); 
					checkNotProp();
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class CheckNotPropContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode NOT() { return getToken(LDLfFormulaParserParser.NOT, 0); }
		public TerminalNode LSEPARATOR() { return getToken(LDLfFormulaParserParser.LSEPARATOR, 0); }
		public PropositionalFormulaContext propositionalFormula() {
			return getRuleContext(PropositionalFormulaContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LDLfFormulaParserParser.RSEPARATOR, 0); }
		public CheckNotPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkNotProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitCheckNotProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckNotPropContext checkNotProp() throws RecognitionException {
		CheckNotPropContext _localctx = new CheckNotPropContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_checkNotProp);
		int _la;
		try {
			setState(204);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(193); 
					match(NOT);
					}
				}

				setState(196); 
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(197); 
					match(NOT);
					}
				}

				setState(200); 
				match(LSEPARATOR);
				setState(201); 
				propositionalFormula();
				setState(202); 
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
		public List<TerminalNode> ID() { return getTokens(LDLfFormulaParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LDLfFormulaParserParser.ID, i);
		}
		public TerminalNode TRUE() { return getToken(LDLfFormulaParserParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LDLfFormulaParserParser.FALSE, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_atom);
		int _la;
		try {
			setState(214);
			switch (_input.LA(1)) {
			case EOF:
			case ID:
			case DOUBLEIMPLY:
			case IMPLY:
			case OR:
			case AND:
			case RSEPARATOR:
			case BOXRSEPARATOR:
			case DIAMONDRSEPARATOR:
			case STAR:
			case TEST:
			case REGEXPOR:
			case CONCATENATION:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(206); 
					match(ID);
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(212); 
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(213); 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u00db\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B"+
		"\13\5\3\6\3\6\3\6\7\6G\n\6\f\6\16\6J\13\6\3\7\3\7\3\7\7\7O\n\7\f\7\16"+
		"\7R\13\7\3\b\3\b\3\b\3\b\5\bX\n\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t`\n\t\3\t"+
		"\3\t\3\n\5\ne\n\n\3\n\3\n\5\ni\n\n\3\n\3\n\3\n\3\n\5\no\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\5\13v\n\13\3\f\3\f\3\r\3\r\3\r\7\r}\n\r\f\r\16\r\u0080"+
		"\13\r\3\16\3\16\3\16\7\16\u0085\n\16\f\16\16\16\u0088\13\16\3\17\3\17"+
		"\5\17\u008c\n\17\3\17\3\17\3\17\3\17\5\17\u0092\n\17\5\17\u0094\n\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a0\n\20\3\21"+
		"\3\21\3\22\3\22\3\22\7\22\u00a7\n\22\f\22\16\22\u00aa\13\22\3\23\3\23"+
		"\3\23\7\23\u00af\n\23\f\23\16\23\u00b2\13\23\3\24\3\24\3\24\7\24\u00b7"+
		"\n\24\f\24\16\24\u00ba\13\24\3\25\3\25\3\25\7\25\u00bf\n\25\f\25\16\25"+
		"\u00c2\13\25\3\26\5\26\u00c5\n\26\3\26\3\26\5\26\u00c9\n\26\3\26\3\26"+
		"\3\26\3\26\5\26\u00cf\n\26\3\27\7\27\u00d2\n\27\f\27\16\27\u00d5\13\27"+
		"\3\27\3\27\5\27\u00d9\n\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,\2\2\u00e3\2.\3\2\2\2\4\61\3\2\2\2\6\63\3\2\2\2\b;\3\2\2"+
		"\2\nC\3\2\2\2\fK\3\2\2\2\16W\3\2\2\2\20_\3\2\2\2\22n\3\2\2\2\24u\3\2\2"+
		"\2\26w\3\2\2\2\30y\3\2\2\2\32\u0081\3\2\2\2\34\u0093\3\2\2\2\36\u009f"+
		"\3\2\2\2 \u00a1\3\2\2\2\"\u00a3\3\2\2\2$\u00ab\3\2\2\2&\u00b3\3\2\2\2"+
		"(\u00bb\3\2\2\2*\u00ce\3\2\2\2,\u00d8\3\2\2\2./\5\4\3\2/\60\7\2\2\3\60"+
		"\3\3\2\2\2\61\62\5\6\4\2\62\5\3\2\2\2\638\5\b\5\2\64\65\7\13\2\2\65\67"+
		"\5\b\5\2\66\64\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\7\3\2\2\2:8"+
		"\3\2\2\2;@\5\n\6\2<=\7\f\2\2=?\5\n\6\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@"+
		"A\3\2\2\2A\t\3\2\2\2B@\3\2\2\2CH\5\f\7\2DE\7\r\2\2EG\5\f\7\2FD\3\2\2\2"+
		"GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\13\3\2\2\2JH\3\2\2\2KP\5\16\b\2LM\7\16"+
		"\2\2MO\5\16\b\2NL\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\r\3\2\2\2RP\3"+
		"\2\2\2ST\7\22\2\2TU\5\26\f\2UV\7\23\2\2VX\3\2\2\2WS\3\2\2\2WX\3\2\2\2"+
		"XY\3\2\2\2YZ\5\20\t\2Z\17\3\2\2\2[\\\7\24\2\2\\]\5\26\f\2]^\7\25\2\2^"+
		"`\3\2\2\2_[\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\5\22\n\2b\21\3\2\2\2ce\7\17"+
		"\2\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fo\5\24\13\2gi\7\17\2\2hg\3\2\2\2hi"+
		"\3\2\2\2ij\3\2\2\2jk\7\20\2\2kl\5\4\3\2lm\7\21\2\2mo\3\2\2\2nd\3\2\2\2"+
		"nh\3\2\2\2o\23\3\2\2\2pv\7\b\2\2qv\7\t\2\2rv\7\6\2\2sv\7\n\2\2tv\5 \21"+
		"\2up\3\2\2\2uq\3\2\2\2ur\3\2\2\2us\3\2\2\2ut\3\2\2\2v\25\3\2\2\2wx\5\30"+
		"\r\2x\27\3\2\2\2y~\5\32\16\2z{\7\30\2\2{}\5\32\16\2|z\3\2\2\2}\u0080\3"+
		"\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\31\3\2\2\2\u0080~\3\2\2\2\u0081\u0086"+
		"\5\34\17\2\u0082\u0083\7\31\2\2\u0083\u0085\5\34\17\2\u0084\u0082\3\2"+
		"\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\33\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\5\36\20\2\u008a\u008c\7\26"+
		"\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0094\3\2\2\2\u008d"+
		"\u008e\7\20\2\2\u008e\u008f\5\26\f\2\u008f\u0091\7\21\2\2\u0090\u0092"+
		"\7\26\2\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2"+
		"\u0093\u0089\3\2\2\2\u0093\u008d\3\2\2\2\u0094\35\3\2\2\2\u0095\u0096"+
		"\7\20\2\2\u0096\u0097\5\4\3\2\u0097\u0098\7\21\2\2\u0098\u0099\7\27\2"+
		"\2\u0099\u00a0\3\2\2\2\u009a\u009b\5\24\13\2\u009b\u009c\7\27\2\2\u009c"+
		"\u00a0\3\2\2\2\u009d\u00a0\5 \21\2\u009e\u00a0\7\7\2\2\u009f\u0095\3\2"+
		"\2\2\u009f\u009a\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\37\3\2\2\2\u00a1\u00a2\5\"\22\2\u00a2!\3\2\2\2\u00a3\u00a8\5$\23\2\u00a4"+
		"\u00a5\7\13\2\2\u00a5\u00a7\5$\23\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3"+
		"\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9#\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00b0\5&\24\2\u00ac\u00ad\7\f\2\2\u00ad\u00af\5&\24\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1%\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b8\5(\25\2\u00b4\u00b5"+
		"\7\r\2\2\u00b5\u00b7\5(\25\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\'\3\2\2\2\u00ba\u00b8\3\2\2\2"+
		"\u00bb\u00c0\5*\26\2\u00bc\u00bd\7\16\2\2\u00bd\u00bf\5*\26\2\u00be\u00bc"+
		"\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		")\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c5\7\17\2\2\u00c4\u00c3\3\2\2\2"+
		"\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00cf\5,\27\2\u00c7\u00c9"+
		"\7\17\2\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2"+
		"\u00ca\u00cb\7\20\2\2\u00cb\u00cc\5 \21\2\u00cc\u00cd\7\21\2\2\u00cd\u00cf"+
		"\3\2\2\2\u00ce\u00c4\3\2\2\2\u00ce\u00c8\3\2\2\2\u00cf+\3\2\2\2\u00d0"+
		"\u00d2\7\3\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d9\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d9\7\4\2\2\u00d7\u00d9\7\5\2\2\u00d8\u00d3\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d8\u00d7\3\2\2\2\u00d9-\3\2\2\2\338@HPW_dhnu~\u0086\u008b\u0091"+
		"\u0093\u009f\u00a8\u00b0\u00b8\u00c0\u00c4\u00c8\u00ce\u00d3\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
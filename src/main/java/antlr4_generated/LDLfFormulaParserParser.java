// Generated from LDLfFormulaParser.g4 by ANTLR 4.5

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
public class LDLfFormulaParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LAST=1, EPSILON=2, TT=3, FF=4, END=5, BOXLSEPARATOR=6, BOXRSEPARATOR=7, 
		DIAMONDLSEPARATOR=8, DIAMONDRSEPARATOR=9, STAR=10, TEST=11, ALTERNATION=12, 
		CONCATENATION=13, ID=14, TRUE=15, FALSE=16, DOUBLEIMPLY=17, IMPLY=18, 
		OR=19, AND=20, NOT=21, LSEPARATOR=22, RSEPARATOR=23, WS=24;
	public static final int
		RULE_start = 0, RULE_expression = 1, RULE_doubleImplicationTemp = 2, RULE_implicationTemp = 3, 
		RULE_orTemp = 4, RULE_andTemp = 5, RULE_ldlfBox = 6, RULE_ldlfDiamond = 7, 
		RULE_notTemp = 8, RULE_ldlfAtom = 9, RULE_regularExpression = 10, RULE_alternation = 11, 
		RULE_concatenation = 12, RULE_star = 13, RULE_test = 14, RULE_propositionalFormula = 15, 
		RULE_doubleImplicationProp = 16, RULE_implicationProp = 17, RULE_orProp = 18, 
		RULE_andProp = 19, RULE_notProp = 20, RULE_atom = 21;
	public static final String[] ruleNames = {
		"start", "expression", "doubleImplicationTemp", "implicationTemp", "orTemp", 
		"andTemp", "ldlfBox", "ldlfDiamond", "notTemp", "ldlfAtom", "regularExpression", 
		"alternation", "concatenation", "star", "test", "propositionalFormula", 
		"doubleImplicationProp", "implicationProp", "orProp", "andProp", "notProp", 
		"atom"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LAST", "EPSILON", "TT", "FF", "END", "BOXLSEPARATOR", "BOXRSEPARATOR", 
		"DIAMONDLSEPARATOR", "DIAMONDRSEPARATOR", "STAR", "TEST", "ALTERNATION", 
		"CONCATENATION", "ID", "TRUE", "FALSE", "DOUBLEIMPLY", "IMPLY", "OR", 
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
		public DoubleImplicationTempContext doubleImplicationTemp() {
			return getRuleContext(DoubleImplicationTempContext.class,0);
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
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(LDLfFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(LDLfFormulaParserParser.DOUBLEIMPLY, i);
		}
		public DoubleImplicationTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleImplicationTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitDoubleImplicationTemp(this);
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
		public List<TerminalNode> IMPLY() { return getTokens(LDLfFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(LDLfFormulaParserParser.IMPLY, i);
		}
		public ImplicationTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implicationTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitImplicationTemp(this);
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
		public List<TerminalNode> OR() { return getTokens(LDLfFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LDLfFormulaParserParser.OR, i);
		}
		public OrTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitOrTemp(this);
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
		public List<LdlfBoxContext> ldlfBox() {
			return getRuleContexts(LdlfBoxContext.class);
		}
		public LdlfBoxContext ldlfBox(int i) {
			return getRuleContext(LdlfBoxContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LDLfFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LDLfFormulaParserParser.AND, i);
		}
		public AndTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitAndTemp(this);
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
			ldlfBox();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(74);
				match(AND);
				setState(75);
				ldlfBox();
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

	public static class LdlfBoxContext extends ParserRuleContext {
		public LdlfDiamondContext ldlfDiamond() {
			return getRuleContext(LdlfDiamondContext.class,0);
		}
		public TerminalNode BOXLSEPARATOR() { return getToken(LDLfFormulaParserParser.BOXLSEPARATOR, 0); }
		public RegularExpressionContext regularExpression() {
			return getRuleContext(RegularExpressionContext.class,0);
		}
		public TerminalNode BOXRSEPARATOR() { return getToken(LDLfFormulaParserParser.BOXRSEPARATOR, 0); }
		public LdlfBoxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ldlfBox; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitLdlfBox(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LdlfBoxContext ldlfBox() throws RecognitionException {
		LdlfBoxContext _localctx = new LdlfBoxContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ldlfBox);
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
			ldlfDiamond();
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

	public static class LdlfDiamondContext extends ParserRuleContext {
		public NotTempContext notTemp() {
			return getRuleContext(NotTempContext.class,0);
		}
		public TerminalNode DIAMONDLSEPARATOR() { return getToken(LDLfFormulaParserParser.DIAMONDLSEPARATOR, 0); }
		public RegularExpressionContext regularExpression() {
			return getRuleContext(RegularExpressionContext.class,0);
		}
		public TerminalNode DIAMONDRSEPARATOR() { return getToken(LDLfFormulaParserParser.DIAMONDRSEPARATOR, 0); }
		public LdlfDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ldlfDiamond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitLdlfDiamond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LdlfDiamondContext ldlfDiamond() throws RecognitionException {
		LdlfDiamondContext _localctx = new LdlfDiamondContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ldlfDiamond);
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
		public LdlfAtomContext ldlfAtom() {
			return getRuleContext(LdlfAtomContext.class,0);
		}
		public TerminalNode LSEPARATOR() { return getToken(LDLfFormulaParserParser.LSEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LDLfFormulaParserParser.RSEPARATOR, 0); }
		public TerminalNode NOT() { return getToken(LDLfFormulaParserParser.NOT, 0); }
		public NotTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitNotTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotTempContext notTemp() throws RecognitionException {
		NotTempContext _localctx = new NotTempContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_notTemp);
		int _la;
		try {
			setState(105);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				ldlfAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(98);
					match(NOT);
					}
				}

				setState(101);
				match(LSEPARATOR);
				setState(102);
				expression();
				setState(103);
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
			setState(112);
			switch (_input.LA(1)) {
			case TT:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(TT);
				}
				break;
			case FF:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(FF);
				}
				break;
			case LAST:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(LAST);
				}
				break;
			case END:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
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
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
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
		public AlternationContext alternation() {
			return getRuleContext(AlternationContext.class,0);
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
			setState(114);
			alternation();
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

	public static class AlternationContext extends ParserRuleContext {
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public List<TerminalNode> ALTERNATION() { return getTokens(LDLfFormulaParserParser.ALTERNATION); }
		public TerminalNode ALTERNATION(int i) {
			return getToken(LDLfFormulaParserParser.ALTERNATION, i);
		}
		public AlternationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitAlternation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlternationContext alternation() throws RecognitionException {
		AlternationContext _localctx = new AlternationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_alternation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			concatenation();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ALTERNATION) {
				{
				{
				setState(117);
				match(ALTERNATION);
				setState(118);
				concatenation();
				}
				}
				setState(123);
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

	public static class ConcatenationContext extends ParserRuleContext {
		public List<StarContext> star() {
			return getRuleContexts(StarContext.class);
		}
		public StarContext star(int i) {
			return getRuleContext(StarContext.class,i);
		}
		public List<TerminalNode> CONCATENATION() { return getTokens(LDLfFormulaParserParser.CONCATENATION); }
		public TerminalNode CONCATENATION(int i) {
			return getToken(LDLfFormulaParserParser.CONCATENATION, i);
		}
		public ConcatenationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitConcatenation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatenationContext concatenation() throws RecognitionException {
		ConcatenationContext _localctx = new ConcatenationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_concatenation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			star();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION) {
				{
				{
				setState(125);
				match(CONCATENATION);
				setState(126);
				star();
				}
				}
				setState(131);
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

	public static class StarContext extends ParserRuleContext {
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode STAR() { return getToken(LDLfFormulaParserParser.STAR, 0); }
		public TerminalNode LSEPARATOR() { return getToken(LDLfFormulaParserParser.LSEPARATOR, 0); }
		public RegularExpressionContext regularExpression() {
			return getRuleContext(RegularExpressionContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LDLfFormulaParserParser.RSEPARATOR, 0); }
		public StarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitStar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StarContext star() throws RecognitionException {
		StarContext _localctx = new StarContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_star);
		int _la;
		try {
			setState(142);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				test();
				setState(134);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(133);
					match(STAR);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(LSEPARATOR);
				setState(137);
				regularExpression();
				setState(138);
				match(RSEPARATOR);
				setState(140);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(139);
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

	public static class TestContext extends ParserRuleContext {
		public TerminalNode LSEPARATOR() { return getToken(LDLfFormulaParserParser.LSEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LDLfFormulaParserParser.RSEPARATOR, 0); }
		public TerminalNode TEST() { return getToken(LDLfFormulaParserParser.TEST, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PropositionalFormulaContext propositionalFormula() {
			return getRuleContext(PropositionalFormulaContext.class,0);
		}
		public TerminalNode EPSILON() { return getToken(LDLfFormulaParserParser.EPSILON, 0); }
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_test);
		try {
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(LSEPARATOR);
				setState(145);
				expression();
				setState(146);
				match(RSEPARATOR);
				setState(147);
				match(TEST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				atom();
				setState(150);
				match(TEST);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				propositionalFormula();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
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
		public DoubleImplicationPropContext doubleImplicationProp() {
			return getRuleContext(DoubleImplicationPropContext.class,0);
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
			setState(156);
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
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(LDLfFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(LDLfFormulaParserParser.DOUBLEIMPLY, i);
		}
		public DoubleImplicationPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleImplicationProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitDoubleImplicationProp(this);
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
			setState(158);
			implicationProp();
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(159);
					match(DOUBLEIMPLY);
					setState(160);
					implicationProp();
					}
					} 
				}
				setState(165);
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

	public static class ImplicationPropContext extends ParserRuleContext {
		public List<OrPropContext> orProp() {
			return getRuleContexts(OrPropContext.class);
		}
		public OrPropContext orProp(int i) {
			return getRuleContext(OrPropContext.class,i);
		}
		public List<TerminalNode> IMPLY() { return getTokens(LDLfFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(LDLfFormulaParserParser.IMPLY, i);
		}
		public ImplicationPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implicationProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitImplicationProp(this);
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
			setState(166);
			orProp();
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(167);
					match(IMPLY);
					setState(168);
					orProp();
					}
					} 
				}
				setState(173);
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

	public static class OrPropContext extends ParserRuleContext {
		public List<AndPropContext> andProp() {
			return getRuleContexts(AndPropContext.class);
		}
		public AndPropContext andProp(int i) {
			return getRuleContext(AndPropContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LDLfFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LDLfFormulaParserParser.OR, i);
		}
		public OrPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitOrProp(this);
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
			setState(174);
			andProp();
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(175);
					match(OR);
					setState(176);
					andProp();
					}
					} 
				}
				setState(181);
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

	public static class AndPropContext extends ParserRuleContext {
		public List<NotPropContext> notProp() {
			return getRuleContexts(NotPropContext.class);
		}
		public NotPropContext notProp(int i) {
			return getRuleContext(NotPropContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(LDLfFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(LDLfFormulaParserParser.AND, i);
		}
		public AndPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitAndProp(this);
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
			setState(182);
			notProp();
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(183);
					match(AND);
					setState(184);
					notProp();
					}
					} 
				}
				setState(189);
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

	public static class NotPropContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode NOT() { return getToken(LDLfFormulaParserParser.NOT, 0); }
		public TerminalNode LSEPARATOR() { return getToken(LDLfFormulaParserParser.LSEPARATOR, 0); }
		public PropositionalFormulaContext propositionalFormula() {
			return getRuleContext(PropositionalFormulaContext.class,0);
		}
		public TerminalNode RSEPARATOR() { return getToken(LDLfFormulaParserParser.RSEPARATOR, 0); }
		public NotPropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notProp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LDLfFormulaParserVisitor ) return ((LDLfFormulaParserVisitor<? extends T>)visitor).visitNotProp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotPropContext notProp() throws RecognitionException {
		NotPropContext _localctx = new NotPropContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_notProp);
		int _la;
		try {
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(190);
					match(NOT);
					}
				}

				setState(193);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(194);
					match(NOT);
					}
				}

				setState(197);
				match(LSEPARATOR);
				setState(198);
				propositionalFormula();
				setState(199);
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
			setState(211);
			switch (_input.LA(1)) {
			case EOF:
			case BOXRSEPARATOR:
			case DIAMONDRSEPARATOR:
			case STAR:
			case TEST:
			case ALTERNATION:
			case CONCATENATION:
			case ID:
			case DOUBLEIMPLY:
			case IMPLY:
			case OR:
			case AND:
			case RSEPARATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(203);
					match(ID);
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u00d8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B"+
		"\13\5\3\6\3\6\3\6\7\6G\n\6\f\6\16\6J\13\6\3\7\3\7\3\7\7\7O\n\7\f\7\16"+
		"\7R\13\7\3\b\3\b\3\b\3\b\5\bX\n\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t`\n\t\3\t"+
		"\3\t\3\n\3\n\5\nf\n\n\3\n\3\n\3\n\3\n\5\nl\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\5\13s\n\13\3\f\3\f\3\r\3\r\3\r\7\rz\n\r\f\r\16\r}\13\r\3\16\3\16\3\16"+
		"\7\16\u0082\n\16\f\16\16\16\u0085\13\16\3\17\3\17\5\17\u0089\n\17\3\17"+
		"\3\17\3\17\3\17\5\17\u008f\n\17\5\17\u0091\n\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\5\20\u009d\n\20\3\21\3\21\3\22\3\22\3\22"+
		"\7\22\u00a4\n\22\f\22\16\22\u00a7\13\22\3\23\3\23\3\23\7\23\u00ac\n\23"+
		"\f\23\16\23\u00af\13\23\3\24\3\24\3\24\7\24\u00b4\n\24\f\24\16\24\u00b7"+
		"\13\24\3\25\3\25\3\25\7\25\u00bc\n\25\f\25\16\25\u00bf\13\25\3\26\5\26"+
		"\u00c2\n\26\3\26\3\26\5\26\u00c6\n\26\3\26\3\26\3\26\3\26\5\26\u00cc\n"+
		"\26\3\27\7\27\u00cf\n\27\f\27\16\27\u00d2\13\27\3\27\3\27\5\27\u00d6\n"+
		"\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\2\u00df"+
		"\2.\3\2\2\2\4\61\3\2\2\2\6\63\3\2\2\2\b;\3\2\2\2\nC\3\2\2\2\fK\3\2\2\2"+
		"\16W\3\2\2\2\20_\3\2\2\2\22k\3\2\2\2\24r\3\2\2\2\26t\3\2\2\2\30v\3\2\2"+
		"\2\32~\3\2\2\2\34\u0090\3\2\2\2\36\u009c\3\2\2\2 \u009e\3\2\2\2\"\u00a0"+
		"\3\2\2\2$\u00a8\3\2\2\2&\u00b0\3\2\2\2(\u00b8\3\2\2\2*\u00cb\3\2\2\2,"+
		"\u00d5\3\2\2\2./\5\4\3\2/\60\7\2\2\3\60\3\3\2\2\2\61\62\5\6\4\2\62\5\3"+
		"\2\2\2\638\5\b\5\2\64\65\7\23\2\2\65\67\5\b\5\2\66\64\3\2\2\2\67:\3\2"+
		"\2\28\66\3\2\2\289\3\2\2\29\7\3\2\2\2:8\3\2\2\2;@\5\n\6\2<=\7\24\2\2="+
		"?\5\n\6\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\t\3\2\2\2B@\3\2\2\2"+
		"CH\5\f\7\2DE\7\25\2\2EG\5\f\7\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2"+
		"\2I\13\3\2\2\2JH\3\2\2\2KP\5\16\b\2LM\7\26\2\2MO\5\16\b\2NL\3\2\2\2OR"+
		"\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\r\3\2\2\2RP\3\2\2\2ST\7\b\2\2TU\5\26\f\2"+
		"UV\7\t\2\2VX\3\2\2\2WS\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\5\20\t\2Z\17\3\2"+
		"\2\2[\\\7\n\2\2\\]\5\26\f\2]^\7\13\2\2^`\3\2\2\2_[\3\2\2\2_`\3\2\2\2`"+
		"a\3\2\2\2ab\5\22\n\2b\21\3\2\2\2cl\5\24\13\2df\7\27\2\2ed\3\2\2\2ef\3"+
		"\2\2\2fg\3\2\2\2gh\7\30\2\2hi\5\4\3\2ij\7\31\2\2jl\3\2\2\2kc\3\2\2\2k"+
		"e\3\2\2\2l\23\3\2\2\2ms\7\5\2\2ns\7\6\2\2os\7\3\2\2ps\7\7\2\2qs\5 \21"+
		"\2rm\3\2\2\2rn\3\2\2\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2s\25\3\2\2\2tu\5\30"+
		"\r\2u\27\3\2\2\2v{\5\32\16\2wx\7\16\2\2xz\5\32\16\2yw\3\2\2\2z}\3\2\2"+
		"\2{y\3\2\2\2{|\3\2\2\2|\31\3\2\2\2}{\3\2\2\2~\u0083\5\34\17\2\177\u0080"+
		"\7\17\2\2\u0080\u0082\5\34\17\2\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\33\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\u0088\5\36\20\2\u0087\u0089\7\f\2\2\u0088\u0087\3\2\2\2"+
		"\u0088\u0089\3\2\2\2\u0089\u0091\3\2\2\2\u008a\u008b\7\30\2\2\u008b\u008c"+
		"\5\26\f\2\u008c\u008e\7\31\2\2\u008d\u008f\7\f\2\2\u008e\u008d\3\2\2\2"+
		"\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0086\3\2\2\2\u0090\u008a"+
		"\3\2\2\2\u0091\35\3\2\2\2\u0092\u0093\7\30\2\2\u0093\u0094\5\4\3\2\u0094"+
		"\u0095\7\31\2\2\u0095\u0096\7\r\2\2\u0096\u009d\3\2\2\2\u0097\u0098\5"+
		",\27\2\u0098\u0099\7\r\2\2\u0099\u009d\3\2\2\2\u009a\u009d\5 \21\2\u009b"+
		"\u009d\7\4\2\2\u009c\u0092\3\2\2\2\u009c\u0097\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009b\3\2\2\2\u009d\37\3\2\2\2\u009e\u009f\5\"\22\2\u009f!"+
		"\3\2\2\2\u00a0\u00a5\5$\23\2\u00a1\u00a2\7\23\2\2\u00a2\u00a4\5$\23\2"+
		"\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6#\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00ad\5&\24\2\u00a9"+
		"\u00aa\7\24\2\2\u00aa\u00ac\5&\24\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3"+
		"\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae%\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00b0\u00b5\5(\25\2\u00b1\u00b2\7\25\2\2\u00b2\u00b4\5(\25\2"+
		"\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\'\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00bd\5*\26\2\u00b9"+
		"\u00ba\7\26\2\2\u00ba\u00bc\5*\26\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3"+
		"\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be)\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00c0\u00c2\7\27\2\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2"+
		"\u00c2\u00c3\3\2\2\2\u00c3\u00cc\5,\27\2\u00c4\u00c6\7\27\2\2\u00c5\u00c4"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\7\30\2\2"+
		"\u00c8\u00c9\5 \21\2\u00c9\u00ca\7\31\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c1"+
		"\3\2\2\2\u00cb\u00c5\3\2\2\2\u00cc+\3\2\2\2\u00cd\u00cf\7\20\2\2\u00ce"+
		"\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\u00d6\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\7\21\2\2\u00d4"+
		"\u00d6\7\22\2\2\u00d5\u00d0\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3"+
		"\2\2\2\u00d6-\3\2\2\2\328@HPW_ekr{\u0083\u0088\u008e\u0090\u009c\u00a5"+
		"\u00ad\u00b5\u00bd\u00c1\u00c5\u00cb\u00d0\u00d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
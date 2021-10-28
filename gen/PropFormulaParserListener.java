// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT/src/main/antlr4-grammars/PropFormulaParser.g4 by ANTLR 4.9.1

	package antlr4_generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PropFormulaParserParser}.
 */
public interface PropFormulaParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PropFormulaParserParser#propositionalFormula}.
	 * @param ctx the parse tree
	 */
	void enterPropositionalFormula(PropFormulaParserParser.PropositionalFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropFormulaParserParser#propositionalFormula}.
	 * @param ctx the parse tree
	 */
	void exitPropositionalFormula(PropFormulaParserParser.PropositionalFormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropFormulaParserParser#doubleImplicationProp}.
	 * @param ctx the parse tree
	 */
	void enterDoubleImplicationProp(PropFormulaParserParser.DoubleImplicationPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropFormulaParserParser#doubleImplicationProp}.
	 * @param ctx the parse tree
	 */
	void exitDoubleImplicationProp(PropFormulaParserParser.DoubleImplicationPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropFormulaParserParser#implicationProp}.
	 * @param ctx the parse tree
	 */
	void enterImplicationProp(PropFormulaParserParser.ImplicationPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropFormulaParserParser#implicationProp}.
	 * @param ctx the parse tree
	 */
	void exitImplicationProp(PropFormulaParserParser.ImplicationPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropFormulaParserParser#orProp}.
	 * @param ctx the parse tree
	 */
	void enterOrProp(PropFormulaParserParser.OrPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropFormulaParserParser#orProp}.
	 * @param ctx the parse tree
	 */
	void exitOrProp(PropFormulaParserParser.OrPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropFormulaParserParser#andProp}.
	 * @param ctx the parse tree
	 */
	void enterAndProp(PropFormulaParserParser.AndPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropFormulaParserParser#andProp}.
	 * @param ctx the parse tree
	 */
	void exitAndProp(PropFormulaParserParser.AndPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropFormulaParserParser#notProp}.
	 * @param ctx the parse tree
	 */
	void enterNotProp(PropFormulaParserParser.NotPropContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropFormulaParserParser#notProp}.
	 * @param ctx the parse tree
	 */
	void exitNotProp(PropFormulaParserParser.NotPropContext ctx);
	/**
	 * Enter a parse tree produced by {@link PropFormulaParserParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(PropFormulaParserParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PropFormulaParserParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(PropFormulaParserParser.AtomContext ctx);
}
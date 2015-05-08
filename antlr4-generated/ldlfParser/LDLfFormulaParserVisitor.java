// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/LDLfFormulaParser.g4 by ANTLR 4.5

	package ldlfParser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LDLfFormulaParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LDLfFormulaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull LDLfFormulaParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull LDLfFormulaParserParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkdoubleImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckdoubleImplication(@NotNull LDLfFormulaParserParser.CheckdoubleImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckImplication(@NotNull LDLfFormulaParserParser.CheckImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckOr(@NotNull LDLfFormulaParserParser.CheckOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckAnd(@NotNull LDLfFormulaParserParser.CheckAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkBox}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckBox(@NotNull LDLfFormulaParserParser.CheckBoxContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckDiamond(@NotNull LDLfFormulaParserParser.CheckDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkNot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckNot(@NotNull LDLfFormulaParserParser.CheckNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#ldlfAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdlfAtom(@NotNull LDLfFormulaParserParser.LdlfAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#regularExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularExpression(@NotNull LDLfFormulaParserParser.RegularExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkOrRegExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckOrRegExp(@NotNull LDLfFormulaParserParser.CheckOrRegExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkConcatenationRegExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckConcatenationRegExp(@NotNull LDLfFormulaParserParser.CheckConcatenationRegExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkStar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckStar(@NotNull LDLfFormulaParserParser.CheckStarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckTest(@NotNull LDLfFormulaParserParser.CheckTestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#propositionalFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropositionalFormula(@NotNull LDLfFormulaParserParser.PropositionalFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkdoubleImplicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckdoubleImplicationProp(@NotNull LDLfFormulaParserParser.CheckdoubleImplicationPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkImplicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckImplicationProp(@NotNull LDLfFormulaParserParser.CheckImplicationPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkOrProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckOrProp(@NotNull LDLfFormulaParserParser.CheckOrPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkAndProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckAndProp(@NotNull LDLfFormulaParserParser.CheckAndPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#checkNotProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckNotProp(@NotNull LDLfFormulaParserParser.CheckNotPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull LDLfFormulaParserParser.AtomContext ctx);
}
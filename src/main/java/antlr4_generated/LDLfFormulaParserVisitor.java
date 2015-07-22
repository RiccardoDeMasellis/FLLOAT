// Generated from LDLfFormulaParser.g4 by ANTLR 4.3

	package antlr4_generated;

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
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#andProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndProp(@NotNull LDLfFormulaParserParser.AndPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull LDLfFormulaParserParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#ldlfDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdlfDiamond(@NotNull LDLfFormulaParserParser.LdlfDiamondContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#star}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar(@NotNull LDLfFormulaParserParser.StarContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(@NotNull LDLfFormulaParserParser.TestContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#implicationTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicationTemp(@NotNull LDLfFormulaParserParser.ImplicationTempContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#regularExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularExpression(@NotNull LDLfFormulaParserParser.RegularExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#notTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotTemp(@NotNull LDLfFormulaParserParser.NotTempContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull LDLfFormulaParserParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#doubleImplicationTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleImplicationTemp(@NotNull LDLfFormulaParserParser.DoubleImplicationTempContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#orTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrTemp(@NotNull LDLfFormulaParserParser.OrTempContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#orProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrProp(@NotNull LDLfFormulaParserParser.OrPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#andTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndTemp(@NotNull LDLfFormulaParserParser.AndTempContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(@NotNull LDLfFormulaParserParser.ConcatenationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#ldlfAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdlfAtom(@NotNull LDLfFormulaParserParser.LdlfAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#implicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicationProp(@NotNull LDLfFormulaParserParser.ImplicationPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#notProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotProp(@NotNull LDLfFormulaParserParser.NotPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#alternation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternation(@NotNull LDLfFormulaParserParser.AlternationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#doubleImplicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleImplicationProp(@NotNull LDLfFormulaParserParser.DoubleImplicationPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#propositionalFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropositionalFormula(@NotNull LDLfFormulaParserParser.PropositionalFormulaContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull LDLfFormulaParserParser.AtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#ldlfBox}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdlfBox(@NotNull LDLfFormulaParserParser.LdlfBoxContext ctx);
}
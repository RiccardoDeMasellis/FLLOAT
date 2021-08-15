// Generated from LTLfFormulaParser.g4 by ANTLR 4.5

	package antlr4_generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LTLfFormulaParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LTLfFormulaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(LTLfFormulaParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LTLfFormulaParserParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#doubleImplicationTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleImplicationTemp(LTLfFormulaParserParser.DoubleImplicationTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#implicationTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicationTemp(LTLfFormulaParserParser.ImplicationTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#orTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrTemp(LTLfFormulaParserParser.OrTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#andTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndTemp(LTLfFormulaParserParser.AndTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#weakUntil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeakUntil(LTLfFormulaParserParser.WeakUntilContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#release}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelease(LTLfFormulaParserParser.ReleaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#until}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntil(LTLfFormulaParserParser.UntilContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#globally}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobally(LTLfFormulaParserParser.GloballyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#eventually}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventually(LTLfFormulaParserParser.EventuallyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#weakNext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeakNext(LTLfFormulaParserParser.WeakNextContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#next}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNext(LTLfFormulaParserParser.NextContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#notTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotTemp(LTLfFormulaParserParser.NotTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#ltlfAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlfAtom(LTLfFormulaParserParser.LtlfAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#propositionalFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropositionalFormula(LTLfFormulaParserParser.PropositionalFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#doubleImplicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleImplicationProp(LTLfFormulaParserParser.DoubleImplicationPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#implicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicationProp(LTLfFormulaParserParser.ImplicationPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#orProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrProp(LTLfFormulaParserParser.OrPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#andProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndProp(LTLfFormulaParserParser.AndPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#notProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotProp(LTLfFormulaParserParser.NotPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(LTLfFormulaParserParser.AtomContext ctx);
}
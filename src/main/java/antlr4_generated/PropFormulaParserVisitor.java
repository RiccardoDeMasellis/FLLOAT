// Generated from PropFormulaParser.g4 by ANTLR 4.3

	package antlr4_generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PropFormulaParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PropFormulaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PropFormulaParserParser#orProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrProp(@NotNull PropFormulaParserParser.OrPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link PropFormulaParserParser#andProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndProp(@NotNull PropFormulaParserParser.AndPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link PropFormulaParserParser#implicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicationProp(@NotNull PropFormulaParserParser.ImplicationPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link PropFormulaParserParser#notProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotProp(@NotNull PropFormulaParserParser.NotPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link PropFormulaParserParser#doubleImplicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleImplicationProp(@NotNull PropFormulaParserParser.DoubleImplicationPropContext ctx);

	/**
	 * Visit a parse tree produced by {@link PropFormulaParserParser#propositionalFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropositionalFormula(@NotNull PropFormulaParserParser.PropositionalFormulaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PropFormulaParserParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull PropFormulaParserParser.AtomContext ctx);
}
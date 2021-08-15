// Generated from LDLfFormulaParser.g4 by ANTLR 4.5

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
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(LDLfFormulaParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LDLfFormulaParserParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#doubleImplicationTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleImplicationTemp(LDLfFormulaParserParser.DoubleImplicationTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#implicationTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicationTemp(LDLfFormulaParserParser.ImplicationTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#orTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrTemp(LDLfFormulaParserParser.OrTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#andTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndTemp(LDLfFormulaParserParser.AndTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#ldlfBox}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdlfBox(LDLfFormulaParserParser.LdlfBoxContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#ldlfDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdlfDiamond(LDLfFormulaParserParser.LdlfDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#notTemp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotTemp(LDLfFormulaParserParser.NotTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#ldlfAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdlfAtom(LDLfFormulaParserParser.LdlfAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#regularExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularExpression(LDLfFormulaParserParser.RegularExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#alternation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternation(LDLfFormulaParserParser.AlternationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(LDLfFormulaParserParser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#star}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar(LDLfFormulaParserParser.StarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(LDLfFormulaParserParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#propositionalFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropositionalFormula(LDLfFormulaParserParser.PropositionalFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#doubleImplicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleImplicationProp(LDLfFormulaParserParser.DoubleImplicationPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#implicationProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicationProp(LDLfFormulaParserParser.ImplicationPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#orProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrProp(LDLfFormulaParserParser.OrPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#andProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndProp(LDLfFormulaParserParser.AndPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#notProp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotProp(LDLfFormulaParserParser.NotPropContext ctx);
	/**
	 * Visit a parse tree produced by {@link LDLfFormulaParserParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(LDLfFormulaParserParser.AtomContext ctx);
}
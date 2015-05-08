// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/LTLfFormulaParser.g4 by ANTLR 4.5

	package ltlfParser;

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
	T visitStart(@NotNull LTLfFormulaParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull LTLfFormulaParserParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkdoubleImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckdoubleImplication(@NotNull LTLfFormulaParserParser.CheckdoubleImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckImplication(@NotNull LTLfFormulaParserParser.CheckImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckOr(@NotNull LTLfFormulaParserParser.CheckOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckAnd(@NotNull LTLfFormulaParserParser.CheckAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkWeakUntil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckWeakUntil(@NotNull LTLfFormulaParserParser.CheckWeakUntilContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkRelease}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckRelease(@NotNull LTLfFormulaParserParser.CheckReleaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkUntil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckUntil(@NotNull LTLfFormulaParserParser.CheckUntilContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkGlobally}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckGlobally(@NotNull LTLfFormulaParserParser.CheckGloballyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkEventually}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckEventually(@NotNull LTLfFormulaParserParser.CheckEventuallyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkWeakNext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckWeakNext(@NotNull LTLfFormulaParserParser.CheckWeakNextContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkNext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckNext(@NotNull LTLfFormulaParserParser.CheckNextContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#checkNot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckNot(@NotNull LTLfFormulaParserParser.CheckNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLfFormulaParserParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull LTLfFormulaParserParser.AtomContext ctx);
}
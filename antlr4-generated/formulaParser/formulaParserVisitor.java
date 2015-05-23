// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/formulaParser.g4 by ANTLR 4.5

package formulaParser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link formulaParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface formulaParserVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link formulaParserParser#start}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStart(@NotNull formulaParserParser.StartContext ctx);

    /**
     * Visit a parse tree produced by {@link formulaParserParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(@NotNull formulaParserParser.ExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link formulaParserParser#formula}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFormula(@NotNull formulaParserParser.FormulaContext ctx);
}
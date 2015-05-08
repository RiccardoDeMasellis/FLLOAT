// Generated from /Users/demas/Lavoro/IntelliJ-Workspace/FLLOAT-new/grammars/fromStringToCharParser.g4 by ANTLR 4.5

	package fromStringToCharParser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link fromStringToCharParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface fromStringToCharParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link fromStringToCharParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull fromStringToCharParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link fromStringToCharParserParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull fromStringToCharParserParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link fromStringToCharParserParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull fromStringToCharParserParser.StringContext ctx);
}
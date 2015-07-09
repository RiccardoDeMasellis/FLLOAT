/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package visitors.LDLfVisitors;

import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfLocalTrueFormula;
import formula.regExp.*;
import generatedParsers.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.PropVisitor.LocalVisitor;

public class LDLfVisitorRegExp extends LDLfFormulaParserBaseVisitor<RegExp> {

    @Override
    public RegExp visitRegularExpression(@NotNull LDLfFormulaParserParser.RegularExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public RegExp visitAlternation(@NotNull LDLfFormulaParserParser.AlternationContext ctx) {
        RegExp left;
        RegExp right;
        RegExp result = null;
        if (ctx.getChildCount() > 1) {
            for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                if (i == ctx.getChildCount() - 1) {
                    left = visit(ctx.getChild(i - 2));
                    right = visit(ctx.getChild(i));
                } else {
                    left = visit(ctx.getChild(i - 2));
                    right = result;
                }
                result = new RegExpAltern(left, right);
            }
            return result;
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public RegExp visitConcatenation(@NotNull LDLfFormulaParserParser.ConcatenationContext ctx) {
        RegExp left;
        RegExp right;
        RegExp result = null;
        if (ctx.getChildCount() > 1) {
            for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                if (i == ctx.getChildCount() - 1) {
                    left = visit(ctx.getChild(i - 2));
                    right = visit(ctx.getChild(i));
                } else {
                    left = visit(ctx.getChild(i - 2));
                    right = result;
                }
                result = new RegExpConcat(left, right);
            }
            return result;
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public RegExp visitStar(@NotNull LDLfFormulaParserParser.StarContext ctx) {

        if (ctx.getChildCount() == 4) {
            return new RegExpStar(visit(ctx.getChild(1)));
        } else {
            if (ctx.getChildCount() == 2) {
                return new RegExpStar(visit(ctx.getChild(0)));
            } else {
                if (ctx.getChildCount() == 3) {
                    return visit(ctx.getChild(1));
                } else {
                    return visitChildren(ctx);
                }
            }
        }

    }

    @Override
    public RegExp visitTest(@NotNull LDLfFormulaParserParser.TestContext ctx) {

        // LSEPARATOR expression RSEPARATOR TEST
        if (ctx.getChildCount() == 4) {
            LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(1).getText()));
            LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.expression();
            LDLfVisitor implementation = new LDLfVisitor();
            LDLfFormula f = implementation.visit(tree);
            //f.nnf();
            return new RegExpTest(f);
        } else {
            // atom TEST
            if (ctx.getChildCount() == 2) {
                LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(0).getText()));
                LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
                ParseTree tree = parser.expression();
                LDLfVisitor implementation = new LDLfVisitor();
                LDLfFormula f = implementation.visit(tree);
                return new RegExpTest(f);
//                LDLfFormula f = null;
//                String atom = ctx.getChild(0).getText();
//                if (atom.equals("True") || atom.equals("TRUE") || atom.equals("true") || atom.equals("T"))
//                    f = new LDLfDiamondFormula(new RegExpLocalTrue(), new LDLfttFormula());
//                if (atom.equals("False") || atom.equals("FALSE") || atom.equals("false"))
//                    f = new LDLfDiamondFormula(new RegExpLocalFalse(), new LDLfttFormula());
//                return new RegExpTest(f);
            }

            // propositionalFormula |  EPSILON
            else {
                // EPSILON
                if (ctx.getChild(0).getText().equals("eps")) {
                    return new RegExpTest(new LDLfLocalTrueFormula());
                }

                // propositionalFormula
                else {
                    PropFormulaParserLexer lexer = new PropFormulaParserLexer(new ANTLRInputStream(ctx.getChild(0).getText()));
                    PropFormulaParserParser parser = new PropFormulaParserParser(new CommonTokenStream(lexer));
                    ParseTree tree = parser.propositionalFormula();
                    LocalVisitor<RegExpLocal> implementation = new LocalVisitor(RegExpLocal.class);
                    //LocalVisitor<S, LTLfLocalFormula>  implementation = new LocalVisitor(genericSymbol, LTLfLocalFormula.class, alphabet);
                    RegExpLocal f = implementation.visit(tree);
                    return f;
                }
            }
        }
    }

}

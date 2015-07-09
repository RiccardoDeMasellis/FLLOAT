/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package visitors.LDLfVisitors;

import formula.ldlf.*;
import formula.regExp.RegExp;
import formula.regExp.RegExpLocalTrue;
import formula.regExp.RegExpTest;
import generatedParsers.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.PropVisitor.LocalVisitor;


public class LDLfVisitor extends LDLfFormulaParserBaseVisitor<LDLfFormula> {

    @Override
    public LDLfFormula visitExpression(@NotNull LDLfFormulaParserParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public LDLfFormula visitLdlfAtom(@NotNull LDLfFormulaParserParser.LdlfAtomContext ctx) {
        if (ctx.getText().equals("tt")) {
            return new LDLfttFormula();
        } else {
            if (ctx.getText().equals("ff")) {
                return new LDLfffFormula();
            } else {
                if ((ctx.getText().equals("END")) || (ctx.getText().equals("end")) || (ctx.getText().equals("End"))) {
                    return new LDLfBoxFormula(new RegExpTest(new LDLfLocalTrueFormula()), new LDLfffFormula());
                } else {
                    if ((ctx.getText().equals("LAST")) || (ctx.getText().equals("Last")) || (ctx.getText().equals("last"))) {
                        return new LDLfDiamondFormula(new RegExpLocalTrue(), new LDLfBoxFormula(new RegExpTest(new LDLfLocalTrueFormula()), new LDLfffFormula()));
                    } else {
                        PropFormulaParserLexer lexer = new PropFormulaParserLexer(new ANTLRInputStream(ctx.getChild(0).getText()));
                        PropFormulaParserParser parser = new PropFormulaParserParser(new CommonTokenStream(lexer));
                        ParseTree tree = parser.propositionalFormula();
                        LocalVisitor<LDLfLocalFormula> implementation = new LocalVisitor(LDLfLocalFormula.class);
                        //LocalVisitor<S, LTLfLocalFormula>  implementation = new LocalVisitor(genericSymbol, LTLfLocalFormula.class, alphabet);
                        LDLfLocalFormula f = implementation.visit(tree);
                        //f.nnf();
                        return f;
                    }
                }
            }
        }
    }

    @Override
    public LDLfFormula visitAndTemp(@NotNull LDLfFormulaParserParser.AndTempContext ctx) {

        LDLfFormula left;
        LDLfFormula right;
        LDLfFormula result = null;

        if (ctx.getChildCount() > 1) {
            if (ctx.getChildCount() == 2) {
                left = visit(ctx.getChild(0));
                right = visit(ctx.getChild(1));
                result = new LDLfTempAndFormula(left, right);
            } else {
                for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                    if (i == ctx.getChildCount() - 1) {
                        left = visit(ctx.getChild(i - 2));
                        right = visit(ctx.getChild(i));
                    } else {
                        left = visit(ctx.getChild(i - 2));
                        right = result;
                    }
                    result = new LDLfTempAndFormula(left, right);
                }
            }
            return result;

        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula visitImplicationTemp(@NotNull LDLfFormulaParserParser.ImplicationTempContext ctx) {
        if (ctx.getChildCount() == 3) {
            LDLfFormula left = visit(ctx.getChild(0));
            LDLfFormula right = visit(ctx.getChild(2));

            return new LDLfTempImplFormula(left, right);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula visitNotTemp(@NotNull LDLfFormulaParserParser.NotTempContext ctx) {
        if (ctx.getChildCount() == 1)
            return visit(ctx.getChild(0));
        else {
            if (ctx.getChildCount() == 4)
                return new LDLfTempNotFormula(visit(ctx.getChild(2)));
            else // ctx.getChildCount() == 3
                return visit(ctx.getChild(1));
        }
    }

    @Override
    public LDLfFormula visitLdlfDiamond(@NotNull LDLfFormulaParserParser.LdlfDiamondContext ctx) {
        if (ctx.getChildCount() == 4) {
            LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(1).getText()));
            LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.regularExpression();
            LDLfVisitorRegExp implementation = new LDLfVisitorRegExp();
            RegExp re = implementation.visit(tree);

            LDLfFormula formula = visit(ctx.getChild(3));

            return new LDLfDiamondFormula(re, formula);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula visitLdlfBox(@NotNull LDLfFormulaParserParser.LdlfBoxContext ctx) {
        if (ctx.getChildCount() == 4) {
            LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(1).getText()));
            LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.regularExpression();
            LDLfVisitorRegExp implementation = new LDLfVisitorRegExp();
            RegExp re = implementation.visit(tree);

            LDLfFormula formula = visit(ctx.getChild(3));

            return new LDLfBoxFormula(re, formula);

        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula visitStart(@NotNull LDLfFormulaParserParser.StartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public LDLfFormula visitDoubleImplicationTemp(@NotNull LDLfFormulaParserParser.DoubleImplicationTempContext ctx) {
        if (ctx.getChildCount() == 3) {
            LDLfFormula left = visit(ctx.getChild(0));
            LDLfFormula right = visit(ctx.getChild(2));
            return new LDLfTempDoubleImplFormula(left, right);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula visitOrTemp(@NotNull LDLfFormulaParserParser.OrTempContext ctx) {

        LDLfFormula left;
        LDLfFormula right;
        LDLfFormula result = null;

        if (ctx.getChildCount() > 1) {
            if (ctx.getChildCount() == 2) {
                left = visit(ctx.getChild(0));
                right = visit(ctx.getChild(1));
                result = new LDLfTempOrFormula(left, right);
            } else {
                for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                    if (i == ctx.getChildCount() - 1) {
                        left = visit(ctx.getChild(i - 2));
                        right = visit(ctx.getChild(i));
                    } else {
                        left = visit(ctx.getChild(i - 2));
                        right = result;
                    }
                    result = new LDLfTempOrFormula(left, right);
                }
            }
            return result;

        } else {
            return visitChildren(ctx);
        }
    }
}

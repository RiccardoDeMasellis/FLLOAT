/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package visitors.LTLfVisitors;

import antlr4_generated.LTLfFormulaParserBaseVisitor;
import antlr4_generated.LTLfFormulaParserParser;
import antlr4_generated.PropFormulaParserLexer;
import antlr4_generated.PropFormulaParserParser;
import formula.ltlf.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.PropVisitor.LocalVisitor;


public class LTLfVisitor extends LTLfFormulaParserBaseVisitor<LTLfFormula> {


    @Override
    public LTLfFormula visitExpression(@NotNull LTLfFormulaParserParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public LTLfFormula visitLtlfAtom(@NotNull LTLfFormulaParserParser.LtlfAtomContext ctx) {
        if ((ctx.getText().equals("LAST")) || (ctx.getText().equals("Last")) || (ctx.getText().equals("last"))) {
            return new LTLfTempNotFormula(new LTLfNextFormula(new LTLfLocalTrueFormula()));
        } else {
/*            S symbol = null;
            try {
                symbol = genericSymbol.getConstructor(String.class).newInstance(ctx.getText());
            } catch (InstantiationException | IllegalAccessException
                    | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException
                    | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            alphabet.addSymbol(symbol);
            return new LDLfAtomicFormula(symbol);*/

            PropFormulaParserLexer lexer = new PropFormulaParserLexer(new ANTLRInputStream(ctx.getChild(0).getText()));
            PropFormulaParserParser parser = new PropFormulaParserParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.propositionalFormula();
            LocalVisitor<LTLfLocalFormula> implementation = new LocalVisitor(LTLfLocalFormula.class);
            //LocalVisitor<S, LTLfLocalFormula>  implementation = new LocalVisitor(genericSymbol, LTLfLocalFormula.class, alphabet);
            LTLfLocalFormula f = implementation.visit(tree);
            return f;
        }
    }


    @Override
    public LTLfFormula visitAndTemp(@NotNull LTLfFormulaParserParser.AndTempContext ctx) {

        LTLfFormula left;
        LTLfFormula right;
        LTLfFormula result = null;

        if (ctx.getChildCount() > 1) {
            for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                if (i == ctx.getChildCount() - 1) {
                    left = visit(ctx.getChild(i - 2));
                    right = visit(ctx.getChild(i));
                } else {
                    left = visit(ctx.getChild(i - 2));
                    right = result;
                }
                result = new LTLfTempAndFormula(left, right);
            }

            return result;

        } else {
            return visitChildren(ctx);
        }
    }


    @Override
    public LTLfFormula visitImplicationTemp(@NotNull LTLfFormulaParserParser.ImplicationTempContext ctx) {

        if (ctx.getChildCount() == 3) {
            LTLfFormula left = visit(ctx.getChild(0));
            LTLfFormula right = visit(ctx.getChild(2));

            return new LTLfTempImplFormula(left, right);
        } else {
            return visitChildren(ctx);
        }
    }


//    @Override
//    public LTLfFormula visitNotTemp(@NotNull LTLfFormulaParserParser.NotTempContext ctx) {
//
//        if (ctx.getChildCount() == 2) {
//            return new LTLfTempNotFormula(visit(ctx.getChild(1)));
//        } else {
//            if (ctx.getChildCount() == 4) {
//                return new LTLfTempNotFormula(visit(ctx.getChild(2)));
//            } else {
//                if (ctx.getChildCount() == 3) {
//                    return visit(ctx.getChild(1));
//                } else {
//                    return visitChildren(ctx);
//                }
//            }
//        }
//    }

    @Override
    public LTLfFormula visitNotTemp(@NotNull LTLfFormulaParserParser.NotTempContext ctx) {

        if (ctx.getChildCount() == 1)
            return visit(ctx.getChild(0));
        else {
            if (ctx.getChildCount() == 4)
                return new LTLfTempNotFormula(visit(ctx.getChild(2)));
            else // ctx.getChildCount() == 3
                return visit(ctx.getChild(1));
        }
    }


    @Override
    public LTLfFormula visitUntil(@NotNull LTLfFormulaParserParser.UntilContext ctx) {

        if (ctx.getChildCount() == 3) {
            LTLfFormula left = visit(ctx.getChild(0));
            LTLfFormula right = visit(ctx.getChild(2));

            return new LTLfUntilFormula(left, right);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LTLfFormula visitNext(@NotNull LTLfFormulaParserParser.NextContext ctx) {
        if (ctx.getChildCount() == 2) {
            return new LTLfNextFormula(visit(ctx.getChild(1)));
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LTLfFormula visitWeakUntil(@NotNull LTLfFormulaParserParser.WeakUntilContext ctx) {

        if (ctx.getChildCount() == 3) {
            LTLfFormula left = visit(ctx.getChild(0));
            LTLfFormula right = visit(ctx.getChild(2));

            return new LTLfWeakUntilFormula(left, right);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LTLfFormula visitGlobally(@NotNull LTLfFormulaParserParser.GloballyContext ctx) {

        if (ctx.getChildCount() == 2) {
            return new LTLfGloballyFormula(visit(ctx.getChild(1)));
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LTLfFormula visitEventually(@NotNull LTLfFormulaParserParser.EventuallyContext ctx) {

        if (ctx.getChildCount() == 2) {
            return new LTLfEventuallyFormula(visit(ctx.getChild(1)));
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LTLfFormula visitWeakNext(@NotNull LTLfFormulaParserParser.WeakNextContext ctx) {

        if (ctx.getChildCount() == 2) {
            return new LTLfWeakNextFormula(visit(ctx.getChild(1)));
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LTLfFormula visitStart(@NotNull LTLfFormulaParserParser.StartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public LTLfFormula visitDoubleImplicationTemp(@NotNull LTLfFormulaParserParser.DoubleImplicationTempContext ctx) {

        if (ctx.getChildCount() == 3) {
            LTLfFormula left = visit(ctx.getChild(0));
            LTLfFormula right = visit(ctx.getChild(2));

            return new LTLfTempDoubleImplFormula(left, right);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LTLfFormula visitRelease(@NotNull LTLfFormulaParserParser.ReleaseContext ctx) {

        if (ctx.getChildCount() == 3) {
            LTLfFormula left = visit(ctx.getChild(0));
            LTLfFormula right = visit(ctx.getChild(2));

            return new LTLfReleaseFormula(left, right);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LTLfFormula visitOrTemp(@NotNull LTLfFormulaParserParser.OrTempContext ctx) {

        LTLfFormula left;
        LTLfFormula right;
        LTLfFormula result = null;

        if (ctx.getChildCount() > 1) {
            for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                if (i == ctx.getChildCount() - 1) {
                    left = visit(ctx.getChild(i - 2));
                    right = visit(ctx.getChild(i));
                } else {
                    left = visit(ctx.getChild(i - 2));
                    right = result;
                }
                result = new LTLfTempOrFormula(left, right);
            }

            return result;

        } else {
            return visitChildren(ctx);
        }
    }

}

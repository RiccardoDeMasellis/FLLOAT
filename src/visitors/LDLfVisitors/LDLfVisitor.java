package visitors.LDLfVisitors;

import formula.ldlf.*;
import formula.regExp.RegExp;
import formula.regExp.RegExpPropTrue;
import formula.regExp.RegExpTest;
import generatedParsers.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import symbols.Alphabet;
import symbols.Symbol;
import visitors.PropVisitor.PropVisitor;


public class LDLfVisitor<S extends Symbol<?>> extends LDLfFormulaParserBaseVisitor<LDLfFormula<S>> {

    private Alphabet<S> alphabet;
    private Class<S> genericSymbol;

    public LDLfVisitor(Class<S> genericSymbol, Alphabet<S> alphabet) {
        this.alphabet = alphabet;
        this.genericSymbol = genericSymbol;
    }

    public Class<S> getGenericSymbol() {
        return genericSymbol;
    }

    public Alphabet<S> getAlphabet() {
        return alphabet;
    }


    @Override
    public LDLfFormula<S> visitExpression(@NotNull LDLfFormulaParserParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public LDLfFormula<S> visitLdlfAtom(@NotNull LDLfFormulaParserParser.LdlfAtomContext ctx) {
        if (ctx.getText().equals("tt")) {
            return new LDLfttFormula<>();
        } else {
            if (ctx.getText().equals("ff")) {
                return new LDLfffFormula<>();
            } else {
                if ((ctx.getText().equals("END")) || (ctx.getText().equals("end")) || (ctx.getText().equals("End"))) {
                    return new LDLfBoxFormula<>(new RegExpTest<>(new LDLfPropTrueFormula<>()), new LDLfffFormula<>());
                } else {
                    if ((ctx.getText().equals("LAST")) || (ctx.getText().equals("Last")) || (ctx.getText().equals("last"))) {
                        return new LDLfDiamondFormula<>(new RegExpPropTrue<>(), new LDLfBoxFormula<>(new RegExpTest<>(new LDLfPropTrueFormula<>()), new LDLfffFormula<>()));
                    } else {
                        PropFormulaParserLexer lexer = new PropFormulaParserLexer(new ANTLRInputStream(ctx.getChild(0).getText()));
                        PropFormulaParserParser parser = new PropFormulaParserParser(new CommonTokenStream(lexer));
                        ParseTree tree = parser.propositionalFormula();
                        PropVisitor<S, LDLfPropFormula<S>> implementation = new PropVisitor(genericSymbol, LDLfPropFormula.class, alphabet);
                        //PropVisitor<S, LTLfPropFormula<S>>  implementation = new PropVisitor<>(genericSymbol, LTLfPropFormula.class, alphabet);
                        LDLfPropFormula<S> f = implementation.visit(tree);
                        //f.nnf();
                        return f;
                    }
                }
            }
        }
    }

    @Override
    public LDLfFormula<S> visitAndTemp(@NotNull LDLfFormulaParserParser.AndTempContext ctx) {

        LDLfFormula<S> left;
        LDLfFormula<S> right;
        LDLfFormula<S> result = null;

        if (ctx.getChildCount() > 1) {
            if (ctx.getChildCount() == 2) {
                left = visit(ctx.getChild(0));
                right = visit(ctx.getChild(1));
                result = new LDLfTempAndFormula<>(left, right);
            } else {
                for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                    if (i == ctx.getChildCount() - 1) {
                        left = visit(ctx.getChild(i - 2));
                        right = visit(ctx.getChild(i));
                    } else {
                        left = visit(ctx.getChild(i - 2));
                        right = result;
                    }
                    result = new LDLfTempAndFormula<>(left, right);
                }
            }
            return result;

        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula<S> visitImplicationTemp(@NotNull LDLfFormulaParserParser.ImplicationTempContext ctx) {
        if (ctx.getChildCount() == 3) {
            LDLfFormula<S> left = visit(ctx.getChild(0));
            LDLfFormula<S> right = visit(ctx.getChild(2));

            return new LDLfTempImplFormula<>(left, right);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula<S> visitNotTemp(@NotNull LDLfFormulaParserParser.NotTempContext ctx) {
        if (ctx.getChildCount() == 1)
            return visit(ctx.getChild(0));
        else {
            if (ctx.getChildCount() == 4)
                return new LDLfTempNotFormula<>(visit(ctx.getChild(2)));
            else // ctx.getChildCount() == 3
                return visit(ctx.getChild(1));
        }
    }

    @Override
    public LDLfFormula<S> visitLdlfDiamond(@NotNull LDLfFormulaParserParser.LdlfDiamondContext ctx) {
        if (ctx.getChildCount() == 4) {
            LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(1).getText()));
            LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.regularExpression();
            LDLfVisitorRegExp<S> implementation = new LDLfVisitorRegExp<>(genericSymbol, alphabet);
            RegExp<S> re = implementation.visit(tree);

            LDLfFormula<S> formula = visit(ctx.getChild(3));

            return new LDLfDiamondFormula<>(re, formula);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula<S> visitLdlfBox(@NotNull LDLfFormulaParserParser.LdlfBoxContext ctx) {
        if (ctx.getChildCount() == 4) {
            LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(1).getText()));
            LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.regularExpression();
            LDLfVisitorRegExp<S> implementation = new LDLfVisitorRegExp<>(genericSymbol, alphabet);
            RegExp<S> re = implementation.visit(tree);

            LDLfFormula<S> formula = visit(ctx.getChild(3));

            return new LDLfBoxFormula<>(re, formula);

        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula<S> visitStart(@NotNull LDLfFormulaParserParser.StartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public LDLfFormula<S> visitDoubleImplicationTemp(@NotNull LDLfFormulaParserParser.DoubleImplicationTempContext ctx) {
        if (ctx.getChildCount() == 3) {
            LDLfFormula<S> left = visit(ctx.getChild(0));
            LDLfFormula<S> right = visit(ctx.getChild(2));
            return new LDLfTempDoubleImplFormula<>(left, right);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public LDLfFormula<S> visitOrTemp(@NotNull LDLfFormulaParserParser.OrTempContext ctx) {

        LDLfFormula<S> left;
        LDLfFormula<S> right;
        LDLfFormula<S> result = null;

        if (ctx.getChildCount() > 1) {
            if (ctx.getChildCount() == 2) {
                left = visit(ctx.getChild(0));
                right = visit(ctx.getChild(1));
                result = new LDLfTempOrFormula<>(left, right);
            } else {
                for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                    if (i == ctx.getChildCount() - 1) {
                        left = visit(ctx.getChild(i - 2));
                        right = visit(ctx.getChild(i));
                    } else {
                        left = visit(ctx.getChild(i - 2));
                        right = result;
                    }
                    result = new LDLfTempOrFormula<>(left, right);
                }
            }
            return result;

        } else {
            return visitChildren(ctx);
        }
    }
}

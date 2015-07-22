/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package visitors.PropVisitor;

import antlr4_generated.PropFormulaParserBaseVisitor;
import antlr4_generated.PropFormulaParserParser;
import formula.LocalFormula;
import formula.LocalFormulaType;
import net.sf.tweety.logics.pl.syntax.Proposition;
import org.antlr.v4.runtime.misc.NotNull;

import java.lang.reflect.InvocationTargetException;


// F can be of type LDLfLocalFormula, RegExpLocal or LTLfLocalFormula.
public class LocalVisitor<F extends LocalFormula> extends PropFormulaParserBaseVisitor<F> {

    private Class<F> genericFormula;

    public LocalVisitor(Class<F> genericFormula) {
        this.genericFormula = genericFormula;
    }


    @Override
    public F visitPropositionalFormula(@NotNull PropFormulaParserParser.PropositionalFormulaContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public F visitImplicationProp(@NotNull PropFormulaParserParser.ImplicationPropContext ctx) {

        if (ctx.getChildCount() == 3) {
            F left = visit(ctx.getChild(0));
            F right = visit(ctx.getChild(2));

            try {
                return genericFormula.cast(genericFormula.getMethod("localFormulaFactory", LocalFormulaType.class, genericFormula, genericFormula, Proposition.class).invoke(null, LocalFormulaType.PROP_IMPL, genericFormula.cast(left), genericFormula.cast(right), null));
            } catch (IllegalAccessException
                    | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException
                    | SecurityException e) {
                throw new RuntimeException(e);
            }

        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public F visitAndProp(@NotNull PropFormulaParserParser.AndPropContext ctx) {

        F left;
        F right;
        F result = null;

        if (ctx.getChildCount() > 1) {

            for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                if (i == ctx.getChildCount() - 1) {
                    left = visit(ctx.getChild(i - 2));
                    right = visit(ctx.getChild(i));
                } else {
                    left = visit(ctx.getChild(i - 2));
                    right = result;
                }
                try {
                    result = genericFormula.cast(genericFormula.getMethod("localFormulaFactory", LocalFormulaType.class, genericFormula, genericFormula, Proposition.class).invoke(null, LocalFormulaType.PROP_AND, genericFormula.cast(left), genericFormula.cast(right), null));
                } catch (IllegalAccessException
                        | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException
                        | SecurityException e) {
                    throw new RuntimeException(e);
                }
            }

            return result;

        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public F visitNotProp(@NotNull PropFormulaParserParser.NotPropContext ctx) {

        if (ctx.getChildCount() == 2) {
            F left = visit(ctx.getChild(1));
            try {
                return genericFormula.cast(genericFormula.getMethod("localFormulaFactory", LocalFormulaType.class, genericFormula, genericFormula, Proposition.class).invoke(null, LocalFormulaType.PROP_NOT, genericFormula.cast(left), null, null));
            } catch (IllegalAccessException
                    | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException
                    | SecurityException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (ctx.getChildCount() == 4) {
                F left = visit(ctx.getChild(2));
                try {
                    return genericFormula.cast(genericFormula.getMethod("localFormulaFactory", LocalFormulaType.class, genericFormula, genericFormula, Proposition.class).invoke(null, LocalFormulaType.PROP_NOT, genericFormula.cast(left), null, null));
                } catch (IllegalAccessException
                        | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException
                        | SecurityException e) {
                    throw new RuntimeException(e);
                }
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
    public F visitDoubleImplicationProp(@NotNull PropFormulaParserParser.DoubleImplicationPropContext ctx) {

        if (ctx.getChildCount() == 3) {
            F left = visit(ctx.getChild(0));
            F right = visit(ctx.getChild(2));

            try {
                return genericFormula.cast(genericFormula.getMethod("localFormulaFactory", LocalFormulaType.class, genericFormula, genericFormula, Proposition.class).invoke(null, LocalFormulaType.PROP_DOUBLEIMPL, genericFormula.cast(left), genericFormula.cast(right), null));
            } catch (IllegalAccessException
                    | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException
                    | SecurityException e) {
                throw new RuntimeException(e);
            }
        } else {
            return visitChildren(ctx);
        }
    }


    @Override
    public F visitOrProp(@NotNull PropFormulaParserParser.OrPropContext ctx) {

        F left;
        F right;
        F result = null;

        if (ctx.getChildCount() > 1) {

            for (int i = ctx.getChildCount() - 1; i >= 2; i = i - 2) {
                if (i == ctx.getChildCount() - 1) {
                    left = visit(ctx.getChild(i - 2));
                    right = visit(ctx.getChild(i));
                } else {
                    left = visit(ctx.getChild(i - 2));
                    right = result;
                }
                try {
                    result = genericFormula.cast(genericFormula.getMethod("localFormulaFactory", LocalFormulaType.class, genericFormula, genericFormula, Proposition.class).invoke(null, LocalFormulaType.PROP_OR, genericFormula.cast(left), genericFormula.cast(right), null));
                } catch (IllegalAccessException
                        | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException
                        | SecurityException e) {
                    throw new RuntimeException(e);
                }
            }

            return result;

        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public F visitAtom(@NotNull PropFormulaParserParser.AtomContext ctx) {
        if ((ctx.getText().equals("TRUE")) || (ctx.getText().equals("True")) || (ctx.getText().equals("true"))) {
            try {
                return genericFormula.cast(genericFormula.getMethod("localFormulaFactory", LocalFormulaType.class, genericFormula, genericFormula, Proposition.class).invoke(null, LocalFormulaType.PROP_TRUE, null, null, null));
            } catch (IllegalAccessException
                    | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException
                    | SecurityException e) {
                throw new RuntimeException(e);
            }
        } else {
            if ((ctx.getText().equals("FALSE")) || (ctx.getText().equals("False")) || (ctx.getText().equals("false"))) {
                try {
                    return genericFormula.cast(genericFormula.getMethod("localFormulaFactory", LocalFormulaType.class, genericFormula, genericFormula, Proposition.class).invoke(null, LocalFormulaType.PROP_FALSE, null, null, null));
                } catch (IllegalAccessException
                        | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException
                        | SecurityException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Proposition prop = new Proposition(ctx.getText());
                try {
                    return genericFormula.cast(genericFormula.getMethod("localFormulaFactory", LocalFormulaType.class, genericFormula, genericFormula, Proposition.class).invoke(null, LocalFormulaType.PROP_VAR, null, null, prop));
                } catch (IllegalAccessException
                        | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException
                        | SecurityException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

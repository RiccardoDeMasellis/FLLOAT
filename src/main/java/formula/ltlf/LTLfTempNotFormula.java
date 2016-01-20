/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.NotFormula;
import formula.TemporalFormula;
import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfTempAndFormula;
import formula.ldlf.LDLfTempNotFormula;
import formula.ldlf.LDLfTempOrFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempNotFormula extends LTLfUnaryFormula implements NotFormula, LTLfBoolOpTempFormula {

    public LTLfTempNotFormula(LTLfFormula nestedFormula) {
        super(nestedFormula);
    }

    public String stringOperator() {
        return "Te" + NotFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_TEMP_NOT;
    }


    @Override
    public LDLfFormula toLDLf() {
        if(this.getNestedFormula() instanceof LTLfNextFormula)
            return new LDLfTempNotFormula(this.getNestedFormula().toLDLf());

        if(this.getNestedFormula() instanceof LTLfEventuallyFormula)
            return new LDLfTempNotFormula(this.getNestedFormula().toLDLf());

        if(this.getNestedFormula() instanceof LTLfUntilFormula)
            return new LDLfTempNotFormula(this.getNestedFormula().toLDLf());

        if(this.getNestedFormula() instanceof LTLfTempAndFormula) {
            LTLfFormula left = ((LTLfTempAndFormula) this.getNestedFormula()).getLeftFormula();
            LTLfFormula right = ((LTLfTempAndFormula) this.getNestedFormula()).getRightFormula();
            LTLfFormula leftNot, rightNot;

            if(left instanceof TemporalFormula)
                leftNot = new LTLfTempNotFormula((LTLfFormula) left.clone());
            else
                leftNot = new LTLfLocalNotFormula((LTLfFormula) left.clone());

            if(right instanceof TemporalFormula)
                rightNot = new LTLfTempNotFormula((LTLfFormula) right.clone());
            else
                rightNot = new LTLfLocalNotFormula((LTLfFormula) right.clone());

            return new LDLfTempOrFormula(leftNot.toLDLf(), rightNot.toLDLf());
        }

        if(this.getNestedFormula() instanceof LTLfTempOrFormula) {
            LTLfFormula left = ((LTLfTempOrFormula) this.getNestedFormula()).getLeftFormula();
            LTLfFormula right = ((LTLfTempOrFormula) this.getNestedFormula()).getRightFormula();
            LTLfFormula leftNot, rightNot;

            if(left instanceof TemporalFormula)
                leftNot = new LTLfTempNotFormula((LTLfFormula) left.clone());
            else
                leftNot = new LTLfLocalNotFormula((LTLfFormula) left.clone());

            if(right instanceof TemporalFormula)
                rightNot = new LTLfTempNotFormula((LTLfFormula) right.clone());
            else
                rightNot = new LTLfLocalNotFormula((LTLfFormula) right.clone());

            return new LDLfTempAndFormula(leftNot.toLDLf(), rightNot.toLDLf());
        }

        if (this.getNestedFormula() instanceof LTLfTempNotFormula)
            return ((LTLfTempNotFormula) this.getNestedFormula()).getNestedFormula().toLDLf();

        System.out.println(this.getNestedFormula().getClass());
        throw new RuntimeException();
    }

    @Override
    public LTLfFormula antinnf() {
        return new LTLfTempNotFormula(this.getNestedFormula().antinnf());
    }
}

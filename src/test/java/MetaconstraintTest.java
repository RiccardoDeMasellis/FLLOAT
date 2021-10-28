/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

import RuntimeVerification.RVTempFalse;
import formula.ldlf.LDLfFormula;
import metaconstraints.*;
import org.junit.Test;
import utils.ParserUtils;

public class MetaconstraintTest {

    @Test
    public void metaconstraintTest() {


        for (DeclareNames name : DeclareNames.values()) {

            DeclareFormula declare = new DeclareFormula(name, "a", "b");

            LDLfFormula tempTrue = ParserUtils.parseLDLfFormula("<"+declare.getRvTempTrue()+">(end)");
            LDLfFormula tempFalse = ParserUtils.parseLDLfFormula("<"+declare.getRvTempFalse()+">(end)");
            LDLfFormula PermTrue = ParserUtils.parseLDLfFormula("<"+declare.getRvPermTrue()+">(end)");
            LDLfFormula PermFalse = ParserUtils.parseLDLfFormula("<"+declare.getRvPermFalse()+">(end)");

            MetaConFormula compensation = new Compensation(name, "a", "b", name, "c", "d");
            MetaConFormula contextAbsence = new ContexAbsence(name, "a", "b", new RVTempFalse(), "d");
            MetaConFormula reactiveComp = new Compensation(name, "a", "b", name, "c", "d");
        }
    }
}
/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

import RuntimeVerification.RVTempFalse;
import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfTempDoubleImplFormula;
import formula.ldlf.LDLfTempNotFormula;
import main.AutomatonResultWrapper;
import main.Main;
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
            MetaConFormula reactiveComp = new ReactiveCompensation(name, "a", "b", name, "c", "d");
        }


        DeclareFormula notCoex1 = new DeclareFormula(DeclareNames.NOT_COEXISTENCE, "a", "b");
        DeclareFormula notCoex2 = new DeclareFormula(DeclareNames.NOT_COEXISTENCE, "b", "a");

        /*
        LDLfFormula doubleImpl = new LDLfTempDoubleImplFormula(notCoex1.getLdlf(), notCoex2.getLdlf());
        LDLfFormula toCheck = new LDLfTempNotFormula(doubleImpl);

        AutomatonResultWrapper arw = Main.ldlfFormula2Aut(toCheck,null,true,true,true,true);
        //Automaton aut = arw.getAutomaton();
        //System.out.println(aut);
        */

        MetaConFormula comp1 = new Compensation(DeclareNames.NOT_COEXISTENCE, "a", "b", DeclareNames.EXISTENCE, "c", null);
        MetaConFormula comp2 = new Compensation(DeclareNames.NOT_COEXISTENCE, "b", "a", DeclareNames.EXISTENCE, "c", null);

        System.out.println(comp1.getMetacon());
        System.out.println(comp2.getMetacon());

        LDLfFormula doubleImpl = new LDLfTempDoubleImplFormula(comp1.getMetacon(), comp2.getMetacon());
        LDLfFormula toCheck = new LDLfTempNotFormula(doubleImpl);
        AutomatonResultWrapper arw = Main.ldlfFormula2Aut(toCheck,null,true,true,true,true);

    }
}
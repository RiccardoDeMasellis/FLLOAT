/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package metaconstraints;

import formula.ldlf.LDLfDiamondFormula;
import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfTempImplFormula;
import utils.ParserUtils;

public class ReactiveCompensation extends MetaConFormula {


    public ReactiveCompensation(DeclareNames namePhi, String phiAct1, String phiAct2, DeclareNames namePsi, String psiAct1, String psiAct2) {

        DeclareFormula decPhi = new DeclareFormula(namePhi, phiAct1, phiAct2);
        String PhiREPermFalse = decPhi.getRvPermFalse();
        LDLfFormula PhiPermFalse = ParserUtils.parseLDLfFormula("<"+PhiREPermFalse+">(end)");

        LDLfFormula ldlfPsi = new DeclareFormula(namePsi, psiAct1, psiAct2).getLdlf();

        LDLfDiamondFormula rightDirty = (LDLfDiamondFormula) ParserUtils.parseLDLfFormula("<" + PhiREPermFalse + ">tt");

        LDLfFormula rightClean = new LDLfDiamondFormula(rightDirty.getRegExp(), ldlfPsi);

        this.metacon = new LDLfTempImplFormula(PhiPermFalse, rightClean);
    }
}

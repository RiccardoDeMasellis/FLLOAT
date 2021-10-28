/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package metaconstraints;

import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfTempImplFormula;
import utils.ParserUtils;

public class Compensation extends MetaConFormula {

    public Compensation(DeclareNames namePhi, String phiAct1, String phiAct2, DeclareNames namePsi, String psiAct1, String psiAct2) {

        DeclareFormula decPhi = new DeclareFormula(namePhi, phiAct1, phiAct2);
        String PhiREPermFalse = decPhi.getRvPermFalse();
        LDLfFormula PhiPermFalse = ParserUtils.parseLDLfFormula("<"+PhiREPermFalse+">(end)");

        LDLfFormula ldlfPsi = new DeclareFormula(namePsi, psiAct1, psiAct2).getLdlf();

        this.metacon = new LDLfTempImplFormula(PhiPermFalse, ldlfPsi);
    }
}

/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package metaconstraints;

import RuntimeVerification.RVFalse;
import RuntimeVerification.RVTempFalse;
import RuntimeVerification.RVTrue;
import RuntimeVerification.RVTruthValue;
import utils.ParserUtils;

public class ContexAbsence extends MetaConFormula {

    public ContexAbsence(DeclareNames name, String act1, String act2, RVTruthValue rvtv, String act) {

        DeclareFormula df = new DeclareFormula(name, act1, act2);
        String re;

        if (rvtv instanceof RVFalse) {
            re = df.getRvPermFalse();
        }
        else if (rvtv instanceof RVTrue) {
            re = df.getRvPermTrue();
        }
        else if (rvtv instanceof RVTempFalse) {
            re = df.getRvTempFalse();
        }
        else { //RVTempTrue
            re = df.getRvTempTrue();
        }

        String mc = "["+re+"]( (!"+act+") || end)";

        this.metacon = ParserUtils.parseLDLfFormula(mc);

    }
}

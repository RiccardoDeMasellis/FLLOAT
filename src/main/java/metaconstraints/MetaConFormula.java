/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package metaconstraints;


import formula.ldlf.LDLfFormula;

public abstract class MetaConFormula {

    LDLfFormula metacon;


    public LDLfFormula getMetacon() {
        return metacon;
    }

}

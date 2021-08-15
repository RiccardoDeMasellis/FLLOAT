/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula;

/**
 * Created by Riccardo De Masellis on 23/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public enum FormulaType {

    /*
    * LTLf
    */
    LTLf_WEAK_UNTIL,
    LTLf_WEAK_NEXT,
    LTLf_UNTIL,
    LTLf_TEMP_OR,
    LTLf_TEMP_NOT,
    LTLf_TEMP_IMPL,
    LTLf_TEMP_DOUBLEIMPL,
    LTLf_TEMP_AND,
    LTLf_RELEASE,
    LTLf_LOCAL_TRUE,
    LTLf_LOCAL_OR,
    LTLf_LOCAL_NOT,
    LTLf_LOCAL_IMPL,
    LTLf_LOCAL_FALSE,
    LTLf_LOCAL_DOUBLEIMPL,
    LTLf_LOCAL_AND,
    LTLf_NEXT,
    LTLf_GLOBALLY,
    LTLf_EVENTUALLY,
    LTLf_LOCAL_VAR,

    /*
    * LDLf
    */
    LDLf_TEMP_OR,
    LDLf_TEMP_NOT,
    LDLf_TEMP_IMPL,
    LDLf_TEMP_DOUBLEIMPL,
    LDLf_TEMP_AND,
    LDLf_LOCAL_TRUE,
    LDLf_LOCAL_OR,
    LDLf_LOCAL_NOT,
    LDLf_LOCAL_IMPL,
    LDLf_LOCAL_FALSE,
    LDLf_LOCAL_DOUBLEIMPL,
    LDLf_LOCAL_AND,
    LDLf_LOCAL_VAR,
    LDLf_tt,
    LDLf_ff,
    LDLf_BOX,
    LDLf_DIAMOND,


    /*
    * RegExp
    */
    RE_TEST,
    RE_STAR,
    RE_LOCAL_VAR,
    RE_LOCAL_TRUE,
    RE_LOCAL_OR,
    RE_LOCAL_NOT,
    RE_LOCAL_IMPL,
    RE_LOCAL_FALSE,
    RE_LOCAL_DOUBLEIMPL,
    RE_LOCAL_AND,
    RE_CONCAT,
    RE_ALTERN

}

/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package metaconstraints;

import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import utils.ParserUtils;

public class DeclareFormula {

    private DeclareNames name;

    private LTLfFormula ltlf;
    private LDLfFormula ldlf;

    private String rvTempTrueRE;
    private String rvTempFalseRE;
    private String rvPermTrueRE;
    private String rvPermFalseRE;


  public DeclareFormula(DeclareNames name, String act1, String act2) {
      String stringFormula="";

      this.name = name;

      // Shortcut for all tasks different from act1;
      String notAct1 = "(!"+act1+")";
      // Shortcut for all tasks different from act2;
      String notAct2 = "(!"+act2+")";
      // Shortcut for all tasks different from act1 and act2;
      String allOthers = "(! ("+act1+" && "+act2+" ))";


        switch(name) {

            case ABSENCE -> {
                stringFormula  = "!(F(" + act1 + "))";

                // TempTrue
                this.rvTempTrueRE = "("+allOthers+"*)";

                // TempFalse
                this.rvTempFalseRE = "false";

                // PermTrue
                this.rvPermTrueRE = "false";

                // PermFalse
                this.rvPermFalseRE = "( (" + notAct1 + "*) ;" + act1 + " ; (true*) )";
                break;
            }

            case ABSENCE2 -> {
                stringFormula = "!(F( "+ act1 +" && F ("+ act1 +") )  ) ";

                //TempTrue
                this.rvTempTrueRE = "( ("+allOthers+"*) + ( ("+allOthers+"*) ;"+act1+" ; ("+allOthers+"*)) )";

                //TempFalse
                this.rvTempFalseRE = "false";

                //PermTrue
                this.rvPermTrueRE = "false";

                //PermFalse
                this.rvPermFalseRE = "( ("+allOthers+"*) ; "+act1+" ; ("+allOthers+"*) ; "+act1+" ; (true*)) ";

                break;
            }

            case EXISTENCE -> {
                stringFormula = "F(" + act1 + ")";

                //TempTrue
                this.rvTempTrueRE = "false";

                //TempFalse
                this.rvTempFalseRE = "(" +allOthers+"*)";

                //PermTrue
                this.rvPermTrueRE = "( ("+allOthers+"*) ; "+act1+" ; (true*) )";

                //PermFalse
                this.rvPermFalseRE = "false";

                break;
            }

            case RESPONSE -> {
                stringFormula = "G ( "+act1+" -> (F "+act2+")) ";

                //TempTrue
                this.rvTempTrueRE = "(( ("+notAct1+") + ( "+act1+" ; (("+notAct2+")*) ; "+act2+" ) )*)";

                //TempFalse
                this.rvTempFalseRE = "(   (( ("+notAct1+") + ( "+act1+" ; (("+notAct2+")*) ; "+act2+" ) )*) ; "+act1+" ; ( ("+notAct2+")* )  )";

                //PermTrue
                this.rvPermTrueRE = "false";

                //PermFalse
                this.rvPermFalseRE = "false";

                break;
            }

            case RESPONDED_EXISTENCE -> {
                stringFormula = "(F "+act1+") -> (F "+act2+")";

                //TempTrue
                this.rvTempTrueRE = "("+allOthers+")*";


                //TempFalse
                this.rvTempFalseRE = "( ("+allOthers+"*) ; "+act1+" ; (("+notAct2+")*) )";


                //PermTrue
                this.rvPermTrueRE = " ( ("+allOthers+"*) ; "+act2+" ; (true*) ) + ( ("+allOthers+"*) ; "+act1+"  ;  (("+notAct2+")*)  ;  "+act2+"  ;  (true*)  ) ";


                //PermFalse
                this.rvPermFalseRE = "false";

                break;
            }

            case PRECEDENCE -> {
                stringFormula = "(!b) W a";

                //TempTrue
                this.rvPermTrueRE = "("+allOthers+"*)";

                //TempFalse
                this.rvTempFalseRE = "false";

                //PermTrue
                this.rvPermTrueRE = " ("+allOthers+"*) ; "+act1+" ; (true*) ";

                //PermFalse
                this.rvPermFalseRE = " ("+allOthers+"*) ; "+act2+" ; (true*) ";

                break;
            }

            case ALTERNATING_RESPONSE -> {
                stringFormula = "G("+act1+" -> ( X ( (!"+act1+") U "+act2+" ) ) )";

                //TempTrue
                this.rvTempTrueRE = "( ( ("+notAct1+") + ( "+act1+" ; ("+allOthers+"*) ; "+act2+")  ) *)";

                //TempFalse
                this.rvTempFalseRE = "( ( ("+notAct1+") + ( "+act1+" ; ("+allOthers+"*) ; "+act2+")  ) *) ; "+act1+" ; ("+allOthers+"*)";

                //PermTrue
                this.rvPermTrueRE = "false";

                //PermFalse
                this.rvTempFalseRE = " ( ( ("+notAct1+") + ( "+act1+" ; ("+allOthers+"*) ; "+act2+")  ) *) ; "+act1+" ; ("+allOthers+"*) ; "+act1+" ; (true*)";
                break;
            }

            case ALTERNATING_PRECEDENCE -> {
                stringFormula = "((!"+act2+") W "+act1+") && (G( "+act2+" -> ( X((!"+act2+") W "+act2+")) ))";

                //TempTrue
                this.rvTempTrueRE = "("+allOthers+"*) + ( ("+allOthers+"*) ; "+act1+"  ; (( "+notAct2+" + ("+act2+" ; ("+allOthers+"*) ; "+act1+" ) )*) ) ";

                //TempFalse
                this.rvTempFalseRE = " ("+allOthers+"*) ; "+act1+" ; (( "+notAct2+" + ("+act2+" ; ("+allOthers+"*) ; "+act1+") )*) ; "+act2+"  ; ("+allOthers+"*) ";

                //PermTrue
                this.rvPermTrueRE = "false";

                //PermFalse
                this.rvPermFalseRE = "( ("+allOthers+"*) ; "+act2+" ; (true*)) + ( ("+allOthers+"*) ; "+act1+" ; (( "+notAct2+" + ( "+act2+" ; ("+allOthers+"*) ; "+act1+" ) )*)  ; "+act2+" ; ("+allOthers+"*) ;  "+act2+"  ; (true*) ) ";
                break;
            }

            case CHAIN_RESPONSE -> {
                stringFormula = "G("+act1+" -> (X "+act2+"))";

                //TempTrue
                this.rvPermTrueRE = "( "+notAct1+" + ( "+act1+" ; "+act2+" ) )*";

                //TempFalse
                this.rvTempFalseRE = " (( "+notAct1+" + ( "+act1+" ; "+act2+" ) )*) ; "+act1+" ";

                //PermTrue
                this.rvPermTrueRE = "false";

                //PermFalse
                this.rvPermFalseRE = " (( "+notAct1+" + ("+act1+";"+act2+") )*) ; "+act1+" ; "+notAct2+" ; (true*)";

                break;
            }

            case CHAIN_PRECEDENCE -> {
                stringFormula = "G ( (X "+act2+") -> "+act1+")";

                //TempTrue
                this.rvTempTrueRE = " (( "+allOthers+" + ( "+act1+" ; ("+act1+"*) ; "+notAct1+" ) )*) ; ("+act1+"*) ";

                //TempFalse
                this.rvTempFalseRE = "false";

                //PermTrue
                this.rvPermTrueRE = "false";

                //PermFalse
                this.rvPermFalseRE = "(( "+allOthers+" + ( "+act1+" ; ("+act1+"*) ; "+notAct1+") )*) ;"+act2+" ; (true*)";

                break;
            }

            case NOT_COEXISTENCE -> {
                stringFormula = "!( (F "+act1+") && (F "+act2+") )";

                //TempTrue
                this.rvTempTrueRE = "( ("+allOthers+"*) ) + ( ("+allOthers+"*) ; "+act1+" ; ("+notAct2+"*) ) + ( ("+allOthers+"*) ; "+act2+" ; ("+notAct1+"*))";

                //TempFalse
                this.rvTempFalseRE = "false";

                //PermTrue
                this.rvPermTrueRE = "false";

                //PermFalse
                this.rvPermFalseRE = "( ("+allOthers+"*) ; "+act1+" ; ("+notAct2+"*)  ; "+act2+"  ; (true*) ) + ()";

                break;
            }

            case NEGATED_SUCCESSION -> {
                stringFormula = "G("+act1+" -> (!(F "+act2+")))";

                //TempTrue
                this.rvTempTrueRE = " ("+notAct1+"*) + ( ("+notAct1+"*) ; "+act1+" ; ("+notAct2+"*) ) ";

                //TempFalse
                this.rvTempFalseRE = "false";

                //PermTrue
                this.rvPermTrueRE = "false";

                //PermFalse
                this.rvPermFalseRE = " ("+notAct1+"*) ; "+act1+" ; ("+notAct2+"*)  ; "+act2+"  ; (true*)";

                break;
            }

            /*
            case NEGATED_ALTERNATING_SUCCESSION -> {

               //stringFormula = ?

                //TempTrue
                this.rvTempTrueRE = " (( "+notAct1+"  + ( "+act1+" ; "+notAct2+" ) )*)  ;  (( \"+notAct1+\"  + ( \"+act1+\" ; \"+notAct2+\" ) )*)  ; "+act1+" ";

                //TempFalse
                this.rvTempFalseRE = "ff";

                //PermTrue
                this.rvPermTrueRE = "ff";

                //PermFalse
                this.rvPermFalseRE = " (( "+notAct1+" + ( "+act1+" ; "+notAct2+" )  )*)  ; "+act1+"  ; "+act2+"  ; (true*) ";

            }*/

            case INITIAL -> {
                stringFormula = act1;

                //TempTrue
                this.rvTempTrueRE = "false";

                //TempFalse
                this.rvTempFalseRE = "eps";

                //PermTrue
                this.rvPermTrueRE = " "+act1+" ; (true*) ";

                //PermFalse
                this.rvPermFalseRE = " "+notAct1+" ; (true*) ";

                break;
            }

            case FINAL -> {
                stringFormula = "(X true) && (G (last -> "+act1+") )";

                //TempTrue
                this.rvTempTrueRE = " (("+notAct1+" + ("+act1+";"+notAct1+") )*) ; "+act1+"";

                //TempFalse
                this.rvTempFalseRE = " ( "+notAct1+" + ( "+act1+" ; "+notAct1+" ) )*";

                //PermTrue

                //PermFalse
                this.rvPermFalseRE = "false";

                break;
            }

            default -> throw new RuntimeException("All cases should be covered!");

        }

        this.ltlf = ParserUtils.parseLTLfFormula(stringFormula);
        this.ldlf = ltlf.toLDLf();

    }

    public LTLfFormula getLtlf() {
        return ltlf;
    }

    public LDLfFormula getLdlf() {
        return ldlf;
    }

    public String getRvTempTrue() {
        return rvTempTrueRE;
    }

    public String getRvTempFalse() {
        return rvTempFalseRE;
    }

    public String getRvPermTrue() {
        return rvPermTrueRE;
    }

    public String getRvPermFalse() {
        return rvPermFalseRE;
    }
}

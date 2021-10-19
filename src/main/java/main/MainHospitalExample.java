/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package main;

import RuntimeVerification.ExecutableAutomaton;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;
import rationals.transformations.Mix;
import rationals.transformations.Reducer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainHospitalExample {

    public static void main(String[] args) {
        try {
            int input = Integer.parseInt(args[0]);
            for(int num=1; num<input; num++) {
                hospitalExampleIncremental(num);
                System.out.println();
            }
        }
        catch (NumberFormatException exception) {
            System.out.println("Invalid input format. Please insert an integer representing the maximum number of constraints to be generated. Thirty is the bound in the paper.");
        }
    }

    public static Automaton hospitalExampleIncremental(int num) {

        long startTime = System.currentTimeMillis();

        boolean declare = true;
        boolean minimize = true;
        boolean trim = false;
        boolean printing = false;

        PropositionalSignature signature = generateSignatureInc(num);

        LTLfAutomatonResultWrapper mainAutomatonWrapper = Main.ltlfString2Aut("true", signature, declare, minimize, trim, printing);
        Automaton mainAutomaton = mainAutomatonWrapper.getAutomaton();
        //AutomatonUtils.printAutomaton(mainAutomaton, "hospitalExampleMain0.gv");

        for (int i=0; i<num; i++) {
            String currentConstraint = getConstraint(i);
            LTLfAutomatonResultWrapper currentAutomatonWrapper = Main.ltlfString2Aut(currentConstraint, signature, declare, minimize, trim, printing);
            Automaton currentAutomaton = currentAutomatonWrapper.getAutomaton();

            // WARNING!!! This might not work if the alphabet of the two automata is not the same!
            mainAutomaton = new Mix<>().transform(mainAutomaton, currentAutomaton);
            mainAutomaton = new Reducer<>().transform(mainAutomaton);
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time for bulding the optimized automaton for "+ num +" activities is: " + elapsedTime + " ms");
        System.out.println("Automaton size = " + mainAutomaton.states().size() + " #states and " + mainAutomaton.delta().size() + " #transitions");

        System.out.print("Running compliant trace... ");
        List<String> complLog = generateCompliantLogInc(num);
        //System.out.println(complLog);
        runTrace(mainAutomaton, complLog);
        //System.out.println();
        System.out.print("Running uncompliant trace... ");
        List<String> uncomplLog = generateUncompliantLogInc(num);
        //System.out.println(uncomplLog);
        runTrace(mainAutomaton, uncomplLog);

        return mainAutomaton;
    }

    public static PropositionalSignature generateSignatureInc(int num) {
        int currIter = Math.floorDiv(num, 11);

        PropositionalSignature signature = new PropositionalSignature();
        int i=0;
        do {
            Proposition lt = new Proposition("lt" + i); //0
            Proposition re = new Proposition("re" + i); //1
            Proposition fha = new Proposition("fha" + i); //2
            Proposition ps = new Proposition("ps" + i); //3
            Proposition os = new Proposition("os" + i); //4
            Proposition o = new Proposition("o" + i); //5
            Proposition iht = new Proposition("iht" + i); //6
            Proposition he = new Proposition("he" + i); //7
            Proposition n = new Proposition("n" + i); //8
            Proposition fu = new Proposition("fu" + i); //9
            Proposition fhaNext = new Proposition("fha" + (i + 1)); //10

            signature.add(lt);
            signature.add(re);
            signature.add(fha);
            signature.add(ps);
            signature.add(os);
            signature.add(o);
            signature.add(iht);
            signature.add(he);
            signature.add(n);
            signature.add(fu);
            signature.add(fhaNext);

            i++;
        } while(i<=currIter);

        return signature;
    }

    public static String getConstraint(int num) {
        String[] constraints = new String[14];

        int currIter = Math.floorDiv(num, 14);
        int currConstraint = num % 14;

        constraints[0] = "( (!fha"+currIter+" ) U re"+currIter+" ) || ( G(!fha"+currIter+") )";
        constraints[1] = "( (!fha"+currIter+") U lt"+currIter+" ) || ( G(!fha"+currIter+") )";
        constraints[2] = "( (!ps"+currIter+") U fha"+currIter+" ) || ( G(!ps"+currIter+") )";
        constraints[3] = "( (!os"+currIter+") U ps"+currIter+" ) || ( G(!os"+currIter+") )";
        constraints[4] = "( (!o"+currIter+") U ps"+currIter+" ) || ( G(!o"+currIter+") )";
        constraints[5] = "( (!iht"+currIter+") U ps"+currIter+" ) || ( G(!iht"+currIter+") )";

        constraints[6] = "((F os"+currIter+") || (F o"+currIter+")) && (!( (F os"+currIter+") && (F o"+currIter+") ))";

        constraints[7] = "(F iht"+currIter+") -> (F o"+currIter+")";
        constraints[8] = "(F he"+currIter+") -> (F o"+currIter+")";

        constraints[9] = "G(os"+currIter+" -> (X (F n"+currIter+") ) )";
        constraints[10] = "G(o"+currIter+" -> (X (F n"+currIter+") ) )";
        constraints[11] = "G(iht"+currIter+" -> (X (F n"+currIter+") ) )";

        constraints[12] = "( G(n"+currIter+" -> (X (F fu"+currIter+"))) ) && ( ( (!fu"+currIter+") U n"+currIter+") || (G (!fu"+currIter+")))";

        constraints[13] = "( ( (!fha"+(currIter+1)+") U fu"+(currIter)+" ) || (G (!fha"+(currIter+1)+" )))";

        //System.out.println(constraints[currConstraint]);
        return constraints[currConstraint];
    }

    public static List<String> generateCompliantLogInc(int num) {
        // From Fab:
        // RE - LT - FHA - PS - IHT - HE - O - N - FU - RE - LT - PS - O - N – FU

        List<String> result = new LinkedList<>();

        int currIter = Math.floorDiv(num, 14);
        int i=0;
        do {
            result.add("re" + i); //0
            result.add("lt" + i); //1
            result.add("fha" + i); //2
            result.add("ps" + i);  //3
            result.add("iht" + i); //4
            result.add("he" + i);  //5
            result.add("o" + i);  //6
            result.add("n" + i);  //7
            result.add("fu" + i); //8
            result.add("re" + i); //9
            result.add("lt" + i); //10
            result.add("ps" + i); //11
            result.add("o" + i); //12
            result.add("n" + i); //13
            result.add("fu" + i); //14
            i++;
        } while (i<=currIter);
        return result.subList(0, num);
    }

    public static List<String> generateUncompliantLogInc(int num) {
        // From Fab:
        // RE - LT - FHA - PS - IHT - HE - O - N - FU - RE - LT - PS - OS - N – FU

        List<String> result = new LinkedList<>();
        int currIter = Math.floorDiv(num, 15);
        int i=0;
        do {
            result.add("re"+i); //0
            result.add("lt"+i); //1
            result.add("fha"+i); //2
            result.add("ps"+i);  //3
            result.add("iht"+i); //4
            result.add("he"+i); //5
            result.add("o"+i); //6
            result.add("n"+i); //7
            result.add("fu"+i); //8
            result.add("re"+i); //9
            result.add("lt"+i); //10
            result.add("ps"+i); //11
            result.add("os"+i); //12
            result.add("n"+i); //13
            result.add("fu"+i); //14
            i++;
        } while (i<=currIter);
        return result.subList(0, num);
    }


    public static Automaton hospitalExampleOptimized(int numIter) {
        long startTime = System.currentTimeMillis();

        Automaton result = hospitalExampleOptimizedAux(0);
        for (int i = 1; i < numIter; i++) {
            Automaton currAutomaton = hospitalExampleOptimizedAux(i);
            Automaton newAutomaton = new Mix<>().transform(result, currAutomaton);
            newAutomaton = new Reducer<>().transform(newAutomaton);
            result = newAutomaton;
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time for bulding the optimized automaton for "+ numIter +" constraints is: " + elapsedTime + " ms");

        System.out.println("Running compliant trace...");
        List<String> complLog = generateCompliantLog(numIter);
        System.out.println(complLog);
        runTrace(result, complLog);
        System.out.println();
        System.out.println("Running uncompliant trace...");
        List<String> uncomplLog = generateUncompliantLog(numIter);
        System.out.println(uncomplLog);
        runTrace(result, uncomplLog);

        return result;
    }

    public static Automaton hospitalExampleOptimizedAux(int currIter) {

        //long startTime = System.currentTimeMillis();

        boolean declare = true;
        boolean minimize = true;
        boolean trim = false;
        boolean printing = false;

        /*
        0- precedence(RE,FHA) = (!FHA U RE)  \/  [](!FHA)
        1- precedence(LT,FHA) = (!FHA U LT)  \/  [](!FHA)
        2- precedence(FHA,PS) = (!PS U FHA)  \/  [](!PS)
        3- precedence(PS,OS) = (!OS U PS)  \/  [](!OS)
        4- precedence(PS,O) = (!O U PS)  \/  [](!O)
        5- precedence(PS,IHT) = (!IHT U PS)  \/  [](!IHT)

        6- exclusive choice (OS,O) = (<>(OS) \/ <>(O)) /\ !(<>(OS) /\ <>(O))

        7- responded existence (IHT,O) = <>(IHT) -> <>(O)
        8- responded existence (HE,O) = <>(HE) -> <>(O)

        9- response(OS,N) = [](OS -> X<>(N))
        10- response(O,N) = [](O -> X<>(N))
        11- response (IHT,N) = [](IHT -> X<>(N))

        12- succession (N,FU) = ([](N -> X<>(FU))) /\  ( (!FU U N) \/ [](!FU) )
        */

        String firstConstraint;

        String constraint0 = "( (!fha"+currIter+" ) U re"+currIter+" ) || ( G(!fha"+currIter+") )";
        String constraint1 = "( (!fha"+currIter+") U lt"+currIter+" ) || ( G(!fha"+currIter+") )";
        String constraint2 = "( (!ps"+currIter+") U fha"+currIter+" ) || ( G(!ps"+currIter+") )";
        String constraint3 = "( (!os"+currIter+") U ps"+currIter+" ) || ( G(!os"+currIter+") )";
        String constraint4 = "( (!o"+currIter+") U ps"+currIter+" ) || ( G(!o"+currIter+") )";
        String constraint5 = "( (!iht"+currIter+") U ps"+currIter+" ) || ( G(!iht"+currIter+") )";

        String constraint6 = "((F os"+currIter+") || (F o"+currIter+")) && (!( (F os"+currIter+") && (F o"+currIter+") ))";

        String constraint7 = "(F iht"+currIter+") -> (F o"+currIter+")";
        String constraint8 = "(F he"+currIter+") -> (F o"+currIter+")";

        String constraint9 = "G(os"+currIter+" -> (X (F n"+currIter+") ) )";
        String constraint10 = "G(o"+currIter+" -> (X (F n"+currIter+") ) )";
        String constraint11 = "G(iht"+currIter+" -> (X (F n"+currIter+") ) )";

        String constraint12 = "( G(n"+currIter+" -> (X (F fu"+currIter+"))) ) && ( ( (!fu"+currIter+") U n"+currIter+") || (G (!fu"+currIter+")))";

        if (currIter==0)
            firstConstraint = constraint0;
        else
            firstConstraint = "( ( (!fha"+currIter+") U fu"+(currIter-1)+" ) || (G (!fha"+currIter+" )))";

        /*
            In the trace there is activity lt which does not appearing in any constraint,
            therefore, I have to manually add it.
         */
        PropositionalSignature signature = new PropositionalSignature();
        Proposition lt = new Proposition("lt"+currIter);
        Proposition re = new Proposition("re"+currIter);
        Proposition fha = new Proposition("fha"+currIter);
        Proposition ps = new Proposition("ps"+currIter);
        Proposition os = new Proposition("os"+currIter);
        Proposition o = new Proposition("o"+currIter);
        Proposition iht = new Proposition("iht"+currIter);
        Proposition he = new Proposition("he"+currIter);
        Proposition n = new Proposition("n"+currIter);
        Proposition fu = new Proposition("fu"+currIter);

        if (currIter!=0) {
            Proposition fuPrevious = new Proposition("fu"+(currIter-1));
            signature.add(fuPrevious);
        }
        signature.add(lt);
        signature.add(re);
        signature.add(fha);
        signature.add(ps);
        signature.add(os);
        signature.add(o);
        signature.add(iht);
        signature.add(he);
        signature.add(n);
        signature.add(fu);

        List<String> constraintList = new LinkedList<>();
        if (currIter!=0)
            constraintList.add(constraint0);
        constraintList.add(constraint1);
        constraintList.add(constraint2);
        constraintList.add(constraint3);
        constraintList.add(constraint4);
        constraintList.add(constraint5);
        constraintList.add(constraint6);
        constraintList.add(constraint7);
        constraintList.add(constraint8);
        constraintList.add(constraint9);
        constraintList.add(constraint10);
        constraintList.add(constraint11);
        constraintList.add(constraint12);

        LTLfAutomatonResultWrapper mainAutomatonWrapper = Main.ltlfString2Aut(firstConstraint, signature, declare, minimize, trim, printing);
        Automaton mainAutomaton = mainAutomatonWrapper.getAutomaton();
        //AutomatonUtils.printAutomaton(mainAutomaton, "hospitalExampleMain0.gv");

        //int i = 1;
        Iterator it = constraintList.listIterator();
        while(it.hasNext()) {
            String currentConstraint = (String) it.next();
            //System.out.println("Constraint"+i+"= " + currentConstraint);
            LTLfAutomatonResultWrapper currentAutomatonWrapper = Main.ltlfString2Aut(currentConstraint, signature, declare, minimize, trim, printing);
            Automaton currentAutomaton = currentAutomatonWrapper.getAutomaton();
            //AutomatonUtils.printAutomaton(currentAutomaton, "hospitalExample" + i + ".gv");

            // WARNING!!! This might not work if the alphabet of the two automata is not the same!
            mainAutomaton = new Mix<>().transform(mainAutomaton, currentAutomaton);
            mainAutomaton = new Reducer<>().transform(mainAutomaton);

            //AutomatonUtils.printAutomaton(mainAutomaton, "hospitalExampleMain" + i +".gv");
            //i++;
        }

        //long elapsedTime = System.currentTimeMillis() - startTime;
        //System.out.println("Time for bulding the optimized automaton is: " + elapsedTime + " ms");
        //AutomatonUtils.printAutomaton(mainAutomaton, "hospitalExampleOptimized.gv");
        return mainAutomaton;
    }

    public static List<String> generateCompliantLog(int numIter) {
        // From Fab:
        // RE - LT - FHA - PS - IHT - HE - O - N - FU - RE - LT - PS - O - N – FU

        List<String> result = new LinkedList<>();

        for (int i=0; i<numIter; i++) {
            result.add("re"+i);
            result.add("lt"+i);
            result.add("fha"+i);
            result.add("ps"+i);
            result.add("iht"+i);
            result.add("he"+i);
            result.add("o"+i);
            result.add("n"+i);
            result.add("fu"+i);
            result.add("re"+i);
            result.add("lt"+i);
            result.add("ps"+i);
            result.add("o"+i);
            result.add("n"+i);
            result.add("fu"+i);
        }
        return result;
    }

    public static List<String> generateUncompliantLog(int num) {
        // From Fab:
        // RE - LT - FHA - PS - IHT - HE - O - N - FU - RE - LT - PS - OS - N – FU

        List<String> result = new LinkedList<>();

        for (int i=0; i<num; i++) {
            result.add("re"+i);
            result.add("lt"+i);
            result.add("fha"+i);
            result.add("ps"+i);
            result.add("iht"+i);
            result.add("he"+i);
            result.add("o"+i);
            result.add("n"+i);
            result.add("fu"+i);
            result.add("re"+i);
            result.add("lt"+i);
            result.add("ps"+i);
            result.add("os"+i);
            result.add("n"+i);
            result.add("fu"+i);
        }
        return result;
    }

    public static void runTrace(Automaton automaton, List<String> log) {
        long startTime = System.currentTimeMillis();
        ExecutableAutomaton exAut = new ExecutableAutomaton(automaton);

        Iterator it = log.listIterator();
        while(it.hasNext()) {
            String currentEvent = (String) it.next();

            exAut.step(currentEvent);

           //if (!it.hasNext())
                //System.out.println("After last event "+currentEvent+" the RV state is "+exAut.currentRVTruthValue());
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(elapsedTime + " ms");
    }
}

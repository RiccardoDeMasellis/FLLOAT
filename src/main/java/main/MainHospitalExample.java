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
import utils.AutomatonUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainHospitalExample {

    public static void main(String[] args) {
        Automaton optimized = hospitalExampleOptimized();
        System.out.println("Running compliant trace");
        runTrace(optimized, generateCompliantLog());
        System.out.println("Running uncompliant trace");
        runTrace(optimized, generateUncompliantLog());

//        Automaton naive = hospitalExampleNaive();
//
//        Automaton naiveCopy = new Identity<>().transform(naive);
//        Automaton optimizedCopy = new Identity<>().transform(optimized);
//
//        /*
//        Are the two the same automaton?
//         */
//        // Test 1: naive AND (NOT optimized) = empty?
//
//        Automaton notOptimized = new Complement<>().transform(optimizedCopy);
//        // WARNING: Mix might not work if the languages of the two automata is different!
//        Automaton test1 = new Mix<>().transform(naive, notOptimized);
//        AutomatonUtils.printAutomaton(test1, "test1.gv");
//
//        // Test 2: (NOT naive) AND optimized = empty?
//        Automaton notNaive = new Complement<>().transform(naive);
//        // WARNING! Mix might not work if the langugages of the two automata is different!
//        Automaton test2 = new Mix<>().transform(notNaive, optimized);
//        AutomatonUtils.printAutomaton(test2, "test2.gv");

    }

    public static Automaton hospitalExampleNaive() {
        long startTime = System.currentTimeMillis();

        boolean declare = true;
        boolean minimize = true;
        boolean trim = false;
        boolean printing = false;

        String constraint0 = "( (!fha) U re) || G(!fha)";
        String constraint1 = "( (!fha) U lt) || G(!fha)";
        String constraint2 = "( (!ps) U fha) || G(!ps)";
        String constraint3 = "( (!os) U ps) || G(!os)";
        String constraint4 = "( (!o) U ps) || G(!o)";
        String constraint5 = "( (!iht) U ps) || G(!iht)";

        String constraint6 = "((F os) || (F o)) && (!( (F os) && (F o) ))";

        String constraint7 = "(F iht) -> (F o)";
        String constraint8 = "(F he) -> (F o)";

        String constraint9 = "G(os -> (X (F n) ) )";
        String constraint10 = "G(o -> (X (F n) ) )";
        String constraint11 = "G(iht -> (X (F n) ) )";

        String constraint12 = "( G(n -> (X (F fu))) ) && ( ( (!fu) U n) || (G (!fu)))";

        /*
            In the trace there is activity lt which does not appearing in any constraint,
            therefore, I have to manually add it.
         */
        PropositionalSignature signature = new PropositionalSignature();
        Proposition lt = new Proposition("lt");
        signature.add(lt);

        List<String> constraintList = new LinkedList<>();
        //constraintList.add(constraint0);
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

        Iterator it = constraintList.listIterator();

        String mainConstraint = "(" + constraint0 + ")";
        while (it.hasNext()) {
            mainConstraint = mainConstraint + " && " + "(" + it.next() + ")";
        }

        LTLfAutomatonResultWrapper mainAutomatonWrapper = Main.ltlfString2Aut(mainConstraint, signature, declare, minimize, trim, printing);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time for naive is: " + elapsedTime + " ms");
        AutomatonUtils.printAutomaton(mainAutomatonWrapper.getAutomaton(), "hospitalExampleNaive.gv");
        return mainAutomatonWrapper.getAutomaton();
    }


    public static Automaton hospitalExampleOptimized() {

        long startTime = System.currentTimeMillis();

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

        String constraint0 = "( (!fha) U re ) || ( G(!fha) )";
        String constraint1 = "( (!fha) U lt ) || ( G(!fha) )";
        String constraint2 = "( (!ps) U fha ) || ( G(!ps) )";
        String constraint3 = "( (!os) U ps ) || ( G(!os) )";
        String constraint4 = "( (!o) U ps ) || ( G(!o) )";
        String constraint5 = "( (!iht) U ps ) || ( G(!iht) )";

        String constraint6 = "((F os) || (F o)) && (!( (F os) && (F o) ))";

        String constraint7 = "(F iht) -> (F o)";
        String constraint8 = "(F he) -> (F o)";

        String constraint9 = "G(os -> (X (F n) ) )";
        String constraint10 = "G(o -> (X (F n) ) )";
        String constraint11 = "G(iht -> (X (F n) ) )";

        String constraint12 = "( G(n -> (X (F fu))) ) && ( ( (!fu) U n) || (G (!fu)))";

        /*
            In the trace there is activity lt which does not appearing in any constraint,
            therefore, I have to manually add it.
         */
        PropositionalSignature signature = new PropositionalSignature();
        Proposition lt = new Proposition("lt");
        Proposition re = new Proposition("re");
        Proposition fha = new Proposition("fha");
        Proposition ps = new Proposition("ps");
        Proposition os = new Proposition("os");
        Proposition o = new Proposition("o");
        Proposition iht = new Proposition("iht");
        Proposition he = new Proposition("he");
        Proposition n = new Proposition("n");
        Proposition fu = new Proposition("fu");

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
        //constraintList.add(constraint0);
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

        LTLfAutomatonResultWrapper mainAutomatonWrapper = Main.ltlfString2Aut(constraint0, signature, declare, minimize, trim, printing);
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

            //AutomatonUtils.printAutomaton(mainAutomaton, "hospitalExampleMain" + i +".gv");
            //i++;
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time for optimized is: " + elapsedTime + " ms");
        AutomatonUtils.printAutomaton(mainAutomaton, "hospitalExampleOptimized.gv");
        return mainAutomaton;
    }

    public static List<String> generateCompliantLog() {
        // From Fab:
        // RE - LT - FHA - PS - IHT - HE - O - N - FU - RE - LT - PS - O - N – FU

        List<String> result = new LinkedList<>();
        result.add("re");
        result.add("lt");
        result.add("fha");
        result.add("ps");
        result.add("iht");
        result.add("he");
        result.add("o");
        result.add("n");
        result.add("fu");
        result.add("re");
        result.add("lt");
        result.add("ps");
        result.add("o");
        result.add("n");
        result.add("fu");

        return result;
    }

    public static List<String> generateUncompliantLog() {
        // From Fab:
        // RE - LT - FHA - PS - IHT - HE - O - N - FU - RE - LT - PS - OS - N – FU

        List<String> result = new LinkedList<>();
        result.add("re");
        result.add("lt");
        result.add("fha");
        result.add("ps");
        result.add("iht");
        result.add("he");
        result.add("o");
        result.add("n");
        result.add("fu");
        result.add("re");
        result.add("lt");
        result.add("ps");
        result.add("os");
        result.add("n");
        result.add("fu");

        return result;
    }

    public static void runTrace(Automaton automaton, List<String> log) {
        long startTime = System.currentTimeMillis();
        ExecutableAutomaton exAut = new ExecutableAutomaton(automaton);

        Iterator it = log.listIterator();
        while(it.hasNext()) {
            String currentEvent = (String) it.next();

            exAut.step(currentEvent);

            System.out.println("After event "+currentEvent+" the RV state is "+exAut.currentRVTruthValue());
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Elapsed time for running the log is: " + elapsedTime + " ms");
    }
}

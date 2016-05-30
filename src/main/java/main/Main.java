/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package main;

import RuntimeVerification.ExecutableAutomaton;
import antlr4_generated.LDLfFormulaParserLexer;
import antlr4_generated.LDLfFormulaParserParser;
import antlr4_generated.LTLfFormulaParserLexer;
import antlr4_generated.LTLfFormulaParserParser;
import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import rationals.Automaton;
import rationals.transformations.Reducer;
import utils.AutomatonUtils;
import visitors.LDLfVisitors.LDLfVisitor;
import visitors.LTLfVisitors.LTLfVisitor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Riccardo De Masellis on 22/07/15.
 */
public class Main {

    public static void main(String[] args) {
        //ldlf2Aut();
        ltlf2Aut();
    }


    public static void ldlf2Aut() {
        //String input = "[true*](([true]ff) || (<!a>tt) || (<true*>(<b>tt)))";
        String input = "<((a)*)*>b";

        /*
        Parsing
         */
        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        System.out.println(tree.toStringTree(parser));

        LDLfVisitor visitor = new LDLfVisitor();

        LDLfFormula formula = visitor.visit(tree);

        /*
        Automaton construction method invocation
         */
        PropositionalSignature signature = formula.getSignature();
        Proposition w = new Proposition("w");
        Proposition x = new Proposition("x");
        Proposition y = new Proposition("y");
        Proposition z = new Proposition("z");
        signature.add(w);
        signature.add(x);
        signature.add(y);
        signature.add(z);

        //System.out.println(formula);

        Automaton automaton = AutomatonUtils.ldlf2Automaton(formula, formula.getSignature());

        /*
        Determinization! WARNING! IT USE THE JAUTOMATA LIBRARY (not tested if works properly)!
         */
        //automaton = new ToDFA<>().transform(automaton);


        automaton = AutomatonUtils.eliminateEmptyTrace(automaton);


        /*
        Minimization! WARNING! IT USE THE JAUTOMATA LIBRARY (not tested if works properly)!
         */
        automaton = new Reducer<>().transform(automaton);

        /*
        Printing
         */
        //System.out.println(automaton);


        /*
        Printing to .gv (graphviz) file
         */
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("ldlfAutomaton.gv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        ps.println(AutomatonUtils.toDot(automaton));
        ps.flush();
        ps.close();
    }


    public static void ltlf2Aut() {
        /*
        Input
         */
        //String input = "(a R b)";
        String input = "G (a -> (F b))";
        //String input = "(F((a U (b|c)) R ((X e) || ((WX f) && (G h) ) ) )) -> ((F d) R (((g)||(i)) U (l)))";
        //String input = "(G(rl -> (F aa))) & (G(aa -> (F dl))) & (G(aa -> (X dl)))";
        //String input = "(G(rl -> (F aa))) & (G(aa -> (X dl)))";

        /*
        Parsing
         */
        LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        LTLfVisitor visitor = new LTLfVisitor();
        LTLfFormula formula = visitor.visit(tree);

        /*
        Translation to ldlf!
         */
        LTLfFormula antinnfFormula = formula.antinnf();
        System.out.println("Antinnf: " + antinnfFormula);

        LDLfFormula ldlff = antinnfFormula.toLDLf();
        System.out.println("To LDLF: " + ldlff);

        /*
        Automaton construction method invocation
         */
        //Automaton automaton = AutomatonUtils.ldlf2AutomatonDeclare(ldlff, ldlff.getSignature());
        Automaton automaton = AutomatonUtils.ldlf2Automaton(ldlff, ldlff.getSignature());
        //System.out.println(automaton);

        /*
        Determinization! WARNING! IT USE THE JAUTOMATA LIBRARY (not tested if works properly)!
         */
        //automaton = new ToDFA<>().transform(automaton);
        //automaton = AutomatonUtils.declareAssumption(automaton);
        /*
        Minimization! WARNING! IT USE THE JAUTOMATA LIBRARY (not tested if works properly)!
         */


        automaton = AutomatonUtils.eliminateEmptyTrace(automaton);

        automaton = new Reducer<>().transform(automaton);




        /*
        Printing
         */
        //System.out.println(automaton);
        System.out.println("Number of states: " + automaton.states().size());
        System.out.println("Number of transitions: " + automaton.delta().size());


        /*
        Printing to .gv (graphviz) file
         */
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("ltlfAutomaton.gv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        ps.println(AutomatonUtils.toDot(automaton));
        ps.flush();
        ps.close();

        //provaExecutableAutomaton(automaton);

    }


    public static void provaExecutableAutomaton(Automaton a) {
        ExecutableAutomaton ea = new ExecutableAutomaton(a);
        System.out.println("Current state: " + ea.getCurrentState());
        System.out.println("Current state value: " + ea.currentRVTruthValue());
        System.out.println("outgoing good transition: ");
        System.out.println(ea.notFailingOutgoingTransitions(ea.getCurrentState()));
        //System.out.println(ea.declareNotFailingEvents());
        System.out.println("Performing transition a");
        ea.step("a");
        System.out.println("Current state: " + ea.getCurrentState());
        System.out.println("Current state value: " + ea.currentRVTruthValue());
        System.out.println("outgoing good transition: ");
        System.out.println(ea.notFailingOutgoingTransitions(ea.getCurrentState()));
        //System.out.println(ea.declareNotFailingEvents());

        System.out.println("Performing transition EmptyTrace");
        ea.step("EmptyTrace");
        System.out.println("Current state: " + ea.getCurrentState());
        System.out.println("Current state value: " + ea.currentRVTruthValue());
//
//        System.out.println("Performing transition c");
//        ea.step("c");
//        System.out.println(ea.getCurrentState());
//        System.out.println(ea.currentRVTruthValue());
//
//        System.out.println("Performing transition c");
//        ea.step("c");
//        System.out.println(ea.getCurrentState());
//        System.out.println(ea.currentRVTruthValue());
    }
}

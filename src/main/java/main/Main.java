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
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import rationals.Automaton;
import rationals.transformations.Pruner;
import rationals.transformations.Reducer;
import utils.AutomatonUtils;
import visitors.LDLfVisitors.LDLfVisitor;
import visitors.LTLfVisitors.LTLfVisitor;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Riccardo De Masellis on 22/07/15.
 */
public class Main {


    public static void ldlf2Aut(String input, PropositionalSignature signature, boolean declare, boolean minimize, boolean trim, boolean noEmptyTrace, boolean printing) {

        /*
        Parsing
         */
        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        System.out.println(tree.toStringTree(parser));

        LDLfVisitor visitor = new LDLfVisitor();

        LDLfFormula formula = visitor.visit(tree);

        Automaton automaton;

        /*
        Check signature parameter
         */
        if (signature==null)
            signature = formula.getSignature();

        /*
        Actual automaton construction
         */
        if(declare)
            automaton = AutomatonUtils.ldlf2AutomatonDeclare(formula, signature);
        else
            automaton = AutomatonUtils.ldlf2Automaton(formula, signature);

        // TRANSFORMATION
        automaton = transformations(automaton, minimize, trim, noEmptyTrace);


        if(printing)
            System.out.println(automaton);


        printAutomaton(automaton, true);
    }


    public static void ltlf2Aut(String input, PropositionalSignature signature, boolean declare, boolean minimize, boolean trim, boolean noEmptyTrace, boolean printing) {

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

        Automaton automaton;

        /*
        Check signature parameter
         */
        if (signature == null)
            signature = formula.getSignature();

        /*
        Actual automaton construction
         */
        if (declare)
            automaton = AutomatonUtils.ldlf2AutomatonDeclare(ldlff, signature);
        else
            automaton = AutomatonUtils.ldlf2Automaton(ldlff, signature);

        // TRANSFORMATION
        automaton = transformations(automaton, minimize, trim, noEmptyTrace);


        if (printing)
            System.out.println(automaton);

        printAutomaton(automaton, false);
    }



    private static void printAutomaton(Automaton automaton, boolean ldl) {
        /*
        Printing to .gv (graphviz) file
         */
        FileOutputStream fos = null;
        try {
            if(ldl)
                fos = new FileOutputStream("ldlfAutomaton.gv");
            else
                fos = new FileOutputStream("ltlfAutomaton.gv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        ps.println(AutomatonUtils.toDot(automaton));
        ps.flush();
        ps.close();
    }


    private static Automaton transformations(Automaton automaton, boolean minimize, boolean trim, boolean noEmptyTrace) {

        // WARNING! This must be called BEFORE the minimization!
        if(noEmptyTrace)
            automaton = AutomatonUtils.eliminateEmptyTrace(automaton);

        if (minimize)
            automaton = new Reducer<>().transform(automaton);

        if(trim)
            automaton = new Pruner<>().transform(automaton);

        return automaton;
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

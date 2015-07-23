/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package main;

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
        ldlf2Aut();
        //ltlf2Aut();
    }


    public static void ldlf2Aut() {
        String input = "<(a + (b ; c)) + (f ; d*)>g";

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
        Automaton automaton = AutomatonUtils.ldlf2Automaton(formula, formula.getSignature());

        /*
        Determinization! WARNING! IT USE THE JAUTOMATA LIBRARY (not tested if works properly)!
         */
        //automaton = new ToDFA<>().transform(automaton);

        /*
        Printing
         */
        System.out.println(automaton);


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
        String input = "G (a U b)";

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
        LDLfFormula ldlff = formula.toLDLf();
        System.out.println(ldlff.nnf());

        /*
        Automaton construction method invocation
         */
        Automaton automaton = AutomatonUtils.ldlf2Automaton(ldlff, ldlff.getSignature());

        /*
        Determinization! WARNING! IT USE THE JAUTOMATA LIBRARY (not tested if works properly)!
         */
        //automaton = new ToDFA<>().transform(automaton);

        /*
        Printing
         */
        System.out.println(automaton);


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
    }
}

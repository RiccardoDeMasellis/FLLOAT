/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

import antlr4_generated.LTLfFormulaParserLexer;
import antlr4_generated.LTLfFormulaParserParser;
import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import rationals.Automaton;
import rationals.properties.ModelCheck;
import rationals.transformations.Reducer;
import utils.AutomatonUtils;
import visitors.LTLfVisitors.LTLfVisitor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Riccardo De Masellis on 21/01/16.
 */
public class DeclareAutomatonTests {

    @Test
    public void declareAutomatonConstructionTest() {
         /*
        Input
         */
        //String input = "!(G (F ((a & b) U (WX (c R (X ((!d || a) WU f)))))))";
        String input = "G ((a & c) -> (F (b || c)))";
        //String input = "(F((a U (b|c)) R ((X e) || ((WX f) && (G h) ) ) )) -> ((F d) R (((g)||(i)) U (l)))";

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
        System.out.println("To LDLF: " + ldlff);

        /*
        Automaton construction method invocation
         */
        Automaton declareAutomaton = AutomatonUtils.ldlf2AutomatonDeclare(ldlff, ldlff.getSignature());
        Automaton traditionalAutomaton = AutomatonUtils.ldlf2Automaton(ldlff, ldlff.getSignature());
        traditionalAutomaton = AutomatonUtils.declareAssumption(traditionalAutomaton);
        //System.out.println(automaton);

        /*
        Determinization! WARNING! IT USE THE JAUTOMATA LIBRARY (not tested if works properly)!
         */
        //automaton = new ToDFA<>().transform(automaton);
        //automaton = AutomatonUtils.declareAssumption(automaton);
        /*
        Minimization! WARNING! IT USE THE JAUTOMATA LIBRARY (not tested if works properly)!
         */
        declareAutomaton = new Reducer<>().transform(declareAutomaton);
        traditionalAutomaton = new Reducer<>().transform(traditionalAutomaton);

        /*
        Printing to .gv (graphviz) file
         */
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("ltlfTraditionalAutomaton.gv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        ps.println(AutomatonUtils.toDot(traditionalAutomaton));
        ps.flush();
        ps.close();

        try {
            fos = new FileOutputStream("ltlfDeclareAutomaton.gv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ps = new PrintStream(fos);
        ps.println(AutomatonUtils.toDot(declareAutomaton));
        ps.flush();
        ps.close();

        boolean areEquivalent = new ModelCheck<>().test(declareAutomaton, traditionalAutomaton) &&
                                new ModelCheck<>().test(traditionalAutomaton, declareAutomaton);

        System.out.println(areEquivalent);

        Assert.assertEquals(areEquivalent, true);

    }
}

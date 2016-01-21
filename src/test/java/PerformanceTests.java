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
import org.junit.Test;
import rationals.Automaton;
import rationals.transformations.Mix;
import rationals.transformations.Reducer;
import utils.AutomatonUtils;
import visitors.LTLfVisitors.LTLfVisitor;

import java.util.HashSet;

/**
 * Created by Riccardo De Masellis on 02/12/15.
 */
public class PerformanceTests {

    @Test
    public void declarePerformances() {

        long startTime = System.currentTimeMillis();

        HashSet<String> constraints = new HashSet<>();

        /*
        Inputs
         */
        String existence = "F a";
        constraints.add(existence);
        String exclusiveChoice = "((F a) | (F b)) && !((F a) && (F b))";
        constraints.add(exclusiveChoice);
        String respondedExistence1 = "(F b) -> (F c)";
        constraints.add(respondedExistence1);
        String repondedExistence2 = "(F a) -> (F d)";
        constraints.add(repondedExistence2);
        String response1 = "G(c -> (F d))";
        constraints.add(response1);
        String response2 = "G(c -> (F e))";
        constraints.add(response2);
        String alternatePrecedence1 = "((!e) WU d) && G(e -> (X((!e) WU d)))";
        constraints.add(alternatePrecedence1);
        String alternatePrecedence2 = "((!f) WU g) && G(f -> (X((!f) WU g)))";
        constraints.add(alternatePrecedence2);
        String chainPrecendence = "G(g -> (X e))";
        constraints.add(chainPrecendence);
        String notRespExistence = "((F e) -> !(F g))";
        constraints.add(notRespExistence);
        String alternateResponse1 = "G(e -> X((!e) U h))";
        constraints.add(alternateResponse1);
        String alternateResponse2 = "G(h -> X((!h) U i))";
        constraints.add(alternateResponse2);
        String precedence = "((!i) WU a)";
        constraints.add(precedence);
        String chainResponse = "((!g) WU c)";
        constraints.add(chainResponse);

        /*
        Parsing
         */
        boolean firstIteration = true;
        Automaton oldAutomaton = null;
        Automaton newAutomaton;
        for(String c : constraints) {
            LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(c));
            LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.expression();
            LTLfVisitor visitor = new LTLfVisitor();
            LTLfFormula formula = visitor.visit(tree);

            /*
            Translation to ldlf!
            */
            LDLfFormula ldlff = formula.antinnf().toLDLf();
            //System.out.println(ldlff.nnf());

            /*
            Automaton construction method invocation
            */
            System.out.print("Automaton for " + c + "... ");
            newAutomaton = AutomatonUtils.ldlf2AutomatonDeclare(ldlff, ldlff.getSignature());


            // Determinization! WARNING! IT USE THE JAUTOMATA LIBRARY (not tested if works properly)!
            //newAutomaton = new ToDFA<>().transform(newAutomaton);
            // Determinization and minimization!
            newAutomaton = new Reducer<>().transform(newAutomaton);
            System.out.println("done!");


            if (!firstIteration) {
                long st = System.currentTimeMillis();
                System.out.print("Intersecating automaton for " + c + " with the product automaton of the previous formulas, which has " + oldAutomaton.states().size() + "states and " + oldAutomaton.delta().size() + " transitions... ");
                // Synchronous product between the new automaton and the result of the products of the others.
                newAutomaton = new Mix().transform(newAutomaton, oldAutomaton);
                long et = System.currentTimeMillis();
                System.out.println("Intersection done in " + (et - st));
            }

            oldAutomaton = newAutomaton;
            firstIteration = false;
        }

        long stopTime = System.currentTimeMillis();
        System.out.println("*******************************");
        System.out.println("*******************************");
        System.out.println("Number of states: " + oldAutomaton.states().size());
        System.out.println("Number of transitions: " + oldAutomaton.delta().size());
        System.out.println("*******************************");
        System.out.println("*******************************");
        System.out.println("Time for the declare automaton: " + (stopTime-startTime));
        System.out.println("*******************************");
        System.out.println("*******************************");
    }

}

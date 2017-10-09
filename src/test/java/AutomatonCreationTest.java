/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

import antlr4_generated.LDLfFormulaParserLexer;
import antlr4_generated.LDLfFormulaParserParser;
import antlr4_generated.LTLfFormulaParserLexer;
import antlr4_generated.LTLfFormulaParserParser;
import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Ignore;
import org.junit.Test;
import rationals.Automaton;
import utils.AutomatonUtils;
import visitors.LDLfVisitors.LDLfVisitor;
import visitors.LTLfVisitors.LTLfVisitor;

/**
 * Created by Riccardo De Masellis on 16/07/15.
 */
public class AutomatonCreationTest {

//    @Ignore
//    @Test
//    public void automatonCreationTest() {
//        String input = "<(a + (b ; c)) + (f ; d*)>g";
//        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
//        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
//        ParseTree tree = parser.expression();
//        System.out.println(tree.toStringTree(parser));
//        LDLfVisitor visitor = new LDLfVisitor();
//        LDLfFormula formula = visitor.visit(tree);
//
//        Automaton automaton = AutomatonUtils.ldlf2Automaton(formula, formula.getSignature());
//
//        System.out.println(automaton);
//
//        Automaton transformed = new ToDFA<>().transform(automaton);
//        System.out.println(transformed);
//
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream("automaton.gv");
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        PrintStream ps = new PrintStream(fos);
//        ps.println(AutomatonUtils.toDot(transformed));
//        ps.flush();
//        ps.close();
//    }


//    @Test
//    public void testIntersection() {
//        String input = "<(a + (b ; c)) + (f ; d*)>g";
//        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
//        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
//        ParseTree tree = parser.expression();
//        System.out.println(tree.toStringTree(parser));
//        LDLfVisitor visitor = new LDLfVisitor();
//        LDLfFormula formula = visitor.visit(tree);
//
//        Automaton automaton = AutomatonUtils.ldlf2Automaton(formula, formula.getSignature());
//
//        automaton = new ToDFA<>().transform(automaton);
//
//        System.out.println("INPUT AUTOMATON: ");
//        System.out.println(automaton);
//
//
//        //Building the automaton to be intersected with "automaton"
//        Automaton other = new Automaton();
//
//        State zero = other.addState(true, false);
//        State one = other.addState(false, true);
//
//        Proposition a = new Proposition("a");
//        Proposition g = new Proposition("g");
//        PossibleWorld pw = new PossibleWorld();
//        pw.add(a);
//        pw.add(g);
//        Transition<PossibleWorld> zeroOne = new Transition<>(zero, pw, one);
//
//        try {
//            other.addTransition(zeroOne);
//        } catch (NoSuchStateException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("OTHER AUTOMATON: ");
//        System.out.println(other);
//
//        Automaton union = new Union<>().transform(automaton, other);
//        union = new ToDFA<>().transform(union);
//
//        System.out.println("RESULTING DETERMINISTIC AUTOMATON: ");
//        System.out.println(union);
//    }

    @Test
    public void testEmptyIntersection() {
//        String input = "(G(a U b)) && (!( G(a U b) ))";
//
//        LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
//        LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
//        ParseTree tree = parser.expression();
//        LTLfVisitor visitor = new LTLfVisitor();
//        LTLfFormula f = visitor.visit(tree);
//
//        LDLfFormula ldlff = f.toLDLf();
//        Automaton af = AutomatonUtils.ldlf2Automaton(ldlff, ldlff.getSignature());
//        //af = new ToDFA<>().transform(af);
//        System.out.println("Automaton for (G(a U b)) && (!( G(a U b) )), should be empty.");
//        System.out.println(af);
//        System.out.println();
//
//        input = "G(a U b)";
//        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
//        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
//        tree = parser.expression();
//        visitor = new LTLfVisitor();
//        LTLfFormula f1 = visitor.visit(tree);
//
//
//        input = "!( G(a U b) )";
//        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
//        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
//        tree = parser.expression();
//        visitor = new LTLfVisitor();
//        LTLfFormula f2 = visitor.visit(tree);
//
//        LDLfFormula ldlff1 = f1.toLDLf();
//        LDLfFormula ldlff2 = f2.toLDLf();



//        String ldlfinput = "[true*](< ((a?) ; true)* > b)";
//        LDLfFormulaParserLexer ldlflexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ldlfinput));
//        LDLfFormulaParserParser ldlfparser = new LDLfFormulaParserParser(new CommonTokenStream(ldlflexer));
//        ParseTree ldlftree = ldlfparser.expression();
//        LDLfVisitor ldlfvisitor = new LDLfVisitor();
//        LDLfFormula ldlfformula = ldlfvisitor.visit(ldlftree);
//
//        System.out.println("Automaton for: " + ldlfformula);
//        Automaton ldlfautomaton = AutomatonUtils.ldlf2Automaton(ldlfformula, ldlfformula.getSignature());
//        System.out.println(ldlfautomaton);

//        Automaton af1 = AutomatonUtils.ldlf2Automaton(ldlff1, ldlff1.getSignature());
//        //af1 = new ToDFA<>().transform(af1);
//        System.out.println("Automaton A1 for " + f1);
//        System.out.println("Automaton A1 for " + f1.toLDLf());
//        System.out.println();
//        System.out.println(af1);
//        System.out.println();
//        Automaton af2 = AutomatonUtils.ldlf2Automaton(ldlff2, ldlff2.getSignature());
//        //af2 = new ToDFA<>().transform(af2);
//        System.out.println("Automaton A2 for !(G(a U b))");
//        System.out.println(af2);
//        System.out.println();
//
//        af1 = new Complement<>().transform(af1);
//        af2 = new Complement<>().transform(af2);
//
//        Automaton aResult = new Union<>().transform(af1, af2);
//
//        aResult = new Complement<>().transform(aResult);
//
//        aResult = new ToDFA<>().transform(aResult);
//
//        System.out.println("Automaton for not( not(A1) UNION not(A2) ). Should be empty.");
//        System.out.println(aResult);
    }


    @Test
    public void prove() {
        String input = "(F a) && (G(a -> Fb)) && (G(b->Fa)) && (G(!a || !b))";

        LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        LTLfVisitor visitor = new LTLfVisitor();
        LTLfFormula f = visitor.visit(tree);

        LDLfFormula ldlff = f.toLDLf();
        System.out.println(ldlff);
        Automaton af = AutomatonUtils.ldlf2Automaton(ldlff, ldlff.getSignature());
        //af = new ToDFA<>().transform(af);
        System.out.println("Automaton for " + ldlff);
        System.out.println(af);
    }

    @Ignore
    @Test
    public void prove2() {
        //String input = "[true*](< ((a?) ; true)* > b)";
        String input = "< ((a?) ; true)* > b";
        //String input = "[true*]a";

        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        LDLfVisitor visitor = new LDLfVisitor();
        LDLfFormula f = visitor.visit(tree);

        Automaton af = AutomatonUtils.ldlf2Automaton(f, f.getSignature());
        //af = new ToDFA<>().transform(af);
        System.out.println("Automaton for " + f);
        System.out.println(af);
    }

}

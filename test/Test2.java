/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

/*import alternating.Alternating;
import alternating.FormulaType;
import formula.Formula;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import rationals.Automaton;
import rationals.NoSuchStateException;
import symbols.Alphabet;
import symbols.StringSymbol;
import visitors.LDLfVisitors.LDLfVisitorFormula;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;*/


public class Test2 {

    /*public static void main(String[] args) throws NoSuchStateException {
        String input = "<true*;a;true*;b;true*>(d&last)";

        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        LDLfVisitor<StringSymbol> visitor = new LDLfVisitor<>(StringSymbol.class, new Alphabet<>());

        Formula<StringSymbol> f = visitor.visit(tree);

        System.out.println(f);
        System.out.println(visitor.getGenericSymbol());
        System.out.println(visitor.getAlphabet());

        Automaton a = new Alternating().nonDeterministicFromAlternating(f, visitor.getAlphabet(), FormulaType.LDLF, StringSymbol.class);

        System.out.println(a);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("automaton.gv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        ps.println(utils.Utilities.toDot(a));
        ps.flush();
        ps.close();


//		Automaton a = new Automaton();
//		State initial = a.addState(true, false);
//		State fin = a.addState(false, true);
//		Transition transition = new Transition(initial, ciao, fin);
//		a.addTransition(transition);
//		
//		System.out.println(a.toString());

    }*/


     /*       Automaton a = new Alternating().nonDeterministicFromAlternating(f, visitor.getAlphabet(), FormulaType.LTLF, StringSymbol.class);

        System.out.println(a);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("automaton.gv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        ps.println(utils.Utilities.toDot(a));
        ps.flush();
        ps.close();


        Automaton a = new Automaton();
        State initial = a.addState(true, false);
        State fin = a.addState(false, true);
        Transition transition = new Transition(initial, "ciao", fin);
        a.addTransition(transition);

        System.out.println(a.toString());*/

     /*       Automaton a = new Alternating().nonDeterministicFromAlternating(f, visitor.getAlphabet(), FormulaType.LTLF, StringSymbol.class);

        System.out.println(a);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("automaton.gv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        ps.println(utils.Utilities.toDot(a));
        ps.flush();
        ps.close();


        Automaton a = new Automaton();
        State initial = a.addState(true, false);
        State fin = a.addState(false, true);
        Transition transition = new Transition(initial, "ciao", fin);
        a.addTransition(transition);

        System.out.println(a.toString());*/

}

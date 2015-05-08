package tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import alternating.Alternating;
import alternating.FormulaType;
import formula.Formula;
import visitors.LTLfVisitors.LTLfVisitor;
import ltlfParser.LTLfFormulaParserLexer;
import ltlfParser.LTLfFormulaParserParser;
import rationals.Automaton;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;
import rationals.graph.AutomatonVisualFactory;
import symbols.Alphabet;
import symbols.StringSymbol;

public class Test1 {

	public static void main(String[] args) throws NoSuchStateException {
				String input = "[](<>a)";
				
				LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
			    LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
			    ParseTree tree = parser.expression();
			    LTLfVisitor<StringSymbol> visitor = new LTLfVisitor<StringSymbol>(StringSymbol.class);
			    
			    Formula<StringSymbol> f = visitor.visit(tree);
			    
			    System.out.println(f);
			    System.out.println(visitor.getGeneric());
			    System.out.println(visitor.getAlphabet());

			    Automaton a = new Alternating().nonDeterministicFromAlternating(f, visitor.getAlphabet(), FormulaType.LTLF, StringSymbol.class);

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
		//		Transition transition = new Transition(initial, "ciao", fin);
		//		a.addTransition(transition);
		//		
		//		System.out.println(a.toString());
	}

}

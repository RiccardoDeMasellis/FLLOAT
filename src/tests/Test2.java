package tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import alternating.Alternating;
import alternating.FormulaType;
import formula.Formula;
import ldlfParser.LDLfFormulaParserLexer;
import ldlfParser.LDLfFormulaParserParser;
import visitors.LDLfVisitors.LDLfVisitorFormula;
import visitors.LTLfVisitors.LTLfVisitor;
import ltlfParser.LTLfFormulaParserLexer;
import ltlfParser.LTLfFormulaParserParser;
import rationals.Automaton;
import rationals.DefaultStateFactory;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;
import symbols.Alphabet;
import symbols.StringSymbol;


public class Test2 {

	public static void main(String[] args) throws NoSuchStateException {
		String input="<true*;a;true*;b;true*>(d&last)";
		
		LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
	    LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
	    ParseTree tree = parser.expression();
	    LDLfVisitorFormula<StringSymbol> visitor = new LDLfVisitorFormula<StringSymbol>(StringSymbol.class, new Alphabet<StringSymbol>());
	    
	    Formula<StringSymbol> f = visitor.visit(tree);
	    
	    System.out.println(f);
	    System.out.println(visitor.getGeneric());
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
		
	}
	
}

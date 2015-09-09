import antlr4_generated.LTLfFormulaParserLexer;
import antlr4_generated.LTLfFormulaParserParser;
import formula.ltlf.LTLfFormula;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import visitors.LTLfVisitors.LTLfVisitor;

/**
 * PropParsingTest
 * <br>
 * Created by Simone Calciolari on 09/09/15.
 * @author Simone Calciolari.
 */
public class PropParsingTest {

	private static final boolean DEBUG = true;

	@Test
	public void testPropParser(){

		parseLTLfFormula("aP___?cas78947297492HJc");

	}


	public static LTLfFormula parseLTLfFormula(String input){
		LTLfFormula output;

		//Instantiates lexer and parser
		LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
		LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));

		//Gets the parsing tree
		ParseTree tree = parser.expression();

		if (DEBUG){
			System.out.println("\n");
			String o = tree.toStringTree(parser);
			System.out.println("> Default parsing tree:\n> " + o + "\n");
		}

		//Calling our own visitor
		LTLfVisitor visitor = new LTLfVisitor();
		output = visitor.visit(tree);

		if(DEBUG) {
			System.out.println("\n> Parsed formula: " + output.toString());
			System.out.println("=============================================================================================");
		}

		return output;
	}

}



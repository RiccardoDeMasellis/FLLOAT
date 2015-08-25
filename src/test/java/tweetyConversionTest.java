import antlr4_generated.LTLfFormulaParserLexer;
import antlr4_generated.LTLfFormulaParserParser;
import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfLocalFormula;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import visitors.LTLfVisitors.LTLfVisitor;

/**
 * Created by Simone Calciolari on 25/08/15.
 */
public class tweetyConversionTest {

	@Test
	public void testTweetyConversion(){

		//Gets rid of annoying antlr warning messages
		parseLTLfFormula("a");
		System.out.println("\n");

		LTLfLocalFormula built = (LTLfLocalFormula) parseLTLfFormula("!a");
		System.out.println(built.toTweetyProp().toString());

	}

	private LTLfFormula parseLTLfFormula(String input){

		LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
		LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));

		ParseTree tree = parser.expression();
		LTLfVisitor visitor = new LTLfVisitor();

		return visitor.visit(tree);
	}

}

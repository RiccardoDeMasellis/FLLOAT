import antlr4_generated.LTLfFormulaParserLexer;
import antlr4_generated.LTLfFormulaParserParser;
import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfLocalFormula;
import net.sf.tweety.logics.pl.parser.PlParser;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import visitors.LTLfVisitors.LTLfVisitor;

import java.io.Reader;
import java.io.StringReader;

/**
 * Created by Simone Calciolari on 25/08/15.
 */
public class tweetyConversionTest {

	@Test
	public void testTweetyConversion(){

		//Gets annoying antlr warning messages out of the way
		parseLTLfFormula("a");
		System.out.println("\n");

		LTLfLocalFormula built = (LTLfLocalFormula) parseLTLfFormula("!a");
		assertEquals("", built.toTweetyProp(), parseTweetyFormula("!a"));

		built = (LTLfLocalFormula) parseLTLfFormula("a && b");
		assertEquals("", parseTweetyFormula("a && b"), built.toTweetyProp());

		built = (LTLfLocalFormula) parseLTLfFormula("a || b");
		assertEquals("", parseTweetyFormula("a || b"), built.toTweetyProp());

		built = (LTLfLocalFormula) parseLTLfFormula("a -> b");
		assertEquals("", parseTweetyFormula("!a || b"), built.toTweetyProp());

		built = (LTLfLocalFormula) parseLTLfFormula("a <-> b");
		assertEquals("", parseTweetyFormula("(!a || b) && (!b || a)"), built.toTweetyProp());

		built = (LTLfLocalFormula) parseLTLfFormula("p || q && ! r -> s");
		assertEquals("", parseTweetyFormula("(!p && (!q || r)) || s"), built.toTweetyProp());

		built = (LTLfLocalFormula) parseLTLfFormula("! a && b || c -> d <-> e");
		assertEquals("", parseTweetyFormula("((((!a && b) || (c)) && !d) || e)&& (!e || (((a || !b) && !c) || d))"),
				built.toTweetyProp());

	}

	private LTLfFormula parseLTLfFormula(String input){

		LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
		LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));

		ParseTree tree = parser.expression();
		LTLfVisitor visitor = new LTLfVisitor();

		return visitor.visit(tree);
	}

	private PropositionalFormula parseTweetyFormula(String input){
		PlParser parser = new PlParser();
		Reader sr = new StringReader(input);
		return parser.parseFormula(sr);
	}

	//<editor-fold desc="assertEquals" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param expected first object to be compared
	 * @param computed second object to be compared
	 */
	private static void assertEquals(String description, Object expected, Object computed) {

		try {
			Assert.assertEquals(description, expected, computed);
			System.out.println("SUCCESS");
			System.out.println("\t> Expected: " + expected.toString());
			System.out.println("\t> Computed: " + computed.toString());
			System.out.println();
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

}

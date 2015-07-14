/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

import formula.ldlf.LDLfLocalFormula;
import generatedParsers.LDLfFormulaParserLexer;
import generatedParsers.LDLfFormulaParserParser;
import net.sf.tweety.logics.pl.parser.PlParser;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import visitors.LDLfVisitors.LDLfVisitor;

import java.io.StringReader;
import java.util.Set;

/**
 * Created by Riccardo De Masellis on 09/07/15.
 */
public class FormulaTweetyIntegration {

    @Test
    public void testLDLfLocal2TweetyPro() {

        String input = "( !(a && b) && !( a || b ) ) || ((!d) && ciao)";

        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        LDLfVisitor visitor = new LDLfVisitor();
        LDLfLocalFormula formula = (LDLfLocalFormula) visitor.visit(tree);
        PropositionalSignature sig1 = formula.getSignature();
        PropositionalFormula pf1 = formula.LDLfLocal2Prop();

        StringReader sr = new StringReader("( !(a && b) && !( a || b ) ) || ((!d) && ciao)");
        PropositionalFormula pf2 = new PlParser().parseFormula(sr);

        System.out.println(pf1);
        System.out.println(pf2);

        Assert.assertEquals("", pf2, pf1);
        Assert.assertEquals("", pf2.getSignature(), pf1.getSignature());
    }

    @Test
    public void testMinimalModels() {

        StringReader sr = new StringReader("(a || b || c )");
        PropositionalFormula pf2 = new PlParser().parseFormula(sr);

        Set<PossibleWorld> models = pf2.getModels();
        System.out.println(models);
        System.out.println(utils.FormulaUtils.minimizeModels(models));
    }
}

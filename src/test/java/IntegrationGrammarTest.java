/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import antlr4_generated.LDLfFormulaParserLexer;
import antlr4_generated.LDLfFormulaParserParser;
import antlr4_generated.LTLfFormulaParserLexer;
import antlr4_generated.LTLfFormulaParserParser;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import visitors.LDLfVisitors.LDLfVisitor;
import visitors.LTLfVisitors.LTLfVisitor;

public class IntegrationGrammarTest {


    @Test
    public void testPropGrammar() {
        String input = "!a";

        LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        LTLfVisitor visitor = new LTLfVisitor();
        LTLfFormula f = visitor.visit(tree);
        System.out.println(f);
        PropositionalSignature returnedSig = f.getSignature();
        PropositionalSignature expectedSig = new PropositionalSignature();
        Proposition a = new Proposition("a");
        expectedSig.add(a);
        Assert.assertEquals("", "NOT(a)", f.toString());
        Assert.assertEquals("", expectedSig, returnedSig);
        System.out.println(returnedSig);

        input = "!(!(!a))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor();
        f = visitor.visit(tree);
        System.out.println(f);
        returnedSig = f.getSignature();
        expectedSig = new PropositionalSignature();
        a = new Proposition("a");
        expectedSig.add(a);
        Assert.assertEquals("", "NOT(NOT(NOT(a)))", f.toString());
        Assert.assertEquals("", expectedSig, returnedSig);
        System.out.println(returnedSig);

        input = "!(!(!(a))) & b";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor();
        f = visitor.visit(tree);
        System.out.println(f);
        returnedSig = f.getSignature();
        expectedSig = new PropositionalSignature();
        a = new Proposition("a");
        expectedSig.add(a);
        Proposition b = new Proposition("b");
        expectedSig.add(b);
        Assert.assertEquals("", "(NOT(NOT(NOT(a)))) AND (b)", f.toString());
        Assert.assertEquals("", expectedSig, returnedSig);
        System.out.println(returnedSig);


        input = "(!(!(!(a))) & b) <-> (!a | (c -> d))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor();
        f = visitor.visit(tree);
        System.out.println(f);

        returnedSig = f.getSignature();
        expectedSig = new PropositionalSignature();
        a = new Proposition("a");
        expectedSig.add(a);
        b = new Proposition("b");
        expectedSig.add(b);
        Proposition c = new Proposition("c");
        expectedSig.add(c);
        Proposition d = new Proposition("d");
        expectedSig.add(d);
        Assert.assertEquals("", expectedSig, returnedSig);
        Assert.assertEquals("", "((NOT(NOT(NOT(a)))) AND (b)) DOUBLEIMPL ((NOT(a)) OR ((c) IMPL (d)))", f.toString());
        System.out.println(returnedSig);
    }


    @Test
    public void testLTLfGrammar() {
        String input = "Ga & Fb";
        LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        LTLfVisitor visitor = new LTLfVisitor();
        LTLfFormula formula = visitor.visit(tree);
        System.out.println(formula);
        PropositionalSignature returnedSig = formula.getSignature();
        PropositionalSignature expectedSig = new PropositionalSignature();
        Proposition a = new Proposition("a");
        expectedSig.add(a);
        Proposition b = new Proposition("b");
        expectedSig.add(b);
        Assert.assertEquals("", expectedSig, returnedSig);
        Assert.assertEquals("", "(G(a)) TeAND (F(b))", formula.toString());
        System.out.println(returnedSig);

        input = "(a & b) U (c & d)";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor();
        formula = visitor.visit(tree);
        System.out.println(formula);
        returnedSig = formula.getSignature();
        expectedSig = new PropositionalSignature();
        a = new Proposition("a");
        expectedSig.add(a);
        b = new Proposition("b");
        expectedSig.add(b);
        Proposition c = new Proposition("c");
        expectedSig.add(c);
        Proposition d = new Proposition("d");
        expectedSig.add(d);
        Assert.assertEquals("", expectedSig, returnedSig);
        Assert.assertEquals("", "((a) AND (b)) U ((c) AND (d))", formula.toString());
        System.out.println(returnedSig);

        input = "Xa";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor();
        formula = visitor.visit(tree);
        System.out.println(formula);
        Assert.assertEquals("", "X(a)", formula.toString());
        System.out.println(formula.getSignature());

        input = "(a & b) U ((Xc) & (d))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor();
        formula = visitor.visit(tree);
        System.out.println(formula);
        returnedSig = formula.getSignature();
        expectedSig = new PropositionalSignature();
        a = new Proposition("a");
        expectedSig.add(a);
        b = new Proposition("b");
        expectedSig.add(b);
        c = new Proposition("c");
        expectedSig.add(c);
        d = new Proposition("d");
        expectedSig.add(d);
        Assert.assertEquals("", expectedSig, returnedSig);
        Assert.assertEquals("", "((a) AND (b)) U ((X(c)) TeAND (d))", formula.toString());
        System.out.println(returnedSig);

        input = "((a & b) U ((Xc) & (d))) R ( ((WX (a -> c)) WU (Ga R c)) <-> (c U f) )";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor();
        formula = visitor.visit(tree);
        System.out.println(formula);
        returnedSig = formula.getSignature();
        expectedSig = new PropositionalSignature();
        a = new Proposition("a");
        expectedSig.add(a);
        b = new Proposition("b");
        expectedSig.add(b);
        c = new Proposition("c");
        expectedSig.add(c);
        d = new Proposition("d");
        expectedSig.add(d);
        Proposition f = new Proposition("f");
        expectedSig.add(f);
        Assert.assertEquals("", expectedSig, returnedSig);
        Assert.assertEquals("", "(((a) AND (b)) U ((X(c)) TeAND (d))) R (((WX((a) IMPL (c))) WU ((G(a)) R (c))) TeDOUBLEIMPL ((c) U (f)))", formula.toString());
        System.out.println(returnedSig);
    }


    @Test
    public void testLDLfGrammar() {
        String input = "<(a + (b ; c)) + (f ; d*)>g";
        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        LDLfVisitor visitor = new LDLfVisitor();
        LDLfFormula formula = visitor.visit(tree);
        System.out.println(formula);
        PropositionalSignature returnedSig = formula.getSignature();
        PropositionalSignature expectedSig = new PropositionalSignature();
        Proposition a = new Proposition("a");
        expectedSig.add(a);
        Proposition b = new Proposition("b");
        expectedSig.add(b);
        Proposition c = new Proposition("c");
        expectedSig.add(c);
        Proposition d = new Proposition("d");
        expectedSig.add(d);
        Proposition f = new Proposition("f");
        expectedSig.add(f);
        Proposition g = new Proposition("g");
        expectedSig.add(g);
        Assert.assertEquals("", expectedSig, returnedSig);
        Assert.assertEquals("", "<((a) + ((b) ; (c))) + ((f) ; (*(d)))>(g)", formula.toString());
        System.out.println(returnedSig);

        input = "<( (a ; (h + j))* + (b ; c)) + (f ; d*)>g";
        lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LDLfVisitor();
        formula = visitor.visit(tree);
        System.out.println(formula);
        returnedSig = formula.getSignature();
        expectedSig = new PropositionalSignature();
        a = new Proposition("a");
        expectedSig.add(a);
        b = new Proposition("b");
        expectedSig.add(b);
        c = new Proposition("c");
        expectedSig.add(c);
        d = new Proposition("d");
        expectedSig.add(d);
        f = new Proposition("f");
        expectedSig.add(f);
        g = new Proposition("g");
        expectedSig.add(g);
        Proposition h = new Proposition("h");
        expectedSig.add(h);
        Proposition j = new Proposition("j");
        expectedSig.add(j);
        Assert.assertEquals("", expectedSig, returnedSig);
        Assert.assertEquals("", "<((*((a) ; ((h) + (j)))) + ((b) ; (c))) + ((f) ; (*(d)))>(g)", formula.toString());
        System.out.println(returnedSig);

        //((g & [(b ; c) + (r + s)*] (d -> !(<a + (b | (a & b) )?>(f | s))) ) & ff) <-> (d & end)
        //(((g) TeAND ([((b) ; (c)) + (*((r) + (s)))]((d) TeIMPL (TeNOT( < (a) + ( ? ((b) TeOR ((a) AND (b))))> ((f) OR (s))))))) TeAND (ff)) TeDOUBLEIMPL ((d) AND(end))

        input = "((g & [(b ; c) + (r + s)*] (d -> !(<a + (b | (a & b) )?>(f | s))) ) & ff) <-> (d & end)";
        lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LDLfVisitor();
        formula = visitor.visit(tree);
        System.out.println(formula);

        returnedSig = formula.getSignature();
        expectedSig = new PropositionalSignature();
        a = new Proposition("a");
        expectedSig.add(a);
        b = new Proposition("b");
        expectedSig.add(b);
        c = new Proposition("c");
        expectedSig.add(c);
        d = new Proposition("d");
        expectedSig.add(d);
        f = new Proposition("f");
        expectedSig.add(f);
        g = new Proposition("g");
        expectedSig.add(g);
        Proposition r = new Proposition("r");
        expectedSig.add(r);
        Proposition s = new Proposition("s");
        expectedSig.add(s);
        Assert.assertEquals("", expectedSig, returnedSig);
        Assert.assertEquals("", "(((g) TeAND ([((b) ; (c)) + (*((r) + (s)))]((d) TeIMPL (TeNOT(<(a) + (?((b) OR ((a) AND (b))))>((f) OR (s))))))) TeAND (ff)) TeDOUBLEIMPL ((d) TeAND ([?(true)](ff)))", formula.toString());
        System.out.println(returnedSig);

    }

}

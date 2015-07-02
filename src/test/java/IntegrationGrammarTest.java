/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import generatedParsers.LDLfFormulaParserLexer;
import generatedParsers.LDLfFormulaParserParser;
import generatedParsers.LTLfFormulaParserLexer;
import generatedParsers.LTLfFormulaParserParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import symbols.Alphabet;
import symbols.StringSymbol;
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
        LTLfVisitor<StringSymbol> visitor = new LTLfVisitor<>(StringSymbol.class);
        LTLfFormula<StringSymbol> f = visitor.visit(tree);
        System.out.println(f);
        Alphabet<StringSymbol> returnedAlphabet = visitor.getAlphabet();
        Alphabet<StringSymbol> expectedAlphabet = new Alphabet<>();
        StringSymbol a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        Assert.assertEquals("", "NOT(a)", f.toString());
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        System.out.println(visitor.getAlphabet());

        input = "!(!(!a))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor<>(StringSymbol.class);
        f = visitor.visit(tree);
        System.out.println(f);
        returnedAlphabet = visitor.getAlphabet();
        expectedAlphabet = new Alphabet<>();
        a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        Assert.assertEquals("", "NOT(NOT(NOT(a)))", f.toString());
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        System.out.println(visitor.getAlphabet());

        input = "!(!(!(a))) & b";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor<>(StringSymbol.class);
        f = visitor.visit(tree);
        System.out.println(f);
        returnedAlphabet = visitor.getAlphabet();
        expectedAlphabet = new Alphabet<>();
        a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        StringSymbol b = new StringSymbol("b");
        expectedAlphabet.addSymbol(b);
        Assert.assertEquals("", "(NOT(NOT(NOT(a)))) AND (b)", f.toString());
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        System.out.println(visitor.getAlphabet());


        input = "(!(!(!(a))) & b) <-> (!a | (c -> d))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor<>(StringSymbol.class);
        f = visitor.visit(tree);
        System.out.println(f);

        returnedAlphabet = visitor.getAlphabet();
        expectedAlphabet = new Alphabet<>();
        a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        b = new StringSymbol("b");
        expectedAlphabet.addSymbol(b);
        StringSymbol c = new StringSymbol("c");
        expectedAlphabet.addSymbol(c);
        StringSymbol d = new StringSymbol("d");
        expectedAlphabet.addSymbol(d);
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        Assert.assertEquals("", "((NOT(NOT(NOT(a)))) AND (b)) DOUBLEIMPL ((NOT(a)) OR ((c) IMPL (d)))", f.toString());
        System.out.println(visitor.getAlphabet());
    }


    @Test
    public void testLTLfGrammar() {
        String input = "Ga & Fb";
        LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        LTLfVisitor<StringSymbol> visitor = new LTLfVisitor<>(StringSymbol.class);
        LTLfFormula<StringSymbol> formula = visitor.visit(tree);
        System.out.println(formula);
        Alphabet<StringSymbol> returnedAlphabet = visitor.getAlphabet();
        Alphabet<StringSymbol> expectedAlphabet = new Alphabet<>();
        StringSymbol a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        StringSymbol b = new StringSymbol("b");
        expectedAlphabet.addSymbol(b);
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        Assert.assertEquals("", "(G(a)) TeAND (F(b))", formula.toString());
        System.out.println(visitor.getAlphabet());

        input = "(a & b) U (c & d)";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor<>(StringSymbol.class);
        formula = visitor.visit(tree);
        System.out.println(formula);
        returnedAlphabet = visitor.getAlphabet();
        expectedAlphabet = new Alphabet<>();
        a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        b = new StringSymbol("b");
        expectedAlphabet.addSymbol(b);
        StringSymbol c = new StringSymbol("c");
        expectedAlphabet.addSymbol(c);
        StringSymbol d = new StringSymbol("d");
        expectedAlphabet.addSymbol(d);
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        Assert.assertEquals("", "((a) AND (b)) U ((c) AND (d))", formula.toString());
        System.out.println(visitor.getAlphabet());

        input = "Xa";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor<>(StringSymbol.class);
        formula = visitor.visit(tree);
        System.out.println(formula);
        Assert.assertEquals("", "X(a)", formula.toString());
        System.out.println(visitor.getAlphabet());

        input = "(a & b) U ((Xc) & (d))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor<>(StringSymbol.class);
        formula = visitor.visit(tree);
        System.out.println(formula);
        returnedAlphabet = visitor.getAlphabet();
        expectedAlphabet = new Alphabet<>();
        a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        b = new StringSymbol("b");
        expectedAlphabet.addSymbol(b);
        c = new StringSymbol("c");
        expectedAlphabet.addSymbol(c);
        d = new StringSymbol("d");
        expectedAlphabet.addSymbol(d);
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        Assert.assertEquals("", "((a) AND (b)) U ((X(c)) TeAND (d))", formula.toString());
        System.out.println(visitor.getAlphabet());

        input = "((a & b) U ((Xc) & (d))) R ( ((WX (a -> c)) WU (Ga R c)) <-> (c U f) )";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LTLfVisitor<>(StringSymbol.class);
        formula = visitor.visit(tree);
        System.out.println(formula);
        returnedAlphabet = visitor.getAlphabet();
        expectedAlphabet = new Alphabet<>();
        a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        b = new StringSymbol("b");
        expectedAlphabet.addSymbol(b);
        c = new StringSymbol("c");
        expectedAlphabet.addSymbol(c);
        d = new StringSymbol("d");
        expectedAlphabet.addSymbol(d);
        StringSymbol f = new StringSymbol("f");
        expectedAlphabet.addSymbol(f);
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        Assert.assertEquals("", "(((a) AND (b)) U ((X(c)) TeAND (d))) R (((WX((a) IMPL (c))) WU ((G(a)) R (c))) TeDOUBLEIMPL ((c) U (f)))", formula.toString());
        System.out.println(visitor.getAlphabet());
    }


    @Test
    public void testLDLfGrammar() {
        String input = "<(a + (b ; c)) + (f ; d*)>g";
        Alphabet<StringSymbol> alphabet = new Alphabet<>();
        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        LDLfVisitor<StringSymbol> visitor = new LDLfVisitor<>(StringSymbol.class, alphabet);
        LDLfFormula<StringSymbol> formula = visitor.visit(tree);
        System.out.println(formula);
        Alphabet<StringSymbol> returnedAlphabet = visitor.getAlphabet();
        Alphabet<StringSymbol> expectedAlphabet = new Alphabet<>();
        StringSymbol a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        StringSymbol b = new StringSymbol("b");
        expectedAlphabet.addSymbol(b);
        StringSymbol c = new StringSymbol("c");
        expectedAlphabet.addSymbol(c);
        StringSymbol d = new StringSymbol("d");
        expectedAlphabet.addSymbol(d);
        StringSymbol f = new StringSymbol("f");
        expectedAlphabet.addSymbol(f);
        StringSymbol g = new StringSymbol("g");
        expectedAlphabet.addSymbol(g);
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        Assert.assertEquals("", "<((a) + ((b) ; (c))) + ((f) ; (*(d)))>(g)", formula.toString());
        System.out.println(visitor.getAlphabet());

        input = "<( (a ; (h + j))* + (b ; c)) + (f ; d*)>g";
        alphabet = new Alphabet<>();
        lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LDLfVisitor<>(StringSymbol.class, alphabet);
        formula = visitor.visit(tree);
        System.out.println(formula);
        returnedAlphabet = visitor.getAlphabet();
        expectedAlphabet = new Alphabet<>();
        a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        b = new StringSymbol("b");
        expectedAlphabet.addSymbol(b);
        c = new StringSymbol("c");
        expectedAlphabet.addSymbol(c);
        d = new StringSymbol("d");
        expectedAlphabet.addSymbol(d);
        f = new StringSymbol("f");
        expectedAlphabet.addSymbol(f);
        g = new StringSymbol("g");
        expectedAlphabet.addSymbol(g);
        StringSymbol h = new StringSymbol("h");
        expectedAlphabet.addSymbol(h);
        StringSymbol j = new StringSymbol("j");
        expectedAlphabet.addSymbol(j);
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        Assert.assertEquals("", "<((*((a) ; ((h) + (j)))) + ((b) ; (c))) + ((f) ; (*(d)))>(g)", formula.toString());
        System.out.println(visitor.getAlphabet());

        //((g & [(b ; c) + (r + s)*] (d -> !(<a + (b | (a & b) )?>(f | s))) ) & ff) <-> (d & end)
        //(((g) TeAND ([((b) ; (c)) + (*((r) + (s)))]((d) TeIMPL (TeNOT( < (a) + ( ? ((b) TeOR ((a) AND (b))))> ((f) OR (s))))))) TeAND (ff)) TeDOUBLEIMPL ((d) AND(end))

        input = "((g & [(b ; c) + (r + s)*] (d -> !(<a + (b | (a & b) )?>(f | s))) ) & ff) <-> (d & end)";
        alphabet = new Alphabet<>();
        lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        System.out.println(tree.toStringTree(parser));
        visitor = new LDLfVisitor<>(StringSymbol.class, alphabet);
        formula = visitor.visit(tree);
        System.out.println(formula);

        returnedAlphabet = visitor.getAlphabet();
        expectedAlphabet = new Alphabet<>();
        a = new StringSymbol("a");
        expectedAlphabet.addSymbol(a);
        b = new StringSymbol("b");
        expectedAlphabet.addSymbol(b);
        c = new StringSymbol("c");
        expectedAlphabet.addSymbol(c);
        d = new StringSymbol("d");
        expectedAlphabet.addSymbol(d);
        f = new StringSymbol("f");
        expectedAlphabet.addSymbol(f);
        g = new StringSymbol("g");
        expectedAlphabet.addSymbol(g);
        StringSymbol r = new StringSymbol("r");
        expectedAlphabet.addSymbol(r);
        StringSymbol s = new StringSymbol("s");
        expectedAlphabet.addSymbol(s);
        Assert.assertEquals("", expectedAlphabet, returnedAlphabet);
        Assert.assertEquals("", "(((g) TeAND ([((b) ; (c)) + (*((r) + (s)))]((d) TeIMPL (TeNOT(<(a) + (?((b) OR ((a) AND (b))))>((f) OR (s))))))) TeAND (ff)) TeDOUBLEIMPL ((d) TeAND ([?(true)](ff)))", formula.toString());
        System.out.println(visitor.getAlphabet());

    }

}

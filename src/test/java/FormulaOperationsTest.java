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
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import visitors.LDLfVisitors.LDLfVisitor;
import visitors.LTLfVisitors.LTLfVisitor;

/**
 * Created by Riccardo De Masellis on 23/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class FormulaOperationsTest {

    @Test
    public void testLTLfnnf() {
        String input = "a & b";
        LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        LTLfVisitor visitor = new LTLfVisitor();
        LTLfFormula formula1 = visitor.visit(tree);

        input = "a & b";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LTLfVisitor();
        LTLfFormula formula2 = visitor.visit(tree);

        Assert.assertEquals("", formula2, formula1.nnf());

        /* ************************************************************************************** */

        input = "!(a & b) & G(!( a <-> b ))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LTLfVisitor();
        formula1 = visitor.visit(tree);

        input = "(!a | !b) & ((false) R (((a) & (!b)) | ((b) & (!a))))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LTLfVisitor();
        formula2 = visitor.visit(tree);
        System.out.println("Formula expected: ");
        System.out.println(formula2);
        System.out.println("Formula computed: ");
        System.out.println(formula1.nnf());

        Assert.assertEquals("", formula2, formula1.nnf());

        /* ************************************************************************************** */

        input = "!( (X (a)) <-> b )";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LTLfVisitor();
        formula1 = visitor.visit(tree);

        input = "((X a) & (!b)) | ((b) & (WX (!a)))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LTLfVisitor();
        formula2 = visitor.visit(tree);
        System.out.println("Formula expected: ");
        System.out.println(formula2);
        System.out.println("Formula computed: ");
        System.out.println(formula1.nnf());

        Assert.assertEquals("", formula2, formula1.nnf());

        /* ************************************************************************************** */

        input = "!( G( G( (WX false) R (G true) )))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LTLfVisitor();
        formula1 = visitor.visit(tree);

        input = "(true) U ((true) U ((X true) U ((true) U (false))))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LTLfVisitor();
        formula2 = visitor.visit(tree);

        Assert.assertEquals("", formula2, formula1.nnf());


        /* ************************************************************************************** */

        input = "F( G( (WX false) <-> (G (!(a & b))) ))";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LTLfVisitor();
        formula1 = visitor.visit(tree);

        input = "true U (false R ( ((X true) | (false R ((!a)|(!b)))) & ((true U (a & b)) | (WX false)) ) )";
        lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LTLfVisitor();
        formula2 = visitor.visit(tree);
        System.out.println("Formula expected: ");
        System.out.println(formula2);
        System.out.println("Formula computed: ");
        System.out.println(formula1.nnf());

        Assert.assertEquals("", formula2, formula1.nnf());
    }


    @Test
    public void testLDLfnnf() {
        //!(<((a ; (b + c))*) + (([d ; ((e+g)*)](a <-> b))?)>([d + f*](h->i)))
        String input = "!(<((a ; (b + c))*) + (([d ; ((e+g)*)](a <-> b))?)>([d + f*](h->i)))";
        LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expression();
        LDLfVisitor visitor = new LDLfVisitor();
        LDLfFormula formula1 = visitor.visit(tree);
        PropositionalSignature sig1 = formula1.getSignature();

        //[(((a);(b + c))*) + ([d ; ((e+g)*)]((!a | b) & (!b | a)))?](<d + (f)*>(h & !i))
        input = "[(((a);(b + c))*) + ([d ; ((e+g)*)]((!a | b) & (!b | a)))?](<d + (f)*>(h & !i))";
        lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LDLfVisitor();
        LDLfFormula formula2 = visitor.visit(tree);
        PropositionalSignature sig2 = formula2.getSignature();
        System.out.println("Formula expected: ");
        System.out.println(formula2);
        System.out.println("Formula computed: ");
        System.out.println(formula1.nnf());

        Assert.assertEquals("", formula2, formula1.nnf());
        Assert.assertEquals("", sig2, sig1);


        //!((<a;b>([f*](<c+d>(g->e)))) & ([g+(e;f)*](<(([a](c)) & (f))?>(l))))
        input = "!((<a;b>([f*](<c+d>(g->e)))) & ([g+(e;f)*](<(([a](c)) & (f))?>(l))))";
        lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LDLfVisitor();
        formula1 = visitor.visit(tree);
        sig1 = formula1.getSignature();

        //([a;b](<f*>([c+d](g & !e)))) | (<g+(e;f)*>([(([a](c)) & (f))?](!l)))
        input = "([a;b](<f*>([c+d](g & !e)))) | (<g+(e;f)*>([(([a](c)) & (f))?](!l)))";
        lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
        tree = parser.expression();
        visitor = new LDLfVisitor();
        formula2 = visitor.visit(tree);
        sig2 = formula2.getSignature();
        System.out.println("Formula expected: ");
        System.out.println(formula2);
        System.out.println("Formula computed: ");
        System.out.println(formula1.nnf());

        Assert.assertEquals("", formula2, formula1.nnf());
        Assert.assertEquals("", sig2, sig1);
    }


    //TODO: Implementare bene secondo le modifiche fatte all'algoritmo di traduzione.
    @Ignore
    @Test
    public void testLTLf2LDLf() {
        String input;
        LTLfFormulaParserLexer ltlfLexer;
        LTLfFormulaParserParser ltlfParser;
        ParseTree tree;
        LTLfVisitor ltlfVisitor;
        LTLfFormula formula1;

        LDLfFormulaParserLexer ldlfLexer;
        LDLfFormulaParserParser ldlfParser;
        LDLfVisitor ldlfVisitor;
        LDLfFormula formula2;

        //F( G( (WX false) <-> (G (!(a & b))) ))
        input = "F( G( (WX false) <-> (G (!(a & b))) ))";
        //nnf
        //(true) U ( (false) R ( ((X true) | ((false) R ((!a) | (!b)))) & ((WX false) | ((true) U ((a) & (b)))) ) )
        ltlfLexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        ltlfParser = new LTLfFormulaParserParser(new CommonTokenStream(ltlfLexer));
        tree = ltlfParser.expression();
        ltlfVisitor = new LTLfVisitor();
        formula1 = ltlfVisitor.visit(tree);
        PropositionalSignature sig1 = formula1.getSignature();

        //<((true ?) ; true)*>( [((true)? ; true)*] (((<true> true) | ( [((true)? ; true)*]((!a) | (!b)) )) & (([true](false)) | ( <((true)? ; true)*>((a) & (b)) ))) )
        input = "<((true ?) ; true)*>( [((true)? ; true)*] (((<true> true) | ( [((true)? ; true)*]((!a) | (!b)) )) & (([true](false)) | ( <((true)? ; true)*>((a) & (b)) ))) )";
        ldlfLexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        ldlfParser = new LDLfFormulaParserParser(new CommonTokenStream(ldlfLexer));
        tree = ldlfParser.expression();
        ldlfVisitor = new LDLfVisitor();
        formula2 = ldlfVisitor.visit(tree);
        PropositionalSignature sig2 = formula2.getSignature();
        System.out.println("Formula expected: ");
        System.out.println(formula2);
        System.out.println("Formula computed: ");
        System.out.println(formula1.toLDLf());

        Assert.assertEquals("", formula2, formula1.toLDLf());
        Assert.assertEquals("", sig2, sig1);

        /* ************************************************************************************** */

        input = "a U b";
        ltlfLexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
        ltlfParser = new LTLfFormulaParserParser(new CommonTokenStream(ltlfLexer));
        tree = ltlfParser.expression();
        ltlfVisitor = new LTLfVisitor();
        formula1 = ltlfVisitor.visit(tree);
        sig1 = formula1.getSignature();

        input = "<((a)? ; true)*>(b)";
        ldlfLexer = new LDLfFormulaParserLexer(new ANTLRInputStream(input));
        ldlfParser = new LDLfFormulaParserParser(new CommonTokenStream(ldlfLexer));
        tree = ldlfParser.expression();
        ldlfVisitor = new LDLfVisitor();
        formula2 = ldlfVisitor.visit(tree);
        sig2 = formula2.getSignature();
        System.out.println("Formula expected: ");
        System.out.println(formula2);
        System.out.println("Formula computed: ");
        System.out.println(formula1.toLDLf());

        Assert.assertEquals("", formula2, formula1.toLDLf());
        Assert.assertEquals("", sig2, sig1);

    }
}
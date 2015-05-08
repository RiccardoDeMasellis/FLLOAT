package visitors.LDLfVisitors;

import ldlfParser.LDLfFormulaParserBaseVisitor;
import ldlfParser.LDLfFormulaParserLexer;
import ldlfParser.LDLfFormulaParserParser;
import operator.Operator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import regularExpression.Atom;
import regularExpression.RegularExpression;
import regularExpression.Test;
import symbols.Alphabet;
import symbols.Symbol;
import formula.*;


public class LDLfVisitorFormula<S extends Symbol<?>> extends LDLfFormulaParserBaseVisitor<Formula<S>> {
	
	private Alphabet<S> alphabet;
	private Class<S> generic;

	public LDLfVisitorFormula(Class<S> generic, Alphabet<S> alphabet) {
		this.alphabet = alphabet;
		this.generic = generic;
	}

	public Class<S> getGeneric() {
		return generic;
	}

	public Alphabet<S> getAlphabet() {
		return alphabet;
	}
	
	
	//LDFfFormula
	@Override 
	public Formula<S> visitExpression(@NotNull LDLfFormulaParserParser.ExpressionContext ctx) {
		return (Formula<S>) visitChildren(ctx);
		}

	@Override 
	public Formula<S> visitLdlfAtom(@NotNull LDLfFormulaParserParser.LdlfAtomContext ctx){
			
		//When I visit an "Atom",
		//if it is equal "tt" then return the "ttFormula",
		//else if it is equal "ff" then return the "ffFormula"
		//else if it is equal to "END" the return the formula "[(<T>(tt))?](ff)"
		//else if it is equal "LAST" then return the formula "<T>([(<T>(tt))?](ff))"
		//else call the parser for the "propositionalFormula"
		if(ctx.getText().equals("tt")){
			return AtomicFormula.ttFormula();
		}
		else{
			if(ctx.getText().equals("ff")){
				return AtomicFormula.ffFormula();
			}
			else{
				if((ctx.getText().equals("END"))||(ctx.getText().equals("end"))||(ctx.getText().equals("End"))){
					return new LdlfBoxFormula<S>(AtomicFormula.ffFormula(),new Test<S>(new LdlfDiamondFormula<S>(AtomicFormula.ttFormula(), new Atom<S>(AtomicFormula.trueFormula()))));
				}
				else{
					if((ctx.getText().equals("LAST"))||(ctx.getText().equals("Last"))||(ctx.getText().equals("last"))){
						return new LdlfDiamondFormula<S>(new LdlfBoxFormula<S>(AtomicFormula.ffFormula(),new Test<S>(new LdlfDiamondFormula<S>(AtomicFormula.ttFormula(), new Atom<S>(AtomicFormula.trueFormula())))),new Atom<S>(AtomicFormula.trueFormula())); 
					}
					else{
						LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(0).getText()));
						LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
						ParseTree tree = parser.propositionalFormula();
						LDLfVisitorProp<S> implementation = new LDLfVisitorProp<S>(generic, alphabet);
						Formula<S> f = implementation.visit(tree);				    
						f=Operations.toNNF(f, false);	

						return f;
					}
				}
			}
		}
	}
		
	@Override
	public Formula<S> visitCheckAnd(@NotNull LDLfFormulaParserParser.CheckAndContext ctx){
			
		Formula<S> left;
		Formula<S> right;
		Formula<S> result=null;
			
		if(ctx.getChildCount()>1){
			if(ctx.getChildCount()==2){
				left= visit(ctx.getChild(0));
				right= visit(ctx.getChild(1));
				result=FormulaFactory.createBinaryFormula(Operator.andOperator,left,right);
			}
			else{
				for(int i=ctx.getChildCount()-1;i>=2;i=i-2){
					if(i==ctx.getChildCount()-1){
						left= visit(ctx.getChild(i-2));
						right= visit(ctx.getChild(i));
					}
					else{
						left= visit(ctx.getChild(i-2));
						right=result;
					}
					result=FormulaFactory.createBinaryFormula(Operator.andOperator,left,right);
				}
			}
			return result;	
		
		}
		else{			
			return visitChildren(ctx);
		}
	}
		
	@Override 
	public Formula<S> visitCheckImplication(@NotNull LDLfFormulaParserParser.CheckImplicationContext ctx){
		
		//If "CheckImplication" finds an "implication",
		//then returns the corresponding "BinaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==3){
			Formula<S> left= visit(ctx.getChild(0));
			Formula<S> right= visit(ctx.getChild(2));
				
			return FormulaFactory.createBinaryFormula(Operator.implicationOperator,left,right);
		}
		else{			
			return visitChildren(ctx);
		}
	}
		
	@Override 
	public Formula<S> visitCheckNot(@NotNull LDLfFormulaParserParser.CheckNotContext ctx){
			
		//If "CheckNot" finds a "not",
		//then returns the corresponding "UnaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==2){
			return FormulaFactory.createUnaryFormula(Operator.notOperator, visit(ctx.getChild(1)));
		}
		else{
			if(ctx.getChildCount()==4){
				return FormulaFactory.createUnaryFormula(Operator.notOperator, visit(ctx.getChild(2)));
			}
			else{
				if(ctx.getChildCount()==3){
					return visit(ctx.getChild(1));
				}
				else{
					return visitChildren(ctx);
				}
			}
		}
	}
		
	@Override 
	public Formula<S> visitCheckDiamond(@NotNull LDLfFormulaParserParser.CheckDiamondContext ctx){ 
		
		//If "CheckDiamond" finds a "diamond" 
	    //then return the corresponding "LdlfDiamondFormula" by invoking the visitor for regular expressions and exploiting the result in order to instantiate the formula
	    //else continues the visit
		if(ctx.getChildCount()==4){
			
			LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(1).getText()));
			LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
		    ParseTree tree = parser.regularExpression();
		    LDLfVisitorRegExp<S> implementation = new LDLfVisitorRegExp<S>(generic, alphabet);
		    RegularExpression<S> e = implementation.visit(tree);
		    
			Formula<S> formula= visit(ctx.getChild(3));

			return new LdlfDiamondFormula<S>(Operations.addTestToDiamondOrBox(formula,"diamond"),e);
		}
		else{
			return visitChildren(ctx);
		}
	}
	
	@Override 
	public Formula<S> visitCheckBox(@NotNull LDLfFormulaParserParser.CheckBoxContext ctx){
	
		//If "CheckBox" finds a "box" 
	    //then return the corresponding "LdlfBoxFormula" by invoking the visitor for regular expressions and exploiting the result in order to instantiate the formula
	    //else continues the visit
		if(ctx.getChildCount()==4){
			
			LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(1).getText()));
			LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
		    ParseTree tree = parser.regularExpression();
		    LDLfVisitorRegExp<S> implementation = new LDLfVisitorRegExp<S>(generic, alphabet);
		    RegularExpression<S> e = implementation.visit(tree);
		    
			Formula<S> formula= visit(ctx.getChild(3));
			
			return new LdlfBoxFormula<S>(Operations.addTestToDiamondOrBox(formula,"box"),e);
			
		}
		else{
			return visitChildren(ctx);
		}
	}
		
	@Override public Formula<S> visitStart(@NotNull LDLfFormulaParserParser.StartContext ctx) { return (Formula<S>) visitChildren(ctx); }
		
	@Override 
	public Formula<S> visitCheckdoubleImplication(@NotNull LDLfFormulaParserParser.CheckdoubleImplicationContext ctx){ 

		//If "CheckdoubleImplication" finds a "doubleImplication",
		//then returns the corresponding "BinaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==3){
			Formula<S> left= (Formula<S>) visit(ctx.getChild(0));
			Formula<S> right= (Formula<S>) visit(ctx.getChild(2));
					
			return FormulaFactory.createBinaryFormula(Operator.doubleImplicationOperator,left,right);
		}
		else{			
			return visitChildren(ctx);
		}
	}
		
	@Override 
	public Formula<S> visitCheckOr(@NotNull LDLfFormulaParserParser.CheckOrContext ctx){ 
		
		Formula<S> left;
		Formula<S> right;
		Formula<S> result=null;
			
		if(ctx.getChildCount()>1){
			if(ctx.getChildCount()==2){
				left= visit(ctx.getChild(0));
				right= visit(ctx.getChild(1));
				result=FormulaFactory.createBinaryFormula(Operator.orOperator,left,right);
			}
			else{
				for(int i=ctx.getChildCount()-1;i>=2;i=i-2){
					if(i==ctx.getChildCount()-1){
						left= visit(ctx.getChild(i-2));
						right= visit(ctx.getChild(i));
					}
					else{
						left= visit(ctx.getChild(i-2));
						right=result;
					}
					result=FormulaFactory.createBinaryFormula(Operator.orOperator,left,right);
				}
			}
			return result;	
		
		}
		else{			
			return visitChildren(ctx);
		}
	}
}

package visitors.LDLfVisitors;

import ldlfParser.LDLfFormulaParserBaseVisitor;
import ldlfParser.LDLfFormulaParserLexer;
import ldlfParser.LDLfFormulaParserParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import formula.AtomicFormula;
import formula.Formula;
import formula.LdlfDiamondFormula;
import formula.Operations;
import regularExpression.Atom;
import regularExpression.Concatenation;
import regularExpression.Or;
import regularExpression.RegularExpression;
import regularExpression.Star;
import regularExpression.Test;
import symbols.Alphabet;
import symbols.Symbol;

public class LDLfVisitorRegExp<S extends Symbol<?>> extends LDLfFormulaParserBaseVisitor<RegularExpression<S>> {

	private Class<S> generic;
	private Alphabet<S> alphabet;
	
	
	public LDLfVisitorRegExp(Class<S> generic, Alphabet<S> alphabet) {
		this.generic = generic;
		this.alphabet = alphabet;
	}
	
@Override public RegularExpression<S> visitRegularExpression(@NotNull LDLfFormulaParserParser.RegularExpressionContext ctx) { return (RegularExpression<S>) visitChildren(ctx); }
	
	@Override 
	public RegularExpression<S> visitCheckOrRegExp(@NotNull LDLfFormulaParserParser.CheckOrRegExpContext ctx){
		
		RegularExpression<S> left;
		RegularExpression<S> right;
		RegularExpression<S> result=null;
		
		if(ctx.getChildCount()>1){
			
			for(int i=ctx.getChildCount()-1;i>=2;i=i-2){
				if(i==ctx.getChildCount()-1){
					left= visit(ctx.getChild(i-2));
					right= visit(ctx.getChild(i));
				}
				else{
					left= visit(ctx.getChild(i-2));
					right=result;
				}
				result=new Or<S>(left,right);
			}
			
			return result;	
		
		}
		else{			
			return visitChildren(ctx);
		} 
	}
	
	@Override 
	public RegularExpression<S> visitCheckConcatenationRegExp(@NotNull LDLfFormulaParserParser.CheckConcatenationRegExpContext ctx){ 

		RegularExpression<S> left;
		RegularExpression<S> right;
		RegularExpression<S> result=null;
		
		if(ctx.getChildCount()>1){
			
			for(int i=ctx.getChildCount()-1;i>=2;i=i-2){
					
				if(i==ctx.getChildCount()-1){		
					left= visit(ctx.getChild(i-2));
					right= visit(ctx.getChild(i));
				}
				else{
					left= visit(ctx.getChild(i-2));
					right=result;
				}
					
				result=new Concatenation<S>(left,right);
				
			}
			
			return result;	
		
		}
		else{			
			return visitChildren(ctx);
		} 
	}
	
	@Override 
	public RegularExpression<S> visitCheckStar(@NotNull LDLfFormulaParserParser.CheckStarContext ctx){ 
		
		if(ctx.getChildCount()==4){
			return new Star<S>(visit(ctx.getChild(1)));
		}
		else{
			if(ctx.getChildCount()==2){
				return new Star<S>(visit(ctx.getChild(0)));
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
	public RegularExpression<S> visitCheckTest(@NotNull LDLfFormulaParserParser.CheckTestContext ctx){
		
		if(ctx.getChildCount()==4){
			
			LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(1).getText()));
			LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
		    ParseTree tree = parser.checkdoubleImplication();
		    LDLfVisitorFormula<S> implementation = new LDLfVisitorFormula<S>(generic, alphabet);
		    Formula<S> f = implementation.visit(tree);
		    
		    f=Operations.toNNF(f, false);
			
			return new Test<S>(f);
		}
		else{
			if(ctx.getChildCount()==2){
				
				LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(0).getText()));
				LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
			    ParseTree tree = parser.checkdoubleImplication();
			    LDLfVisitorFormula<S> implementation = new LDLfVisitorFormula<S>(generic, alphabet);
			    Formula<S> f = implementation.visit(tree);
			    
			    f=Operations.toNNF(f, false);
			    
				if(f.equals(AtomicFormula.trueFormula())){
					f=new LdlfDiamondFormula<S>(AtomicFormula.ttFormula(), new Atom<S>(AtomicFormula.trueFormula()));
				}
				else{
					if(f.equals(AtomicFormula.falseFormula())){
						f=new LdlfDiamondFormula<S>(AtomicFormula.ttFormula(), new Atom<S>(AtomicFormula.falseFormula()));
					}
				}
				
				return new Test<S>(f);
			}
			else{
				if(ctx.getChild(0).getText().equals("eps")){
					return new Test<S>(AtomicFormula.trueFormula());
				}
				else{
					
					LDLfFormulaParserLexer lexer = new LDLfFormulaParserLexer(new ANTLRInputStream(ctx.getChild(0).getText()));
					LDLfFormulaParserParser parser = new LDLfFormulaParserParser(new CommonTokenStream(lexer));
			    	ParseTree tree = parser.propositionalFormula();
			    	LDLfVisitorProp<S> implementation = new LDLfVisitorProp<S>(generic, alphabet);
			    	Formula<S> f = implementation.visit(tree);
			    
			    	f=Operations.toNNF(f, false);
			  
					return new Atom<S>(f);
				}
			}
		}
	}
	
}

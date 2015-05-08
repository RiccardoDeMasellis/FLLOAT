package visitors.LDLfVisitors;

import ldlfParser.LDLfFormulaParserBaseVisitor;
import ldlfParser.LDLfFormulaParserParser;
import operator.Operator;

import org.antlr.v4.runtime.misc.NotNull;

import symbols.*;
import formula.AtomicFormula;
import formula.Formula;
import formula.FormulaFactory;
import java.lang.reflect.*;

public class LDLfVisitorProp<S extends Symbol<?>> extends LDLfFormulaParserBaseVisitor<Formula<S>> {
	
	private Alphabet<S> alphabet;
	private Class<S> generic;
	
	public LDLfVisitorProp(Class<S> generic, Alphabet<S> alphabet) {
		this.generic = generic;
		this.alphabet = alphabet;
	}
	
	@Override public Formula<S> visitPropositionalFormula(@NotNull LDLfFormulaParserParser.PropositionalFormulaContext ctx) { return visitChildren(ctx); }
	
	@Override 
	public Formula<S> visitCheckImplicationProp(@NotNull LDLfFormulaParserParser.CheckImplicationPropContext ctx){
		
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
	public Formula<S> visitCheckAndProp(@NotNull LDLfFormulaParserParser.CheckAndPropContext ctx){ 
		
		Formula<S> left;
		Formula<S> right;
		Formula<S> result=null;
		
		if(ctx.getChildCount()>1){
			
			for(int i=ctx.getChildCount()-1;i>=2;i=i-2){
				if(i==ctx.getChildCount()-1){
					left=visit(ctx.getChild(i-2));
					right=visit(ctx.getChild(i));
				}
				else{
					left=visit(ctx.getChild(i-2));
					right=result;
				}
				result=FormulaFactory.createBinaryFormula(Operator.andOperator,left,right);
			}
			
			return result;	
		
		}
		else
		{			
			return visitChildren(ctx);
		}
	}
		
	@Override 
	public Formula<S> visitCheckNotProp(@NotNull LDLfFormulaParserParser.CheckNotPropContext ctx){ 
		
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
	public Formula<S> visitCheckdoubleImplicationProp(@NotNull LDLfFormulaParserParser.CheckdoubleImplicationPropContext ctx){
		
		//If "CheckdoubleImplication" finds a "doubleImplication",
		//then returns the corresponding "BinaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==3){
			Formula<S> left= visit(ctx.getChild(0));
			Formula<S> right= visit(ctx.getChild(2));
						
			return FormulaFactory.createBinaryFormula(Operator.doubleImplicationOperator,left,right);
		}
		else{			
			return visitChildren(ctx);
		} 
	}
		
	@Override 
	public Formula<S> visitCheckOrProp(@NotNull LDLfFormulaParserParser.CheckOrPropContext ctx){
		
		Formula<S> left;
		Formula<S> right;
		Formula<S> result=null;
		
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
				result=FormulaFactory.createBinaryFormula(Operator.orOperator,left,right);
			}
			
			return result;	
		
		}
		else
		{			
			return visitChildren(ctx);
		}
	}
	
	@Override 
	public Formula<S> visitAtom(@NotNull LDLfFormulaParserParser.AtomContext ctx){
			
		//When I visit an "Atom",
		//if it is equal "TRUE" then return the "trueFormula",
		//else if it is equal "FALSE" then return the "falseFormula"
		//else instantiate a new "Symbol" 
		//add it to the "Alphabet"
		//add the "epsilonSymbol" to the alphabet
		//return the "AtomicFormula" associated to the "Symbol"
		if((ctx.getText().equals("TRUE"))||(ctx.getText().equals("True"))||(ctx.getText().equals("true"))||(ctx.getText().equals("T"))){
			return AtomicFormula.trueFormula();
		}
		else{
			if((ctx.getText().equals("FALSE"))||(ctx.getText().equals("False"))||(ctx.getText().equals("false"))){
				return AtomicFormula.falseFormula();
			}
			else{
				S symbol=null;
				try {
					symbol = generic.getConstructor(String.class).newInstance(ctx.getText());
				} catch (InstantiationException | IllegalAccessException
						| IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				alphabet.addSymbol(symbol);
				return new AtomicFormula<S>(symbol);
			}
		}
	}
}

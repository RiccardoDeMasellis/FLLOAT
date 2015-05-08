package visitors.LTLfVisitors;

import ltlfParser.LTLfFormulaParserBaseVisitor;
import ltlfParser.LTLfFormulaParserParser;
import org.antlr.v4.runtime.misc.NotNull;

import symbols.*;
import formula.*;
import operator.*;
import utils.*;

import java.lang.reflect.*;
import java.util.Arrays;

public class LTLfVisitor<S extends Symbol<?>> extends LTLfFormulaParserBaseVisitor<Formula<S>> {

	private Alphabet<S> alphabet;
	private Class<S> generic;

	public LTLfVisitor(Class<S> generic) {
		alphabet = new Alphabet<S>();
		this.generic = generic;
	}

	public Class<S> getGeneric() {
		return generic;
	}

	public Alphabet<S> getAlphabet() {
		return alphabet;
	}


	@Override 
	public Formula<S> visitExpression(@NotNull LTLfFormulaParserParser.ExpressionContext ctx) {return visitChildren(ctx);}

	@Override 
	public Formula<S> visitAtom(@NotNull LTLfFormulaParserParser.AtomContext ctx){
		//When I visit an "Atom",
		//if it is equal "TRUE" then return the "trueFormula",
		//else if it is equal "FALSE" then return the "falseFormula"
		//else if it is equal "LAST" then return the "WeakNextFormula" that has like "unaryFormula" the "falseFormula"
		//else I instantiate a new "Symbol" 
		//add it to the "Alphabet"
		//return the "AtomicFormula" associated to the "Symbol"
		if((ctx.getText().equals("TRUE"))||(ctx.getText().equals("True"))||(ctx.getText().equals("true"))){
			return AtomicFormula.trueFormula();
		}
		else
		{
			if((ctx.getText().equals("FALSE"))||(ctx.getText().equals("False"))||(ctx.getText().equals("false"))){
				return AtomicFormula.falseFormula();
			}
			else{
				if((ctx.getText().equals("LAST"))||(ctx.getText().equals("Last"))||(ctx.getText().equals("last"))){
					return new WeakNextFormula<S>(AtomicFormula.falseFormula());
				}
				else{
					//Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
					//Class sClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

					//Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];


					S symbol=null;
					try {
						symbol = (S) generic.getConstructor(String.class).newInstance(ctx.getText());
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



	@Override 
	public Formula<S> visitCheckAnd(@NotNull LTLfFormulaParserParser.CheckAndContext ctx) { 

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
	public Formula<S> visitCheckImplication(@NotNull LTLfFormulaParserParser.CheckImplicationContext ctx){ 

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
	public Formula<S> visitCheckNot(@NotNull LTLfFormulaParserParser.CheckNotContext ctx){

		//If "CheckNot" finds a "not",
		//then returns the corresponding "UnaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==2){
			return FormulaFactory.createUnaryFormula(Operator.notOperator, visit(ctx.getChild(1)));
		}
		else{
			if(ctx.getChildCount()==4){
				return FormulaFactory.createUnaryFormula(Operator.notOperator, visit(ctx.getChild(2)));
			}else{
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
	public Formula<S> visitCheckUntil(@NotNull LTLfFormulaParserParser.CheckUntilContext ctx){ 

		//If "CheckUntil" finds an "until",
		//then returns the corresponding "BinaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==3){
			Formula<S> left= visit(ctx.getChild(0));
			Formula<S> right= visit(ctx.getChild(2));

			return FormulaFactory.createBinaryFormula(Operator.untilOperator,left,right);
		}
		else{			
			return visitChildren(ctx);
		}
	}

	@Override 
	public Formula<S> visitCheckNext(@NotNull LTLfFormulaParserParser.CheckNextContext ctx){

		//If "CheckNext" finds a "next",
		//then returns the corresponding "UnaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==2){
			return FormulaFactory.createUnaryFormula(Operator.nextOperator, visit(ctx.getChild(1)));
		}
		else{			
			return visitChildren(ctx);
		}
	}

	@Override 
	public Formula<S> visitCheckWeakUntil(@NotNull LTLfFormulaParserParser.CheckWeakUntilContext ctx){ 

		//If "CheckUntil" finds a "weakUntil",
		//then returns the corresponding "BinaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==3){
			Formula<S> left= visit(ctx.getChild(0));
			Formula<S> right= visit(ctx.getChild(2));

			return FormulaFactory.createBinaryFormula(Operator.weakUntilOperator,left,right);
		}
		else{			
			return visitChildren(ctx);
		}
	}

	@Override 
	public Formula<S> visitCheckGlobally(@NotNull LTLfFormulaParserParser.CheckGloballyContext ctx){

		//If "CheckGlobally" finds a "globally",
		//then returns the corresponding "UnaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==2){
			return FormulaFactory.createUnaryFormula(Operator.globallyOperator, visit(ctx.getChild(1)));
		}
		else{			
			return visitChildren(ctx);
		}
	}

	@Override 
	public Formula<S> visitCheckEventually(@NotNull LTLfFormulaParserParser.CheckEventuallyContext ctx){

		//If "CheckEventually" finds an "eventually",
		//then returns the corresponding "UnaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==2){
			return FormulaFactory.createUnaryFormula(Operator.eventuallyOperator, visit(ctx.getChild(1)));
		}
		else{			
			return visitChildren(ctx);
		}
	}

	@Override 
	public Formula<S> visitCheckWeakNext(@NotNull LTLfFormulaParserParser.CheckWeakNextContext ctx){

		//If "CheckWeakNext" finds a "weakNext",
		//then returns the corresponding "UnaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==2){
			return FormulaFactory.createUnaryFormula(Operator.weakNextOperator, visit(ctx.getChild(1)));
		}
		else{			
			return visitChildren(ctx);
		}
	}

	@Override 
	public Formula<S> visitStart(@NotNull LTLfFormulaParserParser.StartContext ctx){return visitChildren(ctx);}

	@Override 
	public Formula<S> visitCheckdoubleImplication(@NotNull LTLfFormulaParserParser.CheckdoubleImplicationContext ctx){

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
	public Formula<S> visitCheckRelease(@NotNull LTLfFormulaParserParser.CheckReleaseContext ctx){

		//If "CheckRelease" finds a "release",
		//then returns the corresponding "BinaryFormula"
		//else continues the visit
		if(ctx.getChildCount()==3){
			Formula<S> left= visit(ctx.getChild(0));
			Formula<S> right= visit(ctx.getChild(2));

			return FormulaFactory.createBinaryFormula(Operator.releaseOperator,left,right);
		}
		else{			
			return visitChildren(ctx);
		}
	}

	@Override 
	public Formula<S> visitCheckOr(@NotNull LTLfFormulaParserParser.CheckOrContext ctx){

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

}

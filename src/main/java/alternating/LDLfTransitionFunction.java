package alternating;

import evaluations.EpsilonEvaluation;
import evaluations.Evaluation;
import formula.*;
import formula.ldlf.*;
import formula.operator.Operator;
import formula.propositional.FalsePropFormula;
import formula.propositional.TruePropFormula;
import formula.regularExpression.*;
import symbols.Symbol;

public class LDLfTransitionFunction {

    //If the formula is a "TempBinaryFormula" then return the result of the call of "expandBinaryOperator(formula,symbol,last)"
    //else
    //return the result of the call of "evaluate(formula,symbol,last)"
    public static <S extends Symbol<?>> Formula<S> alternatingTransition(Formula<S> formula, Evaluation<S> eval, boolean last) {

        formula = Operations.toNNF(formula, false);

        if (formula instanceof TempBinaryFormula) {
            return expandBinaryOperator(formula, eval, last);
        } else {
            return evaluate(formula, eval, last);
        }
    }


    //Analyzing the type of the "Formula" return the result of the call of the right method
    private static <S extends Symbol<?>> Formula<S> expandBinaryOperator(Formula<S> formula, Evaluation<S> eval, boolean last) {

        Formula<S> result = null;

        if (formula instanceof TempAndFormula) {
            return and((TempAndFormula<S>) formula, eval, last);
        }
        if (formula instanceof TempOrFormula) {
            return or((TempOrFormula<S>) formula, eval, last);
        }

        return result;
    }


    //Analyzing the type of the "Formula" return the result of the call of the right method
    private static <S extends Symbol<?>> Formula<S> evaluate(Formula<S> formula, Evaluation<S> eval, boolean last) {

        Formula<S> result = null;

        if (formula instanceof LDLfDiamondFormula) {
            return ldlfDiamond((LDLfDiamondFormula<S>) formula, eval, last);
        }

        if (formula instanceof LDLfBoxFormula) {
            return ldlfBox((LDLfBoxFormula<S>) formula, eval, last);
        }

        if (formula instanceof TempNotFormula) {
            return notFormula((TempNotFormula<S>) formula, eval, last);
        }

        if (formula instanceof LDLfAtomicFormula) {
            return atomicFormula((LDLfAtomicFormula<S>) formula, eval, last);
        }

        return result;
    }


    //If I have the "ttFormula", then return the "trueFormula"
    //else, if I have the "ffFormula", then return the "falseFormula"
    //else, if the "symbol" model the atomic formula, then return "trueFormula", else return the "falseFormula"
    private static <S extends Symbol<?>> Formula<S> atomicFormula(LDLfAtomicFormula<S> formula, Evaluation<S> eval, boolean last) {

        //In case of "epsilonSymbol" return "trueFormula" if formula is equal to "ttFormula",
        //return false, if formula is equal to "ffFormula"
        //return false, for every other cases
        if (eval instanceof EpsilonEvaluation) {
            if (formula.equals(new ttAtomicFormula<>())) {
                return new TruePropFormula<>();
            } else {
                if (formula.equals(new ffAtomicFormula<>())) {
                    return new FalsePropFormula<>();
                } else {
                    return new FalsePropFormula<>();
                }
            }
        } else {
            if (formula.equals(new ttAtomicFormula<>())) {
                return new TruePropFormula<>();
            } else {
                if (formula.equals(new ffAtomicFormula<>())) {
                    return new FalsePropFormula<>();
                } else {
                    if (Operations.modelPropositionalFormula(formula, eval)) {
                        return new TruePropFormula<>();
                    } else {
                        return new FalsePropFormula<>();
                    }
                }
            }
        }
    }


    //If the symbol model the "TempNotFormula" return the "trueFormula", else return the "falseFormula"
    private static <S extends Symbol<?>> Formula<S> notFormula(TempNotFormula<S> formula, Evaluation<S> eval, boolean last) {

        //In case of "epsilonSymbol" return always "trueFormula"
        if (eval instanceof EpsilonEvaluation) {
            return new TruePropFormula<>();
        } else {
            if (formula.equals(new ttAtomicFormula<>())) {
                return new TruePropFormula<>();
            } else {
                if (formula.equals(new ffAtomicFormula<>())) {
                    return new FalsePropFormula<>();
                } else {
                    if (Operations.modelPropositionalFormula(formula, eval)) {
                        return new TruePropFormula<>();
                    } else {
                        return new FalsePropFormula<>();
                    }
                }
            }
        }
    }


    //It analyzes the "TempAndFormula"
    private static <S extends Symbol<?>> Formula<S> and(TempAndFormula<S> formula, Evaluation<S> eval, boolean last) {

        Formula<S> result = null;
        Formula<S> leftResult = null;
        Formula<S> rightResult = null;

        leftResult = alternatingTransition(formula.getLeftSide(), eval, last);

        //If the result of the "alternatingTransition(formula,symbol,last)" applied to the "leftSide" of the formula is an "LDLfAtomicFormula"
        if (leftResult instanceof LDLfAtomicFormula) {

            //if the "leftResult" is equal to "falseFormula", then stop the computation and return "falseFormula", else evaluate the "rigthSide" of the "TempAndFormula"
            if (leftResult.equals(new FalsePropFormula<>())) {
                result = new FalsePropFormula<>();
            } else {
                rightResult = alternatingTransition(formula.getRightSide(), eval, last);

                //If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "LDLfAtomicFormula"
                if (rightResult instanceof LDLfAtomicFormula) {

                    //if the "rightResult" is equal to "falseFormula", then stop the computation and return "falseFormula"
                    if (rightResult.equals(new FalsePropFormula<>())) {
                        result = new FalsePropFormula<>();
                    } else {
                        //If both "rightResult" and "leftResult" are equal to "trueFormula", then return "trueFormula"
                        if ((leftResult.equals(new TruePropFormula<>())) &&
                                (rightResult.equals(new TruePropFormula<>()))) {
                            result = new TruePropFormula<>();
                        }

                        //If both "leftResult" and "rightResult" are different from "trueFormula"
                        if (!(leftResult.equals(new TruePropFormula<>())) &&
                                !(rightResult.equals(new TruePropFormula<>()))) {
                            //If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
                            if (leftResult.equals(rightResult)) {
                                result = leftResult;
                            } else {
                                result = FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);
                            }
                        }

                        //If "leftResult" is different from "trueFormula", and "rightResult" is equal to "trueFormula", then return the "leftResult"
                        if (!(leftResult.equals(new TruePropFormula<>())) &&
                                (rightResult.equals(new TruePropFormula<>()))) {
                            result = leftResult;
                        }

                        //If "rightResult" is different from "trueFormula", and "leftResult" is equal to "trueFormula", then return the "rightResult"
                        if ((leftResult.equals(new TruePropFormula<>())) &&
                                !(rightResult.equals(new TruePropFormula<>()))) {
                            result = rightResult;
                        }
                    }
                } else {
                    //leftResult is an "LDLfAtomicFormula" different from "falseFormula"
                    //rightResult is not an "LDLfAtomicFormula"
                    //If leftResult is equal "trueFormula" return "rightResult"
                    if (leftResult.equals(new TruePropFormula<>())) {
                        result = rightResult;
                    }
                    //else "leftResult" is an "LDLfAtomicFormula" different from "trueFormula" and "rightResult" is not an "LDLfAtomicFormula",
                    //then result is equal to the call of "checkIsPartOf"
                    else {
                        result = FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);
                    }
                }
            }
        } else {
            //leftResult is not an "LDLfAtomicFormula" (surely is different from "falseFormula")
            rightResult = alternatingTransition(formula.getRightSide(), eval, last);

            //If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "LDLfAtomicFormula"
            if (rightResult instanceof LDLfAtomicFormula) {

                //if the "rightResult" is equal to "falseFormula", then stop the computation and return false
                if (rightResult.equals(new FalsePropFormula<>())) {
                    result = new FalsePropFormula<>();
                } else {

                    //if the "rightResult" is equal to "trueFormula", then return "leftResult"
                    if (rightResult.equals(new TruePropFormula<>())) {
                        result = leftResult;
                    } else {
                        //If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
                        if (leftResult.equals(rightResult)) {
                            result = leftResult;
                        } else {
                            result = FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);
                        }
                    }
                }
            }
            //Both leftResult and rightResult are not Atomic
            else {
                //If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
                if (leftResult.equals(rightResult)) {
                    result = leftResult;
                } else {
                    result = FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);
                }
            }
        }

        return result;
    }


    //It analyzes the "TempOrFormula"
    private static <S extends Symbol<?>> Formula<S> or(TempOrFormula<S> formula, Evaluation<S> eval, boolean last) {

        Formula<S> result = null;
        Formula<S> leftResult = null;
        Formula<S> rightResult = null;

        leftResult = alternatingTransition(formula.getLeftSide(), eval, last);

        //If the result of the "alternatingTransition(formula,symbol,last)" applied to the "leftSide" of the formula is an "LDLfAtomicFormula"
        if (leftResult instanceof LDLfAtomicFormula) {

            //if the "leftResult" is equal to "trueFormula", then stop the computation and return "trueFormula", else evaluate the "rigthSide" of the "TempOrFormula"
            if (leftResult.equals(new TruePropFormula<>())) {
                result = new TruePropFormula<>();
            } else {
                rightResult = alternatingTransition(formula.getRightSide(), eval, last);

                //If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "LDLfAtomicFormula"
                if (rightResult instanceof LDLfAtomicFormula) {


                    //if the "rightResult" is equal to "trueFormula", then stop the computation and return "trueFormula"
                    if (rightResult.equals(new TruePropFormula<>())) {
                        result = new TruePropFormula<>();
                    } else {

                        //If both "rightResult" and "leftResult" are equal to "falseFormula", then return "falseFormula"
                        if ((leftResult.equals(new FalsePropFormula<>())) &&
                                (rightResult.equals(new FalsePropFormula<>()))) {
                            result = new FalsePropFormula<>();
                        }

                        //If both "leftResult" and "rightResult" are different from "falseFormula"
                        if (!(leftResult.equals(new FalsePropFormula<>())) &&
                                !(rightResult.equals(new FalsePropFormula<>()))) {
                            //If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
                            if (leftResult.equals(rightResult)) {
                                result = leftResult;
                            } else {
                                result = FormulaFactory.createBinaryFormula(Operator.orOperator, leftResult, rightResult);
                            }
                        }

                        //If "leftResult" is different from "falseFormula", and "rightResult" is equal to "falseFormula", then return the "leftResult"
                        if (!(leftResult.equals(new FalsePropFormula<>())) &&
                                (rightResult.equals(new FalsePropFormula<>()))) {
                            result = leftResult;
                        }

                        //If "rightResult" is different from "falseFormula", and "leftResult" is equal to "falseFormula", then return the "rightResult"
                        if ((leftResult.equals(new FalsePropFormula<>())) &&
                                !(rightResult.equals(new FalsePropFormula<>()))) {
                            result = rightResult;
                        }
                    }
                } else {
                    //leftResult is an "LDLfAtomicFormula" different from "trueFormula"
                    //rightResult is not an "LDLfAtomicFormula"
                    //If leftResult is equal "falseFormula" return "rightResult"
                    if (leftResult.equals(new FalsePropFormula<>())) {
                        result = rightResult;
                    }
                    //else "leftResult" is an "LDLfAtomicFormula" different from "falseFormula" and "rightResult" is not an "LDLfAtomicFormula",
                    //then result is equal to the call of "checkIsPartOf"
                    else {
                        result = FormulaFactory.createBinaryFormula(Operator.orOperator, leftResult, rightResult);
                    }
                }
            }
        } else {
            //leftResult is not an "LDLfAtomicFormula" (surely is different from "trueFormula")
            rightResult = alternatingTransition(formula.getRightSide(), eval, last);

            //If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "LDLfAtomicFormula"
            if (rightResult instanceof LDLfAtomicFormula) {

                //if the "rightResult" is equal to "trueFormula", then stop the computation and return "trueFormula"
                if (rightResult.equals(new TruePropFormula<>())) {
                    result = new TruePropFormula<>();
                } else {

                    //if the "rightResult" is equal to "falseFormula", then return "leftResult"
                    if (rightResult.equals(new FalsePropFormula<>())) {
                        result = leftResult;
                    } else {
                        //If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
                        if (leftResult.equals(rightResult)) {
                            result = leftResult;
                        } else {
                            result = FormulaFactory.createBinaryFormula(Operator.orOperator, leftResult, rightResult);
                        }
                    }
                }
            }
            //Both leftResult and rightResult are not Atomic
            else {
                //If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
                if (leftResult.equals(rightResult)) {
                    result = leftResult;
                } else {
                    result = FormulaFactory.createBinaryFormula(Operator.orOperator, leftResult, rightResult);
                }
            }

        }
        return result;
    }


    //It analyzes "ldlfDiamondFormula" for all the possible cases
    private static <S extends Symbol<?>> Formula<S> ldlfDiamond(LDLfDiamondFormula<S> formula, Evaluation<S> eval, boolean last) {

        Formula<S> result = null;
        //In case of "epsilonTransition"
        if (eval instanceof EpsilonEvaluation) {

            //If the expression inside the "LDLfDiamondFormula" is a "Test", then return the evaluation of the and between the formula
            //inside the "Test" Operator and the formula outside the diamond
            if (formula.getExpression() instanceof Test) {

                Formula<S> newFormula = Operations.toNNF(((Test<S>) formula.getExpression()).getFormula(), false);
                result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, newFormula, formula.getUnaryFormula()), eval, last);
            } else {
                //If the expression inside the "LDLfDiamondFormula" is an "RegExpOr", then return the evaluation of the or between the two "LDLfDiamondFormula" obtained
                //by separation of the two expression
                if (formula.getExpression() instanceof RegExpOr) {

                    LDLfDiamondFormula<S> newLeftSide = new LDLfDiamondFormula<S>(formula.getUnaryFormula(), ((RegExpOr<S>) formula.getExpression()).getLeftSide());
                    LDLfDiamondFormula<S> newRightSide = new LDLfDiamondFormula<S>(formula.getUnaryFormula(), ((RegExpOr<S>) formula.getExpression()).getRightSide());

                    result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, newLeftSide, newRightSide), eval, last);
                } else {
                    //If the expression inside the "LDLfDiamondFormula" is a "Concatenation", then return the evaluation of the "LDLfDiamondFormula" that have as expression
                    //the first expression of the concatenation and as formula outside the diamond the "LDLfDiamondFormula" with as expression the second expression
                    //of the concatenation and as formula outside the diamond the original formula outside the diamond
                    if (formula.getExpression() instanceof Concatenation) {

                        RegularExpression<S> firstExpression = ((Concatenation<S>) formula.getExpression()).getLeftSide();
                        RegularExpression<S> secondExpression = ((Concatenation<S>) formula.getExpression()).getRightSide();
                        LDLfDiamondFormula<S> f = new LDLfDiamondFormula<S>(formula.getUnaryFormula(), secondExpression);

                        result = alternatingTransition(new LDLfDiamondFormula<S>(f, firstExpression), eval, last);
                    } else {
                        //If the expression inside the "LDLfDiamondFormula" is a Star, then return the formula outside the diamond
                        if (formula.getExpression() instanceof Star) {
                            result = alternatingTransition(formula.getUnaryFormula(), eval, last);
                        } else {
                            //In any other case, return the "falseFormula"
                            result = new FalsePropFormula<>();
                        }
                    }
                }
            }
        } else {
            //If the expression inside the "LDLfDiamondFormula" is a "Test", then return the evaluation of the and between the formula
            //inside the "Test" Operator and the formula outside the diamond
            if (formula.getExpression() instanceof Test) {

                Formula<S> newFormula = Operations.toNNF(((Test<S>) formula.getExpression()).getFormula(), false);

                result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, newFormula, formula.getUnaryFormula()), eval, last);
            } else {
                //If the expression inside the "LDLfDiamondFormula" is an "RegExpOr", then return the evaluation of the or between the two "LDLfDiamondFormula" obtained
                //by separation of the two expression
                if (formula.getExpression() instanceof RegExpOr) {

                    LDLfDiamondFormula<S> newLeftSide = new LDLfDiamondFormula<S>(formula.getUnaryFormula(), ((RegExpOr<S>) formula.getExpression()).getLeftSide());
                    LDLfDiamondFormula<S> newRightSide = new LDLfDiamondFormula<S>(formula.getUnaryFormula(), ((RegExpOr<S>) formula.getExpression()).getRightSide());

                    result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, newLeftSide, newRightSide), eval, last);
                } else {
                    //If the expression inside the "LDLfDiamondFormula" is a "Concatenation", then return the evaluation of the "LDLfDiamondFormula" that have as expression
                    //the first expression of the concatenation and as formula outside the diamond the "LDLfDiamondFormula" with as expression the second expression
                    //of the concatenation and as formula outside the diamond the original formula outside the diamond
                    if (formula.getExpression() instanceof Concatenation) {

                        RegularExpression<S> firstExpression = ((Concatenation<S>) formula.getExpression()).getLeftSide();
                        RegularExpression<S> secondExpression = ((Concatenation<S>) formula.getExpression()).getRightSide();
                        LDLfDiamondFormula<S> f = new LDLfDiamondFormula<S>(formula.getUnaryFormula(), secondExpression);

                        result = alternatingTransition(new LDLfDiamondFormula<S>(f, firstExpression), eval, last);
                    } else {
                        //If the expression inside the "LDLfDiamondFormula" is a Star and the expression inside the LDLfDiamondFormula
                        //is a "Test only", then return the formula outside the diamond
                        //else return the evaluation of the "or" between the formula outside the diamond and the "LDLfDiamondFormula" that has as expression, the
                        //original expression without the star formula.operator, and as formula the original formula
                        if (formula.getExpression() instanceof Star) {
                            if (RegExpOperations.isTestOnly((((Star<S>) formula.getExpression()).getExpression()))) {
                                result = alternatingTransition(formula.getUnaryFormula(), eval, last);
                            } else {

                                RegularExpression<S> insideStar = ((Star<S>) formula.getExpression()).getExpression();

                                result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, formula.getUnaryFormula(), new LDLfDiamondFormula<S>(formula, insideStar)), eval, last);
                            }
                        } else {
                            //In case of "RegExPropFormula" as expression
                            if (formula.getExpression() instanceof RegExPropFormula) {
                                //If "last" is "true" and the "symbol" model the formula associated to the "RegExPropFormula", then return the result of the evaluation
                                //for the "espilonSymbol"
                                //else if "last" is "false" and the "symbol" model the formula associated to the "RegExPropFormula", then return the formula associated to the "RegExPropFormula"
                                //else return the "falseFormula"
                                if ((last == true) && (Operations.modelPropositionalFormula(((RegExPropFormula<S>) formula.getExpression()).getFormula(), eval) == true)) {

                                    result = alternatingTransition(formula.getUnaryFormula(), new EpsilonEvaluation(), last);
                                } else {
                                    if ((last == false) && (Operations.modelPropositionalFormula(((RegExPropFormula<S>) formula.getExpression()).getFormula(), eval) == true)) {
                                        if (formula.getUnaryFormula().equals(new ttAtomicFormula<>())) {
                                            result = new TruePropFormula<>();
                                        } else {
                                            if (formula.getUnaryFormula().equals(new ffAtomicFormula<>())) {
                                                result = new FalsePropFormula<>();
                                            } else {
                                                result = formula.getUnaryFormula();
                                            }
                                        }
                                    } else {
                                        if (Operations.modelPropositionalFormula(((RegExPropFormula<S>) formula.getExpression()).getFormula(), eval) == false) {
                                            result = new FalsePropFormula<>();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }


    //It analyzes "LDLfBoxFormula" for all the possible cases
    private static <S extends Symbol<?>> Formula<S> ldlfBox(LDLfBoxFormula<S> formula, Evaluation<S> eval, boolean last) {

        Formula<S> result = null;
        //In case of "epsilonTransition"
        if (eval instanceof EpsilonEvaluation) {

            //If the expression inside the "LDLfBoxFormula" is a "Test", then return the evaluation of the and between the negation of the formula
            //inside the "Test" Operator and the formula outside the box
            if (formula.getExpression() instanceof Test) {

                TempNotFormula<S> notFormula = new TempNotFormula<S>(((Test<S>) formula.getExpression()).getFormula());
                Formula<S> leftFormula = Operations.toNNF(notFormula, false);

                result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, leftFormula, formula.getUnaryFormula()), eval, last);
            } else {
                //If the expression inside the "LDLfBoxFormula" is an "RegExpOr", then return the evaluation of the or between the two "LDLfBoxFormula" obtained
                //by separation of the two expression
                if (formula.getExpression() instanceof RegExpOr) {

                    LDLfBoxFormula<S> newLeftSide = new LDLfBoxFormula<S>(formula.getUnaryFormula(), ((RegExpOr<S>) formula.getExpression()).getLeftSide());
                    LDLfBoxFormula<S> newRightSide = new LDLfBoxFormula<S>(formula.getUnaryFormula(), ((RegExpOr<S>) formula.getExpression()).getRightSide());

                    result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, newLeftSide, newRightSide), eval, last);
                } else {
                    //If the expression inside the "LDLfBoxFormula" is a "Concatenation", then return the evaluation of the "LDLfBoxFormula" that have as expression
                    //the first expression of the concatenation and as formula outside the box the "LDLfBoxFormula" with as expression the second expression
                    //of the concatenation and as formula outside the box the original formula outside the box
                    if (formula.getExpression() instanceof Concatenation) {

                        RegularExpression<S> firstExpression = ((Concatenation) formula.getExpression()).getLeftSide();
                        RegularExpression<S> secondExpression = ((Concatenation) formula.getExpression()).getRightSide();
                        LDLfBoxFormula<S> f = new LDLfBoxFormula<S>(formula.getUnaryFormula(), secondExpression);

                        result = alternatingTransition(new LDLfBoxFormula<S>(f, firstExpression), eval, last);
                    } else {
                        //If the expression inside the "LDLfBoxFormula" is a Star, then return the formula outside the box
                        if (formula.getExpression() instanceof Star) {
                            result = alternatingTransition(formula.getUnaryFormula(), eval, last);
                        } else {
                            //In any other case, return the "trueFormula"
                            result = new TruePropFormula<>();
                        }
                    }
                }
            }
        } else {
            //If the expression inside the "LDLfBoxFormula" is a "Test", then return the evaluation of the and between the negation of the formula
            //inside the "Test" Operator and the formula outside the box
            if (formula.getExpression() instanceof Test) {

                TempNotFormula<S> notFormula = new TempNotFormula<S>(((Test<S>) formula.getExpression()).getFormula());
                Formula<S> leftFormula = Operations.toNNF(notFormula, false);

                result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, leftFormula, formula.getUnaryFormula()), eval, last);
            } else {
                //If the expression inside the "LDLfBoxFormula" is an "RegExpOr", then return the evaluation of the or between the two "LDLfBoxFormula" obtained
                //by separation of the two expression
                if (formula.getExpression() instanceof RegExpOr) {

                    LDLfBoxFormula<S> newLeftSide = new LDLfBoxFormula<S>(formula.getUnaryFormula(), ((RegExpOr<S>) formula.getExpression()).getLeftSide());
                    LDLfBoxFormula<S> newRightSide = new LDLfBoxFormula<S>(formula.getUnaryFormula(), ((RegExpOr<S>) formula.getExpression()).getRightSide());

                    result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, newLeftSide, newRightSide), eval, last);
                } else {
                    //If the expression inside the "LDLfBoxFormula" is a "Concatenation", then return the evaluation of the "LDLfBoxFormula" that have as expression
                    //the first expression of the concatenation and as formula outside the box the "LDLfBoxFormula" with as expression the second expression
                    //of the concatenation and as formula outside the box the original formula outside the box
                    if (formula.getExpression() instanceof Concatenation) {

                        RegularExpression<S> firstExpression = ((Concatenation<S>) formula.getExpression()).getLeftSide();
                        RegularExpression<S> secondExpression = ((Concatenation<S>) formula.getExpression()).getRightSide();
                        LDLfBoxFormula<S> f = new LDLfBoxFormula<S>(formula.getUnaryFormula(), secondExpression);

                        result = alternatingTransition(new LDLfBoxFormula<S>(f, firstExpression), eval, last);
                    } else {
                        //If the expression inside the "LDLfBoxFormula" is a Star and the expression inside the LDLfBoxFormula
                        //is a "Test only", then return the formula outside the box
                        //else return the evaluation of the "and" between the formula outside the box and the "LDLfBoxFormula" that has as expression, the
                        //original expression without the star formula.operator, and as formula the original formula
                        if (formula.getExpression() instanceof Star) {
                            if (RegExpOperations.isTestOnly((((Star<S>) formula.getExpression()).getExpression()))) {
                                result = alternatingTransition(formula.getUnaryFormula(), eval, last);
                            } else {
                                RegularExpression<S> insideStar = ((Star<S>) formula.getExpression()).getExpression();

                                result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, formula.getUnaryFormula(), new LDLfBoxFormula<S>(formula, insideStar)), eval, last);
                            }
                        } else {
                            //In case of "RegExPropFormula" as expression
                            if (formula.getExpression() instanceof RegExPropFormula) {
                                //If "last" is "true" and the "symbol" model the formula associated to the "RegExPropFormula", then return the result of the evaluation
                                //for the "espilonSymbol"
                                //else if "last" is "false" and the "symbol" model the formula associated to the "RegExPropFormula", then return the formula associated to the "RegExPropFormula"
                                //else return the "trueFormula"
                                if ((last == true) && (Operations.modelPropositionalFormula(((RegExPropFormula<S>) formula.getExpression()).getFormula(), eval) == true)) {

                                    result = alternatingTransition(formula.getUnaryFormula(), new EpsilonEvaluation(), last);
                                } else {
                                    if ((last == false) && (Operations.modelPropositionalFormula(((RegExPropFormula<S>) formula.getExpression()).getFormula(), eval) == true)) {
                                        if (formula.getUnaryFormula().equals(new ttAtomicFormula<>())) {
                                            result = new TruePropFormula<>();
                                        } else {
                                            if (formula.getUnaryFormula().equals(new ffAtomicFormula<>())) {
                                                result = new FalsePropFormula<>();
                                            } else {
                                                result = formula.getUnaryFormula();
                                            }
                                        }
                                    } else {
                                        if (Operations.modelPropositionalFormula(((RegExPropFormula<S>) formula.getExpression()).getFormula(), eval) == false) {
                                            result = new TruePropFormula<>();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}

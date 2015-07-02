/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package symbols;


/**
 * A symbol is an element of the alphabet
 * the automaton is defined over. This interface defines the functionalities each symbol must have.
 * <p>
 * Each class C implementing this interface *must have a constructor taking a String*. This because <@link>LTLfVisitor</@link>
 * and <@link>LDLfVisitor</@link>, when parsing atoms, creates a new object C using a constructor which takes a String
 * as parameter.
 * <p>
 * A symbol is considered a type, hence it must overrides equals and hashcode.
 *
 * @param <T>
 * @author Riccardo De Masellis
 * @version 1.0
 * @since January 8, 2015
 */
public interface Symbol<T> {

    @Override
    boolean equals(Object obj);

    @Override
    int hashCode();


    /**
     * @return The Object (that in each instantiation of this interface will be substituted with a class)
     * that the Symbol contains (or represents).
     */
    T getSymbol();

}

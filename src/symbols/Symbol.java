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
    public boolean equals(Object obj);

    @Override
    public int hashCode();


    /**
     * @return The Object (that in each instantiation of this interface will be substituted with a class)
     * that the Symbol contains (or represents).
     */
    public T getSymbol();

}

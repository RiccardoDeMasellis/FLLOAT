package symbols;


/**
 * This interface defines the functionalities each symbol must have. A symbol is an element of the alphabet
 * the automaton is defined over.
 * <p>
 * A symbol is considered a type, hence it must overrides equals and hashcode.
 * 
 * @author Riccardo De Masellis
 * @version 1.0
 * @since January 8, 2015
 *
 * @param <S>
 */
public interface Symbol<T> {
	
	@Override
	public boolean equals(Object obj);
	
	@Override
	public int hashCode();
	
	/**
	 * @return The Object (that in each instantiation of this interface will be substituted with a class)
	 * that is the Symbol contains.
	 */
	public T getSymbol();
	
	
//	/* Instantiations of Symbol must implement the static method trueSymbol() which returns a
//	 * trueSymbol of that specific class.
//	 */
//	public static <S extends Symbol<?>> S buildTrueSymbol(Class<S> symbolClass) {
//		S result = null;
//		try {
//			return (S) symbolClass.getDeclaredMethod("trueSymbol").invoke(null, null);
//		} catch (IllegalAccessException | IllegalArgumentException
//				| InvocationTargetException | NoSuchMethodException
//				| SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
	

//	/**
//	 * Return the epsilon label.
//	 * @return the epsilon label.
//	 */
//	public static <L extends Label<?>> Label<L> epsilon();
//	
//	/**
//	 * Return the empty label.
//	 * @return the empty label.
//	 */
//	public static <L extends Label<?>> Label<L> emptyLabel();
	
}

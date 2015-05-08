package regularExpression;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;

import symbols.Symbol;

public abstract class RegularExpression<S extends Symbol<?>> implements Serializable,Cloneable{

	static final long serialVersionUID = 500001;
	
	@Override
	public RegularExpression<S> clone(){
		RegularExpression<S> clonedFormula=null;
		try {
			clonedFormula= (RegularExpression<S>) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clonedFormula;
	}
	
//	public abstract String rewriteFromCharToString(HashMap<Character,String>map);
	
	public static <S extends Symbol<?>> RegularExpression<S> load(InputStream stream) throws IOException, OptionalDataException, ClassCastException, ClassNotFoundException, InvalidClassException{
		ObjectInputStream s = new ObjectInputStream(stream);
		return (RegularExpression<S>)s.readObject();
	}
	
	public void store(OutputStream stream) throws IOException{
		ObjectOutputStream s = new ObjectOutputStream(stream);
		s.writeObject(this);
		s.flush();
	}
}

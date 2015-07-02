package useless;

public class StringSymbolTrue extends StringSpecialSymbol {

    public StringSymbolTrue() {
        super("true");
    }

    @Override
    public int hashCode() {
        return "true".hashCode();
    }

    @Override
    public StringSymbolTrue clone() {
        return new StringSymbolTrue();
    }


    @Override
    public String toString() {
        return "true";
    }
}

package useless;

public class StringSymbolFalse extends StringSpecialSymbol {

    public StringSymbolFalse() {
        super("false");
    }

    @Override
    public int hashCode() {
        return "false".hashCode();
    }

    @Override
    public StringSymbolFalse clone() {
        return new StringSymbolFalse();
    }


    @Override
    public String toString() {
        return "false";
    }

}

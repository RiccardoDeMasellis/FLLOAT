package useless;

import symbols.StringSymbol;

public abstract class StringSpecialSymbol extends StringSymbol {

    public StringSpecialSymbol(String symbol) {
        super(symbol);
        // TODO Auto-generated constructor stub
    }


    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }

}

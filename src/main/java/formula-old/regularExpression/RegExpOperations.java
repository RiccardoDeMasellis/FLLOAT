package regularExpression;

import symbols.Symbol;

public class RegExpOperations<S extends Symbol<?>> {

	public static <S extends Symbol<?>> boolean isTestOnly(RegularExpression<S> reg){
		
		if(reg instanceof Star){
			return isTestOnly(((Star<S>) reg).getExpression());
		}
		
		if(reg instanceof Concatenation){
			boolean leftResult= isTestOnly(((Concatenation<S>) reg).getLeftSide());
			if(!leftResult){
				return false;
			}
			else{
				boolean rightResult= isTestOnly(((Concatenation<S>) reg).getRightSide());
				if(!rightResult){
					return false;
				}
				else{
					return true;
				}
			}
		}
		
		if(reg instanceof Or){
			boolean leftResult= isTestOnly(((Or<S>) reg).getLeftSide());
			if(!leftResult){
				return false;
			}
			else{
				boolean rightResult= isTestOnly(((Or<S>) reg).getRightSide());
				if(!rightResult){
					return false;
				}
				else{
					return true;
				}
			}
		}
		
		if(reg instanceof Test){
			return true;
		}
		else{
			return false;
		}
	}
	
}

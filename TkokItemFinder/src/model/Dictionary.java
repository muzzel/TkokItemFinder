package model;

import java.util.HashMap;

public abstract class Dictionary {
	protected HashMap<String, SymbolicFeature> dict;
	
	public Dictionary() {
		this.dict = new HashMap<String, SymbolicFeature>();
	}
	
	/***
	 * Look up a given symbol.
	 * @param symbol specifies the symbol to look up.
	 * @return The according SymbolicFeature if existent, a new one otherwise.
	 */
	public SymbolicFeature lookup(String symbol) {
		SymbolicFeature f = null;
		if (dict.containsKey(symbol)) {
			f = dict.get(symbol);
		} else {
			f = new SymbolicFeature(symbol);
			dict.put(symbol,  f);
		}
		return f;
	}
	
}

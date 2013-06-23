package model;

import itemlist.ItemList;

public class Stat {
	static int count = 0;
	private SymbolicFeature type;
	private NumValue value;
	
	public Stat(ItemList itemListObject, String symType, String value) {
		super();
		count++;
		this.type = itemListObject.getStatTypeDict().lookup(symType);
		this.value = new NumValue(value);
		System.out.println(count + " Found stat: " + symType + ", " + value);
	}
	
}

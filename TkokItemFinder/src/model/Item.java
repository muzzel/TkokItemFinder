package model;

import itemlist.ItemList;

import java.util.ArrayList;

public class Item {

	private String name;
	private String description;
	private SymbolicFeature slot;
	private SymbolicFeature type;
	private NumValue level;
	private SymbolicFeature quality;
	private NumValue cost;
	private ArrayList<Stat> stats;

	public Item(ItemList itemListObject, String name, String description,
			String symSlot, String symType, String symLevel, String symQuality,
			String symCost) {
		super();
		this.stats = new ArrayList<Stat>();
		this.name = name;
		this.description = description;
		this.slot = itemListObject.getItemSlotDict().lookup(symSlot);
		this.type = itemListObject.getItemTypeDict().lookup(symType);
		this.level = new NumValue(symLevel);
		this.quality = itemListObject.getItemQualityDict().lookup(symQuality);
		this.cost = new NumValue(symCost);
		System.out.println("Found item: " + name + ", " + description + ", "
				+ symSlot + ", " + symType + ", " + symLevel + ", "
				+ symQuality + ", " + symCost);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public NumValue getLevel() {
		return level;
	}

	public NumValue getCost() {
		return cost;
	}

	public SymbolicFeature getSlot() {
		return slot;
	}

	public SymbolicFeature getType() {
		return type;
	}

	public SymbolicFeature getQuality() {
		return quality;
	}

	public ArrayList<Stat> getStats() {
		return stats;
	}
}

package itemlist;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.*;
import parser.*;


public class ItemList {
	List<Item> itemList;
	ItemQuality itemQualityDict;
	ItemSlot itemSlotDict;
	ItemType itemTypeDict;
	StatType statTypeDict;
	
	public ItemList() {
		
	}
	
	public void resetDictionaries() {
		itemQualityDict = new ItemQuality();
		itemSlotDict = new ItemSlot();
		itemTypeDict = new ItemType();
		statTypeDict = new StatType();
		
	}
	
	public void scanFile(String file) {
		itemList = null;
		itemList = new ArrayList<Item>();
		FileScanner fs = new FileScanner(file, this);
		try {
			itemList = fs.scanFile();
			
		} catch (IOException e) {
			System.err.println("Could not read file: " + file);
		}
	}
	
	public int getNumberOfItems() {
		return itemList.size();
	}

	public ItemQuality getItemQualityDict() {
		return itemQualityDict;
	}

	public ItemSlot getItemSlotDict() {
		return itemSlotDict;
	}

	public ItemType getItemTypeDict() {
		return itemTypeDict;
	}

	public StatType getStatTypeDict() {
		return statTypeDict;
	}
}

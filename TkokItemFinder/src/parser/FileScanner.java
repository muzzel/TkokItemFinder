package parser;

import model.*;
import itemlist.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileScanner {
	ItemList itemListObject;
	String fileName;

	// Text, names
	final String REGEX_TEXT = "\"([ _'!?,.\\-a-zA-Z0-9]*)\"";
	// Array
	final String REGEX_ARR = "[a-zA-Z0-9\\[\\]_]+";
	// Variable of function
	final String REGEX_VARFUN = "([a-zA-Z0-9_]+)";
	// Symbolic value, might be decimal, hex or a variable
	final String REGEX_SYMVAL = "(\\-?\\$?[.a-zA-Z0-9_]*(?:'.')?)";
	// Raw id
	final String REGEX_RAWID = "'[a-zA-Z0-9]{4}'";

	final String REGEX_ITEMDEFINITION = "set " + REGEX_ARR + "=" + REGEX_VARFUN
			+ "\\(" + REGEX_TEXT + "," + REGEX_TEXT + "," + REGEX_VARFUN + ","
			+ REGEX_VARFUN + "," + REGEX_SYMVAL + "," + REGEX_SYMVAL + ","
			+ REGEX_SYMVAL + "," + REGEX_RAWID + "," + REGEX_RAWID + "\\)";

	final String REGEX_ITEMSTAT = "call " + REGEX_VARFUN + "\\(" + REGEX_ARR
			+ "," + REGEX_SYMVAL + "," + REGEX_SYMVAL + "\\)";

	// Itemdefinition groups: 2 = name, 3 = description, 4 = slot, 5 = type, 6 =
	// level, 7 = quality, 8 = cost
	// Statdefinition groups: 2 = type, 3 = value

	public FileScanner(String fileName, ItemList itemListObject) {
		this.fileName = fileName;
		this.itemListObject = itemListObject;
	}

	public ArrayList<Item> scanFile() throws IOException {
		ArrayList<Item> itemList = new ArrayList<Item>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line;
		Item item = null;
		Pattern itemDefinitionPattern = Pattern.compile(REGEX_ITEMDEFINITION);
		Pattern itemStatPattern = Pattern.compile(REGEX_ITEMSTAT);
		Matcher itemDefinitionMatcher = null;
		Matcher itemStatMatcher = null;
		boolean lookForStats = false;
		while ((line = reader.readLine()) != null) {
			itemDefinitionMatcher = itemDefinitionPattern.matcher(line);
			itemStatMatcher = itemStatPattern.matcher(line);
			if (itemDefinitionMatcher.matches()) {
				item = new Item(itemListObject, itemDefinitionMatcher.group(2),
						itemDefinitionMatcher.group(3),
						itemDefinitionMatcher.group(4),
						itemDefinitionMatcher.group(5),
						itemDefinitionMatcher.group(6),
						itemDefinitionMatcher.group(7),
						itemDefinitionMatcher.group(8));
				itemList.add(item);
				lookForStats = true;
			} else if (itemStatMatcher.matches() && lookForStats) {
				Stat s = new Stat(itemListObject, itemStatMatcher.group(2),
						itemStatMatcher.group(3));
				item.getStats().add(s);
			} else {
				lookForStats = false;
			}
		}
		reader.close();
		return itemList;
	}
}

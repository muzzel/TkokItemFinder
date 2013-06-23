package test;

import model.*;
import itemlist.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parser.*;

public class Test {

	
	
	public static void main(String[] args) {
		ItemList itemListObject = new ItemList();
		itemListObject.resetDictionaries();
		itemListObject.scanFile("tkok330c.j");
		
		 System.out.println("Items in list: " + itemListObject.getNumberOfItems());
		
		// final String REGEX_TEXT = "\"[ _'!?,.\\-a-zA-Z0-9]*\"";
		// System.out.println("\"as,d. ?\"".matches(REGEX_TEXT));
		// Text, names

//		final String REGEX_TEXT = "\"([ _'!?,.\\-a-zA-Z0-9]*)\"";
//		// Array
//		final String REGEX_ARR = "[a-zA-Z0-9\\[\\]_]+";
//		// Variable of function
//		final String REGEX_VARFUN = "([a-zA-Z0-9_]+)";
//		// Symbolic value, might be decimal, hex or a variable
//		final String REGEX_SYMVAL = "(\\$?[.a-zA-Z0-9_]+)";
//		// Raw id
//		final String REGEX_RAWID = "'[a-zA-Z0-9]{4}'";
//		final String REGEX_ITEMDEFINITION = "set " + REGEX_ARR + "="
//				+ REGEX_VARFUN + "\\(" + REGEX_TEXT + "," + REGEX_TEXT + ","
//				+ REGEX_VARFUN + "," + REGEX_VARFUN + "," + REGEX_SYMVAL + ","
//				+ REGEX_SYMVAL + "," + REGEX_SYMVAL + "," + REGEX_RAWID + ","
//				+ REGEX_RAWID + "\\)";
//
//		final String REGEX_ITEMSTAT = "call " + REGEX_VARFUN + "\\("
//				+ REGEX_ARR + "," + REGEX_SYMVAL + "," + REGEX_SYMVAL + "\\)";
//		// Itemdefinition groups: 2 = name, 3 = description, 4 = slot, 5 = type,
//		// 6 = level, 7 = quality, 8 = value
//		// Statdefinition groups: 2 = type, 3 = value
//
//		// Matcher a =
//		// Pattern.compile("a*([0-9]*)b*([0-9]*)c*").matcher("aaa234bbb456456cc");
//		String testItem = "set SK[QK]=W9I(\"Vormur Battle Shield\",\"Fierce looking, sturdy, large, easy to use... and oh so heavy!\",YF,EG,8,3,$88,'B06L','I04I')";
//		String testStat = "call YCI(SK[QK],SF,.13)";
//		Matcher a = Pattern.compile(REGEX_ITEMSTAT).matcher(testStat);
//
//		a.matches();
//		for (int i = 1; i <= a.groupCount(); i++) {
//			System.out.println(i + ": " + a.group(i));
//		}
	}
}

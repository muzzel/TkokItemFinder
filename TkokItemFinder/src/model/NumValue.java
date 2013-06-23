package model;

public class NumValue {

	double value;
	String symValue;

	public NumValue(String symValue) {
		this.symValue = symValue;
		parse();
	}

	private boolean parse() {
		if (symValue.matches("\\-?[0-9]*")) {
			// Is integer
			value = (double) Integer.parseInt(symValue);
			return true;
		} else if (symValue.matches("\\-?[0-9]*\\.[0-9]*")) {
			// Is double
			value = Double.parseDouble(symValue);
			return true;
		} else if (symValue.matches("\\-?\\$[0-9a-zA-Z]*")) {
			// Is hex integer
			value = (double) Integer.parseInt(symValue.replace("$",  ""), 16);
			return true;
		} else {
			// Is symbol
			System.err.println("Couldnt parse NumValue: " + symValue);
			return false;
		}
	}

}

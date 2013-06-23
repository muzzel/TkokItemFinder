package model;

public class SymbolicFeature {


	/***
	 * True if the symbol is resolved. False if the value is pure symbolic.
	 */
	private boolean isResolved;
	public String symbol;
	public String name;
	
	/***
	 * Do not instantiate this class directly, always use a Dictionary-generator to create instances.
	 * @param symbol
	 */
	public SymbolicFeature(String symbol) {
		this.symbol = symbol;
		this.isResolved = false;
	}
//
//	public boolean isResolved() {
//		return this.isResolved;
//	}
//	
//	/***
//	 * Try to resolve the symbolic value.
//	 */
//	public void tryResolve() {
//		if (!isResolved()) {
//			this.isResolved = resolve();
//		}
//	}
	
	/***
	 * Implements the resolving procedure.
	 * @return true if successful.
	 */
//	protected abstract boolean resolve();
}

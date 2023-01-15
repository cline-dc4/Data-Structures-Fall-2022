
public interface Taxable {
	
	/** This function calculates the tax bracket of an individual as
	 * a number between 0 and 100
	 * @param a This is the status of the individual. s = Single, h = Head of household, m = Married/Joint filing
	 * @param b This is the annual income
	 * @return A number between 0 and 100 corresponding to the tax bracket percentage of the individual
	 */
	public double getRate(char a, int b);
}

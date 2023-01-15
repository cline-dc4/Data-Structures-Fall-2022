
public class Symbol 
{
	/** the variable that stores what symbol is in the object */
	private char symbol;
	/** holds the line number that the symbol is in */
	private int lineNum;
	
	public Symbol(char symbol, int lineNumber) 
	{
		setSymbol(symbol);
		setLineNum(lineNumber);
	}

	/**
	 *  the setter for lineNum 
	 * @param lineNum the line number the object should have
	 */
	public void setLineNum(int lineNum)
	{
		this.lineNum = lineNum;
	}
	
	/**
	 * the getter for lineNum
	 * @return the line number of the object
	 */
	public int getLineNum()
	{
		return lineNum;
	}

	/**
	 * the setter for symbol
	 * @param symbol the symbol in the object.
	 */
	public void setSymbol(char symbol) 
	{
		this.symbol = symbol;
	}
	
	/**
	 * the getter for symbol
	 * @return the symbol of the object.
	 */
	public char getSymbol() 
	{
		return symbol;
	}
	
	/**
	 * allows the Symbol objects to be printed.
	 */
	public String toString()
	{
		String s = "";
		s += "Symbol: " + symbol + ", ";
		s += "Line number: " + lineNum;
		return s;
	}
}

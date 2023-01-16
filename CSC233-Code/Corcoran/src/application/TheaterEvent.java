package application;
/**
 * Homework Assignment 5
 * @author Savannah
 * Due Date: 09/21/22
 */
public class TheaterEvent extends Event {

	/**
	 * This is true if its a musical and false if its not
	 */
	private boolean musical;

	/**
	 * The length of the musical/not musical
	 */
	private int length;

	/**
	 * The getter for whether it's a musical or not
	 * @return True or false based on if its a musical
	 */
	public boolean getMusical() 
	{
		return musical;
	}

	/**
	 * The setter for whether it's a musical or not
	 * @param newMusical The new value of true or false 
	 */
	public void setMusical(boolean newMusical) 
	{
		musical = newMusical;
	}

	/**
	 * The getter for the length of the theater event
	 * @return The length of the theater event
	 */
	public int getLength() 
	{
		return length;
	}

	
	/**
	 * The setter for the length of the Theater event
	 * @param newLength The new length of the Theater event
	 * @throws Exception If length is less than 1, name is an empty string, cost is less than 1 and location isn't 'i' or 'o'
	 */
	public void setLength(int newLength) throws Exception 
	{
		if (newLength < 1)
			throw new Exception("Length must be at least 1");
		length = newLength;
	}
	
	/**
	 * This is the default constructor
	 * @throws Exception If length is less than 1
	 */
	public TheaterEvent() throws Exception
	{
		super();
		setMusical(true);
		setLength(1);
	}
	
	/**
	 * This is the constructor the user can modify
	 * @param newName The new name of the event
	 * @param newCost The new cost of the event
	 * @param newLocation The new location of the event
	 * @param newMusical The new value of true or false determining if its a musical
	 * @param newLength The new length of the theater event
	 * @throws Exception If length is less than one, name is an empty string, cost is less than 1 and location isn't 'i' or 'o'
	 */
	public TheaterEvent(String newName, double newCost, char newLocation, boolean newMusical, int newLength) throws Exception
	{
		super(newName, newCost, newLocation);
		setMusical(newMusical);
		setLength(newLength);
	}

	/**
	 * This toString prints out the given information
	 */
	public String toString()
	{
		String needNewNameForStringToReturn = "Theater Event ";
		needNewNameForStringToReturn += super.toString();
		if (musical)
			needNewNameForStringToReturn += " This is a musical";
		else
			needNewNameForStringToReturn += " This is not a musical";
		needNewNameForStringToReturn += " Length: " + length;
		return needNewNameForStringToReturn;
	}


}

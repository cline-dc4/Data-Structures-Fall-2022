package application;

public class TheaterEvent extends Event
{
	/**
	 * default constructor for TheaterEvent
	 * sets name to an empty string,
	 * sets cost to 0, sets the location to i,
	 * sets musical to true, and sets length to 1.
	 * @throws Exception based off multiple setters.
	 */
	public TheaterEvent() throws Exception
	{
		super();
		setMusical(true);
		setLength(1);
	}
	
	/**
	 * constructor for TheaterEvent
	 * @param newNameString that is the name of the event.
	 * @param newCost double that is the cost of the event.
	 * @param newLocation char that is either i or o, i for
	 * indoors and o for outdoors.
	 * @param newMusical boolean that is true if musical, else false.
	 * @param newLength int that describes how long the event will last.
	 * @throws Exception based off multiple setters.
	 */
	public TheaterEvent(String newName, double newCost, char newLocation,
			boolean newMusical, int newLength) throws Exception
	{
		super(newName, newCost, newLocation);
		setMusical(newMusical);
		setLength(newLength);
	}
	
	/**true if the event is a musical, else false.*/
	private boolean musical;
	
	/**describes how long the event lasts.*/
	private int length;

	/**
	 * the getter for the boolean musical.
	 * @return true if musical, false if something else.
	 */
	public boolean getMusical() 
	{
		return musical;
	}

	/**
	 * the setter for the boolean musical.
	 * @param musical True if the event is a musical,
	 * false if anything else.
	 */
	public void setMusical(boolean musical) 
	{
		this.musical = musical;
	}

	/**
	 * the getter for the int length.
	 * @return an int that describes the length of the event.
	 */
	public int getLength() 
	{
		return length;
	}

	/**
	 * the setter for the int length.
	 * @param length integer that tells how long the event lasts.
	 * @throws Exception 
	 */
	public void setLength(int length) throws Exception 
	{
		if (length < 1)
			throw new Exception("Length must be at least one.");
		this.length = length;
	}
	
	/*8
	 * converts a TheaterEvent object to a string.
	 * builds off of the toString method in Event.
	 */
	public String toString()
	{
		String s = "";
		s += " Theater Event";
		s += super.toString();
		if(musical)
			s += " This is a musical";
		else if(!musical)
			s += " This is not a musical";
			
		s += " Length: " + length;
		return s;
	}
	
	
}

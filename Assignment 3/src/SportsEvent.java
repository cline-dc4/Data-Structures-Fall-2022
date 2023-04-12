
public class SportsEvent extends Event
{
	/**
	 * default constructor for SportsEvent.
	 * sets name to an empty string,
	 * sets cost to 0, sets the location to i,
	 * sets spectators to 1, and sets sport to Baseball.
	 * @throws Exception comes from multiple setters.
	 */
	public SportsEvent() throws Exception 
	{
		super();
		setSpectators(1);
		setSport("Baseball");
	}
	
	/**
	 * Constructor for a SportsEvent object.
	 * @param newName a String that is the name of the event
	 * @param newCost a double that is the cost for the event.
	 * @param newLocation a char that is either 'i' or 'o', for 
	 * indoors and outdoor respectively.
	 * @param newSpectators a int for the number of spectators.
	 * @param newSport a String for the name of the sport played.
	 * @throws Exception comes from multiple setters.
	 */
	public SportsEvent(String newName, double newCost, char newLocation,
			int newSpectators, String newSport) throws Exception
	{
		super(newName,newCost,newLocation);
		setSpectators(newSpectators);
		setSport(newSport);
	}
	
	/**the sport played at the event*/
	private String sport;
	
	/**number of spectators at the event*/
	private int spectators;

	/**
	 * the getter for the String sport
	 * @return the sport of the event
	 */
	public String getSport() 
	{
		return sport;
	}

	/**
	 * the setter for the String sport.
	 * @param sport the String says which sport is being played
	 * @throws Exception if sport is an empty String.
	 */
	public void setSport(String sport) throws Exception
	{
		if(sport == "")
			throw new Exception("Sport must not be an empty string.");
		this.sport = sport;
	}

	/**
	 * the getter for the int spectators
	 * @return an int for the number of spectators
	 */
	public int getSpectators() 
	{
		return spectators;
	}

	/**
	 * the setter for the int spectators.
	 * @param spectators int that give number of spectators
	 * @throws Exception 
	 */
	public void setSpectators(int spectators) throws Exception 
	{
		if (spectators < 10)
			throw new Exception("Spectators must be greater than 1");
		this.spectators = spectators;
	}
	
	/**
	 * converts a SportEvent object to a string
	 * builds off of the toString in Event.
	 */
	public String toString()
	{
		String s ="";
		s += " Sports event";
		//calling toString from Event
		s += super.toString();
		s += " Sport: " + sport;
		s += " Spectators: " + spectators;
		
		return s;
	}
	
}

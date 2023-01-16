package application;
/**
 * Homework Assignment 5
 * @author Savannah
 * Due Date: 09/21/22
 */
public class SportsEvent extends Event {

	/**
	 * The type of sport
	 */
	private String sport;

	/**
	 * The number of spectators
	 */
	private int spectators;

	/**
	 * The getter for the name of the sport
	 * @return The name of the sport
	 */
	public String getSport() 
	{
		return sport;
	}
	
	/**
	 * The setter for the name of the sport
	 * @param newSport The new name of the sport
	 * @throws Exception If sport is an empty String
	 */
	public void setSport(String newSport) throws Exception 
	{
		if (newSport == "")
			throw new Exception("Sport cannot be an empty String");
		sport = newSport;
	}

	/**
	 * The getter for the number of spectators
	 * @return The number of spectators
	 */
	public int getSpectators() 
	{
		return spectators;
	}
	
	/**
	 * The setter for the new number of spectators
	 * @param newSpectators The new number of spectators 
	 * @throws Exception If spectators is less than one
	 */
	public void setSpectators(int newSpectators) throws Exception 
	{
		if (newSpectators < 1)
			throw new Exception("Spectators must be at least 1");
		spectators = newSpectators;
	}
	
	/**
	 * This is the default constructor 
	 * @throws Exception If sport is an empty String, spectators is less than one, name is an empty string, cost is less than 1 and location isn't 'i' or 'o'
	 */
	public SportsEvent() throws Exception
	{
		super();
		setSport("Sport");
		setSpectators(1);
	}
	
	/**
	 * This is the constructor the user can modify
	 * @param newName The new name of the event
	 * @param newCost The new cost of the event
	 * @param newLocation The new location of the event
	 * @param newSport The new sport at the event
	 * @param newSpectators The new number of spectators at the event
	 * @throws Exception If sport is an empty String, spectators is less than one, name is an empty string, cost is less than 1 and location isn't 'i' or 'o'
	 */
	public SportsEvent(String newName, double newCost, char newLocation, String newSport, int newSpectators) throws Exception
	{
		super(newName, newCost, newLocation);
		setSport(newSport);
		setSpectators(newSpectators);
	}

	/**
	 * This toString prints out the given information
	 */
	public String toString()
	{
		String stringToReturn = "Sports Event ";
		stringToReturn += super.toString();
		stringToReturn += " Sport: " + sport;
		stringToReturn += " Number of spectators: " + spectators;
		return stringToReturn;
				
	}



}

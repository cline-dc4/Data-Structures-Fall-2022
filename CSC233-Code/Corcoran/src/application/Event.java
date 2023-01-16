package application;
/**
 * Homework Assignment 5
 * @author Savannah
 * Due Date: 09/21/22
 */
public abstract class Event implements Comparable<Event>{

	/**
	 * The name of the event
	 */
	private String name;

	/**
	 * The price of the event
	 */
	private double cost;

	/**
	 * Set to 'i' if indoors, 'o' if outdoors
	 */
	private char location;

	/**
	 * The value of location when it's 'i'
	 */
	public static final char INDOORS = 'i';

	/**
	 * The value of location when it's 'o'
	 */
	public static final char OUTDOORS = 'o';

	/**
	 * The getter for the name of the event
	 * @return The name of the event
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * The setter for the event name
	 * @param newName The new event name
	 * @throws Exception If name is an empty string
	 */
	public void setName(String newName) throws Exception 
	{
		if (newName == "")
			throw new Exception("Name string cannot be empty");
		name = newName;
	}

	/**
	 * The getter for the cost of the event
	 * @return The cost of the event
	 */
	public double getCost() 
	{
		return cost;
	}

	/**
	 * The setter for the cost of the event
	 * @param newCost The new cost of the event
	 * @throws Exception If the cost is less than 1
	 *
	 */
	public void setCost(double newCost) throws Exception 
	{
		if (newCost < 1)
			throw new Exception("Cost must be at least 1");
		cost = newCost;
	}

	/**
	 * The getter for the location of the event
	 * @return The location of the event
	 */
	public char getLocation() 
	{
		return location;
	}

	/**
	 * The setter for the location of the event
	 * @param newLocation The new location of the event
	 * @throws Exception If location isn't 'i' or 'o'
	 */
	public void setLocation(char newLocation) throws Exception 
	{
		if (newLocation != INDOORS && newLocation != OUTDOORS)
			throw new Exception("Location must be 'i' or 'o'");
		location = newLocation;
	}

	/**
	 * This is the default constructor
	 * @throws Exception The name cannot be an empty string, cost has to be at least 1, and location has to be 'i' or 'o'
	 */
	public Event() throws Exception
	{
		setName("Name");
		setCost(1);
		setLocation('i');
	}

	/**
	 * This constructor the user can modify
	 * @param newName The new name of the event
	 * @param newCost The new cost of the event
	 * @param newLocation The new location of the event
	 * @throws Exception The name cannot be an empty string, cost has to be at least 1 and location has to be 'i' or 'o'
	 */
	public Event(String newName, double newCost, char newLocation) throws Exception
	{
		setName(newName);
		setCost(newCost);
		setLocation(newLocation);
	}

	/**
	 * This toString prints out the given information
	 */
	public String toString()
	{
		String stringToReturn = "";
		stringToReturn += "Name: " + name;
		stringToReturn += " Cost: " + cost;
		if (location == INDOORS)
			stringToReturn += " Hosted indoors";
		else if (location == OUTDOORS)
			stringToReturn += " Hosted outdoors";
		return stringToReturn;
	}

/**
 * This method compares objects based on name then cost
 */
	public int compareTo(Event other)
	{
		if (this.getName().compareTo(other.getName()) < 0)
			return -1;
		else if (this.getName().compareTo(other.getName()) > 0)
			return 1;
		if (this.getCost() < other.getCost())
			return -1;
		if (this.getCost() > other.getCost())
			return 1;
		else
			return 0;
	}

}

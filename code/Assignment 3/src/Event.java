/**
 * This class creates an Event object.
 * Homework #3
 * Due 9/12/22
 * @author DC
 * @version 9/11/22
 */
public abstract class Event implements Comparable<Event>
{
	
	public static final char INDOORS = 'i';
	public static final char OUTDOORS = 'o';

	/**
	 * Default constructor, sets name to an empty string,
	 * sets cost to 0, and sets the location to i.
	 * @throws Exception 
	 */
	public Event() throws Exception
	{
		setName("");
		setCost(1);
		setLocation('i');
	}
	/**
	 * Constructor for event objects.
	 * @param newName a String that is the name of the event.
	 * @param newCost a double that is the cost of the event.
	 * @param newLocation a char, either 'i' or 'o' for indoors/outdoors.
	 * @throws Exception 
	 */
	public Event(String newName, double newCost, char newLocation) throws Exception
	{
		setName(newName);
		setCost(newCost);
		setLocation(newLocation);
	}
	
	/**the name of the event*/
	private String name;
	
	/**the cost of the event*/
	private double cost;
	
	/**should be 'i' or 'o', describes whether
	 * event is inside or outside. */
	private char location;
	
	/**
	 * the getter for name.
	 * @return the name of this event.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * the setter for the name.
	 * @param name the new name for the event.
	 * @throws Exception 
	 */
	public void setName(String name) throws Exception
	{
		if (name == "")
			throw new Exception("Name must not be an empty string.");
		this.name = name;
	}

	/**
	 * the getter for cost.
	 * @return the cost of this event.
	 */
	public double getCost() 
	{
		return cost;
	}

	/**
	 * the setter for the cost.
	 * @param cost the new cost of the event.
	 * @throws Exception cost must be at least 1.
	 */
	public void setCost(double cost) throws Exception 
	{
		if (cost < 1)
			throw new Exception("The cost must be at least 1.");
		this.cost = cost;
	}

	/**
	 * the getter for location
	 * @return a char 'i' or 'o', i for indoors and o for outdoors.
	 */
	public char getLocation() 
	{
		return location;
	}

	/**
	 * the setter for location.
	 * @param location Should send either 'i' or 'o',
	 * i for indoors and o for outdoors.
	 * @throws Exception 
	 */
	public void setLocation(char location) throws Exception
	{
		if(location != 'i' && location != 'o')
			throw new Exception("Location must be either 'i' or 'o'.");
		this.location = location;
	}
	
	/**
	 * Converts the objects information to a string.
	 * if adding to this in child class, put space before each addition.
	 */
	public String toString()
	{
		String s = "";
		s += " Name: " + name;
		s += " Cost: " + cost;
		if(location == INDOORS)
			s += " Hosted indoors";
		else if(location == OUTDOORS)
			s += " Hosted outdoors";
		return s;
	}
	
	/**
	 * compares one Event object to another.
	 * @param other an Event object that is being compared.
	 * @return -1 if this object is smaller than the other,
	 * 1 if this object is bigger  than the other,
	 * 0 if equal.
	 */
	public int compareTo(Event other)
	{
		if (this.getName().compareTo(other.getName()) < 0)
			return -1;
		if (this.getName().compareTo(other.getName()) > 0)
			return 1;
		
		if (this.getCost() < other.getCost())
			return -1;
		if (this.getCost() > other.getCost())
			return 1;
		return 0;
			
	}

}

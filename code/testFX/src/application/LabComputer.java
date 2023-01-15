package application;

public class LabComputer extends Computer implements Comparable<LabComputer>
{
	
	private String location;

	public LabComputer() throws Exception
	{
		super();
		setLocation("VC 207");
	}
	
	public LabComputer(String newId,boolean newIsLaptop,
			int newUpdateYear, String newLocation) throws Exception
	{
		super(newId, newIsLaptop, newUpdateYear);
		setLocation(newLocation);
	}
	/**
	 * Getter for location
	 * @return the string Location.
	 */
	public String getLocation() 
	{
		return location;
	}

	/**
	 * Setter for location
	 * @param location The new location for the object.
	 */
	public void setLocation(String location) 
	{
		this.location = location;
	}
	
	@Override
	public String toString()
	{
		String s = super.toString();
		s += " Location: " + location;
		s += " Update year: " + updateYear;
		return s;
	}

	@Override
	public int compareTo(LabComputer other)
	{
		if (this.getUpdateYear() < other.getUpdateYear())
			return -1;
		else if (this.getUpdateYear() > other.getUpdateYear())
			return 1;
		//if they are equal, compare based on String location
		
		if(this.getLocation().compareTo(other.getLocation()) < 0)
			return -1;
		else if(this.getLocation().compareTo(other.getLocation()) > 0)
			return 1;
		
		return 0;
		//alternative for comparing strings as last step:
		//return (this.getLocation().compareTo(other.getLocation()));
	}
	
	
}


/**
 * This is the class to create computer objects
 * @author DC
 * @version 09/07/22
 */
public abstract class Computer 
{
	public final static int CURRENT_YEAR = 2022;
	
	//needs key word abstract to work outside of interface.
	//public void setValue(int x);
	
	public Computer() throws Exception
	{
		setId("00000");
		setIsLaptop(true);
		setUpdateYear(2022);
	}
	
	public Computer(String newId,boolean newIsLaptop, int newUpdateYear) throws Exception 
	{
		setId(newId);
		setIsLaptop(newIsLaptop);
		setUpdateYear(newUpdateYear);
	}
	/** The unique identifier of the computer */
	private String id;
	
	/** True if laptop, false is desktop */
	private boolean isLaptop;
	
	/** The last time this computer was updated*/
	protected int updateYear;
	
	/**
	 * The setter for ID.
	 * @param newId The new ID of the computer.
	 * @throws Exception length of string must be 5.
	 */
	public void setId(String newId) throws Exception
	{
		if (newId.length() != 5)
			throw new Exception("The length must be exactly five digits");
		
		if(newId.charAt(0) < '1' || newId.charAt(0) > '9')
			throw new Exception("The first digit must be between 1 and 9");
		
		for (int i = 1; i < newId.length(); i++)
		{
			if (newId.charAt(i) < '0' || newId.charAt(i) > '9')
				throw new Exception("The ID must only contin digits");
		}
		
		id = newId;
	}
	
	/**
	 * The getter for ID
	 * @return the ID of this computer
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * The getter for isLaptop.
	 * @return true or false.
	 */
	public boolean isLaptop() 
	{
		return isLaptop;
	}

	public void setIsLaptop(boolean isLaptop) 
	{
		this.isLaptop = isLaptop;
	}

	public int getUpdateYear() {
		return updateYear;
	}
	/**
	 * the setter for updateYear.
	 * @param updateYearthe year this computer was updated.
	 * @throws Exception when updateYear is < 2000 or > CURRENT_YEAR.
	 */
	public void setUpdateYear(int updateYear) throws Exception
	{
		if (updateYear < 2000)
			throw new Exception("The update year must be at least 2000.");
		if (updateYear > CURRENT_YEAR)
			throw new Exception("The update year can't be greater than " + CURRENT_YEAR);
		this.updateYear = updateYear;
	}
	
	public String toString()
	{
		String s = "";
		s += "ID : "+ id;
		s = s + " Update year: " + updateYear + "\n";
		if(isLaptop)
			s+= "This is a laptop";
		else
			s+= "This is a desktop";
		return s;
	}
}

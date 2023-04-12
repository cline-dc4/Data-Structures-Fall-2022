package application;

public class Model implements ModelInterface{
	
	private int independent;
	
	private String dependent;
	
	public void setIndependent(int newIndependent)
	{
		independent = newIndependent;
		if (newIndependent < 31)
			{
			dependent = "Freshman";
			}
		else if (newIndependent < 61)
		{
			dependent = "Sophomore";
		}
		else if (newIndependent < 91)
		{
			dependent = "Junior";
		}
		else
			dependent = "Senior";
	}
	
	public int getIndependent()
	{
		return independent;
	}
	
	public String getDependent()
	{
		return dependent;
	}
	
	
}

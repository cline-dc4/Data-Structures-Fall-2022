
public class Address<T extends Comparable<T>, U>
{
	private String city;
	
	private T zipcode;
	
	private U houseNumber;

	public Address()
	{
		city = "Salem";
		setZipcode(null);
		setHouseNumber(null);
	}
	
	public Address(String city, T zipcode, U houseNumber)
	{
		setCity(city);
		setZipcode(zipcode);
		setHouseNumber(houseNumber);
	}
	
	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}
	
	public T getZipcode()
	{
		return zipcode;
	}
	
	public void setZipcode(T zipcode)
	{
		this.zipcode = zipcode;
	}
	
	public U getHouseNumber()
	{
		return houseNumber;
	}
	
	public void setHouseNumber(U houseNumber)
	{
		this.houseNumber = houseNumber;
	}
		
	public String toString()
	{
		String s = "Address: " + city + " " + houseNumber.toString() + " " + zipcode.toString();
		
		return s;
	}
	
}

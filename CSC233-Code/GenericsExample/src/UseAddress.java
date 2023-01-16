import java.util.Scanner;

public class UseAddress {

	public static void main(String[] args) 
	{
//		Address<String, String> a1 = new Address<String, String>();
//		a1.setZipcode("97317");
//		//a1.setZipcode(55112); once a1 is type String can't use Integer.
//		System.out.println(a1);
//		
		Address<Integer, String>a2 = new Address<Integer, String>("Pasco", 99301, "3720");
		System.out.println(a2);
		
		Computer c;
		try 
		{
			c = new LabComputer("10000", true, 2020, "AC3301"); 

		Address<Integer, Computer> a4 = new Address<Integer, Computer>("Salem", 97317, c);
		System.out.println(a4);
		}
		catch (Exception e) 
		{
			System.out.println("Error: " + e.getMessage());
		}
		
		try
		{
			Scanner input = new Scanner(System.in);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		Address<Scanner, Computer> a5 = new Address<Scanner, Computer>("Pasco", input, c);
		//W/O using wildcards, line 40 is invalid b/c a6 is not LabComputer/Scanner combo.
		//Address<LabComputer, Scanner> a6 = new Address<LabComputer, Scanner>();
		//a6 = new Address<String, Integer>();
		
		Address<? extends Comparable<?>, Scanner> a7 = new Address<LabComputer, Scanner>();
		a7 = new Address <Integer, Scanner>();
		a7 = new Address<Integer, String>();
	}

}

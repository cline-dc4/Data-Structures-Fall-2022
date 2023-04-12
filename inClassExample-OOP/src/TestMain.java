import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		/*
//	    Computer c1 = new Computer();
//		System.out.println("Computer ID: " + c1.getId());
//		
//		Computer c2 = new Computer("123456", false, 2020);
//		System.out.println("Year: " +c2.getUpdateYear());
//
//		//Printing out the current year
//		int year = Computer.CURRENT_YEAR;
//		System.out.println("Current year: " + year);
//		System.out.println(c1);
//		System.out.println(c2);
//		
//		Computer c3 = c2;
//		c3.setUpdateYear(1995);
//		System.out.println(c2);
//		System.out.println();
//		
//		Computer c4 = new Computer("123456", false, 1995);
//		System.out.print("c1: ");
//		System.out.println(c1);
//		System.out.print("c2: ");
//		System.out.println(c2);
//		System.out.print("c3: ");
//		System.out.println(c3);
//		System.out.print("c4: ");
//		System.out.println(c4);
//		
//		System.out.println("c1 == c2: " + (c1 == c2));
//		System.out.println("c2 == c3: " + (c2 == c3));
//		System.out.println("c3 == c4: " + (c3 == c4));

		LabComputer lc1 = new LabComputer();
		LabComputer lc2 = new LabComputer("555555", true, 2010, "PV 105");
		System.out.println(lc1);
		System.out.println(lc2);

		//polymorphism
		Computer c1 = new LabComputer();
		BudgetItem  b1 = new LabComputer();
		 */
//		Scanner input = new Scanner(System.in);
//		System.out.print("Enter in the ID: ");
//		try 
//		{
//			String newId = input.next();
//			System.out.print("Enter the update year: ");
//			int updateYear = input.nextInt();
//		}
//		catch(InputMismatchException e)
//		{
//			System.out.println("Year must be a number");
//		}
		
		try {
			Computer c = new LabComputer();
			c = new LabComputer("111111", true, 2010, "PV 105");
			System.out.println(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
		
		try {
			Computer c1 = new LabComputer();
			
			//preventing nullPointerException
			if (c1 != null && c1.getId().compareTo("99999") > 0)
				System.out.println("c1 is greater than 99999");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}

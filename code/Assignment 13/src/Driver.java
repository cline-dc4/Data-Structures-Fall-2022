import java.util.Scanner;
/**
 * The class that has the main for the program.
 * @author DC
 */
public class Driver 
{

	public static void main(String[] args) 
	{
		//Testing:
		
		//		SortedLinkedList ll = new SortedLinkedList();
		//		
		//		try
		//		{
		//		ll.addItem("University");
		//		ll.addItem("Corban");
		//		ll.addItem("Hello");
		//		ll.addItem("Data");
		//		//throws the exception:
		//		ll.addItem("University");
		//		}
		//		catch(Exception e)
		//		{
		//			System.out.println(e);
		//		}
		//		System.out.println(ll);
		//		
		//		try
		//		{
		//			ll.deleteItem("Hello");
		//			//throws the exception:
		//			ll.deleteItem("asdf");
		//			//made sure deleteItem worked for the last element:
		//			//ll.deleteItem("University");
		//		}
		//		catch(Exception e)
		//		{
		//			System.out.println(e);
		//		}
		//		System.out.println(ll);

		/**the linked list used throughout the Driver.*/
		SortedLinkedList stringList = new SortedLinkedList();
		/**a flag used to quit the loop when the user wants to*/
		boolean exitFlag = false;
		/**a flag used to loop through error handling if needed.*/
		boolean errorFlag = false;
		/**the user input value for choosing cases in the switch statement.*/
		String choice = "0"; 
		/**Scanner object for user input.*/
		Scanner keyboard = new Scanner(System.in);

		//
		while(!exitFlag)
		{
			//I know you said I don't *have* to account for InputMismatchException...
			//The following do/while loop checks for various errors that could
			//come up with user input for the choice variable.
			do
			{
				try
				{
					System.out.print("1: Add 2: Delete 3: Quit  ");
					choice = keyboard.nextLine();
					
					//logic behind this: if Integer.parseInt(choice) fails,
					//will print out InputMismatchException and run loop again.
					//if the if statement throws an exception, gives user
					//reason why their input didn't work and runs loop again.

					if(Integer.parseInt(choice) < 1 || Integer.parseInt(choice) > 3)
						throw new Exception("Input must be 1, 2, or 3.");

					errorFlag = false;
				}
				catch (Exception e)
				{
					errorFlag = true;
					System.out.println(e);
				}
			}
			while(errorFlag);

			switch (Integer.parseInt(choice)) {

			//case 1: add a string to the list.
			case(1):
			{
				System.out.print("Enter a string to add:");
				try 
				{
					stringList.addItem(keyboard.nextLine());
					System.out.println(stringList);

				}
				catch (Exception e) 
				{
					System.out.println(e);
				}
				break;
			}
			
			//case 2: delete a string from the list.
			case(2):
			{
				System.out.println("Enter a string to delete:");
				try 
				{
					stringList.deleteItem(keyboard.nextLine());
					System.out.println(stringList);

				}
				catch (Exception e)
				{
					System.out.println(e);
				}
				break;
			}
			
			//case 3: break the loop/end the program.
			case(3):
			{
				exitFlag = true; //stops while loop from running again
				keyboard.close();
				break;
			}
			}
		}
	}


}

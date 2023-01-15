import java.util.Scanner;

/** 0 1 1 2 3 5 8 
 * Output: The fibonacci number is: 3
The fibonacci number is: 1
The fibonacci number is: 5
The fibonacci number is: 8
The fibonacci number is: 1
Input: mom
Letter: a at: -1
Letter: b at: -1
Letter: c at: -1
Letter: d at: -1
Letter: e at: -1
Letter: f at: -1
Letter: g at: -1
Letter: h at: -1
Letter: i at: -1
mom is a palindrome
Input: its computer science
Letter: a at: -1
Letter: b at: -1
Letter: c at: 4
Letter: d at: -1
Letter: e at: 10
Letter: f at: -1
Letter: g at: -1
Letter: h at: -1
Letter: i at: 0
its computer science is not a palindrome
Input: asdfghgfdsa
Letter: a at: 0
Letter: b at: -1
Letter: c at: -1
Letter: d at: 2
Letter: e at: -1
Letter: f at: 3
Letter: g at: 4
Letter: h at: 5
Letter: i at: -1
asdfghgfdsa is a palindrome
64 in base 10 is 1000000 in base 2
15 in base 10 is 1111 in base 2
111 in base 10 is 1101111 in base 2
922 in base 10 is 1110011010 in base 2
535 in base 10 is 1000010111 in base 2
64 in base 10 is	2101 In base 3
64 in base 10 is	1000 In base 4
64 in base 10 is	224 In base 5
15 in base 10 is	120 In base 3
15 in base 10 is	33 In base 4
15 in base 10 is	30 In base 5
111 in base 10 is	11010 In base 3
111 in base 10 is	1233 In base 4
111 in base 10 is	421 In base 5
922 in base 10 is	1021011 In base 3
922 in base 10 is	32122 In base 4
922 in base 10 is	12142 In base 5
535 in base 10 is	201211 In base 3
535 in base 10 is	20113 In base 4
535 in base 10 is	4120 In base 5

 * @author DThomas
 *
 */

public class CSC233_HW06 {
	public static void main(String [] args)
	{
		int [] numbers = {4, 2, 5, 6, 1};
		for (int i = 0; i < numbers.length; i++)
			System.out.println("The fibonacci number is: " + fibonacci(numbers[i]));
		String [] strings = {"mom", "its computer science", "asdfghgfdsa"};
		char [] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};

		for (int j = 0; j < strings.length; j++)
		{
			String inputString = strings[j];
			System.out.println("Input: " + inputString);
			for (int i = 0; i < letters.length; i++)
			{
				System.out.println("Letter: " + letters[i] + " at: " + searchFirstOccurrence(inputString, 0, letters[i]));
			}
			if (isPalindrome(inputString))
				System.out.println(inputString + " is a palindrome");
			else
				System.out.println(inputString + " is not a palindrome");
		}
		int [] array = {64, 15, 111, 922, 535};
		for (int i = 0; i < 5; i++)
			System.out.println(array[i] + " in base 10 is " + printBinary(array[i]) + " in base 2");

		int [] radixArray = {3, 4, 5};
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 3; j++)
				System.out.println(array[i] + " in base 10 is\t" + printRadix(array[i], radixArray[j]) + " In base " + radixArray[j]);
		}

	}

	/**
	 * Example: Recursive method to find binary number
	 * @param number The base 10 number
	 * @return The string version of the binary number
	 */
	public static String printBinary(int number)
	{
		//base case
		if(number == 1)
			return "1";
		//recursive step
		else
			return(printBinary(number / 2) + number % 2);
	}

	/**
	 * HW problem: Recursive method to find binary number
	 * @param number The base 10 number
	 * @return The string version of the new radix number
	 */
	public static String printRadix(int number, int radix)
	{

		//base case
		if(number < radix)
			return String.valueOf(number);
		//recursive step
		else
			return(printRadix(number / radix, radix) + number % radix);
	}

	/** 
	 * HW problem: This method returns the fibonacci number, where fib(0) = 0, fib(1) = 1, etc
	 * @param inputNumber The input number
	 * @return The fibonacci number
	 */
	public static int fibonacci(int inputNumber)
	{
		//base cases
		if (inputNumber == 0)
			return 0;
		else if (inputNumber == 1)
			return 1;
		//recursive step
		else
			return fibonacci(inputNumber-1) + fibonacci(inputNumber-2);
	}

	/**
	 * Searches a string for a particular character, returns the index of the first
	 * occurrence or -1 if it doesn't exist	
	 * @param inputString The string to search in
	 * @param searchKey The character to search for
	 * @return The index of the character (-1 if it doesn't exist)
	 */
	public static int searchFirstOccurrence(String inputString, int start, char searchKey)
	{
		//base case
		if (start == inputString.length() - 1)
			return -1;
		//recursive steps
		if (inputString.charAt(start) == searchKey)
			return(start);
		else
			return (searchFirstOccurrence(inputString, ++start, searchKey));
	}


	/**
	 * Returns true of the string is a palindrome, false otherwise
	 * @param inputString The string to evaluate
	 * @return True if its a palindrome, false otherwise
	 */
	public static boolean isPalindrome(String inputString)
	{
		//base case
		if(inputString.length() == 1)
			return true;
		//recursive step
		if(inputString.charAt(0) == inputString.charAt((inputString.length()-1)))
		{
			return(isPalindrome(inputString.substring(1, (inputString.length()-1))));
		}

		else
			return false;
	}

}


public class RecursionExample1 
{

	public static void main(String[] args) 
	{
		System.out.println("Sum of 1 through 20: " + sum(20));
		System.out.println("Sum of 1 to 1: " + sum(1));
		
		System.out.println("Factorial of 10: " + factorial(10));
		System.out.println("Factorial of 0: " + factorial(0));
		
		System.out.println("Fibonacci(10): " + fib(10));
		
		System.out.println("Vowels in CORBAN UNIVERSITY: " + countVowels("CORBAN UNIVERSITY"));
		
		System.out.println(reverseString("Corban University"));
		
		System.out.println(toBinary(10, 0));
	}

	//don't do this!!!
	public static int sum(int n)
	{
		//base case
		if (n < 1)
			return 0;
		//recursive step
		else
			return n + sum(n-1);
	}
	
	public static int factorial(int n)
	{
		//base case 
		if (n == 0)
			return 1;
		//recursive step
		else
			return n * factorial(n - 1);
	}
	
	public static int fib(int n)
	{
		//base cases
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n-1) + fib(n-2);
	}
	
	public static boolean isPowerOf2(int n)
	{
		//return true for 1, 2, 4, 8...
		//return false otherwise
	}
	
	public static int countVowels(String str)
	{
		//Base case
		if (str.length() == 0)
			return 0;
		//if char at 0 = A/E/I/O/U return 1 + recursive step
		//else return 0 + recursive step.
		if(str.charAt(0) == 'A' ||
				str.charAt(0) == 'E' ||
				str.charAt(0) == 'I' ||
				str.charAt(0) == 'O' ||
				str.charAt(0) == 'U')
			return 1 + countVowels(str.substring(1));
		else 
			return countVowels(str.substring(1));
	}	
	
	public static String reverseString(String str)
	{		
		if (str.length() < 2)
			return str;
		else
			return str.charAt(str.length() - 1) + 
					reverseString(str.substring(0, str.length() - 1));
		
	}
	
	public static int toBinary(int n, int i)
	{
		if(n == 0)
			return 0;
		else 
		{
			i += 10;
			return ((n%2) * i) + toBinary(n/2, i);
		}
	}
}

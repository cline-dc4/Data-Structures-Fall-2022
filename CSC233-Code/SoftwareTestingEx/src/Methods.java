
public class Methods 
{
	public static int countFactors(int inputNumber)
	{
		int numberFactors = 0;
		for (int i = 1; i <= inputNumber; i++)
		{
			if(inputNumber % i == 0)
			{
				numberFactors++;
			}
		}
		return numberFactors;
	}
}


public class CountingClass extends Thread
{
	private int id;

	private int countOfPairs;

	private int numberThreads;

	private int inputNumber;

	public CountingClass(int id, int numberThreads, int inputNumber)
	{
		this.id = id;
		this.numberThreads = numberThreads;
		this.inputNumber = inputNumber;
	}

	public int getCountOfPairs()
	{
		return countOfPairs;
	}

	public void run()
	{
		int lower = (inputNumber/numberThreads * id) + 1;
		int upper = (id + 1) * inputNumber/numberThreads;
		for (int i = lower; i < upper; i++)
		{
			if(isPrime(i) && isPrime(i+2))
			{
				countOfPairs++;
			}
		}
	}

	public boolean isPrime(int x)
	{
		if(x == 1)
		{
			return false;
		}
		for(int i = 2; i <= x/2; i++)
		{
			if(x % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}

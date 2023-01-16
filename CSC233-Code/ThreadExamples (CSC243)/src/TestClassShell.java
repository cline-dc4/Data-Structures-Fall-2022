import java.sql.Timestamp;

public class TestClassShell {

	public static void main(String[] args) {

		System.out.println("Savannah and DC");
		Timestamp start = new Timestamp(System.currentTimeMillis());
		int numberThreads = 10; // Change this number to test with variety of threads
		int maxNumber = 10000; // Change this number to test with variety of inputs
		CountingClass [] threads = new CountingClass[numberThreads];
		int totalCount = 0;
		
		for (int i = 0; i < numberThreads; i++)
		{
			threads[i] = new CountingClass(i, numberThreads, maxNumber);
		}
		for (int i = 0; i < numberThreads; i++)
		{
			try
			{
				threads[i].start();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		for (int i = 0; i < numberThreads; i++)
		{
			try 
			{
				threads[i].join();
				totalCount += threads[i].getCountOfPairs();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		Timestamp end = new Timestamp(System.currentTimeMillis());
		
		System.out.println("Total count: " + totalCount);

		System.out.println("Time taken: " + (end.getTime() - start.getTime())/1000.0);
	}
}

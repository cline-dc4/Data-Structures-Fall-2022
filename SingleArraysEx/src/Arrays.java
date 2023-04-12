import java.util.Random;

public class Arrays {

	public static void main(String[] args) {
		int [] arrayOfInts = new int[20];
		Random r = new Random(50);
		for (int i = 0; i < 20; i++)
		{
			arrayOfInts[i] = r.nextInt()%40;
		}
		for (int i = 0; i < 20; i++)
			System.out.println(arrayOfInts[i]);
		System.out.println();
		
		double [] arrayOfDoubles = new double[10];
		arrayOfDoubles[0] = 3.5;
		arrayOfDoubles[1] = -6.2;
		arrayOfDoubles[2] = 7.0;
		printArray(arrayOfDoubles);	
		insertItem(arrayOfDoubles, 123.45, 1);
		printArray(arrayOfDoubles);

		
		int [][] matrix = new int [12][49];
		for (int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] = r.nextInt()%10;
			}
		}
		System.out.println(calculateAverage(matrix));
	}
	public static double calculateAverage(int [][] matrix)
	{
		int sum = 0;
		for (int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				sum += matrix[i][j];
			}
		}
		double average = (double)sum/(matrix.length*matrix[0].length);
		return average;
	}
	public static void printArray(double [] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] +" ");
		}
		System.out.println();
	}
	public static int [] resize(int [] originalArray)
	{
		int [] newArray = new int[originalArray.length * 2];
		for (int i = 0; i < originalArray.length; i++)
		{
			newArray[i] = originalArray[i];
		}
		return newArray;
	}
	public static void insertItem(double [] array, double item, int i)
	{
		//slide all items to the right of it to the right.
		for(int x = array.length - 1; x > i; x--)
			array[x] = array[x - 1];
		array[i] = item;
	}
	
	public static int countBetween(int [][] matrix, int lower, int upper)
	{
		int count = 0;
		for (int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				if(matrix[i][j] > lower && matrix[i][j] < upper)
				{
					count += 1;
				}
			}
		}
		return count;
	}

}

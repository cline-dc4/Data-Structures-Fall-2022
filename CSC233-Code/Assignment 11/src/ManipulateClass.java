import java.util.Random;

public class ManipulateClass implements Manipulate
{
	/** the matrix of chars.*/
	private char [][] matrix;
	/** the number of rows in the matrix*/
	private int rows;
	/** the number of columns in the matrix*/
	private int columns;
	
	/**
	 * The constructor that creates the matrix.
	 * @param rows # of rows in the matrix
	 * @param columns # of columns in the matrix
	 * @param seed an int for the random number generator.
	 */
	public ManipulateClass(int rows, int columns, int seed)
	{
		//creating the matrix
		this.rows = rows;
		this.columns = columns;
		this.matrix = new char [rows][columns];
		//generating random chars\
		Random r = new Random(seed);
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] = (char)(r.nextInt(26)+65);
			}
		}
	}
	
	/**
	 * Prints the matrix as a table.
	 */
	public void printMatrix()
	{
		System.out.println("===================");
		System.out.println("Number of rows: " + rows + " Number of columns: " + columns);
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===================");
	}

	/**
	 * transposes the matrix (flips it over the diagonal)
	 */
	public void transpose() 
	{
		//can't switch columns and rows w/o extra variables to hold values.
		int newRows = columns;
		int newColumns = rows;
		char [][] transposedMatrix = new char[newRows][newColumns];
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				transposedMatrix[j][i] = matrix[i][j];
			}
		}
		
		matrix = transposedMatrix;
		rows = newRows;
		columns = newColumns;
	}

	/**
	 * copies a row in the matrix into another row.
	 * @param origionalRow the row you are copying from
	 * @param newRow the row you are copying to
	 */
	public void copyRow(int originalRow, int newRow) 
	{
		for(int i = 0; i < matrix[originalRow].length; i++)
		{
			matrix[newRow][i] = matrix[originalRow][i];
		}
	}

}

/**
 * Manipulate interface
 * @author DThomas
 *
 */
public interface Manipulate {
	
	/**
	 * Print out the matrix in a table
	 */
	public void printMatrix();
		
	/**
	 * Transpose the matrix: Swap the rows and column values
	 * An mxn matrix will become an nxm matrix
	 */
	public void transpose();
	
	/**
	 * Copy from one row to another
	 * @param originalRow The row number to copy from
	 * @param newRow The row number to copy to
	 */
	public void copyRow(int originalRow, int newRow);
	
}

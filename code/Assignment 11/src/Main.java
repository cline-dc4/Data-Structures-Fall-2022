
public class Main {
	public static void main(String [] args)
	{
		Manipulate m = new ManipulateClass(4, 6, 13);
		System.out.println("Original");
		m.printMatrix();
		m.transpose();
		System.out.println("Transposed");
		m.printMatrix();
		System.out.println("After copying");
		
		m.copyRow(2, 4);
		m.printMatrix();
	}
}


public class Driver {

	public static void main(String[] args) {

		Parser symbolParser = new Parser();
		try {
			//symbolParser.parseFile("ValidFile.txt");
			//symbolParser.parseFile("NotEnoughClosing.txt");
			//symbolParser.parseFile("NotEnoughOpening.txt");
			//symbolParser.parseFile("Mismatch.txt");
		} 
		catch (Exception e) 
		{	
			System.out.println("Error: " + e.getMessage());
		}
	}

}

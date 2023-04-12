import java.util.ArrayList;

public class testMain {

	public static void main(String[] args) 
	{
		LinkedList ll = new LinkedList();
		
		
		try {
			ll.addNode(354, 0);
			System.out.println(ll);
			ll.deleteNode(0);
			System.out.println(ll);
			ll.addNode(-45, 0);
			ll.addNode(512, 1);
			ll.addNode(125, 0);
			ll.addNode(-1000, 3);
			System.out.println(ll);
			ll.deleteNode(2);
			System.out.println(ll);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//List options
		ArrayList<Integer> integerAL = new ArrayList<Integer>();
		// array[0]= 123;
		integerAL.add(123);
		integerAL.add(555);
		for (int i = 0; i < integerAL.size(); i++)
		{
			System.out.println(i + ": " + integerAL.get(i));
		}
	}
}

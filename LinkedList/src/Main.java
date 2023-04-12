
public class Main 
{
	public static void main(String[] args)
	{
		Node<Integer> n1 = new Node<Integer>(3);
		Node<Integer> n2 = new Node<Integer>(8);
		Node<Integer> n3 = new Node<Integer>(2);
		int sum = n1.getData() + n2.getData() + n3.getData();
		System.out.println("Sum: " + sum);
		n1.setNext(n2);
		n2.setNext(n3);
		System.out.println("Sum: " + getSum(n1));
		n3.setNext(new Node<Integer>(21));
		System.out.println("Sum of all 4: " + getSum(n1));
	}
	
	public static int getSum(Node<Integer> start)
	{
		Node<Integer> iterator = start;
		int sum = 0;
		while (iterator != null)
		{
			sum += iterator.getData();
			iterator = iterator.getNext();
		}
		return sum;
	}
	
}

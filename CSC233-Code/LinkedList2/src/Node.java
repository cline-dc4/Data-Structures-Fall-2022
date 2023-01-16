
public class Node {
	private int data;
	
	private Node next;
	
	public Node()
	{
		setData(0);
		setNext(null);
	}
	
	public Node(int data)
	{
		setData(data);
		setNext(null);
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Node getNext()
	{
		return next;
	}

	public void setData(int data) 
	{
		this.data = data;
	}
	
	public int getData() 
	{
		return data;
	}
	
	public String toString()
	{
		return "" + data;
	}
}


public class LinkedList
{
	private int length;
	
	private Node head;
	
	public LinkedList()
	{
		length = 0;
		head = new Node(); // This is the sentinel node.
	}
	
	public void addNode(int data, int index) throws Exception
	{
		if(index < 0 || index > length)
		{
			throw new Exception("Invalid index");
		}
		Node p = head;
		for(int i = 0; i < index; i++)
		{
			//Move p till we are at  the node prior to 
			//the location of the new node.
			p = p.getNext();
		}
		Node newNode = new Node(data);
		newNode.setNext(p.getNext());
		p.setNext(newNode);
		length++;
	}
	
	public void deleteNode(int index) throws Exception
	{
		if(index < 0 || index >= length)
		{
			throw new Exception("Invalid index");
		}
		//Iterate through the linked list to find P.
		//P is node prior to the node to delete.
		Node iterator = head;
		for(int i = 0; i < index; i++)
		{
			iterator = iterator.getNext();
		}
		//iterator is point to node before the one
		//to be deleted.
		iterator.setNext(iterator.getNext().getNext());
		length--;
	}
	
	public String toString()
	{
		String s = "Length: " + length + "\n";
		Node iterator = head.getNext();
		for(int i = 0; i < length; i++)
		{
			s += (iterator.getData()) + " ";
			iterator = iterator.getNext();
		}
		return s;
	}
}

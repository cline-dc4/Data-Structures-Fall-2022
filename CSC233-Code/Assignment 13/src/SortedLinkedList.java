/**
 * A linked list that is only used for strings.
 * When a string is added it is added in alphabetical order.
 * @author DC
 */
public class SortedLinkedList 
{
	/** The length of the list.*/
	private int length;
	/** A sentinel node that is the first node in the list. */
	private Node head;
	
	/**
	 * The constructor for the SortedLinkedList
	 * creates the head and sets length to 0.
	 */
	public SortedLinkedList()
	{
		length = 0;
		head = new Node();
	}
	
	/**
	 * adds a node with specified data into the list, 
	 * maintaining alphabetical order.
	 * @param data the data the node should hold.
	 * @throws Exception when the index is either < 0 or index > length.
	 */
	public void addItem(String newString) throws Exception
	{
		//incrementing iterator until the string > the one stored already,
		//or until the string is in alphabetical order.
		Node iterator = head;

		for (int i = 0; i < length; i++)
		{
			//exception if string is already in list.
			if (iterator.getNext().getData().equals(newString))
			{
				throw new Exception("This string already exists in the list.");
			}
			//break out of loop if string will be in order at this index.
			if (iterator.getNext().getData().compareToIgnoreCase(newString) > 0)
			{
				break;
			}
			//increment iterator
			iterator = iterator.getNext();
		}
		//adding the node to the list.
		Node newNode = new Node(newString);
		newNode.setNext(iterator.getNext());
		iterator.setNext(newNode);
		length++;
	}
	/**
	 * Deletes a Node from the list corresponding 
	 * to the string passed into the function.
	 * @param deleteString the string the function will delete.
	 * @throws Exception thrown whenever the string passed doesn't exist in the list.
	 */
	public void deleteItem(String deleteString) throws Exception
	{
		Node iterator = head;
		//increments iterator until it is the node
		//prior to the one being deleted/searched for.
		for (int i = 0; i < length; i++)
		{
			//break out of loop if equal
			if (iterator.getNext().getData().compareToIgnoreCase(deleteString) == 0)
			{
				break;
			}
			//throw exception if reaches end and doesn't find the key in list.
			if (i == length - 1)
			{
				throw new Exception("That string doesn't exist in the list.");
			}
			//increment iterator
			iterator = iterator.getNext();
		}
		//deleting the node
		iterator.setNext(iterator.getNext().getNext());
		length--;
	}
	/**
	 * adds the length to the string, then adds all
	 * of the data from the nodes into the string.
	 * @return a String for use in print statements.
	 */
	public String toString()
	{
		String s = "Length: " + length + "\n";
		Node iterator = head.getNext();
		for(int i = 0; i < length; i++)
		{
			s += (i + ": " + iterator.getData() + "\n");
			iterator = iterator.getNext();
		}
		return s;
	}
}

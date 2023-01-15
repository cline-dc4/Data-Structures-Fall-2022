/**
 * The node class for a linked list.
 * Each node holds a piece of data for the list.
 * @author DC
 */
public class Node
{
	/** this is the data held in each node. */
	private String data;
	/** this is a pointer to the next node in the list. */
	private Node next;
	/**
	 * default constructor, sets the node values to null or empty.
	 */
	public Node()
	{
		setData("");
		setNext(null);
	}
	/**
	 * constructor for the node that can add 
	 * data to the node.
	 * @param data the data held in the node.
	 */
	public Node(String data)
	{
		setData(data);
		setNext(null);
	}
	/**
	 * sets the pointer to point to another node.
	 * @param next should be the next node 
	 * added in the list.
	 */
	public void setNext(Node next)
	{
		this.next = next;
	}
	/**
	 * gets the pointer to the next node in the list.
	 * @return the pointer pointing to another node.
	 */
	public Node getNext()
	{
		return next;
	}
	/**
	 * setter for data stored in the node.
	 * @param data the String being added.
	 */
	public void setData(String data) 
	{
		this.data = data;
	}
	/**
	 * getter for the data in the node.
	 * @return the data in the node.
	 */
	public String getData() 
	{
		return data;
	}
	/**
	 * returns the String data.
	 */
	public String toString()
	{
		return data;
	}
}

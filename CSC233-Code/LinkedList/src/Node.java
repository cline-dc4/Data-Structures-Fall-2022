/**
 * The node class for a linked list.
 * Each node holds a piece of data for the list.
 * @author DC
 *
 * @param <T> indicates the type of data held in the list.
 */
public class Node<T> 
{
	/** this is the data held in each node. */
	private T data;
	/** this is a pointer to the next node in the list. */
	private Node<T> next;
	/**
	 * default constructor, sets the node values to null.
	 */
	public Node()
	{
		setData(null);
		setNext(null);
	}
	/**
	 * constructor for the node that can add 
	 * data to the node.
	 * @param data the data held in the node.
	 */
	public Node(T data)
	{
		setData(data);
		setNext(null);
	}
	/**
	 * sets the pointer to point to another node.
	 * @param next should be the next node 
	 * added in the list.
	 */
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	/**
	 * gets the pointer to the next node in the list.
	 * @return the pointer pointing to another node.
	 */
	public Node<T> getNext()
	{
		return next;
	}
	/**
	 * setter for data stored in the node.
	 * @param data is whatever datatype T is.
	 */
	public void setData(T data) 
	{
		this.data = data;
	}
	/**
	 * getter for the data in the node.
	 * @return the data in the node.
	 */
	public T getData() 
	{
		return data;
	}
	/**
	 * calls the toString function for the data in the node.
	 */
	public String toString()
	{
		return data.toString();
	}
}


public class Queue
{
	/**
	 * The array
	 */
	private int [] arrayOfItems;
	/**
	 * The capacity of the array
	 */
	private final int CAPACITY = 10;
	/**
	 * The size of the array
	 */
	private int size;

	/** The front of the queue*/
	private int head;

	/** The tail of the queue*/
	private int tail;

	/** Constructor*/
	public Queue()
	{
		arrayOfItems = new int [CAPACITY];
		head = 0;
		tail = 0;
		size = 0;
	}

	/**
	 * Remove the front of the queue
	 * @return The item returned
	 */
	public int dequeue()
	{
		int item = arrayOfItems[head];
		head = (head+1)%CAPACITY;
		size--;
		return item;

	}
	/**
	 * Adds item at the tail
	 * @param newItem Item to be added
	 */
	public void enqueue(int newItem)
	{
		arrayOfItems[tail] = newItem;
		tail = (tail+1)%CAPACITY;
		size++;
	}

	/**
	 * Checks to see if it is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		if(size == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Print function
	 */
	public void printQueue()
	{
		System.out.println("====================");
		System.out.print("Queue: ");
		for (int counter = head; counter < head + size; counter++)
		{
			System.out.print(arrayOfItems[(counter%CAPACITY)] + " ");
		}
		System.out.println("");
		System.out.println("====================\n");
	}


}

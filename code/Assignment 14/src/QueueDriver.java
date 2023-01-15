/** 
 * Class driver
 * Enqueueing: 0
====================
Queue: 0 
====================

Enqueueing: 1
====================
Queue: 0 1 
====================

Enqueueing: 2
====================
Queue: 0 1 2 
====================

Enqueueing: 3
====================
Queue: 0 1 2 3 
====================

Enqueueing: 4
====================
Queue: 0 1 2 3 4 
====================

Enqueueing: 5
====================
Queue: 0 1 2 3 4 5 
====================

Enqueueing: 6
====================
Queue: 0 1 2 3 4 5 6 
====================

Enqueueing: 7
====================
Queue: 0 1 2 3 4 5 6 7 
====================

Enqueueing: 8
====================
Queue: 0 1 2 3 4 5 6 7 8 
====================

Enqueueing: 9
====================
Queue: 0 1 2 3 4 5 6 7 8 9 
====================

====================
Queue: 0 1 2 3 4 5 6 7 8 9 
====================

Dequeing: 0
====================
Queue: 1 2 3 4 5 6 7 8 9 
====================

Dequeing: 1
====================
Queue: 2 3 4 5 6 7 8 9 
====================

Dequeing: 2
====================
Queue: 3 4 5 6 7 8 9 
====================

Dequeing: 3
====================
Queue: 4 5 6 7 8 9 
====================

Dequeing: 4
====================
Queue: 5 6 7 8 9 
====================

Enqueing: 10
====================
Queue: 5 6 7 8 9 10 
====================

Enqueing: 11
====================
Queue: 5 6 7 8 9 10 11 
====================

Enqueing: 12
====================
Queue: 5 6 7 8 9 10 11 12 
====================

Enqueing: 13
====================
Queue: 5 6 7 8 9 10 11 12 13 
====================

Enqueing: 14
====================
Queue: 5 6 7 8 9 10 11 12 13 14 
====================

====================
Queue: 6 7 8 9 10 11 12 13 14 
====================

====================
Queue: 7 8 9 10 11 12 13 14 
====================

====================
Queue: 8 9 10 11 12 13 14 
====================

====================
Queue: 9 10 11 12 13 14 
====================

====================
Queue: 10 11 12 13 14 
====================

====================
Queue: 11 12 13 14 
====================

====================
Queue: 12 13 14 
====================

====================
Queue: 13 14 
====================

====================
Queue: 14 
====================

====================
Queue: 
====================
 * @author thodeb
 *
 */
public class QueueDriver {
	public static void main(String [] args)
	{
		Queue myQueue = new Queue();
		for (int counter = 0; counter < 10; counter++)
		{
			System.out.println("Enqueueing: " + counter);

			myQueue.enqueue(counter);
			myQueue.printQueue();
		}
		myQueue.printQueue();
		// Dequeueing the first 5 items
		for (int counter = 1; counter <= 5; counter++)
		{
			System.out.println("Dequeing: " + myQueue.dequeue());
			myQueue.printQueue();
		}
		for (int counter = 10; counter < 15; counter++)
		{
			System.out.println("Enqueing: " + counter);
			myQueue.enqueue(counter);
			myQueue.printQueue();
		}
		while (!myQueue.isEmpty())
		{
			myQueue.dequeue();
			myQueue.printQueue();
		}
	}
}

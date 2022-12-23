import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * A queue is an ordered list of objects which are processed in a first-in, first-out (FIFO) 
 * manner, i.e. elements are inserted at the tail or rear-end of the queue whereas 
 * removal of elements occur at the head or front-end of the queue.
 */

public class Queue_Learn {

	public static void main(String[] args) {

		/*
		 * The 'Queue' interface extends 'Collection' interface and declares the
		 * behaviour of a queue. 'Queue' being an interface needs a class which provides
		 * implementation to its methods and also that we can create objects of that
		 * class. 'LinkedList' and 'PriorityQueue' are the most commonly used classes
		 * used while creating a queue object.
		 */

		/*
		 * 'LinkedList' class extends 'AbstractSequentialList' class and implements the
		 * 'List', 'Queue' and 'Deque' interfaces.
		 */

		Queue<Integer> demoQueue = new LinkedList<>();

		/*
		 * Add an element to the queue
		 * 
		 * boolean add(E obj) : Declared in the Collection interface. Adds object to the
		 * collection. Returns true if object was added, otherwise returns false.
		 * 
		 * boolean offer(E obj) : Declared in the Queue interface. Adds object to the
		 * queue. Returns true if object was added, otherwise returns false.
		 */

		demoQueue.add(30);
		// demoQueue = [30]

		demoQueue.add(10);
		// demoQueue = [30, 10]

		demoQueue.add(50);
		// demoQueue = [30, 10, 50]

		System.out.println("demoQueue = " + demoQueue); // demoQueue = [30, 10, 50]

		demoQueue.offer(20);
		// demoQueue = [30, 10, 50, 20]

		demoQueue.offer(40);
		// demoQueue = [30, 10, 50, 20, 40]

		System.out.println("demoQueue = " + demoQueue); // demoQueue = [30, 10, 50, 20, 40]

		/*
		 * Remove an element from the queue
		 * 
		 * E remove() : Declared in the Queue interface. Removes the element at the head
		 * of the queue returning the element in the process. It throws
		 * NoSuchElementException if the queue is empty.
		 * 
		 * boolean remove(Object obj) : Declared in the Collection interface. Removes
		 * one instance of obj from the queue. Returns true if the element was removed.
		 * Otherwise, returns false.
		 */

		demoQueue.remove();
		// demoQueue = [10, 50, 20, 40]

		System.out.println("demoQueue = " + demoQueue); // demoQueue = [10, 50, 20, 40]

		int removedElement = demoQueue.remove();
		// demoQueue = [50, 20, 40]

		System.out.println("Element removed = " + removedElement); // Element removed = 10

		demoQueue.add(10);
		// demoQueue = [50, 20, 40, 10]

		demoQueue.remove(10);
		// demoQueue = [50, 20, 40]

		System.out.println("demoQueue = " + demoQueue); // demoQueue = [50, 20, 40]

		/*
		 * Get the element at the head of the queue
		 * 
		 * E peek() : Declared in the Queue interface. Returns the element at the head
		 * of the queue. It returns null if the queue is empty.
		 */

		int headElement = demoQueue.peek();
		// demoQueue = [50, 20, 40]

		System.out.println("Head element = " + headElement); // Head element = 50

		/*
		 * Get & remove the element at the head of the queue
		 * 
		 * E poll() : Declared in the Queue interface. Returns the element at the head
		 * of the queue, removing the element in the process. It returns null if the
		 * queue is empty.
		 */

		headElement = demoQueue.poll();
		// demoQueue = [20, 40]

		System.out.println("Head element = " + headElement); // Head element = 50

		demoQueue.poll();
		// demoQueue = [40]

		System.out.println("demoQueue = " + demoQueue); // demoQueue = [40]

		/*
		 * Get the count of elements present in the queue
		 * 
		 * int size() : Declared in the Collection interface. Returns the number of
		 * elements held in the invoking collection.
		 */

		int queueSize = demoQueue.size();

		System.out.println("Size = " + queueSize); // Size = 1

		/*
		 * Check if queue is empty or not
		 * 
		 * boolean isEmpty() : Declared in the Collection interface. Returns true if the
		 * invoking collection is empty. Otherwise, returns false.
		 */

		if (demoQueue.isEmpty())
			System.out.println("Queue is empty !");
		else
			System.out.println("Queue is not empty !");

		/*
		 * Check if an object is present the queue
		 * 
		 * boolean contains(Object obj) : Declared in the Collection interface. Returns
		 * true if obj is an element of the invoking collection. Otherwise, returns
		 * false.
		 */

		int value = 40;

		if (demoQueue.contains(value))
			System.out.println("Queue contains " + value);
		else
			System.out.println("Queue does not contain " + value);

		/*
		 * Clear the queue
		 * 
		 * void clear() : Declared in the Collection interface. Removes all elements
		 * from the invoking collection.
		 */

		demoQueue.clear();
		// demoQueue = []

		System.out.println("demoQueue = " + demoQueue); // demoQueue = []

		/*
		 * Construct queue from array
		 */

		String fruits[] = { "apple", "grape", "banana", "orange" };

		Queue<String> fruitQueue = new LinkedList<>();

		Collections.addAll(fruitQueue, fruits);

		System.out.println("fruitQueue = " + fruitQueue); // fruitQueue = [apple, grape, banana, orange]

		/*
		 * Construct array from queue
		 */

		String fruitArr[] = fruitQueue.toArray(new String[fruitQueue.size()]);

		System.out.println("fruitArr = " + Arrays.toString(fruitArr)); // fruitArr = [apple, grape, banana, orange]

		/*
		 * Iterating over the contents of a queue
		 */

		Iterator itr = fruitQueue.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();

		for (String fruit : fruitQueue) {
			System.out.print(fruit + " ");
		}

	}

}

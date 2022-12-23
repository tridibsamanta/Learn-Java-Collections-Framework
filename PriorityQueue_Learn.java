import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
 * A priority queue is an ordered list of objects which are processed according to priority. 
 * The priority of an element is based on the queue's comparator.
 * 
 * If no comparator is specified when a PriorityQueue is constructed, then the default
 * comparator for the type of data stored in the queue is used. By default the comparator
 * will order the queue in ascending order, i.e. the head of the queue will always be the
 * element having smallest value (least priority).
 */

public class PriorityQueue_Learn {

	public static void main(String[] args) {

		/*
		 * The 'PriorityQueue' class extends 'AbstractQueue' class and implements the
		 * 'Queue' interface.
		 */

		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		// head element will be the smallest value (min-heap)

		/*
		 * Add an element to the Priority Queue
		 * 
		 * boolean add(E obj) : Declared in the Collection interface. Adds object to the
		 * collection. Returns true if object was added, otherwise returns false.
		 * 
		 * boolean offer(E obj) : Declared in the Queue interface. Adds object to the
		 * queue. Returns true if object was added, otherwise returns false.
		 */

		minQueue.add(30);
		minQueue.add(20);
		minQueue.add(50);

		System.out.println("minQueue = " + minQueue); // minQueue = [20, 30, 50]

		minQueue.offer(10);
		minQueue.offer(40);

		System.out.println("minQueue = " + minQueue); // minQueue = [10, 20, 50, 30, 40]

		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
		// head element will be the largest value (max-heap)

		maxQueue.add(30);
		maxQueue.add(20);
		maxQueue.add(50);

		System.out.println("maxQueue = " + maxQueue); // maxQueue = [50, 20, 30]

		maxQueue.offer(10);
		maxQueue.offer(40);

		System.out.println("maxQueue = " + maxQueue); // maxQueue = [50, 40, 30, 10, 20]

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

		// minQueue = [10, 20, 50, 30, 40]
		minQueue.remove();
		// minQueue = [20, 30, 50, 40]

		System.out.println("minQueue = " + minQueue); // minQueue = [20, 30, 50, 40]

		// minQueue = [20, 30, 50, 40]
		int removedElement = minQueue.remove();
		// minQueue = [30, 40, 50]

		System.out.println("Element removed = " + removedElement); // Element removed = 20

		// minQueue = [30, 40, 50]
		minQueue.remove(40);
		// minQueue = [30, 50]

		System.out.println("minQueue = " + minQueue); // minQueue = [30, 50]

		/*
		 * Get the element at the head of the queue
		 * 
		 * E peek() : Declared in the Queue interface. Returns the element at the head
		 * of the queue. It returns null if the queue is empty.
		 */

		// maxQueue = [50, 40, 30, 10, 20]
		int headElement = maxQueue.peek();

		System.out.println("Head element = " + headElement); // Head element = 50

		/*
		 * Get & remove the element at the head of the queue
		 * 
		 * E poll() : Declared in the Queue interface. Returns the element at the head
		 * of the queue, removing the element in the process. It returns null if the
		 * queue is empty.
		 */

		// maxQueue = [50, 40, 30, 10, 20]
		headElement = maxQueue.poll();
		// maxQueue = [40, 20, 30, 10]

		System.out.println("Head element = " + headElement); // Head element = 50

		// maxQueue = [40, 20, 30, 10]
		maxQueue.poll();
		// maxQueue = [30, 20, 10]

		System.out.println("maxQueue = " + maxQueue); // maxQueue = [30, 20, 10]

		/*
		 * Get the count of elements present in the queue
		 * 
		 * int size() : Declared in the Collection interface. Returns the number of
		 * elements held in the invoking collection.
		 */

		// maxQueue = [30, 20, 10]
		int queueSize = maxQueue.size();

		System.out.println("Size = " + queueSize); // Size = 3

		/*
		 * Check if queue is empty or not
		 * 
		 * boolean isEmpty() : Declared in the Collection interface. Returns true if the
		 * invoking collection is empty. Otherwise, returns false.
		 */

		if (maxQueue.isEmpty())
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

		int value = 20;

		// maxQueue = [30, 20, 10]
		if (maxQueue.contains(value))
			System.out.println("Queue contains " + value);
		else
			System.out.println("Queue does not contain " + value);

		/*
		 * Clear the queue
		 * 
		 * void clear() : Declared in the Collection interface. Removes all elements
		 * from the invoking collection.
		 */

		// minQueue = [30, 50]
		minQueue.clear();
		// minQueue = []

		System.out.println("minQueue = " + minQueue); // minQueue = []

		/*
		 * Construct queue from array
		 */

		Integer nums[] = { 40, 10, 50, 20, 30 };

		PriorityQueue<Integer> numsMinQueue = new PriorityQueue<>();

		Collections.addAll(numsMinQueue, nums);

		System.out.println("numsMinQueue = " + numsMinQueue); // numsQueue = [10, 20, 50, 40, 30]

		PriorityQueue<Integer> numsMaxQueue = new PriorityQueue<>(Comparator.reverseOrder());

		Collections.addAll(numsMaxQueue, nums);

		System.out.println("numsMaxQueue = " + numsMaxQueue); // numsMaxQueue = [50, 30, 40, 10, 20]

		/*
		 * Construct array from queue
		 */

		Integer numArr[] = numsMinQueue.toArray(new Integer[numsMinQueue.size()]);

		System.out.println("numArr = " + Arrays.toString(numArr)); // numArr = [10, 20, 50, 40, 30]

		/*
		 * Iterating over the contents of a queue
		 */

		Iterator itr = numsMinQueue.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();

		for (int num : numsMinQueue) {
			System.out.print(num + " ");
		}

	}

}

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * An ArrayList is a dynamic-sized array. It grows and shrinks in size
 * dynamically as we keep on adding or removing elements. 
 */

public class ArrayList_Learn {

	public static void main(String[] args) {

		/*
		 * The 'List' interface extends the 'Collection' interface and declares the
		 * behavior of a collection that stores a sequence of elements. Elements can be
		 * added or accessed by their position in the list, using a zero-based index. A
		 * list may also contain duplicate elements.
		 * 
		 * The 'ArrayList' class extends the 'AbstractList' class and implements the
		 * 'List' interface.
		 */

		List<Integer> numList = new ArrayList<>();

		/*
		 * Adding elements to ArrayList
		 * 
		 * boolean add(E obj) : Declared in the Collection interface. Adds object to the
		 * collection. Returns true if object was added, otherwise returns false.
		 * 
		 * void add(int index, E obj) : Declared in the List interface. Adds object obj
		 * to the invoking list at the index passed. Any preexisting element at or
		 * beyond the index are shifted up. Thus no elements are overwritten.
		 * 
		 * boolean addAll(Collection c) : Declared in the Collection interface. Adds all
		 * the elements of c to the invoking collection. Returns true if elements were
		 * added to the invoking collection. Otherwise, returns false.
		 * 
		 * boolean addAll(int index, Collection c) : Declared in the List interface.
		 * Adds all the elements of c to the invoking list at the index passed. Any
		 * preexisting element at or beyond the index are shifted up. Thus no elements
		 * are overwritten. Returns true if elements were added to the invoking list.
		 * Otherwise, returns false.
		 */

		numList.add(7);
		// numList = [7]

		numList.add(5);
		// numList = [7, 5]

		numList.add(1, 3);
		// numList = [7, 3, 5]

		List<Integer> nums = new ArrayList<>(Arrays.asList(6, 3, 1));

		numList.addAll(nums);
		// numList = [7, 3, 5, 6, 3, 1]

		nums = new ArrayList<>(Arrays.asList(4, 7));

		numList.addAll(4, nums);
		// numList = [7, 3, 5, 6, 4, 7, 3, 1]

		System.out.println("numList = " + numList);
		// numList = [7, 3, 5, 6, 4, 7, 3, 1]

		/*
		 * Removing elements from ArrayList
		 * 
		 * boolean remove(Object obj) : Declared in the Collection interface. Removes
		 * one instance of obj from the invoking collection. Returns true if the element
		 * was removed. Otherwise, returns false.
		 * 
		 * boolean removeAll(Collection c) : Declared in the Collection interface.
		 * Removes all elements of c from the invoking collection. Returns true if
		 * elements were removed from the invoking collection. Otherwise, returns false.
		 * 
		 * E remove(int index) : Declared in the List interface. Removes the element at
		 * the specified index from the invoking list, returning the element in the
		 * process. The indexes of the subsequent elements are decremented by one.
		 * 
		 * boolean retainAll(Collection c) : Declared in the Collection interface.
		 * Removes all elements from the invoking collection except those in c. Returns
		 * true if elements were removed from the invoking collection. Otherwise,
		 * returns false.
		 */

		// numList = [7, 3, 5, 6, 4, 7, 3, 1]
		numList.remove(Integer.valueOf(3));
		// numList = [7, 5, 6, 4, 7, 3, 1]

		nums = new ArrayList<>(Arrays.asList(6, 7));

		// removes all occurrences of each element of nums from numList
		numList.removeAll(nums);
		// numList = [5, 4, 3, 1]

		int removedElement = numList.remove(1);
		System.out.println("removedElement = " + removedElement); // removedElement = 4

		System.out.println("numList = " + numList);
		// numList = [5, 3, 1]

		numList.addAll(Arrays.asList(4, 7, 3, 1, 5));
		// numList = [5, 3, 1, 4, 7, 3, 1, 5]

		nums.addAll(Arrays.asList(5, 1));
		// nums = [6, 7, 5, 1]

		numList.retainAll(nums); // Elements [3, 4] are removed from numList
		// numList = [5, 1, 7, 1, 5]

		System.out.println("numList = " + numList);
		// numList = [5, 1, 7, 1, 5]

		/*
		 * Check if ArrayList contains an object
		 * 
		 * boolean contains(Object obj) : Declared in the Collection interface. Returns
		 * true if obj is an element of the invoking collection. Otherwise, returns
		 * false.
		 * 
		 * boolean containsAll(Collection c) : Declared in the Collection interface.
		 * Returns true if the invoking collection contains all elements of c.
		 * Otherwise, returns false.
		 */

		int value = 5;

		// numList = [5, 1, 7, 1, 5]
		if (numList.contains(value))
			System.out.println("numList contains " + value);
		else
			System.out.println("numList does not contain " + value);

		nums = new ArrayList<>(Arrays.asList(5, 7));

		// numList = [5, 1, 7, 1, 5]
		if (numList.containsAll(nums))
			System.out.println("numList contains all elements of nums");
		else
			System.out.println("numList does not contain all elements of nums");

		/*
		 * Get the element at an index in ArrayList
		 * 
		 * E get(int index) : Declared in the List interface. Returns the object stored
		 * at the specified index within the invoking collection.
		 */

		// numList = [5, 1, 7, 1, 5]
		int element = numList.get(2);

		System.out.println("element = " + element); // element = 7

		/*
		 * Get the index of an element in ArrayList
		 * 
		 * int indexOf(Object obj) : Declared in the List interface. Returns the index
		 * of the first instance of obj in the invoking list. If obj is not present in
		 * the list, -1 is returned.
		 * 
		 * int lastIndexOf(Object obj) : Declared in the List interface. Returns the
		 * index of the last instance of obj in the invoking list. If obj is not present
		 * in the list, -1 is returned.
		 */

		// numList = [5, 1, 7, 1, 5]
		int lastIndex = numList.lastIndexOf(5);

		System.out.println("lastIndex = " + lastIndex); // lastIndex = 4

		/*
		 * Set the element at an index in ArrayList
		 * 
		 * E set(int index, E obj) : Declared in the List interface. Assigns obj to the
		 * location specified by index within the invoking list. Returns the old value.
		 */

		// numList = [5, 1, 7, 1, 5]
		int oldValue = numList.set(3, 9);

		System.out.println("oldValue = " + oldValue); // oldValue = 1

		System.out.println("numList = " + numList); // numList = [5, 1, 7, 9, 5]

		/*
		 * Check if ArrayList is empty or not
		 * 
		 * boolean isEmpty() : Declared in the Collection interface. Returns true if the
		 * invoking collection is empty. Otherwise, returns false.
		 */

		// numList = [5, 1, 7, 9, 5]
		if (numList.isEmpty())
			System.out.println("ArrayList is empty");
		else
			System.out.println("ArrayList is not empty");

		/*
		 * Get the count of elements present in the ArrayList
		 * 
		 * int size() : Declared in the Collection interface. Returns the number of
		 * elements held in the invoking collection.
		 */

		// numList = [5, 1, 7, 9, 5]
		int listSize = numList.size();

		System.out.println("Size = " + listSize); // Size = 5

		/*
		 * Get sub-list from an ArrayList
		 * 
		 * List<E> subList(int startIndex, int endIndex) : Declared in the List
		 * interface. Returns a list that includes elements from startIndex to (endIndex
		 * - 1) in the invoking list. Elements in the returned list are also referenced
		 * by the invoking object.
		 */

		// numList = [5, 1, 7, 9, 5]
		List<Integer> subArrayList = new ArrayList<Integer>();

		subArrayList = numList.subList(1, 4);

		System.out.println("subArrayList = " + subArrayList); // subArrayList = [1, 7, 9]

		/*
		 * Clear the ArrayList
		 * 
		 * void clear() : Declared in the Collection interface. Removes all elements
		 * from the invoking collection.
		 */

		// numList = [5, 1, 7, 9, 5]
		numList.clear();

		System.out.println("numList = " + numList); // numList = []

		/*
		 * Construct ArrayList from array
		 */

		String fruits[] = { "apple", "grape", "banana", "orange", "grape" };

		List<String> fruitList = new ArrayList<>();

		Collections.addAll(fruitList, fruits);

		System.out.println("fruitList = " + fruitList); // fruitList = [apple, grape, banana, orange, grape]

		/*
		 * Construct array from ArrayList
		 */

		String fruitArr[] = fruitList.toArray(new String[fruitList.size()]);

		System.out.println("fruitArr = " + Arrays.toString(fruitArr)); // fruitArr = [apple, grape, banana, orange,
																		// grape]

		/*
		 * Iterating over the contents of a ArrayList
		 * 
		 * Iterator<E> iterator() : Declared in the Collection interface. Returns an
		 * iterator for the invoking collection.
		 */

		// fruitList = [apple, grape, banana, orange, grape]
		Iterator itr = fruitList.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();

		// Iterate using for-each loop

		// fruitList = [apple, grape, banana, orange, grape]
		for (String fruit : fruitList) {
			System.out.print(fruit + " ");
		}

		System.out.println();

		/*
		 * ListIterator<E> listIterator() : Declared in the List interface. Returns an
		 * iterator to invoking list starting from the first element.
		 */

		// fruitList = [apple, grape, banana, orange, grape]
		ListIterator listItr = fruitList.listIterator();

		while (listItr.hasNext()) {
			System.out.print(listItr.next() + " ");
		}

		System.out.println();

		/*
		 * ListIterator<E> listIterator(int index) : Declared in the List interface.
		 * Returns an iterator to invoking list starting from the element at the
		 * specified index.
		 */

		// fruitList = [apple, grape, banana, orange, grape]
		ListIterator listIndexItr = fruitList.listIterator(2);

		while (listIndexItr.hasNext()) {
			System.out.print(listIndexItr.next() + " ");
		}

		System.out.println();

	}

}

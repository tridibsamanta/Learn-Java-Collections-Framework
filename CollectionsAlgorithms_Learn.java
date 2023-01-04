import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * The Collections Framework defines several algorithms that can be applied to collections 
 * and maps. These algorithms are defined as static methods within the 'Collections' class.
 */

class Compare implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		return (b - a);
	}

}

public class CollectionsAlgorithms_Learn {

	public static void main(String[] args) {

		ArrayList<Integer> demoList = new ArrayList<>();

		demoList.add(7);
		demoList.add(4);
		demoList.add(2);
		demoList.add(5);
		demoList.add(2);
		demoList.add(3);

		System.out.println("demoList = " + demoList);
		// demoList = [7, 4, 2, 5, 2, 3]

		/*
		 * void sort(List<T> list) : Sorts the elements of a list, which must implement
		 * the Comparable interface. The order is determined by the natural order of the
		 * elements type as implemented by its class's compareTo method. The method
		 * compareTo is declared in interface Comparable.
		 */

		// demoList = [7, 4, 2, 5, 2, 3]
		Collections.sort(demoList);

		System.out.println("demoList = " + demoList);
		// demoList = [2, 2, 3, 4, 5, 7]

		/*
		 * void sort(List<T> list, Comparator<T> comp) : Sorts the elements of a list as
		 * determined by the comparator.
		 */

		// demoList = [2, 2, 3, 4, 5, 7]
		Collections.sort(demoList, new Compare());

		System.out.println("demoList = " + demoList);
		// demoList = [7, 5, 4, 3, 2, 2]

		/*
		 * void reverse(List<T> list) : Reverses the object sequence in the list.
		 */

		// demoList = [7, 5, 4, 3, 2, 2]
		Collections.reverse(demoList);

		System.out.println("demoList = " + demoList);
		// demoList = [2, 2, 3, 4, 5, 7]

		/*
		 * Comparator<T> reverseOrder() : Returns a reverse comparator, which is a
		 * comparator that reverses the outcome of a comparison between two elements.
		 */

		// demoList = [2, 2, 3, 4, 5, 7]
		Collections.sort(demoList, Collections.reverseOrder());

		System.out.println("demoList = " + demoList);
		// demoList = [7, 5, 4, 3, 2, 2]

		/*
		 * void shuffle(List<T> list) : Reorders the list elements randomly.
		 */

		Collections.shuffle(demoList);

		System.out.println("demoList = " + demoList);
		// demoList = [2, 3, 2, 7, 4, 5] (output may vary as shuffling is random)

		Collections.sort(demoList);
		// demoList = [2, 2, 3, 4, 5, 7]

		/*
		 * void rotate(List<T> list, int n) : Rotates a list by n places to the right.
		 * To rotate left, use a negative value for n.
		 */

		// demoList = [2, 2, 3, 4, 5, 7]
		Collections.rotate(demoList, 4);

		System.out.println("demoList = " + demoList);
		// demoList = [3, 4, 5, 7, 2, 2]

		/*
		 * void swap(List<T> list, int idx1, int idx2) : Exchanges the elements in list
		 * at the indices idx1 and idx2.
		 */

		// demoList = [3, 4, 5, 7, 2, 2]
		Collections.swap(demoList, 4, 1);

		System.out.println("demoList = " + demoList);
		// demoList = [3, 2, 5, 7, 4, 2]

		/*
		 * boolean replaceAll(List<T> list, T oldValue, T newValue) : Replaces all
		 * occurrences of oldValue in the list with newValue. Returns true if even one
		 * occurrence of oldValue was replaced with newValue, else returns false.
		 */

		// demoList = [3, 2, 5, 7, 4, 2]
		Collections.replaceAll(demoList, 2, 1);

		System.out.println("demoList = " + demoList);
		// demoList = [3, 1, 5, 7, 4, 1]

		/*
		 * T min(Collection<T> c) : Returns the minimum element in the collection c as
		 * determined by natural ordering. The collection need not be pre-sorted.
		 */

		// demoList = [3, 1, 5, 7, 4, 1]
		int minElement = Collections.min(demoList);

		System.out.println("minElement = " + minElement);
		// minElement = 1

		/*
		 * T max(Collection<T> c) : Returns the maximum element in the collection c as
		 * determined by natural ordering. The collection need not be pre-sorted.
		 */

		// demoList = [3, 1, 5, 7, 4, 1]
		int maxElement = Collections.max(demoList);

		System.out.println("maxElement = " + maxElement);
		// minElement = 7

		/*
		 * int frequency(Collection<T> c, Object obj) : Returns the count of the number
		 * of occurrences of obj in the collection c.
		 */

		// demoList = [3, 1, 5, 7, 4, 1]
		int occurrenceCount = Collections.frequency(demoList, 1);

		System.out.println("occurrenceCount = " + occurrenceCount);
		// occurrenceCount = 2

		/*
		 * boolean disjoint(Collection<T> a, Collection<T> b) : Compares the elements in
		 * a to elements in b. Returns true if the two collections contain no common
		 * elements. Otherwise, returns false.
		 */

		ArrayList<String> fruitList1 = new ArrayList<>(Arrays.asList("orange", "banana", "mango"));
		ArrayList<String> fruitList2 = new ArrayList<>(Arrays.asList("pineapple", "grape"));

		boolean isDisjoint = Collections.disjoint(fruitList1, fruitList2);

		if (isDisjoint)
			System.out.println("Disjoint");
		else
			System.out.println("Non-Disjoint");

		/*
		 * void copy (List<T> a, List<T> b) : Copies the elements of list b to list a.
		 */

		// fruitList1 = [orange, banana, mango]
		// fruitList2 = [pineapple, grape]
		Collections.copy(fruitList1, fruitList2);

		System.out.println("fruitList1 = " + fruitList1);
		// fruitList1 = [pineapple, grape, mango]

		System.out.println("fruitList2 = " + fruitList2);
		// fruitList2 = [pineapple, grape]

		/*
		 * void fill(List<T> list, T obj) : Assigns obj to each element of list.
		 */

		// demoList = [3, 1, 5, 7, 4, 1]
		Collections.fill(demoList, 5);

		System.out.println("demoList = " + demoList);
		// demoList = [5, 5, 5, 5, 5, 5]

		/*
		 * int binarySearch(List<T> list, T value) : Searches for value in list. The
		 * list must be sorted in ascending order according to the natural ordering of
		 * its elements. If the list contains the search key, its index is returned. If
		 * not, the return value is (-(insertion point) - 1), where the insertion point
		 * is the point at which the value would be inserted into the List, or the index
		 * of the first element greater than the value or list.size() if all elements in
		 * the List are less than the specified value.
		 */

		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, 6, 9, 12, 17));

		// nums = [5, 6, 9, 12, 17]
		int foundIndex = Collections.binarySearch(nums, 12);

		System.out.println("foundIndex = " + foundIndex);
		// foundIndex = 3

		// nums = [5, 6, 9, 12, 17]
		foundIndex = Collections.binarySearch(nums, 15);

		System.out.println("foundIndex = " + foundIndex);
		// foundIndex = -5

		nums.add(-foundIndex - 1, 15); // insert missing element at the appropriate position

		System.out.println("nums = " + nums);
		// nums = [5, 6, 9, 12, 15, 17]

	}

}

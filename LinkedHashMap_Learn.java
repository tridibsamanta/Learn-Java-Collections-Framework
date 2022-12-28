import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

/*
 * A map stores key-value pairs. Both key and values are objects. 
 * Using a key you can find its value. Keys must be unique, but
 * the values may contain duplicates.
 */

public class LinkedHashMap_Learn {

	public static void main(String[] args) {

		/*
		 * The 'Map' interface maps unique keys to values. A key is an object that can
		 * be used to retrieve its corresponding value. The 'AbstractMap' class
		 * implements most of the 'Map' interface and serves as a superclass for all
		 * concrete map implementations.
		 * 
		 * The 'LinkedHashMap' class extends the 'HashMap' class. It maintains a linked
		 * list of the entries in the map, in the order in which they were inserted.
		 * This allows insertion-order iteration over the map, i.e. the order in which
		 * elements are added to a hash map is the order in which they are accessed by
		 * an iterator.
		 */

		Map<Integer, String> studentMap = new LinkedHashMap<>();

		/*
		 * Adding elements to LinkedHashMap
		 * 
		 * V put(K k, V v) : Declared in the 'Map' interface. Puts an entry in the
		 * invoking map, overwriting any previous value associated with the key. 'k' is
		 * the key and 'v' is the value. Returns null if the key did not already exist.
		 * Otherwise, the previous value linked to the key is returned.
		 * 
		 * void putAll(Map m) : Declared in the 'Map' interface. Puts all the entries
		 * from m into the map.
		 * 
		 * V putIfAbsent(K k, V v) : Declared in the 'Map' interface. Inserts the
		 * key-value pair into the invoking map if this entry is not already present or
		 * if the existing value for key k is null. Returns the old value or null value
		 * if key k was not already present in the map.
		 */

		studentMap.put(1, "Naman");
		studentMap.put(2, "Vivek");
		studentMap.put(3, "Payal");

		System.out.println("studentMap = " + studentMap);
		// studentMap = {1=Naman, 2=Vivek, 3=Payal}

		Map<Integer, String> newStudents = new LinkedHashMap<>();

		newStudents.put(4, "Neha");
		newStudents.put(5, "Anupam");

		studentMap.putAll(newStudents);

		System.out.println("studentMap = " + studentMap);
		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 4=Neha, 5=Anupam}

		String existingStudent = studentMap.putIfAbsent(5, "Rohan");

		System.out.println("existingStudent = " + existingStudent);
		// existingStudent = Anupam

		existingStudent = studentMap.putIfAbsent(6, "Sumit");
		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 4=Neha, 5=Anupam, 6=Sumit}

		System.out.println("existingStudent = " + existingStudent);
		// existingStudent = null

		/*
		 * Removing elements from LinkedHashMap
		 * 
		 * V remove(K k) : Declared in the 'Map' interface. Removes the entry whose key
		 * equals k.
		 * 
		 * boolean remove(K k, V v) : Declared in the 'Map' interface. Removes that
		 * entry from the invoking map if key equals k and value equals v and returns
		 * true. Otherwise false is returned.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 4=Neha, 5=Anupam, 6=Sumit}
		studentMap.remove(4);
		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam, 6=Sumit}

		studentMap.remove(6, "Sumit");
		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam}

		/*
		 * Get values from LinkedHashMap
		 * 
		 * V get(K k) : Declared in the 'Map' interface. Returns the value associated
		 * with key k. Returns null if the key is not found.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam}
		String studentName = studentMap.get(2);

		System.out.println("studentName = " + studentName);
		// studentName = Vivek

		studentName = studentMap.get(4);

		System.out.println("studentName = " + studentName);
		// studentName = null

		/*
		 * Check if LinkedHashMap contains a key / value
		 * 
		 * boolean containsKey(K k) : Declared in the 'Map' interface. Returns true if
		 * key k is present in the invoking map. Otherwise, returns false.
		 * 
		 * boolean containsValue(V v) : Declared in the 'Map' interface. Returns true if
		 * value v is present in the invoking map. Otherwise, returns false.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam}

		if (studentMap.containsKey(3))
			System.out.println("Key found");
		else
			System.out.println("Key not found");

		if (studentMap.containsValue("Pankaj"))
			System.out.println("Value found");
		else
			System.out.println("Value not found");

		/*
		 * Replace key / value in LinkedHashMap
		 * 
		 * boolean replace(K k, V oldV, V newV) : Declared in the 'Map' interface. If
		 * key-value pair specified by k and oldV is present in the invoking map, the
		 * value is replaced by newV and true is returned. Otherwise false is returned.
		 * 
		 * V replace(K k, V v) : Declared in the 'Map' interface. If key k is present in
		 * the invoking map, its corresponding value is set to v and previous value is
		 * returned. Otherwise null is returned.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Payal, 5=Anupam}

		studentMap.replace(3, "Payal", "Sejal");
		// studentMap = {1=Naman, 2=Vivek, 3=Sejal, 5=Anupam}

		String oldName = studentMap.replace(3, "Ronit");

		System.out.println("oldName = " + oldName); // oldName = Sejal

		System.out.println("studentMap = " + studentMap);
		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}

		/*
		 * Get the count of key-value pairs in the LinkedHashMap
		 * 
		 * int size() : Declared in the 'Map' interface. Returns the number of key-value
		 * pairs in the map.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		int mapSize = studentMap.size();

		System.out.println("mapSize = " + mapSize); // mapSize = 4

		/*
		 * Check if LinkedHashMap is empty or not
		 * 
		 * boolean isEmpty() : Declared in the 'Map' interface. Returns true if the
		 * invoking map is empty. Otherwise, returns false.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		if (studentMap.isEmpty())
			System.out.println("Map is empty");
		else
			System.out.println("Map is not empty");

		/*
		 * Iterating over LinkedHashMap entries
		 * 
		 * Set<Map.Entry<K, V>> entrySet() : Declared in the 'Map' interface. Returns a
		 * Set that contains the entries in the map. The set contains objects of type
		 * Map.Entry, i.e. this method provides a set-view of the invoking map.
		 */

		Set<Map.Entry<Integer, String>> mapSet = studentMap.entrySet();

		for (Map.Entry<Integer, String> kv : mapSet) {
			System.out.print(kv.getKey() + " -> " + kv.getValue() + " ");
		}
		// 1 -> Naman 2 -> Vivek 3 -> Ronit 5 -> Anupam

		System.out.println();

		for (Map.Entry kv : studentMap.entrySet()) {
			System.out.print(kv.getKey() + " -> " + kv.getValue() + " ");
		}
		// 1 -> Naman 2 -> Vivek 3 -> Ronit 5 -> Anupam

		System.out.println();

		/*
		 * Remove all key-value pair from the LinkedHashMap
		 * 
		 * void clear() : Declared in the 'Map' interface. Removes all key-value pairs
		 * from the invoking map.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		studentMap.clear();
		// studentMap = {}

		System.out.println("studentMap = " + studentMap);

	}

}

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * A map stores key-value pairs. Both key and values are objects. 
 * Using a key you can find its value. Keys must be unique, but
 * the values may contain duplicates.
 */

public class TreeMap_Learn {

	public static void main(String[] args) {

		/*
		 * The 'Map' interface maps unique keys to values. A key is an object that can
		 * be used to retrieve its corresponding value. The 'AbstractMap' class
		 * implements most of the 'Map' interface and serves as a superclass for all
		 * concrete map implementations.
		 * 
		 * The 'SortedMap' interface extends 'Map' interface and ensures that the map
		 * entries are sorted in ascending order based on the keys.
		 * 
		 * The 'NavigableMap' interface extends 'SortedMap' interface and declares the
		 * behavior of a map that supports the retrieval of entries based on the closest
		 * match to a given key or keys.
		 * 
		 * The 'TreeMap' class extends the 'AbstractMap' class and implements the
		 * 'NavigableMap' interface. A TreeMap stores key-value pairs sorted in
		 * ascending order of keys allowing us to retrieve entries efficiently.
		 */

		TreeMap<Integer, String> studentMap = new TreeMap<>();

		/*
		 * Adding elements to TreeMap
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

		studentMap.put(2, "Vivek");
		studentMap.put(1, "Naman");
		studentMap.put(3, "Payal");

		System.out.println("studentMap = " + studentMap);
		// studentMap = {1=Naman, 2=Vivek, 3=Payal}

		Map<Integer, String> newStudents = new TreeMap<>();

		newStudents.put(5, "Anupam");
		newStudents.put(4, "Neha");

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
		 * Removing elements from TreeMap
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
		 * Get values from TreeMap
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
		 * Check if TreeMap contains a key / value
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
		 * Replace key / value in TreeMap
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
		 * Get the count of key-value pairs in the TreeMap
		 * 
		 * int size() : Declared in the 'Map' interface. Returns the number of key-value
		 * pairs in the map.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		int mapSize = studentMap.size();

		System.out.println("mapSize = " + mapSize); // mapSize = 4

		/*
		 * Check if TreeMap is empty or not
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
		 * Iterating over TreeMap entries
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
		 * Remove all key-value pair from the TreeMap
		 * 
		 * void clear() : Declared in the 'Map' interface. Removes all key-value pairs
		 * from the invoking map.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}

		TreeMap<Integer, String> studentDemo = new TreeMap<>(studentMap);

		System.out.println("studentDemo = " + studentDemo);
		// studentDemo = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}

		studentDemo.clear();
		// studentDemo = {}

		System.out.println("studentDemo = " + studentDemo);

		/*
		 * Methods from the 'SortedMap' interface
		 */

		/*
		 * K firstKey() : Declared in the 'SortedMap' interface. Returns the first key
		 * in the invoking map.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		Integer firstKey = studentMap.firstKey();

		System.out.println("firstKey = " + firstKey); // firstKey = 1

		/*
		 * K lastKey() : Declared in the 'SortedMap' interface. Returns the last key in
		 * the invoking map.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		int lastKey = studentMap.lastKey();

		System.out.println("lastKey = " + lastKey); // lastKey = 5

		/*
		 * Methods from the 'NavigableMap' interface
		 */

		/*
		 * K ceilingKey(K obj) : Declared in the 'NavigableMap' interface. Searches the
		 * map for the smallest key k such that k >= obj. Returns the key k if found,
		 * else returns null.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		int ceilingKey = studentMap.ceilingKey(4);
		System.out.println("ceilingKey = " + ceilingKey); // ceilingKey = 5

		ceilingKey = studentMap.ceilingKey(3);
		System.out.println("ceilingKey = " + ceilingKey); // ceilingKey = 3

		/*
		 * K floorKey(K obj) : Declared in the 'NavigableMap' interface. Searches the
		 * map for the largest key k such that k <= obj. Returns the key k if found,
		 * else returns null.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		int floorKey = studentMap.floorKey(4);
		System.out.println("floorKey = " + floorKey); // floorKey = 3

		floorKey = studentMap.floorKey(2);
		System.out.println("floorKey = " + floorKey); // floorKey = 2

		/*
		 * K higherKey(K obj) : Declared in the 'NavigableMap' interface. Searches the
		 * map for the smallest key k such that k > obj. Returns the key k if found,
		 * else returns null.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		int higherKey = studentMap.higherKey(2);
		System.out.println("higherKey = " + higherKey); // higherKey = 3

		/*
		 * K lowerKey(K obj) : Declared in the 'NavigableMap' interface. Searches the
		 * map for the largest key k such that k < obj. Returns the key k if found, else
		 * returns null.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		int lowerKey = studentMap.lowerKey(3);
		System.out.println("lowerKey = " + lowerKey); // lowerKey = 2

		/*
		 * Map.Entry<K, V> ceilingEntry(K obj) : Declared in the 'NavigableMap'
		 * interface. Searches the map for the smallest key k such that k >= obj.
		 * Returns the key-value entry if found, else returns null.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		Map.Entry<Integer, String> kv = studentMap.ceilingEntry(3);

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 3=Ronit

		kv = studentMap.ceilingEntry(4);

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 5=Anupam

		/*
		 * Map.Entry<K, V> floorEntry(K obj) : Declared in the 'NavigableMap' interface.
		 * Searches the map for the largest key k such that k <= obj. Returns the
		 * key-value entry if found, else returns null.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		kv = studentMap.floorEntry(2);

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 2=Vivek

		kv = studentMap.floorEntry(4);

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 3=Ronit

		/*
		 * Map.Entry<K, V> higherEntry(K obj) : Declared in the 'NavigableMap'
		 * interface. Searches the map for the smallest key k such that k > obj. Returns
		 * the key-value entry if found, else returns null.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		kv = studentMap.higherEntry(3);

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 5=Anupam

		/*
		 * Map.Entry<K, V> lowerEntry(K obj) : Declared in the 'NavigableMap' interface.
		 * Searches the map for the largest key k such that k < obj. Returns the
		 * key-value entry if found, else returns null.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		kv = studentMap.lowerEntry(5);

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 3=Ronit

		/*
		 * Map.Entry<K, V> firstEntry(K obj) : Declared in the 'NavigableMap' interface.
		 * Returns the first key-value entry if present, i.e. the entry having the
		 * smallest key.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		kv = studentMap.firstEntry();

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 1=Naman

		/*
		 * Map.Entry<K, V> lastEntry(K obj) : Declared in the 'NavigableMap' interface.
		 * Returns the last key-value entry if present, i.e. the entry having the
		 * largest key.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		kv = studentMap.lastEntry();

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 5=Anupam

		/*
		 * Map.Entry<K, V> pollFirstEntry() : Declared in the 'NavigableMap' interface.
		 * Returns the first entry, removing the entry in the process. Returns null if
		 * map is already empty.
		 */

		// studentMap = {1=Naman, 2=Vivek, 3=Ronit, 5=Anupam}
		kv = studentMap.pollFirstEntry();
		// studentMap = {2=Vivek, 3=Ronit, 5=Anupam}

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 1=Naman

		System.out.println("studentMap = " + studentMap);
		// studentMap = {2=Vivek, 3=Ronit, 5=Anupam}

		/*
		 * Map.Entry<K, V> pollLastEntry() : Declared in the 'NavigableMap' interface.
		 * Returns the last entry, removing the entry in the process. Returns null if
		 * map is already empty.
		 */

		// studentMap = {2=Vivek, 3=Ronit, 5=Anupam}
		kv = studentMap.pollLastEntry();
		// studentMap = {2=Vivek, 3=Ronit}

		System.out.println(kv.getKey() + "=" + kv.getValue()); // 5=Anupam

		System.out.println("studentMap = " + studentMap);
		// studentMap ={2=Vivek, 3=Ronit}

		TreeMap<Integer, String> priceMap = new TreeMap<>();

		priceMap.put(10, "Water");
		priceMap.put(15, "Tea");
		priceMap.put(25, "Cookies");
		priceMap.put(30, "Cake");
		priceMap.put(50, "Burger");
		priceMap.put(60, "Sandwich");
		priceMap.put(75, "Soup");
		priceMap.put(100, "Pizza");

		System.out.println("priceMap = " + priceMap);
		// priceMap = {10=Water, 15=Tea, 25=Cookies, 30=Cake, 50=Burger, 60=Sandwich,
		// 75=Soup, 100=Pizza}

		/*
		 * NavigableMap<K, V> headMap(K upperbound, boolean incl) : Declared in the
		 * 'NavigableMap' interface. Returns a NavigableMap that includes all entries
		 * from the invoking map that have keys that are less than upperbound. If incl
		 * is true, then an entry having key equal to upperbound is included.
		 */

		TreeMap<Integer, String> itemMap = new TreeMap<>(priceMap.headMap(50, true));

		System.out.println("itemMap = " + itemMap);
		// itemMap = {10=Water, 15=Tea, 25=Cookies, 30=Cake, 50=Burger}

		itemMap = new TreeMap<>(priceMap.headMap(50, false));

		System.out.println("itemMap = " + itemMap);
		// itemMap = {10=Water, 15=Tea, 25=Cookies, 30=Cake}

		/*
		 * NavigableMap<K, V> tailMap(K lowerbound, boolean incl) : Declared in the
		 * 'NavigableMap' interface. Returns a NavigableMap that includes all entries
		 * from the invoking map that have keys that are greater than lowerbound. If
		 * incl is true, then an entry having key equal to lowerbound is included.
		 */

		itemMap = new TreeMap<>(priceMap.tailMap(60, true));

		System.out.println("itemMap = " + itemMap);
		// itemMap = {60=Sandwich, 75=Soup, 100=Pizza}

		itemMap = new TreeMap<>(priceMap.tailMap(60, false));

		System.out.println("itemMap = " + itemMap);
		// itemMap = {75=Soup, 100=Pizza}

		/*
		 * NavigableMap<K, V> subMap(K lowerbound, boolean lowincl, K upperbound,
		 * boolean upperincl) : Declared in the 'NavigableMap' interface. Returns a
		 * NavigableMap that includes all entries from the invoking map that have keys
		 * that are greater than lowerbound and less than upperbound. If lowincl is
		 * true, then an entry having key equal to lowerbound is included. If upperincl
		 * is true, then an entry having key equal to upperbound is included.
		 */

		itemMap = new TreeMap<>(priceMap.subMap(25, false, 75, true));

		System.out.println("itemMap = " + itemMap);
		// itemMap = {30=Cake, 50=Burger, 60=Sandwich, 75=Soup}

		/*
		 * NavigableSet<K> navigableKeySet() : Declared in the 'NavigableMap' interface.
		 * Returns a NavigableSet that contains all the keys in the invoking map.
		 */

		// itemMap = {30=Cake, 50=Burger, 60=Sandwich, 75=Soup}
		TreeSet<Integer> priceSet = new TreeSet<>(itemMap.navigableKeySet());

		System.out.println("priceSet = " + priceSet);
		// priceSet = [30, 50, 60, 75]

		/*
		 * NavigableSet<K> descendingKeySet() : Declared in the 'NavigableMap'
		 * interface. Returns a NavigableSet that contains all the keys in the invoking
		 * map in reverse order.
		 */

		// itemMap = {30=Cake, 50=Burger, 60=Sandwich, 75=Soup}
		TreeSet<Integer> descPriceSet = new TreeSet<>(itemMap.descendingKeySet());

		System.out.println("descPriceSet = " + descPriceSet);
		// descPriceSet = [75, 60, 50, 30]

		/*
		 * NavigableMap<K, V> descendingMap() : Declared in the 'NavigableMap'
		 * interface. Returns a NavigableMap that includes all entries from the invoking
		 * map in reverse order.
		 */

		// itemMap = {30=Cake, 50=Burger, 60=Sandwich, 75=Soup}
		TreeMap<Integer, String> reverseItemMap = new TreeMap<>(itemMap.descendingMap());

		System.out.println("reverseItemMap = " + reverseItemMap);
		// reverseItemMap = {75=Soup, 60=Sandwich, 50=Burger, 30=Cake}

	}

}

package base;

import java.util.*;

/**
 * 此类是：集合
 *
 * @author hpc
 * @date 2016年12月9日 下午1:37:20
 */
public class Collections {

	public static void main(String[] args) {
		priorityQueue();
	}

	/**
	 * HashSet和TreeSet
	 * 	HashSet:无序的 底层是hashMap
	 * 	TreeSet:是有序的，需要提供比较器 底层是treeMap
	 */
	public static void set(){
		Set<String> set = new HashSet<String>();
		set.add("1");
	}

	/**
	 * 优先级队列PriorityQueue
	 * 	不允许传入空值NullPointerException，默认长度容量是11
	 */
	public static void priorityQueue() {
		PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
		priorityQueue.add(null);
	}

	/**
	 * List和arrayList的容量问题 List集合是固定的大小 ArrayList是自动扩展的 (oldCapacity * 3)/2 + 1
	 * 默认长度是10
	 */
	public static void list() {
		List<String> list = new ArrayList<String>(2);
		list.add("1");
		list.add("2");
		list.add("3");
		list.add(null);
	}

	/**
	 * Map的容量是自动扩展的为Entry[] table长度*2 HashMap可以存空key，但是只能存一个空value，下标为0的位置里
	 * HashTable 不允许存放空key和空value HashMap默认长度16
	 */
	public static void map() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(null, null);
		map.put(null, "null2");
		map.put("11", "11");
		System.err.println(map.get(0));
		Map<String, String> mapTable = new Hashtable<String, String>();
		mapTable.put("1", null);
	}

	/**
	 * Iterator迭代器
	 */
	private static void listIterator() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		Iterator<String> iterator = list.iterator();
		iterator.next();
		iterator.remove();
		iterator.hasNext();
		ListIterator<String> listIterator = list.listIterator();
		listIterator.next();
		listIterator.remove();
		listIterator.hasNext();
		//listIterator.previous();
	}

}

class MyComparator implements Comparator<String> {
	public int compare(String o1, String o2) {
		return o1.hashCode() > o2.hashCode() ? 1 : 0;
	}

}


// Name: 
// Date:     
import java.util.*;

public class CollectionsSpeed {
	public static final int N = 10000;

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		makeValues(al, ll);

		System.out.println("get each for ArrayList = " + timeGetEach(al));
		System.out.println("get each for LinkedList = " + timeGetEach(ll));
		System.out.println("\nadd at 0 for ArrayList = " + timeAddFirst(al));
		System.out.println("add at 0 for LinkedList = " + timeAddFirst(ll));
		System.out.println("\nadd at list.size() for ArrayList = " + timeAddLast(al));
		System.out.println("add at list.size() for LinkedList = " + timeAddLast(ll));
		System.out.println("addLast for LinkedList = " + timeAddLastLL(ll));
	}

	public static void makeValues(ArrayList<Integer> al, LinkedList<Integer> ll) {
		for (int i = 0; i < N; i++) {
			al.add(i); // "autoboxing" converts int to Integer;
			ll.add(i); // introduced in Java 1.5
		}
	}

	/* get N items by searching for each one. */
	public static double timeGetEach(List<Integer> list) {
		double start = System.nanoTime();
		for (int i = 0; i < N; i++) {
			int index = list.get(i);
		}
		return (System.nanoTime() - start) / 1E6;
	}

	/* add 10000 new objects at position 0 */
	public static double timeAddFirst(List<Integer> list) {
		double start = System.nanoTime();
		for (int i = 0; i++ < N; list.add(0, null));
		return (System.nanoTime() - start) / 1E6;
	}

	/* add 10000 new objects at position list.size() */
	public static double timeAddLast(List<Integer> list) {
		double start = System.nanoTime();
		for (int i = 0; i++ < N; list.add(null));
		return (System.nanoTime() - start) / 1E6;
	}

	/*
	 * add 10000 new objects at the end.
	 * Uses the LinkedList method addLast().
	 * You must cast List list into a LinkedList.
	 */
	public static double timeAddLastLL(List<Integer> list) {
		LinkedList l = (LinkedList) list;
		double start = System.nanoTime();
		for (int i = 0; i++ < N; l.addLast(null));
		return (System.nanoTime() - start) / 1E6;
	}
}

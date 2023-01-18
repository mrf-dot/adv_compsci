// name:     date:  

import java.util.*;
import java.io.*;

public class Josephus {
	private static String WINNER = "Josephus";

	public static void main(String[] args) throws FileNotFoundException {
		/* Josephus Part I, insert() and print() */
		ListNode last = null;
		// set a breakpoint here and see if the circle is correctly made
		last = insert(last, "B");
		last = insert(last, "C");
		last = insert(last, "D");
		last = insert(last, "E");
		last = insert(last, "F");
		print(last);

		/* Josephus Part II */
		/* run numberCircle first with J_numbers.txt */
		Scanner sc = new Scanner(System.in);
		System.out.print("How many names (2-20)? ");
		int n = Integer.parseInt(sc.next());
		System.out.print("How many names to count off each time? ");
		int countOff = Integer.parseInt(sc.next());
		ListNode winningPos = numberCircle(n, countOff, "J_numbers.txt");
		System.out.println(winningPos.getValue() + " wins!");

		/* run josephusCircle next with J_names.txt */
		System.out.println("\n ****  Now start all over. **** \n");
		System.out.print("Where should " + WINNER + " stand?  ");
		int winPos = Integer.parseInt(sc.next());
		ListNode theWinner = josephusCircle(n, countOff, "J_names.txt", winPos);
		System.out.println(theWinner.getValue() + " wins!");
	}

	public static ListNode numberCircle(int n, int countOff, String filename) throws FileNotFoundException {
		ListNode p = null;
		p = readNLinesOfFile(n, new File(filename));
		p = countingOff(p, countOff, n);
		return p;
	}

	public static ListNode josephusCircle(int n, int countOff, String filename, int winPos)
			throws FileNotFoundException {
		ListNode p = null;
		p = readNLinesOfFile(n, new File(filename));
		replaceAt(p, WINNER, winPos);
		p = countingOff(p, countOff, n);
		return p;
	}

	/*
	 * reads the names, calls insert(), builds the linked list.
	 */
	public static ListNode readNLinesOfFile(int n, File f) throws FileNotFoundException {
		// instantiate a Scanner object with parameter f
		// set a counter to 0
		// declare a ListNode variable as null

		// while loop condition: check that your counter is smaller than n and
		// that the Scanner reference variable has more in the file
		// call your insert method and pass it the ListNode variable and
		// a call to the Scanner variable's .next() method and
		// assign the returned value to your ListNode variable
		// increment your counter
		// Have your Scanner variable call .close()
		// return your ListNode object
		Scanner s = new Scanner(f);
		int cnt = 0;
		ListNode ln = null;
		while (cnt < n && s.hasNext()) {
			ln = insert(ln, s.next());
			cnt++;
		}
		s.close();
		return ln;

	}

	/*
	 * helper method to build the list. Creates the node, then
	 * inserts it in the circular linked list.
	 */
	private static ListNode insert(ListNode p, Object obj) {
		// instantiate a temp ListNode object with a value of obj
		// and a pointer to null

		// check if the parameter p is null
		// if it is, setNext for the temp ListNode object to temp
		// otherwise
		// setNext for the temp ListNode object to p.getNext()
		// setNext for p to temp
		// return the temp ListNode object
		ListNode tmp = new ListNode(obj, null);
		if (p == null) {
			tmp.setNext(tmp);
		} else {
			tmp.setNext(p.getNext());
			p.setNext(tmp);
		}
		return tmp;
	}

	/*
	 * Runs a Josephus game, counting off and removing each name. Prints after each
	 * removal.
	 * Ends with one remaining name, who is the winner.
	 */
	public static ListNode countingOff(ListNode p, int count, int n) {
		// call the print method
		// loop n - 1 times
		// call remove and pass it p and count, then assign the return value to p
		// call print again
		// return p's next reference
		print(p);
		for (int i = 0; i < n - 1; i++) {
			p = remove(p, count);
			print(p);
		}
		return p.getNext();
	}

	/*
	 * removes the node after counting off count-1 nodes.
	 */
	private static ListNode remove(ListNode p, int count) {
		// loop count - 1 times
		// call p.getNext() and assign it to p

		// update p's next reference to skip over the next node
		// return p
		for (int i = 0; i < count - 1; i++) {
			p = p.getNext();
			p.setNext(p.getNext().getNext());
		}
		return p;
	}

	/*
	 * prints the circular linked list.
	 */
	public static void print(ListNode p) {
		ListNode tmp = p.getNext();
		do {
			System.out.print(tmp.getValue() + " ");
			tmp = tmp.getNext();
		} while (tmp != p.getNext());
		System.out.println();
	}

	/*
	 * replaces the value (the string) at the winning node.
	 */
	public static void replaceAt(ListNode p, Object obj, int pos) {
		for (int i = 0; i++ < pos; p = p.getNext())
			;
		p.setValue(obj);
	}
}

/************************************************
 * 
 * B C D E F
 * How many names (2-20)? 5
 * How many names to count off each time? 2
 * 1 2 3 4 5
 * 3 4 5 1
 * 5 1 3
 * 3 5
 * 3
 * 3 wins!
 **** 
 * Now start all over. ****
 * 
 * Where should Josephus stand? 3
 * Michael Hannah Josephus Ruth Matthew
 * Josephus Ruth Matthew Michael
 * Matthew Michael Josephus
 * Josephus Matthew
 * Josephus
 * Josephus wins!
 * 
 * ----jGRASP: operation complete.
 * 
 **************************************************/

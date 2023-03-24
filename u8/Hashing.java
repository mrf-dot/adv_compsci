
//name:    date:
/*  Assignment:  This hashing program results in collisions.
    You are to implement three different collision schemes: linear 
    probing, rehashing, and chaining.  Then implement a search 
    algorithm that is appropriate for each collision scheme.
*/
import java.util.*;
import javax.swing.*;
import java.util.Scanner;

public class Hashing {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hashing!\n" +
				"Enter the size of the array:  ");
		int arrayLength = input.nextInt();

		System.out.println("Add n items:  ");
		int numItems = input.nextInt();

		System.out.println("The Load Factor is " + (double) numItems / arrayLength +
				"\nWhich collision scheme?\n" +
				"1. Linear Probing\n" +
				"2. Rehashing\n" +
				"3. Chaining");
		int scheme = input.nextInt();

		Hashtable table = null;
		switch (scheme) {
			case 1:
				table = new HashtableLinearProbe(arrayLength);
				break;
			case 2:
				table = new HashtableRehash(arrayLength);
				break;
			case 3:
				table = new HashtableChaining(arrayLength);
				break;
			default:
				System.exit(0);
		}
		for (int i = 0; i < numItems; i++)
			table.add("Item" + i);
		System.out.println("Search for:  Item0" + " to " + "Item" + (numItems - 1));
		int itemNumber = input.nextInt();

		while (itemNumber != -1) {
			String key = "Item" + itemNumber;
			int index = table.indexOf(key);
			if (index >= 0) // found it
				System.out.println(key + " found  at index " + index);
			else
				System.out.println(key + " not found!");
			System.out.println("Search for:  Item0" + " to " + "Item" + (numItems - 1));
			itemNumber = input.nextInt();
		}
		System.exit(0);
	}
}

/*********************************************/
interface Hashtable {
	void add(Object obj);

	int indexOf(Object obj);
}

/***************************************************/
class HashtableLinearProbe implements Hashtable {
	private Object[] array;

	public HashtableLinearProbe(int size) {
		array = new Object[size];
		// constructor
	}

	public void add(Object obj) {
		int code = obj.hashCode();
		int index = Math.abs(code % array.length);
		if (array[index] == null) // empty
		{
			array[index] = obj;
			// insert it
			System.out.println(obj + "\t" + code + "\t" + index);
		} else // collision
		{

			while (array[index] != null) {
				System.out.println(obj + "\t" + code + "\tCollision at " + index);
				index = linearProbe(index);
			}

			array[index] = obj;
			System.out.println(obj + "\t" + code + "\t" + index);
		}
	}

	public int linearProbe(int index) {
		// be sure to wrap around the array.

		return (index + 1) % array.length;
	}

	public int indexOf(Object obj) {
		int index = Math.abs(obj.hashCode() % array.length);
		while (array[index] != null) {
			if (array[index].equals(obj)) // found it
			{
				return index;
			} else // search for it in a linear probe manner
			{
				index = linearProbe(index);
			}
		}
		// not found
		return -1;
	}
}

/*****************************************************/
class HashtableRehash implements Hashtable {
	private Object[] array;
	private int constant = 2;

	public HashtableRehash(int size) {
		// constructor
		// find a constant that is relatively prime to the size of the array
		array = new Object[size];
		constant = size % 2 == 0 ? size + 1 : size + 2;
	}

	public void add(Object obj) {
		int code = obj.hashCode();
		int index = Math.abs(code % array.length);
		if (array[index] == null) // empty
		{
			// insert it
			array[index] = obj;
			System.out.println(obj + "\t" + code + "\t" + index);
		} else // collision
		{
			System.out.println(obj + "\t" + code + "\tCollision at " + index);
			index = rehash(index);
			array[index] = obj;
			System.out.println(obj + "\t" + code + "\t" + index);
		}
	}

	public int rehash(int index) {
		while (array[index] != null) {
			index = (index + constant) % array.length;
		}
		return index;
	}

	public int indexOf(Object obj) {
		int index = Math.abs(obj.hashCode() % array.length);
		while (array[index] != null) {
			if (array[index].equals(obj)) // found it
			{
				return index;
			} else // search for it in a rehashing manner
			{
				index = (index + constant) % array.length;
				System.out.println("Looking at index " + index);
			}
		}
		// not found
		return -1;
	}
}

/********************************************************/
class HashtableChaining implements Hashtable {
	private LinkedList[] array;

	public HashtableChaining(int size) {
		// instantiate the array
		// instantiate the LinkedLists

		array = new LinkedList[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = new LinkedList<Object>();
		}
	}

	public void add(Object obj) {
		int code = obj.hashCode();
		int index = Math.abs(code % array.length);
		array[index].addFirst(obj);
		System.out.println(obj + "\t" + code + " " + " at " + index + ": " + array[index]);
	}

	public int indexOf(Object obj) {
		int index = Math.abs(obj.hashCode() % array.length);
		if (!array[index].isEmpty()) {
			if (array[index].getFirst().equals(obj)) // found it
			{
				return 0;
			} else // search for it in a chaining manner
			{
				for (int i = 0; i < array[index].size(); i++)
					if (array[index].get(i).equals(obj))
						return index;
			}
		}
		// not found
		return -1;
	}
}
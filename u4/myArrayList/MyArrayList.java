// Mitch Feigenbaum, 11/16/2022
// create your own version of the ArrayList by completing this class definition
// look in ListInterface to see what methods you need to create

public class MyArrayList<anyType> implements ListInterface<anyType> {
	private Object[] list;
	private int numElements;

	// intializes class
	public MyArrayList() {
		list = new Object[10];
		numElements = 0;
	}

	// appends element to the list
	public boolean add(anyType x) {
		return add(numElements, x);
	}

	// inserts element into the list
	public boolean add(int index, anyType x) {
		if (++numElements == list.length)
			doubleCapacity();
		for (int i = numElements - 1; i > index; list[i] = list[--i]);
		list[index] = x;
		return true;
	}

	// returns the size of the list
	public int size() {
		return numElements;
	}

	// changes the value of an index in the list
	public anyType set(int index, anyType x) {
		anyType tmp = (anyType) list[index];
		list[index] = x;
		return tmp;
	}

	// returns the value of an index in the list
	public anyType get(int index) {
		return (anyType) list[index];
	}

	// removes an element from the list and shifts the elements to the right
	public anyType remove(int index) {
		anyType tmp = (anyType) list[index];
		if (--numElements < list.length / 3)
			cutCapacity();
		for (int i = index; i < numElements; list[i] = list[++i]);
		return tmp;
	}

	// make list twice as big, i.e. given [A, B, C, null], results with [A,
	// B, C, null, null, null, null, null] to be used if we add an element
	// that would be over the capacity of list private because this is a
	// helper method that need not be used outside of the class
	private void doubleCapacity() {
		Object[] tmp = new Object[list.length * 2];
		for (int i = 0; i < numElements; tmp[i] = list[i++]);
		list = tmp;
	}

	// private because this is a helper method that need not be used outside of the
	// class make list half as big, i.e. given [A, B, C, null, null, null, null,
	// null], results with [A, B, C, null] to be used if after removing an element,
	// we have less than 1/3 of the capacity of list being used
	private void cutCapacity() {
		Object[] tmp = new Object[list.length / 2];
		for (int i = 0; i < numElements; tmp[i] = list[i++]);
		list = tmp;
	}

	public String toString() {
		String ans = "[";
		// add all array elements with a comma separating each, i.e. [A, B, C]
		if (numElements != 0) {
			for (int i = 0; i < numElements - 1; ans += "" + list[i++] + ", ");
			ans += "" + list[numElements - 1];
		} else {
			ans += " ";
		}
		return ans + "]";
	}

}

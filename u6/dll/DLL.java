// Name:
// Date:

//  implements some of the List and LinkedList interfaces: 
//	 	  size(), add(i, o), remove(i);  addFirst(o), addLast(o); 
//  This class also overrides toString().
//  the list is zero-indexed.
//  Uses DLNode.

public class DLL // DoubleLinkedList
{
	private int size;
	private DLNode head = new DLNode(); // dummy node--very useful--simplifies the code

	public int size() {
		/* enter your code */
		return size;
	}

	/*
	 * appends obj to end of list; increases size;
	 * 
	 * @return true
	 */
	public boolean add(Object obj) {
		addLast(obj);
		return true;
	}

	/* inserts obj at position index. increments size. */
	public void add(int index, Object obj) throws IndexOutOfBoundsException // this the way the real LinkedList is
										// coded
	{
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		/* enter your code below */
		if (index == 0) {
			addFirst(obj);
			return;
		}
		if (index == size - 1) {
			addLast(obj);
			return;
		}
		DLNode tmp = new DLNode(), ind = head;
		tmp.setValue(obj);
		for (int i = 0; i++ < index; ind = ind.getNext());
		tmp.setNext(ind);
		tmp.setPrev(ind.getPrev());
		ind.getPrev().setNext(tmp);
		ind.setPrev(tmp);
		++size;
			

	}

	/* return obj at position index. */
	public Object get(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		/* enter your code below */
		DLNode tmp = head;
		for (int i = 0; i++ < index; tmp = tmp.getNext());
		return tmp.getValue();
	}

	/*
	 * replaces obj at position index.
	 * returns the obj that was replaced
	 */
	public Object set(int index, Object obj) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		/* enter your code below */
		DLNode tmp = head;
		for (int i = 0; i++ < index; tmp = tmp.getNext());
		Object tobj = tmp.getValue();
		tmp.setValue(obj);	
		return tobj;
	}

	/*
	 * removes the node from position index (zero-indexed). decrements size.
	 * 
	 * @return the object of the node that was removed.
	 */
	public Object remove(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		/* enter your code below */
		DLNode tmp = head;
		for (int i = 0; i++ < index; tmp = tmp.getNext());
		tmp.getPrev().setNext(tmp.getNext());
		tmp.getNext().setPrev(tmp.getPrev());
		--size;
		return tmp.getValue();
	}

	/* inserts obj at front of list, increases size */
	public void addFirst(Object obj) {
		DLNode tmp = new DLNode();
		tmp.setValue(obj);
		if (size != 0)  {
			tmp.setNext(head);
			head.setPrev(tmp);
		}
		head = tmp;
		++size;
	}

	/* appends obj to end of list, increases size */
	public void addLast(Object obj) {
		DLNode last = head;
		if (head.getValue() == null) {
			addFirst(obj);
			return;
		}
		for (int i = 0; i++ < size; last = last.getNext());
		DLNode tmp = new DLNode();
		tmp.setValue(obj);
		tmp.setPrev(last);
		last.setNext(tmp);
		++size;
	}

	/* returns the first element in this list */
	public Object getFirst() {
		return head.getValue();
	}

	/* returns the last element in this list */
	public Object getLast() {
		DLNode last = head;
		for (int i = 0; i++ < size; last = last.getNext());
		return last.getValue();
	}

	/*
	 * returns and removes the first element in this list, or
	 * returns null if the list is empty
	 */
	public Object removeFirst() {
		if (size == 0)
			return null;
		Object tmp = head.getValue();
		head = head.getNext();
		head.setPrev(null);
		--size;
		return tmp;
	}

	/*
	 * returns and removes the last element in this list, or
	 * returns null if the list is empty
	 */
	public Object removeLast() {
		if (size == 0)
			return null;
		DLNode last = head;
		for (int i = 0; i++ < size; last = last.getNext());
		Object tmp = last.getValue();
		last.getPrev().setNext(null);
		size--;
		return tmp;
	}

	/*
	 * returns a String with the values in the list in a
	 * friendly format, for example [Apple, Banana, Cucumber]
	 * The values are enclosed in [], separated by one comma and one space.
	 */
	public String toString() {
		String ret = "";
		/* enter your code */
		ret += "[";
		DLNode tmp = head;
		for (int i = 0; i++ < size - 1; tmp = tmp.getNext())
			ret += tmp.getValue() + ", ";
		ret += tmp.getValue() + "]";
		return ret;
	}
}
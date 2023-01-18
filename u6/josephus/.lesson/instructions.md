# Josephus  
  
  ## To Do

Implement the Josephus game with a circular linked list, a data structure in which the last node's next points around to the first node.  

The pointer p just keeps moving around the circle. Move it N times, delete that node, and print the list.   Stop when one person, the winner, is left. Easy!  

We will actually run this program twice, once with integers and once with names. The first time, with integers, will discover the winning position. On the second time, after reading the names, we will replace the winning position with Josephus's name. Josephus was a leader of a Jewish rebellion against Rome, was trapped, and somehow, amazingly, was the one who survived the circle of suicide.  

Work on this program in parts. First, write the readNLinesOfFile and print and insert methods. The readNLinesOfFile reads values from a file and inserts them into the circular list in order. The insert method should insert one node, taking care to keep the list circular and print simply displays the circular list. The insert method has two cases.  

Next, write the countingOff and remove methods to simulate the game. Be sure to use the JGrasp debugger to debug. Finally, write the replaceAt method that will replace that name with Josephus's name (or your own).   Josephus should always win.  

### Method Headers
public static ListNode readNLinesOfFile(int n, File f) throws FileNotFoundException  

private static ListNode insert(ListNode p, Object obj)  

public static void print(ListNode p)  

public static void countingOff(ListNode p, int startSpot, int size)  

public static ListNode remove(ListNode p, int n)  

private static void replaceAt(ListNode p, Object obj, int pos)  

  ## Sample Output
B C D E F  
 How many names (2-20)? 5  
 How many names to count off each time? 2  
 1 2 3 4 5  
 3 4 5 1  
 5 1 3  
 3 5  
 3  
 3 wins!  
 
  ****  Now start all over. ****   
 
 Where should Josephus stand?  3  
 Michael Hannah Josephus Ruth Matthew  
 Josephus Ruth Matthew Michael  
 Matthew Michael Josephus  
 Josephus Matthew  
 Josephus  
 Josephus wins!
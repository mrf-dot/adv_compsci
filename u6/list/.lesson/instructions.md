# ListLab1 
  
  ## To Do

Open ListLab1 and modify it to include all nine methods below. Specifically, construct a linked list and display the value of its first, second, pointer to last, and copy of the last node. Then prompt the user for a new value to be inserted and insert that value to both the front and end of the list. Print out the new list, which should have two more nodes than the original.

### 1. copyNode
Returns a new node that is a copy of the argument node.  
public static ListNode copyNode(ListNode arg) {}

### 2. copyList
Returns a new list that is a copy of the original list. This method is recursive!  
example call: ListNode head2 = copyList(head);  
public static ListNode copyList(ListNode arg) {}

### 3. rest
Returns a new linked list containing copies of each node in the original list except 
the first node, maintaining the order of the original list. It is not correct to just
return a pointer to the 2nd node of the original linked list. This method is recursive.  
public static ListNode rest(ListNode h) {}

### 4. first
Returns the value of the first node, or null if the list is empty  
public static Object first(ListNode head) {}

### 5. second
Returns the value of the second node, or null if the list is empty or if there is only one node.  
public static Object second(ListNode head) {}

### 6. pointerToLast
Returns a reference to the last node in the list, or null if the list is empty.  
public static ListNode pointerToLast(ListNode head) {}

### 7. copyOfLast
Returns a copy of the last node (not just its value!). copyofLast can be recursive.  
public static ListNode copyOfLast(ListNode head) {}

### 8. insertFirst
Returns a reference to a list whose first node's value is specified by the argument, and the
first node's next links to the original list.  
public static ListNode insertFirst(ListNode head, Object arg) {}

### 9. insertLast
Returns a reference to a list whose last node's value is specified by the argument, such
that this last node has been appended to the original list and had its next set to null.   
public static ListNode insertLast(ListNode head, Object arg) {}

  ## Sample Output
[computer, science, java, coffee, nonsense, boo, foo, hello]  
[computer, science, java, coffee, nonsense, boo, foo, hello]  
The head has a value "computer" at ListNode@15db9742  
The copy of head has a value of "computer" at ListNode@6d06d69c  
Copy the list: [computer, science, java, coffee, nonsense, boo, foo, hello]  
The rest of the list: [science, java, coffee, nonsense, boo, foo, hello]  
First of the rest = science  
Second of the rest = java  
Pointer to Last = hello at ListNode@7852e922  
Copy of Last =    hello at ListNode@4e25154f     
Insert what? p  
[p, science, java, coffee, nonsense, boo, foo, hello, p]
 // Name:      
 // Date:
 // use for-each loops or iterators, not regular for-loops
import java.io.*;
import java.util.*;
public class IteratorLab
{
   public static void main(String[] args)
   {
      System.out.println("Iterator Lab\n");
      int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
      for(int n : rawNumbers )
         System.out.print(n + " ");    
      ArrayList<Integer> numbers = createNumbers(rawNumbers);
      System.out.println("\nArrayList: "+ numbers);      //Implicit Iterator!
      System.out.println("Count negative numbers: " + countNeg(numbers));
      System.out.println("Average: " + average(numbers));
      System.out.println("Replace negative numbers: " + replaceNeg(numbers));
      System.out.println("Delete zeros: " + deleteZero(numbers));
      String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
      ArrayList<String> movies = createMovies(rawMovies);
      System.out.println("Movies: " + movies);
      System.out.println("Movies: " +  removeDupes(movies));
   }
      // pre: an array of just int values 
   	// post: return an ArrayList containing all the values
   public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
   {
	   ArrayList<Integer> a = new ArrayList<Integer>();
      for (int i: rawNumbers) {
	      a.add(i);
      }
	   return a;
   }
      // pre: an array of just Strings  
   	// post: return an ArrayList containing all the Strings
   public static ArrayList<String> createMovies(String[] rawWords) 
   {
      ArrayList<String> myList = new ArrayList<String>();
      for ( String str : rawWords )
         myList.add( str );
      return myList;
   }
   
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the number of negative values in the ArrayList a
   public static int countNeg(ArrayList<Integer> a)
   {
	   int cnt = 0;
	   for (Integer i: a)
		   if (i < 0)
			   cnt++;
	   return cnt;
   }
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the average of all values in the ArrayList a
   public static double average(ArrayList<Integer> a)
   {
       int sum = 0;
	   ListIterator<Integer> b = a.listIterator();
	   while (b.hasNext())
		   sum += b.next();
	   return sum / a.size();
   }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: replaces all negative values in ArrayList a with 0 
   public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
   {
      ListIterator<Integer> b = a.listIterator(a.size());

      while (b.hasPrevious()) 
	      if (b.previous() < 0)
		      b.set(0);
      ArrayList<Integer> c = new ArrayList<Integer>();
      while (b.hasNext()) 
	c.add(b.next());
      return c;
   }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: deletes all zeros in the ArrayList a
   public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
   {
      ListIterator<Integer> b = a.listIterator(a.size());
      while (b.hasPrevious()) 
	      if (b.previous() == 0)
		      b.remove();
      ArrayList<Integer> c = new ArrayList<Integer>();
      while (b.hasNext()) 
	c.add(b.next());
      return c;
   }
     	// pre: ArrayList a is not empty and contains only Integer objects
	
      // pre: ArrayList a is not empty and contains only String objects
   	// post: return an ArrayList without duplicate movie titles
      //       (Note: you do not have to return a - it can be a different list)
		// strategy: start with an empty arraylist and add movies as needed
   public static ArrayList<String> removeDupes(ArrayList<String> a)
	{
		ArrayList<String> b = new ArrayList<String>();
		for (String s: a) {
			if (!b.contains(s))
				b.add(s);
		}
		return b;
   }
   
}


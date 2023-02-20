// Name:
// Date:
import java.util.*;
public class ParenMatch
{
   public static final String LEFT  = "([{<";
   public static final String RIGHT = ")]}>";
   public static void main(String[] args)
   {
      System.out.println("Parentheses Match");
      ArrayList<String> parenExp = new ArrayList<String>();
      /* test cases */
       parenExp.add("5 + 7");
	parenExp.add("( 15 + -7 )");
	parenExp.add(") 5 + 7 (");
	parenExp.add("( ( 5.0 - 7.3 ) * 3.5 )");
	parenExp.add("< { 5 + 7 } * 3 >");
	parenExp.add("[ ( 5 + 7 ) * ] 3");
	parenExp.add("( 5 + 7 ) * 3");
	parenExp.add("5 + ( 7 * 3 )");
	parenExp.add("( ( 5 + 7 ) * 3");
	parenExp.add("[ ( 5 + 7 ] * 3 )");
	parenExp.add("[ ( 5 + 7 ) * 3 ] )");
	parenExp.add("( [ ( 5 + 7 ) * 3 ]");
	parenExp.add("( ( ( ) $ ) )");
	parenExp.add("( ) [ ]");
      for( String s : parenExp )
      {
         boolean good = checkParen(s);
         if(good)
            System.out.println(s + "\t good!");
         else
            System.out.println(s + "\t BAD");
      }
	     }
   //returns the index of the left parentheses or -1 if it is not there
   public static int isLeftParen(String p)
   {
      return LEFT.indexOf(p);
	     }
   //returns the index of the right parentheses or -1 if it is not there
   public static int isRightParen(String p)
   {
      return RIGHT.indexOf(p);
	     }
   public static boolean checkParen(String exp)
   {
     /* enter your code here */
	   Stack<String> st = new Stack<String>();
	   for (int i = 0; i < exp.length(); i++) {
		   String s = exp.substring(i, i+1);
		   if (isLeftParen(s) != -1) {
			   st.push(s);
		   }
		   if (isRightParen(s) != -1) {
			   if (st.isEmpty() || isLeftParen(st.peek()) != isRightParen(s))
				   return false;
			   st.pop();
		   }
	   }
		return st.isEmpty();
   }
}
/*****************************************
Parentheses Match
 *******************************************/
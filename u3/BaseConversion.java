// ******************************************************************
// BaseConversion.java
// Student Name: <name>
//
// Recursively converts an integer from base 10 to another base
// ******************************************************************
import java.util.Scanner;
public class BaseConversion
{
   public static void main( String[] args )
   {
      int base10Num;
      int base;
      Scanner scan = new Scanner( System.in );
      System.out.println();
      System.out.println( "Base Conversion Program" );
      System.out.print( "Enter an integer: " );
      base10Num = scan.nextInt();
      System.out.print( "Enter the base: " );
      base = scan.nextInt();
   // Call convert and print the answer
      System.out.println(convert(base10Num, base));
   
   }
 
 // --------------------------------------------------
 // Converts a base 10 number to another base.
 // --------------------------------------------------
   public static String convert( int num, int b )
   {
      if (num == 0)
	      return "";
      if (num % b > 9)
	      return "" + convert(num / b, b) + digitToString(num % b);
      return "" + convert(num / b, b) + "" + num % b;
   }
 
 // --------------------------------------------------
 // TODO: Take in an int and convert it to it's
 // hexadecimal representation. Remember 10 == "A", 11 == "B"
 // etc... once you fill this out, use it in convert()
   public static String digitToString( int iVal )
   {
	   return "" + (char) (iVal - 10 + 'A');
   }
}
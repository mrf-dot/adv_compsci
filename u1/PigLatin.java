// Mitch Feigenbaum
// 09/06/2022
// Pig Latin lab
import java.util.*;
import java.io.*;

public class PigLatin {
	public static void main(String[] args) throws Exception {
		// *** UNCOMMENT ONLY ONE PART AT A TIME FOR TESTING ***

		part1(); // user input and display output
		part2(); // file input/output
	}
			

	// reads words from user at run-time and displays pig latin equivalent
	public static void part1() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("\nwhat word? (-1 to exit) ");
			String s = sc.next();
			if (s.equals("-1"))
				System.exit(0);
			String p = pig(s);
			System.out.println(p);
		}
	}

	static Scanner infile;
	// reads words from file at run-time and writes pig latin equivalents to file
	public static void part2() throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter outfile = new PrintWriter("output.txt");

		// For Part 2, replace these next two lines with a try-catch exception
		// Refer to page 'ReadWriteFiles_Exceptions.pdf'
		// The code will be similar to the code in the pdf (although not exact)
		String fileName;
		do {
			System.out.print("Enter input filename: ");
			fileName = sc.nextLine();
			try {
				infile = new Scanner(new File(fileName));
			} catch (FileNotFoundException fnf) {
				System.out.println("Error: file not found");
				fileName = null;
			}
		} while (fileName == null);
		try {	
			infile = new Scanner(new File(fileName));
		} catch (FileNotFoundException fnf) {
			System.out.println("Error: file not found");
			System.exit(1);
		}
		while (infile.hasNextLine()) {
			String line = infile.nextLine();
			String[] words = line.split(" ");
			for (int i = 0; i < words.length; i++) {
				String p = pig(words[i]);
				outfile.print(p + " ");
			}
		}
		outfile.println();
		outfile.close();
	}

	// returns the pig latinized version of the word s
	public static String pig(String s) {
		// ******** PUT YOUR CODE HERE **********
		/* Checks if a vowel is present anywhere in the string (accounts for special cases) */
		if (!s.matches(".*[AEIOaeio].*") && !s.matches(".+[Yy].*") && !s.matches(".*[^Qq][Uu].*"))
			return "**** INVALID ****";
		/* Assigns the punctioation to the character punct */
		char punct = s.charAt(s.length() - 1) == '.'
				? '.'
				: s.charAt(s.length() - 1) == '?'
				? '?'
				: s.charAt(s.length() - 1) == '!'
				? '!'
				: ' ';
		char c;
		boolean capitalized = Character.isUpperCase(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(0);
			/* check if c is a consonant under the special cases */
			if (c != 'A' && c != 'a' && c != 'E' && c != 'e' && c != 'I' && c != 'i' && c != 'O' && c != 'o'
					/* case for u */
					&& ((c != 'u' && c != 'U') || (i > 0 && (s.charAt(s.length() - 1) == 'Q' || s.charAt(s.length() - 1) == 'q')))
					/* case for y */
					&& ((c != 'Y' && c != 'y') || i == 0)) {
				s = s.substring(1) + c;
			} else {
				if (capitalized)
					s = Character.toUpperCase(s.charAt(0)) + s.substring(1);
				if (punct != ' ')
					s += punct;
				s += "ay";
				break;
			}
		}
		return s;
	}
	// ********* PUT ANY OF YOUR HELPER METHODS HERE **********
}

// Mitch Feigenbaum
// Period 6
// 9/16
import java.util.Scanner;

class VigenereCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String p, k;
		System.out.print("Enter a string to be encrypted: ");
		p = sc.nextLine();
		/* Continuously prompts the client until a key with only A-z is given */
		System.out.print("Enter a key: ");
		while (!(k = sc.nextLine().toLowerCase()).matches("[a-z]+"))
			System.out.print("ERROR: Key must contain only letters.\nEnter a valid key: ");
		/* Displays the encrypted string to stdout using the encrypt method */
		System.out.println("Your encrypted string: " + encrypt(p, k));
	}

	/* Encrypts the string using the key string as a shift */
	public static String encrypt(String p, String k) {
		String e = "";
		for (int i = 0; i < p.length(); i++) {
			/* Assigns a variable to the current index in both the encrypted and key string */
			int pc = p.charAt(i), kc = k.charAt(i % k.length());
			/* Shifts a character based on the key */
			if ((pc >= 'A' && pc <= 'Z') || (pc >= 'a' && pc <= 'z'))
				pc = (pc <= 'Z' ? 'A' : 'a') + ((pc >= 'a' ? pc - 'a' : pc - 'A') + (kc - 'a')) % 26;
			/* Adds the modified/non-alphabetical character to the encrypted string */
			e += (char) pc;
		}
		return e;
	}
}
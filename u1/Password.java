import java.util.Scanner;

public class Password {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String pass;
		while (true) {
			System.out.print("Enter a password: ");
			while (!isValid(pass = s.nextLine()))
				System.out.print("Please enter a valid password: ");
			int tries = 0;
			do {
				System.out.print("Enter your password again: ");
			} while (!pass.equals(s.nextLine()) && ++tries < 3);
			if (tries >= 3)
				System.out.println("Your second password does not match the first password.");
			else
				break;
		}
		System.out.println("Password entered successfully.");
	}

	/**
	 * The isValid() method checks whether a password passes the criteria set for
	 * this assignment.
	 * Namely, that the password is at least 8 characters long with one uppercase,
	 * one lowercase, one number, one special character, and no spaces.
	 * It accomplishes this by executing a logical statement using regular
	 * expressions.
	 * It starts by checking the length of the password string is greater than or
	 * equal to eight characters long.
	 * Then it uses the Pattern class to check that the string matches various
	 * regular expressions based on teh assignment criteria.
	 *
	 * @param pass A password in string form
	 * @return true only if the string successfully passes all criteria
	 */
	public static boolean isValid(String pass) {
		return pass.length() >= 8
				&& pass.matches(".*[A-Z].*")
				&& pass.matches(".*[a-z].*")
				&& pass.matches(".*[0-9].*")
				&& pass.matches(".*[^a-zA-Z0-9].*")
				&& pass.matches("\\S+");
	}
}

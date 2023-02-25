
//name:   date:
import java.util.*;

public class InfixToPostfix {
	public static final String LEFT = "([{<";
	public static final String RIGHT = ")]}>";
	public static final String operators = "+-*/";

	public static void main(String[] args) {
		System.out.println("Infix  \t-->\tPostfix\t\t-->\tEvaluate");
		ArrayList<String> infixExp = new ArrayList<String>();
		/* add test cases to the list here */
		infixExp.add("3+4*5");
		infixExp.add("3*4+5");
		infixExp.add("(4+5)-5*3");
		infixExp.add("(3+4)*(5+6)");
		infixExp.add("(3*(4+5)-2)/5");
		infixExp.add("8+1*2-9/3");
		infixExp.add("8*3/5");
		for (String infix : infixExp) {
			String pf = infixToPostfix(infix); // get this conversion to work first
			System.out.println(infix + "\t\t\t" + pf + "\t\t\t" + PostfixEval.eval(pf)); // PostfixEval must
													// work!
		}
	}

	public static String infixToPostfix(String infix) {
		String pfx = "";
		Stack<Character> std = new Stack<Character>();
		for (char c : infix.toCharArray()) {
			if (operators.indexOf(c) != -1) {
				if (std.isEmpty()
						|| std.peek() == c
						|| operators.indexOf(std.peek()) == -1
						|| isStrictlyLower(c, std.peek())) {
					std.push(c);
				} else {
					pfx += std.pop();
					while (!std.isEmpty()
							&& std.peek() != c
							&& !isStrictlyLower(c, std.peek())
							&& operators.indexOf(std.peek()) == -1) {
						std.pop();
					}
					std.push(c);
				}
			} else if (LEFT.indexOf(c) != -1) {
				std.push(c);
			} else if (RIGHT.indexOf(c) != -1) {
				while (!std.isEmpty() && LEFT.indexOf(std.peek()) == -1)
					pfx += std.pop();
				if (!std.isEmpty()) {
					std.pop();
				}
			} else {
				pfx += c;
			}
		}
		while (!std.isEmpty())
			pfx += std.pop();
		return pfx;
	}

	// write isStrictlyLower, isHigherOrEqual, or getLevel:
	/* method goes here */
	public static boolean isStrictlyLower(char next, char top) {
		return (top == '+' || top == '-') && (next == '*' || next == '/');
	}

}

/*
 * Infix --> Postfix --> Evaluate
 * 3+4*5 345*+ 23
 * 3*4+5 34*5+ 17
 * (4+5)-5*3 45+53*- -6
 * (3+4)*(5+6) 34+56+* 77
 * (3*(4+5)-2)/5 345+*2-5/ 5
 * 8+1*2-9/3 812*+93/- 7
 * 8*3/5 83*5/ 4
 */

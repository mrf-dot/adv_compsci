//name:     date:

import java.util.*;

public class PostfixEval {
	public static void main(String[] args) {
		System.out.println("Postfix  -->  Evaluate");
		ArrayList<String> postExp = new ArrayList<String>();
		/* enter tests here */
		postExp.add("345*+");
		postExp.add("34*5+");
		postExp.add("45+53*-");
		postExp.add("34+56+*");
		postExp.add("345+*2-5/");
		postExp.add("812*+93/-");
		postExp.add("83*5/");
		for (String pf : postExp) {
			System.out.println(pf + "\t\t" + eval(pf));
		}
	}

	public static int eval(String postfix) {
		Stack<Integer> st = new Stack<Integer>();
		for (char c : postfix.toCharArray()) {
			if (!isOperator(c)) {
				st.add((Integer) (c - '0'));
			} else {
				if (st.size() < 2) {
					System.err.println("(Error) The user has not input sufficient values in the expression.");
					return -1;
				}
				st.add(eval(st.pop(), st.pop(), c));
			}
		}
		if (st.size() > 1) {
			System.err.println("(Error) The user input has too many values.");
			return -1;
		}
		return st.pop();
	}

	public static int eval(int a, int b, char ch) {
		switch (ch) {
			case '+':
				return b + a;
			case '-':
				return b - a;
			case '*':
				return b * a;
			case '/':
				return b / a;
			default:
				return 0;
		}
	}

	public static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}
}

/*
 * Postfix --> Evaluate
 * 345*+ 23
 * 34*5+ 17
 * 45+53*- -6
 * 34+56+* 77
 * 345+*2-5/ 5
 * 812*+93/- 7
 * 83*5/ 4
 */

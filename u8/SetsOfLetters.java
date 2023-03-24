import java.util.*;
import java.io.*;

public class SetsOfLetters {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "declarationLast.txt";
		fillTheSets(fileName);
	}

	public static void fillTheSets(String fn) throws FileNotFoundException {
		Set<Character> los = new TreeSet<Character>();
		Set<Character> his = new TreeSet<Character>();
		Set<Character> puncts = new TreeSet<Character>();
		Scanner infile = new Scanner(new File(fn));
		for (int shared = 0; infile.hasNext(); ++shared) {
			Set<Character> lo = new TreeSet<Character>();
			Set<Character> hi = new TreeSet<Character>();
			Set<Character> punct = new TreeSet<Character>();
			String ln = infile.nextLine();
			for (Character c : ln.toCharArray()) {
				if (Character.isLowerCase(c))
					lo.add(c);
				else if (Character.isUpperCase(c))
					hi.add(c);
				else if (c != ' ')
					punct.add(c);
			}
			System.out.println(ln);
			System.out.println(lo);
			System.out.println(hi);
			punct.add(' '); // added to comply with sample output below
			System.out.println(punct);
			punct.remove(' ');
			System.out.println();
			if (shared == 1) {
				los = lo;
				his = hi;
				puncts = punct;
			} else if (shared > 1) {
				Iterator loit = los.iterator(), hiit = his.iterator(), punctit = puncts.iterator();
				while (loit.hasNext()) {
					if (!lo.contains(loit.next()))
						loit.remove();
				}
				while (hiit.hasNext()) {
					if (!hi.contains(hiit.next()))
						hiit.remove();
				}
				while (punctit.hasNext()) {
					if (!punct.contains(punctit.next()))
						punctit.remove();
				}
			}
		}
		System.out.println(los);
		System.out.println(his);
		System.out.println(puncts);
	}
}
/***********************************
 * ----jGRASP exec: java SetsOfLetters
 *
 * We, therefore, the Representatives of the united States of
 * Lower Case: [a, d, e, f, h, i, n, o, p, r, s, t, u, v]
 * Upper Case: [R, S, W]
 * Other: [ , ,]
 *
 * America, in General Congress, Assembled, appealing to the
 * Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, p, r, s, t]
 * Upper Case: [A, C, G]
 * Other: [ , ,]
 *
 * Supreme Judge of the world for the rectitude of our intentions,
 * Lower Case: [c, d, e, f, g, h, i, l, m, n, o, p, r, s, t, u, w]
 * Upper Case: [J, S]
 * Other: [ , ,]
 *
 * do, in the Name, and by the Authority of the good People of
 * Lower Case: [a, b, d, e, f, g, h, i, l, m, n, o, p, r, t, u, y]
 * Upper Case: [A, N, P]
 * Other: [ , ,]
 *
 * these Colonies, solemnly publish and declare, That these United
 * Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, u, y]
 * Upper Case: [C, T, U]
 * Other: [ , ,]
 *
 * Colonies are, and of Right ought to be Free and Independent
 * Lower Case: [a, b, d, e, f, g, h, i, l, n, o, p, r, s, t, u]
 * Upper Case: [C, F, I, R]
 * Other: [ , ,]
 *
 * States; that they are Absolved from all Allegiance to the
 * Lower Case: [a, b, c, d, e, f, g, h, i, l, m, n, o, r, s, t, v, y]
 * Upper Case: [A, S]
 * Other: [ , ;]
 *
 * British Crown, and that all political connection between them
 * Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, w]
 * Upper Case: [B, C]
 * Other: [ , ,]
 *
 * and the State of Great Britain, is and ought to be totally
 * Lower Case: [a, b, d, e, f, g, h, i, l, n, o, r, s, t, u, y]
 * Upper Case: [B, G, S]
 * Other: [ , ,]
 *
 * dissolved; and that as Free and Independent States, they have
 * Lower Case: [a, d, e, h, i, l, n, o, p, r, s, t, v, y]
 * Upper Case: [F, I, S]
 * Other: [ , ,, ;]
 *
 * full Power to levy War, conclude Peace, contract Alliances,
 * Lower Case: [a, c, d, e, f, i, l, n, o, r, s, t, u, v, w, y]
 * Upper Case: [A, P, W]
 * Other: [ , ,]
 *
 * establish Commerce, and to do all other Acts and Things which
 * Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, r, s, t, w]
 * Upper Case: [A, C, T]
 * Other: [ , ,]
 *
 * Independent States may of right do. And for the support of this
 * Lower Case: [a, d, e, f, g, h, i, m, n, o, p, r, s, t, u, y]
 * Upper Case: [A, I, S]
 * Other: [ , .]
 *
 * Declaration, with a firm reliance on the protection of divine
 * Lower Case: [a, c, d, e, f, h, i, l, m, n, o, p, r, t, v, w]
 * Upper Case: [D]
 * Other: [ , ,]
 *
 * Providence, we mutually pledge to each other our Lives, our
 * Lower Case: [a, c, d, e, g, h, i, l, m, n, o, p, r, s, t, u, v, w, y]
 * Upper Case: [L, P]
 * Other: [ , ,]
 *
 * Fortunes and our sacred Honor.
 * Lower Case: [a, c, d, e, n, o, r, s, t, u]
 * Upper Case: [F, H]
 * Other: [ , .]
 *
 * Common Lower Case: [d, e, n, o, r, t]
 * Common Upper Case: []
 * Common Other: [ ]
 * ----jGRASP: operation complete.
 ************************************/

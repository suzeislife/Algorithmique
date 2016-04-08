package S01;

public class Parenth {
	// -------------------------------------
	// Usage: java Parenth 'aa(({adf}))' don't forget the ' !
	// -------------------------------------
	public static void main(String[] args) {
		if (args.length != 0) {
			String s = args[0];
			System.out.println(s + " : " + isBalanced(s));
		}
		String[] t = { "((o{()oo})o)", "oo((((((((((((((((((((o))))))))))))))))))))o{}", "oo())(()", "oo()((())()",
				"oo()((()})", ")()", "((}))" };
		boolean[] answer = { true, true, false, false, false, false, false };
		boolean ok = true;
		for (int i = 0; i < t.length; i++) {
			ok = ok & (isBalanced(t[i]) == answer[i]);
			System.out.print(t[i] + " : " + isBalanced(t[i]));
			System.out.println(" (should be " + answer[i] + ")");
		}
		if (ok)
			System.out.println("\nTest passed successfully");
		else
			System.out.println("\nOups... There's a bug !");
	}

	// -------------------------------------
	public static boolean isBalanced(String l) {
		boolean isBalanced = false;
		char c;
		CharStack s = new CharStack();
		for (int i = 0; i < l.length(); i++) {
			c = l.charAt(i);
			if (isOpeningParenth(c)) {
				s.push(c);
			} else if (isClosingParenth(c)) {
				System.out.println(s.top() + " " + c);
				if (isMatchingParenth(s.top(), c))
					s.pop();
				else
					break;
				if (s.isEmpty())
					isBalanced = true;
			}
		}
		return isBalanced; // TODO - A ADAPTER !
	}

	// -------------------------------------
	private static boolean isOpeningParenth(char c) {
		return (c == '(') || (c == '{');
	}

	private static boolean isClosingParenth(char c) {
		return (c == ')') || (c == '}');
	}

	private static boolean isMatchingParenth(char c1, char c2) {
		return ((c1 == '(') && (c2 == ')')) || ((c1 == '{') && (c2 == '}'));
	}
}
package s09;

public class FindsBugs {

	public static void main(String[] args) {
		findsBug01();
		findsBug02();
		findsBug03();
	}

	static boolean findsBug01() {
		IntStack s = new IntStack(10);
		s.push(0);
		if (s.pop() != 0)
			return true;
		if (!s.isEmpty())
			return true;
		return false;
	}

	static boolean findsBug02() {
		IntStack s = new IntStack(10);
		s.push(0);
		s.push(1);
		if (s.isEmpty())
			return true;
		return false;
	}

	static boolean findsBug03() {
		IntStack s = new IntStack(10);
		s.push(0);
		s.push(5);
		s.pop();
		s.push(1);
		if (s.pop() != 1)
			return true;
		if (s.isEmpty())
			return true;
		return false;
	}
}

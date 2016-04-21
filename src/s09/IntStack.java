package s09;

public class IntStack {
	private int buf[];
	private int top;

	public IntStack() {
		this(10);
	}

	public IntStack(int cap) {
		// Pr�
		assert cap > 0 : "Taille du tableau inf�rieur a 0";
		buf = new int[cap];
		top = -1;
		// Post
		assert buf.length == cap : "Taille du tableau incorrect";
		assert isEmpty() : "Tableau pas vide � la cr�ation";
	}

	public boolean isEmpty() {
		// Pr�
		assert this != null : "Object pas cr�e";
		// Post
		return top == -1;
	}

	public int top() {
		// Pr�
		assert this != null : "Object pas cr�e";
		assert buf[top + 1] == 0;
		return buf[top];
	}

	public int pop() {
		// Pr�
		assert this != null : "Object pas cr�e";
		int a = buf[top];
		top--;
		return a;
	}

	public void push(int x) {
		// Pr�
		assert this != null : "Object pas cr�e";
		checkSize();
		top++;
		buf[top] = x;
		// Post
		assert buf[top] == x : "Valeur incorrectement ajout�";
		assert !this.isEmpty() : "tableau vide";
	}

	private void checkSize() {
		if (top == buf.length - 1) {
			int[] t = new int[2 * buf.length];
			for (int i = 0; i < buf.length; i++)
				t[i] = buf[i];
			buf = t;
		}
	}
}
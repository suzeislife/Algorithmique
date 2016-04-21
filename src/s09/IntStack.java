package s09;

public class IntStack {
	private int buf[];
	private int top;

	public IntStack() {
		this(10);
	}

	public IntStack(int cap) {
		// Pré
		assert cap > 0 : "Taille du tableau inférieur a 0";
		buf = new int[cap];
		top = -1;
		// Post
		assert buf.length == cap : "Taille du tableau incorrect";
		assert isEmpty() : "Tableau pas vide à la création";
	}

	public boolean isEmpty() {
		// Pré
		assert this != null : "Object pas crée";
		// Post
		return top == -1;
	}

	public int top() {
		// Pré
		assert this != null : "Object pas crée";
		assert buf[top + 1] == 0;
		return buf[top];
	}

	public int pop() {
		// Pré
		assert this != null : "Object pas crée";
		int a = buf[top];
		top--;
		return a;
	}

	public void push(int x) {
		// Pré
		assert this != null : "Object pas crée";
		checkSize();
		top++;
		buf[top] = x;
		// Post
		assert buf[top] == x : "Valeur incorrectement ajouté";
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
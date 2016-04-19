package s09;

public class IntStack {
	private int buf[];
	private int top;

	public IntStack() {
		this(10);
	}

	public IntStack(int cap) {
		buf = new int[cap];
		top = -1;
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

		
		return buf[top];
		// Post
	}

	public int pop() {
		// Pr�
		assert this != null : "Object pas cr�e";

		// Post
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
		assert top == 0;
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
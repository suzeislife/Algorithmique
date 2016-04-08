package S01;

public class CharStack {
	private int topIndex;
	private char[] buffer;
	// -------------------------------------
	private static final int DEFAULT_SIZE = 10;

	// -------------------------------------
	public CharStack() {
		this(DEFAULT_SIZE);
	}

	// -------------------------------------
	public CharStack(int estimatedSize) {
		buffer = new char[estimatedSize];
		topIndex = -1;
	}

	// -------------------------------------
	public boolean isEmpty() {
		boolean checkEmpty = false;
		if (topIndex == -1)
			checkEmpty = true;
		return checkEmpty;
	}

	// -------------------------------------
	public char top() {
		if (!isEmpty())
			return buffer[topIndex]; // TODO - A compléter...
		return '\0';
	}

	// -------------------------------------
	public char pop() {
		char popElement = '\0';
		if (!isEmpty()) {
			popElement = buffer[topIndex];
			buffer[topIndex] = '\0';
			topIndex--;
		}
		return popElement;
	}

	// -------------------------------------
	public void push(char x) {
		if (topIndex < buffer.length - 1) {
			topIndex++;
			buffer[topIndex] = x;
		} else if (topIndex == buffer.length) {
			char[] newBuffer = new char[buffer.length * 2];
			for (int i = 0; i < buffer.length; i++) {
				newBuffer[i] = buffer[i];
			}
			topIndex++;
			buffer[topIndex] = x;
		}
		// TODO - A compléter...
	}
	// -------------------------------------
}

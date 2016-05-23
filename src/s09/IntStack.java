package s09;

public class IntStack {
  private int buf[];
  private int top;

  public IntStack() {
    this(10);
  }

<<<<<<< HEAD
  public IntStack(int cap) {
    buf = new int[cap];
    top = -1;
  }
=======
	public IntStack(int cap) {
		// Pr�
		assert cap > 0 : "Taille du tableau inf�rieur a 0";
		buf = new int[cap];
		top = -1;
		// Post
		assert buf.length == cap : "Taille du tableau incorrect";
		assert isEmpty() : "Tableau pas vide � la cr�ation";
	}
>>>>>>> branch 'master' of https://github.com/suzeislife/Algorithmique.git

<<<<<<< HEAD
  public boolean isEmpty() {
    assert top <= 0;
    return top == -1;
  }
=======
	public boolean isEmpty() {
		// Pr�
		assert this != null : "Object pas cr�e";
		// Post
		return top == -1;
	}
>>>>>>> branch 'master' of https://github.com/suzeislife/Algorithmique.git

<<<<<<< HEAD
  public int top() {
    return buf[top];
  }
=======
	public int top() {
		// Pr�
		assert this != null : "Object pas cr�e";
		assert buf[top + 1] == 0;
		return buf[top];
	}
>>>>>>> branch 'master' of https://github.com/suzeislife/Algorithmique.git

<<<<<<< HEAD
  public int pop() {
    int a = buf[top];
    top--;
    return a;
  }
=======
	public int pop() {
		// Pr�
		assert this != null : "Object pas cr�e";
		int a = buf[top];
		top--;
		return a;
	}
>>>>>>> branch 'master' of https://github.com/suzeislife/Algorithmique.git

<<<<<<< HEAD
  public void push(int x) {
    checkSize();
    top++;
    buf[top] = x;
  }
=======
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
>>>>>>> branch 'master' of https://github.com/suzeislife/Algorithmique.git

<<<<<<< HEAD
  private void checkSize() {
    if (top == buf.length - 1) {
      int[] t = new int[2 * buf.length];
      for (int i = 0; i < buf.length; i++)
        t[i] = buf[i];
      buf = t;
    }
  }
=======
	private void checkSize() {
		if (top == buf.length - 1) {
			int[] t = new int[2 * buf.length];
			for (int i = 0; i < buf.length; i++)
				t[i] = buf[i];
			buf = t;
		}
	}

>>>>>>> branch 'master' of https://github.com/suzeislife/Algorithmique.git
}
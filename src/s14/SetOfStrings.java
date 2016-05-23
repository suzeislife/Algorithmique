package s14;

import java.util.BitSet;

public class SetOfStrings {
	BitSet busy;
	String[] elt;
	int[] total;
	int crtSize;
	static final int DEFAULT_CAPACITY = 5;

	// ------------------------------------------------------------
	public SetOfStrings() {
		this(DEFAULT_CAPACITY);
	}

	public SetOfStrings(int initialCapacity) {
		initialCapacity = Math.max(2, initialCapacity);
		elt = new String[initialCapacity];
		total = new int[initialCapacity];
		busy = new BitSet(initialCapacity);
		crtSize = 0;
	}

	int capacity() {
		return elt.length;
	}

	// Here is the hash function :
	int hashString(String s) {
		int h = s.hashCode() % capacity();
		if (h < 0)
			h = -h;
		return h;
	}

	// PRE: table is not full
	// returns the index where element e is stored, or, if
	// absent, the index of an appropriate free cell
	// where e can be stored
	int targetIndex(String e) {
		return 0; // TODO - A COMPLETER
	}

	public void add(String e) {
		if (crtSize * 2 >= capacity())
			doubleTable();
		// TODO - A COMPLETER
	}

	private void doubleTable() {
		// TODO - A COMPLETER
	}

	public void remove(String e) {
		int i = targetIndex(e);
		if (!busy.get(i))
			return; // elt is absent
		int h = hashString(e);
		total[h]--;
		elt[i] = null;
		busy.clear(i);
		crtSize--;
	}

	public boolean contains(String e) {
		return busy.get(targetIndex(e));
	}

	public void union(SetOfStrings s) {
		// TODO - A COMPLETER
	}

	public void intersection(SetOfStrings s) {
		// TODO - A COMPLETER
	}

	public int size() {
		return crtSize;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public String[] arrayFromSet() {
		String t[] = new String[size()];
		int i = 0;
		SetOfStringsItr itr = new SetOfStringsItr(this);
		while (itr.hasMoreElements()) {
			t[i++] = itr.nextElement();
		}
		return t;
	}

	public String toString() {
		SetOfStringsItr itr = new SetOfStringsItr(this);
		if (isEmpty())
			return "{}";
		String r = "{" + itr.nextElement();
		while (itr.hasMoreElements()) {
			r += ", " + itr.nextElement();
		}
		return r + "}";
	}

	// ------------------------------------------------------------
	// tiny example
	// ------------------------------------------------------------
	public static void main(String[] args) {
		String a = "abc";
		String b = "defhijk";
		String c = "hahaha";
		SetOfStrings s = new SetOfStrings();
		s.add(a);
		s.add(b);
		s.remove(a);
		if (s.contains(a) || s.contains(c) || !s.contains(b))
			System.out.println("bad news...");
		else
			System.out.println("ok");
	}
}
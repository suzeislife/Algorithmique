package S04;

import S03.List;
import S03.ListItr;

public class Bubble {
	// ---------------------------------------------
	static void bubbleSortList(List l) {
		if (l.isEmpty())
			return;
		ListItr li = new ListItr(l);
		boolean goOn = true;
		while (goOn) {
			li.goToFirst();
			goOn = bubbleSwapped(li);
		}
	}

	// ---------------------------------------------
	// Swaps between left and right element if needed
	// Returns true if swap occurred
	static boolean bubbleSwapped(ListItr li) {
		boolean anyChange = false;
		int nb1;
		int nb2;
		while (!li.isLast()) {
			nb1 = li.consultAfter();
			li.goToNext();
			if (!li.isLast()) {
				nb2 = li.consultAfter();
				if (nb1 > nb2) {
					li.removeAfter();
					li.goToPrev();
					li.insertAfter(nb2);
					anyChange = true;
				}
			}
		}
		return anyChange;
	}

	// ---------------------------------------------
	public static void main(String[] args) {
		List l = new List();
		ListItr li = new ListItr(l);
		int[] t = { 4, 3, 9, 2, 1, 8, 0 };
		int[] r = { 0, 1, 2, 3, 4, 8, 9 };
		for (int i = 0; i < t.length; i++) {
			li.insertAfter(t[i]);
			li.goToNext();
		}
		bubbleSortList(l);
		li = new ListItr(l);
		for (int i = 0; i < r.length; i++) {
			if (li.isLast() || li.consultAfter() != r[i]) {
				System.out.println("Oups... something is wrong");
				System.exit(-1);
			}
			li.goToNext();
		}
		if (!li.isLast()) {
			System.out.println("Oups... too much elements");
			System.exit(-1);
		}
		System.out.println("Test passed successfully");
	}
}

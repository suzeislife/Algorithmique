package S03;

public class ListItr {
	final List list;
	ListNode pred, succ;

	// ----------------------------------------------------------
	public ListItr(List anyList) {
		list = anyList;
		goToFirst();
	}

	// ----------------------------------------------------------
	public void insertAfter(int e) {
		ListNode node = new ListNode(e, pred, succ);
		// Case 1 isEmpty
		if (list.isEmpty()) {
			list.first = node;
			list.last = node;
			succ = node;
		} else {
			// Case 2 insert in first
			if (isFirst()) {
				node.next = succ;
				succ.prev = node;
				succ = node;
				list.first = node;
			}
			// Case 3 insert in last
			else if (isLast()) {
				node.prev = pred;
				pred.next = node;
				succ = node;
				list.last = node;
			}
			// Case 4 insert between
			else {
				succ.prev = node;
				pred.next = node;
				node.prev = pred;
				node.next = succ;
				succ = node;
			}
		}
		list.size++;
	}

	// ----------------------------------------------------------
	public void removeAfter() {
		if (!list.isEmpty()) {
			// Case 1 first and not before last
			if (isFirst() && succ.next != null) {
				succ = succ.next;
				succ.prev = null;
				list.first = succ;
			}
			// Case 2 not first and not before last
			else if (pred != null && succ.next != null) {
				succ = succ.next;
				succ.prev = pred;
				pred.next = succ;
			}
			// Case 3 not first and before last
			else if (pred != null && succ.next == null) {
				succ = null;
				pred.next = null;
				list.last = pred;
			}
			// Case 4 first and last (last element)
			else if (isFirst() && succ.next == null) {
				succ = null;
				list.last = succ;
			}
			list.size--;
		}

	}

	// ----------------------------------------------------------
	public int consultAfter() {
		return succ.elt;
	}

	public void goToNext() {
		pred = succ;
		succ = succ.next;
	}

	public void goToPrev() {
		succ = pred;
		pred = pred.prev;
	}

	public void goToFirst() {
		succ = list.first;
		pred = null;
	}

	public void goToLast() {
		pred = list.last;
		succ = null;
	}

	public boolean isFirst() {
		return pred == null;
	}

	public boolean isLast() {
		return succ == null;
	}
}

// When isFirst(), it is forbidden to call goToPrev()
// When isLast(), it is forbidden to call goToNext()
// When isLast(), it is forbidden to call consultAfter(), or removeAfter()
// For an empty list, isLast()==isFirst()==true
// For a fresh ListItr, isFirst()==true
// Using multiple iterators on the same list is allowed only
// if none of them modifies the list
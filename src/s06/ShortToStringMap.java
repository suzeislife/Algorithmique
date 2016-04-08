package s06;

public class ShortToStringMap {
	private int size;
	private short[] tabKey;
	private short[] newTabKey;
	private String[] tabValue;
	private String[] newTabValue;
	private ShortToStringMapItr itr;
	// ------------------------------
	// Private methods
	// ------------------------------

	// Could be useful, for instance :
	// - one method to detect and handle the "array is full" situation
	// - one method to locate a key in the array
	// (to be called from containsKey(), put(), and remove())
	private void isFull() {
		if (size == itr.key) {
			size = size * 2;
			newTabKey = new short[size];
			newTabValue = new String[size];
			for (int i = 0; i < tabKey.length; i++) {
				newTabKey[i] = tabKey[i];
				newTabValue[i] = tabValue[i];
			}
			tabKey = newTabKey;
			tabValue = newTabValue;
		}
	}

	private int locateKey(short k) {
		for (int i = 0; i < tabKey.length; i++) {
			if (tabKey[i] == k)
				return i;
		}
		return -1;
	}

	// ------------------------------
	// Public methods
	// ------------------------------
	// ------------------------------------------------------------
	public ShortToStringMap() {
		size = 20;
		tabValue = new String[size];
		tabKey = new short[size];
		itr = new ShortToStringMapItr(this);
	}

	// ------------------------------------------------------------
	// adds an entry in the map, or updates the image
	public void put(short key, String img) {
		isFull();
		if (containsKey(key))
			tabValue[locateKey(key)] = img;
		else {
			tabValue[itr.key] = img;
			itr.nextKey();
		}
		// TODO - A COMPLETER...
	}

	// ------------------------------------------------------------
	// returns null if !containsKey(key)
	public String get(short key) {
		if (containsKey(key))
			return tabValue[locateKey(key)];
		else
			return null;
	}

	// ------------------------------------------------------------
	public void remove(short key) {
		if (containsKey(key))
			for (int i = locateKey(key); i < tabKey.length; i++) {
				tabKey[i] = tabKey[i + 1];
				System.out.println(i);
				tabValue[i] = tabValue[i + 1];
				System.out.println(i);
			}
	}

	// ------------------------------------------------------------
	public boolean containsKey(short k) {
		if (locateKey(k) >= 0)
			return true;
		else
			return false;

	}

	// ------------------------------------------------------------
	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	// ------------------------------------------------------------
	// a.union(b) : a becomes "a union b"
	// images are those in b whenever possible
	public void union(ShortToStringMap m) {
		for (int i = 0; i < m.size(); i++) {
			this.put(m.tabKey[i], m.tabValue[i]);
		}
	}

	// ------------------------------------------------------------
	// a.intersection(b) : "a becomes a intersection b"
	// images are those in b
	public void intersection(ShortToStringMap s) {
		newTabKey = new short[s.size()];
		newTabValue = new String[s.size()];
		int j = 0;
		for (int i = 0; i < s.size(); i++) {
			if (this.containsKey(s.tabKey[i])) {
				newTabKey[j] = s.tabKey[i];
				newTabValue[j] = s.tabValue[i];
				j++;
			}
		}
	}

	// ------------------------------------------------------------
	// a.toString() returns all elements in
	// a string like: {3:"abc",9:"xy",-5:"jk"}
	public String toString() {
		return null;
	}
}
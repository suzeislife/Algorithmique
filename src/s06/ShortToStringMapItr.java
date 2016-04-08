package s06;

public class ShortToStringMapItr {
	ShortToStringMap m;
	short key;

	// ----------------------------------------
	public ShortToStringMapItr(ShortToStringMap m) {
		this.m = m;
		key = 0;
	}

	// ----------------------------------------
	public boolean hasMoreKeys() {
		if (m.get((short) (key+1)) != null)
			return true;
		else
			return false; 
	}

	// ----------------------------------------
	// PRE-condition: hasMoreKeys()
	public short nextKey() {
		if (hasMoreKeys())
			return ++key;
		else
			return 0;
	}
}
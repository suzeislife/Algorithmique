package s12;

public class BitSetOfShortsItr {
	BitSetOfShorts theSet;
	int next;

	// ------------------------------------------------------------
	public BitSetOfShortsItr(BitSetOfShorts theSet) {
		this.theSet = theSet;
		next = 0;
	}

	public boolean hasMoreElements() {
		if (theSet.bs.get(next + 1))
			return true;
		return false; // TODO - A COMPLETER...
	}

	public short nextElement() {
		if (hasMoreElements())
			return (short) ++next;
		return 0;
	}

}
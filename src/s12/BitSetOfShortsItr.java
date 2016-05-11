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
		if (theSet.bs.nextSetBit(next)>=0)
			return true;
		return false;
	}

	public short nextElement() {
		if (hasMoreElements()){
			next = theSet.bs.nextSetBit(next);
			return  theSet.eltFromIndex(next);
		}
		return 0;
	}

}
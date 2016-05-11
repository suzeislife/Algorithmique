package s12;

public class BitSetOfShortsItr {
	BitSetOfShorts theSet;
	int next;

	// ------------------------------------------------------------
	public BitSetOfShortsItr(BitSetOfShorts theSet) {
		this.theSet = theSet;
		next = -1;
	}

	public boolean hasMoreElements() {
		if (theSet.bs.nextSetBit(next+1)>=0)
			return true;
		return false;
	}

	public short nextElement() {
		if (hasMoreElements()){
			next = theSet.bs.nextSetBit(next+1);
			return  BitSetOfShorts.eltFromIndex(next);
		}
		next = Integer.MAX_VALUE;
		return 0;
	}

}
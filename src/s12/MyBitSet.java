package s12;

public class MyBitSet {
	// ------------------------------------------------------------
	private int[] buffer;
	private static final short NB_OF_BITS = 32;

	// ------------------------------------------------------------
	public MyBitSet() {
		this(100);
	}

	// ------------------------------------------------------------
	public MyBitSet(int capacity) {
		buffer = new int[1 + (capacity / NB_OF_BITS)];
	}

	// ------------------------------------------------------------
	public void set(int bitIndex, boolean value) { // bitIndex >= 0
		int indexTable = bitIndex / NB_OF_BITS;
		checkSize(indexTable);
		int mask = 1;
		mask = mask << (bitIndex % NB_OF_BITS);
		if (value) {
			buffer[indexTable] |= mask;
		} else {
			mask = ~mask;
			buffer[indexTable] &= mask;
		}
	}

	// ------------------------------------------------------------
	public void set(int bitIndex) {
		set(bitIndex, true);
	}

	// ------------------------------------------------------------
	public void clear(int bitIndex) {
		set(bitIndex, false);
	}

	// ------------------------------------------------------------
	// ------------------------------------------------------------
	// ensures that that array cell exists
	// (re-dimensions the array if necessary)
	private void checkSize(int arrayIndex) {
		if (arrayIndex < buffer.length)
			return;
		int f = 1 + arrayIndex / buffer.length;
		int[] aux = new int[f * buffer.length]; // or new int[arrayIndex+1] if
		for (int j = 0; j < buffer.length; j++) // we choose the minimal size
			aux[j] = buffer[j];
		buffer = aux;
		assert arrayIndex < buffer.length;
	}

	// ------------------------------------------------------------
	public boolean get(int bitIndex) {
		int indexTable = bitIndex / NB_OF_BITS;
		checkSize(indexTable);
		int nb = buffer[indexTable] >> (bitIndex % NB_OF_BITS);
		nb &= 1;
		if (nb == 1)
			return true;
		else
			return false;
	}

	// ------------------------------------------------------------
	public void and(MyBitSet o) {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] &= o.buffer[i];
		}
	}

	// ------------------------------------------------------------
	public void or(MyBitSet o) {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] |= o.buffer[i];
		}
	}

	// ------------------------------------------------------------
	public void xor(MyBitSet o) {
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] ^= o.buffer[i];
		}
	}

	// ------------------------------------------------------------
	public int size() { // crt capacity, total nb of bits
		return buffer.length * NB_OF_BITS;
	}

	// ------------------------------------------------------------
	public int length() { // highest bit "on" + 1
		int n = 0;
		for (int i = 0; i < buffer.length * NB_OF_BITS; i++)
			if (get(i))
				n = i + 1;
		return n;
	}

	// ------------------------------------------------------------
	public int nextSetBit(int fromIndex) { // -1 if none
		for (int i = fromIndex; i < buffer.length * NB_OF_BITS; i++) {
			if (this.get(i))
				return i;
		}
		return -1;
	}

	// ------------------------------------------------------------
	public int cardinality() { // nb of bits set to true
		int compteur = 0;
		int index = 0;
		for (int i = 0; i < length(); i++) {
			if (get(i))
				compteur++;
		}
		return compteur;
	}

	// ------------------------------------------------------------
	public String toString() {
		String r = "{";
		for (int i = 0; i < buffer.length * NB_OF_BITS; i++)
			if (get(i))
				if (r.length() == 1)
					r += i;
				else
					r += "," + i;
		return r + "}";
	}

	// ------------------------------------------------------------
	public static void main(String[] args) {
		MyBitSet a = new MyBitSet(100);
		ok(a.length() == 0);
		System.out.println(a.toString());
		a.set(4);
		ok(a.get(4));
		ok(!a.get(3));
		a.clear(4);
		a.clear(5);
		a.set(6);
		ok(!a.get(4));
		ok(a.get(6));
		ok(!a.get(5));
		System.out.println(a);
	}

	// ------------------------------------------------------------
	static void ok(boolean b) {
		if (b)
			return;
		throw new RuntimeException("property not verified: ");
	}
}
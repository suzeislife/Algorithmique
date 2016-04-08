package s06;

import java.util.Random;
import java.util.TreeMap;

// ------------------------------------------------------------
public class ShortToStringMapTest {
	static class S2SMap {
		TreeMap<Short, String> t = new TreeMap<Short, String>();

		// ------------------------------------------------------------
		public S2SMap() {
		}

		public void put(short key, String img) {
			t.put(key, img);
		}

		public String get(short key) {
			return t.get(key);
		}

		public void remove(short e) {
			t.remove(e);
		}

		public boolean containsKey(short k) {
			return t.containsKey(k);
		}

		public boolean isEmpty() {
			return size() == 0;
		}

		public int size() {
			return t.size();
		}

		public void union(S2SMap m) {
			t.putAll(m.t);
		}

		// ------------------------------------------------------------
		public void intersection(S2SMap s) {
			S2SMap a = new S2SMap();
			for (short e : s.t.keySet()) {
				if (containsKey(e))
					a.put(e, s.get(e));
			}
			t = a.t;
		}
	}

	// ------------------------------------------------------------
	// ------------------------------------------------------------
	// ------------------------------------------------------------
	static void rndAddRm(Random r, ShortToStringMap s, S2SMap g) {
		short i = (short) (r.nextInt(10000));
		if (r.nextBoolean()) {
			String v = "" + r.nextInt(10);
			s.put(i, v);
			g.put(i, v);
		} else {
			s.remove(i);
			g.remove(i);
		}
	}

	// ------------------------------------------------------------
	static boolean areSetEqual(ShortToStringMap s, S2SMap g) {
		int l = 0;
		short lastKey = 10;
		if (g.size() > 0)
			lastKey = g.t.lastKey();
		for (short i = 0; i <= lastKey; i++) {
			if (g.containsKey(i) != s.containsKey(i)) {
				System.out.println("\nMap is : " + s);
				System.out.println("should be: " + g.t);
				System.out.println("Size: " + s.size());
				System.out.println("bad element : " + i);
				return false;
			}
			if (s.containsKey(i)) {
				l++;
				if (!s.get(i).equals(g.get(i))) {
					System.out.println("bad value for element: " + i);
					return false;
				}
			}
		}
		if (l != s.size()) {
			System.out.println("\nMap is : " + s);
			System.out.println("should be: " + g.t);
			System.out.println("Size: " + s.size() + " " + g.size());
			System.out.println("too much elements...");
			return false;
		}
		return true;
	}

	public static void testUnion(int nOperations, Random r) {
		int n = nOperations;
		while (n-- > 0) {
			ShortToStringMap s1 = new ShortToStringMap();
			ShortToStringMap s2 = new ShortToStringMap();
			S2SMap bs1 = new S2SMap();
			S2SMap bs2 = new S2SMap();
			manyAddRm(s1, bs1, r, r.nextInt(nOperations));
			manyAddRm(s2, bs2, r, r.nextInt(nOperations));
			s1.union(s2);
			bs1.union(bs2);
			if (!areSetEqual(s1, bs1))
				throw new RuntimeException("Error in union !");
		}
	}

	public static void testIntersection(int nOperations, Random r) {
		int n = nOperations;
		while (n-- > 0) {
			ShortToStringMap s1 = new ShortToStringMap();
			ShortToStringMap s2 = new ShortToStringMap();
			S2SMap bs1 = new S2SMap();
			S2SMap bs2 = new S2SMap();
			manyAddRm(s1, bs1, r, r.nextInt(nOperations));
			manyAddRm(s2, bs2, r, r.nextInt(nOperations));
			s1.intersection(s2);
			bs1.intersection(bs2);
			if (!areSetEqual(s1, bs1))
				throw new RuntimeException("Error in intersection !");
		}
	}

	private static void manyAddRm(ShortToStringMap s, S2SMap bs, Random r, int nOperations) {
		while (nOperations-- > 0)
			rndAddRm(r, s, bs);
	}

	public static void testAddRm(ShortToStringMap s, S2SMap bs, Random r, int nOperations) {
		int i = 0;
		for (i = 0; i < 10; i++) {
			if (!areSetEqual(s, bs))
				throw new RuntimeException("Error in add/remove/contains !");
			rndAddRm(r, s, bs);
		}
		while (nOperations-- > 0) {
			rndAddRm(r, s, bs);
			if (!areSetEqual(s, bs))
				break;
		}
		if (!areSetEqual(s, bs))
			throw new RuntimeException("Error in add/remove/contains !");
	}

	public static void testItr(ShortToStringMap s) {
		// ---- test itr
		int x = 0;
		ShortToStringMap s2 = new ShortToStringMap();
		ShortToStringMapItr ai = new ShortToStringMapItr(s);
		short e = 0;
		while (ai.hasMoreKeys()) {
			e = ai.nextKey();
			x++;
			s2.put(e, "");
			if (!s.containsKey(e))
				throw new RuntimeException("oups ! The iterator gives an absent elt");
		}
		if (x != s.size() && x != s2.size())
			throw new RuntimeException("Error in iterator !");
	}

	// ------------------------------------------------------------
	// testSet : Simple test method for the Set specification.
	// It verifies that an arbitrary sequence of add/remove
	// results in a correct set.
	// It verifies the union and the intersection
	// prm : n determines the number of operations (try e.g. 500)

	public static void testSet(Random r, int n, boolean withMsg) {
		ShortToStringMap s = new ShortToStringMap();
		S2SMap bs = new S2SMap();
		testAddRm(s, bs, r, n);
		if (withMsg)
			System.out.println("Add/remove seems OK ");
		testItr(s);
		if (withMsg)
			System.out.println("Iterator seems OK ");
		testUnion(n, r);
		if (withMsg)
			System.out.println("Union seems OK ");
		testIntersection(n, r);
		if (withMsg)
			System.out.println("Intersection seems OK ");
	}

	// ------------------------------------------------------------
	// ------------------------------------------------------------
	public static void main(String[] args) {
		int testIntensity = 300;
		Random r = new Random();
		long seed = r.nextInt(1000);
		r.setSeed(seed);
		System.out.println("Using seed " + seed);
		testSet(r, testIntensity, true);
		for (int i = 0; i < 20; i++)
			testSet(r, 20, false);
		System.out.println("\nTest passed successfully !");
	}
}
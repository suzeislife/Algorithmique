package s06;
import java.util.BitSet;
import java.util.Random;

public class SetOfShortsTest{

  static void rndAddRm(Random r, SetOfShorts s, BitSet bs) {
    int i=r.nextInt(1000);
    if (r.nextBoolean()) {
      s.add( (short) i);
      bs.set(i);
    } else {
      s.remove( (short) i);
      bs.clear(i);
    }
  }

  static boolean areSetEqual(SetOfShorts s, BitSet bs) {
    int l = 0;
    for (int i=0; i<bs.length(); i++) {
      if(bs.get(i) != s.contains( (short) i)) {
        System.out.println("\nSetOf : " + s);
        System.out.println("BitSet: " + bs);
        System.out.println("Size: " + s.size());
        System.out.println("conflicting element : " + i);
        return false;
      }
      if (s.contains( (short) i))
        l++;
    }
    if (l != s.size()) {
      System.out.println("\nSetOf : " + s);
      System.out.println("BitSet: " + bs);
      System.out.println("Size: " + s.size());
      System.out.println("bad size...");
      return false;
    }
    return true;
  }
  
  public static void testUnion(int nOperations, Random r) {
    int n=nOperations;
    while(n-- >0) {
      SetOfShorts s1 = new SetOfShorts();
      SetOfShorts s2 = new SetOfShorts();
      BitSet bs1 = new BitSet();
      BitSet bs2 = new BitSet();
      manyAddRm(s1, bs1, r, r.nextInt(nOperations));
      manyAddRm(s2, bs2, r, r.nextInt(nOperations));
      s1.union(s2);
      bs1.or(bs2);
      if (!areSetEqual(s1, bs1))
        throw new RuntimeException("Error in union !");
    }
  }
  
  public static void testIntersection(int nOperations, Random r) {
    int n=nOperations;
    while(n-- >0) {
      SetOfShorts s1 = new SetOfShorts();
      SetOfShorts s2 = new SetOfShorts();
      BitSet bs1 = new BitSet();
      BitSet bs2 = new BitSet();
      manyAddRm(s1, bs1, r, r.nextInt(nOperations));
      manyAddRm(s2, bs2, r, r.nextInt(nOperations));
      s1.intersection(s2);
      bs1.and(bs2);
      if (!areSetEqual(s1, bs1))
        throw new RuntimeException("Error in intersection !");
    }
  }
  
  private static void manyAddRm(SetOfShorts s, BitSet bs, Random r, int nOperations) {
    while(nOperations-- >0)
      rndAddRm(r, s, bs);
  }
  
  public static void testAddRm(SetOfShorts s, BitSet bs, Random r, int nOperations) {
    int i = 0;
    for (i = 0; i < 10; i++) {
      if (!areSetEqual(s, bs))
        throw new RuntimeException("Error in add/remove/contains !");
      rndAddRm(r, s, bs);
    }
    while(nOperations-- >0) {
      rndAddRm(r, s, bs);
      if (!areSetEqual(s, bs))
        break;
    }
    if (!areSetEqual(s, bs))
      throw new RuntimeException("Error in add/remove/contains !");
  }
  
  public static void testItr(SetOfShorts s) {
    // ---- test itr
    int x = 0;
    SetOfShorts s2 = new SetOfShorts();
    SetOfShortsItr ai = new SetOfShortsItr(s);
    short e = 0;
    while (ai.hasMoreElements()) {
      e = ai.nextElement();
      x++;
      s2.add(e);
      if (!s.contains(e))
        throw new RuntimeException("oups ! The iterator gives an absent elt");
    }
    if (x != s.size() && x != s2.size())
      throw new RuntimeException("Error in iterator !");
  }
  
  // ------------------------------------------------------------
  // testSet : Simple test method for the Set specification.
  //           It verifies that an arbitrary sequence of add/remove
  //           results in a correct set.
  //           It verifies the union and intersection methods
  //     prm : n determines the number of operations (try e.g. 500)
  
  public static void testSet(Random r, int n, boolean withMsg) {
    SetOfShorts s = new SetOfShorts();
    BitSet bs = new BitSet();
    testAddRm(s, bs, r, n);
    if (withMsg) System.out.println("Add/remove seems OK ");
    testItr(s);
    if (withMsg) System.out.println("Iterator seems OK ");
    testUnion(n, r);
    if (withMsg) System.out.println("Union seems OK ");
    testIntersection(n, r);
    if (withMsg) System.out.println("Intersection seems OK ");
  }
  //------------------------------------------------------------
  // ------------------------------------------------------------
  public static void main(String[] args) {
    int testIntensity = 500;
    Random r = new Random();
    long seed = r.nextInt(1000);
    r.setSeed(seed);
    System.out.println("Using seed "+seed);
    testSet(r, testIntensity, true);
    for(int i=0; i<20; i++)
      testSet(r, 20, false);
    System.out.println("\nTest passed successfully !");
  }
}
package s12;
import java.util.BitSet;

public class BitSetOfShorts {
  final BitSet bs;
  static final short LOW  = Short.MIN_VALUE;
  static final short HIGH = Short.MAX_VALUE;
  // ------------------------------------------------------------
  static int   indexFromElt(short e) {
    return 0; // TODO - A COMPLETER...  
  }
  static short eltFromIndex(int i)   {
    return 0; // TODO - A COMPLETER...  
  }
  // ------------------------------------------------------------
  public BitSetOfShorts ()  { 
    bs = new BitSet(); // or: new BitSet(1 + HIGH - LOW); 
  }
  // ------------------------------------------------------------
  public void    add     (short e) {
    // TODO - A COMPLETER...
  } 
  public void    remove  (short e) {
     // TODO - A COMPLETER...
  } 
  public boolean contains(short e) {
     return false; // TODO - A COMPLETER...
  } 
  // ------------------------------------------------------------
  public void    union       (BitSetOfShorts s) {
    // TODO - A COMPLETER...
  } 
  public void    intersection(BitSetOfShorts s) {
    // TODO - A COMPLETER...
  } 
  // ------------------------------------------------------------
  public int     size() {
    return 0; // TODO - A COMPLETER...
  } 
  // ------------------------------------------------------------
  public boolean isEmpty() { return bs.length() == 0;}
  // ------------------------------------------------------------
  public String toString() { 
    String r = "{";
    BitSetOfShortsItr itr = new BitSetOfShortsItr(this);
    if (isEmpty()) return "{}";
    r += itr.nextElement();
    while (itr.hasMoreElements()) {
      r += ", " + itr.nextElement();
    }
    return r + "}";
  }
  // ------------------------------------------------------------
  // ------------------------------------------------------------
  public static void main(String [] args) {
    BitSetOfShorts a = new BitSetOfShorts();
    BitSetOfShorts b = new BitSetOfShorts();
    short [] ta = {-3, 5, 6, -3, 9, 9};
    short [] tb = {6, 7, -2, -3};
    int i;
    for (i=0; i<ta.length; i++) {
      a.add(ta[i]);
      System.out.println(""+a+ a.size());
    }
    for (i=0; i<tb.length; i++) {
      b.add(tb[i]);
      System.out.println(""+b+ b.size());
    }
    a.union(b);
    System.out.println(""+a+ a.size());
  }
}
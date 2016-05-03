package s12;
public class MyBitSet {
  // ------------------------------------------------------------
  private int [] buffer;
  private static final short NB_OF_BITS = 32;
  // ------------------------------------------------------------
  public MyBitSet()             { this(100); }
  // ------------------------------------------------------------
  public MyBitSet(int capacity) {
    buffer = new int[1+(capacity/NB_OF_BITS)];
  }
  // ------------------------------------------------------------
  public void    set  (int bitIndex, boolean value) {  // bitIndex >= 0
    // TODO - A COMPLETER...
  }
  // ------------------------------------------------------------
  public void    set  (int bitIndex) { set(bitIndex, true);   }
  // ------------------------------------------------------------
  public void    clear(int bitIndex) { set(bitIndex, false);  }
  // ------------------------------------------------------------
  // ------------------------------------------------------------
  // ensures that that array cell exists 
  // (re-dimensions the array if necessary)
  private void checkSize(int arrayIndex) {
    if (arrayIndex<buffer.length) return;
    int f = 1+arrayIndex/buffer.length;
    int [] aux = new int [f*buffer.length]; // or new int[arrayIndex+1] if 
    for (int j=0; j<buffer.length; j++)     // we choose the minimal size
      aux[j]=buffer[j];
    buffer=aux;
    assert arrayIndex<buffer.length;
  }
  // ------------------------------------------------------------
  public boolean get  (int bitIndex) {
    return false; // TODO - A COMPLETER...
  }
  // ------------------------------------------------------------
  public void    and(MyBitSet o) {
    // TODO - A COMPLETER...
  }
  // ------------------------------------------------------------
  public void    or (MyBitSet o) {
    // TODO - A COMPLETER...
  }
  // ------------------------------------------------------------
  public void    xor(MyBitSet o) {
    // TODO - A COMPLETER...
  }
  // ------------------------------------------------------------
  public int     size() { // crt capacity, total nb of bits
    return buffer.length * NB_OF_BITS;
  }
  // ------------------------------------------------------------
  public int     length() { // highest bit "on" + 1
    int n = 0;
    for(int i=0; i<buffer.length * NB_OF_BITS; i++)
      if (get(i)) n = i+1; 
    return n;
  }
  // ------------------------------------------------------------
  public int     nextSetBit(int fromIndex) {  // -1 if none
    return 0; // TODO - A COMPLETER...
  }
  // ------------------------------------------------------------
  public int     cardinality() {  // nb of bits set to true
    return 0; // TODO - A COMPLETER...
  }
  // ------------------------------------------------------------
  public String toString() {
    String r = "{";
    for(int i=0; i<buffer.length * NB_OF_BITS; i++)
      if (get(i)) 
        if(r.length()==1) r+= i;
        else r+= ","+i;
    return r+"}";
  }
  // ------------------------------------------------------------
  public static void main (String [] args) {
    MyBitSet a = new MyBitSet(100);
    ok(a.length()==0);
    System.out.println(a);
    a.set(4);
    ok(a.get(4));
    ok(!a.get(3));
    a.clear(4);a.clear(5);
    a.set(6);
    ok(!a.get(4));
    ok(a.get(6));
    ok(!a.get(5));
    System.out.println(a);
  }
  // ------------------------------------------------------------
  static void ok(boolean b) {
    if (b) return;
    throw new RuntimeException("property not verified: ");
  }
}
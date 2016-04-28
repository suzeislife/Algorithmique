package s11;

import java.util.Random;

// ======================================================================
public class IntQueueArray {
  private int[] buffer = new int[10];
  private int   front  = 1;
  private int   back   = 0;
  private int   size   = 0;

  // ------------------------------
  public IntQueueArray() {
  }

  // ------------------------------
  public void enqueue(int elt) {
    checkSize();
    back++;
    if (back == buffer.length)
      back = 0;
    buffer[back] = elt;
    size++;
  }

  // ------------------------------
  public boolean isEmpty() {
    return size == 0;
  }

  // ------------------------------
  // PRE: !isEmpty()
  public int consult() {
    return buffer[front];
  }

  // ------------------------------
  // PRE: !isEmpty()
  public int dequeue() {
    front++;
    if(front == buffer.length)
      front = 0;
    return front;
  }

  // ------------------------------
  private void checkSize() {
    boolean checkBuffer = false;
    if (size < buffer.length)
      return;
    if(front-1 == back && size != 0 || front== 0 && back == size-1){
      int[] bufferTmp = new int[size*2];
      while(checkBuffer){
        
      }
    }
      
  }

  // ======================================================================
  public static void main(String[] args) {
    int n = 1000000;
    if (args.length == 1)
      n = Integer.parseInt(args[0]);
    Random r = new Random();
    long seed = r.nextInt(1000);
    r.setSeed(seed);
    System.out.println("Using seed " + seed);
    IntQueueArray q = new IntQueueArray();
    int m = 0;
    int k = 0;
    int p = 0;
    for (int i = 0; i < n; i++) {
      boolean doAdd = r.nextBoolean();
      if (doAdd) {
        k++;
        q.enqueue(k);
        ok(!q.isEmpty(), "should be non-empty " + m + " " + k + " " + p + "\n");
        m++;
        // System.out.print("a("+k+")");
      } else {
        if (m == 0) {
          ok(q.isEmpty(), "should be empty " + m + " " + k + " " + p + "\n");
        } else {
          ok(!q.isEmpty(),
              "should be non-empty " + m + " " + k + " " + p + "\n");
          int e = q.dequeue();
          // System.out.print("r("+e+")");
          m--;
          ok(e == p + 1, "not FIFO " + m + " " + k + " " + p + "\n");
          p++;
        }
      }
    }
    System.out.println("Test passed successfully");
  }

  // ------------------------------------------------------------
  static void ok(boolean b, String s) {
    if (b)
      return;
    throw new RuntimeException("property not verified: " + s);
  }
}
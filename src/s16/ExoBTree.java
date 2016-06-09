package s16;

import java.util.Random;

import java.util.Queue;
import java.util.LinkedList;

public class ExoBTree {
  // ------------------------------------------------------------
  public static String breadthFirst(BTNode t) {
    String res = "";
    Queue<BTNode> q = new LinkedList<BTNode>();
    q.add(t);
    while (!q.isEmpty()) {
      BTNode crt = q.remove();
      if (crt == null)
        continue;
      res += (" " + crt.elt);
      q.add(crt.left);
      q.add(crt.right);
    }
    return res;
  }

  // ------------------------------------------------------------
  public static int size(BTNode t) {
    if (t == null)
      return 0;
    return size(t.left) + size(t.right) + 1;
  }

  // ------------------------------------------------------------
  public static int height(BTNode t) {
    if (t == null)
      return 0;
    return Math.max(height(t.left), height(t.right)) + 1;
  }

  // ------------------------------------------------------------
  public static String breadthFirst1(BTNode t) {
    String valeur = "";
    int levelMax = height(t);
    for (int i = 0; i <= levelMax; i++) {
      valeur += visitLevel(t, i);
    }
    return valeur;
  }

  // ------------------------------------------------------------
  public static String visitLevel(BTNode t, int level) {
    if (t == null) {
      return "";
    } else if (level == 0) {
      return t.elt.toString();
    }
    return visitLevel(t.left, level - 1) + visitLevel(t.right, level - 1);
  }

  // ------------------------------------------------------------
  public static void depthFirst(BTNode t) {
    if (t == null)
      return;
    System.out.print(" " + t.elt);
    depthFirst(t.left);
    depthFirst(t.right);
  }

  // ------------------------------------------------------------
  public static void rotateRight(BTNode y) {
    BTNode a = y.left;
    BTNode b = y.right;
    BTNode c = a.right;
    if (a != null && b != null) {
      b = y;
      y = a;
      b.left = c;
    }
  }

  // ------------------------------------------------------------
  // ------------------------------------------------------------
  // ------------------------------------------------------------
  private static Random rnd = new Random();

  // ------------------------------------------------------------
  public static BTNode rndTree(int size) {
    if (size == 0)
      return null;
    BTNode root = new BTNode(new Integer(0), null, null, null);
    BTNode t = root;
    boolean isLeft;
    for (int i = 1; i < size; i++) {
      t = root;
      while (true) {
        isLeft = rnd.nextBoolean();
        if (isLeft) {
          if (t.left == null)
            break;
          t = t.left;
        } else {
          if (t.right == null)
            break;
          t = t.right;
        }
      }
      BTNode newLeaf = new BTNode(new Integer(i), null, null, t);
      if (isLeft)
        t.left = newLeaf;
      else
        t.right = newLeaf;
    }
    return root;
  }

  // ------------------------------------------------------------
  public static void main(String[] args) {
    int nbOfNodes = 10;
    BTNode t = rndTree(nbOfNodes);
    System.out.println("Tree:" + t);
    System.out.println(t.toReadableString());
    System.out.println("\nDepth first (recursive), preorder:");
    depthFirst(t);
    System.out.println("\nBreadth first:");
    System.out.println(breadthFirst(t));
    System.out.println("\nBreadth first bis:");
    System.out.println(breadthFirst1(t));
    System.out.println("\nSize:" + size(t));
    System.out.println("\nHeight:" + height(t));
  }
  // ------------------------------------------------------------
}

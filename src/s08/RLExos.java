package s08;

public class RLExos {
  // ----------------------------------------------------------------
  // --- Exercices, Série 8 :
  // ----------------------------------------------------------------
  public static CharRecList append(CharRecList l, char e) {
    if (l.isEmpty())
      return l.withHead(e);
    return append(l.tail(), e).withHead(l.head());
  }

  // ----------------------------------------------------------------
  public static CharRecList concat(CharRecList l, CharRecList r) {
    if (l.isEmpty())
      return r;
    return concat(l.tail(), r).withHead(l.head());
  }

  // ----------------------------------------------------------------
  public static CharRecList replaceEach(CharRecList l, char old, char by) {
    if (l.isEmpty())
      return l;
    if (l.head() == old)
      return replaceEach(l.tail(), old, by).withHead(by);

    return replaceEach(l.tail(), old, by).withHead(l.head());
  }

  // ----------------------------------------------------------------
  public static char consultAt(CharRecList l, int index) {
    if (index == 0)
      return l.head();
    return consultAt(l.tail(), index - 1);
  }

  // ----------------------------------------------------------------
  public static boolean isEqual(CharRecList l, CharRecList o) {
    if (l.isEmpty() && o.isEmpty())
      return true;
    if (l.head() != o.head())
      return false;
    return isEqual(l.tail(), o.tail());
  }

  // ----------------------------------------------------------------
  public static boolean isSuffix(CharRecList l, CharRecList suff) {
    if (sizeOf(l) == sizeOf(suff)) {
      return isEqual(l, suff);
    } else {
      return isSuffix(l.tail(), suff);
    }
  }

  // ----------------------------------------------------------------
  // --- Exemples du cours :
  // ----------------------------------------------------------------
  public static int sizeOf(CharRecList l) {
    if (l.isEmpty())
      return 0;
    return 1 + sizeOf(l.tail());
  }

  // ----------------------------------------------------------------
  public static CharRecList inverse(CharRecList l) {
    if (l.isEmpty())
      return l;
    return append(inverse(l.tail()), l.head());
  }

  // ----------------------------------------------------------------
  public static boolean isMember(CharRecList l, char e) {
    if (l.isEmpty())
      return false;
    if (e == l.head())
      return true;
    return isMember(l.tail(), e);
  }

  // ----------------------------------------------------------------
  public static CharRecList smaller(CharRecList l, char e) {
    if (l.isEmpty())
      return l;
    if (l.head() < e)
      return smaller(l.tail(), e).withHead(l.head());
    return smaller(l.tail(), e);
  }

  // ----------------------------------------------------------------
  public static CharRecList greaterOrEqual(CharRecList l, char e) {
    if (l.isEmpty())
      return l;
    if (l.head() < e)
      return greaterOrEqual(l.tail(), e);
    return greaterOrEqual(l.tail(), e).withHead(l.head());
  }

  // ----------------------------------------------------------------
  public static CharRecList quickSort(CharRecList l) {
    CharRecList left, right;
    if (l.isEmpty())
      return l;
    left = smaller(l.tail(), l.head());
    right = greaterOrEqual(l.tail(), l.head());
    left = quickSort(left);
    right = quickSort(right);
    return concat(left, right.withHead(l.head()));
  }

  // ----------------------------------------------------------------
  // ----------------------------------------------------------------
  // ----------------------------------------------------------------
  public static void main(String[] args) {
    CharRecList l = CharRecList.EMPTY_LIST;
    CharRecList m = CharRecList.EMPTY_LIST;
    l = l.withHead('c').withHead('d').withHead('a').withHead('b');
    m = m.withHead('t').withHead('u').withHead('v');

    System.out.println("list l : " + l);
    System.out.println("list m : " + m);

    System.out.println("quickSort(l) : " + quickSort(l));
    System.out.println("append(l,'z') : " + append(l, 'z'));
    System.out.println("concat(l,m) : " + concat(l, m));
    System.out.println("replaceEach(l,'a','z') : " + replaceEach(l, 'a', 'z'));
    System.out.println("consultAt(l,2) : " + consultAt(l, 2));
    // ...
  }

}
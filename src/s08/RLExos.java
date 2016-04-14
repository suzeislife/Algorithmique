package s08;
public class RLExos {
  //----------------------------------------------------------------
  //--- Exercices, Série 8 :
  //----------------------------------------------------------------
  public static CharRecList append(CharRecList l, char e) {
     return null; // TODO...
  }
  //----------------------------------------------------------------
  public static CharRecList concat(CharRecList l, CharRecList r) {
    return null; // TODO...
  }
  //----------------------------------------------------------------
  public static CharRecList replaceEach(CharRecList l, char old, char by) {
    return null; // TODO...
  }
  //----------------------------------------------------------------
  public static char consultAt(CharRecList l, int index) {
    return 'a'; // TODO...
  }
  //----------------------------------------------------------------
  public static boolean isEqual(CharRecList l, CharRecList o) {
    return false; // TODO...
  }
  //----------------------------------------------------------------
  public static boolean isSuffix(CharRecList l, CharRecList suff) {
    return false; // TODO...
  }

  //----------------------------------------------------------------
  //--- Exemples du cours :
  //----------------------------------------------------------------
  public static int sizeOf(CharRecList l) {
    if (l.isEmpty()) 
      return 0;
    return 1 + sizeOf(l.tail());
  }
  //----------------------------------------------------------------
  public static CharRecList inverse(CharRecList l) {
    if (l.isEmpty()) 
      return l;
    return append(inverse(l.tail()), l.head());
  }
  //----------------------------------------------------------------
  public static boolean isMember(CharRecList l, char e) {
    if (l.isEmpty()) 
      return false;
    if (e == l.head())
      return true;
    return isMember(l.tail(), e);
  }
  //----------------------------------------------------------------
  public static CharRecList smaller(CharRecList l, char e) {
    if (l.isEmpty()) 
      return l;
    if ( l.head() < e )
      return smaller(l.tail(), e).withHead(l.head());
    return smaller(l.tail(), e);
  }
  //----------------------------------------------------------------
  public static CharRecList greaterOrEqual(CharRecList l, char e) {
    if (l.isEmpty()) 
      return l;
    if ( l.head() < e )
      return greaterOrEqual(l.tail(), e);
    return greaterOrEqual(l.tail(), e).withHead(l.head());
  }
  //----------------------------------------------------------------
  public static CharRecList quickSort(CharRecList l) {
    CharRecList left, right;
    if (l.isEmpty()) 
      return l;
    left  =        smaller(l.tail(), l.head());
    right = greaterOrEqual(l.tail(), l.head());
    left  = quickSort(left);
    right = quickSort(right);
    return concat(left, right.withHead(l.head()));
  }
  //----------------------------------------------------------------
  //----------------------------------------------------------------
  //----------------------------------------------------------------
  public static void main(String [] args) {
    CharRecList l = CharRecList.EMPTY_LIST;
    CharRecList m = CharRecList.EMPTY_LIST;
    l = l.withHead('c').withHead('d').withHead('a').withHead('b');
    m = m.withHead('t').withHead('u').withHead('v');

    System.out.println("list l : "+ l);
    System.out.println("list m : "+ m);

    System.out.println( "quickSort(l) : "+           quickSort(l)   );
    System.out.println( "append(l,'z') : "+          append(l,'z')  );
    System.out.println( "concat(l,m) : "+            concat(l,m)    );
    System.out.println( "replaceEach(l,'a','z') : "+ replaceEach(l,'a','z') );
    System.out.println( "consultAt(l,2) : "+         consultAt(l,2) );
    //...
  }


}
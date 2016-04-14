package s09;

public class FindsBugs {

<<<<<<< HEAD
  public static void main(String[] args) {
    if (!findsBug01())
      System.out.println("01 NO ERROR");
    else
      System.out.println("01 ERROR");
    if (!findsBug02())
      System.out.println("02 NO ERROR");
    else
      System.out.println("02 ERROR");
    if (!findsBug03())
      System.out.println("03 NO ERROR");
    else
      System.out.println("03 ERROR");
    if (!findsBug04())
      System.out.println("04 NO ERROR");
    else
      System.out.println("04 ERROR");
  }
=======
	public static void main(String[] args) {
		if (!findsBug01())
			System.out.println("01 NO ERROR");
		else
			System.out.println("01 ERROR");
		if (!findsBug02())
			System.out.println("02 NO ERROR");
		else
			System.out.println("02 ERROR");
		if (!findsBug03())
			System.out.println("03 NO ERROR");
		else
			System.out.println("03 ERROR");
		if (!findsBug04())
			System.out.println("04 NO ERROR");
		else
			System.out.println("04 ERROR");
	}
>>>>>>> 2eed945f2302d4ca88baf428e179a9d1175b0796

  static boolean findsBug01() {
    IntStack s = new IntStack(10);
    s.push(0);
    if (s.pop() != 0)
      return true;
    if (!s.isEmpty())
      return true;
    return false;
  }

  static boolean findsBug02() {
    IntStack s = new IntStack(10);
    s.push(0);
    s.push(1);
    if (s.isEmpty())
      return true;
    return false;
  }

<<<<<<< HEAD
  static boolean findsBug03() {
    IntStack s = new IntStack(10);
    s.push(0);
    s.push(5);
    s.pop();
    s.push(1);
    if (s.pop() != 1)
      return true;
    if (s.isEmpty())
      return true;
    return false;
  }

  static boolean findsBug04() {
    IntStack s1 = new IntStack(10);
    IntStack s2 = new IntStack(10);
    s1.push(50);
    s2.push(10);
    if (s1.top() != 50)
      return true;
    if (s1.pop() != 50)
      return true;
    if (!s1.isEmpty())
      return true;
    return false;
  }
=======
	static boolean findsBug03() {
		IntStack s = new IntStack(10);
		s.push(0);
		s.push(5);
		s.pop();
		s.push(1);
		if (s.pop() != 1)
			return true;
		if (s.isEmpty())
			return true;
		return false;
	}

	static boolean findsBug04() {
		IntStack s1 = new IntStack(10);
		IntStack s2 = new IntStack(10);
		s1.push(50);
		s2.push(10);
		if (s1.top() != 50)
			return true;
		if (s1.pop() != 50)
			return true;
		if (!s1.isEmpty())
			return true;
		return false;
	}
>>>>>>> 2eed945f2302d4ca88baf428e179a9d1175b0796
}

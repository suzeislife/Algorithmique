package s07;

public class minimumOnTab {

	public static void main(String[] args) {
		int[] t = { 4, 3, 2, 6, 8, 7, 5, 3, 7, 1, 3 };
		System.out.println("Version 1");
		System.out.println(minOnTabV1(t));
		System.out.println("Version 2");
		System.out.println(minOnTabV2(t));
	}

	// Méthode d'amorce Version 1
	public static int minOnTabV1(int[] t) {
		return minOnTabV1(t, Integer.MAX_VALUE, 1);
	}

	private static int minOnTabV1(int[] t, int min, int left) {
		if (left == t.length - 1)
			return min;
		if (t[left] < min)
			min = t[left];
		return minOnTabV1(t, min, ++left);
	}

	// Méthode d'amorce Version 2
	public static int minOnTabV2(int[] t) {
		return minOnTabV2(t, 0, t.length, Integer.MAX_VALUE);
	}

	static int min = Integer.MAX_VALUE;

	private static int minOnTabV2(int[] t, int left, int right, int min) {
		int mid = (left + right) / 2;
		if (right - left == 1)
			if (t[left] < min)
				return t[left];
			else
				return min;

		min = minOnTabV2(t, left, mid, min);
		min = minOnTabV2(t, mid, right, min);
		return min;
	}

}

package S04;

public class Sorting {
	public static void main(String[] args) {
		int[] t = { 4, 3, 2, 6, 8, 7 };
		int[] u = { 2, 3, 4, 6, 7, 8 };
		int[] x = { 4, 3, 2, 6, 2, 7 };
		int[] y = { 8, 3, 2, 6, 4, 7 };
		insertionSort(t);
		for (int i = 0; i < t.length; i++)
			if (t[i] != u[i]) {
				System.out.println("Something is wrong...");
				return;
			}
		int[] v = { 5 };
		insertionSort(v);
		int[] w = {};
		insertionSort(w);
		System.out.println("\nMini-test passed successfully...");
		System.out.println("Selection Sort");
		selectionSort(x);
		System.out.println("Shell Sort");
		shellSort(y);
	}

	// ------------------------------------------------------------
	public static void selectionSort(int[] a) {
		int savedValue;
		for (int j = 0; j < a.length; j++) {
			int plusPetiteValeur = j;
			for (int i = j; i < a.length; i++) {
				if (a[plusPetiteValeur] > a[i]) {
					plusPetiteValeur = i;
				}
			}
			// swap
			savedValue = a[plusPetiteValeur];
			a[plusPetiteValeur] = a[j];
			a[j] = savedValue;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	// ------------------------------------------------------------
	public static void shellSort(int[] a) {
		int k = 1;
		int savedValue;
		while (a.length > k) {
			if (a.length < 3 * k + 1)
				break;
			else
				k = 3 * k + 1;
		}
		while (k >= 1) {
			for (int j = 0; j < a.length; j++) {
				int plusPetiteValeur = j;
				for (int i = j; i < a.length; i = i + k) {
					if (a[plusPetiteValeur] > a[i]) {
						plusPetiteValeur = i;
					}
				}
				// swap
				savedValue = a[plusPetiteValeur];
				a[plusPetiteValeur] = a[j];
				a[j] = savedValue;
			}
			k = (k - 1) / 3;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}


	// ------------------------------------------------------------
	public static void insertionSort(int[] a) {
		int i, j, v;

		for (i = 1; i < a.length; i++) {
			v = a[i]; // v is the element to insert
			j = i;
			while (j > 0 && a[j - 1] > v) {
				a[j] = a[j - 1]; // move to the right
				j--;
			}
			a[j] = v; // insert the element
		}
	}
	// ------------------------------------------------------------
}
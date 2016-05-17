package s14;

public class PolynomThing {
	private final double[] coef;
	private final boolean isReducible;
	private final String name;

	public PolynomThing(double[] c, boolean red, String s) {
		int n = c.length;
		coef = new double[n];
		System.arraycopy(c, 0, coef, 0, n);
		isReducible = red;
		name = s;
	}

	@Override
	public int hashCode() {
		return 0;
		// A COMPLETER
	}

	public double getCoef(int i) {
		return coef[i];
	}

	public int degree() {
		return coef.length;
	}

	public String name() {
		return name;
	}

	public boolean isReducible() {
		return isReducible;
	}

	// -------------------------------------------
	public static void main(String[] args) {
		PolynomThing a = new PolynomThing(new double[] { 2, 3, 4 }, true, "foo");
		PolynomThing b = new PolynomThing(new double[] { 2, 3, 5 }, true, "bar");
		PolynomThing c = new PolynomThing(new double[] { 2, 3 }, true, "demo");
		PolynomThing d = new PolynomThing(new double[] { 2, 3, 4 }, false, "foo");
		System.out.println(a.hashCode() + " " + b.hashCode() + " " + c.hashCode() + " " + d.hashCode());
	}

}
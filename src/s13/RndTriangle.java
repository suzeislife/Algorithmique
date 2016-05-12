package s13;

import java.util.Random;

public class RndTriangle {
	public static void main(String[] args) {
		int nbOfExperiments = 100000;
		Random r = new Random();
		if (args.length > 0)
			nbOfExperiments = Integer.parseInt(args[0]);
		System.out.println(rndTriangleAvgArea(r, nbOfExperiments));
	}

	// ============================================================
	public static double rndTriangleAvgArea(Random r, int nbOfExperiments) {
		double value = 0.0;
		for (int i = 0; i < nbOfExperiments; i++) {
			double x1 = r.nextDouble();
			double y1 = r.nextDouble();
			double x2 = r.nextDouble();
			double y2 = r.nextDouble();
			double x3 = r.nextDouble();
			double y3 = r.nextDouble();
			value += 0.5 * Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)));
		}
		return value / nbOfExperiments;
	}
}
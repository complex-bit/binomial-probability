import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

class BinomialProbability {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        final double SUM = 0.0;
        int n = 0;
        int x = 0;
        double p = 0.0;
        double q = 1.0 - p;

        try {
            System.out.println("Enter Values:");

            System.out.print("\tNumber of trials >");
            n = keyScan.nextInt();
            
            System.out.print("\tNumber of desired successes >");
            x = keyScan.nextInt();
            
            System.out.print("\tProbability of success >");
            p = keyScan.nextDouble();

            keyScan.close();
            
            System.out.println(probabilityAtLeast(n, x, p, q, SUM));
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }

    private static double probabilityAtLeast(int n, int x, double p, double q, double sum) {
		if (x == n) { return sum; }
		return probabilityAtLeast(n, x + 1, p, q, sum + probability(n, x, p, q));
	}

	private static double probability(int n, int x, double p, double q) {
		return combination(n, x).multiply(new BigDecimal(Math.pow(p, x))).multiply(new BigDecimal(Math.pow(q, n - x))).doubleValue();
	}

	private static BigDecimal combination(int n, int r) {
		return new BigDecimal(factorial(n).divide(factorial(n - r).multiply(factorial(r))));
	}
	
	private static BigInteger factorial(int n) {
		if (n == 1) { return BigInteger.valueOf(1); }
		return BigInteger.valueOf(n).multiply(factorial(n - 1));
	}
}
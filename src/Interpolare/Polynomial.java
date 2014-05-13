package Interpolare;

public class Polynomial {

	double[] myPolynomial = new double[]{1, -12, 30, 0, 12};
	
	public double getValueIn(double x) {
		double result = 0;
		for (int i=myPolynomial.length - 1; i>=0; i--)
			result += myPolynomial[i] * Math.pow(x, i);
		return result;
	}
}

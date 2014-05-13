package Interpolare;

public class Lagrange {

	double[] xValues;
	double[] yValues;
	static double a, b, valueToBeGuessed;
	static int numberOfValuesToGenerate;
	
	public Lagrange() {
		xValues = new double[numberOfValuesToGenerate];
		yValues = new double[numberOfValuesToGenerate];
	}
	
	public void computelagrangePolynomialValue() {
		generateRandomNumbersInRange(a, b);
		printArray(xValues, "X:");
		
		computeYValuesForXValues();
		printArray(yValues, "Y:");
		
		computeAitkenValues();
		printArray(yValues, "Aitken values:");
		
		double result = computeLagrangePolynomialValue(valueToBeGuessed);
		
		System.out.println("Valoarea polinomului Lagrange in " + valueToBeGuessed + " este " + result);
		
		Polynomial p = new Polynomial();
		System.out.println("Diferenta  dintre valoarea calculata si cea reala este " + 
		Math.abs(result - p.getValueIn(valueToBeGuessed)));
	}
	
	private void generateRandomNumbersInRange(double a, double b) {
		double min = a, max = b;
		xValues[0] = a;
		xValues[numberOfValuesToGenerate - 1] = b;
		for (int i=1; i<=numberOfValuesToGenerate - 2; i++) {
			xValues[i] = min + (Math.random() * (max - min));
			min = xValues[i];
		}
	}
	
	private void computeYValuesForXValues() {
		Polynomial p = new Polynomial();
		for (int i=0; i<yValues.length; i++) {
			yValues[i] = p.getValueIn(xValues[i]);
		}
	}
	
	private void computeAitkenValues() {
		for(int k=1; k<yValues.length; k++)
			for (int i=yValues.length - 1; i>=k; i--)
				yValues[i] = (yValues[i] - yValues[i-1]) / (xValues[i] - xValues[i-k]);
	}
	
	private double computeLagrangePolynomialValue(double x) {
		double result = yValues[0];
		
		for (int i=1; i<xValues.length; i++) {
			double product = 1;
			for (int j=0; j<i; j++)
				product *= (x - xValues[j]);
			result += yValues[i] * product;
		}
		
		return result;
	}
	
	public void printArray(double[] array, String message) {
		System.out.println(message);
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

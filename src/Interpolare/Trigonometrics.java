package Interpolare;

import Jama.Matrix;

public class Trigonometrics {

	double startPoint = 0;
	double endPoint = (31 * Math.PI) / 16;
	double[][] tMatrix;
	double[][] coef;
	double realValue;
	
	double[] xValues;
	double[][] yValues;
	static double valueToBeGuessed;
	static int numberOfValuesToGenerate;

	public Trigonometrics() {
		xValues = new double[numberOfValuesToGenerate];
		yValues = new double[numberOfValuesToGenerate][1];
		tMatrix = new double[numberOfValuesToGenerate][numberOfValuesToGenerate];
		coef = new double[numberOfValuesToGenerate][1];
	}

	public double computeTrigValue() {
		generateRandomNumbersInRange(startPoint, endPoint);
		printArray(xValues, "X:");
		
		computeYValuesForXValues();
		printMatrix(yValues, "Y:");
		
		buildTMatrix();
		
		Matrix T = new Matrix(tMatrix);
		Matrix Y = new Matrix(yValues);
		
		Matrix X = T.solve(Y);
		MatrixToArray(X);
		
		double result = guessValue();
		
		System.out.println("Valoarea calculata prin interpolare este " + result);
		System.out.println("Diferenta dintre valori este " + Math.abs(result - realValue));
		
		return result;
	}
	
	private void generateRandomNumbersInRange(double a, double b) {
		if (numberOfValuesToGenerate % 2 == 0)
			numberOfValuesToGenerate ++;
		
		double min = a, max = b;
		xValues[0] = a;
		xValues[numberOfValuesToGenerate - 1] = b;
		
		for (int i=1; i<=numberOfValuesToGenerate - 2; i++) {
			xValues[i] = min + (Math.random() * (max - min));
			min = xValues[i];
		}
	}
	
	private void computeYValuesForXValues() {
		SinCos s = new SinCos();
		for (int i=0; i<yValues.length; i++) {
			yValues[i][0] = s.getFunction1(xValues[i]);
		}
		realValue = s.getFunction1(valueToBeGuessed);
	}
	
	private void buildTMatrix() {
		for (int i=0; i<numberOfValuesToGenerate; i++)
			for (int j=0; j<numberOfValuesToGenerate; j++) {
				tMatrix[i][j] = computeFi(xValues[i], j);
			}
	}
	
	/*interpolarea*/
	private double guessValue() {
		double result = 0;
		double fi = 0;
		
		for (int i=0; i<numberOfValuesToGenerate; i++) {
			fi = computeFi(valueToBeGuessed, i);
			result += (coef[i][0] * fi);
		}
		
		return result;
	}
	
	private double computeFi(double x, int index) {
		double fi = 0;
		
		if (index == 0)
			fi = 1;
		else {
			int k = (index + 1) / 2;
			if (index % 2 == 1)
				fi = Math.sin(k * x);
			else
				fi = Math.cos(k * x);
		}
		
		return fi;
	}
	
	private void MatrixToArray(Matrix x) {
		for (int i=0; i<x.getRowDimension(); i++)
			for (int j=0; j<x.getColumnDimension(); j++)
				coef[i][0] = x.get(i, j);
	}
	
	private void printMatrix(double[][] m, String message) {
		System.out.println(message);
		
		for (int i=0; i<m.length; i++) {
			if (m[0].length == 1) {
				System.out.print(m[i][0] + " ");
				if (i == m.length - 1)
					System.out.println();
			}
			else {
				for (int j=0; j<m[0].length; j++) {
					System.out.print(m[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	public void printArray(double[] array, String message) {
		System.out.println(message);
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

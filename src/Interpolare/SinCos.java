package Interpolare;

public class SinCos {

	public double getFunction1(double x) {
		return Math.sin(x) - Math.cos(x);
	}
	
	public double getFunction2(double x) {
		return Math.sin(2 * x)  + Math.sin(x) + Math.cos(3 * x);
	}
	
	public double getFunction3(double x) {
		return Math.sin(x) * Math.sin(x) - Math.cos(x) * Math.cos(x);
	}
}

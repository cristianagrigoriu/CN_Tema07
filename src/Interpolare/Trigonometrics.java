package Interpolare;

public class Trigonometrics {

	double startPoint = 0;
	double endPoint = (31 * Math.PI) / 16;
	double[][] tMatrix;
	
	static double valueToBeGuessed;
	static int numberOfValuesToGenerate;

	public Trigonometrics() {
		tMatrix = new double[numberOfValuesToGenerate][numberOfValuesToGenerate];
	}

	public void buildTMatrix() {
		int k;
		for (int i=0; i<numberOfValuesToGenerate; i++)
			for (int j=0; j<numberOfValuesToGenerate; j++) {
				if (j == 0)
					tMatrix[i][j] = 1;
				else {
					k = (j + 1) / 2;
					if (j % 2 == 1)
						tMatrix[i][j] = Math.sin(k * valueToBeGuessed);
					else
						tMatrix[i][j] = Math.cos(k * valueToBeGuessed);
				}
			}
		
		printMatrix();
	}
	
	private void printMatrix() {
		for (int i=0; i<numberOfValuesToGenerate; i++) {
			for (int j=0; j<numberOfValuesToGenerate; j++) {
				System.out.print(tMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}

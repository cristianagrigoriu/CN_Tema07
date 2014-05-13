package Interpolare;

import Graphics.FileChooser;

public class Interpolare_Main {
		
	public static void main(String[] args) {
		/*se alege fisierul*/
		FileChooser sfc = new FileChooser();
		sfc.setVisible(true);
		String fileName = sfc.createFileChooser();
		System.out.println("Ati ales fisierul " + fileName);		
					
		if (fileName != null) {
			ReadFile rf = new ReadFile();
			if (fileName.equals("in.txt")) {
				rf.readFromFile(fileName);
				
				Lagrange l = new Lagrange();
				l.computelagrangePolynomialValue();
			}
			if (fileName.equals("in_trig.txt")) {
				rf.readFromFileTrig(fileName);
				
				Trigonometrics t = new Trigonometrics();
				t.buildTMatrix();
			}
		}
	}
}

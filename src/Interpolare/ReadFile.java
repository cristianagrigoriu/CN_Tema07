package Interpolare;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile {

	public void readFromFile(String fileName) {
		try
		{
			FileInputStream fstream = new FileInputStream(fileName);
			/*get the object of DataInputStream*/
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			/*read the first line of the file*/
			while ((strLine = br.readLine()) != null) {
				String[] values = strLine.split(" ");
				Lagrange.a = Double.parseDouble(values[0]);
				Lagrange.b = Double.parseDouble(values[1]);
				Lagrange.numberOfValuesToGenerate = Integer.parseInt(values[2]);
				Lagrange.valueToBeGuessed = Double.parseDouble(values[3]);
			}
			
			/*close the input stream*/
			in.close();
			
			printValues();
			
			/*catch exception if any*/
			}catch (Exception e){
				System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void readFromFileTrig(String fileName) {
		try
		{
			FileInputStream fstream = new FileInputStream(fileName);
			/*get the object of DataInputStream*/
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			/*read the first line of the file*/
			while ((strLine = br.readLine()) != null) {
				String[] values = strLine.split(" ");
				Trigonometrics.numberOfValuesToGenerate = Integer.parseInt(values[2]);
				Trigonometrics.valueToBeGuessed = Double.parseDouble(values[3]);
			}
			
			/*close the input stream*/
			in.close();
			
			System.out.println("n + 1 = " + Trigonometrics.numberOfValuesToGenerate + " x = " + Trigonometrics.valueToBeGuessed);
			
			/*catch exception if any*/
			}catch (Exception e){
				System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void printValues() {
		System.out.println("a = " + Lagrange.a);
		System.out.println("b = " + Lagrange.b);
		System.out.println("numberOfValuesToGenerate = " + Lagrange.numberOfValuesToGenerate);
		System.out.println("valueToBeGuessed = " + Lagrange.valueToBeGuessed);
	}
}

package th.co.extosoft.trainning;

import java.text.DecimalFormat;

public class TestNumber {

	public static void main(String args[]) {
		
		//int
		int numberInt1 = 1;
		int numberInt2 = 2;
		int summaryInt = numberInt1 + numberInt2;
		System.out.println("Summary Interger --> " + summaryInt);
		
		//long
		long numberLong1 = 10000;
		long numberLong2 = 20000L;
		long summaryLong = numberLong1 + numberLong2;
		System.out.println("Summary Long --> " + summaryLong);
		
		//long
		double numberDouble1 = 20020.41;
		double numberDouble2 = 40030.57;
		double summaryDouble = numberDouble1 + numberDouble2;
		System.out.println("Summary Double --> " + summaryDouble);
		
		DecimalFormat df = new DecimalFormat("#,###.##");
		String summaryDoubleFormat = "" + df.format(summaryDouble);
		System.out.println("Summary Double Format(####.##)--> " + summaryDoubleFormat);
		
		//float
		float numberFloat1 = 20020.413f;
		float numberFloat2 = 40030.573f;
		float summaryFloat = numberFloat1 + numberFloat2;
		System.out.println("Summary Float --> " + summaryFloat);
		
	}
	
}

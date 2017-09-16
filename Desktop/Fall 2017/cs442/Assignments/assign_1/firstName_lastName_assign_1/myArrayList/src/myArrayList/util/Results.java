package myArrayList.driver;

import java.util.Formatter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private String[] testResults;
	private Formatter outF;

	public Results() {
		testResults = new String[10];
	}

	public void storeNewResults(String message, int index) {
		// this method will take in the result, and add values this class' Strings data member to be printed out based on the result.testName values and such
		testResults[index] = message;
	}

	public void printSum(MyArrayList myList) {
		System.out.println("The sum of all the values in the list is: " + myList.sum());
	}

	public void writeToStdOut(String s) {
		System.out.println(s);
	}

	public void writeToFile(String outFile, MyArrayList myList) {
		try {
			outF = new Formatter(outFile);
			for(int i = 0; i < getTestResults().length; i++) {
				outF.format("%s\n", getTestResults()[i]);
			}
			outF.format("%s", "The sum of all the values in the list is: " + myList.sum());
		} catch (Exception e) {
			System.err.println("Error opening write file: " + e.getMessage());
		}
	}

	public void closeFile(String outFile) {
		try {
			outF.close();
		} catch (Exception e) {
			System.err.println("Error closing write file: " + e.getMessage());
		}
	}

	public String[] getTestResults() {
		return testResults;
	}

}
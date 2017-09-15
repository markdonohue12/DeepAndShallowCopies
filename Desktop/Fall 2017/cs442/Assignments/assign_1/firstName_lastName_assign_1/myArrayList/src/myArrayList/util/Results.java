package myArrayList.driver;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private String[] testResults;
/*
	private Results[] resultsArr;
	private boolean testPassed;
	private String testMessage;
	private String testName;
*/	

	public Results() {
		testResults = new String[11];
	}

	public void storeNewResults(String message, int index) {
		// this method will take in the result, and add values this class' Strings data member to be printed out based on the result.testName values and such
		testResults[index] = message;
	}

	public void writeToStdOut(String s) {
		System.out.println(s);
	}

	public void writeToFile(String s) {
		System.out.println("Inside Results, my writeToFile(String s) implementation goes here");
	}

	public String[] getTestResults() {
		return testResults;
	}

}
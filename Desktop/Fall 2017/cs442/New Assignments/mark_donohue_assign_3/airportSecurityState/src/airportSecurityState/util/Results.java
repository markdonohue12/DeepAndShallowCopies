package airportSecurityState.driver;

import java.util.Formatter;
import java.io.BufferedWriter;

public class Results implements FileDisplayInterface {

	private Formatter outF;

	public void writeToFile(String outFile, String result, BufferedWriter outWriter) {
		try {
			outWriter.write(result);
			outWriter.newLine();
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
}
package airportSecurityState.driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileProcessor
{
	private String inputFile;
	private BufferedReader reader;	

	// MyLogger instance
	MyLogger myLogger;

	public FileProcessor() {
		inputFile = "input.txt";
		reader = null;
	}

	public FileProcessor(String inFile, MyLogger myLog) {
		inputFile = inFile;
		myLogger = myLog;
		myLogger.writeMessage("Logger: called FileProcessor constructor", 					MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public boolean openFile() throws FileNotFoundException {
		try {
			reader = new BufferedReader(new FileReader(this.inputFile));
		}
		catch (FileNotFoundException e) {
			System.err.println("Error opening file " + e.getMessage());
			return false;
		}
		return true;	
	}

	public String readFileLine() {
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("caught exception trying to read line from file");
		}
		return line;
	}

	public String getInFileName() {
		return inputFile;
	}
}
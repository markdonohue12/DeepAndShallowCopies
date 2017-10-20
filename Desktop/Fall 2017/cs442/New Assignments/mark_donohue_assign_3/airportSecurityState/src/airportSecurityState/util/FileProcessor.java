package airportSecurityState.driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileProcessor
{
	private String inputFile;
	private BufferedReader reader;
	public BufferedWriter outWriter;	

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

	public BufferedWriter openOutFile(String outFile) {
		outWriter = null;
		try {
			FileWriter fstream = new FileWriter(outFile);
			outWriter = new BufferedWriter(fstream);
		} catch (IOException e) {
   			 System.err.println("Error: " + e.getMessage());
		}
		return outWriter;
	}
}
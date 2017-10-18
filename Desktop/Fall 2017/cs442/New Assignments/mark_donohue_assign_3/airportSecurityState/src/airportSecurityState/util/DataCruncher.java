package airportSecurityState.driver;

import java.io.FileNotFoundException;

public class DataCruncher {

	private String inFile;
	private MyLogger myLogger;

	public DataCruncher(String inputFile, MyLogger myLog) {
		inFile = inputFile;
		myLogger = myLog;
		myLog.writeMessage("Logger: called the DataCruncher constructor", 							MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void readFromFile() {
		FileProcessor processFile = new FileProcessor(inFile, myLogger);
		boolean openedSuccessfully = false;
		try {
			openedSuccessfully = processFile.openFile();
		}
		catch (FileNotFoundException e) {
			System.out.println("inside theFileNotFoundException");
		}

		if(openedSuccessfully) {

		}

	}
}
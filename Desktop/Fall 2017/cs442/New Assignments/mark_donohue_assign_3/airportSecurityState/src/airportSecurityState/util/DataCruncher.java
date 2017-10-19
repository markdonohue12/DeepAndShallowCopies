package airportSecurityState.driver;

import java.io.FileNotFoundException;
import java.lang.Integer;

public class DataCruncher {

	private String inFile;
	private MyLogger myLogger;
	private AirportSecurityState contextState;

	public DataCruncher(String inputFile, MyLogger myLog, AirportSecurityState inContextState) {
		inFile = inputFile;
		contextState = inContextState;
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
			// read a line
			// parse input to get days and items
			// calculate the 2 needed values
			// send values to airport security
			int iteration = 0;
			String line = processFile.readFileLine();
			while(line != null) {

				// parse the input
				String[] parcedInput = parseInput(line);

				// extract the day # from the input 
				// store in day variable
				String colonFlag = "[:]";
				String[] parcedDay = parcedInput[0].split(colonFlag);
				int day = Integer.parseInt(parcedDay[1]);	

				String[] parcedItem = parcedInput[3].split(colonFlag);
				String item = parcedItem[1];

				// at this point I have the day and the item
				// DO SOMETHING WITH THE PARCED INPUT
				contextState.tightenOrLoosenSecurity(day, item);

				line = processFile.readFileLine();
				iteration += 1;
			}
		}
	}

	// USED THIS SITE: http://pages.cs.wisc.edu/~hasti/cs302/examples/Parsing/parseString.html
	private String[] parseInput(String line) {
		String flag = "[;]";
		String[] parcedInput = line.split(flag);

		return parcedInput;
	}
}
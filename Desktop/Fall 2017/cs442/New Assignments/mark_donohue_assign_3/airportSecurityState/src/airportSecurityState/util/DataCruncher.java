package airportSecurityState.driver;

import java.io.FileNotFoundException;
import java.lang.Integer;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;

public class DataCruncher {

	private String inFile;
	private MyLogger myLogger;
	private AirportSecurityState contextState;

	private String[] prohibitedItems;	
	private ArrayList<Integer> uniqueDays;
	private int numOfProhibitedItems;
	private int numOfUniqueDays;
	private int numOfTravellers;
	private Results results;
	private String outFile;

	public DataCruncher(String inputFile, MyLogger myLog, AirportSecurityState inContextState, Results inResults, String inOutFile) {
		inFile = inputFile;
		contextState = inContextState;
		myLogger = myLog;
		numOfProhibitedItems = 0;
		numOfUniqueDays = 0;
		uniqueDays = new ArrayList<Integer>();
		prohibitedItems = new String[4];
		numOfTravellers = 0;
		results = inResults;
		outFile = inOutFile;
		prohibitedItems[0] = "Gun";
		prohibitedItems[1] = "NailCutter";
		prohibitedItems[2] = "Blade";
		prohibitedItems[3] = "Knife";

		myLog.writeMessage("Logger: called the DataCruncher constructor", 							MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void readFromFile() {
		FileProcessor processFile = new FileProcessor(inFile, myLogger);
		BufferedWriter outWriter = processFile.openOutFile(outFile);
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
				numOfTravellers += 1;

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
				contextState.tightenOrLoosenSecurity(day, item, this, results, outFile, outWriter);

				line = processFile.readFileLine();
				iteration += 1;
			}
		try {
			outWriter.close();
		} catch (IOException e) {
			System.err.println("Caught IOException while closing output file");
		}
		}
	}

	public void evaluateNumUniqueDays(int day) {
		if(!uniqueDays.contains(day)) {
			uniqueDays.add(day);
			numOfUniqueDays += 1;
		}
	}

	public void calculateProhibitedItemsPerDay(String item) {
		for(int i = 0; i < 4; i++) {
			if(item.equals(prohibitedItems[i])) {
				numOfProhibitedItems += 1;
			}
		}
	}

	public int calcAvgTrafficPerDay(int travellers, int uniqueDays) {
		myLogger.writeMessage("Logger: calculated Avg Traffic Per Day is " + (travellers/uniqueDays), MyLogger.DebugLevel.TRAFFIC);
		return travellers/uniqueDays;
	}

	public int calcAvgProhibitedItemsPerDay(int items, int uniqueDays) {
		myLogger.writeMessage("Logger: calculated Avg Prohibited Items Per Day is " + (items/uniqueDays), MyLogger.DebugLevel.PROHIBITED);
		return items/uniqueDays;
	}

	public int getTotalNumProhibItems() {
		return numOfProhibitedItems;
	}

	public int getNumOfUniqueDays() {
		return numOfUniqueDays;
	}

	public int getNumOfTravellers() {
		return numOfTravellers;
	}

	// USED THIS SITE: http://pages.cs.wisc.edu/~hasti/cs302/examples/Parsing/parseString.html
	private String[] parseInput(String line) {
		String flag = "[;]";
		String[] parcedInput = line.split(flag);

		return parcedInput;
	}
}
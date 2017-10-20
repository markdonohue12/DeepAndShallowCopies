package airportSecurityState.driver;

import java.io.FileNotFoundException;
import java.lang.Integer;
import java.util.ArrayList;

public class DataCruncher {

	private String inFile;
	private MyLogger myLogger;
	private AirportSecurityState contextState;

	private String[] prohibitedItems;	
	private ArrayList<Integer> uniqueDays;
	private int numOfProhibitedItems;
	private int numOfUniqueDays;
	private int numOfTravellers;

	public DataCruncher(String inputFile, MyLogger myLog, AirportSecurityState inContextState) {
		inFile = inputFile;
		contextState = inContextState;
		myLogger = myLog;
		numOfProhibitedItems = 0;
		numOfUniqueDays = 0;
		uniqueDays = new ArrayList<Integer>();
		prohibitedItems = new String[4];
		numOfTravellers = 0;
		prohibitedItems[0] = "Gun";
		prohibitedItems[1] = "NailCutter";
		prohibitedItems[2] = "Blade";
		prohibitedItems[3] = "Knife";

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
				contextState.tightenOrLoosenSecurity(day, item, this);

				line = processFile.readFileLine();
				iteration += 1;
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
		// have an integer ArrayList as a private data member of DataCruncher to 
		// 		hold all of the currently seen days
		// also have String ArrayList of the prohibited items

		// 1)
		// look through the integer ArrayList
		// if day is not in there, increment unique days counter
		// .add new day to the ArrayList
		
		// 2) 
		// if item is in the prohibited items list, increment num_of_prohib_items
		for(int i = 0; i < 4; i++) {
			if(item.equals(prohibitedItems[i])) {
				numOfProhibitedItems += 1;
			}
		}

		// 3) 
		// calculate avgProhibitedItemsPerDay by doing prohib_items / unique_days
	}

	public int calcAvgTrafficPerDay(int travellers, int uniqueDays) {
		return travellers/uniqueDays;
	}

	public int calcAvgProhibitedItemsPerDay(int items, int uniqueDays) {
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
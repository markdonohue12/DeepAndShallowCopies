package airportSecurityState.driver;

public class HighRiskState implements AirportStateI {

	private String highID = "2 4 6 8 10";

	private MyLogger myLogger;

	public HighRiskState(MyLogger inMyLogger) {
		myLogger = inMyLogger;

		myLogger.writeMessage("Logger: called the HighRiskState constructor", 					MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public String tightenOrLoosenSecurity(int day, String item, DataCruncher dataCruncher) {
		//System.out.println("inside of the HIGH risk state Class");

		// calculate the average prohibited items per day
		// calculate the average traffic per day
		// do this by calling helper functions within the DateCruncher class
		dataCruncher.calculateProhibitedItemsPerDay(item);
		dataCruncher.evaluateNumUniqueDays(day);
		
		int avgTrafficPerDay = 																dataCruncher.calcAvgTrafficPerDay(dataCruncher.getNumOfTravellers(), 			dataCruncher.getNumOfUniqueDays());

		int avgProhibitedItemsPerDay = dataCruncher.calcAvgProhibitedItemsPerDay(dataCruncher.getTotalNumProhibItems(), dataCruncher.getNumOfUniqueDays());

		//System.out.println("avgProhibitedItemsPerDay: " + avgProhibitedItemsPerDay);
		//System.out.println("avgTrafficPerDay: " + avgTrafficPerDay);

		String newState = "";
		// now since I have the two metrics, decide which Risk State I am in
		if( (avgTrafficPerDay >= 0 && avgTrafficPerDay < 4) || 
			(avgProhibitedItemsPerDay >= 0 && avgProhibitedItemsPerDay < 1) ) {
				newState = "low";
				//System.out.println("inside of the LOW");
		}
		
		if( (avgTrafficPerDay >= 4 && avgTrafficPerDay < 8) ||
			(avgProhibitedItemsPerDay >= 1 && avgProhibitedItemsPerDay < 2) ) {
				newState = "mod";
				//System.out.println("inside of the MOD");
		}

		if( (avgTrafficPerDay >= 8) || (avgProhibitedItemsPerDay >= 2) ) {
				newState = "high";
				//System.out.println("inside of the HIGH");
		}
		//System.out.println("newState value based on calculations is " + newState);
		return newState;
	}	

	public void writeToStdOut() {
		System.out.println(highID);
	}

	public String getID() {
		return highID;
	}
		
}
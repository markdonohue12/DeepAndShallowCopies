package airportSecurityState.driver;

public class LowRiskState implements AirportStateI {
	public void tightenOrLoosenSecurity(int day, String item, DataCruncher dataCruncher) {
		// calculate the average prohibited items per day
		// calculate the average traffic per day
		// do this by calling helper functions within the DateCruncher class
		dataCruncher.calculateProhibitedItemsPerDay(item);
		dataCruncher.evaluateNumUniqueDays(day);
		
		int avgTrafficPerDay = 																		dataCruncher.calcAvgTrafficPerDay(dataCruncher.getNumOfTravellers(), 				dataCruncher.getNumOfUniqueDays());
		int avgProhibitedItemsPerDay = dataCruncher.calcAvgProhibitedItemsPerDay(dataCruncher.getTotalNumProhibItems(), dataCruncher.getNumOfUniqueDays());

		// now since I have the two metrics, decide which Risk State I am in
		

		System.out.println("The Average Number of Prohibited Items per day is " + avgProhibitedItemsPerDay);
		System.out.println("The Average TrafficPerDay is " + avgTrafficPerDay);

		// then have a serious of if-else statements to determine what to set the new state to
		
	}
}
package airportSecurityState.driver;

public class LowRiskState implements AirportStateI {
	public void tightenOrLoosenSecurity(int day, String item, DataCruncher dataCruncher) {
		// calculate the average prohibited items per day
		// calculate the average traffic per day
		// do this by calling helper functions within the DateCruncher class
		int avgProhibItemsPerDay = dataCruncher.calculateProhibitedItemsPerDay(day, item);


		// then have a serious of if-else statements to determine what to set the new state to
		
	}
}
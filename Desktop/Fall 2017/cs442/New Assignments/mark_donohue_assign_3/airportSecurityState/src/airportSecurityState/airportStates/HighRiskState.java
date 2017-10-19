package airportSecurityState.driver;

public class HighRiskState implements AirportStateI {
	public void tightenOrLoosenSecurity(int day, String item, DataCruncher dataCruncher) {
		System.out.println("this is tightenOrLoosenSecurity for HighRiskState");
	}	
}
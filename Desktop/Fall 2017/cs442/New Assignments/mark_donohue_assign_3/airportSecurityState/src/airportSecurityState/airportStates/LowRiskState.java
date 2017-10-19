package airportSecurityState.driver;

public class LowRiskState implements AirportStateI {
	public void tightenOrLoosenSecurity(int day, String item) {
		System.out.println("this is tightenOrLoosenSecurity for LowRiskState");
	}
}
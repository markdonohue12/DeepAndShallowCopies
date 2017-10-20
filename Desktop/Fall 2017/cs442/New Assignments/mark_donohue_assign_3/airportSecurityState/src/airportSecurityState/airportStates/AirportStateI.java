package airportSecurityState.driver;

public interface AirportStateI {
	public String tightenOrLoosenSecurity(int day, String item, DataCruncher dataCruncher);

	public void writeToStdOut();
}
package airportSecurityState.driver;

public interface AirportStateInterface {
	public void escalate();
	public void de_escalate();
	public void determine_escalation();
}
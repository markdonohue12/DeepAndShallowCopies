package airportSecurityState.driver;

public class ModRiskState implements AirportStateInterface {
	public void escalate() {
		System.out.println("this is the escalate function");
	}

	public void de_escalate() {
		System.out.println("this is the de-escalate function");
	}

	public void determine_escalation() {
		System.out.println("this is the determint_escalation function");
	}
	
}
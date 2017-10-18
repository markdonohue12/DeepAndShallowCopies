package airportSecurityState.driver;

public class AirportSecurityState {
	// private state members
	AirportStateInterface lowRiskState;
	AirportStateInterface modRiskState;
	AirportStateInterface highRiskState;

	// instance to keep track of program State
	AirportStateInterface state;

	public AirportSecurityState() {
		// initialize the states
		lowRiskState = new LowRiskState();
		modRiskState = new ModRiskState();
		highRiskState = new HighRiskState();

		// beginning state is lowRisk
		state = lowRiskState;
	}
}
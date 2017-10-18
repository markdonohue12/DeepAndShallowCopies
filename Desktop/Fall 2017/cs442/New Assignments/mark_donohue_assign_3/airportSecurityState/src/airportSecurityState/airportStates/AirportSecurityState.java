package airportSecurityState.driver;

public class AirportSecurityState {
	// private state members
	AirportStateInterface lowRiskState;
	AirportStateInterface modRiskState;
	AirportStateInterface highRiskState;
	
	// logger member
	MyLogger myLogger;

	// instance to keep track of program State
	AirportStateInterface state;

	public AirportSecurityState(MyLogger myLog) {
		// initialize the states
		lowRiskState = new LowRiskState();
		modRiskState = new ModRiskState();
		highRiskState = new HighRiskState();
	
		// initialize the logger
		myLogger = myLog;

		// beginning state is lowRisk
		state = lowRiskState;

		myLog.writeMessage("Logger: called the AirportSecurityState constructor", 				MyLogger.DebugLevel.CONSTRUCTOR);
	}
}
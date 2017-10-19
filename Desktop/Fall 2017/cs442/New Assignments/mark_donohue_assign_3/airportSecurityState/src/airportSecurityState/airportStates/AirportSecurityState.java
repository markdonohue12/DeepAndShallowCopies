package airportSecurityState.driver;

public class AirportSecurityState {
	// private state members
	private AirportStateI lowRiskState;
	private AirportStateI modRiskState;
	private AirportStateI highRiskState;
	
	// logger member
	private MyLogger myLogger;

	// instance to keep track of program State
	private AirportStateI state;

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

	public AirportStateI getCurrentState() {
		return state;
	}

	public void tightenOrLoosenSecurity(int day, String item) {
		//System.out.println("made it to tightenOrLoosenSecurity() inside of AirportSecurityState");
		
		// get the current state
		// call the current state's tighten or loosen function, sending in day and Item
		System.out.println("calling the getCurrentStateFunction()");
		AirportStateI curState = this.getCurrentState();
		if(curState instanceof LowRiskState) {
			System.out.println("Current state is LowRisk");
		} else if (curState instanceof ModRiskState) {
			System.out.println("Current state is ModRisk"); 
		} else {
			System.out.println("Current state is HighRisk");
		}
	}
}
package airportSecurityState.driver;

import java.io.BufferedWriter;

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
		lowRiskState = new LowRiskState(myLog);
		modRiskState = new ModRiskState(myLog);
		highRiskState = new HighRiskState(myLog);
	
		// initialize the logger
		myLogger = myLog;

		// beginning state is lowRisk
		state = lowRiskState;

		myLog.writeMessage("Logger: called the AirportSecurityState constructor", 				MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public AirportStateI getCurrentState() {
		return state;
	}

	public void tightenOrLoosenSecurity(int day, String item, DataCruncher dataCruncher, Results results, String outFile, BufferedWriter outWriter) {
		// get the current state
		// call the current state's tighten or loosen function, sending in day and Item
		String newState = state.tightenOrLoosenSecurity(day, item, dataCruncher);
		
		// set the new state based on the newState return value
		if(newState.equals("low")) {
			state = lowRiskState;
		} else if(newState.equals("mod")) {
			state = modRiskState;
		} else if(newState.equals("high")) {
			state = highRiskState;
		}

		myLogger.writeMessage("Logger: state has changed", 				MyLogger.DebugLevel.STATE);
		
		// now take correct action based on new state
		state.writeToStdOut();
		results.writeToFile(outFile, state.getID(), outWriter);
	}
}
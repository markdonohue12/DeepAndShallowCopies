package airportSecurityState.driver;

public class Driver {
	public static void main(String[] args) {
		int loggerLevel;
		// there should be exactly 3 args:
		// — input file name
		// — output file name
		// — Logger input number
		if(args.length != 3) {
			System.err.println("Need exactly 3 arguments: input file name, output file 				name, Logger input number. Program exiting");
			System.exit(0);
		} else if (Integer.parseInt(args[2]) < 0 || Integer.parseInt(args[2]) > 4) {
			System.err.println("Logger Level must be in range 0 - 4, exiting");
			System.exit(0);
		} else {
			// set the LoggerLevel for the program
			loggerLevel = Integer.parseInt(args[2]);
			MyLogger myLogger = new MyLogger();
			myLogger.setDebugValue(loggerLevel);

			// create the AirportSecurityState instance
			AirportSecurityState airSecure = new AirportSecurityState(myLogger);

			// create Results instance
			Results results = new Results();

			// create DataCruncher instance
			DataCruncher dataCrunch = new DataCruncher(args[0], myLogger, airSecure, results, args[1]);
			dataCrunch.readFromFile();
		}
	}
}


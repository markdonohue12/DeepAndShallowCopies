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
		} else {
			loggerLevel = Integer.parseInt(args[2]);
		}
	}
}


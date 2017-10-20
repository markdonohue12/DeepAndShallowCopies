package airportSecurityState.driver;

public class MyLogger{

    // DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
    // DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
    // DEBUG_VALUE=2 [FIXME: add your own scheme here]
    // DEBUG_VALUE=1 [FIXME: add your own scheme here]
    // DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    

    public static enum DebugLevel { NONE, STATE, CONSTRUCTOR, TRAFFIC, PROHIBITED };

    private static DebugLevel debugLevel;

    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
	  		case 4: debugLevel = DebugLevel.CONSTRUCTOR; 
					break;
			case 3: debugLevel = DebugLevel.STATE;
					break;
			case 2: debugLevel = DebugLevel.TRAFFIC;
					break;
	      	// FIXME: add code for other cases
			case 1: debugLevel = DebugLevel.PROHIBITED;
					break;
	  		case 0: debugLevel = DebugLevel.NONE; 
					System.out.println("setting debugLevel to DebugLevel.NONE");
					break;
		}
    }

    public static void setDebugValue (DebugLevel levelIn) {
		System.out.println("ENTERED THE DEBUG LEVEL LEVELIN METHOD");
		debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message, DebugLevel levelIn ) {
		if (levelIn == debugLevel) {
	    	System.out.println(message);
		}
    }

    /**
	 * @return String
	 */
    public String toString() {
		return "Debug Level is " + debugLevel;
    }
	
	public DebugLevel getLevel() {
		return debugLevel;
	}
}
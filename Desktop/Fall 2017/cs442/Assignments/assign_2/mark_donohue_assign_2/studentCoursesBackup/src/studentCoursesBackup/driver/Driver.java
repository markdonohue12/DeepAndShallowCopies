package studentCoursesBackup.driver;

public class Driver {
	public static void main(String[] args) {
		if(args.length != 5) {
			System.err.println("Need exactly 5 arguments, program exiting");
			System.exit(0);
		} else {
			// pass input file name to SOMEWHERE TO START READING INPUT
			Node makeNode = new Node(args[0]);
		}
	}
}


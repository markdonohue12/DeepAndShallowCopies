package studentCoursesBackup.driver;

public class Driver {
	public static void main(String[] args) {
		if(args.length != 5) {
			System.err.println("Need exactly 5 arguments, program exiting");
			System.exit(0);
		} else {
			// create a TreeBuilder object, then start reading from file by 
			// calling readFileForNodes on tree - sending in the input file name
			TreeBuilder originalTree = new TreeBuilder();
			originalTree.readFileForNodes(args[0]);
			originalTree.readDeleteFile(args[1]);
		}
	}
}


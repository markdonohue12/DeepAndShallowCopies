package myArrayList.driver;

public class Driver 
{

	public static void main(String[] args) 
	{
		if(args.length != 3) {
			System.err.println("Need exactly 2 arguments, program exiting");
			System.exit(0);
		} else {
			// pass the input file name to the MyArrayList constructor
			MyArrayList myList = new MyArrayList(args[0]);
			Results results = new Results();
			// Make a myArrayListTest instance
			MyArrayListTest myTests = new MyArrayListTest();
			myTests.testMe(myList, results);
			// Print Strings from Results class
			for(int i = 0; i < results.getTestResults().length; i++) {
				results.writeToStdOut("Test Result "+i+": " + results.getTestResults()[i]);
			}	
			results.printSum(myList);
			results.writeToFile(args[1], myList);
			results.closeFile(args[1]);
		}
	}
}



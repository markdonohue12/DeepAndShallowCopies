package myArrayList.driver;

public class Driver 
{

	public static void main(String[] args) 
	{

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

	/*
		myList.insertSorted(20);
		myList.removeValue(8);
		System.out.println();
		System.out.println("the index of the first occurrence of 13 is " + myList.indexOf(13));
		System.out.println("total num of elements in list is " + myList.size());
		System.out.println("sum of the elements in the list is " + myList.sum());
		myList.toString(myList.getMyListArray());
		MyArrayListTest testing = new MyArrayListTest();
		testing.testMe(myList);
	*/
		







	    // command line validation is missing here. FIXME!
		
	}
	
}



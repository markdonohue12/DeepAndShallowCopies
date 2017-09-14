package myArrayList.driver;

public class Driver 
{

	public static void main(String[] args) 
	{

		// pass the input file name to the MyArrayList constructor
		MyArrayList myList = new MyArrayList(args[0]);
		myList.insertSorted(5673);
		myList.removeValue(8);
		System.out.println("the index of the first occurrence of 11 is " + myList.indexOf(13));
		
		







	    // command line validation is missing here. FIXME!
	    /*
		System.out.println("Hello World: " + args[0] + ", " + args[1] + ", " + args[2]);
		MyArrayList firstObj = new MyArrayList();
		firstObj.testValue(5);
		firstObj.setNumber(12);
		System.out.println("the number data member is " + firstObj.getNumber());
		*/
		
	}
	
}



package myArrayList.driver;

public class Driver 
{

	public static void main(String[] args) 
	{

		// pass the input file name to the MyArrayList constructor
		MyArrayList myList = new MyArrayList(args[0]);
		myList.insertSorted(20);
		myList.removeValue(8);
		System.out.println();
		System.out.println("the index of the first occurrence of 13 is " + myList.indexOf(13));
		System.out.println("total num of elements in list is " + myList.size());
		System.out.println("sum of the elements in the list is " + myList.sum());
		myList.toString(myList.getMyListArray());
		
		







	    // command line validation is missing here. FIXME!
		
	}
	
}



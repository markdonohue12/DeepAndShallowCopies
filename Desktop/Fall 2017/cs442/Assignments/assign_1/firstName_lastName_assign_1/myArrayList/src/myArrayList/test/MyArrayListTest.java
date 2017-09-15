package myArrayList.driver;

public class MyArrayListTest {

	public void testMe(MyArrayList myList, Results results) {
		for(int i = 0; i < 11; i++) {
			if(i == 0) {
				testMaxIntInsertSorted(myList, 10000, i, results);
			} else if(i == 1) {
				testMinIntInsertSorted(myList, 0, i, results);
			} else if(i == 2) {
				testMinRemoveValue(myList, 0, i, results);
			} else if(i == 3) {
				testMaxRemoveValue(myList, 10000, i, results);
			} else if(i == 4) {
				testLegitimateValueIndexOf(myList, 10, i, results); 
			} else if(i == 5) {
				testNonExistantValueIndexOf(myList, 11000, i, results);
			}
		}
			

		/* 
			put a for loop in this function, for each individual iteration, call a new test function. then write the results to results.testResults[i]
		*/
	}

	public void testMaxIntInsertSorted(MyArrayList myList, int newValue, int index, Results results) {
		try {
			myList.insertSorted(newValue);
			results.storeNewResults("testMaxIntInsertSorted passed", index);		
		} catch(Exception e) {
			results.storeNewResults("testMaxIntInsertSorted failed: " + e.getMessage(), index);
		}
	}

		public void testMinIntInsertSorted(MyArrayList myList, int newValue, int index, Results results) {
		try {
			myList.insertSorted(newValue);
			results.storeNewResults("testMinIntInsertSorted passed", index);		
		} catch(Exception e) {
			results.storeNewResults("testMinIntInsertSorted failed: " + e.getMessage(), index);
		}
	}

		public void testMinRemoveValue(MyArrayList myList, int removedValue, int index, Results results) {
			try {
				myList.removeValue(removedValue);
				results.storeNewResults("testMinRemoveValue passed", index);
			} catch(Exception e) {
				results.storeNewResults("testMinREmoveValue failed: " + e.getMessage(), index);
			}
		}

		public void testMaxRemoveValue(MyArrayList myList, int removedValue, int index, Results results) {
			try {
				myList.removeValue(removedValue);
				results.storeNewResults("testMaxRemoveValue passed", index);
			} catch(Exception e) {
				results.storeNewResults("testMaxREmoveValue failed: " + e.getMessage(), index);
			}
		}

	public void testLegitimateValueIndexOf(MyArrayList myList, int value, int index, Results results) {
			try {
				int retVal = myList.indexOf(value);
				results.storeNewResults("testLegitimateValueIndexOf passed", index);
			} catch(Exception e) {
				results.storeNewResults("testLegitimateValueIndexOf failed: " + e.getMessage(), index);
			}
	}

	public void testNonExistantValueIndexOf(MyArrayList myList, int value, int index, Results results) {
			try {
				int retVal = myList.indexOf(value);
				results.storeNewResults("testNonExistantValueIndexOf passed", index);
			} catch (Exception e) {
				results.storeNewResults("testNonExistantValueIndexOf failed " + e.getMessage(), index);
			}
	}
		

	
	// int size();
	// int sum();
	// void toString(int[] array);
	
}
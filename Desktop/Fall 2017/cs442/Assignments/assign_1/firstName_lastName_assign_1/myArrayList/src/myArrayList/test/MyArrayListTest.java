package myArrayList.driver;

public class MyArrayListTest {

	public void testMe(MyArrayList myList, Results results) {
		for(int i = 0; i < 10; i++) {
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
			} else if(i == 6) {
				testSize(myList, i, results);
			} else if(i == 7) {
				testSum(myList, i, results);
			} else if(i == 8) {
				testToString(myList, i, results);
			} else {
				testAllAtOnce(myList, i, results);
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

	public void testSize(MyArrayList myList, int index, Results results) {
			try {
				int retVal = myList.size();
				results.storeNewResults("testSize passed", index);
			} catch (Exception e) {
				results.storeNewResults("testSize failed " + e.getMessage(), index);
			}
	}

	public void testSum(MyArrayList myList, int index, Results results) {
		try {
			int retVal = myList.sum();
			results.storeNewResults("testSum passed", index);
		} catch (Exception e) {
			results.storeNewResults("testSum failed " + e.getMessage(), index);
		}
	}
		
	public void testToString(MyArrayList myList, int index, Results results) {
		try {
			myList.toString(myList.getMyListArray());
			results.storeNewResults("testToString() passed", index);
		} catch (Exception e) {
			results.storeNewResults("testToString failed " + e.getMessage(), index);
		}
	}

	public void testAllAtOnce(MyArrayList myList, int index, Results results) {
		try {
			myList.insertSorted(35);
			myList.insertSorted(17);
			myList.removeValue(36);
			myList.removeValue(35);
			myList.indexOf(17);
			int size = myList.size();
			int sum = myList.sum();
			myList.toString(myList.getMyListArray());			
			results.storeNewResults("testAllAtOnce() passed", index);
		} catch (Exception e) {
			results.storeNewResults("testAllAtOnce() failed " + e.getMessage(), index);
		}
	}

	// void toString(int[] array);
	
}
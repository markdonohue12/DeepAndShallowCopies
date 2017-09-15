package myArrayList.driver;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class MyArrayList
{
	private int dataArr[];	
	private int fileReadZeros;
	
	public MyArrayList() {
		dataArr = new int[50];
		fileReadZeros = 0;
	}

	public MyArrayList(String inFile) {
		// set fileReadZeros to 0 because no numbers have been read from file yet
		int fileReadZeros = 0;
		// Create the FileProcessor obj so I can start reading from the file
		FileProcessor processFile = new FileProcessor(inFile);
		boolean openedSuccessfully = false;
		try {
			openedSuccessfully = processFile.openFile();
		}
		catch (FileNotFoundException e) {
			System.out.println("inside theFileNotFoundException");
		}

		// now if openedSuccessfully, start reading lines, each time storing the return value in the array
		if(openedSuccessfully) {
			dataArr = new int[50];
			int convertedInt = -1;
			int index = 0;
			int numsInserted = 0;
			String line = processFile.readFileLine();
			while(line != null) {
				try {
					convertedInt = Integer.parseInt(line);
					numsInserted += 1;
					if(numsInserted > dataArr.length) {
						increaseSize(dataArr);
					}
					dataArr[index] = convertedInt;
					if(convertedInt == 0) {
						fileReadZeros += 1;
					}
					index += 1;
				} catch (NumberFormatException e) {
					System.err.println("File contained a non-integer line, skipped line and continued");
				}
				line = processFile.readFileLine();
			}
		}
		printArray("before sorting", dataArr);
		// sort the array
		Arrays.sort(dataArr);
		printArray("AFTER sorting", dataArr);
		//change placeholder 0's to -1's and keep fileReadZeros bc those are genuine 0 entries
		int nonZeroIndex = 0;
		for(int i = 0; i < dataArr.length; i++) {
			if(dataArr[i] != 0) {
				nonZeroIndex = i;
				break;
			}
		}
		for(int i = nonZeroIndex - fileReadZeros - 1; i >= 0; i--) {
			dataArr[i] = -1;
		}
		printArray("AFTER PLACEHOLDER -1's ", dataArr);
	}

	public void increaseSize(int[] dataArray) {
		int oldLength = dataArray.length;
		int newLength = (int)(oldLength * 1.5);
		int newDataArr[] = Arrays.copyOf(dataArray, newLength);
		dataArr = newDataArr;
	}

	public void insertSorted(int newValue) {
		printArray("BEFORE INSERTION", dataArr);
		int insertAtIndex = -1;
		for(int i = 0; i < dataArr.length; i++) {
			if(newValue > dataArr[i]) {
				insertAtIndex = i;
			} else {
				break;
			}
		}
		for(int i = 0; i <= insertAtIndex; i++) {
			if(i == insertAtIndex) {
				dataArr[i] = newValue;
			}
			else {
				dataArr[i] = dataArr[i+1];
			}
		}
		printArray("after insertion", dataArr);
	}

	public void shiftRightRemoveHelper(int index) {
		for(int i = index; i > 0; i--) {
			dataArr[i] = dataArr[i-1];
		}
	}

	public void removeValue(int value) {
		printArray("before removeValue", dataArr);
		for(int i = 0; i < dataArr.length; i++) {
			if(dataArr[i] == value) {
				shiftRightRemoveHelper(i);
			}
		}
		printArray("AFTER removeValue", dataArr);
		Arrays.sort(dataArr);
	}

	public int indexOf(int value) {
		int result = -1;
		for(int i = 0; i < dataArr.length; i++) {
			if(dataArr[i] == value) {
				result = i;
				break; 
			}
		}
		return result;
	}

	public int size() {
		int arrCount = 0;
		for(int i = 0; i < dataArr.length; i++) {
			if(dataArr[i] != -1) {
				arrCount += 1;
			}
		}
		return arrCount;
	}

	public int sum() {
		int sum = 0;
		for(int i = 0; i < dataArr.length; i++) {
			if(dataArr[i] != -1) {
				sum += dataArr[i];
			}
		}
		return sum;
	}

	public void toString(int[] array) {
		System.out.println("nothing to see here");
	}

	public int[] getMyListArray() {
		return dataArr;
	}

	public void printArray(String describer, int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(describer+" value at index "+i+" is " + array[i]);
		}
	}
}
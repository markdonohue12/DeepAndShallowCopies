package myArrayList.driver;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class MyArrayList
{
	private int dataArr[];	

	public MyArrayList(String inFile) {
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
					index += 1;
				} catch (NumberFormatException e) {
					System.err.println("File contained a non-integer line, skipped line and continued");
				}
				line = processFile.readFileLine();
			}
		}
		// sort the array
		Arrays.sort(dataArr);
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

	public void printArray(String describer, int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(describer+" value at index "+i+" is " + array[i]);
		}
	}
}
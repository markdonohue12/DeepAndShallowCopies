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
			// while still lines left to read in input file
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
				} catch (NumberFormatException e) {
					System.err.println("File contained a non-integer line, skipped line and continued");
				}
				index += 1;
				line = processFile.readFileLine();
			}
		}
		for(int i = 0; i < dataArr.length; i++) {
			System.out.println("FINAL value at index " +i+" is " +dataArr[i]);
		}
	}

	public void increaseSize(int[] dataArray) {
		int oldLength = dataArray.length;
		int newLength = (int)(oldLength * 1.5);
		int newDataArr[] = Arrays.copyOf(dataArray, newLength);
		dataArr = newDataArr;
	}
	
}
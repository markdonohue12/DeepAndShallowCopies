package myArrayList.driver;

import java.io.FileNotFoundException;

public class MyArrayList
{
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
			int convertedInt = -1;
			String line = processFile.readFileLine();
			while(line != null) {
				System.out.println("line read from file is " + line);
				convertedInt = Integer.parseInt(line);
				System.out.println("the INT value is " + convertedInt);
				line = processFile.readFileLine();
				// convert String to int
				// if valid int, store it in the the array
			}
		}
		
	}
	
}
package studentCoursesBackup.driver;

import java.io.FileNotFoundException;

public class TreeBuilder {
	public TreeBuilder() {
		System.out.println("Building Trees or smoking 'em");
	}

	public void readFileForNodes(String inFile) {
		// create FileProcessor object to begin reading from file
		FileProcessor processFile = new FileProcessor(inFile);
		boolean openedSuccessfully = false;
		try {
			openedSuccessfully = processFile.openFile();
		}
		catch (FileNotFoundException e) {
			System.out.println("inside theFileNotFoundException");
		}
		if(openedSuccessfully) {
			// if opened successfully loop through entire input file
			// on each iteration doing the following: 
			//		parsing the return line in to Bnumber and Course strings
			//		call insert which lives in THIS CLASS
			// 		clone one time
			// 		insert the clone
			// 		clone two time
			// 		insert clone 2
			String line = processFile.readFileLine();
			while(line != null) {
				System.out.println("the bNumber is " + line);
				line = processFile.readFileLine();
			}
		}
	}
}
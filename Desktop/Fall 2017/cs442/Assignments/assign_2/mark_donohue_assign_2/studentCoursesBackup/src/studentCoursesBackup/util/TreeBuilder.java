package studentCoursesBackup.driver;

import java.io.FileNotFoundException;

public class TreeBuilder {

	private Node left, right;
	int keyBNumber;
	String valueCourse;

	public TreeBuilder() {
		keyBNumber = 0;
		valueCourse = " ";
	}

	public void insert(Node node) {
		
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
				// parse the input
				String[] parcedInput = parseInput(line);

				// convert bNumber from String to int
				int bNum = Integer.parseInt(parcedInput[0]);
				String course = parcedInput[1];

				// now that we have the BNumber and the course, create a Node 
				Node node = new Node(bNum, course);
				
				// now that I have Node object, I want to insert that node into the tree
				insert(node);			

				line = processFile.readFileLine();
			}
		}
	}
	
	// USED THIS SITE: http://pages.cs.wisc.edu/~hasti/cs302/examples/Parsing/parseString.html
	private String[] parseInput(String line) {
		String flag = "[:]+";
		String[] parcedInput = line.split(flag);
		return parcedInput;
	}
}
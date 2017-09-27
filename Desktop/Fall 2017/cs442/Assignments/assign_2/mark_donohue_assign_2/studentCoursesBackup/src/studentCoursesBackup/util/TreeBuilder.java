package studentCoursesBackup.driver;

import java.io.FileNotFoundException;
import java.lang.CloneNotSupportedException;
import java.util.Arrays;

public class TreeBuilder {

	private Node root;

	public TreeBuilder() {
		root = null;
	}

	private Node insert(Node node, int bNumber, String course) {
		if(node == null) {
			node = new Node(bNumber, course);
		} else {
			if(bNumber <= node.getBNumber()) {
				Node leftNode = node.getLeft();
				leftNode = insert(node.getLeft(), bNumber, course);
			} else {
				Node rightNode = node.getRight();
				rightNode = insert(node.getRight(), bNumber, course);
			}
		}
		System.out.println("successfully returned node");
		return node;
	}

	public void insert(int bNumber, String course) {
		root = insert(root, bNumber, course);
	}

	public void clone1(Node node_orig, int bNumber, String course, int iteration) {
		if(iteration == 0) {
			TreeBuilder clone1Tree = new TreeBuilder();
		}
		try {
			Node clonedNode1 = (Node) node_orig.clone();
			System.out.println("Successfully cloned node 1");
			System.out.println("Cloned1's BNumber is " + clonedNode1.getBNumber());
			System.out.println("Cloned1's courses are " + Arrays.toString(clonedNode1.getCourses().toArray()));
		} catch (CloneNotSupportedException e) {													System.err.println("Error cloning clonedNode1 " + e.getMessage());
		}
	}

	public void clone2(Node node_orig, int bNumber, String course, int iteration) {
		if(iteration == 0) {
			TreeBuilder clone2Tree = new TreeBuilder();
		}
		try {
			Node clonedNode2 = (Node) node_orig.clone();
			System.out.println("Successfully cloned node 2");
			System.out.println("Cloned2's BNumber is " + clonedNode2.getBNumber());
		} catch (CloneNotSupportedException e) {													System.err.println("Error cloning clonedNode2 " + e.getMessage());
		}
	}

	// used this URL: http://www.sanfoundry.com/java-program-implement-binary-search-tree/
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
			int iteration = 0;
			while(line != null) {
				// parse the input
				String[] parcedInput = parseInput(line);

				// convert bNumber from String to int
				int bNum = Integer.parseInt(parcedInput[0]);
				String course = parcedInput[1];

				// now that we have the BNumber and the course, create a Node 
				Node node_orig = new Node(bNum, course);
				
				// now that I have Node object, I want to insert that node into the tree
				insert(bNum, course);
				System.out.println("Node_orig's BNumber is " + node_orig.getBNumber());

				// make the first clone
				// if this is the first iteration of the loop, then we need to 
				// create a new TreeBuilder object, because we are starting a 
				// new tree with a new root and everything
				// so I want to 
				// call the clone1() function, passing in the bNumber, course, and the iteration	
				clone1(node_orig, bNum, course, iteration);
				clone2(node_orig, bNum, course, iteration);

				// on iteration 1 within the clone1 function, I will make a new object
				
								

				line = processFile.readFileLine();
				iteration += 1;
			}
		}
	}
	
	// USED THIS SITE: http://pages.cs.wisc.edu/~hasti/cs302/examples/Parsing/parseString.html
	private String[] parseInput(String line) {
		String flag = "[:]";
		String[] parcedInput = line.split(flag);
		return parcedInput;
	}
}
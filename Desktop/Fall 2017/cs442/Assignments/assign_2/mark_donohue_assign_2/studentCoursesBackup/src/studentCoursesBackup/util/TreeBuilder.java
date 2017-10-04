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
		return node;
	}

	public void insert(int bNumber, String course) {
		root = insert(root, bNumber, course);
	}

	public Node clone1(Node node_orig, int bNumber, String course, int iteration) {
		Node clonedNode1 = null;
		if(iteration == 0) {
			TreeBuilder clone1Tree = new TreeBuilder();
		}
		try {
			clonedNode1 = (Node) node_orig.clone();
		} catch (CloneNotSupportedException e) {													System.err.println("Error cloning clonedNode1 " + e.getMessage());
		} 
		return clonedNode1;
	}

	public Node clone2(Node node_orig, int bNumber, String course, int iteration) {
		Node clonedNode2 = null;
		if(iteration == 0) {
			TreeBuilder clone2Tree = new TreeBuilder();
		}
		try {
			clonedNode2 = (Node) node_orig.clone();
		} catch (CloneNotSupportedException e) {													System.err.println("Error cloning clonedNode2 " + e.getMessage());
		} 
		return clonedNode2;
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


				// ———————————————————————————————

				// before we make a new node we need to search through the tree
				// if we find a BNum match, just add: node.studentCourses.add(course)
				// if we do not find that Bnum, we know we need to make a new node

				// —————————————————————————————————————



				// now that we have the BNumber and the course, create a Node 
				Node node_orig = new Node(bNum, course);
				
				// now that I have Node object, I want to insert that node into the tree
				insert(bNum, course);
				System.out.println("Node_orig's BNumber is " + node_orig.getBNumber());

				// make the first clone
				// if this is the first iteration of the loop, then we need to 
				// create a new TreeBuilder object, because we are starting a 
				// new backup tree with a new root and everything
				// so I want to 
				// call the clone1() function, passing in the bNumber, course, and the iteration	
				Node backup_Node_1 = clone1(node_orig, bNum, course, iteration);
				Node backup_Node_2 = clone2(node_orig, bNum, course, iteration);

				System.out.println(" =================================== ");
				System.out.println("backup_Node_1's bNumber is " + backup_Node_1.getBNumber());	
				System.out.println("Cloned1's courses are ");
				for(String cstring : backup_Node_1.getCourses()) {
					System.out.println(cstring);
				}					

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
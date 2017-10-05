package studentCoursesBackup.driver;

import java.io.FileNotFoundException;
import java.lang.CloneNotSupportedException;
import java.util.Arrays;

public class TreeBuilder {

	private Node root;
	public static TreeBuilder clone1Tree = null;
	public static TreeBuilder clone2Tree = null;

	public TreeBuilder() {
		root = null;
	}

	private Node insert(Node node, int bNumber, String course) {
		if(node == null) {
			node = new Node(bNumber, course);
		} else {
			if(bNumber <= node.getBNumber()) {
				node.left = insert(node.getLeft(), bNumber, course);
			} else {	
				node.right = insert(node.getRight(), bNumber, course);
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
			clone1Tree = new TreeBuilder();
		}
		try {
			clonedNode1 = (Node) node_orig.clone();
			clone1Tree.insert(bNumber, course);
		} catch (CloneNotSupportedException e) {													System.err.println("Error cloning clonedNode1 " + e.getMessage());
		} 
		return clonedNode1;
	}

	public Node clone2(Node node_orig, int bNumber, String course, int iteration) {
		Node clonedNode2 = null;
		if(iteration == 0) {
			clone2Tree = new TreeBuilder();
		}
		try {
			clonedNode2 = (Node) node_orig.clone();
			clone2Tree.insert(bNumber, course);
		} catch (CloneNotSupportedException e) {													System.err.println("Error cloning clonedNode2 " + e.getMessage());
		} 
		return clonedNode2;
	}

	  // url http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

      public Node search(Node root, int key) {
			// Base Cases: root is null or key is present at root
    		if (root==null || root.getBNumber() == key)
       			return root;
 
    		// val is greater than root's key
   		 	if (root.getBNumber() > key)
        		return search(root.getLeft(), key);
 
    		// val is less than root's key
    		return search(root.getRight(), key);
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
				// if we find a Bnum match, just add: node.studentCourses.add(course)
				// if we do not find that Bnum, we know we need to make a new node

				// search for bNum
				Node foundNode = search(root, bNum);
				if(foundNode == null) {
					// System.out.println("Iteration " + iteration + " 
					// did not find BNum: "                   
					// + bNum + " Inserting " + bNum + ":" + course);
					// if here we know that the node does not exist yet 
					// and therefore needs to be created and inserted	

					Node node_orig = new Node(bNum, course);
					this.insert(bNum, course);
					// clone original node, insert them into their respective trees
					// Note: insert called within cloneN(…) methods
					Node backup_Node_1 = clone1(node_orig, bNum, course, iteration);
					Node backup_Node_2 = clone2(node_orig, bNum, course, iteration);
					
					// now need to insert the backup_Nodes into their respective trees

				} else {
					// if here we know that the Node already exists and so all 
					// we have to do is add the course to the studentCourses list
					foundNode.getCourses().add(course);
				}

				// —————————————————————————————————————			
				if(iteration > 0 && foundNode != null) {
					System.out.print("Iteration " + iteration + " BNum: " + foundNode.getBNumber() + "'s courses are: " );
					for(String string : foundNode.getCourses()) {
						System.out.print(string + " ");
					}
					System.out.println();
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

	public Node getRoot() {
		return root;
	}
}
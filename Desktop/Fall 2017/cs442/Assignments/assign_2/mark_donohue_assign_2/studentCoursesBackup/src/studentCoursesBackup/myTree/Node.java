package studentCoursesBackup.driver;

import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Node {
	private int bNumber;
	private ArrayList<String> studentCourses;

	public Node(String inFile) {
		FileProcessor processFile = new FileProcessor(inFile);
		boolean openedSuccessfully = false;
		try {
			openedSuccessfully = processFile.openFile();
		}
		catch (FileNotFoundException e) {
			System.out.println("inside theFileNotFoundException");
		}
		if(openedSuccessfully) {
			String line = processFile.readFileLine();
			while(line != null) {
				System.out.println("the bNumber is " + line);
				line = processFile.readFileLine();
			}
		}
	}
}
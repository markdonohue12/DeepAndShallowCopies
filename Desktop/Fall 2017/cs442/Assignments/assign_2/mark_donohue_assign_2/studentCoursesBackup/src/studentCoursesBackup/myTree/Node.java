package studentCoursesBackup.driver;

import java.util.ArrayList;

public class Node implements Cloneable {

	private int bNumber;
	private ArrayList<String> studentCourses;
	public Node left, right;

	public Node() {
		bNumber = -1;
		studentCourses = new ArrayList<String>();
		left = null;
		right = null;
	}

	public Object clone() throws CloneNotSupportedException {
 		Node newNode = new Node();
		newNode.bNumber = bNumber;
		newNode.left = left;
		newNode.right = right;
		for(String course : studentCourses) {
   			 newNode.studentCourses.add(course);
		}   	

		return super.clone();
	}
	
	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public int getBNumber() {
		return bNumber;
	}

	public ArrayList<String> getCourses() {
		return studentCourses;
	}

	public Node(int bNum, String course) {
		bNumber = bNum;
		studentCourses = new ArrayList<String>();
		studentCourses.add(course);
		left = null;
		right = null;
	}
}
package studentCoursesBackup.driver;

import java.util.ArrayList;

public class Node {
	private int bNumber;
	private ArrayList<String> studentCourses;

	public Node() {
		System.out.println("Hey the default constructor gets called too you know");
		bNumber = -1;
		studentCourses = new ArrayList<String>();
	}

	public Node(int bNum, String course) {
		bNumber = bNum;
		studentCourses = new ArrayList<String>();
		studentCourses.add(course);
	}
}
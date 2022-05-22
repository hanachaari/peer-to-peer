package peer_to_peer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import peer_to_peer.model.Availability;
import peer_to_peer.model.Student;
import peer_to_peer.textualInterface.StudentInterface;
import peer_to_peer.model.Course;
import peer_to_peer.model.Level;
import peer_to_peer.model.Meeting;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		 Level level;
		Student students = new Student();
		StudentInterface levelMenu = new StudentInterface();
		Availability availabilities = new Availability();
		Course courses = new Course();
		Meeting meetings = new Meeting();
		int choice; 
		do {
		
		System.out.println(" 		*** Welcome to Peer-To-Peer ***");
		System.out.println(" 			*** Principle Menu ***");
		System.out.println("1- Students");
		System.out.println("2- Courses");
		System.out.println("3- Meeting");
		 choice = s.nextInt();
		
		switch(choice)
		{
		
		case 1:
			students.StudentMenu(students);
			break;
		case 2:
			courses.CourseMenu(courses);	
			break;
		case 3:
			System.out.println("-The Courses Available: ");
			System.out.println("");
			courses.displayAllCourses();
			System.out.println("Enter the course to find tutors: ");
			String title = s.next();
			System.out.println("Enter the level to find tutors: ");
			level = levelMenu.select_level(students);
			/*for(int i = 0; i < meetings.sortBadStudents(title, level).size(); i++) { 
				Student st= (Student)meetings.sortBadStudents(title, level).get(i);
			    System.out.print(" id= "+st.getId()+" || first name= "+st.getFirstName());
			} 
			for(int i = 0; i < meetings.sortGoodStudents(title, level).size(); i++) { 
				Student st= (Student)meetings.sortGoodStudents(title, level).get(i);
			    System.out.print(" id= "+st.getId()+" || first name= "+st.getFirstName());
			} */
			
			meetings.matchingAvailability(meetings.sortBadStudents(title, level), meetings.sortGoodStudents(title, level));
			break;
	
		}
		



	}
		while(choice != 5);
}
}

package peer_to_peer.textualInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import peer_to_peer.model.Availability;
import peer_to_peer.model.Level;
import peer_to_peer.model.Student;

public class StudentInterface {
	public Scanner s = new Scanner(System.in);
	
	
////////////////////////////////////////////////// add student /////////////////////////////////////////////////////
	public Student addStudent() {

		System.out.println("ID: ");
		String ID = s.next();
		System.out.println("First Name: ");
		String firstName = s.next();
		System.out.println("Last Name: ");
		String lastName = s.next();
		Student student= new Student(ID, firstName, lastName);
		Level level = select_level(student);
		student.setLevel(level);
		System.out.println(" 		*** Courses *** ");
		System.out.println("Enter the number of taken courses: ");
		int n = s.nextInt();
		for(int i=0; i<n; i++)
		{
			student.setNewCourseGrade(level);
		}
		System.out.println(" 		*** Availability *** ");
		int j =0;
		while (j != 1)
		{
			student.getAvailablitiesStudent().add();
			System.out.println("1- Add availability");
			System.out.println("10-Exit");
			int choice = s.nextInt();
			if (choice ==10) {
				j = 1;
			}
			
		}
		
		return student;
	}
	
////////////////////////////////////////////////// select level /////////////////////////////////////////////////////
	public Level select_level(Student student) {
		int choice;
		Level level1 = null;
	
				System.out.println("Choose a level: ");
				System.out.println("0-freshman ");
				System.out.println("1-sophomore");
				System.out.println("2-junior");
				System.out.println("3-senior ");
				System.out.println("4-final");
				
				choice = s.nextInt();
			

			switch (choice) {
			case 0:
				level1 = student.getLevel().FRESHMAN;
				break;
			case 1:
				level1 = student.getLevel().SOPHOMORE;
				break;
			case 2:
				level1 = student.getLevel().JUNIOR;
				break;
			case 3:
				level1 = student.getLevel().SENIOR;
				break;
			case 4:
				level1 = student.getLevel().FINAL;
				break;

			}

	
		return level1;
}
////////////////////////////////////////////////// search a student /////////////////////////////////////////////////////
	public int searchStudent(ArrayList<Student> students) {
		System.out.println("Enter the ID of the student :");
		String id = s.next();
		int index = -1;
		
		do {
			for(int i = 0; i < students.size(); i++)
			{
				if(id.equals((students.get(i)).getId())) {
					index = i;
				}
			}
			if (index == -1) {
				System.out.println("The ID does not exist");
				System.out.println("Please try again");
				id = s.next();
			}
		}while(index == -1);
		return index;
	}
	//////////////////////// Student course menu /////////////////////////
	public void StudentCourseMenu(Student student)
	{
		int choice;
	
		do
		{
			System.out.println("		*** Welcome to "+ student.getFirstName() + " Course Menu ***");
			System.out.println("1-Display all course and grades");
			System.out.println("2-Add a course and grade");
			System.out.println("3-Modify a course and grade");
			System.out.println("4-Delete a course and grade");
			System.out.println("5-Back to principle menu");
			
			 choice = s.nextInt();
			switch(choice) {
			case 1:
				System.out.println(student.getCourseGrade());
				break;
			case 2:
				student.setNewCourseGrade(student.getLevel());
				break;
			case 3:
				student.setCourseGrade(student.moddifyCourseGradeStudent(student.getCourseGrade(), student.getLevel()));
				break;
			case 4:
				student.setCourseGrade(student.deleteCourseGradeStudent(student.getCourseGrade(), student.getLevel()));
				break;
		
		}
		

		}while(choice < 5);

	}
//////////////////////////////////////////////////Availability Student Menu /////////////////////////////////////////
	public void AvailabilityStudentMenu(Student student)
	{
		int choice;
		
		do
		{
			System.out.println("		*** Welcome to " +student.getFirstName()+" Availablities ***");
			System.out.println("1-Display all Availablities");
			System.out.println("2-Add an availability");
			System.out.println("3-Modify an availability");
			System.out.println("4-Search an availability");
			System.out.println("5-Delete an availability");
			System.out.println("6-Back to principle menu");
			
			choice = s.nextInt();
			switch(choice) {
				case 1:
					student.getAvailablitiesStudent().displayAllAvailabilities();
				break;
				case 2:
					student.getAvailablitiesStudent().add();
				break;
				case 3:
					student.getAvailablitiesStudent().modify();
				break;
				case 4:
					student.getAvailablitiesStudent().displaySearchedAvailability(student.getAvailablitiesStudent().search());
				break;
				case 5:
					student.getAvailablitiesStudent().delete();
					student.getAvailablitiesStudent().setTotalAvailabilities(student.getAvailablitiesStudent().getTotalAvailabilities()-1);;

				break;
			
		
		}
	
	
	}while(choice < 6);
	
	}	


	 /////////////////////// modify student  details//////////////////////
	public Student modifyStudent(ArrayList<Student> students,int index)
	{
		int choice;
		do {
			do {
				System.out.println("You want to modify:");
				System.out.println("1-Student ID");
				System.out.println("2-Student First Name");
				System.out.println("3-Student Last Name");
				System.out.println("4-Student courses");
				System.out.println("5-Student availabilities");
				System.out.println("0-Exit");
				choice = s.nextInt();

				if ((choice > 4) && (choice < 0)) {
					System.out.println("ERROR");
					System.out.println("Please try again");
				}

			} while ((choice > 4) && (choice < 0));

			switch (choice) {
			case 1:
				System.out.println("The old Id:		" + students.get(index).getId());
				System.out.println("Enter the course new Title");
				(students.get(index)).setID(s.next());
				break;
			case 2:
				System.out.println("The old first name:		" + students.get(index).getFirstName());
				System.out.println("Enter the new first name");
				(students.get(index)).setFirstName(s.next());
				break;
			case 3:
				System.out.println("The old last name:		" +(students.get(index)).getLastName());
				System.out.println("Enter the new last name");
				(students.get(index)).setLastName(s.next());
				break;
			case 4:
				this.StudentCourseMenu(students.get(index));
				break;
			case 5:
				this.AvailabilityStudentMenu(students.get(index));
				break;
			

			}
		} while (choice != 0);
		return students.get(index);
	}
}

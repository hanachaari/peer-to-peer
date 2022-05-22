package peer_to_peer.model;

import java.util.Scanner;
import java.util.ArrayList;

import peer_to_peer.textualInterface.CourseInterface;
import peer_to_peer.dao.CourseDao;

public class Course {
	
	private String title;
	private ArrayList<Student> studentsOfCourse ;
	private int numberStudents;
	private Level level;
	private CourseDao tool = new CourseDao();
	private CourseInterface textualInterface  = new CourseInterface();
	
	public Scanner s= new Scanner(System.in);
	
	public Course()
	{
		
	}
	public Course(String title)
	{
		this.title=title;
	}
	public Course (String title, Level level , int numberStudents) {
		this.level=level;
		this.numberStudents=numberStudents;
		this.title=title;
	}
	
	//////////////// Getters&Setters //////////////////////////////////////
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	
	public int getNumberStudents() {
		return numberStudents;
	}
	
	public void setNumberStudents(int numberStudents) {
		this.numberStudents = numberStudents;
	}
	////////////////////////// displayCourseLevel ////////////////////////////
	public void displayCoursesLevel(Level level)
	{ 		ArrayList<Course> courses= (ArrayList<Course>)tool.getAll();
;
	for (int i =0; i< courses.size(); i++)
		{
			if(courses.get(i).getLevel() == level)
			{
				System.out.println("Title:		"+ courses.get(i).getTitle());
				System.out.println("level:		"+ courses.get(i).getLevel());
				System.out.println("Number of students: "+ courses.get(i).getNumberStudents());
				System.out.println("------------------------------------");
			}
		}
	
	}
	////////////////////////// displayAllCourses /////////////////////////////
	public void displayAllCourses()
	{ 		ArrayList<Course> courses= (ArrayList<Course>)tool.getAll();
;
	for (int i =0; i< courses.size(); i++)
		{
			System.out.println("Title:		"+ courses.get(i).getTitle());
			System.out.println("level:		"+ courses.get(i).getLevel());
			System.out.println("Number of students: "+ courses.get(i).getNumberStudents());
			System.out.println("------------------------------------");
		}
	
	}
	//////////////////////////displaySearchedCourse /////////////////////////////
	public void displaySearchedCourse(Course course)
	{
		
		System.out.println("Title:		"+ course.getTitle());
		System.out.println("level:		"+ course.getLevel());
		System.out.println("Number of students: "+ course.getNumberStudents());
	
	}
	///////////////////////// add new Course //////////////////////////////////////
	public void add() {
		tool.save(textualInterface.addCourse()); 
	}
	////////////////////////////// search Course //////////////////////////////////////
	public Course search() {
		ArrayList<Course> courses= (ArrayList<Course>)tool.getAll();
		return tool.get(textualInterface.searchCourse(courses)); 
	}
	
	//////////////////////// delete Course //////////////////////////////////////
	public void delete() {
		ArrayList<Course> courses= (ArrayList<Course>)tool.getAll();
		tool.delete(courses.get(textualInterface.searchCourse(courses))); 
		}
	/////////////////////modify Course ////////////////////////////
	public void modify()  
	{
		ArrayList<Course> courses= (ArrayList<Course>)tool.getAll();
		int index = textualInterface.searchCourse(courses);
		tool.update(index, textualInterface.modifyCourse(courses, index));
	}
	/////////////////////////// Course Menu //////////////////////////////////
	public void CourseMenu(Course courses)
	{
		int choice;
	
		do
		{
			System.out.println("		*** Welcome to Courses ***");
			System.out.println("1-Display all Courses");
			System.out.println("2-Add a course");
			System.out.println("3-Modify a course");
			System.out.println("4-Search a course");
			System.out.println("5-Delete a course");
			System.out.println("6-Back to principle menu");
			
			 choice = s.nextInt();
			switch(choice) {
			case 1:
				courses.displayAllCourses();
				break;
			case 2:
				courses.add();
				break;
			case 3:
				courses.modify();
				break;
			case 4:
				courses.displaySearchedCourse(courses.search());
				break;
			case 5:
				courses.delete();
				break;
			case 6:
		
		}
		

		}while(choice < 6);

	}	
	
	
}

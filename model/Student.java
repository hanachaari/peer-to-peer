package peer_to_peer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import peer_to_peer.textualInterface.StudentInterface;
import peer_to_peer.textualInterface.AvailabilityInterface;
import peer_to_peer.textualInterface.CourseInterface;
import peer_to_peer.dao.AvailabilityDao;
import peer_to_peer.dao.CourseDao;
import peer_to_peer.dao.StudentDao;


public class Student extends Person {

	private String id;
	private Level level;
	private HashMap<String, Double> courseGrade= new HashMap<String, Double> ();
	private Availability availablitiesStudent= new Availability() ;
	private ArrayList<Meeting> tutoringMeetings;
	private ArrayList<Meeting> tutoredMeetings;
	
	private StudentDao tool = new StudentDao();
	private CourseDao tool2 = new CourseDao();
	//private AvailabilityDao tool3 = new AvailabilityDao(availablities);
	Scanner s = new Scanner(System.in);


	private StudentInterface textualInterface  = new StudentInterface();
	private CourseInterface textualInterface2  = new CourseInterface();
	//private AvailabilityInterface textualInterface3  = new AvailabilityInterface();



	public Student() {
		super();
	}

	public Student(String id, String firstName, String lastName) {
		super(firstName, lastName);
		this.id = id;
		/*this.availablities = availablities;
		this.tutoringMeetings = new ArrayList<>();
		this.tutoredMeetings = new ArrayList<>();*/
		
	}
	////////////////////////// Getters&Setters /////////////////////////////////////

	public String getId() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public HashMap<String, Double> getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(HashMap<String, Double> courseGrade) {
		this.courseGrade = courseGrade;
	}

	public Availability getAvailablitiesStudent() {
		return availablitiesStudent;
	}

	public void setAvailablitiesStudent(Availability availablitiesStudent) {
		this.availablitiesStudent = availablitiesStudent;
	}


	
	public ArrayList<Meeting> getTutoringMeetings() {
		return tutoringMeetings;
	}

	public void setTutoringMeetings(ArrayList<Meeting> tutoringMeetings) {
		this.tutoringMeetings = tutoringMeetings;
	}

	public ArrayList<Meeting> getTutoredMeetings() {
		return tutoredMeetings;
	}

	public void setTutoredMeetings(ArrayList<Meeting> tutoredMeetings) {
		this.tutoredMeetings = tutoredMeetings;
	}

	/////////////////////////////// Get a grade of a course /////////////////////////////////////////////////////
	
	public void  getGradeOfACourse(Level level) {
		String name=textualInterface2.addACourseName(level);//get the name of the course 
		System.out.println("grade in "+name+" "+courseGrade.get(name)); 
	 }
	
	////////////////////////////// Set new course grade ////////////////////////////////////////////////// 
	public void setNewCourseGrade(Level level) {
		
		String name=textualInterface2.addACourseName(level);
		Double grade=textualInterface2.addACourseGrade();
		courseGrade.put(name,grade);
		//System.out.println(courseGrade);
	
		 List <Course> courses= tool2.getAll();
		 for(int i=0;i<courses.size();i++) {
			 Course c=courses.get(i);
			 if(name.equals(c.getTitle())) {
			 c.setNumberStudents(c.getNumberStudents()+1);
				 break;
			 }
		 }
		}
	////////////////////////////////////////////////modify student course ////////////////////////////////////////
	public HashMap<String, Double> moddifyCourseGradeStudent( HashMap<String, Double> courseGrade, Level level)
	{
		System.out.println("The courses taken are: ");
		System.out.println(courseGrade);
		System.out.println("Enter the course to modify: ");
		String courseName = s.next();
		/*courseGrade.remove(courseName);
		String newCourseName = textualInterface2.addACourseName(level);*/
		double newCourseGrade = textualInterface2.addACourseGrade();
		courseGrade.put(courseName,newCourseGrade);
		return courseGrade;
	}
	
	////////////////////////////////////////////// delete student course //////////////////////////////////////////
	public HashMap<String, Double> deleteCourseGradeStudent( HashMap<String, Double> courseGrade, Level level)
	{
		System.out.println("The courses taken are: ");
		System.out.println(courseGrade);
		System.out.println("Enter the course to delete: ");
		String courseName = s.next();
		courseGrade.remove(courseName);
		return courseGrade;
	}

	///////////////////////// add new student //////////////////////////////////////
	public void add() {
		tool.save(textualInterface.addStudent()); ///textualInterface.addStudent() --> returns Student
	}
	
	////////////////////////////// search student//////////////////////
	
	public Student search() {
		ArrayList<Student> students=(ArrayList<Student>)tool.getAll();
		 return tool.get(textualInterface.searchStudent(students)); ///textualInterface.searchStudent(students) --> returns int(index)
	}

	//////////////////////// delete student ////////////////////////////////////////
	public void delete() {
		ArrayList<Student> students=(ArrayList<Student>)tool.getAll();
		//System.out.println(textualInterface.searchStudent(students));
		tool.delete(students.get(textualInterface.searchStudent(students))); ///students.get(textualInterface.searchStudent(students)) --> returns Student 
	}
	/////////////////////modify student details ////////////////////////////
	public void modify()  

	{
		ArrayList<Student> students=(ArrayList<Student>)tool.getAll();
		int index = textualInterface.searchStudent(students);
		tool.update(index, textualInterface.modifyStudent(students, index));///textualInterface.modifyStudent(students, index) --> returns Student 

	}

	/////////////////////////////// display All Students /////////////////////////
	public void displayAllStudents() {
		ArrayList<Student> students=(ArrayList<Student>)tool.getAll();
		for (int i = 0; i < students.size(); i++) {
			System.out.println("ID:			" + students.get(i).getId());
			System.out.println("First Name:		" + students.get(i).getFirstName());
			System.out.println("Last Name:		" + students.get(i).getLastName());
			System.out.println("------------------------------------");
		}
		
	}

	/////////////////////////////// display Searched Student /////////////////////////////// /////////////////////////
	public void displaySearchedStudent(Student student) {
		System.out.println("ID:			" + student.getId());
		System.out.println("First Name:		" + student.getFirstName());
		System.out.println("Last Name:		" + student.getLastName());
		System.out.println("------------------------------------");

	}

	/////////////////////////////// display Student information /////////////////////////////// /////////////////////////
	public void displayStudentInformation() {
		ArrayList<Student> students=(ArrayList<Student>)tool.getAll();
		int index = textualInterface.searchStudent(students);
		System.out.println("ID:			" + students.get(index).getId());
		System.out.println("First Name:		" + students.get(index).getFirstName());
		System.out.println("Last Name:		" + students.get(index).getLastName());
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println();
		System.out.println(students.get(index).level); 
		System.out.println();
		System.out.println("		Courses and Grades		");
		System.out.println(students.get(index).courseGrade); 
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println();
		System.out.println("		Availibility		");
		students.get(index).availablitiesStudent.displayStudentAvailabilities(students.get(index));

	}
	
	
	public void importStudents(String file) {
		ArrayList<Student> students=(ArrayList<Student>)tool.getAll();
		ArrayList<Student> studentsImported=(ArrayList<Student>)tool.importStudents(file);
		for(int i=0; i<studentsImported.size();i++) {
			tool.save(studentsImported.get(i));
			}
		}
	
	///////////////////////////////////// Student Menu ///////////////////////////////////////////////////////////////////
	public void StudentMenu(Student students)
	{
		int choice;
	
		do
		{
			System.out.println("		*** Welcome to Students ***");
			System.out.println("1-Display all students");
			System.out.println("2-Display a student personal information");
			System.out.println("3-Add a student");
			System.out.println("4-Modify a student");
			System.out.println("5-Search a student");
			System.out.println("6-Delete a student");
			System.out.println("7-Import Students");
			System.out.println("8-Back to principle menu");
			
			 choice = s.nextInt();
			switch(choice) {
			case 1:
				students.displayAllStudents();
				break;
			case 2:
				students.displayStudentInformation();
				break;
			case 3:
				students.add();
				break;
			case 4:
				students.modify();
				break;
			case 5:
				students.displaySearchedStudent(students.search());;
				break;
			case 6:
				students.delete();
				break;
			case 7:
				System.out.println("Enter the file name");
				String file = s.next();
				students.importStudents(file);;
				break;
		
		}
		

		}while(choice < 8);

	}	
	

}
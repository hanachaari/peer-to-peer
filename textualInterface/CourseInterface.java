package peer_to_peer.textualInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import peer_to_peer.model.Level;
import peer_to_peer.model.Course;

public class CourseInterface {
	
	public Scanner s = new Scanner(System.in);

	public Level selectLevel(Course course)
	{
		int choice;
		Level level1 = null;
		
			
				 System.out.println("Choose a level: ");
				 System.out.println("1-freshman ");
				 System.out.println("2-sophomore");
				 System.out.println("3-junior");
				 System.out.println("4-senior ");
				 System.out.println("5-final");
				 choice = s.nextInt();
				 
			 
			 switch(choice)
			 {
			 case 1:
				 level1 = course.getLevel().FRESHMAN;
				 break;
			 case 2: 
				 level1 = course.getLevel().SOPHOMORE;
			 	break;
			 case 3:
				 level1 = course.getLevel().JUNIOR;
				 break;
			 case 4:
				 level1 = course.getLevel().SENIOR;
				 break;
			 case 5:
				 level1 = course.getLevel().FINAL;
				 break;
			 }
			 
		return level1;
	}
									/////////////////// add_a_course&Grade /////////////////////
	
	//////////////////////////////////////////////////// add course to student /////////////////////////////////////
	public String addACourseName(Level level) {
		Course course= new Course();
		System.out.println("-The Courses Available: ");
		System.out.println("");
		course.displayCoursesLevel(level);
		System.out.println("Enter the course name");
		String courseName=s.next();
		return courseName;
	}
	///////////////////////////////////////////////// add grade to student /////////////////////////////////////////

	public Double addACourseGrade() {
	 System.out.println("Enter the course grade");
	 Double courseGrade=s.nextDouble();
	return courseGrade;
	}
	
	
	
	/////////////////// add_course /////////////////////
		
		public Course addCourse() {
			
			 
			 Course course= new Course();
			 System.out.println("Enter the course name");
			 String title=s.next();
			 Level level = selectLevel(course);
			 course.setTitle(title);
			 course.setLevel(level);
			 return course;
		}
	
	/////////////////// SearchCourse /////////////////////
		public int searchCourse (ArrayList<Course> courses) {
	
			 String title;
			 Level level1;
			 int index=-1;
			 do 
			 {
				 System.out.println("Enter the course name: ");
				 title= s.next();
				 Course course1= new Course(title);
				 level1 = selectLevel(course1); 
			 
			 for(int i=0; i <courses.size();i++)
			 {
				 if ( ((courses.get(i).getTitle()).equals(title)) && ((courses.get(i).getLevel()).equals(level1)) ) {
					 index = i;
				 }
			 }
			 	if (index < 0)
			 	{
			 		System.out.println("The course entered does not exist");
			 		System.out.println("Please try again");
			 	}
			 }while(index<0);
			 return index;
			 }
		
	/////////////////// ModifyCourse /////////////////////
		public Course modifyCourse(ArrayList<Course> courses,int index)
		{
			int choice;
			do
			{
				do 
				 {
					 System.out.println("You want to modify:");
					 System.out.println("1-Course title");
					 System.out.println("2-Course level");
					 System.out.println("3-Exit");
					  choice = s.nextInt();
					  
					  if ((choice > 3 ) && (choice < 0))
					  {
						  System.out.println("ERROR");
						  System.out.println("Please try again");
					  }

				 }while((choice > 3 ) && (choice < 0));
				
				switch(choice)
				{
				case 1:
					System.out.println("The old course title:		"+(courses.get(index)).getTitle());
					System.out.println("Enter the course new Title");
					(courses.get(index)).setTitle(s.next());
					break;
				case 2:
					System.out.println("The course old level:		"+(courses.get(index)).getLevel());
					System.out.println("Enter the course new level");
					(courses.get(index)).setLevel(selectLevel(courses.get(index)));
					break;
					
				}
			}while(choice != 3);
			return courses.get(index);
		}


	
	
	}

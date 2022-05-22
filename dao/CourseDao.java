package peer_to_peer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import peer_to_peer.model.Course;

public class CourseDao implements Dao<Course> {
	
	 static private List<Course>courses= new ArrayList<>();
	 Scanner s = new Scanner(System.in);
	 
	 @Override
		public Course get(int index) {
			return courses.get(index);
		}

		@Override
		public List<Course> getAll() {
			return courses;
		}

		@Override
		public void save(Course course) {
			courses.add(course);
		}

		@Override
		public void update(int index, Course course) {
			courses.set(index, course);
		}

		@Override
		public void delete(Course course) {
			courses.remove(course); 
			
		}
	 

}

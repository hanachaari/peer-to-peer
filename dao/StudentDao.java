package peer_to_peer.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import peer_to_peer.model.Level;
import peer_to_peer.model.Student;

public class StudentDao implements Dao<Student> {
	
	static private List<Student> students = new ArrayList<>();
	 Scanner s = new Scanner(System.in);

	@Override
	public Student get(int index) {
		return students.get(index);
	}

	@Override
	public List<Student> getAll() {
		return students;
	}

	@Override
	public void save(Student student) {
		students.add(student);
	}

	@Override
	public void update(int index, Student student) {
		students.set(index, student);
	}

	@Override
	public void delete(Student student) {
		students.remove(student);
		
	}
	
	
	////////////////////////////import students(id& name   ) //////////////////////////////////////////////////
	
	public List<Student> importStudents(String file) {
		List<Student> students = new ArrayList<>();
		String line = "";
		String splitBy = ",";
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(file + ".txt"));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] data = line.split(splitBy); // use comma as separator
				Student s = new Student(data[0],data[1],data[2]); // id , F name,L name
				(students).add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}

	
}
	



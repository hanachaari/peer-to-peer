package peer_to_peer.model;

import peer_to_peer.textualInterface.AvailabilityInterface;
import peer_to_peer.dao.AvailabilityDao;

import java.util.ArrayList;
import java.util.Scanner;


public class Availability {
	
private String studentName;
private String day;
private float from,to;
private AvailabilityDao tool = new AvailabilityDao();
private AvailabilityInterface textualInterface  = new AvailabilityInterface();
private int totalAvailabilities;
Scanner s = new Scanner(System.in);

public Availability () 
{
	this.day= "";
	this.from=0;
	this.to = 0;
}

 public Availability ( String studentName, String day, float from,float to) 
 {
	 this.studentName = studentName;
	this.day= day;
	this.from=from;
	this.to=to;
 }
 
 
 /////////////////////////////////// Getters&Setters ///////////////////////////
 
 public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public float getFrom() {
		return from;
	}


	public void setFrom(float from) {
		this.from = from;
	}
	

	public int getTotalAvailabilities() {
		return totalAvailabilities;
	}

	public void setTotalAvailabilities(int totalAvailabilities) {
		this.totalAvailabilities = totalAvailabilities;
	}

	public float getTo() {
		return to;
	}
	

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setTo(float to) {
		this.to = to;
	}


 

 
 ///////////////////////////////////add_availablity //////////////////////////////////////

public void add() {
	 tool.save(textualInterface.addAvailability());
}
//////////////////////////////search Availability //////////////////////////////////////
public Availability search() {
	ArrayList<Availability>availablities= (ArrayList<Availability>)tool.getAll();
	return tool.get(textualInterface.searchAvailability(availablities)); 
}


 /////////////////////////////////// delete_availablity //////////////////////////////////////
 
 public void delete () {
	 ArrayList<Availability>availablities= (ArrayList<Availability>)tool.getAll();
	 tool.delete(availablities.get(textualInterface.searchAvailability(availablities))); 
	    }
 
	 
 ///////////////////////////////////modify_availablity //////////////////////////////////////
 
 public void modify() {
	 ArrayList<Availability>availablities= (ArrayList<Availability>)tool.getAll();
	 int index = textualInterface.searchAvailability(availablities);
		tool.update(index,textualInterface.modifyAvailability(availablities.get(index).getStudentName() ,
				availablities.get(index).getDay(),  availablities.get(index).getFrom(), availablities.get(index).getTo()));} 
 
 ///////////////////////////////////display_Searched_availablity //////////////////////////////////////

 public void displaySearchedAvailability(Availability availability) {
	 
	 	System.out.println("Student Name: "+ availability.getStudentName());
		System.out.println("Day:		"+ availability.getDay());
		System.out.println("From:		"+ availability.getFrom());
		System.out.println("To:			"+ availability.getTo());
		System.out.println("------------------------------------");


 } 
 
 //////////////////////////////////// display_all_availibilites //////////////////////////////////////
 
 public void displayAllAvailabilities()
 {
	 ArrayList<Availability>availablities= (ArrayList<Availability>)tool.getAll();
	 for (int i =0; i< availablities.size(); i++)
		{
		 	System.out.println("Student Name:		"+ availablities.get(i).getStudentName());
			System.out.println("Day:		"+ availablities.get(i).getDay());
			System.out.println("From:		"+ availablities.get(i).getFrom());
			System.out.println("To:			"+ availablities.get(i).getTo());
			System.out.println("------------------------------------");
		}
 }
////////////////////////////////////display_all_availibilites //////////////////////////////////////
 
	public void displayStudentAvailabilities(Student student)
	{
		ArrayList<Availability>availablities= (ArrayList<Availability>)tool.getAll();
		for (int i =0; i< availablities.size(); i++)
		{
			if(availablities.get(i).getStudentName().equals(student.getFirstName()))
			{
				//System.out.println("Day:		"+ availablities.get(i).getStudentName());
				System.out.println("Day:		"+ availablities.get(i).getDay());
				System.out.println("From:		"+ availablities.get(i).getFrom());
				System.out.println("To:			"+ availablities.get(i).getTo());
				System.out.println("------------------------------------");
			}
		
		}
}
 
 }
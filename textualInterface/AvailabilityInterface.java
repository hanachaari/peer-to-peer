package peer_to_peer.textualInterface;

import java.util.ArrayList;
import java.util.Scanner;

import peer_to_peer.model.Availability;

public class AvailabilityInterface {
	
	public Scanner s = new Scanner(System.in);
	
	public Availability addAvailability() {
		 String day;
		 float from,to;
		 
		 System.out.println("Enter the student name: ");
		 String name = s.next();
		 System.out.println("Enter the day: ");
		 day= s.next();
		 System.out.println("From: ");
		 from= s.nextFloat();
		 System.out.println("To:");
		 to= s.nextFloat();
		 Availability availability =new Availability(name,day,from,to); 
		 availability.setTotalAvailabilities(availability.getTotalAvailabilities()+1);
		 return availability;
	 }
	 ///////////////////////////////////search_availablity //////////////////////////////////////
	
	public int searchAvailability (ArrayList<Availability> availablities ) 
	 {
		 String day;
		 float from,to;
		 int index=-1;
		 do
		 {
			 System.out.println("Day: ");
			 day= s.next();
			 /*System.out.println("From: ");
			 from= s.nextFloat();
			 System.out.println("To: ");
			 to= s.nextFloat();*/
			 
			 for(int i=0; i <availablities.size();i++)
			 {
				 if ( (((availablities.get(i)).getDay()).equals(day)) /*&& ((availablities.get(i)).getFrom()== from) && ((availablities.get(i)).getTo()==to)*/ )
				 {
					 index = i;
				 }
			 }
			 	if (index < 0)
			 	{
			 		System.out.println("The date entered does not exist");
			 		System.out.println("PLEASE TRY AGAIN");
			 	}
		 }while(index<0);
		 return index;
	 }
	
	public Availability modifyAvailability(String studentName, String day, float from,float to) {
		int choice;
		 do
		 {
			 
			 do 
			 {
				 System.out.println("You want to modify:");
				 System.out.println("1-Day");
				 System.out.println("2-From");
				 System.out.println("3-To");
				 System.out.println("4-Exit");
				  choice = s.nextInt();
				  
				  if ((choice > 4 ) && (choice < 0))
				  {
					  System.out.println("ERROR");
					  System.out.println("Please try again");
				  }

			 }while((choice > 4 ) && (choice < 0));
			 switch(choice) {
			 case 1:
				 System.out.println("The old day: ");
				 System.out.println(day);
				 System.out.println("Enter the new day: ");
				 day=s.next();
				break;
			 case 2:
				 System.out.println("The old starting time: ");
				 System.out.println(from);
				 System.out.println("Enter the new starting time (from): ");
				 from=s.nextFloat();
				break;
			 case 3:
				 System.out.println("The old ending time: ");
				 System.out.println(to);
				 System.out.println("Enter the new ending time (to):");
				 to=s.nextFloat();;
				break;
			 }
			 
		 }while(choice != 4);
		 Availability a=new Availability(studentName,day,from,to);
			return a;

			
 } 
 
}

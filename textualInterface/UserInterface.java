package peer_to_peer.textualInterface;

import java.util.ArrayList;
import java.util.Scanner;

import peer_to_peer.model.User;
import peer_to_peer.model.Course;
import peer_to_peer.model.Level;
import peer_to_peer.model.Person ;


public class UserInterface {
	public Scanner s = new Scanner(System.in);

	public User addUser() {
		String firstName;
		String lastName;
		String password;
		String passwordAgain;
		String email;
		String emailAgain;
		 System.out.println("Enter your first name");
		  firstName=s.next();
		 System.out.println("Enter your last name");
		  lastName=s.next();
		 do {
		 System.out.println("Enter your password");
		  password=s.next();
		 System.out.println("Enter your password again ");
		  passwordAgain=s.next();
		 } while (!(password.equals(passwordAgain)));
		 do {
			 System.out.println("Enter your email");
			 email=s.next();
			 System.out.println("Enter your email again ");
			 emailAgain=s.next();
		} while (!(email.equals(emailAgain)));
		 User user= new User(firstName,lastName,password,passwordAgain);
		 return user;
	}
	public int searchUser (ArrayList<User> users) {
		String firstName;
		String lastName;
		
		 int index=-1;
		 do 
		 {
			 System.out.println("Enter your first name");
			  firstName=s.next();
			 System.out.println("Enter your last name");
			  lastName=s.next();
		 
		 for(int i=0; i <users.size();i++)
		 {
			 if ( ((users.get(i).getFirstName()).equals(firstName)) && ((users.get(i).getLastName()).equals(lastName)) ) {
				 index = i;
			 }
		 }
		 	if (index < 0)
		 	{
		 		System.out.println("The user entered does not exist");
		 		System.out.println("Please try again");
		 	}
		 }while(index<0);
		 return index;
		 }
	public User modifyUser(ArrayList<User> users,int index)
	{
		int choice;
		do
		{
			do 
			 {
				 System.out.println("You want to modify:");
				 System.out.println("1-email");
				 System.out.println("2-password");
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
				System.out.println("The old email:		"+(users.get(index)).getEmail());
				System.out.println("Enter the new email");
				(users.get(index)).setEmail(s.next());
				break;
			case 2:
				System.out.println("The old password:		"+(users.get(index)).getPassword());
				System.out.println("Enter the new password");
				(users.get(index)).setPassword(s.next());
				break;
				
			}
		}while(choice != 3);
		return users.get(index);
	}



}

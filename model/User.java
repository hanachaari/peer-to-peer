package peer_to_peer.model;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

import peer_to_peer.dao.UserDao;
import peer_to_peer.textualInterface.UserInterface;

public class User extends Person {
	private String password;
	private String email;
	private UserDao tool = new UserDao();
	private UserInterface textualInterface  = new UserInterface();
	
	public Scanner s= new Scanner(System.in);

	
	public User(String firstName, String lastName,String password,String email) {
		super(firstName, lastName);
		this.password = password;
		this.email = email;
		// TODO Auto-generated constructor stub
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void displayAllUsers() {
		ArrayList<User> users= (ArrayList<User>)tool.getAll();
		for (int i =0; i< users.size(); i++)
		{
			System.out.println("Title:		"+ users.get(i).getFirstName());
			System.out.println("level:		"+ users.get(i).getLastName());
			System.out.println("level:		"+ users.get(i).getEmail());
			System.out.println("------------------------------------");
		}
		
	}
	public void add() {
		tool.save(textualInterface.addUser()); 
	}
	public User search() {
		ArrayList<User> users= (ArrayList<User>)tool.getAll();
		return tool.get(textualInterface.searchUser(users)); 
	}
	public void delete() {
		ArrayList<User> users= (ArrayList<User>)tool.getAll();
		tool.delete(users.get(textualInterface.searchUser(users))); 
		}
	public void modify()  
	{
		ArrayList<User> users= (ArrayList<User>)tool.getAll();
		int index = textualInterface.searchUser(users);
		tool.update(index, textualInterface.modifyUser(users, index));
	}
	
}

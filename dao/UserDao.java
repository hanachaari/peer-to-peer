package peer_to_peer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import peer_to_peer.model.User;

public class UserDao implements Dao<User> {
		
		 static private List<User> users = new ArrayList<>();
		 Scanner s = new Scanner(System.in);
		 
		 @Override
			public User get(int index) {
				return users.get(index);
			}

			@Override
			public List<User> getAll() {
				return users;
			}

			@Override
			public void save(User user) {
				users.add(user);
			}

			@Override
			public void update(int index, User user) {
				users.set(index, user);
			}

			@Override
			public void delete(User user) {
				users.remove(user);  
				
			}
		 

	}



package com.revature.daos;

import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public class UserDAO {
	
	public static User[] team = {
			(new User(1, "User1", "Very Patriotic", "Steve", "Rogers", 1, 1)),
			(new User(2, "User2", "Snarky", "Tony", "Stark", 1, 1)),
			(new User(3, "User3", "Could kill me and I'd say thanks", "Natasha", "Romanonov", 1,1)),
			(new User(4, "User4", "He is groot", "I am", "Groot", 1, 1)),
			(new User(5, "User5", "Amazing haircare routine", "Thor", "Odinson", 1 ,1))
	};
	
	public User[] getAll() {
		return team;
	}
	
	public User getById(int id) {
		if(id>team.length || id<1) {
			return null;
		}
		return team[id-1];
	}
	
	public User update(User a) {
		if(a.getUser_id()>team.length||a.getUser_id()<1){
			return null;
		} else {
			team[a.getUser_id()-1] = a;
			return getById(a.getUser_id());
		}
		
	}

}

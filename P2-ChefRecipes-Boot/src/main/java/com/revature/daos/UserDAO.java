package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.revature.models.database.Users;


@Repository
public class UserDAO {
	
	public static Users[] team = {
			//(new Users( "User1", "Very Patriotic", "Steve", "Rogers", 1)),
//			(new Users(2, "User2", "Snarky", "Tony", "Stark", 1, 1)),
//			(new Users(3, "User3", "Could kill me and I'd say thanks", "Natasha", "Romanonov", 1,1)),
//			(new Users(4, "User4", "He is groot", "I am", "Groot", 1, 1)),
//			(new Users(5, "User5", "Amazing haircare routine", "Thor", "Odinson", 1 ,1))
	};
	
	public Optional<List<Users>> findByUsernameAndPassword() {
		
		
		return null;
		
	}
	
	public Users[] getAll() {
		return team;
	}
	
	public Users getById(int id) {
		if(id>team.length || id<1) {
			return null;
		}
		return team[id-1];
	}
	
	public Users update(Users a) {
		if(a.getUser_id()>team.length||a.getUser_id()<1){
			return null;
		} else {
			team[a.getUser_id()-1] = a;
			return getById(a.getUser_id());
		}
		
	}

}

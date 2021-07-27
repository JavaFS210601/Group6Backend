package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.models.database.Users;
import com.revature.utils.HibernateUtil;

@SpringBootApplication
public class P2ChefRecipesBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(P2ChefRecipesBootApplication.class, args);
		
		Users user = new Users();
		
		System.out.println(user);

	}

}

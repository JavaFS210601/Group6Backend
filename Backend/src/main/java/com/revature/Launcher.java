package com.revature;

import com.revature.models.database.Users;
import com.revature.utils.HibernateUtil;

public class Launcher {

	public static void main(String[] args) {
		
		HibernateUtil.getSession();
		Users user = new Users();
		
		System.out.println(user);
		HibernateUtil.closeSession();
	}

}

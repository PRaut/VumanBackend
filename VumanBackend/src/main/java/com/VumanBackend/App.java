package com.VumanBackend;

import java.util.Date;
import java.util.List;

import com.Dao.UserDao;
import com.UserDaoImpl.UserDaoImpl;
import com.model.User;

public class App {
	public static void  main(String [] a) {	
		User user1 = new User();
		user1.setName("Vina");
		user1.setPassword("123");
		user1.setPhone("789");
		user1.setAddress("nag");
		user1.setEmail("vina@gmail.com");
		user1.setJoinDate(new Date());

		UserDao userDao = new UserDaoImpl();
		//userDao.insertUser(user1);
		
		List<User> userList = userDao.getAllUsers();
		for(User user: userList){
			System.out.println("Name: "+ user.getName() +", Address: "+ user.getAddress());
		}
		
	} 
	
}


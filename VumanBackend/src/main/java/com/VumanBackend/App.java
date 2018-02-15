package com.VumanBackend;

import java.util.Date;
import java.util.List;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.model.User;

public class App {
	public static void  main(String [] a) {	
		User user1 = new User();
		user1.setName("Pallavi");
		user1.setPassword("123");
		user1.setPhone("7145");
		user1.setAddress("mum");
		user1.setEmail("pallavi@gmail.com");
		//user1.setJoinDate(new Date());

		//UserDao userDao = new UserDaoImpl();

//		insert single user
//		userDao.insertUser(user1);
		
//		get all users
//		List<User> userList = userDao.getAllUsers();
//		if(userList.isEmpty()){
//			System.out.println("No records found");
//		}else{
//			for(User user: userList){
//				System.out.println("Name: "+ user.getName() +", Address: "+ user.getAddress());
//			}
//		}

//	 	get single user		
//		User user = (User)userDao.getUser(7);
//		System.out.println(user.getId()+ " "+user.getName() );
		
		
	} 
	
}


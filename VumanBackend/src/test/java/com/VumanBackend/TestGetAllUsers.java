package com.VumanBackend;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.UserDao;
import com.UserDaoImpl.UserDaoImpl;
import com.model.User;

public class TestGetAllUsers {

	private static UserDao userDao;
	
	@BeforeClass
	public static void setUp(){
		userDao = new UserDaoImpl();
	}
	
	@Test
	public void testGetAllUsersList(){
		List<User> usersList = new ArrayList<User>();
		usersList = userDao.getAllUsers();
		if(usersList.isEmpty()){
			System.out.println("No records found");
		}else{
			for(User user: usersList){
				System.out.println("Name: "+user.getName() + ", Address: "+ user.getAddress());
			}
		}
		
	}
}

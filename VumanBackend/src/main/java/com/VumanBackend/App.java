package com.VumanBackend;

import java.util.List;

import com.Dao.UserDao;
import com.UserDaoImpl.UserDaoImpl;
import com.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	UserDao userDaoImpl = new UserDaoImpl();
		List<User> userList = userDaoImpl.getAllUsers();
		for(User user: userList){
			System.out.println(user.getEmail());
		}
    }
}

package com.VumanBackend;

import com.Dao.UserDao;
import com.UserDaoImpl.UserDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	UserDao userDaoImpl = new UserDaoImpl();
		userDaoImpl.show("john@gmail.com", "John D", "123", "123456", "USA");
    }
}

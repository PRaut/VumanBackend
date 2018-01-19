package com.UserDaoImpl;

import com.Dao.UserDao;

public class UserDaoImpl implements UserDao{

	public void show(String email, String name, String password, String phone, String address) {
		System.out.println(email);
	}

}

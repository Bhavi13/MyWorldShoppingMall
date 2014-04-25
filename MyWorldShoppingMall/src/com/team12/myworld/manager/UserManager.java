package com.team12.myworld.manager;

import com.team12.myworld.dao.UserDAO;
import com.team12.myworld.pojos.User;

public class UserManager {
	
	UserDAO userDAO = new UserDAO();
	
	public boolean signUpUser(User userInfo)
	{
		boolean flag = userDAO.signUpUser(userInfo);
		return flag;
	}

}

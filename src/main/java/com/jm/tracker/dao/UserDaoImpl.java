package com.jm.tracker.dao;

import com.jm.tracker.obj.ResultObj;
import com.jm.tracker.obj.UserObj;

public interface UserDaoImpl {

	// consider encryption
	public UserObj getUser(String userName, String passWord);
	
	public UserObj updateUser(String userId, UserObj userObj );
	
	public ResultObj deleteUser(String userId);
	
	public ResultObj createUser(UserObj userObj);
}

package com.uj.service;

import java.util.List;

import com.uj.dto.Login;
import com.uj.dto.RoleChange;
import com.uj.dto.User;

public interface IUserService {

	boolean registerEmployee(User user);

	List<User> getAllUsers();

	User getUserById(Integer id);

	User getUserByEmail(String email);

	boolean deleteUser(Integer id);

	String login(Login login);
	
	String changeRoleOfUser(Integer id,RoleChange role);
	
	String deleteAllUser();
}

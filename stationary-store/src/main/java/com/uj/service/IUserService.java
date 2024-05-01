package com.uj.service;

import java.util.List;

import com.uj.dto.AuthRequest;
import com.uj.dto.RoleChange;
import com.uj.dto.User;

public interface IUserService {

	boolean registerEmployee(User user);
	
	boolean updateUser(Integer id , User user);

	List<User> getAllUsers();

	User getUserById(Integer id);

	User getUserByEmail(String email);

	boolean deleteUser(Integer id);

	String login(AuthRequest login);
	
	String changeRoleOfUser(Integer id,RoleChange role);
	
	String deleteAllUser();
}

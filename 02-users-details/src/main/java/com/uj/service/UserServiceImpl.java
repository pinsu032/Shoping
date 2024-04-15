package com.uj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.core.util.Base64Encoder;
import com.uj.dto.Login;
import com.uj.dto.RoleChange;
import com.uj.dto.User;
import com.uj.entity.UsersMaster;
import com.uj.repo.UserMasterRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	private UserMasterRepo masterRepo;
	
	@Autowired
	public UserServiceImpl(UserMasterRepo masterRepo) {
		this.masterRepo = masterRepo;
	}

	@Override
	public boolean registerEmployee(User user) {
		UsersMaster userMaster = new UsersMaster();
        
		BeanUtils.copyProperties(user, userMaster);
		userMaster.setRole("USER");
		userMaster.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		UsersMaster save = masterRepo.save(userMaster);
		
		return save.getUserId()!=null;
	}

	@Override
	public List<User> getAllUsers() {
		List<UsersMaster> findAll = masterRepo.findAll();

		List<User> userList = new ArrayList<>();
		findAll.forEach(entity -> {
			User user = new User();
			BeanUtils.copyProperties(entity, user);
			userList.add(user);
		});
		return userList;
	}

	@Override
	public User getUserById(Integer id) {
		Optional<UsersMaster> findById = masterRepo.findById(id);
		if (findById.isPresent()) {
			UsersMaster userMaster = findById.get();
			User user = new User();
			BeanUtils.copyProperties(userMaster, user);
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<UsersMaster> findByEmail = masterRepo.findByEmail(email);
		User user = new User();
		if(findByEmail.isPresent()) {
			BeanUtils.copyProperties(findByEmail.get(), user);
		}
		return user;
	}

	@Override
	public boolean deleteUser(Integer id) {
		try {
			masterRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String login(Login login) {
		UsersMaster findByEmailAndPassword = masterRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
		String msg = " ";
		if (findByEmailAndPassword != null) 
			msg = "login success";
		else 
			msg = "Invalid credentials";

		return msg;
	}

	@Override
	public String changeRoleOfUser(Integer id,RoleChange role) {
		String msg = null;
		Optional<UsersMaster> findById = masterRepo.findById(id);
		if(findById.isPresent()) {
			UsersMaster um = findById.get();
			um.setRole(role.getRole());
			UsersMaster save = masterRepo.save(um);
			if(save.getRole().equalsIgnoreCase(role.getRole())) {
				msg = "Role changed to "+role.getRole();
			}
			else {
				msg = "Role not changed..";
			}
		}
			
		return msg;
	}

	@Override
	public String deleteAllUser() {
		String msg = null;
		try {
			masterRepo.deleteAll();
			msg = "All users deleted";
		}catch(Exception e){
			msg = "Can't delete all users..";
		}
		return msg;
	}
	
	

}

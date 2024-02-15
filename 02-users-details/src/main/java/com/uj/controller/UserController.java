package com.uj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uj.dto.Login;
import com.uj.dto.RoleChange;
import com.uj.dto.User;
import com.uj.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private IUserService service;

	@Autowired
	public UserController(IUserService service) {
		this.service = service;
	}
	
	@PostMapping("/")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		boolean status = service.registerEmployee(user);
		
		if(status)
		  return new ResponseEntity<String>("User registered successfully..",HttpStatus.OK);
		else
		  return new ResponseEntity<String>("Registeration failed..",HttpStatus.OK);

	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUser(){
		List<User> allUsers = service.getAllUsers();
		
		if(!allUsers.isEmpty())
		  return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
		else
		  return new ResponseEntity<String>("Something went wrong",HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){
		User userById = service.getUserById(id);
		
		if(userById != null)
		  return new ResponseEntity<User>(userById,HttpStatus.OK);
		else
		  return new ResponseEntity<String>("Something went wrong",HttpStatus.OK);
	}
	
	@GetMapping("/get/{mobile}")
	public ResponseEntity<?> getUserByMobile(@PathVariable("mobile") Long mobile){
		User userByMobile = service.getUserByMobile(mobile);
		
		if(userByMobile != null)
		  return new ResponseEntity<User>(userByMobile,HttpStatus.OK);
		else
		  return new ResponseEntity<String>("Something went wrong",HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id){
		boolean deleteUser = service.deleteUser(id);
		
		if(deleteUser)
		  return new ResponseEntity<String>("User deleted successfully..",HttpStatus.OK);
		else
		  return new ResponseEntity<String>("Something went wrong",HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login){
		String msg = service.login(login);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	@PutMapping("/change/{id}")
	public ResponseEntity<String> changeRole(@PathVariable("id") Integer id,@RequestBody RoleChange role){
		String changeRoleOfUser = service.changeRoleOfUser(id, role);
		if(changeRoleOfUser != null) {
			return new ResponseEntity<String>(changeRoleOfUser,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Can't change role ",HttpStatus.OK);

	}
	
}

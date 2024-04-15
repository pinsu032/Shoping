package com.uj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uj.dto.Login;
import com.uj.dto.LoginReq;
import com.uj.dto.RoleChange;
import com.uj.dto.User;
import com.uj.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private IUserService service;

	
	public UserController(IUserService service) {
		this.service = service;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		boolean status = service.registerEmployee(user);
		
		if(status)
		  return new ResponseEntity<String>("User registered successfully..",HttpStatus.OK);
		else
		  return new ResponseEntity<String>("Registeration failed..",HttpStatus.OK);

	}
	
	@GetMapping("/all")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_USER')")
	public ResponseEntity<?> getAllUser(){
		List<User> allUsers = service.getAllUsers();
		
		if(!allUsers.isEmpty())
		  return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
		else
		  return new ResponseEntity<String>("Something went wrong",HttpStatus.OK);

	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){
		User userById = service.getUserById(id);
		
		if(userById != null)
		  return new ResponseEntity<User>(userById,HttpStatus.OK);
		else
		  return new ResponseEntity<String>("Something went wrong",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id){
		boolean deleteUser = service.deleteUser(id);
		
		if(deleteUser)
		  return new ResponseEntity<String>("User deleted successfully..",HttpStatus.OK);
		else
		  return new ResponseEntity<String>("Something went wrong",HttpStatus.OK);
	}
	
	@DeleteMapping("/delAll")
	public ResponseEntity<?> deleteAllUserBy(){
		String msg = service.deleteAllUser();
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Login login){
		String msg = service.login(login);
		//LoginReq req = new LoginReq();
		//req.setMsg(msg);
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@PutMapping("/change/{id}")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> changeRole(@PathVariable("id") Integer id,@RequestBody RoleChange role){
		String changeRoleOfUser = service.changeRoleOfUser(id, role);
		if(changeRoleOfUser != null) {
			return new ResponseEntity<String>(changeRoleOfUser,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Can't change role ",HttpStatus.OK);

	}
	
}

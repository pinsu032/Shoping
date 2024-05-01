package com.uj.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uj.dto.AuthRequest;
import com.uj.dto.RegisterRes;
import com.uj.dto.Response;
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
	public ResponseEntity<?> registerUser(@RequestBody User user){
		System.out.println("UserController.registerUser()");
		boolean status = service.registerEmployee(user);
		RegisterRes res = new RegisterRes();
		if(status)
			res.setMsg("User registered successfully..");
		else
			res.setMsg("Registeration failed..");
		
		  return new ResponseEntity<RegisterRes>(res,HttpStatus.OK);

	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable("userId") Integer userId,@RequestBody User user){
		System.out.println("UserController.registerUser()");
		boolean status = service.updateUser(userId,user);
		RegisterRes res = new RegisterRes();
		if(status)
			res.setMsg("User update successfully..");
		else
			res.setMsg("Updation failed..");
		
		  return new ResponseEntity<RegisterRes>(res,HttpStatus.OK);

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
		Response res = new Response();
		if(deleteUser)
			res.setMsg("User deleted successfully..");
		else
			res.setMsg("Something went wrong");
		
		  return new ResponseEntity<Response>(res,HttpStatus.OK);
	}
	
	@DeleteMapping("/delAll")
	public ResponseEntity<?> deleteAllUserBy(){
		String msg = service.deleteAllUser();
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AuthRequest login){
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

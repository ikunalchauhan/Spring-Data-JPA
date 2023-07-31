package com.spring.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.core.entity.User;
import com.spring.core.service.UserService;

import java.util.List;

@RestController
@ResponseBody
public class Controller {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/addUsers")
	public ResponseEntity<Void> addUsers(@RequestBody List<User> users) {
		return userService.addUsersService(users);				// for adding multiple users
	}

	@PostMapping("/addUser")
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		return userService.addUserService(user);				// for adding one user
	}
	
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return userService.getAllUsersService();		// fetching all users
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		return userService.getUserService(id);			// fetching single user after searching using id
	}
	
	
	
	@DeleteMapping("/deleteUsers")
	public ResponseEntity<Void> deleteUsers() {
		return userService.deleteUsersService();				// for deleting all users
	}
	

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		return userService.deleteUserService(id);				// for deleting one user
	}
	
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable("id") int id) {
		return userService.updateUser(id, user);
	}
	
}

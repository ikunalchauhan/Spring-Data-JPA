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
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		return userService.getUserByIdService(id);			// fetching single user after searching using id
	}
	
	// Derived Query Method 
	@GetMapping("/getUserByName/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
		return userService.getUserByNameService(name);			// fetching single user after searching using name
	}
	
	// Derived Query Method Services
	@GetMapping("/getUserByCity/{city}")
	public ResponseEntity<User> getUserByCity(@PathVariable("city") String city) {
		return userService.getUserByCityService(city);			// fetching single user after searching using name
	}
	
	// Derived Query Method Services
	@GetMapping("/getUserByNameAndStatus/{name}/{status}")
	public ResponseEntity<List<User>> getUserByNameAndStatus(@PathVariable("name") String name, @PathVariable("status") String status){
		return userService.getUserByNameAndStatusService(name, status);
	}
	
	
	// Derived Query Method Services
	@GetMapping("/getUsersMatchingStatus/{status}")
	public ResponseEntity<List<User>> getUsersMatchingStatus(@PathVariable("status") String status){
		return userService.getUsersMatchingStatusService(status);
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

package com.spring.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.core.dao.UserRepository;
import com.spring.core.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	
	public ResponseEntity<Void> addUserService(User user) {
		
		if(userRepo.save(user) != null) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public ResponseEntity<Void> addUsersService(List<User> users) {

		if(userRepo.saveAll(users) != null) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	public ResponseEntity<List<User>> getAllUsersService(){
		List<User> users = userRepo.findAll();
		
//		This will create an positive response i.e OK with a non-empty body and NON_Content with empty body
		return ResponseEntity.of(Optional.of(users));
	}
	
	public ResponseEntity<User> getUserService(int id){
		Optional<User> userOptional = userRepo.findById(id);
		
		return ResponseEntity.of(userOptional);
	}
	
	
	
	public ResponseEntity<Void> deleteUsersService() {
		
		if(userRepo.findAll().isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		else {
			userRepo.deleteAll();
			return ResponseEntity.status(HttpStatus.OK).build();
		}		
	}
	
	public ResponseEntity<Void> deleteUserService(int id) {
		
		try {
			userRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	
	public ResponseEntity<Void> updateUser(int id, User user){
		Optional<User> optionalUser = userRepo.findById(id);
		
		if(optionalUser.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		User tempUser = optionalUser.get();
		
		tempUser.setName(user.getName());
		tempUser.setCity(user.getCity());
		tempUser.setStatus(user.getStatus());
		
		if(userRepo.save(tempUser) == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		else
			return ResponseEntity.status(HttpStatus.OK).build();
	}
}

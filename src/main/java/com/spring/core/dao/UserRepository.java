package com.spring.core.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.spring.core.entity.User;

//https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods.query-creation

@Service
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	// Custom finder methods OR Derived Query Methods
	
	public Optional<User> findByName(String name);
	
	public Optional<User> findByCity(String city);
	
	public List<User> findByNameAndStatus(String name, String status);
	
	
	// Here we binded the status of query using @Param with method parameter
	@Query("select u FROM User u WHERE u.status =:status")
	public List<User> getAllUsersMatchingStatus(@Param("status") String status);
	
}

package com.spring.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.spring.core.entity.User;

@Service
public interface UserRepository extends JpaRepository<User, Integer>{

}

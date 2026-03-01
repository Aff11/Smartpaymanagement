package com.maven.smartpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maven.smartpay.model.User;

@Repository
public interface Userrepository extends JpaRepository<User,Integer>{

	 User findByEmailAndPassword(String email, String password); 
    User findByEmail(String mall);
}

package com.maven.smartpay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maven.smartpay.model.Transaction;
import com.maven.smartpay.model.User;

@Repository
public interface Transactionrepository extends JpaRepository<Transaction,Integer>{

	 List<Transaction> findBySenderOrReceiver(User sender, User receiver);
}

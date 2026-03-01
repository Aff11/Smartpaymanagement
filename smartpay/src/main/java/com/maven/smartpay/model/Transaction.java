package com.maven.smartpay.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
	
@Entity
@Table(name = "transactions")
public class Transaction {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@ManyToOne
private User sender;
@ManyToOne
private User receiver;
private double amount;
private String status;
private String type;
private LocalDateTime created_at;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public User getSender() {
	return sender;
}
public void setSender(User sender) {
	this.sender = sender;
}
public User getReceiver() {
	return receiver;
}
public void setReceiver(User receiver) {
	this.receiver = receiver;
}
public void setCreated_at(LocalDateTime created_at) {
	this.created_at = created_at;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public Transaction() {
	super();
}

public Transaction(int id, User sender, User receiver, double amount, String status, String type,
		LocalDateTime created_at) {
	super();
	this.id = id;
	this.sender = sender;
	this.receiver = receiver;
	this.amount = amount;
	this.status = status;
	this.type = type;
	this.created_at = created_at;
}
@Override
public String toString() {
	return "Transaction [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", amount=" + amount
			+ ", status=" + status + ", type=" + type + ", created_at=" + created_at + "]";
}



}

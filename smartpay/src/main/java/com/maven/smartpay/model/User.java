package com.maven.smartpay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String email;
private String password;
private double wallet_balance;
private String role;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public User() {
	super();
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public double getWallet_balance() {
	return wallet_balance;
}
public void setWallet_balance(double wallet_balance) {
	this.wallet_balance = wallet_balance;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public User(int id, String name, String email, String password, double wallet_balance, String role) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.wallet_balance = wallet_balance;
	this.role = role;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", wallet_balance="
			+ wallet_balance + ", role=" + role + "]";
}



}

package com.setup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_login")
public class User_login {

	
	private String user_name;
	private String email;
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User_login(String user_name, String email, String password) {
		//super();
		this.user_name = user_name;
		this.email = email;
		this.password =password;
	}
	
	public User_login(String user_name, String email) {
		//super();
		this.user_name = user_name;
		this.email = email;
	}
	public User_login() {
		super();
	}
	
}

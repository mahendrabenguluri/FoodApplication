package com.food.model;

public class User {
	private int userid;
	private String username;
	private String password;
	private String email;
	private String address;
	private String role;
	
	
	
	public User() {
		super();
	}
	



	public User( int userid,String username,  String email, String address, String role,String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}
	

	public int getUserid() {
		return userid;
	}




	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}




	public void setUsername(String username ) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public static void main(String[] args) {
		
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", role=" + role + "]";
	}

}

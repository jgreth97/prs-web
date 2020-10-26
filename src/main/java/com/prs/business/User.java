package com.prs.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)//database increments the id by 1
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private boolean isReviewer;
	private boolean isAdmin;
	
	public User() {

	} 

	public User(int id, String userName, String password, String firstName, String lastName, String phoneNumber,
			String email, boolean isReviewer, boolean isAdmin, double lineItemValue) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isReviewer = isReviewer;
		this.isAdmin = isAdmin;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isReviewer() {
		return isReviewer;
	}

	public void setReviewer(boolean isReviewer) {
		this.isReviewer = isReviewer;
		
	}
	public boolean setReviewer(String isReviewer) {
	
		
		if (isReviewer.equalsIgnoreCase("true"))
			return true;
		else 
			return false;
	
	}
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String toString() {

		return "User Summary:\n" +"User ID"+id+ "\nUsername: " + userName + "\tpassword:" + "\nName: " + firstName + " " + lastName
				+ "\nPhone Number: " + phoneNumber + "\nEmail Address: " + email + "\nIs Reviewer?: " + isReviewer
				+ "\nIs Admin?: " + isAdmin;
	}


public String displayUser() {
	String str = "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
	str += "-+-+-+-+-+-+-+-+-+-+-+-+-User-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
	str += "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--+-+-\n";
	str += "User ID:\t\t " + id + "\n";
	str += "Username:\t\t " + userName + "\n";
	str += "Password:\t\t " + password + "\n";
	str += "First Name:\t\t " + firstName + "\n";
	str += "Last Name: \t\t "+lastName+"\n";
	str += "Phone Number:\t\t"+phoneNumber+"\n";
	str += "Email:\t\t\t"+email+"\n";
	str += "Is Reviewer\t\t"+isReviewer+"\n";
	str += "Is Admin:\t\t"+isAdmin+"\n";
	str += "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";

	return str;
}
}
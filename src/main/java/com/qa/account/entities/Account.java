package com.qa.account.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Account {
	public void setPrize(double prize) {
		this.prize = prize;
	}

	@Id
	@Column(unique = true, name = "account_number")
	@Pattern(regexp = "^[a-b][0-9]({6}|{8}|{10})", message = "Invalid Account Number")
	private String accountNumber="";
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "prize")
	private double prize;
	
	public Account(String firstName , String lastName) {
//		setAccountNumber();
		this.firstName=firstName;
		this.lastName=lastName;
		//this.prize=prizeCheck();
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public double getPrize() {
		return this.prize;
	}
	
	public void setAccountNumber(String num) {
		this.accountNumber=num;		
	}	
}

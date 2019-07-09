package com.revature.beans;

public class Account {

	private int accountNumber;
	private double balance = 0.00;
	private User authorizedUser; // if you wanted to, you can have authorizedUser be of type int
								// and simply hold the user id of the authorized user.
	
	public Account() {}
	public Account(double balance, User authorizedUser) {
		this.balance = balance;
		this.authorizedUser = authorizedUser;
	}
	public Account(int accountNumber, double balance, User authorizedUser) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.authorizedUser = authorizedUser;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		if(balance < 0) {
			System.out.println("You cannot have a negative balance.");
			throw new RuntimeException();
		} else {
			this.balance = balance;
		}
	}
	public User getAuthorizedUser() {
		return authorizedUser;
	}
	public void setAuthorizedUser(User authorizedUser) {
		this.authorizedUser = authorizedUser;
	}
}

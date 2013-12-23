package com.vbasoft.billsage.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="BILLSAGE_USER")
public class User {

	@Id @GeneratedValue
	private long userId;
	private String userName;
	private String emailId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth; //Date Of Birth
	private Date dateOfJoining; //Date of Joining
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Group> groups;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Transactions> transactions;
	
	public User() {}
	public User(String userName) {
		this.userName = userName;
	}
	public User(String userName, String email) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.emailId = email;
	}
	public final long getUserId() {
		return userId;
	}
	public final void setUserId(long userId) {
		this.userId = userId;
	}
	public final String getUserName() {
		return userName;
	}
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	public final String getEmailId() {
		return emailId;
	}
	public final void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public final String getFirstName() {
		return firstName;
	}
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public final String getLastName() {
		return lastName;
	}
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public final Date getDateOfBirth() {
		return dateOfBirth;
	}
	public final void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public final Date getDateOfJoining() {
		return dateOfJoining;
	}
	public final void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public final List<Group> getGroups() {
		return groups;
	}
	public final void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public final List<Transactions> getTransactions() {
		return transactions;
	}
	public final void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
}

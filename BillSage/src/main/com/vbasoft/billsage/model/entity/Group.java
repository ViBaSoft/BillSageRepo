package com.vbasoft.billsage.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="BILLSAGE_GRP")
public class Group {
	@Id @GeneratedValue
	private int groupId;
	private int name;
	@ManyToMany()
	private List<User> members;
	@ManyToMany()
	private List<Transactions> transactions;
	public final int getGroupId() {
		return groupId;
	}
	public final void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public final int getName() {
		return name;
	}
	public final void setName(int name) {
		this.name = name;
	}
	public final List<User> getMembers() {
		return members;
	}
	public final void setMembers(List<User> members) {
		this.members = members;
	}
	public final List<Transactions> getTransactions() {
		return transactions;
	}
	public final void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	
}

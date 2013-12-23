package com.vbasoft.billsage.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="BILLSAGE_USER_TX")
public class Transactions {

	@Id @GeneratedValue
	private long txId;
	private Date timestamp;
	private float totalAmount;
	@ManyToMany()
	private List<User> paidByUsers;
	@ManyToMany()
	private List<User> sharedByUsers;
	private float perHeadShare;
	
	public final long getTxId() {
		return txId;
	}
	public final void setTxId(long txId) {
		this.txId = txId;
	}
	public final Date getTimestamp() {
		return timestamp;
	}
	public final void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public final float getTotalAmount() {
		return totalAmount;
	}
	public final void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public final List<User> getPaidByUsers() {
		return paidByUsers;
	}
	public final void setPaidByUsers(List<User> paidByUsers) {
		this.paidByUsers = paidByUsers;
	}
	public final List<User> getSharedByUsers() {
		return sharedByUsers;
	}
	public final void setSharedByUsers(List<User> sharedByUsers) {
		this.sharedByUsers = sharedByUsers;
	}
	public final float getPerHeadShare() {
		return perHeadShare;
	}
	public final void setPerHeadShare(float perHeadShare) {
		this.perHeadShare = perHeadShare;
	}
	
	
}

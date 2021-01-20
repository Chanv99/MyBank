package com.chango.myBank.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class AccountHolder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@OneToMany(targetEntity = Name.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk", referencedColumnName = "id")
	private Name name;
	private String contactNo;
	private String address;
	//@Column(precision=2, scale=2) only work if decimal data type in database
	private BigDecimal accountBalance;
	
	@CreatedDate
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AccountHolder [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", address=" + address
				+ ", accountBalance=" + accountBalance + ", date=" + date + "]";
	}
	
	
	
}
//@Table(name="accountHolders", schema="chango")
//@Column(name="created_date")
//@Column(precision=2, scale=2)
//@Type(type = "big_decimal")
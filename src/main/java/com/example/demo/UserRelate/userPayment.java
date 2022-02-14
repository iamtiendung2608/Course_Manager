package com.example.demo.UserRelate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class userPayment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String cardNumber;
	private String phoneNumber;
	@Column(name="Year")
	private int ccYear;
	@Column(name="Month")
	private int ccMonth;
	@Column(name="Zip_Code")
	private int zipCode;
	public userPayment() {
		super();
	}
	public userPayment(String cardNumber, String phoneNumber, int ccYear, int ccMonth, int zipCode) {
		super();
		this.cardNumber = cardNumber;
		this.phoneNumber = phoneNumber;
		this.ccYear = ccYear;
		this.ccMonth = ccMonth;
		this.zipCode = zipCode;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getCcYear() {
		return ccYear;
	}
	public void setCcYear(int ccYear) {
		this.ccYear = ccYear;
	}
	public int getCcMonth() {
		return ccMonth;
	}
	public void setCcMonth(int ccMonth) {
		this.ccMonth = ccMonth;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public int getID() {
		return ID;
	}
	
}





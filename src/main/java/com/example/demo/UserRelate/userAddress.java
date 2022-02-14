package com.example.demo.UserRelate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class userAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String Country;
	private String Province;
	private String City;
	private String Street;
	@Column(name="Home_Number")
	private int homeNumber;
	public userAddress() {
		super();
	}
	public userAddress(String country, String province, String city, String street, int homeNumber) {
		super();
		Country = country;
		Province = province;
		City = city;
		Street = street;
		this.homeNumber = homeNumber;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public int getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(int homeNumber) {
		this.homeNumber = homeNumber;
	}
	public int getID() {
		return ID;
	}
	
}

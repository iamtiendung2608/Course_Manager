package com.example.demo.CourseInfo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String Name;
	@Column(name="Suitable_Degree")
	private String suitDegree;
	private String Description;
	private Long Price;
	public Course(String name, String suitDegree, String description, Long price) {
		super();
		Name = name;
		this.suitDegree = suitDegree;
		Description = description;
		Price = price;
	}
	public Course() {
		super();
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSuitDegree() {
		return suitDegree;
	}
	public void setSuitDegree(String suitDegree) {
		this.suitDegree = suitDegree;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Long getPrice() {
		return Price;
	}
	public void setPrice(Long price) {
		Price = price;
	}
	public int getID() {
		return ID;
	}
	
}

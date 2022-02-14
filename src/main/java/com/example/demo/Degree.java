package com.example.demo;

public enum Degree {
	BEGINNER("beginner"),
	COLLEGE("college"),
	EXPERT("expert");
	private final String name;
	Degree(String Name){
		this.name=Name;
	}
	public String getName() {
		return name;
	}
}	

package com.example.db;

public class Dairy {
	private long id;
	private String weight;
	private String length;
	private String girth;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String getLength(){
		return length;
	}
	
	public void setLength(String length){
		this.length = length;
	}
	
	public String getGirth(){
		return girth;
	}
	
	public void setGirth(String girth){
		this.girth = girth;
	}

	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return weight + ", " + length + ", " + girth;
	}
}

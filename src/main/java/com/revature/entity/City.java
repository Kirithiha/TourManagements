package com.revature.models;

import java.util.Arrays;

// POJO CLASS FOR CITY MODEL. 
public class City {

	private Character[] rtoCode;
	private String name;
	private Character[] stateCode;
	
	public City(Character[] rtoCode, String name, Character[] stateCode) {
		super();
		this.rtoCode =  new Character[5];
		this.rtoCode = rtoCode;
		this.name = name;
		this.stateCode = new Character[2];
		this.stateCode = stateCode;
	}

	public Character[] getRtoCode() {
		return rtoCode;
	}

	public void setRtoCode(Character[] rtoCode) {
		this.rtoCode = rtoCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character[] getStateCode() {
		return stateCode;
	}

	public void setStateCode(Character[] stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "City [rtoCode=" + Arrays.toString(rtoCode) + ", name=" + name + ", stateCode="
				+ Arrays.toString(stateCode) + "]";
	}
	
}

package com.revature.entity;


import com.revature.exceptions.NotFoundException;

// POJO CLASS FOR CITY MODEL. 
public class City {

	private String rtoCode;
	private String name;
	private String stateCode;
	
	public City(String name) {
		super();
		this.rtoCode =  null;
		this.name = name;
		this.stateCode = null;
	}
	
	public void setCode (String rtoCode, String stateCode) throws NotFoundException {
		System.out.println(rtoCode.length()+" " + rtoCode);
		if(rtoCode.length() == 4 || rtoCode.length() == 5) 
			this.rtoCode = rtoCode;
		else
			throw new NotFoundException("Rto code is not in correct format");
		if(stateCode.length() == 2) 
			this.stateCode = stateCode;
		else
			throw new NotFoundException("State code is not in correct format");
	}

	public String getRtoCode() {
		return rtoCode;
	}

	public void setRtoCode(String rtoCode) {
		this.rtoCode = rtoCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "City [rtoCode=" + rtoCode + ", name=" + name + ", stateCode="
				+ stateCode + "]";
	}
	
}

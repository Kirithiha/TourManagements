package com.revature.dto;


// POJO CLASS FOR CITY MODEL. 
public class CityDto {

	private String rtoCode;
	private String name;
	private String stateCode;
	
	public CityDto() {
		
	}
	
	public CityDto(String name, String rtoCode, String stateCode) {
		super();
		this.rtoCode =  rtoCode;
		this.name = name;
		this.stateCode = stateCode;
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

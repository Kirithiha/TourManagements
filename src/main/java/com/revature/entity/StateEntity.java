package com.revature.entity;

import com.revature.exceptions.NotFoundException;

// POJO CLASS FOR STATE MODEL.
public class StateEntity {

	private String code;
	private String name;
	
	public StateEntity() {
		
	}
	
	public StateEntity(String name) {
		super();
		this.code = null;
		this.name = name;
	}

	public void setCodeValue(String code) throws NotFoundException {
		if(code.length() == 2) 
			this.code = code;
		else
			throw new NotFoundException("State code is not in correct format");
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "State [code=" + code + ", name=" + name + "]";
	}
		
}

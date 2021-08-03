package com.revature.models;

import java.util.Arrays;

// POJO CLASS FOR STATE MODEL.
public class State {

	private Character[] code;
	private String name;
	
	public State(Character[] code, String name) {
		super();
		this.code = new Character[2];
		this.code = code;
		this.name = name;
	}

	public Character[] getCode() {
		return code;
	}

	public void setCode(Character[] code) {
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
		return "State [code=" + Arrays.toString(code) + ", name=" + name + "]";
	}
		
}

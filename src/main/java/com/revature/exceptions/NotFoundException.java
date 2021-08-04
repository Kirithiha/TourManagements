package com.revature.exceptions;

import org.apache.log4j.Logger;

public class NotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger("NotFoundException.class");

	public NotFoundException(String msg){
		super(msg);
		log.warn("Inside the Custom Exception class.");
	}
	
}

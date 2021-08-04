package com.revature.controller;


import org.apache.log4j.Logger;

import com.revature.entity.State;
import com.revature.exceptions.NotFoundException;
import com.revature.utils.StateUtil;

public class StateController {
	
	StateUtil impl = new StateUtil();
	static Logger log = Logger.getLogger("StateController.class");

	// TO ADD NEW STATE RECORD TO TABLE.
	public int saveState(State newState) throws NotFoundException {
		
		log.debug("Inside SAVE STATE CONTROLLER");
		return impl.saveState(newState);
	}

	// TO LIST ALL THE RECORDS IN STATE.
	public void readAllStates() {
		log.debug("Inside READ ALL STATE CONTROLLER");
		impl.readAllStates();
	}

	// TO GET PARTICULAR STATE RECORD BASED ON STATE CODE.
	public void readStateById(String code) throws NotFoundException {
		
		log.debug("Inside READ STATE CONTROLLER");
		impl.readStateById(code);
	}

	// TO UPDATE PARTICULAR STATE RECORD BASED ON STATE CODE.
	public int updateState(State newState) throws NotFoundException {
		
		log.debug("Inside UPDATE STATE CONTROLLER");
		return impl.updateState(newState);
	}

	// TO DELETE PARTICULAR STATE RECORD BASED ON STATE CODE.
	public int deleteState(String code) throws NotFoundException {
		
		log.debug("Inside DELETE STATE CONTROLLER");
		return impl.deleteState(code);
	}
}

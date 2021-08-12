package com.revature.util;

import org.apache.log4j.Logger;

import com.revature.dto.State;
import com.revature.service.implemenations.StateServiceImplementation;

public class StateUtil {

	StateServiceImplementation impl = new StateServiceImplementation();
	static Logger log = Logger.getLogger("StateUtil.class");

	// TO ADD NEW STATE RECORD TO TABLE.
	public int saveState(State newState) {
		
		log.debug("Inside SAVE STATE UTIL");
		return impl.saveState(newState);
	}

	// TO LIST ALL THE RECORDS IN STATE.
	public void readAllStates() {
		log.debug("Inside READ ALL STATE UTIL");
		impl.readAllStates();
	}

	// TO GET PARTICULAR STATE RECORD BASED ON STATE CODE.
	public void readStateById(String code) {
		
		log.debug("Inside READ STATE UTIL");
		impl.readStateById(code);
	}

	// TO UPDATE PARTICULAR STATE RECORD BASED ON STATE CODE.
	public int updateState(State newState) {
		
		log.debug("Inside UPDATE STATE UTIL");
		return impl.updateState(newState);
	}

	// TO DELETE PARTICULAR STATE RECORD BASED ON STATE CODE.
	public int deleteState(String code) {
		
		log.debug("Inside DELETE STATE UTIL");
		return impl.deleteState(code);
	}

}

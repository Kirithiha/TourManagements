package com.revature.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.impl.StateDaoImpl;
import com.revature.dto.StateDto;
import com.revature.service.StateService;

// STATE SERVICE REPOSITORY.
public class StateServiceImpl implements StateService {

	static Logger log = Logger.getLogger("StateServiceImplementation.class");
	
	StateDaoImpl s_impl = new StateDaoImpl();
	@Override
	public int saveState(StateDto newState) {
		
		log.debug("Inside SAVE STATE");
		// TO ADD STATE.
		return s_impl.saveState(newState);
	}

	@Override
	public void readAllStates() {
		
		log.debug("Inside READ ALL STATE");
		// TO READ ALL STATES.
		List<StateDto> stateList = s_impl.readAllStates();
		stateList.forEach(System.out :: println);
	}

	@Override
	public void readStateById(String code) {
		
		log.debug("Inside READ STATE");
		//TO DISPLAY STATE.
		System.out.println(s_impl.readStateById(code));
	}

	@Override
	public int updateState(StateDto newState) {
		
		log.debug("Inside UPDATE STATE");
		// TO UPDATE STATE.
		return s_impl.updateState(newState);
	}

	@Override
	public int deleteState(String stateCode) {
		
		log.debug("Inside DELETE STATE");
		// TO DELETE STATE.
		return s_impl.deleteState(stateCode);
	}

}

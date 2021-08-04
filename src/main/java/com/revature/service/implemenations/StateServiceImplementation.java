package com.revature.service.implemenations;

import com.revature.exceptions.NotFoundException;

import java.util.List;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.dao.implementation.StateDaoImplementation;
import com.revature.entity.State;
import com.revature.service.StateServiceRepository;

// STATE SERVICE REPOSITORY.
public class StateServiceImplementation implements StateServiceRepository {

	static Logger log = Logger.getLogger("StateServiceImplementation.class");
	
	StateDaoImplementation s_impl = new StateDaoImplementation();
	@Override
	public int saveState(State newState) throws NotFoundException, SQLException {
		
		log.debug("Inside SAVE STATE");
		// TO ADD STATE.
		return s_impl.saveState(newState);
	}

	@Override
	public void readAllStates() throws SQLException {
		
		log.debug("Inside READ ALL STATE");
		// TO READ ALL STATES.
		List<State> stateList = s_impl.readAllStates();
		stateList.forEach(System.out :: println);
	}

	@Override
	public void readStateById(String code) throws NotFoundException, SQLException {
		
		log.debug("Inside READ STATE");
		//TO DISPLAY STATE.
		System.out.println(s_impl.readStateById(code));
	}

	@Override
	public int updateState(State newState) throws NotFoundException, SQLException {
		
		log.debug("Inside UPDATE STATE");
		// TO UPDATE STATE.
		return s_impl.updateState(newState);
	}

	@Override
	public int deleteState(String stateCode) throws NotFoundException, SQLException {
		
		log.debug("Inside DELETE STATE");
		// TO DELETE STATE.
		return s_impl.deleteState(stateCode);
	}

}

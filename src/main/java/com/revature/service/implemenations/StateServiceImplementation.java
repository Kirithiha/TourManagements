package com.revature.service.implemenations;

import org.apache.log4j.Logger;

import com.revature.entity.State;
import com.revature.exceptions.NotFoundException;
import com.revature.service.StateServiceRepository;

// STATE SERVICE REPOSITORY.
public class StateServiceImplementation implements StateServiceRepository {

	static Logger log = Logger.getLogger("StateServiceImplementation.class");

	@Override
	public int saveState(State newState) throws NotFoundException {
		
		log.debug("Inside SAVE STATE SERVICE");
		for(State state : state_list) {
			//TO CHECK FOR UNIQUE CODE.
			if(state.getCode().equals(newState.getCode()))
				throw new NotFoundException("State Code Already Found");
		}
		// TO ADD STATE TO LIST.
		state_list.add(newState);
		return 1;
	}

	@Override
	public void readAllStates() {
		
		// TO READ ALL STATES.
		log.debug("Inside READ ALL STATE SERVICE");
		state_list.forEach(System.out :: println);
	}

	@Override
	public void readStateById(String code) throws NotFoundException {
		
		// STREAMS TO GET THE PARTICULAR STATE BY GIVEN STATE CODE.
		log.debug("Inside READ STATE SERVICE");
		State st = state_list.stream().filter(s-> code.equals(s.getCode())).findAny().orElse(null);
				
		//THROWS EXCEPTION IF NO ID WAS FOUND.
		if(st == null) {
			throw new NotFoundException("No state code found");
		} else {
			// TO DISPLAY THE STATE.
			System.out.println(st);
		}
	}

	@Override
	public int updateState(State newState) throws NotFoundException {
		
		log.debug("Inside UPDATE STATE SERVICE");
		String str = newState.getCode();
		
		//STREAMS TO GET INDEX.
	    State st = state_list.stream().filter(s-> str.equals(s.getCode())).findAny().orElse(null);
		
	    //THROWS EXCEPTION IF NO ID WAS FOUND.
	    if(st == null) {
			throw new NotFoundException("No state code found");
		} else {
			// TO UPDATE THE STATE.
			int i = state_list.indexOf(st);
			state_list.set(i,newState);
		}
		return 1;
	}

	@Override
	public int deleteState(String stateCode) throws NotFoundException {
		
		// STREAMS TO GET THE INDEX OF ID.
		log.debug("Inside DELETE STATE SERVICE");
		State st = state_list.stream().filter(s-> stateCode.equals(s.getCode())).findAny().orElse(null);
				
		//THROWS EXCEPTION IF NO ID FOUND.
		if(st == null) {
			throw new NotFoundException("No state code found");
		} else {
			// TO REMOVE PARTICULAR ID FROM LIST.
			int i = state_list.indexOf(st);
			state_list.remove(i);
		}
		return 1;
	}

}

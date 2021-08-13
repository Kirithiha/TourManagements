package com.revature.util;


import com.revature.dto.StateDto;
import com.revature.entity.State;

public class StateUtil {

	public static State dtoToEntity(StateDto s) {
		State se = new State();
		se.setCode(s.getCode());
		se.setName(s.getName());
		return se;
	}
	
	public static StateDto entityToDto(State s) {
		StateDto se = new StateDto();
		se.setCode(s.getCode());
		se.setName(s.getName());
		return se;
	}
}

package com.revature.mapper;

import com.revature.dto.State;
import com.revature.entity.StateEntity;

public class StateMapper {

	public static StateEntity stateMap(State s) {
		StateEntity se = new StateEntity();
		se.setCode(s.getCode());
		se.setName(s.getName());
		return se;
	}
}

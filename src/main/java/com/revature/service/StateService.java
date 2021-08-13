package com.revature.service;


import com.revature.dto.StateDto;

public interface StateService {
	
	public int saveState(StateDto newState);
	public void readAllStates();
	public void readStateById(String code);
	public int updateState(StateDto newState);
	public int deleteState(String stateCode);
	
}

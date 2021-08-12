package com.revature.service;


import com.revature.dto.State;

public interface StateServiceRepository {
	
	public int saveState(State newState);
	public void readAllStates();
	public void readStateById(String code);
	public int updateState(State newState);
	public int deleteState(String stateCode);
	
}

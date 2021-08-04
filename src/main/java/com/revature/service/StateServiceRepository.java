package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.entity.State;
import com.revature.exceptions.NotFoundException;

public interface StateServiceRepository {
	
	public List<State> state_list = new ArrayList<State>();
	public int saveState(State newState) throws NotFoundException;
	public void readAllStates();
	public void readStateById(String code) throws NotFoundException;
	public int updateState(State newState) throws NotFoundException;
	public int deleteState(String stateCode) throws NotFoundException;
	
}

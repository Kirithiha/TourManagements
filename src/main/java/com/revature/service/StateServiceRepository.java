package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.NotFoundException;
import com.revature.models.State;

public interface StateServiceRepository {
	
	public List<State> state_list = new ArrayList<State>();
	public int saveState(State newState) throws NotFoundException;
	public void readAllStates();
	public void readStateById(Character[] code) throws NotFoundException;
	public int updateState(State newState) throws NotFoundException;
	public int deleteState(Character[] stateCode) throws NotFoundException;
	
}

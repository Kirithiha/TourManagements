package com.revature.dao;

import java.util.List;

import com.revature.dto.State;

// STATE DAO REPOSITORY.
public interface StateDaoRepository {

	public int saveState(State newState);
	public List<State> readAllStates();
	public State readStateById(String code);
	public int updateState(State newState);
	public int deleteState(String code);
}

package com.revature.dao;

import java.util.List;

import com.revature.dto.StateDto;

// STATE DAO REPOSITORY.
public interface StateDao {

	public int saveState(StateDto newState);
	public List<StateDto> readAllStates();
	public StateDto readStateById(String code);
	public int updateState(StateDto newState);
	public int deleteState(String code);
}

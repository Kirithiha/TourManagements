package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.entity.State;
import com.revature.exceptions.NotFoundException;

// STATE DAO REPOSITORY.
public interface StateDaoRepository {

	public int saveState(State newState) throws NotFoundException, SQLException;
	public List<State> readAllStates() throws SQLException;
	public State readStateById(String code) throws SQLException;
	public int updateState(State newState) throws NotFoundException, SQLException;
	public int deleteState(String code) throws NotFoundException, SQLException;
}

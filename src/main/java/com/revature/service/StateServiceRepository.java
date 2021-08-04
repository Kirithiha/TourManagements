package com.revature.service;

import java.sql.SQLException;

import com.revature.exceptions.NotFoundException;
import com.revature.entity.State;

public interface StateServiceRepository {
	
	public int saveState(State newState) throws NotFoundException, SQLException;
	public void readAllStates() throws SQLException;
	public void readStateById(String code) throws NotFoundException, SQLException;
	public int updateState(State newState) throws NotFoundException, SQLException;
	public int deleteState(String stateCode) throws NotFoundException, SQLException;
	
}

package com.revature.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.StateDaoRepository;
import com.revature.entity.State;
import com.revature.properties.DBUtil;
import com.revature.exceptions.NotFoundException;

public class StateDaoImplementation implements StateDaoRepository{

	static Logger log = Logger.getLogger("StateDaoImpl.class");
	Connection con;
	Statement stmt;
	PreparedStatement st;
	ResultSet rs;
	
	public StateDaoImplementation() {
		getConnection();
	}
	
	public void getConnection() {
		
		// TO GET CONNECTION FROM UTIL FILE.
		try {
			con = DBUtil.getDbConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// TO ADD NEW STATE RECORD TO TABLE.
	@Override
	public int saveState(State newState) throws NotFoundException, SQLException {
		
		log.info("SAVE STATE DAO");
		st = con.prepareStatement("insert into state values(?,?)");
		st.setString(1, newState.getCode());
		st.setString(2, newState.getName());
		int result = st.executeUpdate();
		
		// THROWS EXCEPTION IF 0 ROWS AFFECTED (DUPLICATE KEY).
		if(result == 0)
			throw new NotFoundException("Duplicate State Code Found");
		return 1;
	}

	// TO LIST ALL THE RECORDS IN STATE.
	@SuppressWarnings("null")
	@Override
	public List<State> readAllStates() throws SQLException {
		
		log.info("READ ALL STATE DAO");
		List<State> stateList = new ArrayList<State>();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from state");
		if(rs!= null) {
			while(rs.next()) {
				State state = new State();
				state.setCode(rs.getString(1));
				state.setName(rs.getString(2));
				stateList.add(state);
			}
		} 
		return stateList;
	}

	// TO GET PARTICULAR STATE RECORD BASED ON STATE CODE.
	@Override
	public State readStateById(String code) throws SQLException {
		
		log.info("READ STATE DAO");
		State state = null;
		st = con.prepareStatement("select * from state where code = ?");
		st.setString(1, code);
		rs = st.executeQuery();
		if(rs!= null) {
			while(rs.next()) {
				state = new State();
				state.setCode(rs.getString(1));
				state.setName(rs.getString(2));
			}
		} 
		return state;
	}

	// TO UPDATE PARTICULAR STATE RECORD BASED ON STATE CODE.
	@Override
	public int updateState(State newState) throws NotFoundException, SQLException {
		
		log.info("UPDATE STATE DAO");
		st = con.prepareStatement("update state set name = ? where code = ?");
		st.setString(2, newState.getCode());
		st.setString(1, newState.getName());
		int result = st.executeUpdate();
		
		// THROWS EXCEPTION IF 0 ROWS AFFECTED.
		if(result == 0)
			throw new NotFoundException("State Code Not Found");
		return 1;	
	}

	// TO DELETE PARTICULAR STATE RECORD BASED ON STATE CODE.
	@Override
	public int deleteState(String code) throws NotFoundException, SQLException {
		
		log.info("DELET STATE DAO");
		st = con.prepareStatement("delete from state where code = ?");
		st.setString(1, code);
		int result = st.executeUpdate();
		
		// THROWS EXCEPTION IF 0 ROWS AFFECTED.
		if(result == 0)
			throw new NotFoundException("State Code Not Found");
		return 1;
	}
}

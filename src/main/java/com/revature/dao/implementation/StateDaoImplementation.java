package com.revature.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.StateDaoRepository;
import com.revature.dto.State;
import com.revature.entity.StateEntity;
import com.revature.properties.DBUtil;
import com.revature.exceptions.NotFoundException;
import com.revature.mapper.StateMapper;

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
	public int saveState(State newState) {
		
		log.info("SAVE STATE DAO");
		int result =0;
		try {
			StateEntity newEntity = StateMapper.stateMap(newState);
			st = con.prepareStatement("insert into state(code,name,createdDate) values(?,?,?)");
			st.setString(1, newEntity.getCode());
			st.setString(2, newEntity.getName());
			LocalDate date = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String dateText = date.format(format);
			Date createDate = Date.valueOf(LocalDate.parse(dateText, format));
			st.setDate(3, createDate);
			result = st.executeUpdate();
			
			// THROWS EXCEPTION IF 0 ROWS AFFECTED (DUPLICATE KEY)
		}catch(SQLException e) {
			log.info("State code found already "+e);
		}
		return result;
	}

	// TO LIST ALL THE RECORDS IN STATE.
	@SuppressWarnings("null")
	@Override
	public List<State> readAllStates() {
		
		log.info("READ ALL STATE DAO");
		List<State> stateList = new ArrayList<State>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from state");
			if(rs.next()) {
				while(rs.next()) {
					State state = new State();
					state.setCode(rs.getString(1));
					state.setName(rs.getString(2));
					stateList.add(state);
				}
			} else 
				throw new NotFoundException("Rto Code Not Found");
		} catch(SQLException e) {
			log.info(e);
		} catch(NotFoundException e) {
			log.info(e);
		}
		return stateList;
	}

	// TO GET PARTICULAR STATE RECORD BASED ON STATE CODE.
	@Override
	public State readStateById(String code) {
		
		log.info("READ STATE DAO");
		State state = null;
		try {
			st = con.prepareStatement("select * from state where code = ?");
			st.setString(1, code);
			rs = st.executeQuery();
			if(rs.next()) {
					state = new State();
					state.setCode(rs.getString(1));
					state.setName(rs.getString(2));
			} else 
				throw new NotFoundException("State Code Not Found");
		} catch(SQLException e) {
			log.info(e);
		} catch(NotFoundException e) {
			log.info(e);
		}
		return state;
	}

	// TO UPDATE PARTICULAR STATE RECORD BASED ON STATE CODE.
	@Override
	public int updateState(State newState) {
		
		log.info("UPDATE STATE DAO");
		int result=0;
		try {
			st = con.prepareStatement("update state set name = ?, updatedDate = ? where code = ?");
			st.setString(3, newState.getCode());
			st.setString(1, newState.getName());
			LocalDate date = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String dateText = date.format(format);
			Date updateDate = Date.valueOf(LocalDate.parse(dateText, format));
			st.setDate(2, updateDate);
			result = st.executeUpdate();
			
			// THROWS EXCEPTION IF 0 ROWS AFFECTED.
			if(result == 0)
				throw new NotFoundException("State Code Not Found");
		} catch(SQLException e) {
			log.info("Rto Code not found "+e);
		}catch(NotFoundException e) {
			log.info(e);
		}
		return result;	
	}

	// TO DELETE PARTICULAR STATE RECORD BASED ON STATE CODE.
	@Override
	public int deleteState(String code) {
		
		log.info("DELET STATE DAO");
		int result=0;
		try {
			st = con.prepareStatement("delete from state where code = ?");
			st.setString(1, code);
			result = st.executeUpdate();
			
			// THROWS EXCEPTION IF 0 ROWS AFFECTED.
			if(result == 0)
				throw new NotFoundException("State Code Not Found");
		}catch(SQLException e) {
			log.info("Rto code not found "+e);
		} catch(NotFoundException e) {
			log.info(e);
		}
		return result;
	}
}

package com.revature.dao.impl;

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

import com.revature.dao.StateDao;
import com.revature.dto.StateDto;
import com.revature.entity.State;
import com.revature.exceptions.NotFoundException;
import com.revature.util.DBUtil;
import com.revature.util.StateUtil;

public class StateDaoImpl implements StateDao{

	static Logger log = Logger.getLogger("StateDaoImpl.class");
	Connection con;
	Statement stmt;
	PreparedStatement st;
	ResultSet rs;
	
	public StateDaoImpl() {
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
	public int saveState(StateDto newState) {
		
		log.info("SAVE STATE DAO");
		int result =0;
		try {
			State newEntity = StateUtil.dtoToEntity(newState);
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
	public List<StateDto> readAllStates() {
		
		log.info("READ ALL STATE DAO");
		List<StateDto> stateList = new ArrayList<StateDto>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from state");
			if(rs.next()) {
				while(rs.next()) {
					State state = new State();
					state.setCode(rs.getString(1));
					state.setName(rs.getString(2));
					StateDto stateDto = StateUtil.entityToDto(state);
					stateList.add(stateDto);
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
	public StateDto readStateById(String code) {
		
		log.info("READ STATE DAO");
		StateDto stateDto = null;
		try {
			st = con.prepareStatement("select * from state where code = ?");
			st.setString(1, code);
			rs = st.executeQuery();
			if(rs.next()) {
					State state = new State();
					state.setCode(rs.getString(1));
					state.setName(rs.getString(2));
					stateDto = StateUtil.entityToDto(state);
					return stateDto;
			} else 
				throw new NotFoundException("State Code Not Found");
		} catch(SQLException e) {
			log.info(e);
		} catch(NotFoundException e) {
			log.info(e);
		}
		return stateDto;
	}

	// TO UPDATE PARTICULAR STATE RECORD BASED ON STATE CODE.
	@Override
	public int updateState(StateDto newState) {
		
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

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

import com.revature.dao.CityDaoRepository;
import com.revature.dto.City;
import com.revature.entity.CityEntity;
import com.revature.exceptions.NotFoundException;
import com.revature.mapper.CityMapper;
import com.revature.properties.DBUtil;

public class CityDaoImplementation implements CityDaoRepository{

	static Logger log = Logger.getLogger("CityDaoImpl.class");
	Connection con;
	Statement stmt;
	PreparedStatement st;
	ResultSet rs;
	
	public CityDaoImplementation() {
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
	public int saveCity(City newCity) {
		
		log.info("Inside SAVE CITY DAO");
		int result=0;
		try {
			CityEntity newEntity = CityMapper.cityMap(newCity);
			st = con.prepareStatement("insert into city(rtocode,name,stateCode, createdDate) values(?,?,?,?)");
			st.setString(1, newEntity.getRtoCode());
			st.setString(2, newEntity.getName());
			st.setString(3,newEntity.getStateCode());
			LocalDate date = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String dateText = date.format(format);
			Date createDate = Date.valueOf(LocalDate.parse(dateText, format));
			st.setDate(4, createDate);
			result = st.executeUpdate();
			
			// THROWS EXCEPTION IF 0 ROWS AFFECTED (DUPLICATE KEY).
		}catch(SQLException e) {
			log.info("Rto code found already "+e);
		}
		return result;
	}

	// TO GET ALL CITY RECORD.
	@SuppressWarnings("null")
	@Override
	public List<City> readAllCites(){
		log.info("Inside READ ALL CITY DAO");
		List<City> cityList = new ArrayList<City>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from city");
			if(rs.next()) {
				while(rs.next()) {
					City city = new City();
					city.setStateCode(rs.getString(3));
					city.setName(rs.getString(2));
					city.setRtoCode(rs.getString(1));
					cityList.add(city);
				}
			} else 
				throw new NotFoundException("Rto Code Not Found");
		} catch(SQLException e) {
			log.info(e);
		} catch(NotFoundException e) {
			log.info(e);
		}
		return cityList;
	}

	// TO GET PARTICULAR CITY RECORD BASED ON STATE AND CITY CODE.
	@Override
	public City readCityById(String rtoCode) {
		
		log.info("Inside READ  CITY DAO");
		City city = null;
		try {
			st = con.prepareStatement("select * from city where rtoCode = ?");
			st.setString(1, rtoCode);
			rs = null;
			rs = st.executeQuery();
			if(rs.next()) {
					city = new City();
					city.setStateCode(rs.getString(3));
					city.setName(rs.getString(2));
					city.setRtoCode(rs.getString(1));
					return city;
			} else
				throw new NotFoundException("Rto code not Found");
		} catch(SQLException e) {
			log.info("No Rto code Found "+e);
		} catch(NotFoundException e) {
			log.info(e);
		}
		return city;
	}

	// TO UPDATE PARTICULAR CITY RECORD BASED ON STATE AND CITY CODE.
	@Override
	public int updateCity(String rtoCode, String name) {
		
		log.info("Inside UPDATE CITY DAO");
		int result = 0;
		try {
			st = con.prepareStatement("update city set name = ?, updatedDate = ? where rtocode = ?");
			st.setString(1, name);
			st.setString(3, rtoCode);
			LocalDate date = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String dateText = date.format(format);
			Date updateDate = Date.valueOf(LocalDate.parse(dateText, format));
			st.setDate(2, updateDate);
			result = st.executeUpdate();
			
			// THROWS EXCEPTION IF 0 ROWS AFFECTED.
			if(result == 0)
				throw new NotFoundException("Rto Code not found");
		} catch(SQLException e) {
			log.info("Rto Code not found "+e);
		}catch(NotFoundException e) {
			log.info(e);
		}
		return result;	
	}

	// TO DELETE PARTICULAR CITY RECORD BASED ON STATE AND CITY CODE.
	@Override
	public int deleteCity(String rtoCode) {
		
		log.info("Inside DELETE CITY DAO");
		int result=0;
		try {
			st = con.prepareStatement("delete from city where rtocode = ?");
			st.setString(1, rtoCode);
			result = st.executeUpdate();
			
			// THROWS EXCEPTION IF 0 ROWS AFFECTED (DUPLICATE KEY)
			if(result == 0)
				throw new NotFoundException("Rto code Not found");
		}catch(SQLException e) {
			log.info("Rto code not found "+e);
		} catch(NotFoundException e) {
			log.info(e);
		}
		return result;
	}
}

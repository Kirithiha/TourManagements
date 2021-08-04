package com.revature.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.CityDaoRepository;
import com.revature.entity.City;
import com.revature.exceptions.NotFoundException;
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
	public int saveCity(City newCity) throws NotFoundException, SQLException {
		
		log.info("Inside SAVE CITY DAO");
		st = con.prepareStatement("insert into city values(?,?,?)");
		st.setString(1, newCity.getRtoCode());
		st.setString(2, newCity.getName());
		st.setString(3,newCity.getStateCode());
		int result = st.executeUpdate();
		
		// THROWS EXCEPTION IF 0 ROWS AFFECTED (DUPLICATE KEY).
		if(result == 0)
			throw new NotFoundException("Rto code Found");
		return 1;
	}

	// TO GET ALL CITY RECORD.
	@SuppressWarnings("null")
	@Override
	public List<City> readAllCites() throws SQLException {
		log.info("Inside READ ALL CITY DAO");
		List<City> cityList = new ArrayList<City>();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from city");
		if(rs!= null) {
			while(rs.next()) {
				City city = new City();
				city.setStateCode(rs.getString(3));
				city.setName(rs.getString(2));
				city.setRtoCode(rs.getString(1));
				cityList.add(city);
			}
		} 
		return cityList;
	}

	// TO GET PARTICULAR CITY RECORD BASED ON STATE AND CITY CODE.
	@Override
	public City readCityById(String rtoCode) throws SQLException {
		
		log.info("Inside READ  CITY DAO");
		City city = null;
		st = con.prepareStatement("select * from city where rtoCode = ?");
		st.setString(1, rtoCode);
		rs = st.executeQuery();
		if(rs!= null) {
			while(rs.next()) {
				city = new City();
				city.setStateCode(rs.getString(3));
				city.setName(rs.getString(2));
				city.setRtoCode(rs.getString(1));
			}
		} 
		return city;
	}

	// TO UPDATE PARTICULAR CITY RECORD BASED ON STATE AND CITY CODE.
	@Override
	public int updateCity(String rtoCode, String name) throws NotFoundException, SQLException {
		
		log.info("Inside UPDATE CITY DAO");
		st = con.prepareStatement("update city set name = ? where rtocode = ?");
		st.setString(1, name);
		st.setString(2, rtoCode);
		int result = st.executeUpdate();
		
		// THROWS EXCEPTION IF 0 ROWS AFFECTED.
		if(result == 0)
			throw new NotFoundException("Rto Code Not Found");
		return 1;	
	}

	// TO DELETE PARTICULAR CITY RECORD BASED ON STATE AND CITY CODE.
	@Override
	public int deleteCity(String rtoCode) throws NotFoundException, SQLException {
		
		log.info("Inside DELETE CITY DAO");
		st = con.prepareStatement("delete from city where rtocode = ?");
		st.setString(1, rtoCode);
		int result = st.executeUpdate();
		
		// THROWS EXCEPTION IF 0 ROWS AFFECTED (DUPLICATE KEY).
		if(result == 0)
			throw new NotFoundException("Rto Code Not Found");
		return 1;
	}
}

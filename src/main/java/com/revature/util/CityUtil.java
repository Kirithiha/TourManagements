package com.revature.util;

import com.revature.entity.City;
import com.revature.exceptions.NotFoundException;
import com.revature.service.implemenations.CityServiceImplementation;

import java.sql.SQLException;

import org.apache.log4j.Logger;


public class CityUtil {

	CityServiceImplementation cityImpl = new CityServiceImplementation();
	static Logger log = Logger.getLogger("CityUtil.class");
	// TO ADD NEW CITY RECORD TO TABLE.
	public int saveCity(City newCity) throws NotFoundException, SQLException {
		
		log.debug("Inside SAVE CITY UTIL");
		return cityImpl.saveCity(newCity);
	}

	// TO GET ALL CITY RECORD.
	public void readAllCities() throws SQLException {
		log.debug("Inside READ ALL CITY UTIL");
		cityImpl.readAllCities();
	}

	// TO GET PARTICULAR CITY RECORD BASED ON CITY CODE.
	public void readCityById(String rtoCode) throws NotFoundException, SQLException {
		log.debug("Inside READ CITY UTIL");
		cityImpl.readCityById(rtoCode);
	}

	// TO UPDATE PARTICULAR CITY RECORD BASED CITY CODE.
	public int updateCity(String rtoCode, String name) throws NotFoundException, SQLException {
		log.debug("Inside UPDATE CITY UTIL");
		return cityImpl.updateCity(rtoCode,name);
	}

	// TO DELETE PARTICULAR CITY RECORD BASED ON CITY CODE.
	public int deleteCity(String rtoCode) throws NotFoundException, SQLException {
		log.debug("Inside DELETE CITY UTIL");
		return cityImpl.deleteCity(rtoCode);
	}
	
}

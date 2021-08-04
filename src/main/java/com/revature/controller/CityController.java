package com.revature.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.entity.City;
import com.revature.exceptions.NotFoundException;
import com.revature.util.CityUtil;

public class CityController {
	
	CityUtil cityImpl = new CityUtil();
	static Logger log = Logger.getLogger("CityController.class");
	// TO ADD NEW CITY RECORD TO TABLE.
	public int saveCity(City newCity) throws NotFoundException, SQLException {
		
		log.debug("Inside SAVE CITY CONTROLLER");
		return cityImpl.saveCity(newCity);
	}

	// TO GET ALL CITY RECORD.
	public void readAllCities() throws SQLException {
		log.debug("Inside READ ALL CITY CONTROLLER");
		cityImpl.readAllCities();
	}

	// TO GET PARTICULAR CITY RECORD BASED ON CITY CODE.
	public void readCityById(String rtoCode) throws NotFoundException, SQLException {
		log.debug("Inside READ CITY CONTROLLER");
		cityImpl.readCityById(rtoCode);
	}

	// TO UPDATE PARTICULAR CITY RECORD BASED CITY CODE.
	public int updateCity(String rtoCode, String name) throws NotFoundException, SQLException {
		log.debug("Inside UPDATE CITY CONTROLLER");
		return cityImpl.updateCity(rtoCode, name);
	}

	// TO DELETE PARTICULAR CITY RECORD BASED ON CITY CODE.
	public int deleteCity(String rtoCode) throws NotFoundException, SQLException {
		log.debug("Inside DELETE CITY CONTROLLER");
		return cityImpl.deleteCity(rtoCode);
	}
	
}

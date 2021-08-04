package com.revature.controller;


import org.apache.log4j.Logger;

import com.revature.entity.City;
import com.revature.exceptions.NotFoundException;
import com.revature.utils.CityUtil;

public class CityController {
	
	CityUtil cityImpl = new CityUtil();
	static Logger log = Logger.getLogger("CityController.class");
	
	// TO ADD NEW STATE RECORD TO TABLE.
	public int saveCity(City newCity) throws NotFoundException {
		
		log.debug("Inside SAVE CITY CONTROLLER");
		return cityImpl.saveCity(newCity);
	}

	// TO GET ALL CITY RECORD.
	public void readAllCities() {
		log.debug("Inside READ ALL CITY CONTROLLER");
		cityImpl.readAllCities();
	}

	// TO GET PARTICULAR CITY RECORD BASED ON STATE AND CITY CODE.
	public void readCityById(String rtoCode) throws NotFoundException {
		log.debug("Inside READ CITY CONTROLLER");
		cityImpl.readCityById(rtoCode);
	}

	// TO UPDATE PARTICULAR CITY RECORD BASED ON STATE AND CITY CODE.
	public int updateCity(City newCity) throws NotFoundException {
		log.debug("Inside UPDATE CITY CONTROLLER");
		return cityImpl.updateCity(newCity);
	}

	// TO DELETE PARTICULAR CITY RECORD BASED ON STATE AND CITY CODE.
	public int deleteCity(String rtoCode) throws NotFoundException {
		log.debug("Inside DELETE CITY CONTROLLER");
		return cityImpl.deleteCity(rtoCode);
	}
	
}

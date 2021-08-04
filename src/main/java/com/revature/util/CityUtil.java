package com.revature.util;

import com.revature.entity.City;
import com.revature.exceptions.NotFoundException;
import com.revature.service.implemenations.CityServiceImplementation;
import org.apache.log4j.Logger;


public class CityUtil {

	CityServiceImplementation cityImpl = new CityServiceImplementation();
	static Logger log = Logger.getLogger("CityUtil.class");
	// TO ADD NEW CITY RECORD TO TABLE.
	public int saveCity(City newCity) throws NotFoundException {
		
		log.debug("Inside SAVE CITY UTIL");
		return cityImpl.saveCity(newCity);
	}

	// TO GET ALL CITY RECORD.
	public void readAllCities() {
		log.debug("Inside READ ALL CITY UTIL");
		cityImpl.readAllCities();
	}

	// TO GET PARTICULAR CITY RECORD BASED ON CITY CODE.
	public void readCityById(String rtoCode) throws NotFoundException {
		log.debug("Inside READ CITY UTIL");
		cityImpl.readCityById(rtoCode);
	}

	// TO UPDATE PARTICULAR CITY RECORD BASED CITY CODE.
	public int updateCity(City newCity) throws NotFoundException {
		log.debug("Inside UPDATE CITY UTIL");
		return cityImpl.updateCity(newCity);
	}

	// TO DELETE PARTICULAR CITY RECORD BASED ON CITY CODE.
	public int deleteCity(String rtoCode) throws NotFoundException {
		log.debug("Inside DELETE CITY UTIL");
		return cityImpl.deleteCity(rtoCode);
	}
	
}

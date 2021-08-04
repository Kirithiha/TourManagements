package com.revature.service.implemenations;

import com.revature.exceptions.NotFoundException;

import java.util.List;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.dao.implementation.CityDaoImplementation;
import com.revature.entity.City;
import com.revature.entity.State;
import com.revature.service.CityServiceRepository;
import com.revature.service.StateServiceRepository;

public class CityServiceImplementation implements CityServiceRepository{

	static Logger log = Logger.getLogger("CityServiceImplementation.class");
	
	CityDaoImplementation c_impl = new CityDaoImplementation();
	
	@Override
	public int saveCity(City newCity) throws NotFoundException, SQLException {
		
		log.debug("Inside SAVE CITY SERVICE");
		//TO ADD CITY
		return c_impl.saveCity(newCity);
	}

	@Override
	public void readAllCities() throws SQLException {
		
		log.debug("Inside READ ALL CITY SERVICE");
		// TO DISPLAY ALL CITIES
		List<City> cityList = c_impl.readAllCites();
		cityList.forEach(System.out :: println);
	}

	@Override
	public void readCityById(String rtoCode) throws NotFoundException, SQLException {

		log.debug("Inside READ CITY SERVICE");
		// TO DISPLAY PARTICULAR CITY.
		System.out.println(c_impl.readCityById(rtoCode));
	}

	@Override
	public int updateCity(String rtoCode, String name) throws NotFoundException, SQLException {
		
		log.debug("Inside UPDATE CITY SERVICE");
		// TO UPDATE CITY.
		return c_impl.updateCity(rtoCode, name);
	}

	@Override
	public int deleteCity(String rtoCode) throws NotFoundException, SQLException {
		
		log.debug("Inside DELETE CITY SERVICE");
		// TO DELETE CITY.
		return c_impl.deleteCity(rtoCode);
	}

}

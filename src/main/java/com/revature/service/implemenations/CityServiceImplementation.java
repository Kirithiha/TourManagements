package com.revature.service.implemenations;



import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.implementation.CityDaoImplementation;
import com.revature.dto.City;
import com.revature.service.CityServiceRepository;

public class CityServiceImplementation implements CityServiceRepository{

	static Logger log = Logger.getLogger("CityServiceImplementation.class");
	
	CityDaoImplementation c_impl = new CityDaoImplementation();
	
	@Override
	public int saveCity(City newCity) {
		
		log.debug("Inside SAVE CITY SERVICE");
		//TO ADD CITY
		return c_impl.saveCity(newCity);
	}

	@Override
	public void readAllCities() {
		
		log.debug("Inside READ ALL CITY SERVICE");
		// TO DISPLAY ALL CITIES
		List<City> cityList = c_impl.readAllCites();
		if(cityList!=null)
			cityList.forEach(System.out :: println);
	}

	@Override
	public void readCityById(String rtoCode) {

		log.debug("Inside READ CITY SERVICE");
		// TO DISPLAY PARTICULAR CITY.
		City city = c_impl.readCityById(rtoCode);
		if(city!=null)
			System.out.println(city);
	}

	@Override
	public int updateCity(String rtoCode, String name) {
		
		log.debug("Inside UPDATE CITY SERVICE");
		// TO UPDATE CITY.
		return c_impl.updateCity(rtoCode, name);
	}

	@Override
	public int deleteCity(String rtoCode) {
		
		log.debug("Inside DELETE CITY SERVICE");
		// TO DELETE CITY.
		return c_impl.deleteCity(rtoCode);
	}

}

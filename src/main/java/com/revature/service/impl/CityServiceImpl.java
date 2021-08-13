package com.revature.service.impl;



import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.impl.CityDaoImpl;
import com.revature.dto.CityDto;
import com.revature.service.CityService;

public class CityServiceImpl implements CityService{

	static Logger log = Logger.getLogger("CityServiceImplementation.class");
	
	CityDaoImpl c_impl = new CityDaoImpl();
	
	@Override
	public int saveCity(CityDto newCity) {
		
		log.debug("Inside SAVE CITY SERVICE");
		//TO ADD CITY
		return c_impl.saveCity(newCity);
	}

	@Override
	public void readAllCities() {
		
		log.debug("Inside READ ALL CITY SERVICE");
		// TO DISPLAY ALL CITIES
		List<CityDto> cityList = c_impl.readAllCites();
		if(cityList!=null)
			cityList.forEach(System.out :: println);
	}

	@Override
	public void readCityById(String rtoCode) {

		log.debug("Inside READ CITY SERVICE");
		// TO DISPLAY PARTICULAR CITY.
		CityDto city = c_impl.readCityById(rtoCode);
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

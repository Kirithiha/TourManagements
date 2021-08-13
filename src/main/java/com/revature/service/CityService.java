package com.revature.service;

import com.revature.dto.CityDto;

public interface CityService {

	public int saveCity(CityDto newCity);
	public void readAllCities();
	public void readCityById(String rtoCode);
	public int updateCity(String rtoCode, String name);
	public int deleteCity(String rtoCode);
	
}

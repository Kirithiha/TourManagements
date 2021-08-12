package com.revature.service;

import com.revature.dto.City;

public interface CityServiceRepository {

	public int saveCity(City newCity);
	public void readAllCities();
	public void readCityById(String rtoCode);
	public int updateCity(String rtoCode, String name);
	public int deleteCity(String rtoCode);
	
}

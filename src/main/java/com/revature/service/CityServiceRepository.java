package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.entity.City;
import com.revature.exceptions.NotFoundException;

public interface CityServiceRepository {

	public List<City> cityList = new ArrayList<City>();
	public int saveCity(City newCity) throws NotFoundException;
	public void readAllCities();
	public void readCityById(String rtoCode) throws NotFoundException;
	public int updateCity(City newCity) throws NotFoundException;
	public int deleteCity(String rtoCode) throws NotFoundException;
	
}

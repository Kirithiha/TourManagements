package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.NotFoundException;
import com.revature.models.City;

public interface CityServiceRepository {

	public List<City> cityList = new ArrayList<City>();
	public int saveCity(City newCity) throws NotFoundException;
	public void readAllCities();
	public void readCityById(Character[] rtoCode) throws NotFoundException;
	public int updateCity(City newCity) throws NotFoundException;
	public int deleteCity(Character[] rtoCode) throws NotFoundException;
	
}

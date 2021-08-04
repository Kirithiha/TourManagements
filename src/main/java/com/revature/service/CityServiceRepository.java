package com.revature.service;

import java.sql.SQLException;

import com.revature.exceptions.NotFoundException;
import com.revature.entity.City;

public interface CityServiceRepository {

	public int saveCity(City newCity) throws NotFoundException, SQLException;
	public void readAllCities() throws SQLException;
	public void readCityById(String rtoCode) throws NotFoundException, SQLException;
	public int updateCity(String rtoCode, String name) throws NotFoundException, SQLException;
	public int deleteCity(String rtoCode) throws NotFoundException, SQLException;
	
}

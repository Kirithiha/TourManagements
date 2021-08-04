package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.entity.City;
import com.revature.exceptions.NotFoundException;

//CITY DAO REPOSITORY.
public interface CityDaoRepository {

	public int saveCity(City newCity) throws NotFoundException, SQLException;
	public List<City> readAllCites() throws SQLException;
	public City readCityById(String rtoCode) throws SQLException;
	public int updateCity(String rtoCode, String name) throws NotFoundException, SQLException;
	public int deleteCity(String rtoCode) throws NotFoundException, SQLException;

}

package com.revature.dao;

import java.util.List;

import com.revature.dto.City;

//CITY DAO REPOSITORY.
public interface CityDaoRepository {

	public int saveCity(City newCity);
	public List<City> readAllCites();
	public City readCityById(String rtoCode);
	public int updateCity(String rtoCode, String name);
	public int deleteCity(String rtoCode);

}

package com.revature.dao;

import java.util.List;

import com.revature.dto.CityDto;

//CITY DAO REPOSITORY.
public interface CityDao {

	public int saveCity(CityDto newCity);
	public List<CityDto> readAllCites();
	public CityDto readCityById(String rtoCode);
	public int updateCity(String rtoCode, String name);
	public int deleteCity(String rtoCode);

}

package com.revature.mapper;

import com.revature.dto.City;
import com.revature.entity.CityEntity;

public class CityMapper {

	public static CityEntity cityMap(City c) {
		
		CityEntity ce = new CityEntity();
		ce.setRtoCode(c.getRtoCode());
		ce.setName(c.getName());
		ce.setStateCode(c.getStateCode());
		return ce;
	}
}

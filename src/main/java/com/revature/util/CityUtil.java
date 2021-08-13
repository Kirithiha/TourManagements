package com.revature.util;

import com.revature.dto.CityDto;
import com.revature.entity.City;


public class CityUtil {

	public static City dtoToEntity(CityDto c) {
			
			City ce = new City();
			ce.setRtoCode(c.getRtoCode());
			ce.setName(c.getName());
			ce.setStateCode(c.getStateCode());
			return ce;
	}
	
	public static CityDto entityToDto(City c) {
		
		CityDto ce = new CityDto();
		ce.setRtoCode(c.getRtoCode());
		ce.setName(c.getName());
		ce.setStateCode(c.getStateCode());
		return ce;
}
}

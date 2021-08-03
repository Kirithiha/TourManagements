package com.revature.service.implemenations;

import com.revature.exceptions.NotFoundException;
import com.revature.models.City;
import com.revature.models.State;
import com.revature.service.CityServiceRepository;
import com.revature.service.StateServiceRepository;

public class CityServiceImplementation implements CityServiceRepository{

	@Override
	public int saveCity(City newCity) throws NotFoundException {
		
		//CHECKS FOR FOREIGN KEY - STATE CODE.
		int flag = 0;
		for(State state :StateServiceRepository.state_list ) {
			if(state.getCode().equals(newCity.getStateCode())) {
				flag = 1;
				break;
			}
		}
		if(flag == 0) 
			throw new NotFoundException("No state code is found in state tabe");
		
		//CHECKS FOR UNIQUE ID.
		for(City city : cityList) {
			if(city.getRtoCode().equals(newCity.getRtoCode()) )
					throw new NotFoundException("Rto Code Already Found");
		}
		// TO ADD CITY TO LIST.
		cityList.add(newCity);
		return 1;
	}

	@Override
	public void readAllCities() {
		
		// TO DISPLAY ALL CITIES
		cityList.forEach(System.out :: println);
	}

	@Override
	public void readCityById(Character[] rtoCode) throws NotFoundException {

		// STREAMS TO GET THE PARTICULAR STATE BY GIVEN STATE CODE.
		City city = cityList.stream().filter(s-> rtoCode.equals(s.getRtoCode())).findAny().orElse(null);
						
		//THROWS EXCEPTION IF NO ID FOUND
		if(city == null) {
			throw new NotFoundException("No rto code found");
		} else {
					
			// TO DISPLAY THE STATE
			System.out.println(city);
		}
	}

	@Override
	public int updateCity(City newCity) throws NotFoundException {
		
		Character[] cityCode = newCity.getRtoCode();
		
		//STREAMS TO GET INDEX.
	    City city = cityList.stream().filter(s-> cityCode.equals(s.getRtoCode())).findAny().orElse(null);
		
	    //THROWS EXCEPTION IF NO ID WAS FOUND.
	    if(city == null) {
			throw new NotFoundException("No rto code found");
		} else {
			// TO UPDATE THE STATE.
			int i = cityList.indexOf(city);
			cityList.set(i,newCity);
		}
		return 1;
	}

	@Override
	public int deleteCity(Character[] rtoCode) throws NotFoundException {
		
		// STREAMS TO GET THE INDEX OF ID
		City city = cityList.stream().filter(s-> rtoCode.equals(s.getRtoCode())).findAny().orElse(null);
						
		//THROWS EXCEPTION IF NO ID FOUND
		if(city == null) {
			throw new NotFoundException("No rto code found");
		} else {
			
			// TO REMOVE PARTICULAR ID FROM LIST
			int i = cityList.indexOf(city);
			cityList.remove(i);
		}
		return 1;
	}

}

package com.revature.tourmanagement;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.CityController;
import com.revature.entity.City;
import com.revature.exceptions.NotFoundException;

public class CityAdmin {
	
	static Logger log = Logger.getLogger("CityAdmin.class");

	public void accessCity() throws NotFoundException {

		log.debug("Inside CITY ADMIN");
		City city;
		CityController s_impl = new CityController();
		Scanner in = new Scanner(System.in);
		System.out.println("Your options are :");
		System.out.println("1. Create \n2. Read \n3. Update \n4. Delete \n5. Back to Main Menu");
		int choice;
		do {
			String cityName,rtoCode,stateCode;
			System.out.println("Enter your CRUD choice :");
			choice = in.nextInt();
			in.nextLine();
			switch(choice) {
				case 1 :
					System.out.println("Enter the state code :");
					stateCode = in.nextLine();
					System.out.println("Enter the city code :");
					rtoCode = in.nextLine();
					System.out.println("Enter the name of the city :");
					cityName = in.nextLine();
					city = new City( rtoCode, cityName, stateCode);
					city.setValues(rtoCode, stateCode);
					if(s_impl.saveCity(city) == 1) 
						log.info("City created successfully... :)");
					break;
				case 2 : 
					System.out.println("Read city by\n1. ID\n2. All Cities");
					System.out.println("Enter your read choice: ");
					int readChoice = in.nextInt();
					in.nextLine();
					if(readChoice == 1) {
						System.out.println("Enter the code of the city to be displayed :");
						rtoCode = in.nextLine();
						s_impl.readCityById(rtoCode);
					} else if(readChoice == 2) 
						s_impl.readAllCities();
					break;
				case 3:
					System.out.println("Enter the state code of the city to be updated :");
					stateCode = in.nextLine();
					System.out.println("Enter the code of the city to be updated :");
					rtoCode = in.nextLine();
					System.out.println("Enter the name of the city to be updated :");
					cityName = in.nextLine();
					city = new City(rtoCode, cityName, stateCode);
					city.setValues(rtoCode, stateCode);
					if(s_impl.updateCity(city)==1)
						log.info("City Updated successfully... :)");
					break;
				case 4:
					System.out.println("Enter the code of the city to be updated :");
					rtoCode = in.nextLine();
					if(s_impl.deleteCity(rtoCode)==1)
						log.info("City Deleted successfully... :)");
					break;
				case 5:
					break;
				default:
					System.out.println("Please enter valid choice..!!");
			}
		}while(choice!=5);

	}
}

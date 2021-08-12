package com.revature.tourmanagement;

import java.sql.SQLException;
import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.revature.dto.City;
import com.revature.exceptions.NotFoundException;
import com.revature.properties.ScannerUtil;
import com.revature.util.CityUtil;

public class CityAdmin {

	static Logger log = Logger.getLogger("CityAdmin.class");
	public int checkCode(String rtoCode) {
		try {
			System.out.println(rtoCode.length()+" " + rtoCode);
			if(rtoCode.length() == 4 || rtoCode.length() == 5) 
				return 1;
			else
				throw new NotFoundException("Rto code is not in correct format");
		}catch(NotFoundException e) {
			log.info("Rto Code not Found "+e);
		}
		return 0;
	}
	
	public void accessCity() throws NotFoundException, SQLException {

		City city;
		CityUtil s_impl = new CityUtil();
		log.info("\nYour options are :");
		log.info("\n1. Create \n2. Read \n3. Update \n4. Delete \n5. Back to Main Menu");
		int choice=0;
		do {
			String rtoCode, name, stateCode;
			System.out.println("Enter your CRUD choice :");
			try {
			choice = ScannerUtil.in.nextInt();
			}catch(InputMismatchException e) {
				log.info(e);
			}
			ScannerUtil.in.nextLine();
			switch(choice) {
				case 1 :
					log.info("Enter the state code :");
					stateCode = ScannerUtil.in.nextLine();
					log.info("Enter the city rto code :");
					rtoCode = ScannerUtil.in.nextLine();
					log.info("Enter the name of the city :");
					name = ScannerUtil.in.nextLine();
					city = new City(name);
					city.setCode(rtoCode, stateCode);
					if(city.getRtoCode()!=null && city.getStateCode()!=null) {
					if(s_impl.saveCity(city) == 1) 
						log.info("City created successfully... :)");
					}
					break;
				case 2 : 
					log.info("Read city by\n1. ID\n2. All Cities");
					log.info("Enter your read choice: ");
					int readChoice = ScannerUtil.in.nextInt();
					ScannerUtil.in.nextLine();
					if(readChoice == 1) {
						log.info("Enter the rto code of the city to be displayed :");
						rtoCode = ScannerUtil.in.nextLine();
						if(checkCode(rtoCode)==1) 
							s_impl.readCityById(rtoCode);
					} else if(readChoice == 2) 
						s_impl.readAllCities();
					break;
				case 3:
					log.info("Enter the rto code of the city to be updated :");
					rtoCode = ScannerUtil.in.nextLine();
					log.info("Enter the name of the city to be updated :");
					name = ScannerUtil.in.nextLine();
					if(checkCode(rtoCode)==1) {
						if(s_impl.updateCity(rtoCode, name)==1)
							log.info("City Updated successfully... :)");
					}
					break;
				case 4:
					log.info("Enter the rto code of the city to be updated :");
					rtoCode = ScannerUtil.in.nextLine();
					if(checkCode(rtoCode)==1) {
						if(s_impl.deleteCity(rtoCode)==1)
							log.info("City Deleted successfully... :)");
					}
					break;
				case 5:
					log.info("Back to Main menu Successfully ... :)");
					break;
				default:
					log.info("Please enter valid choice..!!");
			}
		}while(choice!=5);
	}
}

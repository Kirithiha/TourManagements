package com.revature.tourmanagement;

import java.sql.SQLException;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.revature.dto.CityDto;
import com.revature.exceptions.NotFoundException;
import com.revature.service.impl.CityServiceImpl;
import com.revature.util.ScannerUtil;

public class CityAdmin {

	static Logger log = Logger.getLogger("CityAdmin.class");
	
	// To CHECK RTO CODE(TN72 OR TN01X) AND STATE CODE(TN)
	public int setCode (String rtoCode, String stateCode) {
		int flag1 = 0, flag2 = 0;;
		try {
			System.out.println(rtoCode.length()+" " + rtoCode);
			if(rtoCode.length() == 4 || rtoCode.length() == 5) 
				flag1 = 1;
			else {
				flag1 = 0;
				throw new NotFoundException("Rto code is not in correct format");
			}
			if(stateCode.length() == 2) 
				flag2 = 1;
			else {
				flag2 = 0;
				throw new NotFoundException("State code is not in correct format");
			}
		}catch(NotFoundException e) {
			log.info(e);
		}
		if(flag1==1 && flag2==1)
			return 1;
		return 0;
	}
	
	//TO CHECH RTOCODE ALONE(TN72 OR TN01X).
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

		CityDto city;
		CityServiceImpl s_impl = new CityServiceImpl();
		int choice=0;
		do {
			log.info("\nYour options are :");
			log.info("\n1. Create \n2. Read \n3. Update \n4. Delete \n5. Back to Main Menu");
			String rtoCode, name, stateCode;
			System.out.println("Enter your CRUD choice :");
			try {
			choice = ScannerUtil.in.nextInt();
			}catch(InputMismatchException e) {
				log.info(e+" Enter integer value as input for choice");
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
					int res = setCode(rtoCode, stateCode);
					if(res==1) {
						city = new CityDto(name,rtoCode,stateCode);
						if(s_impl.saveCity(city) == 1) 
							log.info("City created successfully... :)");
					}
					break;
				case 2 : 
					log.info("Read city by\n1. ID\n2. All Cities");
					log.info("Enter your read choice: ");
					int readChoice =0;
					try {
						readChoice = ScannerUtil.in.nextInt();
					} catch(InputMismatchException e) {
						log.info(e+" Enter integer as choice");
					}
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

package com.revature.tourmanagement;

import java.sql.SQLException;
import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.revature.exceptions.NotFoundException;
import com.revature.properties.ScannerUtil;

public class Admin {
	
	static Logger log = Logger.getLogger("Admin.class");
    public static void main( String[] args ) throws NotFoundException, SQLException {
    	
    	int mainChoice=0;
    	 for(;;) {
			log.info("\nYour choices are");
			log.info("\n1. Manage State\n2. Manage City\n3. Logout");
			log.info("Enter your choice :");
			try {
			mainChoice = ScannerUtil.in.nextInt();
			}catch(InputMismatchException e) {
				log.info(e);
			}
			ScannerUtil.in.next();
			switch(mainChoice) {
				case 1:
					StateAdmin state = new StateAdmin();
					state.accessState();
					break;
				case 2:
					CityAdmin city = new CityAdmin();
					city.accessCity();
					break;
				case 3:
					ScannerUtil.in.close();
					log.info("Logged Out Successfully ... :)");
					System.exit(0);
					break;
				default :
					log.info("Please enter the valid choice !!");
			}
    	 }
    }
}

package com.revature.tourmanagement;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.revature.exceptions.NotFoundException;

public class Admin 
{
	static Logger log = Logger.getLogger("Admin.class");

    public static void main( String[] args ) throws NotFoundException
    {
    	BasicConfigurator.configure();
    	log.debug("Inside Main");
    	Scanner in = new Scanner(System.in);
		do {
			int mainChoice;
			System.out.println("Your choices are");
			System.out.println("1. Manage State\n2. Manage City\n3. Logout");
			System.out.println("Enter your choice :");
			mainChoice = in.nextInt();
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
					in.close();
					System.out.println("Logged Out Successfully ... :)");
					System.exit(0);
					break;
				default :
					System.out.println("Please enter the valid choice !!");
			}
		}while(true);	
    }
}

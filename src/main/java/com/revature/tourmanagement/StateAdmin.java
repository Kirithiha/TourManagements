package com.revature.tourmanagement;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.controller.StateController;
import com.revature.entity.State;
import com.revature.exceptions.NotFoundException;
import com.revature.properties.ScannerUtil;

public class StateAdmin {

	static Logger log = Logger.getLogger("StateAdmin.class");
	public void accessState() throws NotFoundException, SQLException{
		
		log.debug("Inside STATE ADMIN");
		State s;
		StateController s_impl = new StateController();
		System.out.println("Your options are :");
		System.out.println("1. Create \n2. Read \n3. Update \n4. Delete \n5. Back to Main Menu");
		int choice;
		do {
			String code, name;
			System.out.println("Enter your CRUD choice :");
			choice = ScannerUtil.in.nextInt();
			ScannerUtil.in.nextLine();
			switch(choice) {
				case 1 :
					System.out.println("Enter the state code :");
					code = ScannerUtil.in.nextLine();
					System.out.println("Enter the name of the state :");
					name = ScannerUtil.in.nextLine();
					s = new State(name);
					s.setCodeValue(code);
					if(s_impl.saveState(s) == 1) 
						log.info("State created successfully... :)");
					break;
				case 2 : 
					System.out.println("Read state by\n1. ID\n2. All states");
					System.out.println("Enter your read choice: ");
					int readChoice = ScannerUtil.in.nextInt();
					ScannerUtil.in.nextLine();
					if(readChoice == 1) {
						System.out.println("Enter the code of the state to be displayed :");
						code = ScannerUtil.in.nextLine();
						s_impl.readStateById(code);
					} else if(readChoice == 2) 
						s_impl.readAllStates();
					break;
				case 3:
					System.out.println("Enter the id to be updated :");
					code = ScannerUtil.in.nextLine();
					System.out.println("Enter the name of the state to be updated :");
					name = ScannerUtil.in.nextLine();
					s = new State(name);
					s.setCodeValue(code);
					if(s_impl.updateState(s)==1)
						log.info("State Updated successfully... :)");
					break;
				case 4:
					System.out.println("Enter the code of the state to be deleted :");
					code = ScannerUtil.in.nextLine();
					if(s_impl.deleteState(code)==1)
						log.info("State Deleted successfully... :)");
					break;
				case 5:
					break;
				default:
					System.out.println("Please enter valid choice..!!");
			}
		}while(choice!=5);
		
	}

}

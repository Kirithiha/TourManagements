package com.revature.tourmanagement;



import org.apache.log4j.Logger;

import com.revature.dto.State;
import com.revature.exceptions.NotFoundException;
import com.revature.properties.ScannerUtil;
import com.revature.util.StateUtil;

public class StateAdmin {

	static Logger log = Logger.getLogger("StateAdmin.class");
	
	public int checkCode(String stateCode) {
		try {
			if(stateCode.length() == 2) 
				return 1;
			else
				throw new NotFoundException("State code is not in correct format");
		}catch(NotFoundException e) {
				log.info(e);
		}
		return 0;
	}
	
	public void accessState() {
	
		State s;
		StateUtil s_impl = new StateUtil();
		log.info("\nYour options are :");
		log.info("\n1. Create \n2. Read \n3. Update \n4. Delete \n5. Back to Main Menu");
		int choice;
		do {
			String code, name;
			log.info("Enter your CRUD choice :");
			choice = ScannerUtil.in.nextInt();
			ScannerUtil.in.nextLine();
			switch(choice) {
				case 1 :
					log.info("Enter the state code :");
					code = ScannerUtil.in.nextLine();
					log.info("Enter the name of the state :");
					name = ScannerUtil.in.nextLine();
					s = new State(name);
					s.setCodeValue(code);
					if(s.getCode()!=null) {
						if(s_impl.saveState(s) == 1) 
							log.info("State created successfully... :)");
					}
					break;
				case 2 : 
					log.info("Read state by\n1. ID\n2. All states");
					log.info("Enter your read choice: ");
					int readChoice = ScannerUtil.in.nextInt();
					ScannerUtil.in.nextLine();
					if(readChoice == 1) {
						log.info("Enter the code of the state to be displayed :");
						code = ScannerUtil.in.nextLine();
						if(checkCode(code) ==1 )
							s_impl.readStateById(code);
					} else if(readChoice == 2) 
						s_impl.readAllStates();
					break;
				case 3:
					log.info("Enter the id to be updated :");
					code = ScannerUtil.in.nextLine();
					log.info("Enter the name of the state to be updated :");
					name = ScannerUtil.in.nextLine();
					s = new State(name);
					s.setCodeValue(code);
					if(s.getCode()!=null) {
						if(s_impl.updateState(s)==1)
							log.info("State Updated successfully... :)");
					}
					break;
				case 4:
					log.info("Enter the code of the state to be deleted :");
					code = ScannerUtil.in.nextLine();
					if(checkCode(code) == 1) {
						if(s_impl.deleteState(code)==1)
							log.info("State Deleted successfully... :)");
					}
					break;
				case 5:
					log.info("Back Main menu Successfully ... :)");
					break;
				default:
					log.info("Please enter valid choice..!!");
			}
		}while(choice!=5);
		
	}

}

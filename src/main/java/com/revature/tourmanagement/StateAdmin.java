package com.revature.tourmanagement;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.controller.StateController;
import com.revature.entity.State;
import com.revature.exceptions.NotFoundException;

public class StateAdmin {
	
	static Logger log = Logger.getLogger("StateAdmin.class");

	public void accessState() throws NotFoundException{
		
		log.debug("Inside State Admin class");
		State s;
		StateController s_impl = new StateController();
		Scanner in = new Scanner(System.in);
		System.out.println("Your options are :");
		System.out.println("1. Create \n2. Read \n3. Update \n4. Delete \n5. Back to Main Menu");
		int choice;
		do {
			String state_code, state_name;
			System.out.println("Enter your CRUD choice :");
			choice = in.nextInt();
			in.nextLine();
			switch(choice) {
				case 1 :
					System.out.println("Enter the state code :");
					state_code = in.nextLine();
					System.out.println("Enter the name of the state :");
					state_name = in.nextLine();
					s = new State(state_code, state_name);
					s.setValues(state_code);
					if(s_impl.saveState(s) == 1) 
						log.info("State created successfully... :)");
					break;
				case 2 : 
					System.out.println("Read state by\n1. ID\n2. All states");
					System.out.println("Enter your read choice: ");
					int readChoice = in.nextInt();
					in.nextLine();
					if(readChoice == 1) {
						System.out.println("Enter the code of the state to be displayed :");
						String code = in.nextLine();
						s_impl.readStateById(code);
					} else if(readChoice == 2) 
						s_impl.readAllStates();
					break;
				case 3:
					System.out.println("Enter the id to be updated :");
					state_code = in.nextLine();
					System.out.println("Enter the name of the state to be updated :");
					state_name = in.nextLine();
					s = new State(state_code,state_name);
					s.setValues(state_code);
					if(s_impl.updateState(s)==1)
						log.info("State Updated successfully... :)");
					break;
				case 4:
					System.out.println("Enter the code of the state to be deleted :");
					state_code = in.nextLine();
					if(s_impl.deleteState(state_code)==1)
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

package HallAdmissionSystem;

import java.io.*;
import java.util.*;

public class LoginPortal{

		private static LoginPortal instance = new LoginPortal();
		private ArrayList<Account> accountList;


	private LoginPortal(){
		try {
		File inputFile=new File("C:\\Users\\amble\\OneDrive\\орн▒\\Cs3343\\Hall-Admission-System\\src\\Database.csv");
		Scanner in=new Scanner(inputFile);
		
		in.nextLine();
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		
	}

	private static LoginPortal getInstance() {
		
		return instance;
	}

	public Account login() {
		// TODO - implement LoginPortal.login
		throw new UnsupportedOperationException();
	}

}
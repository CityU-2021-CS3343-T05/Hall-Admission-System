package HallAdmissionSystem;

import java.io.*;
import java.util.*;

public class LoginPortal {

	private static LoginPortal instance = new LoginPortal();
	private ArrayList<Account> accountList = new ArrayList<Account>();

	private LoginPortal() {
		try {
			File inputFile = new File("Database.csv");
			Scanner in = new Scanner(inputFile);

			in.nextLine();
			while (in.hasNextLine()) {
				String inLine = in.nextLine();
				String[] inLineContent = inLine.split(",");
				String type, sid, name, charIsLocal, userName, userPwd;
				int year;
				boolean isLocal = true;
				type = inLineContent[0];
				if (type.equals("School")) {
					userName = inLineContent[4];
					userPwd = inLineContent[5];
					Account account = new CityU(userName, userPwd);
					accountList.add(account);
				} else if (type.equals("Student")) {
					sid = inLineContent[1];
					year = Integer.parseInt(inLineContent[2]);
					charIsLocal = inLineContent[3];
					if (charIsLocal.equals("T"))
						isLocal = true;
					else if (charIsLocal.equals("F"))
						isLocal = false;
					userName = inLineContent[4];
					userPwd = inLineContent[5];
					Account account = new Student(sid, userName, userPwd, isLocal, year);
					accountList.add(account);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			Display.runDisplayLine("File Not Found");
		}

	}

	public static LoginPortal getInstance() {
		return instance;
	}

	private Account findAccount(String inputUserName) {
		if (inputUserName.isEmpty()) {
			Display.runDisplayLine("User Name cannot empty! Please try again!");
			return null;
		} else {
			for (Account e : accountList) {
				if (inputUserName.equals(e.getUserName()))
					return e;
			}
		}
		Display.runDisplayLine("No existing User! Please try again!");
		return null;
	}

	private Account checkPwd(Account targetAc, String inputUserPwd) {
		if (inputUserPwd.isEmpty()) {
			Display.runDisplayLine("Password cannot empty! Please try again!");
			return null;
		} else {
			if (inputUserPwd.equals(targetAc.getUserPwd()))
				return targetAc;
		}
		Display.runDisplayLine("Wrong Password!Please try again!");
		return null;
	}

	public Account login() {
		
		Display.runTitleLine("Login Portal");
		
		Display.getScanner();
		
		String uName = Display.runDisplayDetails("Enter Username");
		
		Account findUserAc = findAccount(uName);
		
		while (findUserAc == null) {
			uName = Display.runDisplayDetails("Re enter Username");
			findUserAc = findAccount(uName);
		}
		
		String psw = Display.runDisplayDetails("Enter Password");
		
		Account userAccount = checkPwd(findUserAc, psw);
		
		while (userAccount == null) {
			psw = Display.runDisplayDetails("Re enter Password");
			userAccount = checkPwd(findUserAc, psw);
		}
		
		Display.runDisplayLine("Login Successful");
		
		Display.runEndLine();
		
		return userAccount;
	}
}
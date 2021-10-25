package HallAdmissionSystem;

import java.io.*;
import java.util.*;

public class LoginPortal{

	private static LoginPortal instance = new LoginPortal();
	private ArrayList<Account> accountList=new ArrayList<Account>();

	private LoginPortal(){
		try {
			File inputFile=new File("Database.csv");
			Scanner in=new Scanner(inputFile);
		
			in.nextLine();
			while(in.hasNextLine()) {
				String inLine=in.nextLine();
				String[] inLineContent=inLine.split(",");
				String type,sid,name,charIsLocal,userName,userPwd;
				int year;
				boolean isLocal=true;
				type=inLineContent[0];
				if (type.equals("School")) {
					userName=inLineContent[4];
					userPwd=inLineContent[5];
					Account account=new CityU(userName,userPwd);
					accountList.add(account);
				}else if(type.equals("Student")) {
					sid=inLineContent[1];
					year=Integer.parseInt(inLineContent[2]);
					charIsLocal=inLineContent[3];
					if(charIsLocal.equals("T"))
						 isLocal=true;
					else if(charIsLocal.equals("F"))
						isLocal=false;
					userName=inLineContent[4];
					userPwd=inLineContent[5];
					Account account=new Student(sid,year,isLocal,userName,userPwd);
					accountList.add(account);
				}
				
			}
			
			in.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
	}

	public static LoginPortal getInstance() {
		
		return instance;
	}
	
	public Account findAccount(String inputUserName) {
		if(inputUserName.isEmpty()) { 
			System.out.println("User Name cannot empty! Please try again!");
			return null;
		}else{
			for(Account e:accountList){
				if(inputUserName.equals(e.getUserName()))
					return e;
			}
		}
		System.out.println("No existing User! Please try again!");
		return null;
	}
	
	public Account checkPwd(Account targetAc, String inputUserPwd) {
		if(inputUserPwd.isEmpty()) { 
			System.out.println("Password cannot empty! Please try again!");
			return null;
		}else{
			if(inputUserPwd.equals(targetAc.getUserPwd()))
				return targetAc;
		}
		System.out.println("Wrong Password!Please try again!");
		return null;
		
	}

	public Account login() {
		Account targetAc;
		Scanner input = new Scanner(System.in);
		String inputUserName,inputUserPwd;
		System.out.println("Please enter User Name");
		inputUserName=input.nextLine();
		targetAc=findAccount(inputUserName);
		if(targetAc!=null) {
			System.out.println("Please enter Password");
			inputUserPwd=input.nextLine();
			targetAc=checkPwd(targetAc,inputUserPwd);
		}
		input.close();
		return targetAc;
		
	}

}
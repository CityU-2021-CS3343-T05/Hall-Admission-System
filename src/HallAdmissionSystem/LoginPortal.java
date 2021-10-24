package HallAdmissionSystem;

import java.io.*;
import java.util.*;

public class LoginPortal{

	private static LoginPortal instance = new LoginPortal();
	private ArrayList<Account> accountList=new ArrayList<Account>();
	private Account cityU;


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
					cityU=new CityU(userName,userPwd);
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
					Student student=new Student(sid,year,isLocal,userName,userPwd);
					accountList.add(student);
					System.out.println(student.getUserName());
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
		if(inputUserName==null) { 
			System.out.println("User Name cannot empty! Please try again!");
			return null;
		}else{
			for(Account e:accountList){
				if(inputUserName.equals(e.getUserName()))
					return e;
			}
		}
		return null;
	}
	
	public Account checkPwd(Account targetAc, String inputUserPwd) {
		if(inputUserPwd==null) { 
			System.out.println("Password cannot empty! Please try again!");
			return null;
		}else{
			if(inputUserPwd.equals(targetAc.getUserPwd()))
				return targetAc;
		}
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
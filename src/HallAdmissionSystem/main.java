package HallAdmissionSystem;

import java.util.Scanner;

import javax.print.attribute.standard.Chromaticity;

public class main {
	public static void main(String[] args) throws Exception {	
		HallSystem hS = HallSystem.getInstance();
		System.out.println("> Application");
		Student std1 = new Student("001", "Jennifer", "s001", false, 4);
		hS.createApplication(std1, 1, new ScoreComponent("GPA", "4.2", "2", "300", "Cheung Chau"));
		
		Student std2 = new Student("002", "Elston", "s002", false, 2);
		hS.createApplication(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
		
		Student std3 = new Student("003", "Wilson", "s003", true, 2);
		hS.createApplication(std3, 1, new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau"));
		
		Student std4 = new Student("004", "Chung", "s004", true, 2);
		hS.createApplication(std4, 3, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
		
		Student std5 = new Student("005", "Jacky", "s005", false, 2);
		hS.createApplication(std5, 1, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
		
		Student std6 = new Student("006", "Alex", "s006", false, 2);
		hS.createApplication(std6, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
		
//		
		Display.createScanner();
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Log in as Student or Admin?");
			String ans = sc.nextLine();
			if(ans.equals("Student") || ans.equals("student")) {
				StudentLogin.login();
			}
			else if(ans.equals("Admin") || ans.equals("admin")) {
				Account cityU = LoginPortal.getInstance().login();
				
				cityU.mainManual();
			}
			Display.runDisplayLine("System End");
//			Display.closeScanner();
		}
		//		hS.viewAllApplication();
//		

	}

	
}

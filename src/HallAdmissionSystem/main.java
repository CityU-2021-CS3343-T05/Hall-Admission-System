package HallAdmissionSystem;

public class main {
	public static void main(String[] args) throws Exception {
//		LoginPortal loginPortal = LoginPortal.getInstance();
//		Account ac=loginPortal.login();
//		if(ac!=null)
//			if(ac instanceof Student)
//				System.out.println(((Student)ac).getSid());
//			else if(ac instanceof CityU)
//				System.out.println(((CityU)ac).getUserName());
//		
//		Test add score
//		System.out.println("Testing Academic DSE");
//		ScoreComponent s_AC_1 = new ScoreComponent("DSE", "5*", "5", "180", "Cheung Chau");
//		System.out.println(s_AC_1.getAcademic());
//		s_AC_1.setAcademic("5**");
//		System.out.println(s_AC_1.getAcademic());
//		
//		System.out.println("Testing Leader");
//		System.out.println(s_AC_1.getLeaderShip());
//		s_AC_1.setLeaderShip("2");
//		System.out.println(s_AC_1.getLeaderShip());
//		
//		System.out.println("Testing ECA");
//		System.out.println(s_AC_1.getECA());
//		s_AC_1.setECA("2");
//		System.out.println(s_AC_1.getECA());
//		
//		System.out.println("Testing Location");
//		System.out.println(s_AC_1.getLocation());
//		s_AC_1.setLocation("Kowloon Tong");
//		System.out.println(s_AC_1.getLocation());
//		
//		System.out.println("Testing Academic GPA");
//		ScoreComponent s_AC_2 = new ScoreComponent("GPA", "4.3", "2", "300", "Kowloon Tong");
//		s_AC_2.setAcademic("2");
//		System.out.println(s_AC_2.getAcademic());
//		System.out.println("Test Weighting");
//		WeightComponent wc1 = new WeightComponent(0, 20, 100, 90);
//		int[] arr = wc1.getWeightings();
//		for (int i : arr) {
//			System.out.println(i);
//		}
//		System.out.println("Test Update Weighting");
//		wc1.setWeightings(110, 220, 90, 100);
//		int[] arr2 = wc1.getWeightings();
//		for (int i : arr2) {
//			System.out.println(i);
//		}		
//		System.out.println("> Hall");
//		HallSystem hS = HallSystem.getInstance();
//		hS.viewHallList();
//		
//		System.out.println("> Application");
//		Student std1 = new Student("001", "Jennifer", "s001", false, 4);
//		hS.createApplication(std1, 1, new ScoreComponent("GPA", "4.2", "2", "300", "Cheung Chau"));
//		
//		Student std2 = new Student("002", "Elston", "s002", false, 2);
//		hS.createApplication(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
//		
//		Student std3 = new Student("003", "Wilson", "s003", true, 2);
//		hS.createApplication(std3, 1, new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau"));
//		
//		Student std4 = new Student("004", "Chung", "s004", true, 2);
//		hS.createApplication(std4, 3, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
//		
//		Student std5 = new Student("005", "Jacky", "s005", false, 2);
//		hS.createApplication(std5, 1, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
//		
//		Student std6 = new Student("006", "Alex", "s006", false, 2);
//		hS.createApplication(std6, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
//		
//		hS.viewAllApplication();
//		
//		System.out.println("> Process");
//		hS.processApplication();
//		
//		System.out.println("> Result");
//		hS.viewResult();

		HallSystem hS = HallSystem.getInstance();
		Display.createScanner();
		while(true) {
			hS.runSystem();
			
			String cmdString = Display.runDisplay("If you want to change Account", "Y/N", true);

			if(cmdString.equals("N")) {
				break;
			}
		}
		Display.closeScanner();
	}

	
}

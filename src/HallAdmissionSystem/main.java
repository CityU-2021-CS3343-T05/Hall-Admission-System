package HallAdmissionSystem;

public class main {
	public static void main(String[] args) {
//		LoginPortal loginPortal = LoginPortal.getInstance();
//		Account ac=loginPortal.login();
//		if(ac!=null)
//			if(ac instanceof Student)
//				System.out.println(((Student)ac).getSid());
//			else if(ac instanceof CityU)
//				System.out.println(((CityU)ac).getUserName());
		
		//Test add score
		System.out.println("Testing Academic DSE");
		ScoreComponent s_AC_1 = new ScoreComponent("DSE", "5*", "5", "180", null);
		System.out.println(s_AC_1.getAcademic());
		s_AC_1.setAcademic("5**");
		System.out.println(s_AC_1.getAcademic());
		
		System.out.println("Testing Leader");
		System.out.println(s_AC_1.getLeaderShip());
		s_AC_1.setLeaderShip("2");
		System.out.println(s_AC_1.getLeaderShip());
		
		System.out.println("Testing ECA");
		System.out.println(s_AC_1.getECA());
		s_AC_1.setECA("2");
		System.out.println(s_AC_1.getECA());
		
		
		
		System.out.println("Testing Academic GPA");
		ScoreComponent s_AC_2 = new ScoreComponent("GPA", "4.3", "2", "300", null);
		System.out.println(s_AC_2.getAcademic());
		s_AC_2.setAcademic("2");
		System.out.println(s_AC_2.getAcademic());
		
	}
}

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
		System.out.println("Testing Academic");
		ScoreComponent s_AC = new ScoreComponent("DSE", "5*", null, null, null);
		System.out.println(s_AC.getAcademic());
		s_AC.setAcademic("5**");
		System.out.println(s_AC.getAcademic());
	}
}

package HallAdmissionSystem;

public class main {
	public static void main(String[] args) {
		LoginPortal loginPortal = LoginPortal.getInstance();
		Account ac=loginPortal.login();
		if(ac!=null)
			if(ac instanceof Student)
				System.out.println(((Student)ac).getSid());
			else if(ac instanceof CityU)
				System.out.println(((CityU)ac).getUserName());
	}
}

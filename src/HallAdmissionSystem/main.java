package HallAdmissionSystem;

public class main {
	public static void main(String[] args) {
		LoginPortal loginPortal = LoginPortal.getInstance();
		Account ac=loginPortal.login();
		if(ac==null)
			System.out.println("Wrong Password");
		else
			System.out.println(ac.getUserName());
	}
}

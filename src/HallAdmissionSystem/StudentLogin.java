package HallAdmissionSystem;

public class StudentLogin {
	public static void login() throws Exception {
		Display.createScanner();
		LoginPortal lp = LoginPortal.getInstance();
		Account s = lp.login();
		s.mainManual();
	}
}

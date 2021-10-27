package HallAdmissionSystem;

public class CityU implements Account {

	private String userName;
	private String userPwd;

	
	public CityU(String userName,String userPwd) {
		this.userName=userName;
		this.userPwd=userPwd;
	}
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void processApplication() {
		// TODO - implement CityU.processApplication
		throw new UnsupportedOperationException();
	}

	public void viewApplication() {
		// TODO - implement CityU.viewApplication
		throw new UnsupportedOperationException();
	}

}
package HallAdmissionSystem;

public class CityU implements Account {

	private String userName;
	private String userPwd;

	public String getUserName() {
		return this.userName;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	/**
	 * 
	 * @param userPwd
	 */
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
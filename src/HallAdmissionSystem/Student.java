package HallAdmissionSystem;

public class Student implements Account {

	private String userName;
	private String userPwd;
	private String sid;
	private String nation;
	private int year;

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

	public void createApplication() {
		// TODO - implement Student.createApplication
		throw new UnsupportedOperationException();
	}

	public void viewApplication() {
		// TODO - implement Student.viewApplication
		throw new UnsupportedOperationException();
	}

	public String getSid() {
		return this.sid;
	}

	/**
	 * 
	 * @param sid
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getNation() {
		return this.nation;
	}

	/**
	 * 
	 * @param nation
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	public int getYear() {
		return this.year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

}
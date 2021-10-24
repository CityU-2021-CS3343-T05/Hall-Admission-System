package HallAdmissionSystem;

public class Student implements Account {

	private String userName;
	private String userPwd;
	private String sid;
	private boolean isLocal;
	private int year;

	public Student(String sid,int year,boolean isLocal,String userNmae,String userPwd) {
		this.setSid(sid);
		this.setYear(year);
		this.setIsLocal(isLocal);
		this.setUserName(userNmae);
		this.setUserPwd(userPwd);
	}
	
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

	public boolean getIsLocal() {
		return this.isLocal;
	}

	/**
	 * 
	 * @param isLocal
	 */
	public void setIsLocal(boolean isLocal) {
		this.isLocal = isLocal;
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
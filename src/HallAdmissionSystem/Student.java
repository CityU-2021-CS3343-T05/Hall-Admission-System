package HallAdmissionSystem;

public class Student implements Account {

	private String sid;
	private String userName;
	private String userPwd;
	private boolean isLocal;
	private int year;

	public Student(String sid, String userNmae, String userPwd, boolean isLocal, int year) {
		this.sid = sid;
		this.userName = userNmae;
		this.userPwd = userPwd;
		this.year = year;
		this.isLocal = isLocal;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	@Override
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPwd() {
		return this.userPwd;
	}
	
	public String getSid() {
		return this.sid;
	}

	public boolean getIsLocal() {
		return this.isLocal;
	}

	public int getYear() {
		return this.year;
	}

	public void mainManuel() {
		
	}
}
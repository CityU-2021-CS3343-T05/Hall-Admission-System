package HallAdmissionSystem;

public interface Account {

	String getUserName();

	void setUserName(String userName);

	String getUserPwd();

	void setUserPwd(String userPwd);
	
	void mainManual() throws Exception;

}
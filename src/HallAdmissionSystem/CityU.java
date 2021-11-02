package HallAdmissionSystem;

public class CityU implements Account {

	private String userName;
	private String userPwd;

	public CityU(String userName, String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
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
	
	@Override
	public void mainManuel() throws Ex_WrongExamType {
		CityUFunction hS = HallSystem.getInstance();

		boolean login = true;

		while (login) {

			String content = "Welcome, " + this.userName + "\n";
			content += "Select the functions:\n";
			content += "[1] Create Hall\n";
			content += "[2] Change Hall Setting\n";			
			content += "[3] View Hall Listing\n";
			content += "[4] View Applications\n";
			content += "[5] Process Applications\n";
			content += "[6] Change Username\n";
			content += "[7] Change Password\n";
			content += "[8] Logout\n";

			int input = Integer.parseInt(Display.runDisplay("Student Manuel", content, true));

			switch (input) {
			case 1:
				int hName = Integer.parseInt(Display.runDisplayDetails("Hall Name"));
				int numOfAcceptance = Integer.parseInt(Display.runDisplayDetails("Number of Acceptance"));
				int academic = Integer.parseInt(Display.runDisplayDetails("Academic Weighting"));
				int leadership = Integer.parseInt(Display.runDisplayDetails("Leadership Weighting"));
				int eca = Integer.parseInt(Display.runDisplayDetails("ECA Weighting"));
				int location = Integer.parseInt(Display.runDisplayDetails("Location Weighting"));
				
				hS.createNewHall(hName, numOfAcceptance, academic, leadership, eca, location);
				break;
			case 2:
				hName = Integer.parseInt(Display.runDisplayDetails("Hall Name"));
				academic = Integer.parseInt(Display.runDisplayDetails("Academic Weighting"));
				leadership = Integer.parseInt(Display.runDisplayDetails("Leadership Weighting"));
				eca = Integer.parseInt(Display.runDisplayDetails("ECA Weighting"));
				location = Integer.parseInt(Display.runDisplayDetails("Location Weighting"));
				
				hS.changeHallSetting(hName, academic, leadership, eca, location);
				break;
			case 3:
				hS.viewHallList();
				break;
			case 4:
				hS.viewAllApplication();
				break;
			case 5:
				hS.processApplication();
				Display.runTitleLine("Done processing");
				break;
			case 6:
				setUserName(Display.runDisplay("Change Username", "Input the new username:", true));
				break;
			case 7:
				setUserPwd(Display.runDisplay("Change Password", "Input the new password:", true));
				break;
			default:
				login = false;
				break;
			}
		}
	}
}
package HallAdmissionSystem;

public class Administrator implements Account {

	private String userName;
	private String userPwd;

	public Administrator(String userName, String userPwd) {
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
	
	private String getMenuContent() {
		String content = "Welcome, " + this.userName + "\n";
		content += "Select the functions:\n";
		content += "[1] Create Hall\n";
		content += "[2] Change Hall Setting\n";			
		content += "[3] View Hall Listing\n";
		content += "[4] View All Results\n";
		content += "[5] Process Applications\n";
		content += "[6] Change Username\n";
		content += "[7] Change Password\n";
		content += "[8] Logout\n";
		return content;
	}
	
	@Override
	public void mainManual() {
		AdministratorFunction hS = HallSystem.getInstance();

		boolean login = true;

		while (login) {
			String input = Display.runDisplay("Admin Manual", getMenuContent(), true);
			switch (input) {
			case "1":
				int hName = Validation.getNewHallInput();
				int numOfAcceptance = Validation.getIntegerValue("Number of Acceptance");
				int academic = Validation.getIntegerValue("Academic Weighting");
				int leadership = Validation.getIntegerValue("Leadership Weighting");
				int eca = Validation.getIntegerValue("Eca Weighting");
				int location = Validation.getIntegerValue("Location Weighting");
				WeightComponent newWeighting = new WeightComponent(academic, leadership, eca, location);
//				hS.createNewHall(hName, numOfAcceptance, academic, leadership, eca, location);
				hS.createNewHall(hName, numOfAcceptance, newWeighting);
				Display.runDisplayLine("Hall Created");
				break;
			case "2":
				hName = Validation.getHallInput("Hall Number");
//				Integer.parseInt(Display.runDisplayDetails("Hall Name"));
				academic = Validation.getIntegerValue("New Academic Weighting");
//						Integer.parseInt(Display.runDisplayDetails("Academic Weighting"));
				leadership = Validation.getIntegerValue("New Leadership Weighting");
//						Integer.parseInt(Display.runDisplayDetails("Leadership Weighting"));
				eca =  Validation.getIntegerValue("New Eca Weighting");
//				Integer.parseInt(Display.runDisplayDetails("ECA Weighting"));
				location =  Validation.getIntegerValue("New Location Weighting");
//				Integer.parseInt(Display.runDisplayDetails("Location Weighting"));
				numOfAcceptance = Validation.getIntegerValue("New Number of Acceptance");
				newWeighting = new WeightComponent(academic, leadership, eca, location);
				hS.changeHallSetting(hName,numOfAcceptance,newWeighting);
				Display.runDisplayLine("Hall " + hName+" setting changed");
				break;
			case "3":
				hS.viewHallList();
				break;
			case "4":
				hS.viewResult();
				break;
			case "5":
				hS.processApplication();
				Display.runTitleLine("Done processing");
				break;
			case "6":
				setUserName(Display.runDisplay("Change Username", "Input the new username:", true));
				break;
			case "7":
				setUserPwd(Display.runDisplay("Change Password", "Input the new password:", true));
				break;
			case "8":
				login = false;
				break;
			default:
				Display.runDisplayLine("Wrong command, please enter again!");
			}
		}
	}
}
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

	@Override
	public void mainManuel() throws Ex_WrongExamType {
		StudentFunction hS = HallSystem.getInstance();

		boolean login = true;

		while (login) {

			String content = "Welcome, " + this.userName + "\n";
			content += "Select the functions:\n";
			content += "[1] Create Application\n";
			content += "[2] Delate Application\n";
			content += "[3] View Application\n";
			content += "[4] View Hall List\n";
			content += "[5] View Result\n";
			content += "[6] Change Username\n";
			content += "[7] Change Password\n";
			content += "[8] Logout\n";

			int input = Integer.parseInt(Display.runDisplay("Student Manuel", content, true));

			switch (input) {
			case 1:
				int pHall = Integer.parseInt(Display.runDisplayDetails("Preferenced Hall"));

				String academicType = Display.runDisplayDetails("Academic type");
				String academicScore = Display.runDisplayDetails("Academic score");
				String leaderTime = Display.runDisplayDetails("Leardership Times");
				String ecaHr = Display.runDisplayDetails("ECA Hours");
				String location = Display.runDisplayDetails("Lived location");

				ScoreComponent sc = new ScoreComponent(academicType, academicScore, leaderTime, ecaHr, location);

				hS.createApplication(this, pHall, sc);
				break;
			case 2:
				String remove = Display.runDisplayDetails("Are you sure to delate application (y/n)");
				if (remove.equals("y")) {
					hS.delateApplication(this);
					Display.runDisplayLine("Application Delated");
				} else {
					Display.runDisplayLine("Application Not Delated");
				}
				break;
			case 3:
				hS.viewApplication(this);
				break;
			case 4:
				hS.viewHallList();
				break;
			case 5:
				hS.viewSpecificResult(this);
				break;
			case 6:
				setUserName(Display.runDisplay("Change Password", "Input the new password:", true));
				break;
			case 7:
				setUserPwd(Display.runDisplay("Change Password", "Input the new password:", true));
			default:
				login = false;
				break;
			}
		}
	}
}
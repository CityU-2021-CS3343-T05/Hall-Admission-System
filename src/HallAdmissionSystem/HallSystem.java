package HallAdmissionSystem;

import java.util.ArrayList;

public class HallSystem implements CityUFunction, StudentFunction {

	private static HallSystem instance = new HallSystem();
	private ArrayList<Hall> allHall;
	private ArrayList<Application> allApplication;
	private Process process;

	private HallSystem() {
		allHall = new ArrayList<>();
		allApplication = new ArrayList<>();
	}

	public static HallSystem getInstance() {
		return instance;
	}

	@Override
	public void viewApplication() {

	}

	@Override
	public void createApplication(Student std, int perferHall, ScoreComponent score) {
		
	}

	@Override
	public void viewResult() {

	}

	@Override
	public void processApplication() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewHallList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hall getHall(int targetHall) {
		// TODO Auto-generated method stub
		return null;
	}
}
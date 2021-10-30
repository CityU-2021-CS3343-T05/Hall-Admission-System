package HallAdmissionSystem;

import java.util.ArrayList;

public class HallSystem implements CityUFunction, StudentFunction {

	private static HallSystem instance = new HallSystem();
	private ArrayList<Hall> allHallListing;
	private ArrayList<Application> allApplication;
	private Process processResult;

	private HallSystem() {
		allHallListing = new ArrayList<>();
		allApplication = new ArrayList<>();

		allHallListing.add(new Hall(1, 2, new WeightComponent(1, 1, 1, 1)));
		allHallListing.add(new Hall(2, 2, new WeightComponent(0, 0, 0, 0)));
		allHallListing.add(new Hall(3, 2, new WeightComponent(0, 0, 0, 0)));
	}

	public static HallSystem getInstance() {
		return instance;
	}

	@Override
	public void viewAllApplication() {
		System.out.println("========================= Application ========================");

		for (Application application : allApplication) {
			System.out.println(application);
		}
	}

	@Override
	public void createApplication(Student std, int perferHall, ScoreComponent score) {
		allApplication.add(new Application(std, perferHall, score));
	}

	@Override
	public void viewResult() {
		System.out.println("=========================== Result ===========================");
		processResult.showProcessDetailedResult();
	}

	@Override
	public void processApplication() {
		processResult = new Process(allApplication);
		processResult.runProcess();
	}

	@Override
	public void viewHallList() {
		for (Hall hall : allHallListing) {
			System.out.println(hall);
		}
	}

	@Override
	public Hall getHall(int targetHall) {
		for (Hall hall : allHallListing) {
			if (hall.getHallNumber() == targetHall) {
				return hall;
			}
		}
		return null;
	}
	
	private Application getApplication(Student targetStd) {
		for (Application app : allApplication) {
			if (app.getSid() == targetStd.getSid()) {
				return app;
			}
		}
		return null;
	}

	public ArrayList<Hall> getHallList() {
		return allHallListing;
	}

	@Override
	public void changeHallSetting(Hall hall, int newAcademicWeight, int newLeaderShipWeight, int newEcaWeight,
			int newLocationWeight) {
		hall.setNewHallWeightings(newAcademicWeight, newLeaderShipWeight, newEcaWeight, newLocationWeight);
	}

	@Override
	public void createNewHall(int hallNum, int capacity, int academicWeight, int leaderShipWeight, int ecaWeight,
			int locationWeight) {
		new Hall(hallNum, capacity, new WeightComponent(academicWeight, leaderShipWeight, ecaWeight, locationWeight));
	}

	@Override
	public void viewApplication(Student std) {
		System.out.println(getApplication(std));
	}

	@Override
	public void delateApplication(Student std) {
		Application removeApplication = getApplication(std);
		this.allApplication.remove(removeApplication);	
	}
	
	//To Be done
	public void runSystem() {
		LoginPortal portal = LoginPortal.getInstance();
		Account loginPersonAccount;
	}
}
package HallAdmissionSystem;

import java.util.ArrayList;

public class HallSystem implements CityUFunction, StudentFunction {

	private static HallSystem instance = new HallSystem();
	private ArrayList<Hall> allHallListing;
	private ArrayList<Application> allApplication;
	private StartProcessing processResult;

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
		String out = "";
		
		for (Application application : allApplication) {
			out += application;
		}
		
		Display.runDisplay("Application", out, false);
	}

	@Override
	public void createApplication(Student std, int perferHall, ScoreComponent score) {
		allApplication.add(new Application(std, perferHall, score));
	}

	@Override
	public void viewResult() {
		String content = processResult.processDetailedResultList();
		
		Display.runDisplay("All Result", content, false);
	}
	
	@Override
	public void viewSpecificResult(Student std) {
		Display.runDisplay("Specifici Result", processResult.FindDetailedResult(std), false);
	}

	@Override
	public void processApplication() {
		processResult = new StartProcessing(allApplication);
		processResult.runProcess();
	}

	@Override
	public void viewHallList() {
		String out = "";
		for (Hall hall : allHallListing) {
			out += hall;
		}
		
		Display.runDisplay("Hall Listing", out, false);
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
	public void changeHallSetting(int hall, int newAcademicWeight, int newLeaderShipWeight, int newEcaWeight,
			int newLocationWeight) {
		Hall h = getHall(hall);
		h.setNewHallWeightings(newAcademicWeight, newLeaderShipWeight, newEcaWeight, newLocationWeight);
	}

	@Override
	public void createNewHall(int hallNum, int capacity, int academicWeight, int leaderShipWeight, int ecaWeight,
			int locationWeight) {
		new Hall(hallNum, capacity, new WeightComponent(academicWeight, leaderShipWeight, ecaWeight, locationWeight));
	}

	@Override
	public void viewApplication(Student std) {
		Display.runDisplay("View Application", getApplication(std).toString(), false);
	}

	@Override
	public void delateApplication(Student std) {
		Application removeApplication = getApplication(std);
		this.allApplication.remove(removeApplication);	
	}
	
	public void runSystem() {

	}
}
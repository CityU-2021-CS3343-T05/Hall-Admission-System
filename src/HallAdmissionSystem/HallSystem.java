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
		
		processResult = new Process();
		
		allHallListing.add(new Hall(1, 50, new WeightComponent(0, 0, 0, 0)));
		allHallListing.add(new Hall(2, 100, new WeightComponent(0, 0, 0, 0)));
		allHallListing.add(new Hall(3, 80, new WeightComponent(0, 0, 0, 0)));
	}

	public static HallSystem getInstance() {
		return instance;
	}

	@Override
	public void viewApplication() {
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
		
	}

	@Override
	public void processApplication() {
		
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
			if(hall.getHallNumber()==targetHall) {
				return hall;
			}
		}
		return null;
	}

	@Override
	public void changeHallSetting(Hall hall, int newAcademicWeight, int newLeaderShipWeight, int newEcaWeight, int newLocationWeight) {
		hall.setNewHallWeightings(newAcademicWeight, newLeaderShipWeight, newEcaWeight, newLocationWeight);
	}

	@Override
	public void createNewwHall(int hallNum, int capacity, int academicWeight, int leaderShipWeight, int ecaWeight, int locationWeight) {
		new Hall(hallNum, capacity, new WeightComponent(academicWeight, leaderShipWeight, ecaWeight, locationWeight));
	}
}
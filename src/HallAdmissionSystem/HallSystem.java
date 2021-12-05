package HallAdmissionSystem;

import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.text.AbstractDocument.Content;

public class HallSystem implements AdministratorFunction, StudentFunction {

	private static HallSystem instance = new HallSystem();
	private ArrayList<Hall> allHallListing;
	private ArrayList<Application> allApplication;
	private ProcessApplication processApplication = null;

	private HallSystem() {
		allHallListing = new ArrayList<>();
		allApplication = new ArrayList<>();
		allHallListing.add(new Hall(1, 2, new WeightComponent(1, 1, 1, 1)));
		allHallListing.add(new Hall(2, 2, new WeightComponent(0, 0, 0, 0)));
		allHallListing.add(new Hall(3, 2, new WeightComponent(0, 0, 0, 0)));
	}

	public static HallSystem getInstance() {
		
		if(instance==null) {
			instance = new HallSystem();
		}
		return instance;
	}
	
	@Override
	public void processApplication() {
		processApplication = new ProcessApplication(this.allHallListing);
		processApplication.runProcess(allApplication);
	}

	@Override
	public void viewAllApplication() {
		String out = "";
		
		for (Application application : allApplication) {
			out += application + "\n";
		}
		
		Display.runDisplay("Application", out, false);
	}

	@Override
	public void createApplication(Student std, int perferHall, ScoreComponent score) {
		for (Application application : allApplication) {
			if (application.getSid() == std.getSid()) {
				return;
			}
		}
		
		allApplication.add(new Application(std, perferHall, score));
	}

	@Override
	public void viewResult() {
		if(processApplication != null){
			String content = processApplication.getFinalResult();
			
			Display.runDisplay("All Result", content, false);
		}
		else {
			String content = "Waiting for processing to finish.";
			Display.runDisplay("All Result",content , false);
		}
	}
	
	public String findApplicationStatus(Application target) {
		if(processApplication == null) {
			return "Watiting to process";
		}
		return "Current Appication Status: " + processApplication.findResultStatus(target);
	}
	
	@Override
	public void viewSpecificResult(Student std) {
		Application application = findApplication(std);
		Display.runDisplay("Detailed Result", findApplicationStatus(application), false);
	}

	@Override
	public void viewHallList() {
		String out = "";
		for (Hall hall : allHallListing) {
			out += hall + " ";
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
	
	private Application findApplication(Student targetStd) {
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
	public void changeHallSetting(int hall,int newCapacity, WeightComponent newWeightComponent) {
		Hall h = getHall(hall);
		h.setNumberofAcceptance(newCapacity);
		h.setNewHallWeightings(null);
	}

	@Override
	public void createNewHall(int hallNum, int capacity, WeightComponent weightComponent) {
		allHallListing.add(new Hall(hallNum, capacity, weightComponent));
	}

	@Override
	public void viewApplication(Student std) {
		Application application = findApplication(std);
		if(application != null) {
			Display.runDisplay("View Application", findApplication(std).toString(), false);
		}
		else {
			System.out.println("");
		}
		
	}

	@Override
	public void deleteApplication(Student std) {
		Application removeApplication = findApplication(std);
		this.allApplication.remove(removeApplication);	
	}
	
	public void runSystem() throws Exception {
		LoginPortal lP = LoginPortal.getInstance();
		
		Account loginAc = lP.login();
		
		while (loginAc != null) {
			loginAc.mainManual();
			
			loginAc = null;
		}
	}
}
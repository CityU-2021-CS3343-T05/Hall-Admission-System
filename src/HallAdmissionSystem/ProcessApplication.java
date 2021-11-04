package HallAdmissionSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class ProcessApplication {
	private ArrayList<ProcessInformation> allInformation;
	private ArrayList<ProcessResult> allResults;
	private ArrayList<Application> rawApplications;

			
	public ProcessApplication(ArrayList<Hall> hallList) {
		allInformation = new ArrayList<>();
		allResults = new ArrayList<>();
	}

	
	public void initializeEnvironment(ArrayList<Application> allApplications) {
		rawApplications = allApplications;
		
		HallSystem hS = HallSystem.getInstance();
		
		ArrayList<Hall> hallList = hS.getHallList();
		
		for (Hall hall : hallList) {
			allInformation.add(new ProcessInformation(hall));
			allResults.add(new ProcessResult(hall));
		}
	}
	
	private ProcessInformation findProcessInformation(Hall h) {
		for (ProcessInformation processInformation : allInformation) {
			if(processInformation.getHall().equals(h)) {
				return processInformation;
			}
		}
		
		return null;
	}
	
	public void runSorting() {
		for (Application app : rawApplications) {
			ProcessInformation pI = findProcessInformation(app.getPerferenceHall());
			pI.importApplication(app);
		}
	}
}

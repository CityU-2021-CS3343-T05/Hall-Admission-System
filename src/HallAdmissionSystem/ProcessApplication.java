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
	
	private ProcessResult findProcessResult(Hall h) {
		for (ProcessResult processResult : allResults) {
			if(processResult.getHall().equals(h)) {
				return processResult;
			}
		}
		return null;
	}
	
	public void runSorting() {
		for (Application app : rawApplications) {
			calculateApplicationScore(app);
			ProcessInformation pI = findProcessInformation(app.getPerferenceHall());
			pI.importApplication(app);
		}
	}
	
//	IN REFACTORING TRANSFER TO APPLICATION CLASS
	private void calculateApplicationScore(Application application) {
		System.out.println(application);
		int[] detailScore = application.getDetailScore();
		Hall preferencedHall = application.getPerferenceHall();

		int[] detailWeighting = preferencedHall.getHallWeightings();
		int sum = 0;

		for (int i = 0; i < detailWeighting.length; i++) {
			sum += detailWeighting[i] * detailScore[i];
		}

		application.setTotalScore(sum);
	}
	
	public void admitApplication() {
		for (ProcessInformation processInformation : allInformation) {
			
			Hall admitingHall = processInformation.getHall();
			ProcessResult procesingResult = findProcessResult(admitingHall);
			
			Application pendingApplication = processInformation.topNonLocalApplication();
			
			while (pendingApplication != null) {
				procesingResult.admitApplication(pendingApplication);
				pendingApplication = processInformation.topNonLocalApplication();
			}
			
			//WaitingList
			
			
			//Local
			
			pendingApplication = processInformation.topLocalApplicant();
			
			while (pendingApplication != null) {
				procesingResult.admitApplication(pendingApplication);
				pendingApplication = processInformation.topLocalApplicant();
			}
		}
	}
}

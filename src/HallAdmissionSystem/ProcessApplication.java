package HallAdmissionSystem;

import java.util.ArrayList;

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
			if (processInformation.getHall().equals(h)) {
				return processInformation;
			}
		}
		return null;
	}

	private ProcessResult findProcessResult(Hall h) {
		for (ProcessResult processResult : allResults) {
			if (processResult.getHall().equals(h)) {
				return processResult;
			}
		}
		return null;
	}

	public void startSorting() {
		for (Application app : rawApplications) {
			calculateApplicationScore(app);
			ProcessInformation pI = findProcessInformation(app.getPerferenceHall());
			pI.importApplication(app);
		}
	}

//	IN REFACTORING TRANSFER TO APPLICATION CLASS
	private void calculateApplicationScore(Application application) {
		
		int[] detailScore = application.getDetailScore();
		Hall preferencedHall = application.getPerferenceHall();

		int[] detailWeighting = preferencedHall.getHallWeightings();
		int sum = 0;

		for (int i = 0; i < detailWeighting.length; i++) {
			sum += detailWeighting[i] * detailScore[i];
		}

		application.setTotalScore(sum);
		System.out.println(application);
	}

	private ProcessResult findMoreEmptyHall() {
		ProcessResult minRes = allResults.get(0);
		int minCapacity;

		if (minRes == null) {
			return null;
		} else {
			minCapacity = minRes.getOccupied();
		}

		for (ProcessResult processResult : allResults) {
			if (minCapacity > processResult.getOccupied()) {
				minRes = processResult;
				minCapacity = minRes.getOccupied();
			}
		}

		return minRes;
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

			// WaitingList
			pendingApplication = procesingResult.topWaitingApplication();
			while (pendingApplication != null) {
				ProcessResult moreEmptyHall = findMoreEmptyHall();
				moreEmptyHall.admitApplication(pendingApplication);

				pendingApplication = procesingResult.topWaitingApplication();
			}

			// Local

			pendingApplication = processInformation.topLocalApplicant();

			while (pendingApplication != null) {
				procesingResult.admitApplication(pendingApplication);
				pendingApplication = processInformation.topLocalApplicant();
			}
		}
	}

	public void runProcess(ArrayList<Application> raw) {
		initializeEnvironment(raw);

		startSorting();

		admitApplication();
	}

	public String getFinalResult() {

		String out = "";

		for (ProcessResult res : allResults) {
			out += res;
		}

		out += "\n";

		out += ProcessResult.getWaitingListing();

		out += "\n";

		out += ProcessResult.getRejectListing();

		return out;
	}

	public String findResultStatus(Application target) {
		
		String outData = null;
		
		for (ProcessResult processResult : allResults) {
			outData = processResult.findInAdmit(target);
		}
		
		if(outData == null) {
			outData = ProcessResult.findInWaiting(target);
		}
		
		if(outData == null) {
			outData = ProcessResult.findInReject(target);
		}
		
		return outData;
	}
}

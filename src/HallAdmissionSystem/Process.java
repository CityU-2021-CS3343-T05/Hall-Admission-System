package HallAdmissionSystem;

import java.util.*;

public class Process {

	private ArrayList<ProcessData> allProcessData;
	private ArrayList<Result> allResult;
	ArrayList<Application> allApplication;

	public Process(ArrayList<Application> allApplication) {
		this.allApplication = allApplication;
		this.allProcessData = new ArrayList<>();
		this.allResult = new ArrayList<>();
	}

	private void setupQueue() {
		HallSystem hS = HallSystem.getInstance();
		ArrayList<Hall> hallList = hS.getHallList();

		for (Hall hall : hallList) {
			allProcessData.add(new ProcessData(hall, true));
			allProcessData.add(new ProcessData(hall, false));
		}
		
		for (Hall hall : hallList) {
			allResult.add(new Result(hall));
		}
	}

	private ProcessData findOutput(Hall hall, boolean isLocal) {
		for (ProcessData res : allProcessData) {
			if (res.getHall().equals(hall)) {
				if (res.getIsLocal() == isLocal) {
					return res;
				}
			}
		}
		return null;
	}

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

	private void importApplication() {
		for (Application application : allApplication) {
			calculateApplicationScore(application);
			ProcessData inputTo = findOutput(application.getPerferenceHall(), application.getIsLocal());
			inputTo.addToList(application);
		}
	}

	private void handleAdmission(ProcessData res, boolean isLocal) {
		int i = 0;
		while (i < res.getHall().getNumberofAcceptance()) {
			Application application = res.getTopAppliant();
			if (application == null) {
				break;
			}

			if (isLocal) {
				res.addToAdmission(application);
				i++;
			} else {
				if (application.getYear() > 3) {
					ProcessData.addToReject(application);
				} else {
					res.addToAdmission(application);
					i++;
				}
			}
		}
	}

	private void handleWaiting(ProcessData res, boolean isLocal) {

		if (!isLocal) {
			Application waitApplication = res.getTopAppliant();
			while (waitApplication != null) {
				ProcessData.addToWaiting(waitApplication);
				waitApplication = res.getTopAppliant();
			}
		}
	}

	private void sortApplication() {

		int numberOfList = allProcessData.size();

		for (ProcessData res : allProcessData) {
			boolean isLocal = res.getIsLocal();

			if (!isLocal) {
				handleAdmission(res, isLocal);

				handleWaiting(res, isLocal);
			}

		}

	}

	public void showProcessResult() {
		for (ProcessData res : allProcessData) {
			System.out.println(res);
		}
		System.out.println(ProcessData.getWaitingListing());
	}

	public void runProcess() {
		setupQueue();
		importApplication();
		sortApplication();
	}

}
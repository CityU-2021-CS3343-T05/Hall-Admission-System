package HallAdmissionSystem;

import java.util.*;

public class Process {

	private ArrayList<Result> allOutput;
	ArrayList<Application> allApplication;

	public Process(ArrayList<Application> allApplication) {
		this.allApplication = allApplication;
		this.allOutput = new ArrayList<>();
	}

	private void setupQueue() {
		HallSystem hS = HallSystem.getInstance();
		ArrayList<Hall> hallList = hS.getHallList();

		for (Hall hall : hallList) {
			allOutput.add(new Result(hall, true));
			allOutput.add(new Result(hall, false));
		}
	}

	private Result findOutput(Hall hall, boolean isLocal) {
		for (Result res : allOutput) {
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
//		System.out.println(preferencedHall);
		int[] detailWeighting = preferencedHall.getHallWeightings();
		int sum = 0;

		for (int i = 0; i < detailWeighting.length; i++) {
			sum += detailWeighting[i] * detailScore[i];
		}
		System.out.println(">" + sum);
		application.setTotalScore(sum);
	}

	private void importApplication() {
		for (Application application : allApplication) {
			calculateApplicationScore(application);
			Result inputTo = findOutput(application.getPerferenceHall(), application.getIsLocal());
			inputTo.addToList(application);
		}
	}

	private void handleAdmission(Result res, boolean isLocal) {
		int i = 0;
		while ( i < res.getHall().getNumberofAcceptance()) {
			Application application = res.getTopAppliant();
			if (application == null) {
				break;
			}

			if (isLocal) {
				res.addToAdmission(application);
				i++;
			} else {			
				if (application.getYear() > 3) {
//					System.out.println("===================???" + application);
					//Line 76 run many time for random reason
					Result.addToWaiting(application);
				} else {
					res.addToAdmission(application);
					i++;
				}
			}
		}
	}

	private void handleWaiting(Result res, boolean isLocal) {

		if (!isLocal) {
			Application waitApplication = res.getTopAppliant();
			while (waitApplication != null) {
				Result.addToWaiting(waitApplication);
				waitApplication = res.getTopAppliant();
			}
		}
	}

	private void sortApplication() {
		for (Result res : allOutput) {
			boolean isLocal = res.getIsLocal();

			System.out.println(res.getHall() + "\t" + res.getIsLocal());

			handleAdmission(res, isLocal);

			handleWaiting(res, isLocal);
		}
	}

	public void showProcessResult() {
		for (Result res : allOutput) {
			System.out.println(res);
		}
		System.out.println(Result.getWaitingListing());
	}

	public void runProcess() {
		setupQueue();
		importApplication();
		sortApplication();
	}

}
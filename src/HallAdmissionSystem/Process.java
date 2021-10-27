package HallAdmissionSystem;

import java.util.*;

public class Process {

	private ArrayList<Result> allOutput;
	ArrayList<Application> allApplication;

	public Process(ArrayList<Application> allApplication) {
		this.allApplication = allApplication;
	}

	private void setupQueue() {
		HallSystem hS = HallSystem.getInstance();
		ArrayList<Hall> hallList = hS.getHallList();

		for (Hall hall : hallList) {
			allOutput.add(new Result(hall));
		}
	}
	
	private Result findOutput(Hall hall) {
		for (Result res : allOutput) {
			if(res.getHall().equals(hall)) {
				return res;
			}
		}
		return null;
	}

	private void calculateApplicationScore(Application application) {
		int[] detailScore = application.getDetailScore();
		Hall preferencedHall = application.getPerferenceHall();
		int[] detailWeighting = preferencedHall.getHallWeightings();

		int sum = 0;

		for (int i = 0; i < detailWeighting.length; i++) {
			sum += detailWeighting[i] * detailScore[i];
		}

		application.setTotalScore(sum);
	}

	private void sortApplication() {
		for (Application application : allApplication) {
			calculateApplicationScore(application);
			Result inputTo = findOutput(application.getPerferenceHall());
			inputTo.addToQueue(application);
		}
	}

	private void runNonLocalProcess() {
		// TODO - implement Process.runNonLocalProcess
		throw new UnsupportedOperationException();
	}

	private void runNonLocalWaitingProcess() {
		// TODO - implement Process.runNonLocalWaitingProcess
		throw new UnsupportedOperationException();
	}

	private void runLocalProcess() {
		// TODO - implement Process.runLocalProcess
		throw new UnsupportedOperationException();
	}
	
	private void testResult() {
		for (Result res : allOutput) {
			System.out.println(res);
		}
	}

	public void runProcess() {
		setupQueue();
		sortApplication();
		testResult();
	}

}
package HallAdmissionSystem;

import java.util.*;

public class Result {

	private Hall hall;
	private boolean isLocal;
	private static PriorityQueue<Application> waitingList = new PriorityQueue<>(new ApplicationDateCompare());
	private ArrayList<Application> admissionList;
	private PriorityQueue<Application> fullList;

	public Result(Hall hall, boolean isLocal) {
		this.hall = hall;
		this.isLocal = isLocal;
		admissionList = new ArrayList<>();
		fullList = new PriorityQueue<>();
	}

	public Hall getHall() {
		return hall;
	}
	
	public boolean getIsLocal() {
		return isLocal;
	}

	public void addToList(Application app) {
		fullList.add(app);
	}

	public Application getTopAppliant() {
		return fullList.poll();
	}

	public void addToAdmission(Application app) {
		admissionList.add(app);
	}

	public static void addToWaiting(Application app) {
		waitingList.add(app);
	}

	public static PriorityQueue<Application> getWaitingList() {
		return waitingList;
	}

	public ArrayList<Application> getAdmissionList() {
		return admissionList;
	}

	@Override
	public String toString() {
		String output = "";

		for (Application application : fullList) {
			output += this.hall + "\t full \t" + application + "\n";
		}

		for (Application application : admissionList) {
			output += this.hall + "\t admissionList \t" + application + "\n";
		}

		for (Application application : waitingList) {
			output += this.hall + "\t waitingList \t" + application + "\n";
		}
		return output;
	}

//	@Override
//	public boolean equals(Object target) {
//		if (target == this) {
//			return true;
//		}
//		if (target == null || target.getClass() != this.getClass()) {
//			return false;
//		}
//
//		Result resultTarget = (Result) target;
//
//		if (this.hall.equals(resultTarget.getHall()) && this.isLocal == resultTarget.isLocal) {
//			return true;
//		} else {
//			return false;
//		}
//	}
}

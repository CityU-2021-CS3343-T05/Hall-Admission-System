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
		String output = hall + "\t" + isLocal + "\n";

		for (Application application : fullList) {
			output += "full        \t" + this.hall + "\t" + application + "\n";
		}

		for (Application application : admissionList) {
			output += "addmission  \t" + this.hall + "\t" + application + "\n";
		}

		return output;
	}

	public static String getWaitingListing() {
		String output = "Waiting List\n";
		for (Application application : waitingList) {
			output += application + "\n";
		}
		return output;
	}
}

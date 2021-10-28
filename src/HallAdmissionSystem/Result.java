package HallAdmissionSystem;

import java.util.*;

public class Result {

	private Hall hall;
	private static PriorityQueue<Application> waitingList;
	private ArrayList<Application> admissionList;
	private PriorityQueue<Application> fullList;

	public Result(Hall hall) {
		this.hall = hall;
		admissionList = new ArrayList<>();
		fullList = new PriorityQueue<>();
	}

	public Hall getHall() {
		return hall;
	}

	public void addToList(Application app) {
		fullList.add(app);
	}

	public PriorityQueue<Application> getWaitingList() {
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
}

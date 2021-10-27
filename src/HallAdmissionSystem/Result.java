package HallAdmissionSystem;

import java.util.*;

public class Result {

	private Hall hall;
	private ArrayList<Application> waitingList;
	private ArrayList<Application> admissionList;
	private PriorityQueue<Application> fullQueue;

	public Result(Hall hall) {
		this.hall = hall;
		fullQueue = new PriorityQueue<>();
	}
	
	public Hall getHall() {
		return hall;
	}
	
	public void addToQueue(Application app) {
		fullQueue.add(app);
	}

	public ArrayList<Application> getWaitingList() {
		return waitingList;
	}
	
	public ArrayList<Application> getAdmissionList() {
		return admissionList;
	}
}

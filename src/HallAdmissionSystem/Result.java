package HallAdmissionSystem;

import java.util.ArrayList;

public class Result {

	private Hall hall;
	private ArrayList<Application> waitingList;
	private ArrayList<Application> admissionList;

	public Result(Hall hall, ArrayList<Application> recWaitingList, ArrayList<Application> recAdmissionList) {
		this.hall = hall;
		waitingList = recWaitingList;
		admissionList = recAdmissionList;
	}
	
	public Hall getHall() {
		return hall;
	}

	public ArrayList<Application> getWaitingList() {
		return waitingList;
	}
	
	public ArrayList<Application> getAdmissionList() {
		return admissionList;
	}
}

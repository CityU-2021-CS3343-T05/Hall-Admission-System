package HallAdmissionSystem;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ProcessResult {
	private Hall hall;
	private ArrayList<Application> admittedList;
	private int capacity;
	private static ArrayList<Application> rejectedList = new ArrayList<>();
	private static PriorityQueue<Application> waitingList = new PriorityQueue<>(new ApplicationDateCompare());
	
	public ProcessResult(Hall hall) {
		this.hall = hall;
		this.capacity = hall.getNumberofAcceptance();
		admittedList = new ArrayList<>();
	}
	
	public void admitApplication(Application app) {
		if(app.getIsLocal()) {
			//Local
			if(admittedList.size()<capacity) {
				admittedList.add(app);
			}else {
				rejectedList.add(app);
			}
		}else {
			//Non Local
			if(app.getYear()<=3) {
				if(admittedList.size()<capacity) {
					admittedList.add(app);
				}else {
					waitingList.add(app);
				}
			}else {
				rejectedList.add(app);
			}
		}
	}
	
	public Application topWaitingApplication() {
		return waitingList.poll();
	}

	public Hall getHall() {
		return this.hall;
	}
	
	public int getOccupied() {
		return admittedList.size();
	}
	
	public static String getWaitingListing() {
		String out = "";
		
		if(waitingList.size() == 0) {
			return "Waiting List is empty \n";
		}
		
		for (Application application : waitingList) {
			out += "Waiting List    " + application + "\n";
		}
		
		return out;
	}
	
	public static String getRejectListing() {
		String out = "";
		
		if(rejectedList.size() == 0) {
			return "Reject List is empty \n";
		}
		
		for (Application application : rejectedList) {
			out += "Reject List     " + application + "\n";
		}
		
		return out;
	}
	
	@Override
	public String toString() {
		String out = "";
		out += this.hall + "\n";
		
		for (Application application : admittedList) {
			out += "Admitted        " + application + "\n";
		}
		
		return out;
	}
}

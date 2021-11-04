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
			if(admittedList.size()<capacity) {
				admittedList.add(app);
			}else {
				rejectedList.add(app);
			}
		}else {
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
	
}

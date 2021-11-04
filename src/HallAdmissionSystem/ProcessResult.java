package HallAdmissionSystem;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ProcessResult {
	private Hall hall;
	private ArrayList<Application> admittedList;
	private int capacity;
	private static ArrayList<Application> rejectedList = new ArrayList();
	private static PriorityQueue<Application> waitingList = new PriorityQueue<>(new ApplicationDateCompare());
	
	public ProcessResult(Hall hall) {
		this.hall = hall;
		this.capacity = hall.getNumberofAcceptance();
		admittedList = new ArrayList<>();
	}
	
	
	
	
	

}

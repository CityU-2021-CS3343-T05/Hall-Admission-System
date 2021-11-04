package HallAdmissionSystem;

import java.util.PriorityQueue;

public class ProcessInformation {
	
	private Hall hall;
	private PriorityQueue<Application> nonLocalApplications;
	private PriorityQueue<Application> localApplications;
	
	public ProcessInformation(Hall hall) {
		this.hall = hall;
		nonLocalApplications = new PriorityQueue<>();
		localApplications = new PriorityQueue<>();
	}

	public Hall getHall() {
		return hall;
	}

	public void importApplication(Application app) {
		if(app.getIsLocal()) {
			localApplications.add(app);
		}else {
			nonLocalApplications.add(app);
		}
	}
	
	
	
	
}

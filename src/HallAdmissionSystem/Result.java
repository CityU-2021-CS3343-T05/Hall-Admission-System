package HallAdmissionSystem;

import java.util.*;

public class Result {
	private Hall hall;
	private ArrayList<Application> admissionList;
	
	public Result(Hall hall) {
		this.hall = hall;
		
		admissionList = new ArrayList<>();
	}
	
	public Hall getHall() {
		return this.hall;
	}
	
	public Application addToAdmission(Application app) {
		
		try {
			admissionList.add(app);
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			return app;
		}
	}
	
	public ArrayList<Application> getAdmissionList() {
		return admissionList;
	}
	
	@Override
	public String toString() {
		String output = hall + "\n";

		for (Application application : admissionList) {
			output += "addmission  \t" + this.hall + "\t" + application + "\n";
		}

		return output;
	}

	
	
}

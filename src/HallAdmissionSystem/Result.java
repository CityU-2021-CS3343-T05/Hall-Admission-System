package HallAdmissionSystem;

import java.util.*;

public class Result {
	private Hall hall;
	private ArrayList<Application> admissionList;
	
	public Result(Hall hall) {
		this.hall = hall;
		
		admissionList = new ArrayList<>();
	}
	
	public void addToAdmission(Application app) {
		admissionList.add(app);
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

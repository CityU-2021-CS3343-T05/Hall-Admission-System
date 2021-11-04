package HallAdmissionSystem;

import java.util.*;

public class Result {

	private Hall hall;
//	private Application[] admissionList;
	private ArrayList<Application> admissionList; 
	private int numberOfPpl;

	public Result(Hall hall) {
		this.hall = hall;
		admissionList = new ArrayList<>();
		this.numberOfPpl = hall.getNumberofAcceptance();
	}

	public Hall getHall() {
		return this.hall;
	}
	
	public int getNumberOfPpl() {
		return numberOfPpl;
	}

	public Application addToAdmission(Application app) {
		
		if(admissionList.size() < numberOfPpl){
			admissionList.add(app);
		}
		else {
			return app;
		}
		return null;
	}

	public ArrayList<Application> getAdmissionList() {
		return admissionList;
	}

	@Override
	public String toString() {
		String output = hall + "\n";
		if (this.numberOfPpl == 0) {
			output += "Empty listing\n";
		} else {
			for (int i = 0; i < admissionList.size(); i++) {
				output += "addmission  \t" + this.hall + "\t" + admissionList.get(i) + "\n";
			}
		}

		return output;
	}

	public String findSpecificResult(Application app) {
		for (int i = 0; i < admissionList.size(); i++) {
			if(admissionList.get(i).equals(app)) {
				return "addmission  \t" + this.hall + "\t" + admissionList.get(i) + "\n";
			}
		}
		return null;
	}
	
}

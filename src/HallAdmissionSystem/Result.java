package HallAdmissionSystem;

import java.util.*;

public class Result {
	private Hall hall;
	private ArrayList<Application> admissionList;
	
	public Result(Hall hall) {
		this.hall = hall;
		System.out.println("++++++++++++++++"+hall.getNumberofAcceptance());
		admissionList = new ArrayList<>(hall.getNumberofAcceptance());
	}
	
	public Hall getHall() {
		return this.hall;
	}
	
	public Application addToAdmission(Application app) {
		
		try {
			admissionList.add(app);
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("!!!!!!!!!!!!!!!");
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

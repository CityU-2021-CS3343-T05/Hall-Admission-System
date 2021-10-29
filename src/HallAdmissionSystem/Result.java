package HallAdmissionSystem;

import java.util.*;

public class Result {
	class FullException extends ArrayIndexOutOfBoundsException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}

	private Hall hall;
	private Application[] admissionList;
	private int numberOfPpl = 0;

	public Result(Hall hall) {
		this.hall = hall;
		admissionList = new Application[this.hall.getNumberofAcceptance()];
	}

	public Hall getHall() {
		return this.hall;
	}

	public Application addToAdmission(Application app) {
		try {
			admissionList[numberOfPpl] = app;
			numberOfPpl++;
			return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			return app;
		}
	}

	public Application[] getAdmissionList() {
		return admissionList;
	}

	@Override
	public String toString() {
		String output = hall + "\n";
		if (this.numberOfPpl == 0) {
			output += "Empty listing\n";
		} else {
			for (int i = 0; i < admissionList.length; i++) {
				output += "addmission  \t" + this.hall + "\t" + admissionList[i] + "\n";
			}
		}

		return output;
	}

}

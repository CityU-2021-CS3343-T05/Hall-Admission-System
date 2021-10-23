package HallAdmissionSystem;

public class Gpa implements Academic {

	private int weighting;

	public int getWeighting() {
		return this.weighting;
	}

	/**
	 * 
	 * @param weighting
	 */
	public void setWeighting(int weighting) {
		this.weighting = weighting;
	}

	/**
	 * 
	 * @param input
	 */
	public int toMarks(int input) {
		// TODO - implement Gpa.toMarks
		throw new UnsupportedOperationException();
	}

}
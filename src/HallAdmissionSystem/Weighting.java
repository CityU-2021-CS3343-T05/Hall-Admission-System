package HallAdmissionSystem;

public interface Weighting {

	int getWeighting();

	/**
	 * 
	 * @param weighting
	 */
	void setWeighting(int weighting);

	/**
	 * 
	 * @param input
	 */
	int toMarks(int input);

}
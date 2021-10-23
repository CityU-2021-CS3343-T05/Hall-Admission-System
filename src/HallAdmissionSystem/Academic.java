package HallAdmissionSystem;

public interface Academic {

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
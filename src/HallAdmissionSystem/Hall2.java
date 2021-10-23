package HallAdmissionSystem;

public class Hall2 implements Hall {

	private Hall2 instance;
	private int hallNumber;
	private int numberofAcceptance;
	private WeightComponents weightingComponents;

	private Hall2() {
		// TODO - implement Hall2.Hall2
		throw new UnsupportedOperationException();
	}

	public Hall2 getInstance() {
		return this.instance;
	}

	public int getHallNumber() {
		return this.hallNumber;
	}

	/**
	 * 
	 * @param hallNumber
	 */
	public void setHallNumber(int hallNumber) {
		this.hallNumber = hallNumber;
	}

	public int getNumberofAcceptance() {
		return this.numberofAcceptance;
	}

	/**
	 * 
	 * @param numberofAcceptance
	 */
	public void setNumberofAcceptance(int numberofAcceptance) {
		this.numberofAcceptance = numberofAcceptance;
	}

	public WeightComponents getWeightingComponents() {
		return this.weightingComponents;
	}

	/**
	 * 
	 * @param weightingComponents
	 */
	public void setWeightingComponents(WeightComponents weightingComponents) {
		this.weightingComponents = weightingComponents;
	}

}
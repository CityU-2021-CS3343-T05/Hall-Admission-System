package HallAdmissionSystem;

public abstract class Hall {

	private int hallNumber;
	private int numberOfAcceptance;
	private WeightComponents weightingComponents;
	
	protected Hall(int hallNumber, int numOfAcceptance, WeightComponents weightComponents) {
		this.hallNumber = hallNumber;
		this.numberOfAcceptance = numOfAcceptance;
		this.weightingComponents = weightComponents;
	}

	public int getHallNumber() {
		return this.hallNumber;
	}

	public WeightComponents getWeightingComponents() {
		return this.weightingComponents;
	}

	public void setWeightingComponents(WeightComponents weightingComponents) {
		this.weightingComponents = weightingComponents;
	}

	public int getNumberofAcceptance() {
		return this.numberOfAcceptance;
	}

	public void setNumberofAcceptance(int numberofAcceptance) {
		this.numberOfAcceptance = numberofAcceptance;
	}

}
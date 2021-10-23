package HallAdmissionSystem;

public class Hall1 implements Hall {

	private Hall1 instance;
	private int hallNumber;
	private int numberOfAcceptance;
	private WeightComponents weightingComponents;

	private Hall1() {
		// TODO - implement Hall1.Hall1
		throw new UnsupportedOperationException();
	}

	@Override
	public Hall1 getInstance() {
		return this.instance;
	}

	@Override
	public int getHallNumber() {
		return this.hallNumber;
	}

	@Override
	public WeightComponents getWeightingComponents() {
		return this.weightingComponents;
	}

	@Override
	public void setWeightingComponents(WeightComponents weightingComponents) {
		this.weightingComponents = weightingComponents;
	}

	@Override
	public int getNumberOfAcceptance() {
		return numberOfAcceptance;
	}
	
	@Override
	public void setNumberOfAcceptance(int numberOfAcceptance) {
		this.numberOfAcceptance=numberOfAcceptance;
	}

}
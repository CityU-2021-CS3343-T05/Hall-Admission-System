package HallAdmissionSystem;

public class Hall2 implements Hall {

	private Hall2 instance;
	private int hallNumber;
	private int numberOfAcceptance;
	private WeightComponents weightingComponents;

	private Hall2() {
		// TODO - implement Hall2.Hall2
		throw new UnsupportedOperationException();
	}

	@Override
	public Hall getInstance() {
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
	public int getNumberofAcceptance() {
		return this.numberOfAcceptance;
	}

	@Override
	public void setNumberofAcceptance(int numberofAcceptance) {
		this.numberOfAcceptance = numberofAcceptance;
	}

}
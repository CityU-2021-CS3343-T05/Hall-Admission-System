package HallAdmissionSystem;

public class Hall3 implements Hall {

	private Hall3 instance;
	private int hallNumber;
	private int numberOfAcceptance;
	private WeightComponents weightingComponents;

	private Hall3() {
		// TODO - implement Hall3.Hall3
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
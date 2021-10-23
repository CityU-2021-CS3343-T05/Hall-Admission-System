package HallAdmissionSystem;

public class Hall1 implements Hall {

	private Hall1 instance = new Hall1();;
	private int hallNumber;
	private int numberOfAcceptance;
	private WeightComponents weightingComponents;

	private Hall1() {
		this.hallNumber = 1;
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
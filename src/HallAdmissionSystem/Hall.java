package HallAdmissionSystem;

public class Hall {

	private int hallNumber;
	private int numberOfAcceptance;
	private WeightComponent weightingComponents;

	public Hall(int hallNumber, int numOfAcceptance, WeightComponent weightComponents) {
		this.hallNumber = hallNumber;
		this.numberOfAcceptance = numOfAcceptance;
		this.weightingComponents = weightComponents;
	}

	public int getHallNumber() {
		return this.hallNumber;
	}

	public int[] getHallWeightings() {
		return this.weightingComponents.getWeightings();
	}

	public void setNewHallWeightings(int newAcademicWeight, int newLeaderShipWeight, int newEcaWeight, int newLocationWeight) {
		this.weightingComponents.setWeightings(newAcademicWeight, newLeaderShipWeight, newEcaWeight, newLocationWeight);
	}

	public int getNumberofAcceptance() {
		return this.numberOfAcceptance;
	}

	public void setNumberofAcceptance(int numberofAcceptance) {
		this.numberOfAcceptance = numberofAcceptance;
	}
	
	@Override
	public String toString() {
		return Integer.toString(hallNumber);
	}

}
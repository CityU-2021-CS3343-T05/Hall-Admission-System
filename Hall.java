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

	public void setNewHallWeightings(WeightComponent newWightComponent) {
		this.weightingComponents = newWightComponent;
	}

	public int getNumberofAcceptance() {
		return this.numberOfAcceptance;
	}

	public void setNumberofAcceptance(int numberofAcceptance) {
		this.numberOfAcceptance = numberofAcceptance;
	}
	
	@Override
	public String toString() {
		return "Hall " + Integer.toString(hallNumber);
	}
	
	@Override
	public boolean equals(Object target) {
		if (target == this) {
            return true;
        }
        if (target == null || target.getClass() != this.getClass()) {
            return false;
        }
        
        Hall hallTarget = (Hall)target;
		
		if(this.hallNumber == hallTarget.hallNumber) {
			return true;
		}else {
			return false;
		}
	}
}
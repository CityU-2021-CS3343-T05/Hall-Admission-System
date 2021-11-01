package HallAdmissionSystem;

public class WeightComponent {

	private Weighting academic, leadership, eCA, location;

	public WeightComponent(int academicWeight, int leadershipWeight, int ecaWeight, int locationWeight) {
		this.academic = new Area_Academic(new ValueWeighting(academicWeight));
		this.leadership = new Area_LeaderShip(new ValueWeighting(leadershipWeight));
		this.eCA = new Area_ECA(new ValueWeighting(ecaWeight));
		this.location = new Area_Location(new ValueWeighting(locationWeight));
	}

	public void setAcademic(int newWeight) {
		this.academic.setWeightValue(newWeight);
	}

	public void setLeaderShip(int newLeaderShipTimes) {
		this.leadership.setWeightValue(newLeaderShipTimes);
	}
	
	public void setEca(int newEca) {
		this.eCA.setWeightValue(newEca);
	}

	public void setLocation(int newLocation) {
		this.location.setWeightValue(newLocation);
	}

	public void setWeightings(int newAcademicWeight, int newLeaderShipWeight, int newEcaWeight, int newLocationWeight) {
		this.academic.setWeightValue(newAcademicWeight);
		this.leadership.setWeightValue(newLeaderShipWeight);
		this.eCA.setWeightValue(newEcaWeight);
		this.location.setWeightValue(newLocationWeight);
	}

	public int[] getWeightings() {
		return new int[] { this.academic.getValue(), this.leadership.getValue(), this.eCA.getValue(),
				this.location.getValue() };
	}
}
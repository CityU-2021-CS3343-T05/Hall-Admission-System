package HallAdmissionSystem;

public class ScoreComponent {

	private Score academic, leadership, eCA, location;

	public ScoreComponent(String academicType, String academicScore, String leadershipTimes, String ecaHour, String location) {
		this.academic = Area_Academic.createArea_Academic(academicType, academicScore);
		this.leadership = new Area_LeaderShip(new ValueScore(Area_LeaderShip.convertScore(leadershipTimes), leadershipTimes));
		this.eCA = new Area_ECA(new ValueScore(Area_ECA.convertScore(ecaHour), ecaHour));
		this.location = new Area_Location(new ValueScore(Area_Location.convertScore(location), location));
	}
	
	public int getAcademic() {
		return this.academic.getValue();
	}

	public void setAcademic(String newScore) {
		this.academic.setScoreValue(newScore);;
	}
	
	public int getLeaderShip() {
		return this.leadership.getValue();
	}

	public void setLeaderShip(String newTimes) {
		this.leadership.setScoreValue(newTimes);
	}
	
	public int getECA() {
		return this.eCA.getValue();
	}
	
	public void setECA(String newHour) {
		this.eCA.setScoreValue(newHour);
	}

	public int getLocation() {
		return this.location.getValue();
	}

	public void setLocation(String newLocation) {
		this.location.setScoreValue(newLocation);
	}
	
	public int[] getDetailScoreList() {
		return new int[] {this.academic.getValue(), this.leadership.getValue(), this.eCA.getValue(), this.location.getValue()};
	}
	
	@Override
	public String toString() {
		return this.academic.getValue() + "\t" + this.leadership.getValue() + "\t" + this.eCA.getValue() + "\t" + this.location.getValue();
	}

}
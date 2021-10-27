package HallAdmissionSystem;

import java.util.ArrayList;

public class ScoreComponent {

	private Score academic, leadership, eCA, location;

	public ScoreComponent(String academicType, String academicScore, String leadershipTimes, String ecaHour, String location) {
		this.academic = Area_Academic.createArea_Academic(academicType, academicScore);
		this.leadership = new Area_LeaderShip(leadershipTimes);
		this.eCA = new Area_ECA(ecaHour);
		this.location = new Area_Location(location);
	}
	
	public int getAcademic() {
		return this.academic.getValue();
	}

	public void setAcademic(String newScore) {
		this.academic.setValue(newScore);;
	}
	
	public int getLeaderShip() {
		return this.leadership.getValue();
	}

	public void setLeaderShip(String newTimes) {
		this.leadership.setValue(newTimes);
	}
	
	public int getECA() {
		return this.eCA.getValue();
	}
	
	public void setECA(String newHour) {
		this.eCA.setValue(newHour);
	}

	public Area_Location getLocation() {
		return null;
	}

	public void setLocation(Area_Location location) {
		this.location = location;
	}

}
package HallAdmissionSystem;

import java.util.ArrayList;

public class ScoreComponent {

	private Score academic, leadership, eCA, location;

	public ScoreComponent(String academicType, String academic, String leadership, String eCA, String location) {
		this.academic = Area_Academic.createArea_Academic(academicType, academic);
//		this.leadership = new Area_LeaderShip(leadership);
	}
	
	public int getAcademic() {
		return academic.getValue();
	}

	public void setAcademic(String newScore) {
		this.academic.setValue(newScore);;
	}
	
	public Area_LeaderShip getLeaderShip() {
		return null;
	}

	/**
	 * 
	 * @param leaderShip
	 */
	public void setLeaderShip(Area_LeaderShip leaderShip) {
	}
	
	public Area_ECA getEca() {
		return null;
	}

	/**
	 * 
	 * @param eca
	 */
	public void setEca(Area_ECA eca) {
	}

	public Area_Location getLocation() {
		return null;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(Area_Location location) {
		this.location = location;
	}

}
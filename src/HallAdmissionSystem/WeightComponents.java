package HallAdmissionSystem;

public class WeightComponents {

	private LeaderShip leaderShip;
	private Academic academic;
	private ECA eca;
	private Location location;

	public LeaderShip getLeaderShip() {
		return this.leaderShip;
	}

	/**
	 * 
	 * @param leaderShip
	 */
	public void setLeaderShip(LeaderShip leaderShip) {
		this.leaderShip = leaderShip;
	}

	public Academic getAcademic() {
		return this.academic;
	}

	/**
	 * 
	 * @param academic
	 */
	public void setAcademic(Academic academic) {
		this.academic = academic;
	}

	public ECA getEca() {
		return this.eca;
	}

	/**
	 * 
	 * @param eca
	 */
	public void setEca(ECA eca) {
		this.eca = eca;
	}

	public Location getLocation() {
		return this.location;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

}
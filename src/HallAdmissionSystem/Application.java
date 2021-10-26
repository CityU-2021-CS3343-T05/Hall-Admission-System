package HallAdmissionSystem;

import java.util.Date;

public class Application {

	private String sid;
	private Date applyTime;
	private Hall perferenceHall;
	private Score score;
	private boolean isLocal;

	public String getSid() {
		return this.sid;
	}

	/**
	 * 
	 * @param sid
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getAcademicScore() {
		return 0;
	}

	/**
	 * 
	 * @param academicScore
	 */
	public void setAcademicScore(int academicScore) {
	}

	public int getLeadershipHr() {
		return 0;
	}

	/**
	 * 
	 * @param leadershipHr
	 */
	public void setLeadershipHr(int leadershipHr) {
	}

	public int getEcaHr() {
		return 0;
	}

	/**
	 * 
	 * @param ecaHr
	 */
	public void setEcaHr(int ecaHr) {
	}

	public int getSchoolRepresentive() {
		return 0;
	}

	/**
	 * 
	 * @param schoolRepresentive
	 */
	public void setSchoolRepresentive(int schoolRepresentive) {
	}

	public String getLocation() {
		return null;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	/**
	 * 
	 * @param applyTime
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Hall getPerferenceHall() {
		return this.perferenceHall;
	}

	/**
	 * 
	 * @param perferenceHall
	 */
	public void setPerferenceHall(Hall perferenceHall) {
		this.perferenceHall = perferenceHall;
	}

	public int getScore() {
		return 0;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(int score) {
	}

	public boolean getIsLocal() {
		return this.isLocal;
	}

	/**
	 * 
	 * @param isLocal
	 */
	public void setIsLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

}
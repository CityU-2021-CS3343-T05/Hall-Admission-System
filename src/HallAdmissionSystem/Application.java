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
		return this.academicScore;
	}

	/**
	 * 
	 * @param academicScore
	 */
	public void setAcademicScore(int academicScore) {
		this.academicScore = academicScore;
	}

	public int getLeadershipHr() {
		return this.leadershipHr;
	}

	/**
	 * 
	 * @param leadershipHr
	 */
	public void setLeadershipHr(int leadershipHr) {
		this.leadershipHr = leadershipHr;
	}

	public int getEcaHr() {
		return this.ecaHr;
	}

	/**
	 * 
	 * @param ecaHr
	 */
	public void setEcaHr(int ecaHr) {
		this.ecaHr = ecaHr;
	}

	public int getSchoolRepresentive() {
		return this.schoolRepresentive;
	}

	/**
	 * 
	 * @param schoolRepresentive
	 */
	public void setSchoolRepresentive(int schoolRepresentive) {
		this.schoolRepresentive = schoolRepresentive;
	}

	public String getLocation() {
		return this.location;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
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
		return this.score;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
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
package HallAdmissionSystem;

import java.util.Date;

public class Application {

	private Date applyTime;
	private String sid;
	private boolean isLocal;
	private Hall perferenceHall;
	private ScoreComponent score;
	
	public Application(Student std, int perferHall, ScoreComponent score) {
		this.applyTime = new Date();
		this.sid = std.getSid();
		this.isLocal = std.getIsLocal();
		
		HallSystem hS = HallSystem.getInstance();
		perferenceHall = hS.getHall(perferHall);
		
		this.score = score;
	}

	public String getSid() {
		return this.sid;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public Hall getPerferenceHall() {
		return this.perferenceHall;
	}

	public void setPerferenceHall(int newHallNumber) {
	}

	public ScoreComponent getScore() {
		return score;
	}

	public void setScore(int score) {
	}

	public boolean getIsLocal() {
		return this.isLocal;
	}

	public void setIsLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

}
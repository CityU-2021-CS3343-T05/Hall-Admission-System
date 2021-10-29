package HallAdmissionSystem;

import java.util.Date;

public class Application implements Comparable<Application> {

	private Date applyTime;
	private String sid;
	private boolean isLocal;
	private int year;
	private Hall perferenceHall;
	private ScoreComponent score;
	private int totalScore;

	public Application(Student std, int perferHall, ScoreComponent score) {
		this.applyTime = new Date();
		this.sid = std.getSid();
		this.isLocal = std.getIsLocal();
		this.year = std.getYear();
		
		HallSystem hS = HallSystem.getInstance();
		perferenceHall = hS.getHall(perferHall);

		this.score = score;
	}

	public String getSid() {
		return this.sid;
	}
	
	public int getYear() {
		return this.year;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public Hall getPerferenceHall() {
		return this.perferenceHall;
	}

	public int[] getDetailScore() {
		return score.getDetailScoreList();
	}

	public boolean getIsLocal() {
		return this.isLocal;
	}

	public void setTotalScore(int s) {
		this.totalScore = s;
	}

	@Override
	public String toString() {
		return this.applyTime + "\t" + sid + "\t" + this.isLocal + "\t" + this.year + "\t" + this.perferenceHall + "\t" + this.score + "\t" + this.totalScore;
	}

	@Override
	public int compareTo(Application target) {
		if (this.totalScore > target.totalScore) {
			return -1;
		} else if (this.totalScore == target.totalScore) {
			return 0;
		} else {
			return 1;
		}
	}
}
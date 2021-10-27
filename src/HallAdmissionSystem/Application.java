package HallAdmissionSystem;

import java.util.Date;

public class Application{

	private Date applyTime;
	private String sid;
	private boolean isLocal;
	private Hall perferenceHall;
	private ScoreComponent score;
	private int totalScore;
	
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
		return this.applyTime + "\t" + sid + "\t" + this.isLocal + "\t" + this.perferenceHall + "\t" + this.score;	
	}
}
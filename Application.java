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
		return this.applyTime + "\t" + sid + "\t" + this.isLocal + "\tYear " + this.year + "\t" + this.perferenceHall + "\t"
				+ this.score + "\t" + this.totalScore;
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
	
	@Override
	public boolean equals(Object target) {
		if (target == this) {
            return true;
        }
        if (target == null || target.getClass() != this.getClass()) {
            return false;
        }
        
        Application appTarget = (Application)target;
		if(this.sid == appTarget.sid) {
			return true;
		}else {
			return false;
		}
	}

	public void showApplicationScore() {
		int[] detailScore = this.getDetailScore();
		Hall preferencedHall = this.getPerferenceHall();

		int[] detailWeighting = preferencedHall.getHallWeightings();
		int sum = 0;
		for (int i = 0; i < detailWeighting.length; i++) {
			sum += detailWeighting[i] * detailScore[i];
		}
		this.setTotalScore(sum);
		System.out.println(this);
	}
}

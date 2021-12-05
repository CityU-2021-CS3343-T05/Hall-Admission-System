package HallAdmissionSystem;

public class ValueScore implements Value {

	private int score;
	private String rawScore;
	
	public ValueScore(int rawScore, String rawData) {
		this.rawScore = rawData;
		this.score = rawScore;
	}

	public String getRawScore() {
		return this.rawScore;
	}
	
	public void setRawScore(String rawScore) {
		this.rawScore = rawScore;
	}

	@Override
	public int getValue() {
		return score;
	}

	@Override
	public void setValue(int s) {
		this.score = s;
	}

}
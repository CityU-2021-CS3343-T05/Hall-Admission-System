package HallAdmissionSystem;

import java.lang.Math;

public class Area_GPA extends Area_Academic {

	public Area_GPA(String rawScore) {
		super(new ValueScore(convertScore(rawScore), rawScore));
	}

	public static int convertScore(String rawData) {
		return (int) Math.round(Double.parseDouble(rawData)/4.3*10);
	}

	@Override
	public void setScoreValue(String v) {
		super.setScoreValue(Integer.toString(convertScore(v)));
	}
}
package HallAdmissionSystem;

import java.lang.Math;

public class Area_GPA extends Area_Academic {

	public Area_GPA(String rawString) {
		super(new ValueScore(convertScore(rawString), rawString));
	}

	public static int convertScore(String rawData) {
		return (int) Math.round(Double.parseDouble(rawData)/4.3*10);
	}

	@Override
	public void setValue(String v) {
		super.setValue(Integer.toString(convertScore(v)));
	}
}
package HallAdmissionSystem;

import java.lang.Math;

public class Area_GPA extends Area_Academic {

	public Area_GPA(String rawString) {
		super(new ValueScore(convertScore(rawString), rawString));
	}

	@Override
	public static int convertScore(String rawData) {
		
		return (int) Math.round(Long.parseLong(rawData)/4.3);
	}

}
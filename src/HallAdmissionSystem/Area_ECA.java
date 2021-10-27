package HallAdmissionSystem;

public class Area_ECA implements Weighting, Score {

	private Value value;

	public Area_ECA(String ecaHour) {
		this.value = new ValueScore(convertScore(ecaHour), ecaHour);
	}

	public static int convertScore(String rawData) {
		int input = Integer.parseInt(rawData);
		if (input >= 210) {
			return 10;
		} else if (input >= 185) {
			return 7;
		} else if (input >= 160) {
			return 5;
		} else if (input >= 135) {
			return 4;
		} else if (input >= 110) {
			return 3;
		} else if (input >= 85) {
			return 2;
		} else if (input >= 60) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public void setValue(String v) {
		this.value.setValue(convertScore(v));
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return this.value.getValue();
	}

}
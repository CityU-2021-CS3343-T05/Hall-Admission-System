package HallAdmissionSystem;

public class Area_ECA implements Weighting, Score {

	private Value value;

	public Area_ECA(Value v) {
		this.value = v;
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
	public void setScoreValue(String v) {
		this.value.setValue(convertScore(v));
	}
	
	@Override
	public void setWeightValue(int newWeight) {
		this.value.setValue(newWeight);
	}


	@Override
	public int getValue() {
		return this.value.getValue();
	}

}
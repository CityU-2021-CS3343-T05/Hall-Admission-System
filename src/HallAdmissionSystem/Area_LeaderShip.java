package HallAdmissionSystem;

public class Area_LeaderShip implements Weighting, Score {

	private Value value;

	public Area_LeaderShip(String leadershipTimes) {
		this.value = new ValueScore(convertScore(leadershipTimes), leadershipTimes);

	}

	public static int convertScore(String rawData) {
		int input = Integer.parseInt(rawData);
		if (input >= 5) {
			return 10;
		} else if (input == 4) {
			return 8;
		} else if (input == 3) {
			return 6;
		} else if (input == 2) {
			return 4;
		} else if (input == 1) {
			return 2;
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
		return value.getValue();
	}
}
package HallAdmissionSystem;

public class Area_LeaderShip implements Weighting, Score {

	private Value value;

	public Area_LeaderShip(Value v) {
		this.value = v;
	}

	public static int convertScore(String rawData) {
		int input = Integer.parseInt(rawData);
		if(input<=0) {
			return 0; 
		}
		if (input >= 5) {
			return 10;
		}else {
			return input*2;
		}
//		else if (input == 4) {
//			return 8;
//		} else if (input == 3) {
//			return 6;
//		} else if (input == 2) {
//			return 4;
//		} else if (input == 1) {
//			return 2;
//		} else {
//			return 0;
//		}
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
		return value.getValue();
	}
}
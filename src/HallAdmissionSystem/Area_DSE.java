package HallAdmissionSystem;

public class Area_DSE extends Area_Academic {

	public Area_DSE(String rawScore) {
		super(new ValueScore(convertScore(rawScore), rawScore));
	}

	public static int convertScore(String rawData) {
		if(rawData.equals("5**")) {
			return 10;
		}else if (rawData.equals("5*")) {
			return 7;
		}else if (rawData.equals("5")) {
			return 5;
		}else if (rawData.equals("4")) {
			return 4;
		}else if (rawData.equals("3")) {
			return 3;
		}else if (rawData.equals("2")) {
			return 2;
		}else if (rawData.equals("1")) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public void setScoreValue(String v) {
		super.setScoreValue(Integer.toString(convertScore(v)));
	}
}
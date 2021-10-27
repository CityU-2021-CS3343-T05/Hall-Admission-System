package HallAdmissionSystem;

public class Area_Location implements Weighting, Score {

	private Value value;
	
	public Area_Location(String location) {
		this.value = new ValueScore(convertScore(location), location);
	}
	
	public static int convertScore(String rawData) {

		return 0;
	}

	@Override
	public void setValue(String v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
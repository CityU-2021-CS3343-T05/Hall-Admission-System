package HallAdmissionSystem;

public abstract class Area_Academic implements Weighting, Score {

	private Value value;
	
	public Area_Academic(Value v) {
		this.value = v;
	}
	
	public static Area_Academic createArea_Academic(String type, String rawString) {
		if(type.equals("DSE")) {
			return new Area_DSE(rawString);
		}else {
			return new Area_GPA(rawString);
		}
	}

	@Override
	public void setValue(int v) {
		this.value.setValue(v);		
	}

	@Override
	public int getValue() {
		return this.value.getValue();
	}

	public static int convertScore(String rawData) {
		return -9999;
	}
}
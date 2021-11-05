package HallAdmissionSystem;

public class Area_Academic implements Weighting, Score {

	private Value value;
	
	public Area_Academic(Value v) {
		this.value = v;
	}
	
	public static Area_Academic createArea_Academic(String type, String rawString) throws Exception {
		if(type.toUpperCase().equals("DSE")) {
			return new Area_DSE(rawString);
		}else if(type.toUpperCase().equals("GPA")){
			return new Area_GPA(rawString);
		}else {
			throw new Exception();
		}
	}

	@Override
	public void setScoreValue(String v) {
		this.value.setValue(Integer.parseInt(v));		
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
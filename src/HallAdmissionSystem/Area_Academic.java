package HallAdmissionSystem;

public class Area_Academic implements Weighting, Score {

	private Value value;
	
	public Area_Academic(Value v) {
		this.value = v;
	}
	
	public static Area_Academic createArea_Academic(String type, String rawString) throws Ex_WrongExamType {
		if(type.equals("DSE")) {
			return new Area_DSE(rawString);
		}else if(type.equals("GPA")){
			return new Area_GPA(rawString);
		}else {
			throw new Ex_WrongExamType();
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
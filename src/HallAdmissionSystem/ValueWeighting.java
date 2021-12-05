package HallAdmissionSystem;

public class ValueWeighting implements Value {

	private int weight;

	public ValueWeighting(int academicWeight) {
		this.weight = academicWeight;
	}

	@Override
	public int getValue() {
		return this.weight;
	}

	@Override
	public void setValue(int v) {
		this.weight = v;
	}

}
package HallAdmissionSystem;

public class Hall1 extends Hall {

	private static Hall instance = new Hall1();

	private Hall1() {
		super(1, 20, new WeightComponent(0, 0, 0, 0));
	}
	
//	public Hall1(int number, int capacity, WeightComponent w) {
//		super(number, capacity, w);
//	}

	public static Hall getInstance() {
		return instance;
	}
}
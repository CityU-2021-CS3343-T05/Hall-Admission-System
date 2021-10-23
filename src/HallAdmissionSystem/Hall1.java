package HallAdmissionSystem;

public class Hall1 extends Hall {
	
	private static Hall instance = new Hall1();
	
	private Hall1() {
		super(1, 20, new WeightComponents());
	}
	
	public static Hall getInstance() {
		return instance;
	}
}
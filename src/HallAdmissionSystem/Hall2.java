package HallAdmissionSystem;

public class Hall2 extends Hall {

	private static Hall instance = new Hall2();
	
	private Hall2() {
		super(2, 30, new WeightComponent(0, 0, 0, 0));
	}
	
	public static Hall getInstance() {
		return instance;
	}
}
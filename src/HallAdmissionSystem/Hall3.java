package HallAdmissionSystem;

public class Hall3 extends Hall {

	private static Hall instance = new Hall3();
	
	private Hall3() {
		super(3, 50, new WeightComponent(0, 0, 0, 0));
	}
	
	public static Hall getInstance() {
		return instance;
	}
}
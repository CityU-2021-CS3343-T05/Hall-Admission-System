package HallAdmissionSystem;

public interface Hall {

	public Hall getInstance();

	public int getHallNumber();
	
	public int getNumberofAcceptance();

	public void setNumberofAcceptance(int numberofAcceptance);

	public WeightComponents getWeightingComponents();
	
	public void setWeightingComponents(WeightComponents weightingComponents);
}
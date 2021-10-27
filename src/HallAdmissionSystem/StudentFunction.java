package HallAdmissionSystem;

public interface StudentFunction {

	void createApplication();

	void viewApplication();

	void viewHallList();

	void viewResult();
	
	Hall getHall(int targetHall);

}
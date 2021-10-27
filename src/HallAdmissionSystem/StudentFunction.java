package HallAdmissionSystem;

public interface StudentFunction {

	void createApplication();

	void viewApplication();

	void viewHallList();

	void viewResult();
	
	Hall getHall(int targetHall);

	void createApplication(Student std, int perferHall, ScoreComponent score);

}
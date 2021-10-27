package HallAdmissionSystem;

public interface StudentFunction {

	void createApplication(Student std, int perferHall, ScoreComponent score);

	void viewApplication();

	void viewHallList();

	void viewResult();
	
	Hall getHall(int targetHall);

}
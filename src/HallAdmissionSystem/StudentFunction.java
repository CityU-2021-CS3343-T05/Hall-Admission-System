package HallAdmissionSystem;

public interface StudentFunction {

	void createApplication(Student std, int perferHall, ScoreComponent score);

	void deleteApplication(Student std);
	
	void viewApplication(Student std);

	void viewHallList();

	void viewSpecificResult(Student std);
	
	Hall getHall(int targetHall);

}
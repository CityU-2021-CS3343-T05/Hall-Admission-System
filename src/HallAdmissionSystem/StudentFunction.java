package HallAdmissionSystem;

public interface StudentFunction {

	void createApplication(Student std, int perferHall, ScoreComponent score);

	void delateApplication(Student std);
	
	void viewApplication(Student std);

	void viewHallList();

	void viewResult();
	
	Hall getHall(int targetHall);

}
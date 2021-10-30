package HallAdmissionSystem;

public interface CityUFunction {

	void processApplication();

	void viewAllApplication();

	void viewHallList();

	void viewResult();

	void createNewHall(int hallNum, int capacity, int academicWeight, int leaderShipWeight, int ecaWeight,
			int locationWeight);

	void changeHallSetting(Hall hall, int newAcademicWeight, int newLeaderShipWeight, int newEcaWeight, int newLocationWeight);

}
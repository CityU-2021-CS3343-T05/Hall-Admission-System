package HallAdmissionSystem;

public interface CityUFunction {

	void processApplication();

	void viewApplication();

	void viewHallList();

	void viewResult();

	void createNewwHall(int hallNum, int capacity, int academicWeight, int leaderShipWeight, int ecaWeight,
			int locationWeight);

	void changeHallSetting(Hall hall, int newAcademicWeight, int newLeaderShipWeight, int newEcaWeight, int newLocationWeight);
}
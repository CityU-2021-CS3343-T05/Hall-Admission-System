package HallAdmissionSystem;

public interface AdministratorFunction {

	void processApplication();

	void viewAllApplication();

	void viewHallList();

	void viewResult();

	void createNewHall(int hallNum, int capacity, int academicWeight, int leaderShipWeight, int ecaWeight,
			int locationWeight);

	void changeHallSetting(int hall,int newCapacity, int newAcademicWeight, int newLeaderShipWeight, int newEcaWeight, int newLocationWeight);

}
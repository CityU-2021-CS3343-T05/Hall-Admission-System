package HallAdmissionSystem;

public interface AdministratorFunction {

	void processApplication();

	void viewAllApplication();

	void viewHallList();

	void viewResult();

	void createNewHall(int hallNum, int capacity, WeightComponent weightComponent);

	void changeHallSetting(int hall,int newCapacity, WeightComponent newWeightComponent);

}
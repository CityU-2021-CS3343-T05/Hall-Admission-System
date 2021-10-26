package HallAdmissionSystem;

public interface Score {

	static int convertScore(String rawData) {
		return -9999;
	}

	void setValue(int v);

	int getValue();

}
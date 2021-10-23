package HallAdmissionSystem;

import java.util.ArrayList;

public class System implements CityUFunction, StudentFunction {

	private System instance;
	private ArrayList<Hall> allHall;
	private ArrayList<Application> allApplication;
	private Process process;

	private System() {
		// TODO - implement System.System
		throw new UnsupportedOperationException();
	}

	public System getInstance() {
		return this.instance;
	}

	public void processApplication() {
		// TODO - implement System.processApplication
		throw new UnsupportedOperationException();
	}

	public void viewApplication() {
		// TODO - implement System.viewApplication
		throw new UnsupportedOperationException();
	}

	public void createApplication() {
		// TODO - implement System.createApplication
		throw new UnsupportedOperationException();
	}

	public void viewHallList() {
		// TODO - implement System.viewHallList
		throw new UnsupportedOperationException();
	}

	public void viewResult() {
		// TODO - implement System.viewResult
		throw new UnsupportedOperationException();
	}

}
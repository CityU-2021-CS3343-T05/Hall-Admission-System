package HallAdmissionSystem;

import java.util.*;

public class Process {

	private ArrayList<Result> allOutput;
	private ArrayList<Application> allInput;
	
	public Process(ArrayList<Application> list) {
		this.allInput = list;
	}

	public void calculateApplicationScore(ArrayList<Application> list) {
		for (Application application : list) {
			int[] detailScore = 
		}
	}

	public void sortApplication() {
		// TODO - implement Process.sortApplication
		throw new UnsupportedOperationException();
	}

	public void runNonLocalProcess() {
		// TODO - implement Process.runNonLocalProcess
		throw new UnsupportedOperationException();
	}

	public void runNonLocalWaitingProcess() {
		// TODO - implement Process.runNonLocalWaitingProcess
		throw new UnsupportedOperationException();
	}

	public void runLocalProcess() {
		// TODO - implement Process.runLocalProcess
		throw new UnsupportedOperationException();
	}
	
	public void runProcess() {
		
	}

}
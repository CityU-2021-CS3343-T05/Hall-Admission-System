package HallAdmissionSystem;

import java.util.*;

public class StartProcessing {

	private ArrayList<ProcessData> allProcessData;
	private ArrayList<Result> allResult;
	ArrayList<Application> allApplication;

	public StartProcessing(ArrayList<Application> allApplication) {
		this.allApplication = allApplication;
		this.allProcessData = new ArrayList<>();
		this.allResult = new ArrayList<>();
	}

	private void setupQueue() {
		HallSystem hS = HallSystem.getInstance();
		ArrayList<Hall> hallList = hS.getHallList();

		for (Hall hall : hallList) {
			allProcessData.add(new ProcessData(hall, true));
			allProcessData.add(new ProcessData(hall, false));
		}
		for (Hall hall : hallList) {
		
			this.allResult.add(new Result(hall));
		}
	}

	private ProcessData findOutput(Hall hall, boolean isLocal) {
		for (ProcessData res : allProcessData) {
			if (res.getHall().equals(hall)) {
				if (res.getIsLocal() == isLocal) {
					return res;
				}
			}
		}
		return null;
	}

	private void calculateApplicationScore(Application application) {
		System.out.println(application);
		int[] detailScore = application.getDetailScore();
		Hall preferencedHall = application.getPerferenceHall();

		int[] detailWeighting = preferencedHall.getHallWeightings();
		int sum = 0;

		for (int i = 0; i < detailWeighting.length; i++) {
			sum += detailWeighting[i] * detailScore[i];
		}

		application.setTotalScore(sum);
	}

	private void importApplication() {
		for (Application application : allApplication) {
			calculateApplicationScore(application);
			ProcessData inputTo = findOutput(application.getPerferenceHall(), application.getIsLocal());
			inputTo.addToList(application);
		}
	}

	private ProcessData findProcessData(Hall hall, boolean isLocal) {
		for (ProcessData pData : allProcessData) {
			if (pData.getHall().equals(hall) && pData.getIsLocal() == isLocal) {
//				System.out.println(">>>>>>>>>");
//				System.out.println(hall + "" + pData.getIsLocal());
				return pData;
			}
		}
		return null;
	}

	private void handleNonlocalAdmission() {
		for (Result res : allResult) {
			Hall pHall = res.getHall();

			ProcessData pDataNotLocal = findProcessData(pHall, false);

			// Non local
			Application pApplication = pDataNotLocal.getTopAppliant();

//			System.out.println("Doing++++++++++++++++++++++");
			while (pApplication != null) {
//				System.out.println(">>>=========>>>" + pApplication);

				Application status;

				if (pApplication.getYear() > 3) {
					ProcessData.addToReject(pApplication);
				} else {
					status = res.addToAdmission(pApplication);
//					System.out.println("####" + status);
					if (status != null) {
						ProcessData.addToWaiting(pApplication);

					}
				}
				pApplication = pDataNotLocal.getTopAppliant();
			}
		}
	}

	private void handleLocalAdmission() {
		for (Result res : allResult) {
			Hall pHall = res.getHall();

			ProcessData pDataIsLocal = findProcessData(pHall, true);

			// Local
			Application pApplication = pDataIsLocal.getTopAppliant();
			while (pApplication != null) {
				Application status;

				status = res.addToAdmission(pApplication);
				if (status != null) {
					ProcessData.addToReject(pApplication);
				}
				pApplication = pDataIsLocal.getTopAppliant();
			}
		}
	}

	public String processDetailedResultList() {
		String out = "";

		for (Result res : allResult) {
			out += res.toString();
		}

		out += ProcessData.getListing();

		return out;
	}
	
	public Application findApplication(Student std) {
		for (Application application : allApplication) {
			if (application.getSid() == std.getSid()) {
				return application;
			}
		}
		return null;
	}

	public String findDetailedResult(Student std) {
		String out = "";
		
		Application app = findApplication(std);
		
		for (Result res : allResult) {
			out = res.findSpecificResult(app);
		}

		if (out == null) {
			out = ProcessData.getSpecificListing(app);
		}
		
		if (out == null) {
			out = "Result not found\n";
		}

		return out;
	}

	private Result findTheLessPplHall() {
		Result minResult = allResult.get(0);
		int minPpl = allResult.get(0).getNumberOfPpl();

		for (Result res : allResult) {
			if (res.getNumberOfPpl() < minPpl) {
				minResult = res;
				minPpl = res.getNumberOfPpl();
			}
		}

		return minResult;
	}

	private void handleNonLocalWaiting() {

		Application pApplication = ProcessData.getTopWaitingStd();

		while (pApplication != null) {
			Application status;

			Result res = findTheLessPplHall();

			status = res.addToAdmission(pApplication);
			if (status != null) {
				ProcessData.addToReject(pApplication);
			}
			pApplication = ProcessData.getTopWaitingStd();
		}
	}

	public void runProcess() {
		setupQueue();
		importApplication();
		handleNonlocalAdmission();
		handleNonLocalWaiting();
		handleLocalAdmission();
	}
}
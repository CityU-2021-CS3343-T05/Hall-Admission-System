package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.text.Format.Field;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HallAdmissionSystem.Application;
import HallAdmissionSystem.Hall;
import HallAdmissionSystem.ProcessInformation;
import HallAdmissionSystem.ProcessResult;
import HallAdmissionSystem.ScoreComponent;
import HallAdmissionSystem.Student;
import HallAdmissionSystem.WeightComponent;

class testProcessInfromation {
	Hall hall1;
	ProcessInformation pInfo;
	Student std1, std2;
	Application application1;
	ScoreComponent sc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		std1 = new Student("S00001", "Jennifer", "Passw0rd", false, 4);
		std2 = new Student("S00002", "John", "Passw0rd", true, 4);
		sc = new ScoreComponent("DSE", "5**", "7", "211", "Tin Shui Wai");
		hall1 = new Hall(1, 2, new WeightComponent(1, 1, 1, 1));
		pInfo = new ProcessInformation(hall1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testImportApplication1() {
		String msg = "Test student is a non local student";
		Application actualResult = null;
		application1 = new Application(std1,1,sc);
		pInfo.importApplication(application1);
		actualResult = pInfo.topNonLocalApplication();
		assertNotNull(actualResult);
	}

	@Test
	void testImportApplication2() {
		String msg = "Test student is a local student";
		Application actualResult = null;
		application1 = new Application(std2,1,sc);
		pInfo.importApplication(application1);
		actualResult = pInfo.topLocalApplicant();
		assertNotNull(actualResult);
	}
}

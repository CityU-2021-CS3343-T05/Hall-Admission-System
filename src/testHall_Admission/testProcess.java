package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HallAdmissionSystem.*;
import HallAdmissionSystem.StartProcessing;

class testProcess {
	
	HallSystem hs;
	Student std1, std2, std3, std4;
	ArrayList<Application> allApplication;
	StartProcessing process;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		allApplication = new ArrayList<>();
		std1 = new Student("001", "Jennifer", "s001", false, 4);
		std2 = new Student("002", "Elston", "s002", false, 2);
		std3 = new Student("003", "Wilson", "s003", true, 2);
		std4 = new Student("004", "Chung", "s004", true, 2);
		
		allApplication.add(new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau")));
		allApplication.add(new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau")));
		allApplication.add(new Application(std3, 1, new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau")));
		allApplication.add(new Application(std4, 1, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau")));
		
		process = new StartProcessing(allApplication);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testProcessDetailedResultList() {
		fail("Not yet implemented");
	}

	@Test
	void testFindApplication() {
		fail("Not yet implemented");
	}

	@Test
	void testFindDetailedResult() {
		fail("Not yet implemented");
	}

}

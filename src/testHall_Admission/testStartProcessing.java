package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HallAdmissionSystem.*;

class testStartProcessing {
	
	HallSystem hs;
	Hall h1;
	Student std1, std2, std3, std4, std5, std6;
	Application application1, application2, application3, application4, application5, application6;
	ScoreComponent sc1, sc2, sc3, sc4, sc5, sc6;
	ArrayList<Application> allApplication;
//	StartProcessing process;
	private final PrintStream standardOut = System.out;
	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	Date expectedDate1, expectedDate2, expectedDate3, expectedDate4, expectedDate5, expectedDate6;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
//		hs = HallSystem.getInstance();
		allApplication = new ArrayList<>();
		
		std1 = new Student("S00001", "Jennifer", "s001", false, 4);
		std2 = new Student("S00002", "Elston", "s002", false, 2);
		std3 = new Student("S00003", "Wilson", "s003", true, 2);
		std4 = new Student("S00004", "Chung", "s004", true, 2);
		std5 = new Student("S00005", "Jacky", "s005", false, 2);
		std6 = new Student("S00006", "Jacky", "s006", false, 2);
		
		sc1 = new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau");
		sc2 = new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau");
		sc3 = new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau");
		sc4 = new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau");
		sc5 = new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau");
		sc6 = new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau");
		
		application1 = new Application(std1, 1, sc1);
		expectedDate1 = new Date();
		application2 = new Application(std2, 1, sc2);
		expectedDate2 = new Date();
		application3 = new Application(std3, 1, sc3);
		expectedDate3 = new Date();
		application4 = new Application(std4, 1, sc4);
		expectedDate4 = new Date();
		application5 = new Application(std5, 1, sc5);
		expectedDate5 = new Date();
		application6 = new Application(std6, 1, sc6);
		expectedDate6 = new Date();
		
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setOut(standardOut);
	}

//	@Test
//	void testProcessDetailedResultList1() {
//		String msg = "Test Process Detailed Result List with empty list";
//		
//		process = new StartProcessing(allApplication);
//		process.runProcess();
//		process.processDetailedResultList();
//		
//		String expectedOutput = "";
//		
//		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
//	}
	
	@Test
	void testProcessDetailedResultList2() {
		String msg = "Test Process Detailed Result List";
		
		allApplication.add(application1);
		allApplication.add(application2);
		allApplication.add(application3);
		allApplication.add(application4);
		
//		process = new StartProcessing(allApplication);
//		process.runProcess();
//		process.processDetailedResultList();
		
		String expectedOutput = expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0\r\n" + expectedDate2 + "\tS00002\tfalse\t2\tHall 1\t8\t4\t10\t10\t0\r\n" + expectedDate3 + "\tS00003\ttrue\t2\tHall 1\t9\t4\t10\t10\t0\r\n" + expectedDate4 + "\tS00004\ttrue\t2\tHall 1\t5\t4\t10\t10\t0";
//		System.out.println(outputStreamCaptor.toString());
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}

//	@Test
//	void testFindApplication1() {
//		String msg = "Test find std1 application";
//		
//		String expectedToString = expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0";
//		
//		allApplication.add(application1);
//		allApplication.add(application2);
//		allApplication.add(application3);
//		allApplication.add(application4);
//		
//		process = new StartProcessing(allApplication);
//		
//		Application actualResult = process.findApplication(std1);
//		
//		assertEquals(expectedToString,actualResult.toString(),msg);
//	}
//	
//	@Test
//	void testFindApplication2() {
//		String msg = "Test non-existing student application";
//		
//		allApplication.add(application1);
//		allApplication.add(application3);
//		allApplication.add(application4);
//		
//		process = new StartProcessing(allApplication);
//		
//		Application actualResult = process.findApplication(std2);
//		
//		assertNull(actualResult);
//	}
//
//	@Test
//	void testFindDetailedResult() {
//		String msg = "Test Find Detailed Result";
//		
//		String expectedOutput = "";
//		
//		allApplication.add(application1);
//		allApplication.add(application2);
//
//		process = new StartProcessing(allApplication);
//		process.runProcess();
//		
//		process.findDetailedResult(std1);
//		
//		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
//	}
//	
	@Test
	void testRunProcess() {
		String msg = "Test handle non local waiting";
		
		String expectedOutput = "";
		
		hs = HallSystem.getInstance();
		
		hs.createApplication(std1, 1, sc1);
		hs.createApplication(std2, 1, sc2);
		hs.createApplication(std3, 2, sc3);
		hs.createApplication(std4, 2, sc4);
		hs.createApplication(std5, 1, sc5);
		hs.createApplication(std6, 1, sc6);
		
		hs.processApplication();
		
		hs.viewAllApplication();
		
		hs.viewResult();
		
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		
	}

}
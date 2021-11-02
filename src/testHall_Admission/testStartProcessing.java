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
	Student std1, std2, std3, std4;
	Application application1, application2, application3, application4;
	ArrayList<Application> allApplication;
	StartProcessing process;
	private final PrintStream standardOut = System.out;
	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	Date expectedDate1, expectedDate2, expectedDate3, expectedDate4;
	
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
		
		application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
		expectedDate1 = new Date();
		application2 = new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
		expectedDate2 = new Date();
		application3 = new Application(std3, 1, new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau"));
		expectedDate3 = new Date();
		application4 = new Application(std4, 1, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
		expectedDate4 = new Date();
		
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setOut(standardOut);
	}

	@Test
	void testProcessDetailedResultList1() {
		String msg = "Test Process Detailed Result List with empty list";
		
		process = new StartProcessing(allApplication);
		process.runProcess();
		process.processDetailedResultList();
		
		String expectedOutput = "";
		
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testProcessDetailedResultList2() {
		String msg = "Test Process Detailed Result List";
		
		allApplication.add(application1);
		allApplication.add(application2);
		allApplication.add(application3);
		allApplication.add(application4);
		
		process = new StartProcessing(allApplication);
		process.runProcess();
		process.processDetailedResultList();
		
		String expectedOutput = expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0\r\n" + expectedDate2 + "\tS00002\tfalse\t2\tHall 1\t8\t4\t10\t10\t0\r\n" + expectedDate3 + "\tS00003\ttrue\t2\tHall 1\t9\t4\t10\t10\t0\r\n" + expectedDate4 + "\tS00004\ttrue\t2\tHall 1\t5\t4\t10\t10\t0\r\n";
		
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}

	@Test
	void testFindApplication1() {
		String msg = "Test find std1 application";
		
		String expectedToString = expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0";
		
		allApplication.add(application1);
		allApplication.add(application2);
		allApplication.add(application3);
		allApplication.add(application4);
		
		process = new StartProcessing(allApplication);
		
		Application actualResult = process.findApplication(std1);
		
		assertEquals(expectedToString,actualResult.toString(),msg);
	}
	
	@Test
	void testFindApplication2() {
		String msg = "Test non-existing student application";
		
		String expectedToString = expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0";
		
		allApplication.add(application1);
		allApplication.add(application3);
		allApplication.add(application4);
		
		process = new StartProcessing(allApplication);
		
		Application actualResult = process.findApplication(std2);
		
		assertNull(actualResult);
	}

	@Test
	void testFindDetailedResult() {
		String msg = "Test Find Detailed Result";
		
		String expectedOutput = "";
		
		process = new StartProcessing(allApplication);
		process.runProcess();
		
		process.findDetailedResult(std1);
		
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}

}

package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;

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

class testProcessResult {
	
	Hall hall1, hall2;
	ProcessResult pRes1, pRes2;
	Student std1, std2, std3;
	Application application;
	ScoreComponent sc;
//	private final PrintStream standardOut = System.out;
//	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		std1 = new Student("S00001", "Jennifer", "Passw0rd", false, 4);
		std2 = new Student("S00002", "John", "Passw0rd", false, 2);
		std3 = new Student("S00003", "Alex", "Passw0rd", true, 4);
		sc = new ScoreComponent("DSE", "5**", "7", "211", "Tin Shui Wai");
		hall1 = new Hall(1, 2, new WeightComponent(1, 1, 1, 1));
		hall2 = new Hall(1, 0, new WeightComponent(1, 1, 1, 1));
		pRes1 = new ProcessResult(hall1);
		pRes2 = new ProcessResult(hall2);
		Field fieldWaitingList = ProcessResult.class.getDeclaredField("waitingList");
		fieldWaitingList.setAccessible(true);
		fieldWaitingList.set(fieldWaitingList,new PriorityQueue<Application>());
		Field fieldRejectedList = ProcessResult.class.getDeclaredField("rejectedList");
		fieldRejectedList.setAccessible(true);
		fieldRejectedList.set(fieldWaitingList,new ArrayList<>());
		
	}

	@AfterEach
	void tearDown() throws Exception {
//		System.setOut(standardOut);
	}

	@Test
	void testAdmitApplication1() {
		String msg = "Test process Year 4 non local student application";
		
		application = new Application(std1,1,sc);
		Date expectedDate = new Date();
		String expectedAdmit = "Hall 1\n";
		String expectedWaiting = "Waiting List is empty \n";
		String expectedReject = "Reject List     " + expectedDate + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t0\n";
		pRes1.admitApplication(application);
		String actualAdmit = pRes1.toString();
		String actualWaiting = ProcessResult.getWaitingListing();
		String actualReject = ProcessResult.getRejectListing();
		
		assertEquals(expectedAdmit,actualAdmit,msg);
		assertEquals(expectedWaiting,actualWaiting,msg);
		assertEquals(expectedReject,actualReject,msg);
	}
	
	@Test
	void testAdmitApplication2() {
		String msg = "Test process Year 2 non local student application";
		
		application = new Application(std2,1,sc);
		Date expectedDate = new Date();
		String expectedAdmit = "Hall 1\nAdmitted        "+ expectedDate + "\tS00002\tfalse\tYear 2\tHall 1\t10\t10\t10\t7\t0\n";
		String expectedWaiting = "Waiting List is empty \n";
		String expectedReject = "Reject List is empty \n";
		pRes1.admitApplication(application);
		String actualAdmit = pRes1.toString();
		String actualWaiting = ProcessResult.getWaitingListing();
		String actualReject = ProcessResult.getRejectListing();
		
		assertEquals(expectedAdmit,actualAdmit,msg);
		assertEquals(expectedWaiting,actualWaiting,msg);
		assertEquals(expectedReject,actualReject,msg);
	}
	
	@Test
	void testAdmitApplication3() {
		String msg = "Test process Year 2 non local student application";
		
		application = new Application(std2,2,sc);
		Date expectedDate = new Date();
		String expectedAdmit = "Hall 1\n";
		String expectedWaiting = "Waiting List    "+ expectedDate + "\tS00002\tfalse\tYear 2\tHall 2\t10\t10\t10\t7\t0\n";
		String expectedReject = "Reject List is empty \n";
		pRes2.admitApplication(application);
		String actualAdmit = pRes2.toString();
		String actualWaiting = ProcessResult.getWaitingListing();
		String actualReject = ProcessResult.getRejectListing();
		
		assertEquals(expectedAdmit,actualAdmit,msg);
		assertEquals(expectedWaiting,actualWaiting,msg);
		assertEquals(expectedReject,actualReject,msg);
	}
	
	@Test
	void testAdmitApplication4() {
		String msg = "Test process Year 4 local student application";
		
		application = new Application(std3,1,sc);
		Date expectedDate = new Date();
		String expectedAdmit = "Hall 1\nAdmitted        "+ expectedDate + "\tS00003\ttrue\tYear 4\tHall 1\t10\t10\t10\t7\t0\n";
		String expectedWaiting = "Waiting List is empty \n";
		String expectedReject = "Reject List is empty \n";
		pRes1.admitApplication(application);
		String actualAdmit = pRes1.toString();
		String actualWaiting = ProcessResult.getWaitingListing();
		String actualReject = ProcessResult.getRejectListing();
		
		assertEquals(expectedAdmit,actualAdmit,msg);
		assertEquals(expectedWaiting,actualWaiting,msg);
		assertEquals(expectedReject,actualReject,msg);
	}
	
	@Test
	void testAdmitApplication5() {
		String msg = "Test process Year 4 local student application";
		
		application = new Application(std3,2,sc);
		Date expectedDate = new Date();
		String expectedAdmit = "Hall 1\n";
		String expectedWaiting = "Waiting List is empty \n";
		String expectedReject = "Reject List     "+ expectedDate + "\tS00003\ttrue\tYear 4\tHall 2\t10\t10\t10\t7\t0\n";
		pRes2.admitApplication(application);
		String actualAdmit = pRes1.toString();
		String actualWaiting = ProcessResult.getWaitingListing();
		String actualReject = ProcessResult.getRejectListing();
		
		assertEquals(expectedAdmit,actualAdmit,msg);
		assertEquals(expectedWaiting,actualWaiting,msg);
		assertEquals(expectedReject,actualReject,msg);
	}

	@Test
	void testFindInAdmit1() {
		String msg = "Test find existing application in admittion list";
		application = new Application(std2,1,sc);
		String expectedOutput = "Admited to Hall 1";
		pRes1.admitApplication(application);
		String actualOutput = pRes1.findInAdmit(application);
		assertEquals(expectedOutput,actualOutput,msg);
	}
	
	@Test
	void testFindInAdmit2() {
		String msg = "Test find non existing application in admittion list";
		application = new Application(std1,1,sc);
		String expectedOutput = null;
		String actualOutput = pRes1.findInAdmit(application);
		assertEquals(expectedOutput,actualOutput,msg);
	}

	@Test
	void testFindInWaiting1() {
		String msg = "Test find non existing application in waiting list";
		application = new Application(std2,2,sc);
		String expectedOutput = "Waiting list";
		pRes2.admitApplication(application);
		String actualOutput = ProcessResult.findInWaiting(application);
		assertEquals(expectedOutput,actualOutput,msg);
	}
	@Test
	void testFindInWaiting2() {
		String msg = "Test find non existing application in waiting list";
		application = new Application(std1,2,sc);
		String expectedOutput = null;
		String actualOutput = ProcessResult.findInWaiting(application);
		assertEquals(expectedOutput,actualOutput,msg);
	}

	@Test
	void testFindInReject1() {
		String msg = "Test find non existing application in reject list";
		application = new Application(std1,1,sc);
		String expectedOutput = "Reject list";
		pRes1.admitApplication(application);
		String actualOutput = ProcessResult.findInReject(application);
		assertEquals(expectedOutput,actualOutput,msg);
	}
	
	@Test
	void testFindInReject2() {
		String msg = "Test find non existing application in reject list";
		application = new Application(std1,1,sc);
		String expectedOutput = null;
		String actualOutput = ProcessResult.findInReject(application);
		assertEquals(expectedOutput,actualOutput,msg);
	}


}

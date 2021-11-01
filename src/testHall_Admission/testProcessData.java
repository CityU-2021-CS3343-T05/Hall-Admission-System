package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.PriorityQueue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HallAdmissionSystem.*;


class testProcessData {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	Hall hall1;
	ProcessData actualResult;
	Student std1, std2, std3, std4;
	Application application1 = null, application2 = null, application3 = null, application4 = null;
	Date expectedDate1 = null, expectedDate2 = null, expectedDate3 = null, expectedDate4 = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
		hall1 = new Hall(1, 2, new WeightComponent(1, 1, 1, 1));
		actualResult = new ProcessData(hall1,false);
		Field fieldWaitingList = ProcessData.class.getDeclaredField("waitingList");
		fieldWaitingList.setAccessible(true);
		fieldWaitingList.set(fieldWaitingList,new PriorityQueue<>(new ApplicationDateCompare()));
		Field fieldRejectedList = ProcessData.class.getDeclaredField("rejectedList");
		fieldRejectedList.setAccessible(true);
		fieldRejectedList.set(fieldRejectedList,new PriorityQueue<>(new ApplicationDateCompare()));
		std1 = new Student("S00001", "Jennifer", "Passw0rd", false, 4);
		std2 = new Student("S00002", "Elston", "Passw0rd", false, 2);
		std3 = new Student("S00003", "Wilson", "Passw0rd", false, 2);
		std4 = new Student("S00004", "Chung", "Passw0rd", false, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setOut(standardOut);
	}

	@Test
	void testToString1() {
		
		String msg = "Test empty fullList";
		
		String expectedOutput="";
		System.out.print(actualResult.toString());
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testToString2() {
		
		String msg = "Test non-empty fullList";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			actualResult.addToList(application1);
			String expectedOutput = "full        \tHall 1\tfalse\n" + expectedDate1+ "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0" ;
			System.out.print(actualResult.toString());
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
		}
		assertEquals(expectedFail,actualFail,msg);
		
	}

	@Test
	void testGetListing1() {
		
		String msg = "Test empty waiting list and empty rejected list";
		
		String expectedOutput = "Waiting List\nEmpty listing\n\nReject List\nEmpty listing";
		System.out.print(ProcessData.getListing());
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testGetListing2() {
		
		String msg = "Test 1 application in waiting list and empty rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToWaiting(application1);
			String expectedOutput = "Waiting List\n" + expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0\n\nReject List\nEmpty listing";
			System.out.print(ProcessData.getListing());
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testGetListing3() {
		
		String msg = "Test empty waiting list and 1 application in rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToReject(application1);
			String expectedOutput = "Waiting List\nEmpty listing\n\nReject List\n" + expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0";
			System.out.print(ProcessData.getListing());
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}

	@Test
	void testGetListing4() {
		
		String msg = "Test 1 application in waiting list and 1 application in rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
			 application2 = new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
			 expectedDate2 = new Date();
			 
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToWaiting(application1);
			ProcessData.addToReject(application2);
			String expectedOutput = "Waiting List\n" + expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0\n\nReject List\n" + expectedDate2 + "\tS00002\tfalse\t2\tHall 1\t8\t4\t10\t10\t0";
			System.out.print(ProcessData.getListing());
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testGetListing5() {
		
		String msg = "Test 2 applications in waiting list and empty rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
			 application2 = new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
			 expectedDate2 = new Date();
			 
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToWaiting(application1);
			ProcessData.addToWaiting(application2);
			String expectedOutput = "Waiting List\n" + expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0\n"+ expectedDate2 + "\tS00002\tfalse\t2\tHall 1\t8\t4\t10\t10\t0\n\nReject List\nEmpty listing";
			System.out.print(ProcessData.getListing());
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testGetListing6() {
		
		String msg = "Test empty waiting list and 2 applications in rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
			 application2 = new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
			 expectedDate2 = new Date();
			 
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToReject(application1);
			ProcessData.addToReject(application2);
			String expectedOutput = "Waiting List\nEmpty listing\n\nReject List\n" + expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0\n"+ expectedDate2 + "\tS00002\tfalse\t2\tHall 1\t8\t4\t10\t10\t0";
			System.out.print(ProcessData.getListing());
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testGetSpecificListing1() {
		
		String msg = "Test getting application in empty waiting list and rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			String expectedOutput = "null";
			System.out.print(ProcessData.getSpecificListing(application1));
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
		
	}
	
	@Test
	void testGetSpecificListing2() {
		
		String msg = "Test getting application in non-empty waiting list and rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
			 application2 = new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
			 expectedDate2 = new Date();
			 application3 = new Application(std3, 1, new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau"));
			 expectedDate3 = new Date();
			 application4 = new Application(std4, 1, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
			 expectedDate4 = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToWaiting(application1);
			ProcessData.addToWaiting(application2);
			ProcessData.addToReject(application3);
			ProcessData.addToReject(application4);
			String expectedOutput = "Waiting List: " + expectedDate1 + "\tS00001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0";
			System.out.print(ProcessData.getSpecificListing(application1));
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testGetSpecificListing3() {
		
		String msg = "Test getting application in non-empty waiting list and rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
			 application2 = new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
			 expectedDate2 = new Date();
			 application3 = new Application(std3, 1, new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau"));
			 expectedDate3 = new Date();
			 application4 = new Application(std4, 1, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
			 expectedDate4 = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToWaiting(application1);
			ProcessData.addToWaiting(application2);
			ProcessData.addToReject(application3);
			ProcessData.addToReject(application4);
			String expectedOutput = "Waiting List: " + expectedDate2 + "\tS00002\tfalse\t2\tHall 1\t8\t4\t10\t10\t0";
			System.out.print(ProcessData.getSpecificListing(application2));
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testGetSpecificListing4() {
		
		String msg = "Test getting application in non-empty waiting list and rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
			 application2 = new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
			 expectedDate2 = new Date();
			 application3 = new Application(std3, 1, new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau"));
			 expectedDate3 = new Date();
			 application4 = new Application(std4, 1, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
			 expectedDate4 = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToWaiting(application1);
			ProcessData.addToWaiting(application2);
			ProcessData.addToReject(application3);
			ProcessData.addToReject(application4);
			String expectedOutput = "Rejected List: " + expectedDate3 + "\tS00003\tfalse\t2\tHall 1\t9\t4\t10\t10\t0";
			System.out.print(ProcessData.getSpecificListing(application3));
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testGetSpecificListing5() {
		
		String msg = "Test getting application in non-empty waiting list and rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
			 application2 = new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
			 expectedDate2 = new Date();
			 application3 = new Application(std3, 1, new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau"));
			 expectedDate3 = new Date();
			 application4 = new Application(std4, 1, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
			 expectedDate4 = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToWaiting(application1);
			ProcessData.addToWaiting(application2);
			ProcessData.addToReject(application3);
			ProcessData.addToReject(application4);
			String expectedOutput = "Rejected List: " + expectedDate4 + "\tS00004\tfalse\t2\tHall 1\t5\t4\t10\t10\t0";
			System.out.print(ProcessData.getSpecificListing(application4));
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testGetSpecificListing6() {
		
		String msg = "Test getting a application that not in waiting and rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate1 = new Date();
			 application2 = new Application(std2, 1, new ScoreComponent("GPA", "3.3", "2", "300", "Cheung Chau"));
			 expectedDate2 = new Date();
			 application3 = new Application(std3, 1, new ScoreComponent("GPA", "4.0", "2", "300", "Cheung Chau"));
			 expectedDate3 = new Date();
			 application4 = new Application(std4, 1, new ScoreComponent("GPA", "2.0", "2", "300", "Cheung Chau"));
			 expectedDate4 = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToWaiting(application1);
			ProcessData.addToWaiting(application2);
			ProcessData.addToReject(application3);
			String expectedOutput = "null";
			System.out.print(ProcessData.getSpecificListing(application4));
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
}

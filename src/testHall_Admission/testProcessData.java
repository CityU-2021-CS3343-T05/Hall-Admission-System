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
		Field field = ProcessData.class.getDeclaredField("waitingList");
		field.setAccessible(true);
		field.set(field,new PriorityQueue<>(new ApplicationDateCompare()));
		
		
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
	
//	@Test
//	void testToString2() {
//		
//		String msg = "Test non-empty fullList";
//		
//		boolean expectedFail = false;
//		boolean actualFail = false;
//		Date expectedDate = null;
//		Student std1 = new Student("001", "Jennifer", "s001", false, 4);
//		Application application1=null;
//		
//		try {
//			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
//			 expectedDate = new Date();
//		} catch (Ex_WrongExamType e) {
//			actualFail = true;
//		}
//		
//		if(!expectedFail) {
//			actualResult.addToList(application1);
//			String expectedOutput="full Hall 1 false " + expectedDate.toString() + "001 false 4 " ;
//			actualResult.toString();
//			assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
//		}
//		assertEquals(expectedFail,actualFail,msg);
//		
//	}

	@Test
	void testGetListing1() {
		
		String msg = "Test empty waiting list and empty rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		Date expectedDate = null;
		Student std1 = new Student("001", "Jennifer", "s001", false, 4);
		Application application1=null;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToWaiting(application1);
			String expectedOutput="Waiting List\n" + expectedDate + "\t001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0\n\nReject List\nEmpty listing";
			System.out.print(ProcessData.getListing());
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testGetListing2() {
		
		String msg = "Test empty waiting list and empty rejected list";
		
		boolean expectedFail = false;
		boolean actualFail = false;
		Date expectedDate = null;
		Student std1 = new Student("001", "Jennifer", "s001", false, 4);
		Application application1=null;
		
		try {
			 application1 = new Application(std1, 1, new ScoreComponent("GPA", "4.3", "2", "300", "Cheung Chau"));
			 expectedDate = new Date();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		
		if(!expectedFail) {
			ProcessData.addToReject(application1);
			String expectedOutput="Waiting List\nEmpty listing\n\nReject List\n" + expectedDate + "\t001\tfalse\t4\tHall 1\t10\t4\t10\t10\t0";
			System.out.print(ProcessData.getListing());
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
		}
		assertEquals(expectedFail,actualFail,msg);
	}

}

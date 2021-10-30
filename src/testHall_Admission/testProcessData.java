package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HallAdmissionSystem.*;


class testProcessData {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
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
		Hall hall1 = new Hall(1, 2, new WeightComponent(1, 1, 1, 1));
		actualResult = new ProcessData(hall1,true);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToString1() {
		
		String msg = "Test empty fullList";
		
		String expectedOutput="";
		actualResult.toString();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testToString2() {
		
		String msg = "Test non-empty fullList";
		
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
			actualResult.addToList(application1);
			String expectedOutput="full 1 ";
			actualResult.toString();
			assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
		}
		assertEquals(expectedFail,actualFail,msg);
		
	}

	@Test
	void testGetListing() {
		fail("Not yet implemented");
	}

}

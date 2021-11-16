package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import HallAdmissionSystem.Hall;
import HallAdmissionSystem.HallSystem;
import HallAdmissionSystem.ScoreComponent;
import HallAdmissionSystem.Student;

class testHallSystem {
	
	HallSystem hs;
	Student std1, std2, std3;
	ScoreComponent sc;
	Date expectedDate;
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		Field instance = HallSystem.class.getDeclaredField("instance");
		instance.setAccessible(true);
		instance.set(null, null);
		
		std1 = new Student("S00001", "Jennifer", "Passw0rd", false, 4);
		std2 = new Student("S00002", "John", "Passw0rd", false, 2);
		std3 = new Student("S00003", "Charles", "Passw0rd", true, 1);
		sc = new ScoreComponent("DSE", "5**", "7", "211", "Tin Shui Wai");
		hs = HallSystem.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setOut(standardOut);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testHallSystem_getHall.csv")
	void testGetHall(int input,boolean expectedExist, int expectedHallNumber, String msg) {
		Hall actualHall = hs.getHall(input);
		if(expectedExist) {
			assertNotNull(actualHall);
			int actualHallNumber = actualHall.getHallNumber();
			assertEquals(expectedHallNumber,actualHallNumber,msg);
		}else {
			assertNull(actualHall);
		}
	}
	
	@Test 
	void testViewHallResult(){
		String msg = "Test view all hall";
		
		String expectedOutput = "================== Hall Listing ==================\r\nHall 1Hall 2Hall 3\r\n==================================================\r\n";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewHallList();
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test 
	void testCreateApplication1() {
		String msg = "Test create new Application";
		
		hs.createApplication(std1,1,sc);
		expectedDate = new Date();
		String expectedOutput = "================ View Application ================\r\n" + expectedDate + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t0\r\n==================================================\r\n";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewApplication(std1);
		
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testCreateApplication2() {
		String msg = "Test create new Application that student create an applcation before";
		
		hs.createApplication(std1,2,sc);
		expectedDate = new Date();
		String expectedOutput = "================ View Application ================\r\n" + expectedDate + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t0\r\n==================================================\r\n";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewApplication(std1);
		
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testViewApplication1() {
		String msg = "Test find specific application";
		hs.createApplication(std1,2,sc);
		expectedDate = new Date();
		String expectedOutput = "";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewApplication(std1);
		
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testViewApplication2() {
		String msg = "Test find specific application";
		
		String expectedOutput = "";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewApplication(std2);
		
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testViewAllApplication1() {
		String msg = "Test view all applications with no application";
		
		String expectedOutput = "=================== Application ==================\r\n\r\n==================================================\r\n";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewAllApplication();
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testViewAllApplication2() {
		String msg = "Test view all applications";
		
		hs.createApplication(std1, 1, sc);
		expectedDate = new Date();
		String expectedOutput = "=================== Application ==================\r\n"+expectedDate+"\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t0\n\r\n==================================================\r\n";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewAllApplication();
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testViewSpecificResult1() {
		String msg = "Test find application status before process applcation";
		
		String expectedOutput = "================= Detailed Result ================\r\nWatiting to process\r\n==================================================\r\n";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std1);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testViewSpecificResult2() {
		String msg = "Test find application status after process applcation";
		
		String expectedOutput = "================= Detailed Result ================\r\nCurrent Appication Status: null\r\n==================================================\r\n";
		hs.processApplication();
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std1);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testViewSpecificResult3() {
		String msg = "Test find application status after process applcation";
		
		String expectedOutput = "================= Detailed Result ================\r\nCurrent Appication Status: Reject list\r\n==================================================\r\n";
		hs.createApplication(std1, 1, sc);
		hs.processApplication();
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std1);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testViewSpecificResult4() {
		String msg = "Test find application status after process applcation";
		
		String expectedOutput = "================= Detailed Result ================\r\nCurrent Appication Status: Admited to Hall 1\r\n==================================================\r\n";
		hs.createApplication(std2, 1, sc);
		hs.processApplication();
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std2);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testViewSpecificResult5() {
		String msg = "Test find application status after process applcation";
		
		String expectedOutput = "================= Detailed Result ================\r\nCurrent Appication Status: Admited to Hall 2\r\n==================================================\r\n";
		hs.createApplication(std3, 2, sc);
		hs.processApplication();
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std3);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}
	
	@Test
	void testChangeHallSetting1() {
		String msg = "Test changing hall weight setting";
		
		int[] expectedArray = {1,2,3,4};
		int expectedCapacity = 10;
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.changeHallSetting(1, 10, 1, 2, 3, 4);
		Hall actualResult = hs.getHall(1);
		int[] actualArray = actualResult.getHallWeightings();
		int actualCapacity = actualResult.getNumberofAcceptance();
		assertEquals(expectedCapacity,actualCapacity,msg);
		assertTrue(Arrays.equals(expectedArray,actualArray),msg);
	}
	
	@Test
	void testCreateNewHall() {
		String msg = "Test create a new hall";
		
		int expectedHallNumber = 4;
		int expectedCapacity = 10;
		int[] expectedArray = {1,1,1,1};
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.createNewHall(4, 10, 1, 1, 1, 1);
		Hall actualResult = hs.getHall(4);
		int actualHallNumber = actualResult.getHallNumber();
		int actualCapacity = actualResult.getNumberofAcceptance();
		int[] actualArray = actualResult.getHallWeightings();
		assertNotNull(actualResult);
		assertEquals(expectedHallNumber,actualHallNumber,msg);
		assertEquals(expectedCapacity,actualCapacity,msg);
		assertTrue(Arrays.equals(expectedArray,actualArray),msg);
	}
	
}

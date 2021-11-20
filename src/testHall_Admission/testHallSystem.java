package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.PriorityQueue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import HallAdmissionSystem.ApplicationDateCompare;
import HallAdmissionSystem.Hall;
import HallAdmissionSystem.HallSystem;
import HallAdmissionSystem.ProcessResult;
import HallAdmissionSystem.ScoreComponent;
import HallAdmissionSystem.Student;

class testHallSystem {
	
	HallSystem hs;
	Student std1, std2, std3, std4, std5, std6, std7, std8, std9, std10, std11;
	ScoreComponent sc1, sc2, sc3;
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
		
		Field rejectedList = ProcessResult.class.getDeclaredField("rejectedList");
		rejectedList.setAccessible(true);
		rejectedList.set(null, new ArrayList<>());
		
		Field waitingList = ProcessResult.class.getDeclaredField("waitingList");
		waitingList.setAccessible(true);
		waitingList.set(null, new PriorityQueue<>(new ApplicationDateCompare()));
		
		std1 = new Student("S00001", "Jennifer", "Passw0rd", false, 4);
		std2 = new Student("S00002", "John", "Passw0rd", false, 2);
		std3 = new Student("S00003", "Charles", "Passw0rd", true, 1);
		std4 = new Student("S00004", "Tom", "Passw0rd", false, 2);
		std5 = new Student("S00005", "Mary", "Passw0rd", false, 1);
		std6 = new Student("S00006", "Chris", "Passw0rd", true, 2);
		std7 = new Student("S00007", "Alvin", "Passw0rd", true, 4);		
		std8 = new Student("S00008", "Ralph", "Passw0rd", false, 2);
		std9 = new Student("S00009", "John", "Passw0rd", false, 2);
		std10 = new Student("S00010", "John", "Passw0rd", false, 2);
		std11 = new Student("S00011", "John", "Passw0rd", false, 2);
		sc1 = new ScoreComponent("GPA", "4.3", "7", "211", "Tin Shui Wai");
		sc2 = new ScoreComponent("GPA", "3", "2", "150", "Wong Chuk Hang");
		sc3 = new ScoreComponent("DSE", "5", "5", "100", "Lamma Island");
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
	void testViewHallList(){
		String msg = "Test view all hall";
		
		String expectedOutput = "================== Hall Listing ==================\r\nHall 1Hall 2Hall 3\r\n==================================================";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewHallList();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testViewApplication1() {
		String msg = "Test find specific application";
		hs.createApplication(std1,2,sc1);
		Date expectedDate = new Date();
		String expectedOutput = "================ View Application ================\r\n" + expectedDate + "\tS00001\tfalse\tYear 4\tHall 2\t10\t10\t10\t7\t0\r\n==================================================";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewApplication(std1);
		
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim().trim(),msg);
	}
	
	@Test
	void testViewApplication2() {
		String msg = "Test find specific application";
		
		String expectedOutput = "";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewApplication(std2);
		
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim().trim(),msg);
	}
	
	@Test
	void testViewAllApplication1() {
		String msg = "Test view all applications with no application";
		
		String expectedOutput = "=================== Application ==================\r\n\r\n==================================================";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewAllApplication();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testViewAllApplication2() {
		String msg = "Test view all applications";
		
		hs.createApplication(std1, 1, sc1);
		Date expectedDate1 = new Date();
		String expectedOutput = "=================== Application ==================\r\n" + expectedDate1 + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t0\n\r\n==================================================";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewAllApplication();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testViewAllApplication3() {
		String msg = "Test view all applications";
		
		hs.createApplication(std1, 1, sc1);
		Date expectedDate1 = new Date();
		hs.createApplication(std2, 1, sc1);
		Date expectedDate2 = new Date();
		String expectedOutput = "=================== Application ==================\r\n" + expectedDate1 + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t0\n" + expectedDate2 + "\tS00002\tfalse\tYear 2\tHall 1\t10\t10\t10\t7\t0\n\r\n" + "==================================================";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewAllApplication();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testViewSpecificResult1() {
		String msg = "Test find application status before process application";
		
		String expectedOutput = "================= Detailed Result ================\r\nWatiting to process\r\n==================================================";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std1);
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testViewSpecificResult2() {
		String msg = "Test find not existing application status after process application";
		
		String expectedOutput = "================= Detailed Result ================\r\nCurrent Appication Status: null\r\n==================================================";
		hs.processApplication();
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std1);
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testViewSpecificResult3() {
		String msg = "Test find application status after process application";
		
		String expectedOutput = "================= Detailed Result ================\r\nCurrent Appication Status: Reject list\r\n==================================================";
		hs.createApplication(std1, 1, sc1);
		hs.processApplication();
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std1);
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testViewSpecificResult4() {
		String msg = "Test find application status after process applcation";
		
		String expectedOutput = "================= Detailed Result ================\r\nCurrent Appication Status: Admitted to Hall 1\r\n==================================================";
		hs.createApplication(std2, 1, sc1);
		hs.processApplication();
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std2);
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testViewSpecificResult5() {
		String msg = "Test find application status after process applcation";
		
		String expectedOutput = "================= Detailed Result ================\r\nCurrent Appication Status: Admitted to Hall 2\r\n==================================================";
		hs.createApplication(std3, 2, sc1);
		hs.processApplication();
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewSpecificResult(std3);
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testChangeHallSetting() {
		String msg = "Test changing hall weight setting";
		
		int[] expectedArray = {1,2,3,4};
		int expectedCapacity = 10;
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
	
	@Test 
	void testRunProcess1() {
		String msg = "Test 3 non-local applications apply to the same hall. 1 of the application will go waiting list and then admit to other hall";
		
		hs.createApplication(std2, 1, sc1);
		Date expectedDate1 = new Date();
		hs.createApplication(std4, 1, sc2);
		Date expectedDate2 = new Date();
		hs.createApplication(std5, 1, sc3);
		Date expectedDate3 = new Date();
		hs.processApplication();
		String expectedOutput = "=================== All Result ===================\r\nHall 1\nAdmitted        " + expectedDate1 + "\tS00002\tfalse\tYear 2\tHall 1\t10\t10\t10\t7\t37\nAdmitted        " + expectedDate3 + "\tS00005\tfalse\tYear 1\tHall 1\t5\t10\t2\t10\t27\nHall 2\nAdmitted        " + expectedDate2 + "\tS00004\tfalse\tYear 2\tHall 1\t7\t4\t4\t5\t20\nHall 3\n\nWaiting List is empty \n\nReject List is empty \n\r\n==================================================";
		
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewResult();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test 
	void testRunProcess2() {
		String msg = "Test 2 non-local applications and 1 local application apply to the same hall. The local application will go to rejected list";
		
		hs.createApplication(std2, 1, sc1);
		Date expectedDate1 = new Date();
		hs.createApplication(std3, 1, sc2);
		Date expectedDate2 = new Date();
		hs.createApplication(std5, 1, sc3);
		Date expectedDate3 = new Date();
		hs.processApplication();
		String expectedOutput = "=================== All Result ===================\r\nHall 1\nAdmitted        " + expectedDate1 + "\tS00002\tfalse\tYear 2\tHall 1\t10\t10\t10\t7\t37\nAdmitted        " + expectedDate3 + "\tS00005\tfalse\tYear 1\tHall 1\t5\t10\t2\t10\t27\nHall 2\nHall 3\n\nWaiting List is empty \n\nReject List     " + expectedDate2 + "\tS00003\ttrue\tYear 1\tHall 1\t7\t4\t4\t5\t20\n\r\n==================================================";
		
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewResult();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test 
	void testRunProcess3() {
		String msg = "Test 3 non-local applications and 1 local application apply to the same hall. The non-local application applied from Year 4 student and the local application will go to rejected list";
		
		hs.createApplication(std2, 1, sc1);
		Date expectedDate1 = new Date();
		hs.createApplication(std3, 1, sc2);
		Date expectedDate2 = new Date();
		hs.createApplication(std5, 1, sc3);
		Date expectedDate3 = new Date();
		hs.createApplication(std1, 1, sc1);
		Date expectedDate4 = new Date();
		hs.processApplication();
		String expectedOutput = "=================== All Result ===================\r\nHall 1\nAdmitted        " + expectedDate1 + "\tS00002\tfalse\tYear 2\tHall 1\t10\t10\t10\t7\t37\nAdmitted        " + expectedDate3 + "\tS00005\tfalse\tYear 1\tHall 1\t5\t10\t2\t10\t27\nHall 2\nHall 3\n\nWaiting List is empty \n\nReject List     " + expectedDate4 + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t37\nReject List     " + expectedDate2 + "\tS00003\ttrue\tYear 1\tHall 1\t7\t4\t4\t5\t20\n\r\n==================================================";
		
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewResult();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test 
	void testRunProcess4() {
		String msg = "Test 3 local applications apply to the same hall. The local application which have the lowest score will go to rejected list";
		
		hs.createApplication(std3, 1, sc1);
		Date expectedDate1 = new Date();
		hs.createApplication(std6, 1, sc2);
		Date expectedDate2 = new Date();
		hs.createApplication(std7, 1, sc3);
		Date expectedDate3 = new Date();
		hs.processApplication();
		String expectedOutput = "=================== All Result ===================\r\nHall 1\nAdmitted        " + expectedDate1 +"\tS00003\ttrue\tYear 1\tHall 1\t10\t10\t10\t7\t37\nAdmitted        " + expectedDate3 + "\tS00007\ttrue\tYear 4\tHall 1\t5\t10\t2\t10\t27\nHall 2\nHall 3\n\nWaiting List is empty \n\nReject List     " + expectedDate2 + "\tS00006\ttrue\tYear 2\tHall 1\t7\t4\t4\t5\t20\n\r\n==================================================";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewResult();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test 
	void testRunProcess5() {
		String msg = "Test 3 local applications apply to the different halls. All application can admit to their preference hall";
		
		hs.createApplication(std3, 1, sc1);
		Date expectedDate1 = new Date();
		hs.createApplication(std6, 2, sc2);
		Date expectedDate2 = new Date();
		hs.createApplication(std7, 3, sc3);
		Date expectedDate3 = new Date();
		hs.processApplication();
		String expectedOutput = "=================== All Result ===================\r\nHall 1\nAdmitted        " + expectedDate1 +"\tS00003\ttrue\tYear 1\tHall 1\t10\t10\t10\t7\t37\nHall 2\nAdmitted        " + expectedDate2 + "\tS00006\ttrue\tYear 2\tHall 2\t7\t4\t4\t5\t0\nHall 3\nAdmitted        " + expectedDate3 + "\tS00007\ttrue\tYear 4\tHall 3\t5\t10\t2\t10\t0\n\nWaiting List is empty \n\nReject List is empty \n\r\n==================================================";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewResult();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test 
	void testRunProcess6() {
		String msg = "Test 4 non-local applications apply to the same hall.";
		
		
		hs.createApplication(std2, 1, sc1);
		Date expectedDate1 = new Date();
		hs.createApplication(std4, 1, sc1);
		Date expectedDate2 = new Date();
		hs.createApplication(std5, 1, sc1);
		Date expectedDate3 = new Date();
		hs.createApplication(std8, 1, sc1);
		Date expectedDate4 = new Date();
		hs.createApplication(std9, 1, sc1);
		Date expectedDate5 = new Date();
		hs.createApplication(std10, 1, sc1);
		Date expectedDate6 = new Date();
		hs.createApplication(std11, 1, sc1);
		Date expectedDate7 = new Date();
		hs.processApplication();
		String expectedOutput = "=================== All Result ===================\r\nHall 1\nAdmitted        " + expectedDate1 +"\tS00003\ttrue\tYear 1\tHall 1\t10\t10\t10\t7\t37\nHall 2\nAdmitted        " + expectedDate2 + "\tS00006\ttrue\tYear 2\tHall 2\t7\t4\t4\t5\t0\nHall 3\nAdmitted        " + expectedDate3 + "\tS00007\ttrue\tYear 4\tHall 3\t5\t10\t2\t10\t0\n\nWaiting List is empty \n\nReject List is empty \n\r\n==================================================";
		System.setOut(new PrintStream(outputStreamCaptor));
		hs.viewResult();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
}

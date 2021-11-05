package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HallAdmissionSystem.Administrator;
import HallAdmissionSystem.Display;
import HallAdmissionSystem.Ex_WrongExamType;
import HallAdmissionSystem.HallSystem;
import HallAdmissionSystem.ScoreComponent;
import HallAdmissionSystem.Student;

class testCityU {

	Administrator cityu;
	Student std1;
	HallSystem hs;
	private final InputStream standardIn = System.in;
	private final PrintStream standardOut = System.out;
	private ByteArrayInputStream inputStreamCaptor;
	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	Date expectedDate;
	ScoreComponent sc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	private void provideInput(String data){
		inputStreamCaptor = new ByteArrayInputStream(data.getBytes());
		System.setIn(inputStreamCaptor);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		cityu = new Administrator("CityU","Passw0rd");
		System.setOut(new PrintStream(outputStreamCaptor));
		
		std1 = new Student("S00001", "Jennifer", "Passw0rd", false, 4);
		sc = new ScoreComponent("DSE", "5**", "7", "211", "Tin Shui Wai");
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(standardIn);
		System.setOut(standardOut);
	}
	
	@Test
	void testmainManual1() {
		
		String msg = "Test Create Hall";
		String input = "1\n4\n4\n1\n1\n1\n1\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Hall Name\r\n> Number of Acceptance\r\n> Academic Weighting\r\n> Leadership Weighting\r\n> ECA Weighting\r\n> Location Weighting\r\n> ================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		hs = HallSystem.getInstance();
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();			
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testmainManual2() {
		String msg = "Test Create Hall";
		String input = "2\n3\n2\n1\n1\n1\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Hall Name\r\n> Academic Weighting\r\n> Leadership Weighting\r\n> ECA Weighting\r\n> Location Weighting\r\n> ================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		hs = HallSystem.getInstance();
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();			
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testmainManual3() {
		String msg = "Test hall listing";
		String input = "3\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> =================== Hall Listing ===================\r\nHall 1Hall 2Hall 3\r\n==================================================\r\n================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		hs = HallSystem.getInstance();
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testmainManual4a() {
		String msg = "Test hall listing";
		String input = "4\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ==================== Application ===================\r\n\r\n==================================================\r\n================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		hs = HallSystem.getInstance();
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testmainManual4b() {
		String msg = "Test hall listing";
		String input = "4\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		hs = HallSystem.getInstance();
		hs.createApplication(std1, 1, sc);
		expectedDate = new Date();
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ==================== Application ===================\r\n" + expectedDate + "\tS00001\tfalse\t4\tHall 1\t10\t10\t10\t7\t0\n\r\n==================================================\r\n================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}
	
	@Test
	void testmainManual5() {
		String msg = "Test Process Application";
		String input = "5\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================== Done processing =================\r\n================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		hs = HallSystem.getInstance();
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();		
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}

	@Test
	void testmainManual6() {
		String msg = "Test Change Username";
		String input = "6\nKongU\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedUsername="KongU";
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================== Change Username =================\r\nInput the new username:\r\n==================================================\r\n> ================== Student Manuel ==================\r\nWelcome, KongU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		hs = HallSystem.getInstance();
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();		
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
			String actualUsername = cityu.getUserName();
			assertEquals(expectedUsername,actualUsername,msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}

	@Test
	void testmainManual7() {
		String msg = "Test Change Password";
		String input = "7\nAbcd1234\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedPassword="Abcd1234";
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================== Change Password =================\r\nInput the new password:\r\n==================================================\r\n> ================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		hs = HallSystem.getInstance();
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();			
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
			String actualPassword = cityu.getUserPwd();
			assertEquals(expectedPassword,actualPassword,msg);
		}
		assertEquals(expectedFail,actualFail,msg);	
	}
	
	@Test
	void testmainManual8() {
		String msg = "Test CityU logout";
		String input="8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		hs = HallSystem.getInstance();
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();	
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);	
	}
	
	@Test
	void testmainManual9() {
		String msg = "Test enter other input";
		String input="9\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>  Wrong command, please enter again!\r\n================== Student Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		hs = HallSystem.getInstance();
		try {
			provideInput(input);
			Display.createScanner();
			cityu.mainManual();
			Display.closeScanner();	
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		}
		assertEquals(expectedFail,actualFail,msg);	
	}

}

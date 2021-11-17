package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HallAdmissionSystem.Administrator;
import HallAdmissionSystem.Display;
import HallAdmissionSystem.HallSystem;
import HallAdmissionSystem.ScoreComponent;
import HallAdmissionSystem.Student;

class testAdministrator {

	Administrator admin;
	Student std1,std2;
	HallSystem hs;
	private final InputStream standardIn = System.in;
	private final PrintStream standardOut = System.out;
	private ByteArrayInputStream inputStreamCaptor;
	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
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
		
		Field instance = HallSystem.class.getDeclaredField("instance");
		instance.setAccessible(true);
		instance.set(null, null);
		
		hs = HallSystem.getInstance();
		
		admin = new Administrator("CityU","Passw0rd");
		
		std1 = new Student("S00001", "Jennifer", "Passw0rd", false, 4);
		std2 = new Student("S00002", "Charles","Passw0rd",true,1);
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
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> New Hall Number\r\n> Number of Acceptance\r\n> Academic Weighting\r\n> Leadership Weighting\r\n> Eca Weighting\r\n> Location Weighting\r\n> ================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();			
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testmainManual2() {
		String msg = "Test Create Hall";
		String input = "2\n3\n2\n2\n1\n1\n1\n8";
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Hall Number\r\n> New Academic Weighting\r\n> New Leadership Weighting\r\n> New Eca Weighting\r\n> New Location Weighting\r\n> New Number of Acceptance\r\n> ================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();			
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testmainManual3() {
		String msg = "Test hall listing";
		String input = "3\n8";
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================== Hall Listing ==================\r\nHall 1Hall 2Hall 3\r\n==================================================\r\n================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testmainManual4a() {
		String msg = "Test all application";
		String input = "4\n8";
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> =================== Application ==================\r\n\r\n==================================================\r\n================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testmainManual4b() {
		String msg = "Test all application";
		String input = "4\n8";
		hs.createApplication(std1, 1, sc);
		Date expectedDate = new Date();
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> =================== Application ==================\r\n" + expectedDate + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t0\n\r\n==================================================\r\n================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testmainManual4c() {
		String msg = "Test all application";
		String input = "4\n8";
		hs.createApplication(std1, 1, sc);
		Date expectedDate1 = new Date();
		hs.createApplication(std2, 1, sc);
		Date expectedDate2 = new Date();
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> =================== Application ==================\r\n" + expectedDate1 + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t0\n" + expectedDate1 + "\tS00002\ttrue\tYear 1\tHall 1\t10\t10\t10\t7\t0\n\r\n==================================================\r\n================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testmainManual5a() {
		String msg = "Test Process Application";
		String input = "5\n8";
		hs.createApplication(std1, 1, sc);
		Date expectedDate = new Date();
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> " + expectedDate + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t37\r\n================= Done processing ================\r\n================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();		
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testmainManual5b() {
		String msg = "Test Process Application";
		String input = "5\n8";
		hs.createApplication(std2, 1, sc);
		Date expectedDate = new Date();
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> " + expectedDate + "\tS00002\ttrue\tYear 1\tHall 1\t10\t10\t10\t7\t37\r\n================= Done processing ================\r\n================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();		
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}

	@Test
	void testmainManual6() {
		String msg = "Test Change Username";
		String input = "6\nKongU\n8";
		String expectedUsername="KongU";
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================= Change Username ================\r\nInput the new username:\r\n==================================================\r\n> ================== Admin Manuel ==================\r\nWelcome, KongU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();		
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		String actualUsername = admin.getUserName();
		assertEquals(expectedUsername,actualUsername,msg);
	}

	@Test
	void testmainManual7() {
		String msg = "Test Change Password";
		String input = "7\nAbcd1234\n8";
		String expectedPassword="Abcd1234";
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================= Change Password ================\r\nInput the new password:\r\n==================================================\r\n> ================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();			
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		String actualPassword = admin.getUserPwd();
		assertEquals(expectedPassword,actualPassword,msg);	
	}
	
	@Test
	void testmainManual8() {
		String msg = "Test CityU logout";
		String input="8";
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();	
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testmainManual9() {
		String msg = "Test enter other input";
		String input="9\n8";
		String expectedOutput = "================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Wrong command, please enter again!\r\n================== Admin Manuel ==================\r\nWelcome, CityU\nSelect the functions:\n[1] Create Hall\n[2] Change Hall Setting\n[3] View Hall Listing\n[4] View Applications\n[5] Process Applications\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		admin.mainManual();
		Display.closeScanner();	
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}

}

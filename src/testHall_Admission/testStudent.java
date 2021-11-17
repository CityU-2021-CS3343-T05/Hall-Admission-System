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

import HallAdmissionSystem.Display;
import HallAdmissionSystem.HallSystem;
import HallAdmissionSystem.ScoreComponent;
import HallAdmissionSystem.Student;

class testStudent {

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
		
		Field instance = HallSystem.class.getDeclaredField("instance");
		instance.setAccessible(true);
		instance.set(null, null);
		
		hs = HallSystem.getInstance();
		std1 = new Student("S00001", "Jennifer", "Passw0rd", false, 4);
		sc = new ScoreComponent("DSE", "5**", "7", "211", "Tin Shui Wai");
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(standardIn);
		System.setOut(standardOut);
	}
	
	@Test
	void testMainManual1a() {
		String msg = "Test View Result";
		
		String input = "1\n1\nDSE\n5**\n7\n211\nTin Shui Wai\n8";
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Preferenced Hall\r\n> Wrong input, please enter Dse or GPA!\r\n> Academic Type\r\n> Academic Score\r\n> Wrong input, please enter correct score!\r\n> Leadership Times\r\n> ECA Hours\r\n> Lived Location\r\n> ================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testMainManual1b() {
		String msg = "Test View Result";
		
		String input = "1\n1\ngpaaa\nDse\n4.3\n5**\n7\n211\nTin Shui Wai\n8";
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Preferenced Hall\r\n> Academic Type\r\n> Academic Score\r\n> Leadership Times\r\n> ECA Hours\r\n> Lived Location\r\n> ================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testMainManual2a() {
		String msg = "Test Delete Application and then choose y to not Delete the application";
		
		String input = "2\ny\n8";
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Are you sure to delete application (y/n)\r\n> Application Deleted\r\n================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		hs.createApplication(std1, 1, sc);
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();		
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testMainManual2b() {
		String msg = "Test Delete Application and then choose n to not Delete the application";
		
		String input = "2\nn\n8";
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Are you sure to delete application (y/n)\r\n> Application Not Deleted\r\n================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		hs.createApplication(std1, 1, sc);
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();			
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testMainManual3() {
		String msg = "Test View application";
		
		String input = "3\n8";	
		hs.createApplication(std1, 1, sc);
		expectedDate = new Date();
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================ View Application ================\r\n" + expectedDate + "\tS00001\tfalse\tYear 4\tHall 1\t10\t10\t10\t7\t0\r\n==================================================\r\n================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();			
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testMainManual4() {
		String msg = "Test hall listing";
		String input = "4\n8";
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================== Hall Listing ==================\r\nHall 1Hall 2Hall 3\r\n==================================================\r\n================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();			
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testMainManual5() {
		String msg = "Test View Result";
		String input = "5\n8";
		hs.createApplication(std1, 1, sc);
		hs.processApplication();
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================= Detailed Result ================\r\nCurrent Appication Status: Reject list\r\n==================================================\r\n================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();			
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testMainManual6() {
		String msg = "Test Change Username";
		String input = "6\nJohn\n8";
		String expectedUsername="John";
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================= Change Username ================\r\nInput the new username:\r\n==================================================\r\n> ================= Student Manual =================\r\nWelcome, John\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		String actualUsername = std1.getUserName();
		assertEquals(expectedUsername,actualUsername,msg);	
	}

	@Test
	void testMainManual7() {
		String msg = "Test Change Password";
		String input = "7\nAbcd1234\n8";
		String expectedPassword="Abcd1234";
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================= Change Password ================\r\nInput the new password:\r\n==================================================\r\n> ================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();			
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
		String actualPassword = std1.getUserPwd();
		assertEquals(expectedPassword,actualPassword,msg);
	}
	
	@Test
	void testMainManual8() {
		String msg = "Test student logout";
		String input="8";
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();	
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}
	
	@Test
	void testMainManual9() {
		String msg = "Test enter other input";
		String input="9\n8";
		String expectedOutput = "================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Wrong command, please enter again!\r\n================= Student Manual =================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delete Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n>";
		System.setOut(new PrintStream(outputStreamCaptor));
		provideInput(input);
		Display.createScanner();
		std1.mainManual();
		Display.closeScanner();	
		assertEquals(expectedOutput,outputStreamCaptor.toString().trim(),msg);
	}

}

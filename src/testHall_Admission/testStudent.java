package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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

import HallAdmissionSystem.ApplicationDateCompare;
import HallAdmissionSystem.Display;
import HallAdmissionSystem.Ex_WrongExamType;
import HallAdmissionSystem.HallSystem;
import HallAdmissionSystem.ProcessData;
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
		
		std1 = new Student("S00001", "Jennifer", "Passw0rd", false, 4);
		System.setOut(new PrintStream(outputStreamCaptor));
		
		hs = HallSystem.getInstance();
		sc = new ScoreComponent("DSE", "5**", "7", "211", "Tin Shui Wai");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(standardIn);
		System.setOut(standardOut);
	}
	
	@Test
	void testMainManual1() {
		String msg = "Test View Result";
		String input = "1\r\n1\r\nDSE\r\n5**\r\n7\r\n211\r\nTin Shui Wai\r\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Preferenced Hall\r\n> Academic Type\r\n> Academic Score\r\n> Leadership Times\r\n> ECA Hours\r\n> Lived Location\r\n> ================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std1.mainManual();
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
	void testMainManual2a() {
		String msg = "Test delate Application and then choose y to not delate the application";
		String input = "2\r\ny\r\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Are you sure to delate application (y/n)\r\n> Application Delated\r\n================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std1.mainManual();
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
	void testMainManual2b() {
		String msg = "Test delate Application and then choose n to not delate the application";
		String input = "2\r\nn\r\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Are you sure to delate application (y/n)\r\n> Application Not Delated\r\n================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std1.mainManual();
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
	void testMainManual3() {
		String msg = "Test View application";
		String input = "3\r\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		Student std2 = new Student("S00002", "Jennifer", "Passw0rd", false, 4);
		hs.createApplication(std2, 1, sc);
		expectedDate = new Date();
		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================= View Application =================\r\n" + expectedDate + "\tS00002\tfalse\t4\tHall 1\t10\t10\t10\t7\t0\r\n==================================================\r\n================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std2.mainManual();
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
	void testMainManual4() {
		String msg = "Test hall listing";
		String input = "4\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> =================== Hall Listing ===================\r\nHall 1Hall 2Hall 3\r\n==================================================\r\n================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std1.mainManual();
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
	void testMainManual5() {
		String msg = "Test View Result";
		String input = "5\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		
		hs.processApplication();

		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================== Change Username =================\r\nInput the new username:\r\n==================================================\r\n> ================== Student Manual ==================\r\nWelcome, John\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std1.mainManual();
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
	void testMainManual6() {
		String msg = "Test Change Username";
		String input = "6\nJohn\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedUsername="John";
		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================== Change Username =================\r\nInput the new username:\r\n==================================================\r\n> ================== Student Manual ==================\r\nWelcome, John\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std1.mainManual();
			Display.closeScanner();		
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
			String actualUsername = std1.getUserName();
			assertEquals(expectedUsername,actualUsername,msg);
		}
		assertEquals(expectedFail,actualFail,msg);
	}

	@Test
	void testMainManual7() {
		String msg = "Test Change Password";
		String input = "7\nAbcd1234\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedPassword="Abcd1234";
		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================== Change Password =================\r\nInput the new password:\r\n==================================================\r\n> ================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std1.mainManual();
			Display.closeScanner();			
		} catch (Ex_WrongExamType e) {
			actualFail = true;
		}
		if(!expectedFail) {
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
			String actualPassword = std1.getUserPwd();
			assertEquals(expectedPassword,actualPassword,msg);
		}
		assertEquals(expectedFail,actualFail,msg);	
	}
	
	@Test
	void testMainManual8() {
		String msg = "Test student logout";
		String input="8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std1.mainManual();
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
	void testMainManual9() {
		String msg = "Test enter other input";
		String input="9\n8";
		boolean actualFail = false;
		boolean expectedFail = false;
		String expectedOutput = "================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> Wrong command, please enter again!\r\n================== Student Manual ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
		try {
			provideInput(input);
			Display.createScanner();
			std1.mainManual();
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

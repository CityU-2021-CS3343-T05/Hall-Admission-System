package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HallAdmissionSystem.Ex_WrongExamType;
import HallAdmissionSystem.Student;

class testStudent {

	Student std1;
	private final InputStream standardIn = System.in;
	private final PrintStream standardOut = System.out;
	private ByteArrayInputStream inputStreamCaptor;
	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
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
		std1 = new Student("001", "Jennifer", "s001", false, 4);
		//System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(standardIn);
		System.setOut(standardOut);
	}

	@Test
	void testMainManuel7() {
		try {
			String msg = "Test Change Password";
			String input = "7\naaa";
			String expectedOutput = "================== Student Manuel ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ================== Change Password =================\r\nInput the new password:\r\n==================================================\r\n> ";
			provideInput(input);
			System.out.println(standardIn);


			std1.mainManuel();
			
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
			
			
		} catch (Ex_WrongExamType e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	void testMainManuel8() {
		try {
			String msg = "Test student logout";
			String input="8";
			String expectedOutput = "================== Student Manuel ==================\r\nWelcome, Jennifer\nSelect the functions:\n[1] Create Application\n[2] Delate Application\n[3] View Application\n[4] View Hall List\n[5] View Result\n[6] Change Username\n[7] Change Password\n[8] Logout\n\r\n==================================================\r\n> ";
			provideInput(input);
			
			std1.mainManuel();
			
			assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
			
			
			
		} catch (Ex_WrongExamType e) {
			
			e.printStackTrace();
		}
	}

}

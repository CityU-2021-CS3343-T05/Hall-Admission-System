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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HallAdmissionSystem.Account;
import HallAdmissionSystem.Administrator;
import HallAdmissionSystem.Display;
import HallAdmissionSystem.LoginPortal;
import HallAdmissionSystem.Student;

class testLoginPortal {

	LoginPortal loginPortal;
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
		System.setOut(new PrintStream(outputStreamCaptor));
		loginPortal = LoginPortal.getInstance();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(standardIn);
		System.setOut(standardOut);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testLogin.csv")
	void testLogin2(String inputString, String expectedSid, boolean expectedIsStudent, boolean expectedIsAdmin, String msg) {
		
		String input = inputString.replace("|", "\n");
		
		provideInput(input);
		Display.createScanner();
		Account actualAc = loginPortal.login();
		Display.closeScanner();
		
		assertEquals(expectedIsStudent, actualAc instanceof Student,msg);
		assertEquals(expectedIsAdmin, actualAc instanceof Administrator,msg);
		
		if(expectedIsStudent) {
			Student std = (Student)actualAc;
			String actualSid = std.getSid(); 
			assertEquals(expectedSid,actualSid,msg);
		}
		assertNotNull(actualAc,msg);
	}

}

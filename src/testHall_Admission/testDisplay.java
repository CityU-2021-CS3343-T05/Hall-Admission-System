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

import HallAdmissionSystem.*;

class testDisplay {

	private final InputStream standardIn = System.in;
	private final PrintStream standardOut = System.out;
	private ByteArrayInputStream inputStreamCaptor;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
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
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(standardIn);
		System.setOut(standardOut);
	}

	@Test
	void testRunDisplay1() {
		String msg = "Test input is required";
		
		String title = "Test runDisplay";
		String content = "Input is required";
		boolean haveInput = true;
		String input = "input";
		String expectedResult = "input";
		String expectedOutput = "================= Test runDisplay ================\r\nInput is required\r\n==================================================\r\n> ";
		provideInput(input);
		Display.createScanner();
		String actualResult = Display.runDisplay(title, content, haveInput);
		Display.closeScanner();
		assertNotNull(actualResult);
		assertEquals(expectedResult,actualResult,msg);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		
	}
	
	@Test
	void testRunDisplay2() {
		String msg = "Test input is not required";
		
		String title = "Test runDisplay";
		String content = "Input is required";
		boolean haveInput = false;
		String expectedOutput = "================= Test runDisplay ================\r\nInput is required\r\n==================================================\r\n";
		String actualResult = Display.runDisplay(title, content, haveInput);
		assertNull(actualResult);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
		
	}

}

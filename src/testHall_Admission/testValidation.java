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

import HallAdmissionSystem.Display;
import HallAdmissionSystem.Validation;

class testValidation {
	
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
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(standardIn);
		System.setOut(standardOut);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testGetHallInput.csv")
	void testGetHallInput(String input,int expectedResult, String expectedOutput, String msg) {
		input = input.replace("|", "\r\n");
		expectedOutput = expectedOutput.replace("|", "\r\n");
		provideInput(input);
		Display.createScanner();
		int actualResult = Validation.getHallInput("Preferenced Hall");
		Display.closeScanner();
		assertEquals(expectedResult,actualResult,msg);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testGetAcademicType.csv")
	void testGetAcademicType(String input,String expectedResult, String expectedOutput, String msg) {
		input = input.replace("|", "\r\n");
		expectedOutput = expectedOutput.replace("|", "\r\n");
		provideInput(input);
		Display.createScanner();
		String actualResult = Validation.getAcademicType();
		Display.closeScanner();
		assertEquals(expectedResult,actualResult,msg);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testGetAcademicScore.csv")
	void testGetAcademicScore(String input, String academicType, String expectedResult, String expectedOutput, String msg) {
		input = input.replace("|", "\r\n");
		expectedOutput = expectedOutput.replace("|", "\r\n");
		provideInput(input);
		Display.createScanner();
		String actualResult = Validation.getAcademicScore(academicType);
		Display.closeScanner();
		assertEquals(expectedResult,actualResult,msg);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testGetEcaNLeaderShip.csv")
	void testGetEcaNLeaderShip(String input, String expectedResult, String title, String expectedOutput, String msg) {
		input = input.replace("|", "\r\n");
		expectedOutput = expectedOutput.replace("|", "\r\n");
		provideInput(input);
		Display.createScanner();
		String actualResult = Validation.getEcaNLeaderShip(title);
		Display.closeScanner();
		assertEquals(expectedResult,actualResult,msg);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testGetLocation.csv")
	void testGetLocation(String input, String expectedResult, String expectedOutput, String msg) {
		input = input.replace("|", "\r\n");
		expectedOutput = expectedOutput.replace("|", "\r\n");
		provideInput(input);
		Display.createScanner();
		String actualResult = Validation.getLocation();
		Display.closeScanner();
		assertEquals(expectedResult,actualResult,msg);
		assertEquals(expectedOutput,outputStreamCaptor.toString(),msg);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testValidationHall.csv")
	void testValidationHall(String input, boolean expectedOutput,String msg) {
		
		boolean actualOutput = Validation.validationHall(input);
		
		assertEquals(expectedOutput,actualOutput,msg);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testValidationType.csv")
	void testValidationType(String input, boolean expectedOutput, String msg) {
		
		boolean actualOutput = Validation.validationType(input);
		
		assertEquals(expectedOutput, actualOutput, msg);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testValidationScore.csv")
	void testValidationScore(String input,String type, boolean expectedOutput, String msg) {
		
		boolean actualOutput = Validation.validationScore(input, type);
		
		assertEquals(expectedOutput, actualOutput, msg);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testValidationLocation.csv")
	void testValidationLocation(String input, boolean expectedOutput, String msg) {
		
		boolean actualOutput = Validation.validationLocation(input);
		
		assertEquals(expectedOutput,actualOutput,msg);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testCheckInteger.csv")
	void testCheckInteger(String input, boolean expectedOutput, String msg) {
		
		boolean actualOutput = Validation.checkInteger(input);
		
		assertEquals(expectedOutput,actualOutput,msg);
	} 
	
	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testCheckDouble.csv")
	void testCheckDouble(String input,boolean expectedOutput, String msg) {

		boolean actualOutput = Validation.checkDouble(input);
		
		assertEquals(expectedOutput,actualOutput,msg);
	}

}

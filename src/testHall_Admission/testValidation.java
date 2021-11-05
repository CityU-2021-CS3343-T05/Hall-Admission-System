package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HallAdmissionSystem.Validation;

class testValidation {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetHallInput() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAcademicType() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAcademicScore() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEcaNLeaderShip() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLocation() {
		fail("Not yet implemented");
	}

	@Test
	void testValidationHall() {
		fail("Not yet implemented");
	}

	@Test
	void testValidationType() {
		fail("Not yet implemented");
	}

	@Test
	void testValidationScore() {
		fail("Not yet implemented");
	}

	@Test
	void testValidationLocation() {
		fail("Not yet implemented");
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testCheckInteger.csv")
	void testCheckInteger(String input,boolean expectedOutput, String msg) {
		
		boolean actualOutput = Validation.checkInteger("String");
		
		assertEquals(expectedOutput,actualOutput,msg);
	} 
	
	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testCheckDouble.csv")
	void testCheckDouble(String input,boolean expectedOutput, String msg) {

		boolean actualOutput = Validation.checkDouble("String");
		
		assertEquals(expectedOutput,actualOutput,msg);
	}

}

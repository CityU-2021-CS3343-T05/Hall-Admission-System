package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HallAdmissionSystem.Area_ECA;

class testArea_eca {

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

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testCreateArea_eca.csv")
	void testConvertScore(String input,boolean expectedFail,int expectedResult,String msg) {
		int actualResult = 0;
		boolean actualFail = false;
		try {
			actualResult = Area_ECA.convertScore(input);
		}catch(NumberFormatException e) {
			actualFail = true;
		}
		assertEquals(expectedFail,actualFail,msg);
		if(!expectedFail) {
			assertEquals(expectedResult,actualResult,msg);
		}
	}

}

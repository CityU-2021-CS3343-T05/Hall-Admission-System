package testHall_Admission;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HallAdmissionSystem.*;

class testCreateArea_Academic {

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
	@CsvFileSource(resources = "/testResource/testCreateArea_academic.csv")
	void testCreateAcademic(String inputType,String inputValue,boolean expectedFail, String expectedResult, String msg) {
		Area_Academic actualResult = null;
		boolean expected = false;
		boolean actualFail = false;
		try {
			actualResult = Area_Academic.createArea_Academic(inputType,inputValue);	
		}catch(Ex_WrongExamType e){
			actualFail = true;
		}
		if(!expectedFail) {
			if(expectedResult.equals("T")){
				expected=true;
			}else if(expectedResult.equals("F")){
				expected = false;
			}
			assertEquals(expected,actualResult instanceof Area_DSE);
		}
		
		assertEquals(expectedFail,actualFail);

		
		
		
	}

}

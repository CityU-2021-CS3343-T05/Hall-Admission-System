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
	void testCreateAcademic(String inputType, String inputValue, String expectedResult,int expectedResultValue, String msg) {
		Area_Academic actualResult = null;;
		int actualResultValue = 0;;
		boolean expected = true;
		
		try {
			actualResult = Area_Academic.createArea_Academic(inputType,inputValue);
			actualResultValue = actualResult.getValue();
			expected=true;
			if(expectedResult.equals("T")){
				expected=true;
			}else if(expectedResult.equals("F")){
				expected = false;
			}
			assertEquals(expected,actualResult instanceof Area_DSE);
			assertEquals(expectedResultValue,actualResultValue,msg);
		}catch(Ex_WrongExamType e){
			assertEquals(true, e instanceof Ex_WrongExamType);
		}
		

		
		
		
	}

}

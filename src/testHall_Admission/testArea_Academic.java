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

class testArea_Academic {

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
	void testCreateAcademic1() {
		Area_Academic actualResult = null;
		String msg = "Test input type is DSE";
		
		String inputType = "DSE", inputValue = "5**";
		boolean expectedIsDse=true, expectedIsGpa=false;

		actualResult = Area_Academic.createArea_Academic(inputType,inputValue);	
		
		assertNotNull(actualResult);
		assertEquals(expectedIsDse,actualResult instanceof Area_DSE);
		assertEquals(expectedIsGpa,actualResult instanceof Area_GPA);
	}
	
	@Test
	void testCreateAcademic2() {
		Area_Academic actualResult = null;
		String msg = "Test input type is GPA";
		
		String inputType = "GPA", inputValue = "4.3";
		boolean expectedIsDse=false, expectedIsGpa=true;

		actualResult = Area_Academic.createArea_Academic(inputType,inputValue);	
		
		assertNotNull(actualResult);
		assertEquals(expectedIsDse,actualResult instanceof Area_DSE);
		assertEquals(expectedIsGpa,actualResult instanceof Area_GPA);
	}
	
	@Test
	void testCreateAcademic3() {
		Area_Academic actualResult = null;
		String msg = "Test input type is wrong";
		
		String inputType = "other string", inputValue = "";
		actualResult = Area_Academic.createArea_Academic(inputType,inputValue);	
		
		assertNull(actualResult);
	}


}

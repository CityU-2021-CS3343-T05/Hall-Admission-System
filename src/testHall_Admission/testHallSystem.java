package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HallAdmissionSystem.Hall;
import HallAdmissionSystem.HallSystem;
import HallAdmissionSystem.WeightComponent;

class testHallSystem {
	
	HallSystem actualResult;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		actualResult = HallSystem.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetInstance() {
		String msg = "Test create new Hall System and there are three Hall object in allHallListing";
		
		int expectedHallNumber = 3;
		
		ArrayList<Hall> actualHallList = actualResult.getHallList();
		int actualHallNumber = actualHallList.size();
		
		assertEquals(expectedHallNumber,actualHallNumber,msg);
		
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testResource/testHallSystem_getHall.csv")
	void testGetHall(int input,boolean expectedExist, int expectedHallNumber, String msg) {
		Hall actualHall = actualResult.getHall(input);
		if(expectedExist) {
			assertNotNull(actualHall);
			int actualHallNumber = actualHall.getHallNumber();
			assertEquals(expectedHallNumber,actualHallNumber,msg);
		}else {
			assertNull(actualHall);
		}
		
	}

}

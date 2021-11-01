package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HallAdmissionSystem.LoginPortal;

class testLoginPortal {

	LoginPortal loginPortal;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		loginPortal = LoginPortal.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLogin() {
		fail("Not yet implemented");
	}

}

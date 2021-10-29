package testHall_Admission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import HallAdmissionSystem.*;

class testApplication {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	
	
	@BeforeEach
	void setUp() throws Exception {
		
		HallSystem hS = HallSystem.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testApplication_CompareTo1() {
		
		String msg = "Test std1 has equal score than std2";
		
		Student std1 = new Student("S00001","John","Passw0rd",true,4);
		Student std2 = new Student("S00002","Tom","Passw0rd",true,2);
		
		ScoreComponent sc1 = new ScoreComponent("DSE","5*","5","180","Cheung Chau");
		ScoreComponent sc2 = new ScoreComponent("GPA","4.3","2","300","Kowloon Tong");
		
		Application application1 = new Application(std1,1,sc1);
		Application application2 = new Application(std2,1,sc2);
		
		int expectedResult = 0;
		
		int actualResult = application1.compareTo(application2);
		assertEquals(expectedResult,actualResult,msg);
	}
	
	@Test
	void testApplication_CompareTo2() {

		String msg = "Test std1 has lower score than std2";
		
		Student std1 = new Student("S00001","John","Passw0rd",true,4);
		Student std2 = new Student("S00002","Tom","Passw0rd",true,2);
		
		ScoreComponent sc1 = new ScoreComponent("DSE","1","1","0","Kowloon Tong");
		ScoreComponent sc2 = new ScoreComponent("GPA","4.3","5","300","Cheung Chau");
		
		Application application1 = new Application(std1,1,sc1);
		Application application2 = new Application(std2,1,sc2);
		
		int expectedResult = 0;
		
		int actualResult = application1.compareTo(application2);
		assertEquals(expectedResult,actualResult,msg);
	}
	
	@Test
	void testApplication_CompareTo3() {

		String msg = "Test std1 has lower score than std2";
		
		Student std1 = new Student("S00001","John","Passw0rd",true,4);
		Student std2 = new Student("S00002","Tom","Passw0rd",true,2);
		
		ScoreComponent sc1 = new ScoreComponent("DSE","1","1","0","Kowloon Tong");
		ScoreComponent sc2 = new ScoreComponent("GPA","4.3","5","300","Cheung Chau");
		
		Application application1 = new Application(std1,1,sc2);
		Application application2 = new Application(std2,1,sc1);
		
		int expectedResult = 0;
		
		int actualResult = application1.compareTo(application2);
		assertEquals(expectedResult,actualResult,msg);
	}

	

}

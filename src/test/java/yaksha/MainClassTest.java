package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import java.sql.ResultSet;
import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	void testViewTraineeDetails() throws Exception {
		PICO pico = new PICO();
		Trainee[] t = new Trainee[1];
		String resultData = null;
		String expectedData = null;
		int id;
		String name;
		int age;
		String batch;
		double score;
		int attemptNumber;
		// Input : 101,'Rajesh',21,'First',99.00,1
		id = 101;
		name = "Rajesh";
		age = 21;
		batch = "First";
		score = 99.0;
		attemptNumber = 1;
		t[0] = new Trainee(id, name, age, batch, score, attemptNumber);
		expectedData = id + " " + name + " " + age + " " + batch + " " + score + " " + attemptNumber;
		expectedData = expectedData.trim();
		ResultSet rs = pico.viewTraineeDetails();
		while (rs.next()) {
			int id1 = rs.getInt(1);
			String name1 = rs.getString(2).trim();
			int age1 = rs.getInt(3);
			String batch1 = rs.getString(4).trim();
			double score1 = rs.getDouble(5);
			int attemptNumber1 = rs.getInt(6);
			resultData = id1 + " " + name1 + " " + age1 + " " + batch1 + " " + score1 + " " + attemptNumber1;
			resultData = resultData.trim();
		}
		yakshaAssert(currentTest(), (expectedData.equals(resultData) ? "true" : "false"), businessTestFile);
		rs.close();
	}
}

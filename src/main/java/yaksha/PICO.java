package yaksha;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PICO {
	public ResultSet viewTraineeDetails() throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		con = DB.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from Trainee where id=101");
		return rs;
	}
}

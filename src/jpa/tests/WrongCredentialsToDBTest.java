package jpa.tests;

import java.sql.Connection;
import java.sql.DriverManager;

import org.testng.annotations.Test;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class WrongCredentialsToDBTest {

	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;

	@Test
	public static void test() {
		Exception expectedException = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_casino", "root",
					"WRONG_PASSWORD");
			statement = (Statement) connection.createStatement();
		} catch (Exception exception) {
			expectedException = exception;
			exception.printStackTrace();
		}

		assert expectedException != null;

	}

}

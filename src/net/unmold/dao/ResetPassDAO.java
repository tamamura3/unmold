package net.unmold.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class ResetPassDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public void resetPass(String mail, String token, Timestamp date) {
		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "INSERT INTO reset_pass(mail, token, date) VALUES(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, mail);
			ps.setString(2, token);
			ps.setTimestamp(3, date);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

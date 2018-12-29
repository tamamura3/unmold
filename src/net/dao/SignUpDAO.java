package net.unmold.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

//mailとtokenをregisterに登録する

public class SignUpDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public void setInfo(String name, String mail, String password, String token, Timestamp date) {

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "INSERT INTO register(name, mail, password, token, date) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, mail);
			ps.setString(3, password);
			ps.setString(4, token);
			ps.setTimestamp(5, date);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

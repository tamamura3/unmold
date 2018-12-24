package net.getout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//本登録をするクラス

public class RegisterDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public void registerUser() {


		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "INSERT register(mail, token) VALUES(?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

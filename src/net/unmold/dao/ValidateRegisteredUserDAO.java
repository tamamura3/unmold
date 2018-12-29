package net.unmold.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateRegisteredUserDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public boolean validateRegisteredUser(int userId, String password){
		boolean registered = false;

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT * FROM user WHERE id = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userId);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				registered = true;
			}
					} catch (Exception e) {
			e.printStackTrace();
		}
		return registered;
	}



	public boolean validateRegisteredUserByMail(String mail) {
		boolean registered = false;

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT * FROM user WHERE mail = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, mail);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				registered = true;
			}
					} catch (Exception e) {
			e.printStackTrace();
		}
		return registered;

	}

}

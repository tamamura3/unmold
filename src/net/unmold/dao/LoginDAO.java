package net.unmold.dao;

import java.sql.Connection;
//メアドとパスワードからログインの判定を行う
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public boolean loginValidate(String mail, String password) {
		boolean loginValidation = false;

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM user WHERE (mail = ?) AND (password = ?) AND (is_deleted = 0)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				loginValidation = true;}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginValidation;

	}

}

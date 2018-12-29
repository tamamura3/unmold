package net.unmold.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MailValidate {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public boolean mailAlreadyInUse(String mail) {
		boolean alreadyInUse = false;

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM user WHERE (mail = ?) AND (is_deleted = 0)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				alreadyInUse = true;}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alreadyInUse;

	}

}

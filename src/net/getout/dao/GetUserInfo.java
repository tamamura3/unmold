package net.getout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.getout.beans.User;

public class GetUserInfo {


	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public User GetUser(String mail, String password) {
		User returnUser = null;

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM user WHERE (mail = ?) AND (password = ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			User user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("mail"),rs.getString("password"));
			returnUser = user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnUser;
	}


}

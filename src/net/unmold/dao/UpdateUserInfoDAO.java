package net.unmold.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateUserInfoDAO {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

//	メールアドレス変更メソッド
	public void updateMail(int userId, String password, String mail) {
		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "UPDATE user SET mail = ? WHERE id = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setInt(2, userId);
			ps.setString(3, password);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	パスワード変更メソッド
	public void updatePassword(int userId, String currentPassword, String newPassword) {
		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "UPDATE user SET password = ? WHERE id = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userId);
			ps.setString(3, currentPassword);
			ps.executeUpdate();

			//flagを1に変更
			String sql2 = "UPDATE user SET flag = 1 WHERE id = ? AND password = ?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, userId);
			ps2.setString(2, newPassword);
			ps2.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

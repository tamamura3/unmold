package net.unmold.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetMailByTokenDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public String getMailByTokenDAO(String token) {
		String mail = "";
		try {
			//DBに接続してtokenと一致するデータを取得
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM reset_pass WHERE token = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, token);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
			mail = rs.getString("mail");
			}
			System.out.println(mail);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mail;
	}

}

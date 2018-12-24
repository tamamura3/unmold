package net.getout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//reviewテーブルに値をセットする

public class InsertReviewDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public void insertReview(int userId, int challengeId, String reviewText) {

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "INSERT INTO review (user_id, challenge_id, review_text) VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, challengeId);
			ps.setString(3, reviewText);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

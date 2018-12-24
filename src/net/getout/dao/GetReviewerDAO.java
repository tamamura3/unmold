package net.getout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetReviewerDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	//もう必要ないかも

	public String getReviewer(int reviewId) {
		String returnName = "";

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT * FROM review JOIN user ON review.user_id = user.id WHERE review.challenge_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reviewId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				returnName = name;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnName;
	}

}

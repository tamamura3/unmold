package net.unmold.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RemoveAchievementDAO {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	/*
	 呼び出し　RemoveAchievement.java
	 userID とchallengeIdを受け取り、一致するデータをachievementテーブルから削除する
	  */

	public void removeAchievement(int userId, int challengeId) {
		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "DELETE from achievement where user_id = ? AND challenge_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, challengeId);
			ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}

	}
}

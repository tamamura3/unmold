package net.getout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//ユーザーIDとチャレンジIDを引数に受け取り、DBのachievementに格納する

public class AchievementDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

//ahievementとして登録済みか確認するクラスだが現在は不要
//と思いきや登録もしている！？登録はAddAchievementがあるのでなぜここで？エラーの原因だったかも。とりあえずこのまま保存

	public boolean validateAdd(int userId, int challengeId) {
		boolean alreadyAdded = false;

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT * from achievement WHERE user_id = ? AND challenge_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, challengeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				alreadyAdded = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return alreadyAdded;
	}
}

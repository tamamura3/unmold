package net.getout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.getout.beans.Achievement;

public class GetAchievementListDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public List<Achievement> getAchievementList(int userId){

		ArrayList<Achievement> achievementList = new ArrayList<Achievement>();

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM achievement WHERE user_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			Achievement achievement = new Achievement(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("challenge_id"));
			achievementList.add(achievement);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achievementList;


	}

}

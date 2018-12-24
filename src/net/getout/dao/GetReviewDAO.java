package net.getout.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.getout.beans.Reviews;

public class GetReviewDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public ArrayList<Reviews> getReview(int challengeNumber) {
		ArrayList<Reviews> reviewList = new ArrayList<Reviews>();

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			//レビューの内容、レビュワーのidをゲット
			String sql = "SELECT * FROM review WHERE challenge_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, challengeNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//レビュワーの名前をゲット
				String sql2 = "SELECT user.name FROM user JOIN review ON review.user_id = user.id WHERE (review.challenge_id = ?) AND (user.is_deleted = 0)";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, challengeNumber);
				ResultSet rs2 = ps2.executeQuery();
				//リストに加えていく
				if (rs2.next()) {
					Reviews review = new Reviews(rs.getInt("id"), rs.getInt("challenge_id"), rs.getInt("user_id"),
							rs.getString("review_text"), rs2.getString("name"));
					reviewList.add(review);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewList;
	}

	public boolean haveReviewedBefore(int userId, int challengeId) {
		boolean result = false;

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM review WHERE user_id = ? AND challenge_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, challengeId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Reviews getSingleReview(int userId, int challengeId) {
		Reviews review = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM review WHERE user_id = ? AND challenge_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, challengeId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				review = new Reviews(rs.getInt("id"), rs.getString("review_text"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return review;
	}

}

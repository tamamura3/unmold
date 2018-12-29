package net.unmold.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.unmold.beans.Challenge;

public class GetChallengeListDAO {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost/overflowing";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "mysql";

	public List<Challenge> getChallengeList(int challengeId){

		ArrayList<Challenge> challengeList = new ArrayList<Challenge>();

		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			String sql = "SELECT * FROM challenge WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, challengeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			Challenge challenge = new Challenge(rs.getInt("id"),rs.getString("challenge_name"),rs.getString("description"));
			challengeList.add(challenge);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return challengeList;


	}

}

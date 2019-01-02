package net.unmold.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.unmold.beans.Challenge;

public class BeforeIndexDAO {

	public List<Challenge> getChallenge() {
		System.out.println("in beforeindexDAO");

		List<Challenge> list = new ArrayList<Challenge>();
		Driver driver = new Driver();

		try {
			Connection con = driver.getConnection();
			String sql = "SELECT * FROM public.t_challenge";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Challenge singleChallenge = new Challenge();
				singleChallenge.setChallenge(rs.getInt("id"), rs.getString("challenge_name"),
						rs.getString("description"));
				list.add(singleChallenge);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
